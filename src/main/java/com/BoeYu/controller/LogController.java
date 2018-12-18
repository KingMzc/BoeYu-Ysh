package com.BoeYu.controller;

import com.BoeYu.pojo.UserSearch;
import com.BoeYu.service.LogService;
import com.BoeYu.util.MyUtil;
import com.BoeYu.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
@RequestMapping("log/")
public class LogController {
	
	@Autowired
	private LogService logServiceImpl;
	
	@RequestMapping("logList")
	@RequiresPermissions("log:log:list")
	public String logList(){
		return "page/log/logList";
	}
	
	@RequestMapping("getLogList")
	@RequiresPermissions("log:log:list")
	@ResponseBody
	public ResultUtil getLogList(Integer page, Integer limit, UserSearch search){
		return logServiceImpl.selLogList(page,limit,search);
	}
	/*public static void main(String[] args)
	{
		Boolean xx = MyUtil.deleteFile("D:\\upload\\","b422b5b29e3f4da9a1d7e87c850fdda97250.jpg");
if(xx==true){
	System.out.println("删除成功");
}else{

}

	}*/



}
