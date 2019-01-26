package com.BoeYu.controller;

import com.BoeYu.pojo.AdminSearch;
import com.BoeYu.service.AdminService;
import com.BoeYu.service.DiscounService;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sys")
public class DiscountController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private DiscounService discounService;

    @RequestMapping("/discountList")
    public String partnerList() {
        return "page/discount/adminList";
    }

    @RequestMapping("/getdiscountList")
    @ResponseBody
    public ResultUtil getdiscountList(Integer page, Integer limit) {
        ResultUtil discount = discounService.selDiscoun(page,limit);
        return discount;
    }
    @RequestMapping("/updateExport")
    @ResponseBody
    public ResultUtil updateExport(String id) {
        ResultUtil resultUtil =new ResultUtil();
        id = id.substring(0,id.length()-1);
        String [] xx = id.split(",");
        discounService.updateExport(xx);
        return resultUtil;
    }

    @RequestMapping("/addDiscount")
    @ResponseBody
    public ResultUtil addDiscount(String csize,String distype,String endtime) {
        ResultUtil resultUtil =new ResultUtil();
        resultUtil.setMsg(discounService.addDiscoun(csize,distype,endtime));
        return resultUtil;
    }
}
