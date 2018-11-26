package com.BoeYu.mapper;

import com.BoeYu.pojo.Times;
import com.BoeYu.pojo.TimesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TimesMapper {
    long countByExample(TimesExample example);

    int deleteByExample(TimesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Times record);

    int insertSelective(Times record);

    List<Times> selectByExample(TimesExample example);

    Times selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Times record, @Param("example") TimesExample example);

    int updateByExample(@Param("record") Times record, @Param("example") TimesExample example);

    int updateByPrimaryKeySelective(Times record);

    int updateByPrimaryKey(Times record);

    int CheckWeek(String childId,String week);

    Times GetTimes(String childId,String week);

    List<Times> GetLockTime(String childId,String week,String type);

    String ShowLockTime(String childId, String week, String type, String flag);

    int CheckCheckRemindTime(String childId);

    Times GetRemindTime(String childId);

    int updateRemindTime(Times record);

    List<Times> GetEyeRemindTime(String childId);
}