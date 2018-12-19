package com.BoeYu.parent;

import com.BoeYu.pojo.*;
import com.BoeYu.service.ChildService;
import com.BoeYu.service.CustomerService;
import com.BoeYu.service.SafeUrlService;
import com.BoeYu.util.DateUtil;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("Api/parent")
public class SafeController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SafeUrlService safeUrlService;
    @Autowired
    private ChildService childService;
    @RequestMapping("/SafeChildUrl")
    @ResponseBody
    public ResultUtil SafeChildUrl(String token,String url ,String type){
        String md ="";
        if (type.equals("0")){
            md="白名单";
        }else if(type.equals("1")){
            md="黑名单";
        }else{
            md="关键字";
        }
        Customer customer = GetCustomer(token);
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        if(customerService.CheckChild(customer.getFkFamilyId())<=0){
            resultUti.setCode(1);
            resultUti.setMsg("没有找到这个孩子！");
            return resultUti;
        }

        if(customerService.CheckChildIsCustomer(customer.getPhone(),customer.getFkFamilyId())<=0){
            resultUti.setCode(1);
            resultUti.setMsg("没有权限设置这个孩子的"+md+"!");
            return resultUti;
        }
        SafeUrl safeUrl = new SafeUrl();
        Date date=new Date();
        safeUrl.setSafeContent(url);
        safeUrl.setFkChildId(customer.getFkFamilyId());
        safeUrl.setFkCustomerId(customer.getId().toString());
        safeUrl.setSafeType(type);
        safeUrl.setCreateTime(date);
        int flag = safeUrlService.insert(safeUrl);
        if(flag>0){
            resultUti.setCode(0);
            resultUti.setMsg(md+"设置成功");
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg(md+"设置失败");
            return resultUti;
        }
    }

    @RequestMapping("/SelectSafeChild")
    @ResponseBody
    public ResultUtil SelectSafeChild(String token, String type){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        List<SafeUrl> list  = safeUrlService.SelectSafeUrl(customer.getFkFamilyId(),type);
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

    @RequestMapping("/deleteSafeChild")
    @ResponseBody
    public ResultUtil deleteSafeChild(String token, String id){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        int flag = safeUrlService.delteteSafeUrl(Integer.valueOf(id));
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("删除成功");
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("删除失败");
            return resultUti;
        }
    }

    @RequestMapping("/SetSafeChildUrl")
    @ResponseBody
    public ResultUtil SetSafeChildUrl(String token,String type){
        ResultUtil resultUti=new ResultUtil();
        String md ="";
        if (type.equals("0")){
            md="白名单";
        }else if(type.equals("1")){
            md="黑名单";
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("未知参数! ");
            return resultUti;
        }
        Customer customer = GetCustomer(token);

        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        if(customerService.CheckChild(customer.getFkFamilyId())<=0){
            resultUti.setCode(1);
            resultUti.setMsg("没有找到这个孩子！");
            return resultUti;
        }
        if(customerService.CheckChildIsCustomer(customer.getPhone(),customer.getFkFamilyId())<=0){
            resultUti.setCode(1);
            resultUti.setMsg("没有权限设置这个孩子的"+md+"!");
            return resultUti;
        }
        int flag = childService.updateFlag(customer.getFkFamilyId(),type);
        if(flag>0){
            resultUti.setCode(0);
            resultUti.setMsg(md+"启用成功");
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg(md+"启用失败");
            return resultUti;
        }
    }
    /**
     * 第一次进入安全区域 默认两个安全区域
     *@参数  [token, coordinate]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/18
     */
    @RequestMapping("/Region")
    @ResponseBody
    public ResultUtil Region(String token,String coordinate){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        int flag = safeUrlService.CheckRegion(customer.getFkFamilyId());
        if (flag>=2){
        }else{
            safeUrlService.deleteRegion(customer.getFkFamilyId());
            safeUrlService.addRegion(customer.getFkFamilyId(),coordinate);
        }
        List<Region> list =safeUrlService.SelectRegions(customer.getFkFamilyId());
        if (list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(list);
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("暂无数据");
        }
        return resultUti;
    }
    /**
     * 添加新的安全区域
     *@参数  [token, coordinate, name]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/18
     */
    @RequestMapping("/AddRegion")
    @ResponseBody
    public ResultUtil AddRegion(String token,String coordinate,String name){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        int flag = safeUrlService.CheckRegion(customer.getFkFamilyId());
        if (flag>5){
            resultUti.setCode(1);
            resultUti.setMsg("最多可添加5个安全区域");
            return resultUti;
        }else{
            int flagt=safeUrlService.addNewRegion(customer.getFkFamilyId(),name,coordinate);
            if (flagt>=7){
                resultUti.setCode(0);
                resultUti.setMsg("添加成功");
            }else{
                resultUti.setCode(1);
                resultUti.setMsg("添加失败");
            }
        }
        return resultUti;
    }
    /**
     * 删除安全区域
     *@参数  [token, regionId]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/18
     */
    @RequestMapping("/DeleteRegion")
    @ResponseBody
    public ResultUtil DeleteRegion(String token,String regionId){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        int flag = safeUrlService.deleteRegionByID(regionId);
        if (flag>0){
            if(safeUrlService.deleteRegionTime(regionId)>0){
                resultUti.setCode(0);
                resultUti.setMsg("删除成功");
            }else{
                resultUti.setCode(1);
                resultUti.setMsg("删除失败");
            }
        }else{
                resultUti.setCode(1);
                resultUti.setMsg("删除失败");
        }
        return resultUti;
    }
    /**
     * 展示选择安全区域基本信息
     *@参数  [token, regionId]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/18
     */
    @RequestMapping("/SelectRegion")
    @ResponseBody
    public ResultUtil SelectRegion(String token,String regionId){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        Region region = safeUrlService.SelectRegion(regionId);
        if (region!=null){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(region);
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("暂无数据");
        }
        return resultUti;
    }
    /**
     * 查询选择安全区域的时间
     *@参数  [token, regionId]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/18
     */
    @RequestMapping("/SelectRegionTime")
    @ResponseBody
    public ResultUtil SelectRegionTime(String token,String regionId){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        List<RegionTime> list = safeUrlService.SelectRegionTime(regionId);
        if (list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(list);
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("暂无数据");
        }
        return resultUti;
    }
    /**
     * 修改安全区域的坐标
     *@参数  [token, coordinate, regionId]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/18
     */
    @RequestMapping("/UpdateRegionCoordinate")
    @ResponseBody
    public ResultUtil UpdateRegionCoordinate(String token,String coordinate,String regionId){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        int flag = safeUrlService.UpdateRegionCoordinate(regionId,coordinate);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("坐标修改成功");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("坐标修改失败");
        }
        return resultUti;
    }
    /**
     * 修改安全区域的范围
     *@参数  [token, mater, regionId]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/18
     */
    @RequestMapping("/UpdateRegionMater")
    @ResponseBody
    public ResultUtil UpdateRegionMater(String token,String mater,String regionId){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        int flag = safeUrlService.UpdateRegionMater(regionId,mater);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("范围修改成功");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("范围修改失败");
        }
        return resultUti;
    }
    /**
     * 修改安全区域的名称
     *@参数  [token, name, regionId]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/18
     */
    @RequestMapping("/UpdateRegionName")
    @ResponseBody
    public ResultUtil UpdateRegionName(String token,String name,String regionId){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        int flag = safeUrlService.UpdateRegionName(regionId,name);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("名称修改成功");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("名称修改失败");
        }
        return resultUti;
    }
    /**
     * 修改安全区域的时间
     *@参数  [token, regionId, week, startTime, endTime]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/18
     */
    @RequestMapping("/UpdateRegionTimes")
    @ResponseBody
    public ResultUtil UpdateRegionTimes(String token,String android,String regionId,String week,String startTime,String endTime){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        boolean time=true;
        List<RegionTimes> list = safeUrlService.SelectRegionBychildId(android,week);
        if (list.size()>0){
            for(int i=0;i<list.size();i++){
                if (list.get(i).getStarttime().equals("")||list.get(i).getEndtime().equals("")){
                }else{
                    if (DateUtil.pdycsjcd(startTime,endTime,list.get(i).getStarttime(),list.get(i).getEndtime())==true){
                        time=true;
                    }else{
                        time=false;
                        break;
                    }
                }
            }
        }
        if(time==false){
            resultUti.setCode(1);
            resultUti.setMsg("时间重叠！请重新选择时间。");
            return resultUti;
        }
        int flag = safeUrlService.UpdateRegionTimes(regionId,week,startTime,endTime);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("时间修改成功");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("时间修改失败");
        }
        return resultUti;
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
