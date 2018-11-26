package com.BoeYu.service.impl;

import com.BoeYu.mapper.*;
import com.BoeYu.pojo.*;
import com.BoeYu.service.CustomerService;
import com.BoeYu.util.MyUtil;
import com.BoeYu.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.websocket.server.ServerEndpointConfig;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private ChildMapper childMapper;
    @Autowired
    private FamilyMapper familyMapper;
    @Autowired
    private CoordinateMapper coordinateMapper;
    @Autowired
    private ConfidantnumberMapper confidantnumberMapper;

    @Override
    public ResultUtil selCustomer(Integer page, Integer limit, UserSearch search) {
        PageHelper.startPage(page, limit);
        //TbUsersExample example=new TbUsersExample();
        CustomerExample example =new CustomerExample();
        //设置按创建时间降序排序
        example.setOrderByClause("create_time DESC");
        //TbUsersExample.Criteria criteria = example.createCriteria();
        CustomerExample.Criteria criteria = example.createCriteria();
        if(search.getNickname()!=null&&!"".equals(search.getNickname())){
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andNicknameLike("%"+search.getNickname()+"%");
        }
        if(search.getSex()!=null&&!"-1".equals(search.getSex())){
            criteria.andSexEqualTo(search.getSex());
        }
        if(search.getStatus()!=null&&!"-1".equals(search.getStatus())){
            criteria.andStatusEqualTo(search.getStatus());
        }
        if(search.getVip()!=null&&!"-1".equals(search.getVip())){
            criteria.andVipEqualTo(search.getVip());
        }
        if(search.getCreateTimeStart()!=null&&!"".equals(search.getCreateTimeStart())){
            criteria.andCreateTimeGreaterThanOrEqualTo(MyUtil.getDateByString(search.getCreateTimeStart()));
        }
        if(search.getCreateTimeEnd()!=null&&!"".equals(search.getCreateTimeEnd())){
            criteria.andCreateTimeLessThanOrEqualTo(MyUtil.getDateByString(search.getCreateTimeEnd()));
        }

        List<Customer> customer = customerMapper.selectByExample(example);
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(customer);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public Customer selCustomerById(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> loginInfo(String phone, String wxid, String mm) {
        Map<String, Object> map =new HashMap<String, Object>();
        Customer customer =customerMapper.selectByLogin(phone,wxid,mm);
        if (customer==null){
            map.put("customer",0);
            return map;
        }
         /*= familyMapper.selectByExample()*/
        /*List<Child> list = childMapper.selectByCustomerId(customer.getId().toString());*/
        String token= DigestUtils.md5DigestAsHex((new Date().getTime()+""+phone+wxid).getBytes());
        customer.setToken(token);
        customerMapper.updateToken(customer);
        map.put("customer",customer);
        /*map.put("ChildList",list);*/
        map.put("token",token);
        return map;
    }

    @Override
    public int selectPhone(String phone) {
        return customerMapper.selectPhone(phone);
    }

    @Override
    public int selectToken(String token) {
        return customerMapper.selectToken(token);
    }

    @Override
    public Customer GetCustomerByToken(String token) {
        return customerMapper.GetCustomerByToken(token);
    }

    @Override
    public List<Child> GetChild(String CustomerID) {
        List<String> childlist = familyMapper.GetchildId(CustomerID);
        List<Child> list =new ArrayList<Child>();
        for (int i=0;i<childlist.size();i++){
            list.add(childMapper.selectByPrimaryKey(Integer.valueOf(childlist.get(i))));
        }
        return list;
    }

    @Override
    public int updateChild(Customer customer) {
        return customerMapper.updateChild(customer);
    }

    @Override
    public int updateName(Customer customer) {

        return customerMapper.updateName(customer);
    }

    @Override
    public int CheckChild(String childId) {
        return childMapper.CheckChild(childId);
    }

    @Override
    public int CheckChildIsCustomer(String CustomerId, String ChildId) {
        return familyMapper.CheckChildIsCustomer(CustomerId,ChildId);
    }

    @Override
    public int LockChild(Child child) {
        return childMapper.LockChild(child);
    }

    @Override
    public List<String> getcoordinate(String childId, String date,String datee) {
        return coordinateMapper.GetCoordinate(childId,date,datee);
    }

    @Override
    public int addConfidantnumber(String childId, String name, String phone) {
        Confidantnumber confidantnumber =new Confidantnumber();
        confidantnumber.setFkChildId(childId);
        confidantnumber.setName(name);
        confidantnumber.setPhone(phone);
        return confidantnumberMapper.insert(confidantnumber);
    }

    @Override
    public int CheckPhone(String childId, String phone) {
        return confidantnumberMapper.CheckPhone(childId,phone);
    }

    @Override
    public int updateConfidantnumber(String id, String name, String phone) {
        Confidantnumber confidantnumber =new Confidantnumber();
        confidantnumber.setId(Integer.valueOf(id));
        confidantnumber.setName(name);
        confidantnumber.setPhone(phone);
        return confidantnumberMapper.updateById(confidantnumber);
    }
}
