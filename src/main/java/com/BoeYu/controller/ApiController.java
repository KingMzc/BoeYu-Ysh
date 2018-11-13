package com.BoeYu.controller;


import com.BoeYu.util.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("Api")
public class ApiController {
    @RequestMapping("/login")
    @ResponseBody
    public ResultUtil ceshi(String xx, String cc){
        ResultUtil resultUti=new ResultUtil();
        resultUti.setCode(0);
        resultUti.setMsg("你是猪吗？");
        Map<String,String> map=new HashMap<String,String>();
        map.put("key","你是猪");
        map.put("xx",xx);
        map.put("cc",cc);
        resultUti.setData(map);
        return resultUti;
    }
}
