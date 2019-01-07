package com.BoeYu.service.impl;

import com.BoeYu.mapper.ApplicationTimesMapper;
import com.BoeYu.mapper.RegionMapper;
import com.BoeYu.mapper.RegionTimeMapper;
import com.BoeYu.mapper.TimesMapper;
import com.BoeYu.pojo.ApplicationTimes;
import com.BoeYu.pojo.Region;
import com.BoeYu.pojo.RegionTimes;
import com.BoeYu.pojo.Times;
import com.BoeYu.service.TimeService;
import com.BoeYu.util.DateUtil;
import com.BoeYu.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TimeServiceImpl implements TimeService {
    @Autowired
    private TimesMapper timesMapper;
    @Autowired
    private ApplicationTimesMapper applicationTimesMapper;
    @Autowired
    private RegionMapper regionMapper;
    @Autowired
    private RegionTimeMapper regionTimeMapper;
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
            map.put("type",list.get(0).getFlag());
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
        times.setFlag("0");
        times.setCreateTime(date);
        return timesMapper.insert(times);
    }

    @Override
    public int CheckRemindTime(String childId) {
        return timesMapper.CheckCheckRemindTime(childId);
    }

    @Override
    public int updateRemindTime(long id, String remindtime, String resttime,String type) {
        Times times = new Times();
        times.setTimes(remindtime+","+resttime);
        times.setStartetime(remindtime);
        times.setEndtime(resttime);
        times.setFlag(type);
        times.setId((int) id);
        return timesMapper.updateRemindTime(times);
    }

    @Override
    public Times GetRemindTime(String childId) {
        return timesMapper.GetRemindTime(childId);
    }

    @Override
    public int deleteRemindTime(String childId) {
        return timesMapper.deleteRemindTime(childId);
    }

    @Override
    public int addRegionTime(String childId,String meter,String startTime, String endTime,String week,String name) {
        Times times = new Times();
        times.setStartetime(startTime);
        times.setEndtime(endTime);
        times.setFkChildId(childId);
        times.setWeek(week);
        times.setType("4");
        times.setFlag(name);
        times.setTimes(meter);
        times.setCreateTime(new Date());
        return timesMapper.insert(times);
    }

    @Override
    public int updateRegionTime( String childId,String meter,String startTime,String endTime,String week,String name,String timeId) {
        Times times = new Times();
        times.setId(Integer.valueOf(timeId));
        times.setStartetime(startTime);
        times.setEndtime(endTime);
        times.setFlag(name);
        times.setTimes(meter);
        return 0;
    }

    @Override
    public int CheckRegion(String android, String coordinate){
        String week = "";
        int flag=0;
        String Regioncoordinate = "";
        String mater="";
        int hav=0;
        try {
             week = DateUtil.dateToWeekday(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<RegionTimes> list =regionMapper.selectRegionBychildId(android,week);
        String nowtime=DateUtil.datehms(new Date());
        for (int i=0;i<list.size();i++){
            if (list.get(i).getStarttime().equals("")||list.get(i).getEndtime().equals("")){
            }else{
                String starttime = list.get(i).getStarttime()+":00";
                String endtime = list.get(i).getEndtime()+":00";
                if(DateUtil.compTime(nowtime,starttime)==true&&DateUtil.compTime(endtime,nowtime)==true){
                    Regioncoordinate=list.get(i).getCoordinate();
                    mater=list.get(i).getMater();
                    hav++;
                }
                break;
            }
        }
        if (hav>0){
            String [] coordinateyzb = coordinate.split(",");
            String [] coordinateezb = Regioncoordinate.split(",");
            if (coordinateyzb[0].length()==coordinateezb[0].length()&&coordinateyzb[1].length()==coordinateezb[1].length()){
                double jlmater = MapUtil.getDistance(
                        Double.parseDouble(coordinateyzb[0]),
                        Double.parseDouble(coordinateyzb[1]),
                        Double.parseDouble(coordinateezb[0]),
                        Double.parseDouble(coordinateezb[1]));
                if (Integer.valueOf(mater)<jlmater){
                    System.out.println("孩子已经跑了~~报警开始~~~~~~~");
                    flag=1;
                }
            }
        }
        //旧方法
        /*int flag=0;

        int hour=0;*/
        /*String mater="";
        String Regioncoordinate = "";
        int hav=0;
        try {
            week= DateUtil.dateToWeekday(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            hour = DateUtil.datehour(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Times> time=timesMapper.CheckRegion(android,week);
        List<Times> times = new ArrayList<Times>();
        if(time.size()>0){
            for(int i =0;i<time.size();i++){

            }
            if(times.size()>0){
                for(int i =0;i<times.size();i++){
                    if(Integer.valueOf(times.get(i).getStartetime())<=hour && Integer.valueOf(times.get(i).getEndtime())>hour){
                        String [] materandcoordinate = times.get(i).getTimes().split("-");
                        mater=materandcoordinate[0];
                        Regioncoordinate=materandcoordinate[1];
                        hav=1;
                        break;
                    }
                }
                if (hav>0){
                    String [] coordinateyzb = coordinate.split(",");
                    String [] coordinateezb = Regioncoordinate.split(",");
                    double jlmater = MapUtil.getDistance(
                            Double.parseDouble(coordinateyzb[0]),
                            Double.parseDouble(coordinateyzb[1]),
                            Double.parseDouble(coordinateezb[0]),
                            Double.parseDouble(coordinateezb[1]));
                    if (Integer.valueOf(mater)<jlmater){
                        System.out.println("孩子已经跑了~~报警开始~~~~~~~");
                        flag=1;
                    }
                }
            }
        }*/
        return flag;
    }

    @Override
    public List<Times> GetRegionTime(String childId) {
        return timesMapper.GetRegionTime(childId);
    }

    @Override
    public int deleteRegionTime(String timeId) {
        return timesMapper.deleteByPrimaryKey(Integer.valueOf(timeId));
    }

    @Override
    public int selectAppLockTime(String childId, String week) {
        return applicationTimesMapper.selectAppLockTime(childId,week);
    }

    @Override
    public int updateAppLockTime(ApplicationTimes applicationTimes) {
        return applicationTimesMapper.updateAppLockTime(applicationTimes);
    }

    @Override
    public int addAppLockTime(ApplicationTimes applicationTimes) {
        return applicationTimesMapper.insert(applicationTimes);
    }

    @Override
    public List<ApplicationTimes> ShowLockTimep(String childId) {
        return applicationTimesMapper.ShowLockTimep(childId);
    }

    @Override
    public List<ApplicationTimes> ShowLockTimeChild(String childId,String week) {
        return applicationTimesMapper.ShowLockTimeChild(childId,week);
    }

    @Override
    public int updateAppLockTimeFlag(String childId, String flag) {
        return applicationTimesMapper.updateAppLockTimeFlag(childId,flag);
    }
}
