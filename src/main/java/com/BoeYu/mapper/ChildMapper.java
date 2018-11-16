package com.BoeYu.mapper;

import com.BoeYu.pojo.Child;
import com.BoeYu.pojo.ChildExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChildMapper {
    long countByExample(ChildExample example);

    int deleteByExample(ChildExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Child record);

    int insertSelective(Child record);

    List<Child> selectByExample(ChildExample example);

    List<Child> selectByCustomerId(@Param("customerid") String customerid);

    Child selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Child record, @Param("example") ChildExample example);

    int updateByExample(@Param("record") Child record, @Param("example") ChildExample example);

    int updateByPrimaryKeySelective(Child record);

    int updateByPrimaryKey(Child record);

    int CheckChild(String childId);

    int LockChild(Child child);

}