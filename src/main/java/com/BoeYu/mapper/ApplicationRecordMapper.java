package com.BoeYu.mapper;

import com.BoeYu.pojo.ApplicationRecord;
import com.BoeYu.pojo.ApplicationRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplicationRecordMapper {
    long countByExample(ApplicationRecordExample example);

    int deleteByExample(ApplicationRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplicationRecord record);

    int insertSelective(ApplicationRecord record);

    List<ApplicationRecord> selectByExample(ApplicationRecordExample example);

    ApplicationRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApplicationRecord record, @Param("example") ApplicationRecordExample example);

    int updateByExample(@Param("record") ApplicationRecord record, @Param("example") ApplicationRecordExample example);

    int updateByPrimaryKeySelective(ApplicationRecord record);

    int updateByPrimaryKey(ApplicationRecord record);
}