package com.BoeYu.service;
import java.util.Date;

import com.BoeYu.pojo.TbLog;
import com.BoeYu.pojo.UserSearch;
import com.BoeYu.util.ResultUtil;

public interface LogService {
	//添加日志
	public void insLog(TbLog log);
	
	//获取日志列表
	ResultUtil selLogList(Integer page, Integer limit, UserSearch search);

	//删除指定日期以前的日志
	public int delLogsByDate(Date date);
}
