package com.BoeYu.controller;

import com.BoeYu.pojo.ChildSearch;
import com.BoeYu.pojo.UserSearch;
import com.BoeYu.service.ChildService;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//孩子管理
@Controller
@RequestMapping("child/")
public class ChildController {

    @Autowired
    private ChildService childService;

    @RequestMapping("childList")
    public String userList(){
        return "page/child/childList";
    }

    @RequestMapping("getchildList")
    @ResponseBody
    public ResultUtil getUserList(Integer page, Integer limit, ChildSearch search){
        return childService.selChild(page,limit,search);
    }
}
