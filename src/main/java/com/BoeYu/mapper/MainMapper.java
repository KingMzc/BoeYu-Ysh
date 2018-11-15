package com.BoeYu.mapper;

import java.util.List;

import com.BoeYu.pojo.Customer;
import org.apache.ibatis.annotations.Select;

import com.BoeYu.pojo.TbUsers;


public interface MainMapper {
	@Select("select * from customer where to_days(create_time) = to_days(now());")
	List<Customer> selUsersToday();
	
	@Select("SELECT * FROM customer WHERE TO_DAYS( NOW( ) ) - TO_DAYS( create_time)= 1  ")
	List<Customer> selUsersYesterday();
	
	@Select("SELECT * FROM  customer WHERE YEARWEEK(date_format(create_time,'%Y-%m-%d')) = YEARWEEK(now());")
	List<Customer> selUsersYearWeek();
	
	@Select("SELECT * FROM customer WHERE DATE_FORMAT( create_time, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )")
	List<Customer> selUsersMonth();
}
