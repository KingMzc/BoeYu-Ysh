package com.BoeYu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.BoeYu.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.BoeYu.pojo.TbUsers;
import com.BoeYu.service.MainService;

@Controller
@RequestMapping("main/")
public class MainController {
	
	@Autowired
	private MainService mainServiceImpl;
	
	@RequestMapping("getUserTotal")
	@ResponseBody
	public List<Customer> getUserTotal(){
		return mainServiceImpl.selUserList();
	}

	@RequestMapping("getUsersToday")
	@ResponseBody
	public List<Customer> getUsersToday(){
		return mainServiceImpl.selUsersToday();
	}
	@RequestMapping("getUsersYestoday")
	@ResponseBody
	public List<Customer> getUsersYestoday(){
		return mainServiceImpl.selUsersYestoday();
	}
	@RequestMapping("getUsersYearWeek")
	@ResponseBody
	public List<Customer> getUsersYearWeek(){
		return mainServiceImpl.selUsersYearWeek();
	}
	
	@RequestMapping("getUsersMonth")
	@ResponseBody
	public List<Customer> getUsersMonth(){
		return mainServiceImpl.selUsersMonth();
	}

	@RequestMapping("/dataAccessGender")
	@ResponseBody
	public Map<String, Object> dataAccessGender() {
	    Map<String, Object> j=new HashMap<>();
	    String[] categories = {"女", "男", "保密"};
	    j.put("categories", categories);
	    Map<String, Object> json=null;
	    List<Map<String, Object>> list=new ArrayList<>();
	    for(int i=0;i<categories.length;i++){
	    	json = new HashMap<String, Object>();
		    json.put("value", mainServiceImpl.seUserCountBygender(i));
		    json.put("name",categories[i]);
		    list.add(json);
	    }
	    j.put("values", list);
	    return j;
	}
}
