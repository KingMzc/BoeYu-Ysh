package com.BoeYu.parent;

import com.BoeYu.pojo.Child;
import com.BoeYu.pojo.Customer;
import com.BoeYu.pojo.SafeUrl;
import com.BoeYu.service.ChildService;
import com.BoeYu.service.CustomerService;
import com.BoeYu.service.SafeUrlService;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("Api/parent")
public class SafeController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SafeUrlService safeUrlService;
    @Autowired
    private ChildService childService;
    @RequestMapping("/SafeChildUrl")
    @ResponseBody
    public ResultUtil SafeChildUrl(String token,String url ,String type){
        String md ="";
        if (type.equals("0")){
            md="白名单";
        }else if(type.equals("1")){
            md="黑名单";
        }else{
            md="关键字";
        }
        Customer customer = GetCustomer(token);
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        if(customerService.CheckChild(customer.getFkFamilyId())<=0){
            resultUti.setCode(1);
            resultUti.setMsg("没有找到这个孩子！");
            return resultUti;
        }

        if(customerService.CheckChildIsCustomer(customer.getPhone(),customer.getFkFamilyId())<=0){
            resultUti.setCode(1);
            resultUti.setMsg("没有权限设置这个孩子的"+md+"!");
            return resultUti;
        }
        SafeUrl safeUrl = new SafeUrl();
        Date date=new Date();
        safeUrl.setSafeContent(url);
        safeUrl.setFkChildId(customer.getFkFamilyId());
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

    @RequestMapping("/SelectSafeChild")
    @ResponseBody
    public ResultUtil SelectSafeChild(String token, String type){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        List<SafeUrl> list  = safeUrlService.SelectSafeUrl(customer.getFkFamilyId(),type);
        if (list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(list);
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("暂无数据");
            return resultUti;
        }
    }

    @RequestMapping("/deleteSafeChild")
    @ResponseBody
    public ResultUtil deleteSafeChild(String token, String id){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        int flag = safeUrlService.delteteSafeUrl(Integer.valueOf(id));
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("删除成功");
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("删除失败");
            return resultUti;
        }
    }

    @RequestMapping("/SetSafeChildUrl")
    @ResponseBody
    public ResultUtil SetSafeChildUrl(String token,String type){
        ResultUtil resultUti=new ResultUtil();
        String md ="";
        if (type.equals("0")){
            md="白名单";
        }else if(type.equals("1")){
            md="黑名单";
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("未知参数! ");
            return resultUti;
        }
        Customer customer = GetCustomer(token);

        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        if(customerService.CheckChild(customer.getFkFamilyId())<=0){
            resultUti.setCode(1);
            resultUti.setMsg("没有找到这个孩子！");
            return resultUti;
        }
        if(customerService.CheckChildIsCustomer(customer.getPhone(),customer.getFkFamilyId())<=0){
            resultUti.setCode(1);
            resultUti.setMsg("没有权限设置这个孩子的"+md+"!");
            return resultUti;
        }
        int flag = childService.updateFlag(customer.getFkFamilyId(),type);
        if(flag>0){
            resultUti.setCode(0);
            resultUti.setMsg(md+"启用成功");
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg(md+"启用失败");
            return resultUti;
        }
    }

    @RequestMapping("/Region")
    @ResponseBody
    public ResultUtil Region(String token){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        int flag = 0;
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("删除成功");
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("删除失败");
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
