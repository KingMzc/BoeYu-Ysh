package com.BoeYu.mapper;

import com.BoeYu.pojo.Cashlog;
import com.BoeYu.pojo.CashlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CashlogMapper {
    long countByExample(CashlogExample example);

    int deleteByExample(CashlogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cashlog record);

    int insertSelective(Cashlog record);

    List<Cashlog> selectByExample(CashlogExample example);

    Cashlog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cashlog record, @Param("example") CashlogExample example);

    int updateByExample(@Param("record") Cashlog record, @Param("example") CashlogExample example);

    int updateByPrimaryKeySelective(Cashlog record);

    int updateByPrimaryKey(Cashlog record);

    int selectcashlog(String partnerid);

    int updatetcashlog(Cashlog record);

    List<Cashlog> selCashlogByTime(String phone,String TimeS, String TimeE);
}