package com.BoeYu.service;

import com.BoeYu.pojo.Customer;
import com.BoeYu.pojo.UserSearch;
import com.BoeYu.util.ResultUtil;

import java.util.Map;

public interface CustomerService {
    //得到用户信息
     ResultUtil selCustomer(Integer page, Integer limit, UserSearch search);

     Customer selCustomerById(Long id);

     Map<String,Object> loginInfo(String phone,String wxid,String mm);

     int selectPhone(String phone);
}
