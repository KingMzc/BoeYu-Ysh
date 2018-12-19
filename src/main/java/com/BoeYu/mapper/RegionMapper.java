package com.BoeYu.mapper;

import com.BoeYu.pojo.Region;
import com.BoeYu.pojo.RegionExample;
import java.util.List;

import com.BoeYu.pojo.RegionTimes;
import org.apache.ibatis.annotations.Param;

public interface RegionMapper {
    long countByExample(RegionExample example);

    int deleteByExample(RegionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Region record);

    int insertSelective(Region record);

    List<Region> selectByExample(RegionExample example);

    Region selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Region record, @Param("example") RegionExample example);

    int updateByExample(@Param("record") Region record, @Param("example") RegionExample example);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);

    int CheckRegion(String childId);

    int addRegion(Region record);

    int deleteRegion(String childId);

    int UpdateRegionCoordinate(Region record);

    int UpdateRegionMater(Region record);

    int UpdateRegionName(Region record);

    List<RegionTimes> selectRegionBychildId(String childId,String week);

    List<Region> SelectRegions(String childId);
}