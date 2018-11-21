package com.BoeYu.service;

import com.BoeYu.pojo.Child;

import java.util.Map;

public interface ChildService {

    Map<String,Object> GetChild(String android);

    int CheckChild(String phone);

    int CheckToken(String token);

    Child GetChildByAndroid(String android);

    int updateSex(Child child);

    int updateYears(Child child);

    Child selectByPrimaryKey(Integer id);



}
