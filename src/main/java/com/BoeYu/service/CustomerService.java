package com.BoeYu.service;

import com.BoeYu.pojo.*;
import com.BoeYu.util.ResultUtil;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    //得到用户信息
     ResultUtil selCustomer(Integer page, Integer limit, UserSearch search);

     Customer selCustomerById(Long id);

     Map<String,Object> loginInfo(String phone,String wxid,String mm);

     int selectPhone(String phone);

     int selectToken(String token);

     Customer GetCustomerByToken(String token);

     Customer GetCustomerByPhone(String phone);

     List<Child> GetChild(String CustomerID);

     int updateChild(Customer customer);

     int updateName(Customer customer);

     int CheckChild(String childId);

     int CheckChildIsCustomer(String CustomerId,String ChildId);

    int LockChild(Child child);

    List<String> getcoordinate(String childId,String date,String datee);

    int addConfidantnumber(String childId,String name,String phone);

    int CheckPhone(String childId,String phone);

    int updateConfidantnumber(String id,String name,String phone);

    int updateVipTime(Customer customer);

    List<Vip> GetVipList();

    Vip selectByPrimaryKey(Integer id);

    int addFeedback (Feedback feedback);


}
