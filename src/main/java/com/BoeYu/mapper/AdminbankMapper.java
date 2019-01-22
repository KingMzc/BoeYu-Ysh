package com.BoeYu.mapper;

import com.BoeYu.pojo.Adminbank;
import com.BoeYu.pojo.AdminbankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminbankMapper {
    long countByExample(AdminbankExample example);

    int deleteByExample(AdminbankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Adminbank record);

    int insertSelective(Adminbank record);

    List<Adminbank> selectByExample(AdminbankExample example);

    Adminbank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Adminbank record, @Param("example") AdminbankExample example);

    int updateByExample(@Param("record") Adminbank record, @Param("example") AdminbankExample example);

    int updateByPrimaryKeySelective(Adminbank record);

    int updateByPrimaryKey(Adminbank record);

    List<Adminbank> selBankList(String phone);
}