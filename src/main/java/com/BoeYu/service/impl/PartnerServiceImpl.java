package com.BoeYu.service.impl;

import com.BoeYu.mapper.*;
import com.BoeYu.pojo.*;
import com.BoeYu.service.PartnerService;
import com.BoeYu.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private CashlogMapper cashlogMapper;
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private TbAdminMapper tbAdminMapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private AdminbankMapper adminbankMapper;
	@Autowired
	private RechargelogMapper rechargelogMapper;

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

	@Override
	public int selectPhone(String phone) {
		return tbAdminMapper.selectPhone(phone);
	}

	@Override
	public int selectPhonewx(String phone, String wxid) {
		return tbAdminMapper.selectPhonewx(phone,wxid);
	}



	@Override
	public Map<String, Object> loginInfo(String phone, String wxid) {
		Map<String, Object> map =new HashMap<String, Object>();
		TbAdmin tbAdmin = tbAdminMapper.selectByLogin(phone);
		if (tbAdmin==null){
			map.put("Admin",0);
			return map;
		}
		String token= DigestUtils.md5DigestAsHex((new Date().getTime()+""+phone).getBytes());
		tbAdmin.setToken(token);
		tbAdminMapper.updateToken(tbAdmin);
		Account account = accountMapper.selectAccount(phone);
		if (account==null){
			Account at = new Account();
			at.setFkPartnerId(phone);
			at.setTmoney("0");
			at.setMoney("0");
			at.setSmoney("0");
			accountMapper.insert(at);
			account=accountMapper.selectAccount(phone);
		}
		map.put("Admin",tbAdmin);
		map.put("account",account);
		map.put("customerS",customerMapper.countcustomer(phone));
		map.put("customerV",customerMapper.countvipcustomer(phone,"1"));
		map.put("customer",customerMapper.countvipcustomer(phone,"0"));
		return map;
	}

	@Override
	public int updateWxid(String phone, String wxid) {
		return tbAdminMapper.updateWxid(phone,wxid);
	}

	@Override
	public int addAdmin(TbAdmin tbAdmin) {
		return tbAdminMapper.insert(tbAdmin);
	}

	@Override
	public int addBankId(Adminbank adminbank) {
		return adminbankMapper.insert(adminbank);
	}

	@Override
	public int updateAdmin(TbAdmin tbAdmin) {
		return tbAdminMapper.updateAdminidcard(tbAdmin);
	}

	@Override
	public List<cashList> selcashlist(String phone, String time) {

		List<cashList> list = new ArrayList<cashList>();
		List<Cashlog> clist = cashlogMapper.selCashlogByTime(phone,time+"-01 00:00:00",time+"-31 23:59:59");
		if (clist.size()>0){
			for (int i=0;i<clist.size();i++){
				cashList cashlist  = new cashList();
				cashlist.setPhone(clist.get(i).getFkPartnerId());
				cashlist.setMoney(clist.get(i).getTmoney());
				cashlist.setTime(clist.get(i).getCreatetime());
				list.add(cashlist);
			}
		}
		List<Rechargelog> rlist=rechargelogMapper.selRechargelogByTime(phone,time+"-01 00:00:00",time+"-31 23:59:59");
		if (rlist.size()>0){
			for (int i=0;i<rlist.size();i++){
				cashList cashlist  = new cashList();
				cashlist.setPhone(rlist.get(i).getFkCustomerId());
				cashlist.setMoney(rlist.get(i).getMoney());
				cashlist.setTime(rlist.get(i).getCreatetime());
				list.add(cashlist);
			}
		}
		ListSort(list);
		return list;
	}

	@Override
	public List<Adminbank> selBankList(String phone) {
		return adminbankMapper.selBankList(phone);
	}

	@Override
	public int deleteBank(String id) {
		return adminbankMapper.deleteByPrimaryKey(Integer.valueOf(id));
	}

	private static void ListSort(List<cashList> list) {
		Collections.sort(list, new Comparator<cashList>() {
			@Override
			public int compare(cashList o1, cashList o2) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
				try {
					Date dt1 = o1.getTime();
					Date dt2 = o2.getTime();
					if (dt1.getTime() > dt2.getTime()) {
						return 1;
					} else if (dt1.getTime() < dt2.getTime()) {
						return -1;
					} else {
						return 0;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return 0;
			}
		});
	}
}
