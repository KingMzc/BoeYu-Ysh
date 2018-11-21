package com.BoeYu.child;

import com.BoeYu.service.ChildService;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("Api/child")
public class LoginChildController {
    @Autowired
    private ChildService childService;
    @RequestMapping("/login")
    @ResponseBody
    public ResultUtil Login(HttpServletRequest request, String android) {
        ResultUtil resultUti = new ResultUtil();
        Map<String,Object> map =childService.GetChild(android);
        resultUti.setCode(0);
        resultUti.setMsg("登录成功");
        resultUti.setData(map);
        return resultUti;
    }


}
