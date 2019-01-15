package com.BoeYu.child;

import com.BoeYu.pojo.*;
import com.BoeYu.service.ChildService;
import com.BoeYu.service.CustomerService;
import com.BoeYu.service.SafeUrlService;
import com.BoeYu.service.TimeService;
import com.BoeYu.util.GlobalUtil;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/Coordinate", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResultUtil Coordinate(String android, String Coordinate) {
        ResultUtil resultUti = new ResultUtil();
        if(android==null){
            return resultUti;
        }
        if(Coordinate==null){
            return resultUti;
        }
        Child child =GetChild(android);
        int flag = childService.insertCoordinate(child,Coordinate);
        //判断 是不是安全范围
        if (flag>0){
           if(timeService.CheckRegion(android,Coordinate)>0){
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

    @RequestMapping(value = "/SelectConfidantnumber", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResultUtil SelectConfidantnumber(String android) {
        ResultUtil resultUti = new ResultUtil();
        Child child =GetChild(android);
        List<Confidantnumber> list =childService.SelectConfidantnumber(android);
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

    @RequestMapping(value = "/SelectSafeChild", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResultUtil SelectSafeChild(String android,String type){
        ResultUtil resultUti=new ResultUtil();
        Child child =GetChild(android);
        List<SafeUrl> list = new ArrayList<SafeUrl>();
        if(type.equals("0")||type.equals("1")){
            list  = safeUrlService.SelectSafeUrl(child.getAndroid(),type);
        }else if(type.equals("2")){
            list  = safeUrlService.SelectSafeUrl(child.getAndroid(),"2");
        }else if(type.equals("3")){
            list  = safeUrlService.SelectSafeUrll(child.getAndroid());
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
            resultUti.setCode(0);
            resultUti.setMsg("暂无数据");
            return resultUti;
        }
    }
    /**
     * 孩子端获取应用列表及当天的应用时间
     *@参数  [android]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/15
     */
    @RequestMapping(value = "/ShowApplication", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResultUtil ShowApplication(String android) {
        ResultUtil resultUti = new ResultUtil();
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
     * 上传应用接口
     *@参数  [android, applicationId, appUpdatetime, applicationName, file, req]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/13
     */

    @RequestMapping(value = "/UploadApplication",method = { RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public ResultUtil UploadApplication(String android,String applicationType,String applicationId,String appUpdatetime,String applicationName, MultipartFile file, HttpServletRequest req) {
        if (file == null) {
            return ResultUtil.error("文件不能为空！");
        }
        ResultUtil resultUti=new ResultUtil();
        Child child = GetChild(android);
        Application application = new Application();
       /* String fileSub = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."))
                .toLowerCase();*/
        //if (".jpg".equals(fileSub) || ".jpeg".equals(fileSub) || ".png".equals(fileSub) || ".gif".equals(fileSub)||".mp3".equals(fileSub)) {
            Random d = new Random();
            String img = UUID.randomUUID().toString().replace("-", "") + d.nextInt(10000) + "."+file.getOriginalFilename() ;
            try {
                File f=new File(GlobalUtil.getValue("upfile.path"));
                if(!f.exists()){
                    f.mkdirs();
                }
                file.transferTo(new File(f, img));
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            application.setApplicationId(applicationId);
            application.setFkChildId(android);
            application.setApplicationName(applicationName);
            application.setAppUpdatetime(appUpdatetime);
            application.setApplicationImg(img);

            int addorupdate =childService.selectApplication(android,applicationId);
            if(addorupdate>0){
                int flag= childService.updateApplication(application);
                if (flag>0){
                    resultUti.setCode(0);
                    resultUti.setMsg("应用修改成功");
                }else {
                    resultUti.setCode(1);
                    resultUti.setMsg("应用修改失败");
                }
            }else{
                application.setCreatetime(new Date());
                application.setApplicationType(applicationType);
                application.setLockType("1");
                int flag= childService.addApplication(application);
                if (flag>0){
                    resultUti.setCode(0);
                    resultUti.setMsg("应用上传成功");
                }else {
                    resultUti.setCode(1);
                    resultUti.setMsg("应用上传失败");
                }
            }
            return resultUti;
//        } else {
//            return ResultUtil.error("文件格式不支持,请重新选择！");
//        }
    }


    /**
     * 卸载应用删除应用列表接口
     *@参数  [android, applicationId]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/13
     */
    @RequestMapping(value = "/DeleteApplication", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResultUtil deleteapplication(String android,String applicationId){
        ResultUtil resultUti=new ResultUtil();
        Child child =GetChild(android);
        int flag =childService.selectApplication(android,applicationId);
        if (flag>0){
            int deflag =childService.deleteApplication(android,applicationId);
            if(deflag>0){
                resultUti.setCode(0);
                resultUti.setMsg("删除成功");
            }else{
                resultUti.setCode(1);
                resultUti.setMsg("删除失败");
            }
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("删除成功");
        }
        return resultUti;
    }


    @RequestMapping(value = "/SetApplicationRecord", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResultUtil SetApplicationRecord(String android,String applicationId,String time,String recordTime) {
        ResultUtil resultUti = new ResultUtil();
        int flag = childService.addApplicationRecord(applicationId,time,recordTime);
        if(flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("上传成功");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("上传失败");
        }
        return resultUti;
    }

    public Child GetChild(String android){
        Child child =childService.GetChildByAndroid(android);
        return child;
    }

}
