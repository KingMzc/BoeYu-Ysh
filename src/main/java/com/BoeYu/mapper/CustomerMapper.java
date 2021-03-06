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

    Customer GetCustomerByPhone(String phone);

    Customer selectByLogin(@Param("phone") String phone);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    int updateToken(Customer record);

    int updateLoginTime(Customer record);

    int updateVip(Customer record);

    int updateWxid(String phone,String wxid);

    int updateChild(Customer record);

    int updateVipTime(Customer record);

    int updateFkFamilyId(Customer record);

    int selectPhone(String phone);
    int selectPhonewx(String phone,String wxid);

    int selectToken(String token);

    int updateName(Customer record);

    int updatepassword(Customer record);

    String Getpassword(String phone);

    String GetMoney(String phone);

    List<Customer> countvipcustomer(String partnerId,String vip);

    List<Customer> countcustomer(String partnerId);

}