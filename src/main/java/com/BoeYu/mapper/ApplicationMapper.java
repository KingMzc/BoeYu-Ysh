package com.BoeYu.mapper;

import com.BoeYu.pojo.AppRecordt;
import com.BoeYu.pojo.Application;
import com.BoeYu.pojo.ApplicationExample;
import java.util.List;

import com.BoeYu.pojo.ApplicationTime;
import org.apache.ibatis.annotations.Param;

public interface ApplicationMapper {
    long countByExample(ApplicationExample example);

    int deleteByExample(ApplicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Application record);

    int insertSelective(Application record);

    List<Application> selectByExample(ApplicationExample example);

    Application selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Application record, @Param("example") ApplicationExample example);

    int updateByExample(@Param("record") Application record, @Param("example") ApplicationExample example);

    int updateByPrimaryKeySelective(Application record);

    int updateByPrimaryKey(Application record);

    int selectApplication(String android, String applicationId);

    int updateApplication(Application record);

    int updateLockTime(Application record);

    int updateAppType(Application record);

    int updateLockApp(Application record);

    int deleteApplication(String android, String applicationId);

    List<Application> selectApplicationtype(String android);

    List<ApplicationTime> selectApplicationTime(String android, String week);

    List<ApplicationTime> selectApplicationTimes(String android);

    List<ApplicationTime> selApplicationTimes(String android);

    List<Application> selectApplicationTimeStart(String android);

    List<AppRecordt> selectApplicationRecord (String android);

    int deletechildd(String android);
}