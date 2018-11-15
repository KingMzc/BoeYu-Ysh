package com.BoeYu.service.impl;

import java.util.List;

import com.BoeYu.mapper.CustomerMapper;
import com.BoeYu.pojo.Customer;
import com.BoeYu.pojo.CustomerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoeYu.mapper.MainMapper;
import com.BoeYu.mapper.TbUsersMapper;
import com.BoeYu.pojo.TbUsers;
import com.BoeYu.pojo.TbUsersExample;
import com.BoeYu.pojo.TbUsersExample.Criteria;
import com.BoeYu.service.MainService;
@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private MainMapper mainMapper;

	@Override
	public List<Customer> selUserList() {
		CustomerExample example=new CustomerExample();
		return customerMapper.selectByExample(example);
	}
	
	@Override
	public List<Customer> selUsersToday() {
		return mainMapper.selUsersToday();
	}

	@Override
	public List<Customer> selUsersYestoday() {
		return mainMapper.selUsersYesterday();
	}


	@Override
	public List<Customer> selUsersYearWeek() {
		// TODO Auto-generated method stub
		return mainMapper.selUsersYearWeek();
	}
	
	@Override
	public List<Customer> selUsersMonth() {
		// TODO Auto-generated method stub
		return mainMapper.selUsersMonth();
	}

	@Override
	public int seUserCountBygender(int i) {
		// TODO Auto-generated method stub
		CustomerExample example=new CustomerExample();
		CustomerExample.Criteria criteria = example.createCriteria();
		criteria.andSexEqualTo(i+"");
		List<Customer> list = customerMapper.selectByExample(example);
		return list.size();
	}

}
