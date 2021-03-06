package com.BoeYu.service;

import com.BoeYu.pojo.*;
import com.BoeYu.util.ResultUtil;

import java.util.List;
import java.util.Map;

public interface ChildService {

    Map<String,Object> GetChild(String android);

    int CheckChild(String phone);

    int CheckToken(String token);

    Child GetChildByAndroid(String android);

    int updateName(Child child);

    int updateSex(Child child);

    int updateYears(Child child);

    int updateGrade(Child child);

    int updateType(Child child);

    int updateFlag(String id ,String flag);

    Child selectByPrimaryKey(Integer id);

    Child selectByAndroid(String android);

    int insertCoordinate(Child child, String coordinate);

    List<Confidantnumber> SelectConfidantnumber(String ChildId);

    int selectChildBinding(String android);

    int addChild(Child child);

    int deleteChild(Child child);

    int addApplication(Application application);

    int selectApplication(String android,String applicationId);

    int updateApplication(Application application);

    int deleteApplication(String android,String applicationId);

    int addApplicationRecord(String applicationId,String time,String recordTime);

    ResultUtil selChild(Integer page, Integer limit, ChildSearch search);

    int updateDevname(String android,String devname);

    int updatePhone(String android,String phone);

    int updateElectric(String android,String electric);

}
