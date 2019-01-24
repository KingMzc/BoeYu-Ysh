package com.BoeYu.parent;

import com.BoeYu.pojo.Child;
import com.BoeYu.pojo.Customer;
import com.BoeYu.pojo.Family;
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
public class BindingController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ChildService childService;
    @RequestMapping("/Binding")
    @ResponseBody
    public ResultUtil Binding(String token, String android){
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        Child child = new Child();
        child.setFkImgId("img.png");
        child.setAndroid(android);
        child.setFkCustomerId(customer.getPhone());
        child.setCreateTime(new Date());
        int flag = childService.addChild(child);
        if (flag==0){
            resultUti.setCode(0);
            resultUti.setMsg("绑定成功");
        }else if (flag==1){
            resultUti.setCode(1);
            resultUti.setMsg("绑定失败");
        }else if (flag==2){
            resultUti.setCode(1);
            resultUti.setMsg("已经绑定了两个孩子");
        }else if (flag==3){
            resultUti.setCode(1);
            resultUti.setMsg("孩子已经被绑定！");
        }
        return resultUti;
    }

    @RequestMapping("/RelieveBinding")
    @ResponseBody
    public ResultUtil RelieveBinding(String token, String android){
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        if (childService.GetChildByAndroid(android).getFkCustomerId().equals(customer.getPhone())){
            Child child = new Child();
            child.setAndroid(android);
            child.setFkCustomerId(customer.getPhone());
            int flag = childService.deleteChild(child);
            if (flag==0){
                customer.setFkFamilyId("");
                customerService.updateFkFamilyId(customer);
                resultUti.setCode(0);
                resultUti.setMsg("解除绑定成功");
            }else if (flag==1){
                resultUti.setCode(1);
                resultUti.setMsg("解除绑定失败");
            }
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("你不是孩子的绑定者，无法解绑孩子");
        }
        return resultUti;
    }

    @RequestMapping("/Invitation")
    @ResponseBody
    public ResultUtil Invitation(String token,String android, String phone){
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Family family =new Family();
        family.setCreateTime(new Date());
        family.setFkCustomerId(phone);
        family.setFkChildId(android);
        int flag = customerService.addInvitation(family);
        if (flag==0){
            resultUti.setCode(0);
            resultUti.setMsg("邀请成功");
        }else if (flag==1){
            resultUti.setCode(1);
            resultUti.setMsg("邀请失败");
        }
        return resultUti;
    }

    @RequestMapping("/updateflag")
    @ResponseBody
    public ResultUtil updateflag(String token,String android, String flag){
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        int fla = customerService.updateflag(customer.getPhone(),android,flag);
        if (fla>0){
            resultUti.setCode(0);
            resultUti.setMsg("修改成功");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("修改失败");
        }
        return resultUti;
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
