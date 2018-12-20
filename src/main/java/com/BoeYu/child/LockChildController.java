package com.BoeYu.child;

import com.BoeYu.pojo.ApplicationTime;
import com.BoeYu.pojo.ApplicationTimes;
import com.BoeYu.pojo.Child;
import com.BoeYu.pojo.Times;
import com.BoeYu.service.ChildService;
import com.BoeYu.service.CustomerService;
import com.BoeYu.service.TimeService;
import com.BoeYu.util.DateUtil;
import com.BoeYu.util.ResultUtil;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @Autowired
    private CustomerService customerService;
    /**
     * 孩子端获取当天的锁屏时间
     *@参数  [android]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/15
     */
    @RequestMapping(value = "/GetLockTime", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResultUtil GetLockTime(String android) {
        ResultUtil resultUti = new ResultUtil();
        Child child =childService.GetChildByAndroid(android);
        List<ApplicationTimes> list =timeService.ShowLockTimeChild(android, DateUtil.week());
        if(list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(list);
            return resultUti;
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("暂无数据");
            return resultUti;
        }
    }
    /**
     * 获取应用列表和应用的禁用时间
     *@参数  [android]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/14
     *//*
    @RequestMapping(value = "/GetApplicationTime", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResultUtil GetApplicationTime(String android) {
        ResultUtil resultUti = new ResultUtil();
        List<ApplicationTime> list =customerService.selectApplicationTime(android);
        if(list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(list);
            return resultUti;
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("暂无数据");
            return resultUti;
        }
    }*/

    @RequestMapping(value = "/GetEyeRemindTime", method = { RequestMethod.GET, RequestMethod.POST })
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
            resultUti.setCode(0);
            resultUti.setMsg("暂无数据");
            resultUti.setData(map);
            return resultUti;
        }
    }
}
