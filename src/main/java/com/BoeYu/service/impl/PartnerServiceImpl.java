package com.BoeYu.service.impl;

import com.BoeYu.mapper.AccountMapper;
import com.BoeYu.mapper.CashlogMapper;
import com.BoeYu.pojo.*;
import com.BoeYu.service.PartnerService;
import com.BoeYu.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private CashlogMapper cashlogMapper;
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public int addcashlog(Cashlog cashlog) {
		return cashlogMapper.insert(cashlog);
	}

	@Override
	public int selectcashlog(String partnerid) {
		return cashlogMapper.selectcashlog(partnerid);
	}

	@Override
	public ResultUtil selCashlog(Integer page, Integer limit,String partnerid,PartnerSearch search) {
		PageHelper.startPage(page, limit);
		CashlogExample example=new CashlogExample();
		//排序
		CashlogExample.Criteria criteria = example.createCriteria();
		if(partnerid.equals("admin")){

		}else{
			criteria.andFkPartnerIdEqualTo(partnerid);
		}
		if(search.getNickname()!=null&&!"".equals(search.getNickname())){
			//注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
			criteria.andNickNameLike("%"+search.getNickname()+"%");
		}
		if(search.getPhone()!=null&&!"".equals(search.getPhone())){
			//注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
			criteria.andFkPartnerIdLike("%"+search.getPhone()+"%");
		}
		List<Cashlog> list = cashlogMapper.selectByExample(example);
		PageInfo<Cashlog> pageInfo = new PageInfo<Cashlog>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCode(0);
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		return resultUtil;
	}

	@Override
	public int updatetcashlog(Cashlog cashlog) {
		return cashlogMapper.updatetcashlog(cashlog);
	}

	@Override
	public Cashlog selcashlog(Integer id) {
		return cashlogMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateAccount(Account account) {
		return accountMapper.updateAccount(account);
	}
}
