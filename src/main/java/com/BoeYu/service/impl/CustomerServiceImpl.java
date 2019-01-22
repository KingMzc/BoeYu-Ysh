package com.BoeYu.service.impl;

import com.BoeYu.mapper.*;
import com.BoeYu.pojo.*;
import com.BoeYu.service.CustomerService;
import com.BoeYu.util.DateUtil;
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
    @Autowired
    private VipMapper vipMapper;
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private ApplicationTimesMapper applicationTimesMapper;
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
        if(search.getPhone()!=null&&!"".equals(search.getPhone())){
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andPhoneLike("%"+search.getPhone()+"%");
        }
        if(search.getPartnerId()!=null&&!"".equals(search.getPartnerId())){
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andPartnerIdEqualTo(search.getPartnerId());
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

        for(int i=0;i<customer.size();i++){
            if(customerMapper.GetMoney(customer.get(i).getPhone())==null||customerMapper.GetMoney(customer.get(i).getPhone()).equals("")){
                customer.get(i).setMoney("0");
            }else{
                customer.get(i).setMoney(customerMapper.GetMoney(customer.get(i).getPhone()));
            }
        }
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(customer);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setMsg("哈哈哈");
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public Customer selCustomerById(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> loginInfo(String phone, String wxid) {
        Map<String, Object> map =new HashMap<String, Object>();
        Customer customer =customerMapper.selectByLogin(phone);
        if (customer==null){
            map.put("customer",0);
            return map;
        }
        String token= DigestUtils.md5DigestAsHex((new Date().getTime()+""+phone).getBytes());
        customer.setToken(token);
        if(customer.getVipTime()==null){
            customer.setVip("0");
            customerMapper.updateVip(customer);
        }else{
            if(customer.getVipTime().compareTo(new Date())<0){
                customer.setVip("0");
                customerMapper.updateVip(customer);
            }
        }
        customerMapper.updateToken(customer);
        map.put("customer",customer);
        map.put("token",token);
        if(customer.getFkFamilyId()==null){
            map.put("flag","0");
        }else{
            map.put("flag",familyMapper.selectflag(customer.getPhone(),customer.getFkFamilyId()));
        }
        return map;
    }

    @Override
    public int addCustomer(Customer customer) {
        return customerMapper.insert(customer);
    }

    @Override
    public int selectPhone(String phone) {
        return customerMapper.selectPhone(phone);
    }
    @Override
    public int selectPhonewx(String phone,String wxid) {
        return customerMapper.selectPhonewx(phone,wxid);
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
    public Customer GetCustomerByPhone(String phone) {
        return customerMapper.GetCustomerByPhone(phone);
    }

    @Override
    public List<Child> GetChild(String CustomerID) {
        List<String> childlist = familyMapper.GetchildId(CustomerID);
        List<Child> list =new ArrayList<Child>();
        for (int i=0;i<childlist.size();i++){
            list.add(childMapper.GetChildByAndroid(childlist.get(i)));
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
    public int updateVip(Customer customer) {
        return customerMapper.updateVip(customer);
    }

    @Override
    public int updateWxid(String phone,String wxid) {
        return customerMapper.updateWxid(phone,wxid);
    }

    @Override
    public int updatepassword(Customer customer) {
        return customerMapper.updatepassword(customer);
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

    @Override
    public int updateVipTime(Customer customer) {
        return customerMapper.updateVipTime(customer);
    }

    @Override
    public List<Vip> GetVipList() {
        return vipMapper.selectByExample(new VipExample());
    }

    @Override
    public Vip selectByPrimaryKey(Integer id) {
        return vipMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addFeedback(Feedback feedback) {
        return feedbackMapper.insert(feedback);
    }

    @Override
    public int updateLockTime(Application application) {
        return applicationMapper.updateLockTime(application);
    }

    @Override
    public int updateAppType(Application application) {
        return applicationMapper.updateAppType(application);
    }

    @Override
    public int updateLockApp(Application application) {
        return applicationMapper.updateLockApp(application);
    }

    @Override
    public List<Application> selectApplication(String android) {
        return applicationMapper.selectApplicationtype(android);
    }

    @Override
    public List<ApplicationTime> selectApplicationTime(String android) {
         String week= DateUtil.week();
         return applicationMapper.selectApplicationTime(android,week);
    }

    @Override
    public List<ApplicationTime> selectApplicationTimes(String android) {
        return applicationMapper.selApplicationTimes(android);
    }

    @Override
    public List<ApplicationTime> selectAppListTimes(String android) {
        String week = DateUtil.week();
        return applicationMapper.selectApplicationTime(android,week);
    }

    @Override
    public List<ApplicationTimes> selApplicationTimes(String id) {
        return applicationTimesMapper.selApplicationTimes(id);
    }

    @Override
    public List<Application> selectApplicationTimeStart(String android) {
        return applicationMapper.selectApplicationTimeStart(android);
    }

    @Override
    public List<AppRecordt> selectApplicationRecord(String android) {
        return applicationMapper.selectApplicationRecord(android);
    }

    @Override
    public String Getpassword(String phone) {
        return customerMapper.Getpassword(phone);
    }

    @Override
    public int addInvitation(Family family) {
        return familyMapper.insert(family);
    }

    @Override
    public int updateflag(String cusid, String childid, String flag) {
        return familyMapper.updateflag(cusid,childid,flag);
    }


}
