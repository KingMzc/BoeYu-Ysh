package com.BoeYu.parent;

import com.BoeYu.controller.WebSocket;
import com.BoeYu.pojo.*;
import com.BoeYu.service.ChildService;
import com.BoeYu.service.CustomerService;
import com.BoeYu.service.TimeService;
import com.BoeYu.util.DateUtil;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.PathParam;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("Api/parent")
public class InfoController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ChildService childService;
    @Autowired
    private TimeService timeService;

    @RequestMapping("/GetCustomerInfo")
    @ResponseBody
    public ResultUtil GetCustomerInfo(String token) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        if(customer.getVipTime()!=null){
        if(customer.getVipTime().compareTo(new Date())<0){
            customer.setVip("0");
            customerService.updateVip(customer);
            resultUti.setMsg("vip已到期");
        }else{
            resultUti.setMsg("vip已登录");
        }
        }else{
            resultUti.setMsg("普通用户已登录");
        }
            resultUti.setCode(0);
            resultUti.setData(customer);
        return resultUti;
    }

    @RequestMapping("/UpdateName")
    @ResponseBody
    public ResultUtil UpdateName(String token, String name) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        customer.setNickname(name);
        int flag = customerService.updateName(customer);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("修改成功");
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("修改失败");
        }
        return resultUti;
    }

    @RequestMapping("/UpdateChildName")
    @ResponseBody
    public ResultUtil UpdateChildName(String token, String name) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        Child child =childService.selectByAndroid(customer.getFkFamilyId());
        child.setName(name);
        int flag = childService.updateName(child);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("修改成功");
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("修改失败");
        }
        return resultUti;
    }

    @RequestMapping("/UpdateChildSex")
    @ResponseBody
    public ResultUtil UpdateChildSex(String token, String sex) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        Child child =childService.selectByAndroid(customer.getFkFamilyId());
        child.setSex(sex);
        int flag = childService.updateSex(child);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("修改成功");
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("修改失败");
        }
        return resultUti;
    }



    @RequestMapping("/UpdateChildYears")
    @ResponseBody
    public ResultUtil UpdateChildYears(String token, String years) throws ParseException {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        Child child =childService.selectByAndroid(customer.getFkFamilyId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        child.setYears(sdf.parse(years));
        int flag = childService.updateYears(child);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("修改成功");
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("修改失败");
        }
        return resultUti;
    }

    @RequestMapping("/UpdateChildGrade")
    @ResponseBody
    public ResultUtil UpdateChildGrade(String token, String grade) throws ParseException {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        Child child =childService.selectByAndroid(customer.getFkFamilyId());
        child.setGrade(grade);
        int flag = childService.updateGrade(child);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("修改成功");
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("修改失败");
        }
        return resultUti;
    }

    @RequestMapping("/ShowCoordinate")
    @ResponseBody
    public ResultUtil ShowCoordinate(String token, String date){
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        String sdate=date+" 00:00:00";
        String edate=date+" 23:59:59";
        Customer customer=GetCustomer(token);
        //Child child =childService.selectByPrimaryKey(Integer.valueOf(customer.getFkFamilyId()));
        List<String> list =customerService.getcoordinate(customer.getFkFamilyId(),sdate,edate);
        if (list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(list);
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("暂无记录");
        }
        return resultUti;
    }

    /**
     * 向安卓发送指令 上传孩子坐标
     *@参数  [token]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/20
     */
    @RequestMapping("/SendCoordinate")
    @ResponseBody
    public ResultUtil SendCoordinate(String token) throws IOException {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        int flag = WebSocket.sendmsg(customer.getFkFamilyId(),"Coordinate");
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("发送成功");
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("发送失败");
        }
        return resultUti;
    }
    /**
     * 获取孩子坐标
     *@参数  [token]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/20
     */
    @RequestMapping("/GetCoordinate")
    @ResponseBody
    public ResultUtil GetCoordinate(String token) throws IOException {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        Map<String,String> map = RealTimeCoordinates.getmap();
        if (map==null||map.get(customer.getFkFamilyId()).equals("")){
            resultUti.setCode(0);
            resultUti.setMsg("暂无数据");
        }else {
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(map.get(customer.getFkFamilyId()));
        }
        return resultUti;
    }

    @RequestMapping("/addConfidantnumber")
    @ResponseBody
    public ResultUtil addConfidantnumber(String token, String name,String phone) throws IOException {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        if(name.equals("undefined")||name==null){
            resultUti.setCode(1);
            resultUti.setMsg("姓名不能为空!");
            return resultUti;
        }
        if(phone.equals("undefined")||phone==null){
            resultUti.setCode(1);
            resultUti.setMsg("手机号码不能为空!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        if (customerService.CheckPhone(customer.getFkFamilyId(),phone)>0){
            resultUti.setCode(1);
            resultUti.setMsg("请勿重复添加手机号码？");
            return resultUti;
        }
        int flag = customerService.addConfidantnumber(customer.getFkFamilyId(),name,phone);
        if (flag>0){
            WebSocket.sendmsg(customer.getFkFamilyId(),"FamilyNumber");
            resultUti.setCode(0);
            resultUti.setMsg("亲情号码添加成功");
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("亲情号码添加失败");
        }
        return resultUti;
    }
    @RequestMapping("/updateConfidantnumber")
    @ResponseBody
    public ResultUtil updateConfidantnumber(String token,String name,String phone,String id) throws IOException {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        if(id.equals("undefined")||id==null){
            resultUti.setCode(1);
            resultUti.setMsg("ID不能为空!");
            return resultUti;
        }
        if(name.equals("undefined")||name==null){
            resultUti.setCode(1);
            resultUti.setMsg("姓名不能为空!");
            return resultUti;
        }

        if(phone.equals("undefined")||phone==null){
            resultUti.setCode(1);
            resultUti.setMsg("手机号码不能为空!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        int flag = customerService.updateConfidantnumber(id,name,phone);
        if (flag>0){
            WebSocket.sendmsg(customer.getFkFamilyId(),"FamilyNumber");
            resultUti.setCode(0);
            resultUti.setMsg("亲情号码修改成功");
            return resultUti;
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("亲情号码修改失败");
            return resultUti;
        }
    }

    @RequestMapping("/SelectConfidantnumber")
    @ResponseBody
    public ResultUtil SelectConfidantnumber(String token) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer=GetCustomer(token);
        List<Confidantnumber> list =childService.SelectConfidantnumber(customer.getFkFamilyId());
        if(list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(list);
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("暂无数据");
        }
        return resultUti;
    }
    @RequestMapping("/FreeVip")
    @ResponseBody
    public ResultUtil FreeVip(String token) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        Calendar c = Calendar.getInstance();
        Date date =new Date();
        if(customer.getVipTime()==null||customer.getVipTime().equals("")){
            c.setTime(date);
        }else{
            c.setTime(customer.getVipTime());
        }
        c.add(Calendar.DAY_OF_MONTH, 3);
        customer.setVipTime(c.getTime());
        int flag = customerService.updateVipTime(customer);
        if(flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("Vip领取成功");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("Vip领取失败");
        }
        return resultUti;
    }

    @RequestMapping("/FreeVip/{phone}")
    @ResponseBody
    public ResultUtil FreeVipT( String token, @PathVariable String phone) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer vipcustomer = customerService.GetCustomerByPhone(phone);
        if(vipcustomer.getVip().equals("0")||vipcustomer.getVip()==null){
            resultUti.setCode(1);
            resultUti.setMsg("Vip领取失败");
        }
        Customer customer = GetCustomer(token);
        Calendar c = Calendar.getInstance();
        Date date =new Date();
        if(customer.getVipTime()==null||customer.getVipTime().equals("")){
            c.setTime(date);
        }else{
            c.setTime(customer.getVipTime());
        }
        c.add(Calendar.DAY_OF_MONTH, 7);
        customer.setVipTime(c.getTime());
        int flag = customerService.updateVipTime(customer);
        if(flag>0){
            c.setTime(vipcustomer.getVipTime());
            c.add(Calendar.DAY_OF_MONTH, 7);
            vipcustomer.setVipTime(c.getTime());
            int flagt = customerService.updateVipTime(vipcustomer);
            if(flagt>0){
                resultUti.setCode(0);
                resultUti.setMsg("Vip领取成功");
            }else{
                resultUti.setCode(1);
                resultUti.setMsg("Vip领取失败");
            }
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("Vip领取失败");
        }
        return resultUti;
    }

    @RequestMapping("/SelectVip")
    @ResponseBody
    public ResultUtil SelectVip(String token) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        List<Vip> vip = customerService.GetVipList();
        if(vip.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(vip);
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("暂无数据");
        }
        return resultUti;
    }
    /**
     * 家长修改孩子电话
     *@参数  [token, android, Phone]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2019/1/23
     */
    @RequestMapping(value = "/updateChildPhone", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResultUtil updateChildPhone(String token,String android,String Phone) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        if(childService.updatePhone(android,Phone)>0){
            resultUti.setCode(0);
            resultUti.setMsg("修改成功");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("修改失败");
        }
        return resultUti;
    }

    @RequestMapping("/Feedback")
    @ResponseBody
    public ResultUtil Feedback(String token,String content) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        Feedback feedback =new Feedback();
        feedback.setFkCustomerId(customer.getPhone());
        feedback.setContent(content);
        feedback.setType("1");
        feedback.setCreateTime(new Date());
        customerService.addFeedback(feedback);
        resultUti.setCode(0);
        resultUti.setMsg("反馈成功");
        return resultUti;
    }

    @RequestMapping("/selectRegionTime")
    @ResponseBody
    public ResultUtil selectRegionTime(String token) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        List<Times> times=timeService.GetRegionTime(customer.getFkFamilyId());
        if (times.size()>0){
            resultUti.setMsg("查询成功");
            resultUti.setData(times);
            resultUti.setCode(0);
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("暂无数据");
        }
        return resultUti;
    }

    @RequestMapping("/deleteRegionTime")
    @ResponseBody
    public ResultUtil deleteRegionTime(String token,String timeId) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        int flag = timeService.deleteRegionTime(timeId);
        if (flag>0){
            resultUti.setMsg("删除成功");
            resultUti.setCode(0);
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("删除失败");
        }
        return resultUti;
    }

    /*@RequestMapping("/addRegionTime")
    @ResponseBody
    public ResultUtil addRegionTime(String token,String meter,String startTime,String endTime,String week,String name,String timeId) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        if(Integer.valueOf(startTime)>=Integer.valueOf(endTime)){
            resultUti.setCode(1);
            resultUti.setMsg("结束时间必须大于开始时间!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        List<Times> times=timeService.GetRegionTime(customer.getFkFamilyId());
        boolean res=true;
        if (times.size()>0){
            for(int i=0;i<times.size();i++){
                res = DateUtil.pdycsjcd(startTime,endTime,times.get(i).getStartetime(),times.get(i).getEndtime());
                if(res==false){
                    res=false;
                    break;
                }
            }
        }
        if(res==false){
            resultUti.setCode(1);
            resultUti.setMsg("区域时间重复！");
            return resultUti;
        }
        if(timeId.equals("")||timeId==null){
            int flag= timeService.addRegionTime(customer.getFkFamilyId(),meter,startTime,endTime,week,name);
            if(flag>0){
                resultUti.setCode(0);
                resultUti.setMsg("区域范围添加成功");
            }else{
                resultUti.setCode(1);
                resultUti.setMsg("区域范围添加失败");
            }
        }else{
            int flag= timeService.updateRegionTime(customer.getFkFamilyId(),meter,startTime,endTime,week,name,timeId);
            if(flag>0){
                resultUti.setCode(0);
                resultUti.setMsg("区域范围修改成功");
            }else{
                resultUti.setCode(1);
                resultUti.setMsg("区域范围修改失败");
            }
        }

        return resultUti;
    }*/

    @RequestMapping(value = "/GetEyeRemindTime", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResultUtil GetEyeRemindTime(String token) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        //Child child =childService.GetChildByAndroid(customer.getFkFamilyId());
        Map<String,String> map = timeService.GetEyeRemindTime(customer.getFkFamilyId());
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
    /**
     * 家长获取孩子的使用记录
     *@参数  [token]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/22
     */
    @RequestMapping(value = "/selectApplicationRecord", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResultUtil selectApplicationRecord(String token) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        List<AppRecordt> list= customerService.selectApplicationRecord(customer.getFkFamilyId());
        if(list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(list);
            return resultUti;
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("暂无数据");
            resultUti.setData(list);
            return resultUti;
        }
    }
    /**
     * 快速启动应用列表
     *@参数  [token, android]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/26
     */
    @RequestMapping("/ShowApplicationStart")
    @ResponseBody
    public ResultUtil ShowApplication( String token,String android) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        List<Application> list =customerService.selectApplicationTimeStart(android);
        if(list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(list);
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("暂无数据");
        }
        return resultUti;
    }

    public Customer GetCustomer(String token){
        Customer customer = customerService.GetCustomerByToken(token);
        return customer;
    }

    public boolean CheckToken(String token){
        boolean check = true;
        int flag = customerService.selectToken(token);
        if(flag!=1){
            check=false;
        }
        return check;
    }
}
