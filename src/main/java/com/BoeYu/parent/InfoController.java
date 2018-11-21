package com.BoeYu.parent;

import com.BoeYu.pojo.Child;
import com.BoeYu.pojo.Customer;
import com.BoeYu.service.ChildService;
import com.BoeYu.service.CustomerService;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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
