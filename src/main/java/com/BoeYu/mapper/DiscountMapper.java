package com.BoeYu.mapper;

import com.BoeYu.pojo.Discount;
import com.BoeYu.pojo.DiscountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiscountMapper {
    long countByExample(DiscountExample example);

    int deleteByExample(DiscountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Discount record);

    int insertSelective(Discount record);

    List<Discount> selectByExample(DiscountExample example);

    Discount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Discount record, @Param("example") DiscountExample example);

    int updateByExample(@Param("record") Discount record, @Param("example") DiscountExample example);

    int updateByPrimaryKeySelective(Discount record);

    int updateByPrimaryKey(Discount record);

    int updateExport(@Param("paramId")String [] id);

}