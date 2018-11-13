package com.BoeYu.service.impl;

import com.BoeYu.mapper.ChildMapper;
import com.BoeYu.mapper.CustomerMapper;
import com.BoeYu.mapper.FamilyMapper;
import com.BoeYu.pojo.*;
import com.BoeYu.service.CustomerService;
import com.BoeYu.util.MyUtil;
import com.BoeYu.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import sun.security.provider.MD5;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private ChildMapper childMapper;
    @Autowired
    private FamilyMapper familyMapper;

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
        String token= DigestUtils.md5DigestAsHex((new Date().getTime()+""+phone+wxid).getBytes());
        map.put("customer",customer);
        map.put("token",token);
        return map;
    }
}
