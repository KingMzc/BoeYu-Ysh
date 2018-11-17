package com.BoeYu.parent;

import com.BoeYu.pojo.Customer;
import com.BoeYu.pojo.SafeUrl;
import com.BoeYu.service.CustomerService;
import com.BoeYu.service.SafeUrlService;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("Api/parent")
public class SafeController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SafeUrlService safeUrlService;
    @RequestMapping("/SafeChildUrl")
    @ResponseBody
    public ResultUtil LockChild(String token, String childId,String url ,String type){
        String md ="";
        if (type.equals("0")){
            md="白名单";
        }else{
            md="黑名单";
        }
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        if(customerService.CheckChild(childId)<=0){
            resultUti.setCode(1);
            resultUti.setMsg("没有找到这个孩子！");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        if(customerService.CheckChildIsCustomer(customer.getId().toString(),childId)<=0){
            resultUti.setCode(1);
            resultUti.setMsg("没有权限设置这个孩子的"+md+"!");
            return resultUti;
        }
        SafeUrl safeUrl = new SafeUrl();
        Date date=new Date();
        safeUrl.setSafeContent(url);
        safeUrl.setFkChildId(childId);
        safeUrl.setFkCustomerId(customer.getId().toString());
        safeUrl.setSafeType(type);
        safeUrl.setCreateTime(date);
        int flag = safeUrlService.insert(safeUrl);
        if(flag>0){
            resultUti.setCode(0);
            resultUti.setMsg(md+"设置成功");
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg(md+"设置失败");
            return resultUti;
        }
    }

    public boolean CheckToken(String token){
        boolean check = true;
        int flag = customerService.selectToken(token);
        if(flag!=1){
            check=false;
        }
        return check;
    }

    public Customer GetCustomer(String token){
        Customer customer = customerService.GetCustomerByToken(token);
        return customer;
    }
}
