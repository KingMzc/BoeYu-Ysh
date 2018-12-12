package com.BoeYu.mapper;

import com.BoeYu.pojo.Coordinate;
import com.BoeYu.pojo.CoordinateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoordinateMapper {
    long countByExample(CoordinateExample example);

    int deleteByExample(CoordinateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Coordinate record);

    int insertSelective(Coordinate record);

    List<Coordinate> selectByExample(CoordinateExample example);

    Coordinate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Coordinate record, @Param("example") CoordinateExample example);

    int updateByExample(@Param("record") Coordinate record, @Param("example") CoordinateExample example);

    int updateByPrimaryKeySelective(Coordinate record);

    int updateByPrimaryKey(Coordinate record);

    List<String> GetCoordinate(String childId,String date,String datee);

    int deleteChild(String android);
}