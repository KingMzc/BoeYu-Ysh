package com.BoeYu.mapper;

import com.BoeYu.pojo.ApplicationTimes;
import com.BoeYu.pojo.ApplicationTimesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplicationTimesMapper {
    long countByExample(ApplicationTimesExample example);

    int deleteByExample(ApplicationTimesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplicationTimes record);

    int insertSelective(ApplicationTimes record);

    List<ApplicationTimes> selectByExample(ApplicationTimesExample example);

    ApplicationTimes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApplicationTimes record, @Param("example") ApplicationTimesExample example);

    int updateByExample(@Param("record") ApplicationTimes record, @Param("example") ApplicationTimesExample example);

    int updateByPrimaryKeySelective(ApplicationTimes record);

    int updateByPrimaryKey(ApplicationTimes record);

    int selectAppLockTime(String childId,String week);

    int updateAppLockTime(ApplicationTimes applicationTimes);

    List<ApplicationTimes> ShowLockTimep(String childId);

    List<ApplicationTimes> ShowLockTimeChild(String childId,String week);

}