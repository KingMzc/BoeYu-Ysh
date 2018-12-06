package com.BoeYu.parent;

import com.BoeYu.pojo.AppRecord;
import com.BoeYu.pojo.Customer;
import com.BoeYu.pojo.Times;
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
    @RequestMapping("/SetLockTime")
    @ResponseBody
    public ResultUtil LockChild( String token,String times,String childId,String week,String type,String flag){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        int check = timeService.CheckWeek(childId,week);
        Times time =timeService.GetTimes(childId,week);
        List<Integer> list = GetTimes(times);
        int xhcs = 0;
        int crcs = 0;
        if(check>0){
            for (int i = 0; i < list.size(); i++) {
                if(i==0){
                    xhcs++;
                    int bz = timeService.updateTime(time.getId(),list.get(i).toString(),(list.get(i+1)+1)+"",times,childId,week,type,flag);
                    crcs = crcs+bz;
                }else if(i==1){
                }else if(i%2==0){
                    xhcs++;
                    int bz =timeService.updateTime(time.getId(),list.get(i).toString(),(list.get(i+1)+1)+"",times,childId,week,type,flag);
                    crcs = crcs+bz;
                }
            }
        }else{
            for (int i = 0; i < list.size(); i++) {
                if(i==0){
                    xhcs++;
                    // System.out.println(list.get(i) + "-"+(list.get(i+1)+1));
                    int bz = timeService.addTime(list.get(i).toString(),(list.get(i+1)+1)+"",times,childId,week,type,flag);
                    crcs = crcs+bz;
                }else if(i==1){
                }else if(i%2==0){
                    xhcs++;
                    // System.out.println(list.get(i) + "-"+(list.get(i+1)+1));
                    int bz =timeService.addTime(list.get(i).toString(),(list.get(i+1)+1)+"",times,childId,week,type,flag);
                    crcs = crcs+bz;
                }
            }
        }
        if(xhcs==crcs){
            resultUti.setCode(0);
            resultUti.setMsg("设置成功！");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("设置失败！");
        }
        return resultUti;
    }
    @RequestMapping("/ShowLockTime")
    @ResponseBody
    public ResultUtil ShowLockTime( String token,String childId,String week,String type,String flag) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        String times = timeService.ShowLockTime(childId,week,type,flag);
        if(times!=""||times!=null){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(times);
        }else{
            resultUti.setCode(1);
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
            resultUti.setCode(1);
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
