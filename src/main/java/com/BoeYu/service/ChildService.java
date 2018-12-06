package com.BoeYu.service;

import com.BoeYu.pojo.Child;
import com.BoeYu.pojo.Confidantnumber;

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

    int updateFlag(Integer id ,String flag);

    Child selectByPrimaryKey(Integer id);

    Child selectByAndroid(String android);

    int insertCoordinate(Child child, String coordinate);

    List<Confidantnumber> SelectConfidantnumber(String ChildId);

    int selectChildBinding(String android);

    int addChild(Child child);

}
