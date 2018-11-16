package com.BoeYu.parent;

import com.BoeYu.pojo.Child;
import com.BoeYu.pojo.Customer;
import com.BoeYu.service.CustomerService;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("Api/parent")
public class LoginController {
    @Autowired
    private CustomerService customerService;
    /**
     *@参数  [request, phone, wxid, password]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/11/14
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultUtil Login(HttpServletRequest request,String phone, String wxid , String password){
        ResultUtil resultUti=new ResultUtil();
        if (phone==null||phone==""){
            resultUti.setCode(1);
            resultUti.setMsg("手机号码为空！");
            return resultUti;
        }
        //正则验证手机号码
        /*else if(isPhone(phone)==false){
            resultUti.setCode(1);
            resultUti.setMsg("输入正确的手机号码！");
            return resultUti;
        }*/
        if(wxid==null||wxid==""){
            resultUti.setCode(1);
            resultUti.setMsg("微信号码为空！");
            return resultUti;
        }
        Map<String,Object> map=customerService.loginInfo(phone,wxid,password);
        if (map.get("customer").equals(0)){
            resultUti.setCode(1);
            resultUti.setMsg("登录错误,登录身份过期请重新登录！");
            return resultUti; 
        }
        Customer customer = (Customer)map.get("customer");
        request.getSession().setAttribute("customerid",customer.getId());
        resultUti.setCode(0);
        resultUti.setMsg("登录成功");
        resultUti.setData(map);
        return resultUti;
    }
    @RequestMapping("/Getchilds")
    @ResponseBody
    public ResultUtil Getchilds(String token){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录！");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        List<Child> list = customerService.GetChild(customer.getId().toString());
        resultUti.setCode(0);
        resultUti.setMsg("查询成功");
        resultUti.setData(list);
        return resultUti;
    }

    @RequestMapping("/SwitchChild")
    @ResponseBody
    public ResultUtil SwitchChild(String token,String childId){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
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
            resultUti.setMsg("没有权限绑定这个孩子!");
            return resultUti;
        }
        customer.setFkFamilyId(childId);
        int flag = customerService.updateChild(customer);
        if(flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("切换成功");
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("切换失败 ");
            return resultUti;
        }
    }
    @RequestMapping("/LockChild")
    @ResponseBody
    public ResultUtil LockChild(String token,String childId,String type){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
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
            resultUti.setMsg("没有权限锁屏这个孩子!");
            return resultUti;
        }
        Child child = new Child();
        child.setChildType(type);
        child.setId(Integer.valueOf(childId));
        int flag = customerService.LockChild(child);
        if(flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("锁屏成功");
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("锁屏失败");
            return resultUti;
        }
    }
    @RequestMapping("/ceshi")
    @ResponseBody
    public ResultUtil ceshi(){
        ResultUtil resultUti=new ResultUtil();
            resultUti.setCode(0);
            resultUti.setMsg("锁屏成功");
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

    public static boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if (!isMatch) {
                return false;
            }
            return true;
        }
    }
}
