package com.BoeYu.mapper;

import com.BoeYu.pojo.Child;
import com.BoeYu.pojo.ChildExample;
import com.BoeYu.pojo.ChildKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChildMapper {
    long countByExample(ChildExample example);

    int deleteByExample(ChildExample example);

    int deleteByPrimaryKey(ChildKey key);

    int insert(Child record);

    int insertSelective(Child record);

    List<Child> selectByExample(ChildExample example);

    Child selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Child record, @Param("example") ChildExample example);

    int updateByExample(@Param("record") Child record, @Param("example") ChildExample example);

    int updateByPrimaryKeySelective(Child record);

    int updateByPrimaryKey(Child record);

    int CheckChild(String android);

    int LockChild(Child record);

    Child GetChildByPhone(String phone);

    int updateToken(Child record);

    int CheckChildByPhone(String phone);

    int CheckChildByToken(String token);

    Child GetChildByAndroid(String android);

    int updateName(Child record);

    int updateSex(Child record);

    int updateYears(Child record);

    int updateGrade(Child child);

    int updateType(Child child);

    int updateFlag(String id,String flag);

    int CheckCustomerBinding(String phone);

    Child selectByAndroid(String android);

    int deleteChild(String android);

    int updateDevname(String android,String devname);

    int updatePhone(String android,String phone);

    int updateElectric(String android,String electric);

}