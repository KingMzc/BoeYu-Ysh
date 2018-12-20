package com.BoeYu.parent;

import com.BoeYu.pojo.*;
import com.BoeYu.service.AppTypeService;
import com.BoeYu.service.CustomerService;
import com.BoeYu.service.TimeService;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("Api/parent")
public class LockController {
    @Autowired
    private TimeService timeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AppTypeService appTypeService;
    /**
     * 设置锁屏时间
     *@参数  [token, times, android, week]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/15
     */
    @RequestMapping("/SetLockTime")
    @ResponseBody
    public ResultUtil LockChildTime( String token,String times,String android,String week){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        ApplicationTimes applicationTimes = new ApplicationTimes();
        applicationTimes.setFkApplicationId(android);
        applicationTimes.setTimes(times);
        applicationTimes.setWeek(week);
        applicationTimes.setFlag("1");
        if(timeService.selectAppLockTime(android,week)>0){
            if(timeService.updateAppLockTime(applicationTimes)>0){
                resultUti.setMsg("锁屏时间修改成功");
                resultUti.setCode(0);
            }else{
                resultUti.setMsg("锁屏时间修改失败");
                resultUti.setCode(1);
            }
        }else{
            if(timeService.addAppLockTime(applicationTimes)>0){
                resultUti.setMsg("锁屏时间设置成功");
                resultUti.setCode(0);
            }else{
                resultUti.setMsg("锁屏时间设置失败");
                resultUti.setCode(1);
            }
        }
        return resultUti;
    }
    /**
     * 设置应用的时间
     *@参数  [token, times, id, week]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/15
     */
    @RequestMapping("/SetApplicationTime")
    @ResponseBody
    public ResultUtil SetApplicationTime( String token,String times,String id,String week){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        ApplicationTimes applicationTimes = new ApplicationTimes();
        applicationTimes.setFkApplicationId(id);
        applicationTimes.setTimes(times);
        applicationTimes.setWeek(week);
        applicationTimes.setFlag("0");
        if(timeService.selectAppLockTime(id,week)>0){
            if(timeService.updateAppLockTime(applicationTimes)>0){
                resultUti.setMsg("锁屏时间修改成功");
                resultUti.setCode(0);
            }else{
                resultUti.setMsg("锁屏时间修改失败");
                resultUti.setCode(1);
            }
        }else{
            if(timeService.addAppLockTime(applicationTimes)>0){
                resultUti.setMsg("锁屏时间设置成功");
                resultUti.setCode(0);
            }else{
                resultUti.setMsg("锁屏时间设置失败");
                resultUti.setCode(1);
            }
        }
        return resultUti;
    }
    /**
     * 设置应用的状态
     *@参数  [token, android, appId, applicationType]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/14
     */
    @RequestMapping("/SetAppType")
    @ResponseBody
    public ResultUtil updateAppType( String token,String android,String id,String applicationType){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Application application = new Application();
        application.setFkChildId(android);
        application.setApplicationId(id);
        application.setApplicationType(applicationType);
        if(customerService.updateAppType(application)>0){
            resultUti.setMsg("设置成功");
            resultUti.setCode(0);
        }else{
            resultUti.setMsg("设置失败");
            resultUti.setCode(1);
        }
        return resultUti;
    }
    /**
     * 设置锁屏应用
     *@参数  [token, android, appId, lockType]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/14
     */
    @RequestMapping("/SetLockApp")
    @ResponseBody
    public ResultUtil updateLockApp( String token,String android,String id,String lockType){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Application application = new Application();
        application.setFkChildId(android);
        application.setApplicationId(id);
        application.setLockType(lockType);
        if(customerService.updateLockApp(application)>0){
            resultUti.setMsg("设置成功");
            resultUti.setCode(0);
        }else{
            resultUti.setMsg("设置失败");
            resultUti.setCode(1);
        }
        return resultUti;
    }

    /**
     * 家长端获取应用列表和锁定时间
     *@参数  [token, android]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/14
     */
    @RequestMapping("/ShowApplication")
    @ResponseBody
    public ResultUtil ShowApplication( String token,String android) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        List<ApplicationTime> list =customerService.selectApplicationTimes(android);
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
    /**
     * 家长获取孩子的锁屏时间
     *@参数  [token, android]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/15
     */
    @RequestMapping("/ShowLockTimeParent")
    @ResponseBody
    public ResultUtil ShowLockTimeParent( String token,String android) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        List<ApplicationTimes> list =timeService.ShowLockTimep(android);
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


    @RequestMapping("/EyeRemind")
    @ResponseBody
    public ResultUtil EyeRemind(String token,String remindtime,String resttime){
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        if(timeService.CheckRemindTime(customer.getFkFamilyId())>0){
            Times times = timeService.GetRemindTime(customer.getFkFamilyId());
            int flag = timeService.updateRemindTime(times.getId(),remindtime,resttime);
            if(flag>0){
                resultUti.setCode(0);
                resultUti.setMsg("护眼时间修改成功");
                return resultUti;
            }else{
                resultUti.setCode(1);
                resultUti.setMsg("护眼时间修改失败");
                return resultUti;
            }
        }else{
            int flag = timeService.addRemindTime(customer.getFkFamilyId(),remindtime,resttime);
            if(flag>0){
                resultUti.setCode(0);
                resultUti.setMsg("护眼时间添加成功");
                return resultUti;
            }else{
                resultUti.setCode(1);
                resultUti.setMsg("护眼时间添加失败");
                return resultUti;
            }
        }
    }

    @RequestMapping("/DeleteEyeRemind")
    @ResponseBody
    public ResultUtil DeleteEyeRemind(String token){
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        int flag = timeService.deleteRemindTime(customer.getFkFamilyId());
        if(flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("护眼提醒关闭成功!");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("护眼提醒关闭失败!");
        }
        return resultUti;
    }

    @RequestMapping("/GetAppType")
    @ResponseBody
    public ResultUtil GetAppType(String token){
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        List<AppRecord> list =appTypeService.GetAppType(customer.getFkFamilyId());
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

    @RequestMapping("/updateAppType")
    @ResponseBody
    public ResultUtil updateAppType(String token,String id,String type){
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        int flag = appTypeService.updateAppType(id,type);
        if(flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("修改成功");
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("修改失败");
            return resultUti;
        }
    }

    public List<Integer> GetTimes(String times){
        String time = times.replace(" ","");
        String[] datas = time.split(",");
        int[] data = new int[datas.length];
        for(int i=0;i<datas.length;i++){
            data[i] = Integer.parseInt(datas[i]);
        }
        int size = data.length;
        int curr = -1;
        int next = -1;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            curr = data[i];
            if (i == 0) {
                list.add(curr);//第一个元素
            }
            if ((i + 1) == size) {
                list.add(data[i]);//最后一个元素
                break;
            }
            next = data[i + 1];
            if (Math.abs((curr - next)) == 1) {
            } else {
                list.add(curr);
                list.add(next);
            }
        }
        return list;
    }


    public boolean CheckToken(String token){
        boolean check = true;
        int flag = customerService.selectToken(token);
        if(flag!=1){
            check=false;
        }
        return check;
    }


    public Customer GetCustomer(String token){
        Customer customer = customerService.GetCustomerByToken(token);
        return customer;
    }


}
