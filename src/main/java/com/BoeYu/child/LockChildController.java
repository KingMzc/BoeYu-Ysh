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
        Map<String, List<Times>> maptimes = timeService.GetLockTime(child.getId().toString(),type);
        if(maptimes.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(maptimes);
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("暂无数据");
            resultUti.setData(maptimes);
            return resultUti;
        }
    }
    @RequestMapping("/GetEyeRemindTime")
    @ResponseBody
    public ResultUtil GetEyeRemindTime(String android) {
        ResultUtil resultUti = new ResultUtil();
        Child child =childService.GetChildByAndroid(android);
        Map<String,String> map = timeService.GetEyeRemindTime(child.getId().toString());
        if(map.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(map);
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("暂无数据");
            resultUti.setData(map);
            return resultUti;
        }
    }
}
