package com.BoeYu.child;

import com.BoeYu.pojo.Chat;
import com.BoeYu.pojo.Child;
import com.BoeYu.service.ChildService;
import com.BoeYu.service.CustomerService;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("Api/child")
public class BangingChildController {
    @Autowired
    private ChildService childService;
    @Autowired
    private CustomerService customerService;
    /**
     * 孩子端通过家长设置的密码进行解绑
     *@参数  [android, password]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/26
     */
    @RequestMapping(value = "/CheckPassword")
    @ResponseBody
    public ResultUtil CheckPassword(String android,String password){
        ResultUtil resultUti = new ResultUtil();
        Child child = GetChild(android);
        if(password.equals(customerService.Getpassword(child.getFkCustomerId()))){
        /*int flag = childService.deleteChild(child);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("解绑成功!");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("解绑失败!");
        }*/
            resultUti.setCode(0);
            resultUti.setMsg("解绑成功!");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("密码错误!");
        }
        return resultUti;
    }

    public Child GetChild(String android){
        Child child =childService.GetChildByAndroid(android);
        return child;
    }
}
