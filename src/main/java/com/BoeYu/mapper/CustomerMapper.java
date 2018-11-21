package com.BoeYu.mapper;

import com.BoeYu.pojo.Customer;
import com.BoeYu.pojo.CustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    long countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Long id);

    Customer GetCustomerByToken(String token);

    Customer selectByLogin(@Param("phone") String phone,@Param("wxid") String wxid,@Param("password") String password);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    int updateToken(Customer record);

    int updateChild(Customer record);

    int selectPhone(String phone);

    int selectToken(String token);

    int updateName(Customer record);

}