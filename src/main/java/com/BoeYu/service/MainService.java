package com.BoeYu.service;

import java.util.List;

import com.BoeYu.pojo.Customer;
import com.BoeYu.pojo.TbUsers;

public interface MainService {

	 List<Customer> selUserList();

	 List<Customer> selUsersToday();

	 List<Customer> selUsersYestoday();
	
	 List<Customer> selUsersYearWeek();
	
	 List<Customer> selUsersMonth();

	 int seUserCountBygender(int i);
}
