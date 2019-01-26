package com.BoeYu.service;


import com.BoeYu.pojo.*;
import com.BoeYu.util.ResultUtil;

import java.util.List;
import java.util.Map;

public interface PartnerService {
	int addcashlog(Cashlog cashlog);

	int selectcashlog(String partnerid);

	ResultUtil selCashlog(Integer page, Integer limit, String partnerid, PartnerSearch partnerSearch);

	int updatetcashlog(Cashlog cashlog);

	Cashlog selcashlog(Integer id);

	int updateAccount(Account account);

	int selectPhone(String phone);

	int selectPhonewx(String phone,String wxid);

	Map<String,Object> loginInfo(String phone, String wxid);

	Map<String,Object> partnerInfo(String phone);

	int updateWxid(String phone,String wxid);

	int addAdmin(TbAdmin tbAdmin);

	int addBankId(Adminbank adminbank);

	int updateAdmin(TbAdmin tbAdmin);

	List<cashList> selcashlist(String phone, String time);

	List<Adminbank> selBankList(String phone);

	int deleteBank(String id);



}
