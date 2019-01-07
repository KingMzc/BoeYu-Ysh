package com.BoeYu.mapper;

import com.BoeYu.pojo.TbAdminExample;
import com.BoeYu.pojo.TbAdmin;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAdminMapper {
    int countByExample(TbAdminExample example);

    int deleteByExample(TbAdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAdmin record);

    int insertSelective(TbAdmin record);

    List<TbAdmin> selectByExample(TbAdminExample example);

    List<TbAdmin> selectpByExample(TbAdminExample example);

    TbAdmin selectByPrimaryKey(Long id);

    TbAdmin selectGetId(TbAdmin record);

    int updateByExampleSelective(@Param("record") TbAdmin record, @Param("example") TbAdminExample example);

    int updateByExample(@Param("record") TbAdmin record, @Param("example") TbAdminExample example);

    int updateByPrimaryKeySelective(TbAdmin record);

    int updateByPrimaryKey(TbAdmin record);

    int updateToken(TbAdmin record);

    int checkphone(String phone);
}