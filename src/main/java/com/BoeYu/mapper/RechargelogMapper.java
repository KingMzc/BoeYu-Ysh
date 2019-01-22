package com.BoeYu.mapper;

import com.BoeYu.pojo.Rechargelog;
import com.BoeYu.pojo.RechargelogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RechargelogMapper {
    long countByExample(RechargelogExample example);

    int deleteByExample(RechargelogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rechargelog record);

    int insertSelective(Rechargelog record);

    List<Rechargelog> selectByExample(RechargelogExample example);

    Rechargelog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Rechargelog record, @Param("example") RechargelogExample example);

    int updateByExample(@Param("record") Rechargelog record, @Param("example") RechargelogExample example);

    int updateByPrimaryKeySelective(Rechargelog record);

    int updateByPrimaryKey(Rechargelog record);

    List<Rechargelog> selRechargelogByTime(String phone,String TimeS, String TimeE);

}