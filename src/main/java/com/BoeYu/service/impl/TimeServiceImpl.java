package com.BoeYu.service.impl;

import com.BoeYu.mapper.TimesMapper;
import com.BoeYu.pojo.Times;
import com.BoeYu.service.TimeService;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TimeServiceImpl implements TimeService {
    @Autowired
    private TimesMapper timesMapper;
    @Override
    public int addTime(String starte, String end, String time, String childId, String week, String type, String flag) {
        Times times = new Times();
        Date date = new Date();
        times.setWeek(week);
        times.setType(type);
        times.setFkChildId(childId);
        times.setEndtime(end);
        times.setStartetime(starte);
        times.setFlag(flag);
        times.setTimes(time);
        times.setCreateTime(date);
        return timesMapper.insert(times);
    }

    @Override
    public int updateTime(long id, String starte, String end, String time, String childId, String week, String type, String flag) {
        Times times = new Times();
        times.setWeek(week);
        times.setType(type);
        times.setFkChildId(childId);
        times.setEndtime(end);
        times.setStartetime(starte);
        times.setFlag(flag);
        times.setTimes(time);
        times.setId((int) id);
        return timesMapper.updateByPrimaryKey(times);
    }


    @Override
    public int CheckWeek(String childId, String week) {
        return timesMapper.CheckWeek(childId,week);
    }

    @Override
    public Times GetTimes(String childId, String week) {
        return timesMapper.GetTimes(childId,week);
    }

    @Override
    public Map<String, List<Times>> GetLockTime(String childId,String type) {
        Map<String,List<Times>> map = new HashMap<String,List<Times>>();
        for(int i=1;i<8;i++){
            List<Times> list = timesMapper.GetLockTime(childId,String.valueOf(i),type);
            map.put(String.valueOf(i), list);
        }

        return map;
    }

    @Override
    public String ShowLockTime(String childId, String week, String type, String flag) {
        return null;
    }
}
