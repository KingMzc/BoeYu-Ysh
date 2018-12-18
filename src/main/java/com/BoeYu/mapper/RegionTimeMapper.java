package com.BoeYu.mapper;

import com.BoeYu.pojo.RegionTime;
import com.BoeYu.pojo.RegionTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegionTimeMapper {
    long countByExample(RegionTimeExample example);

    int deleteByExample(RegionTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RegionTime record);

    int insertSelective(RegionTime record);

    List<RegionTime> selectByExample(RegionTimeExample example);

    RegionTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RegionTime record, @Param("example") RegionTimeExample example);

    int updateByExample(@Param("record") RegionTime record, @Param("example") RegionTimeExample example);

    int updateByPrimaryKeySelective(RegionTime record);

    int updateByPrimaryKey(RegionTime record);
}