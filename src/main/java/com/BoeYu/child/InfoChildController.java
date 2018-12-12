package com.BoeYu.child;

import com.BoeYu.pojo.Child;
import com.BoeYu.pojo.Confidantnumber;
import com.BoeYu.pojo.Customer;
import com.BoeYu.pojo.SafeUrl;
import com.BoeYu.service.ChildService;
import com.BoeYu.service.SafeUrlService;
import com.BoeYu.service.TimeService;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("Api/child")
public class InfoChildController {
    @Autowired
    private ChildService childService;
    @Autowired
    private SafeUrlService safeUrlService;
    @Autowired
    private TimeService timeService;
    @RequestMapping("/Coordinate")
    @ResponseBody
    public ResultUtil Coordinate(String android, String coordinate) {
        ResultUtil resultUti = new ResultUtil();
        Child child =GetChild(android);
        int flag = childService.insertCoordinate(child,coordinate);
        //判断 是不是安全范围

        if (flag>0){
           if(timeService.CheckRegion(android,coordinate)>0){
               Map<String,String> map =new HashMap<String,String>();
               map.put("msg","孩子已经逃跑~~~请抓回！！！！！！！");
               resultUti.setData(map);
           }
            resultUti.setCode(0);
            resultUti.setMsg("新增成功");
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("新增失败");
            return resultUti;
        }
    }

    @RequestMapping("/SelectConfidantnumber")
    @ResponseBody
    public ResultUtil SelectConfidantnumber(String android) {
        ResultUtil resultUti = new ResultUtil();
        Child child =GetChild(android);
        List<Confidantnumber> list =childService.SelectConfidantnumber(child.getId().toString());
        if(list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(list);
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("暂无数据");
        }
        return resultUti;
    }

    @RequestMapping("/SelectSafeChild")
    @ResponseBody
    public ResultUtil SelectSafeChild(String android,String type){
        ResultUtil resultUti=new ResultUtil();
        Child child =GetChild(android);
        List<SafeUrl> list = new ArrayList<SafeUrl>();
        if(type==null||type==""){
            list  = safeUrlService.SelectSafeUrl(child.getId().toString(),child.getFlag());
        }else if(type.equals("2")){
            list  = safeUrlService.SelectSafeUrl(child.getId().toString(),"2");
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("无效参数！");
            return resultUti;
        }
        if (list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(list);
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("暂无数据");
            return resultUti;
        }
    }


    public Child GetChild(String android){
        Child child =childService.GetChildByAndroid(android);
        return child;
    }

}
