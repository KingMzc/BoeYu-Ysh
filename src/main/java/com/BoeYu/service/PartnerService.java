package com.BoeYu.service;


import com.BoeYu.pojo.Account;
import com.BoeYu.pojo.Cashlog;
import com.BoeYu.pojo.PartnerSearch;
import com.BoeYu.util.ResultUtil;

public interface PartnerService {
	int addcashlog(Cashlog cashlog);

	int selectcashlog(String partnerid);

	ResultUtil selCashlog(Integer page, Integer limit, String partnerid, PartnerSearch partnerSearch);

	int updatetcashlog(Cashlog cashlog);

	Cashlog selcashlog(Integer id);

	int updateAccount(Account account);

}
