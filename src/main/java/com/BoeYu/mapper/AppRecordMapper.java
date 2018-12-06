package com.BoeYu.mapper;

import com.BoeYu.pojo.AppRecord;
import com.BoeYu.pojo.AppRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppRecordMapper {
    long countByExample(AppRecordExample example);

    int deleteByExample(AppRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppRecord record);

    int insertSelective(AppRecord record);

    List<AppRecord> selectByExample(AppRecordExample example);

    AppRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppRecord record, @Param("example") AppRecordExample example);

    int updateByExample(@Param("record") AppRecord record, @Param("example") AppRecordExample example);

    int updateByPrimaryKeySelective(AppRecord record);

    int updateByPrimaryKey(AppRecord record);

    List<AppRecord> GetAppType(String child);

    int updateAppType(String id,String type);
}