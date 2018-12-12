package com.BoeYu.mapper;

import com.BoeYu.pojo.Confidantnumber;
import com.BoeYu.pojo.ConfidantnumberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfidantnumberMapper {
    long countByExample(ConfidantnumberExample example);

    int deleteByExample(ConfidantnumberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Confidantnumber record);

    int insertSelective(Confidantnumber record);

    List<Confidantnumber> selectByExample(ConfidantnumberExample example);

    Confidantnumber selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Confidantnumber record, @Param("example") ConfidantnumberExample example);

    int updateByExample(@Param("record") Confidantnumber record, @Param("example") ConfidantnumberExample example);

    int updateByPrimaryKeySelective(Confidantnumber record);

    int updateByPrimaryKey(Confidantnumber record);

    int CheckPhone(String childId,String phone);

    int updateById(Confidantnumber record);

    List<Confidantnumber> selectConfidantnumber(String ChildId);

    int deleteChild(String android);
}