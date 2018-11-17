package com.BoeYu.child;

import com.BoeYu.util.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("Api/child")
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public ResultUtil Login(HttpServletRequest request, String phone) {
        ResultUtil resultUti = new ResultUtil();
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
        return resultUti;
    }

    public static boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length()!=11) {
            return false;
        } else {
            System.out.println("..");
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
