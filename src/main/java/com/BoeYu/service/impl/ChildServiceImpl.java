package com.BoeYu.service.impl;


import com.BoeYu.mapper.ChildMapper;
import com.BoeYu.pojo.Child;
import com.BoeYu.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChildServiceImpl implements ChildService {
    @Autowired
    private ChildMapper childMapper;
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
    public Child selectByPrimaryKey(Integer id) {
        return childMapper.selectByPrimaryKey(id);
    }
}
