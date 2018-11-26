package com.BoeYu.service;

import com.BoeYu.pojo.Times;
import org.omg.CORBA.Object;

import java.util.List;
import java.util.Map;

public interface TimeService {
    int addTime(String starte,String end,String times,String childId,String week,String type,String flag);

    int updateTime(long id,String starte,String end,String times,String childId,String week,String type,String flag);

    int CheckWeek(String childId,String week);

    Times GetTimes(String childId,String week);

    Map<String, List<Times>> GetLockTime(String childId,String type);

    Map<String,String> GetEyeRemindTime(String childId);

    String ShowLockTime(String childId,String week,String type,String flag);

    int addRemindTime(String childId,String remindtime,String resttime);

    int CheckRemindTime(String childId);

    int updateRemindTime(long id,String remindtime,String resttime);

    Times GetRemindTime(String childId);
}
