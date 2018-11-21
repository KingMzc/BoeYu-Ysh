package com.BoeYu.child;

import com.BoeYu.pojo.Child;
import com.BoeYu.pojo.Times;
import com.BoeYu.service.ChildService;
import com.BoeYu.service.TimeService;
import com.BoeYu.util.ResultUtil;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Api/child")
public class LockChildController {
    @Autowired
    private ChildService childService;
    @Autowired
    private TimeService timeService;
    @RequestMapping("/GetLockTime")
    @ResponseBody
    public ResultUtil GetLockTime(String android,String type) {
        ResultUtil resultUti = new ResultUtil();
        Child child =childService.GetChildByAndroid(android);
        Map<String, List<Times>> map = timeService.GetLockTime(child.getId().toString(),type);
        resultUti.setCode(0);
        resultUti.setMsg("查询成功");
        resultUti.setData(map);
        return resultUti;
    }
}
