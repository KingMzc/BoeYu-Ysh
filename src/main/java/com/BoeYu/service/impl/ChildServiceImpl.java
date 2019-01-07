package com.BoeYu.service.impl;


import com.BoeYu.mapper.*;
import com.BoeYu.pojo.*;
import com.BoeYu.service.ChildService;
import com.BoeYu.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChildServiceImpl implements ChildService {
    @Autowired
    private ChildMapper childMapper;
    @Autowired
    private CoordinateMapper coordinateMapper;
    @Autowired
    private ConfidantnumberMapper confidantnumberMapper;
    @Autowired
    private FamilyMapper familyMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private ChatMapper chatMapper;
    @Autowired
    private TimesMapper timesMapper;
    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private ApplicationRecordMapper applicationRecordMapper;
    @Override
    public Map<String,Object> GetChild(String android){
        Map<String, Object> map =new HashMap<String, Object>();
        Child child =childMapper.GetChildByAndroid(android);
        map.put("child",child);
        return map;
    }

    @Override
    public int CheckChild(String phone) {
        return childMapper.CheckChildByPhone(phone);
    }

    @Override
    public int CheckToken(String token) {
        return childMapper.CheckChildByToken(token);
    }

    @Override
    public Child GetChildByAndroid(String android) {

        return childMapper.GetChildByAndroid(android);
    }

    @Override
    public int updateName(Child child) {
        return childMapper.updateName(child);
    }

    @Override
    public int updateSex(Child child) {
        return childMapper.updateSex(child);
    }

    @Override
    public int updateYears(Child child) {
        return childMapper.updateYears(child);
    }

    @Override
    public int updateGrade(Child child) {
        return childMapper.updateGrade(child);}

    @Override
    public int updateType(Child child) {
        return childMapper.updateType(child);}

    @Override
    public int updateFlag(String id ,String flag) {
        return childMapper.updateFlag(id,flag);
    }

    @Override
    public Child selectByPrimaryKey(Integer id) {
        return childMapper.selectByPrimaryKey(id);
    }

    @Override
    public Child selectByAndroid(String android) {
        return childMapper.selectByAndroid(android);
    }

    @Override
    public int insertCoordinate(Child child, String coordinate) {
        Coordinate coordinate1 = new Coordinate();
        Date date = new Date();
        coordinate1.setCoordinate(coordinate);
        coordinate1.setCreatetime(date);
        coordinate1.setFkChildId(child.getAndroid());
        coordinate1.setFalg("0");
        return coordinateMapper.insert(coordinate1);
    }

    @Override
    public List<Confidantnumber> SelectConfidantnumber(String ChildId) {
        return confidantnumberMapper.selectConfidantnumber(ChildId);
    }

    @Override
    public int selectChildBinding(String android) {
        return familyMapper.selectChildBinding(android);
    }
    @Override
    public int addChild(Child child) {
        int flag=0;
        if(childMapper.CheckChild(child.getAndroid())>0){
            return 3;
        }
        if(childMapper.CheckCustomerBinding(child.getFkCustomerId())>=2){
            return 2;
        }
        if(childMapper.insert(child)>0){
            Family family = new Family();
            family.setFkChildId(child.getAndroid());
            family.setFkCustomerId(child.getFkCustomerId());
            family.setCreateTime(new Date());
            if(familyMapper.insert(family)>0){
                Customer customer =new Customer();
                customer.setPhone(child.getFkCustomerId());
                customer.setFkFamilyId(child.getAndroid());
                 if(customerMapper.updateChild(customer)<=0){
                     flag=1;
                 }
            }else{
                flag=1;
            }
        }else{
            flag=1;
        }
        return flag;
    }

    @Override
    public int deleteChild(Child child) {
        int flag=0;
        if(childMapper.deleteChild(child.getAndroid())>0){
            confidantnumberMapper.deleteChild(child.getAndroid());
            coordinateMapper.deleteChild(child.getAndroid());
            chatMapper.deleteChild(child.getAndroid());
            familyMapper.deletechild(child.getAndroid());
            timesMapper.deletechild(child.getAndroid());
        }else{
            flag=1;
        }
        return flag;
    }

    @Override
    public int addApplication(Application application) {
        return applicationMapper.insert(application);
    }

    @Override
    public int selectApplication(String android, String applicationId) {
        return applicationMapper.selectApplication(android,applicationId);
    }

    @Override
    public int updateApplication(Application application) {
        return applicationMapper.updateApplication(application);
    }

    @Override
    public int deleteApplication(String android, String applicationId) {
        return applicationMapper.deleteApplication(android,applicationId);
    }

    @Override
    public int addApplicationRecord(String applicationId, String time, String recordTime) {
        ApplicationRecord applicationRecord =new ApplicationRecord();
        applicationRecord.setFkApplicationId(applicationId);
        applicationRecord.setTime(time);
        applicationRecord.setRecordTime(new Date(new Long(recordTime)));
        return applicationRecordMapper.insert(applicationRecord);
    }
}
