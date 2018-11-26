package com.BoeYu.service.impl;


import com.BoeYu.mapper.ChildMapper;
import com.BoeYu.mapper.ConfidantnumberMapper;
import com.BoeYu.mapper.CoordinateMapper;
import com.BoeYu.pojo.Child;
import com.BoeYu.pojo.Confidantnumber;
import com.BoeYu.pojo.Coordinate;
import com.BoeYu.service.ChildService;
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
    @Override
    public Map<String,Object> GetChild(String android){
        Map<String, Object> map =new HashMap<String, Object>();
        Child child =childMapper.GetChildByAndroid(android);
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
    public int updateSex(Child child) {
        return childMapper.updateSex(child);
    }

    @Override
    public int updateYears(Child child) {
        return childMapper.updateYears(child);
    }

    @Override
    public int updateFlag(Integer id ,String flag) {
        return childMapper.updateFlag(id,flag);
    }

    @Override
    public Child selectByPrimaryKey(Integer id) {
        return childMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertCoordinate(Child child, String coordinate) {
        Coordinate coordinate1 = new Coordinate();
        Date date = new Date();
        coordinate1.setCoordinate(coordinate);
        coordinate1.setCreatetime(date);
        coordinate1.setFkChildId(child.getId().toString());
        coordinate1.setFalg("0");
        return coordinateMapper.insert(coordinate1);
    }

    @Override
    public List<Confidantnumber> SelectConfidantnumber(String ChildId) {
        return confidantnumberMapper.selectConfidantnumber(ChildId);
    }
}
