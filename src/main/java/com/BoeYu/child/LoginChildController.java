package com.BoeYu.child;

import com.BoeYu.service.ChildService;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("Api/child")
public class LoginChildController {
    @Autowired
    private ChildService childService;
    @RequestMapping(value = "/Login", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResultUtil Login(HttpServletRequest request, String android) {
        ResultUtil resultUti = new ResultUtil();
        int flag =childService.selectChildBinding(android);
        if (flag>0){
            Map<String,Object> map =childService.GetChild(android);
            if(map.size()>0){
                resultUti.setCode(0);
                resultUti.setMsg("登录成功");
                resultUti.setData(map);
            }else{
                resultUti.setCode(1);
                resultUti.setMsg("登录失败");
            }
        }else{
            resultUti.setCode(2);
            resultUti.setMsg("未绑定");
        }
        return resultUti;
    }


}
