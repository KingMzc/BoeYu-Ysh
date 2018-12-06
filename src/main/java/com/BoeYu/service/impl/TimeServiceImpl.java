package com.BoeYu.service.impl;

import com.BoeYu.mapper.TimesMapper;
import com.BoeYu.pojo.Times;
import com.BoeYu.service.TimeService;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


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
    public Map<String,String> GetEyeRemindTime(String childId) {
        List<Times> list = timesMapper.GetEyeRemindTime(childId);
        Map<String,String> map = new HashMap<String,String>();
        if(list.size()>0){
            map.put("RemindTime",list.get(0).getStartetime());
            map.put("RestTime",list.get(0).getEndtime());
        }
        return map;
    }

    @Override
    public String ShowLockTime(String childId, String week, String type, String flag) {
        return timesMapper.ShowLockTime(childId,week,type,flag);
    }

    @Override
    public int addRemindTime(String childId,String remindtime, String resttime) {
        Times times = new Times();
        Date date = new Date();
        times.setFkChildId(childId);
        times.setTimes(remindtime+","+resttime);
        times.setStartetime(remindtime);
        times.setEndtime(resttime);
        times.setWeek("0");
        times.setType("3");
        times.setFlag("REMIND");
        times.setCreateTime(date);
        return timesMapper.insert(times);
    }

    @Override
    public int CheckRemindTime(String childId) {
        return timesMapper.CheckCheckRemindTime(childId);
    }

    @Override
    public int updateRemindTime(long id, String remindtime, String resttime) {
        Times times = new Times();
        times.setTimes(remindtime+","+resttime);
        times.setStartetime(remindtime);
        times.setEndtime(resttime);
        times.setId((int) id);
        return timesMapper.updateRemindTime(times);
    }

    @Override
    public Times GetRemindTime(String childId) {
        return timesMapper.GetRemindTime(childId);
    }
}
