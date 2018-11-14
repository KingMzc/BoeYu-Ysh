package com.BoeYu.parent;

import com.BoeYu.pojo.Customer;
import com.BoeYu.service.CustomerService;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("register")
public class LoginController {
    @Autowired
    private CustomerService customerService;
    /**
     * 登录
     *@参数  [xx, cc]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/11/9
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultUtil Login(HttpServletRequest request,String xx, String cc , String dd){
        ResultUtil resultUti=new ResultUtil();
        if (xx==null||xx==""){
            resultUti.setCode(1);
            resultUti.setMsg("手机号码为空！");
            return resultUti;
        }
        if(cc==null||cc==""){
            resultUti.setCode(1);
            resultUti.setMsg("微信号码为空！");
            return resultUti;
        }
        Map<String,Object> map=customerService.loginInfo(xx,cc,dd);
        if (map.get("customer").equals(0)){
            resultUti.setCode(1);
            resultUti.setMsg("登录错误,登录身份过期请重新登录！");
            return resultUti; 
        }
        Customer customer = (Customer)map.get("customer");
        request.getSession().setAttribute("customerid",customer.getId());
        System.out.println("22222222222222222222222222222..."+request.getSession().getAttribute("customerid"));
        resultUti.setCode(0);
        resultUti.setMsg("登录成功");
        resultUti.setData(map);
        return resultUti;
    }
    /**
     * 注册
     *@参数  [xx, cc]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/11/9
     */
    @RequestMapping("/register")
    @ResponseBody
    public ResultUtil Register(HttpServletRequest request){
        ResultUtil resultUti=new ResultUtil();
        System.out.println("+++++++++++"+request.getSession().getAttribute("customerid"));
        resultUti.setCode(0);
        resultUti.setMsg("你是猪吗？");
        return resultUti;
    }
}
