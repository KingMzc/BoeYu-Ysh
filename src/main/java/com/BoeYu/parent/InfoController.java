package com.BoeYu.parent;

import com.BoeYu.pojo.Child;
import com.BoeYu.pojo.Confidantnumber;
import com.BoeYu.pojo.Customer;
import com.BoeYu.service.ChildService;
import com.BoeYu.service.CustomerService;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("Api/parent")
public class InfoController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ChildService childService;
    @RequestMapping("/UpdateName")
    @ResponseBody
    public ResultUtil UpdateName(String token, String name) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        customer.setNickname(name);
        int flag = customerService.updateName(customer);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("修改成功");
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("修改失败");
        }
        return resultUti;
    }

    @RequestMapping("/UpdateChildSex")
    @ResponseBody
    public ResultUtil UpdateChildSex(String token, String sex) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        Child child =childService.selectByPrimaryKey(Integer.valueOf(customer.getFkFamilyId()));
        child.setSex(sex);
        int flag = childService.updateSex(child);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("修改成功");
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("修改失败");
        }
        return resultUti;
    }



    @RequestMapping("/UpdateChildYears")
    @ResponseBody
    public ResultUtil UpdateChildYears(String token, Date years) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        Child child =childService.selectByPrimaryKey(Integer.valueOf(customer.getFkFamilyId()));
        child.setYears(years);
        int flag = childService.updateYears(child);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("修改成功");
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("修改失败");
        }
        return resultUti;
    }

    @RequestMapping("/ShowCoordinate")
    @ResponseBody
    public ResultUtil ShowCoordinate(String token, String date) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        String sdate=date+" 00:00:00";
        String edate=date+" 23:59:59";
        Customer customer=GetCustomer(token);
        Child child =childService.selectByPrimaryKey(Integer.valueOf(customer.getFkFamilyId()));
        List<String> list =customerService.getcoordinate(child.getId().toString(),sdate,edate);
        if (list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(list);
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("暂无记录");
        }
        return resultUti;
    }
    @RequestMapping("/addConfidantnumber")
    @ResponseBody
    public ResultUtil addConfidantnumber(String token, String name,String phone) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        if (customerService.CheckPhone(customer.getFkFamilyId(),phone)>0){
            resultUti.setCode(1);
            resultUti.setMsg("请勿重复添加手机号码？");
            return resultUti;
        }
        int flag = customerService.addConfidantnumber(customer.getFkFamilyId(),name,phone);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("亲情号码添加成功");
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("亲情号码添加失败");
        }
        return resultUti;
    }
    @RequestMapping("/updateConfidantnumber")
    @ResponseBody
    public ResultUtil updateConfidantnumber(String token,String name,String phone,String id) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        int flag = customerService.updateConfidantnumber(id,name,phone);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("亲情号码修改成功");
            return resultUti;
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("亲情号码修改失败");
            return resultUti;
        }
    }

    @RequestMapping("/SelectConfidantnumber")
    @ResponseBody
    public ResultUtil SelectConfidantnumber(String token) {
        ResultUtil resultUti = new ResultUtil();
        Customer customer=GetCustomer(token);
        List<Confidantnumber> list =childService.SelectConfidantnumber(customer.getFkFamilyId());
        if(list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(list);
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("暂无数据");
        }
        return resultUti;
    }

    public Customer GetCustomer(String token){
        Customer customer = customerService.GetCustomerByToken(token);
        return customer;
    }

    public boolean CheckToken(String token){
        boolean check = true;
        int flag = customerService.selectToken(token);
        if(flag!=1){
            check=false;
        }
        return check;
    }
}
