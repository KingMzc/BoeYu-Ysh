package com.BoeYu.service.impl;

import java.util.List;

import com.BoeYu.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoeYu.mapper.TbUsersMapper;
import com.BoeYu.pojo.TbUsers;
import com.BoeYu.pojo.TbUsersExample;
import com.BoeYu.pojo.TbUsersExample.Criteria;
import com.BoeYu.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private TbUsersMapper tbUsersMapper;

	@Override
	public TbUsers selUserByCodeAndStatus(String eCode,String status) {
		TbUsersExample example=new TbUsersExample();
		Criteria criteria = example.createCriteria();
		criteria.andECodeEqualTo(eCode);
		criteria.andStatusEqualTo(status);
		List<TbUsers> users = tbUsersMapper.selectByExample(example);
		if(users!=null&&users.size()>0){
			return users.get(0);
		}
		return null;
	}

	@Override
	public void updUserStatus(Customer customer) {
		tbUsersMapper.updateByPrimaryKey(customer);
	}

}
