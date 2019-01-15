package com.BoeYu.controller;

import com.BoeYu.pojo.*;
import com.BoeYu.service.AdminService;
import com.BoeYu.service.CustomerService;
import com.BoeYu.service.PartnerService;
import com.BoeYu.util.ResultUtil;
import com.BoeYu.util.ShiroUtils;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

//城市合伙人
@Controller
@RequestMapping("partner")
public class PartnerController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PartnerService partnerService;

    @RequestMapping("/List")
    public String partnerList() {
        return "page/partner/adminList";
    }

    @RequestMapping("/getAdminList")
    @RequiresPermissions("partner:admin:list")
    @ResponseBody
    public ResultUtil getAdminList(Integer page,Integer limit) {
        ResultUtil admins = adminService.selpAdmins(page, limit);
        return admins;
    }
    @RequestMapping("/editAdmin/{id}")
    @RequiresPermissions("partner:admin:update")
    public String editAdmin(HttpServletRequest req,@PathVariable("id")Long id) {
        TbAdmin ad = adminService.selAdminById(id);
        List<TbRoles> roles = adminService.selRoles();
        req.setAttribute("ad",ad);
        req.setAttribute("roles", roles);
        return "page/partner/editAdmin";
    }


    @RequestMapping("/customerList")
    public String customerList() {
        return "page/partner/customerList";
    }

    @RequestMapping("/imgerweima")
    public String imgerweima(HttpServletRequest req) {
        TbAdmin admin = adminService.selAdminByUserName(req.getSession().getAttribute("username").toString());
        req.setAttribute("codeImg",admin.getCodeImg());
        return "page/partner/imgerweima";
    }
    @RequestMapping("/tixian")
    public String tixian(HttpServletRequest req) {
        TbAdmin admin = adminService.selAdminByUserName(req.getSession().getAttribute("username").toString());
        Account account  =adminService.selectAccount(admin.getPhone());
        req.setAttribute("money",account.getMoney());
        req.setAttribute("smoney",account.getSmoney());
        req.setAttribute("tmoney",account.getTmoney());
        return "page/partner/tixian";
    }

    @RequestMapping("/addtixian")
    @ResponseBody
    public ResultUtil addtixian(HttpServletRequest req,String yinhang,String zhanghu,String jine,String newsImg,
                                String newsImgt,String newsImgs,String dzjine) {
        ResultUtil resultUti = new ResultUtil();
        TbAdmin admin = adminService.selAdminByUserName(req.getSession().getAttribute("username").toString());
        if (partnerService.selectcashlog(admin.getPhone())>0){
            resultUti.setCode(1);
            resultUti.setMsg("已经有一笔提现正在审核，请勿重复提交！");
            return resultUti;
        }
        Cashlog cashlog = new Cashlog();
        cashlog.setZhanghu(zhanghu);
        cashlog.setBank(newsImgs);
        cashlog.setFkPartnerId(admin.getPhone());
        cashlog.setFlag("2");
        cashlog.setIdcardz(newsImg);
        cashlog.setIdcardf(newsImgt);
        cashlog.setMoney(jine);
        cashlog.setTmoney(dzjine);
        cashlog.setBankid(yinhang);
        cashlog.setNickname(admin.getFullname());
        int flag = partnerService.addcashlog(cashlog);
          if (flag>0){
              resultUti.setCode(0);
              resultUti.setMsg("提交成功");
          }else{
              resultUti.setCode(1);
              resultUti.setMsg("提交失败");
          }
        return resultUti;
    }

    @RequestMapping("/cashlog")
    public String carouselList() {
        return "page/partner/cashlog";
    }

    @RequestMapping("/admincashlog")
    public String admincashlog() {
        return "page/admin/cashlog";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultUtil getCarouseList(HttpServletRequest req,Integer page,Integer limit,PartnerSearch partnerSearch) {
        TbAdmin admin = adminService.selAdminByUserName(req.getSession().getAttribute("username").toString());
        if (admin.getFlag().equals("0")){
            ResultUtil cashlog = partnerService.selCashlog(page, limit,"admin",partnerSearch);
            return cashlog;
        }else{
            ResultUtil cashlog = partnerService.selCashlog(page, limit,admin.getPhone(),partnerSearch);
            return cashlog;
        }
    }

    @RequestMapping("/tupdate")
    @ResponseBody
    public ResultUtil tupdate(HttpServletRequest req,String id) {
        ResultUtil resultUti = new ResultUtil();
        TbAdmin admin = adminService.selAdminByUserName(req.getSession().getAttribute("username").toString());
        Cashlog cashlog = partnerService.selcashlog(Integer.valueOf(id));
        cashlog.setFlag("0");
        cashlog.setAdname(admin.getFullname());
        cashlog.setAdmsg("审核通过");
        if(partnerService.updatetcashlog(cashlog)>0){
           Account account = new Account();
            account.setFkPartnerId(cashlog.getFkPartnerId());
            account.setMoney(cashlog.getMoney());
            account.setTmoney(cashlog.getTmoney());
            if(partnerService.updateAccount(account)>0){
                resultUti.setCode(0);
                resultUti.setMsg("审核成功");
            }else{
                resultUti.setCode(1);
                resultUti.setMsg("审核失败");
            }
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("审核失败");
        }
        return resultUti;
    }

    @RequestMapping("/fupdate")
    @ResponseBody
    public ResultUtil fupdate(HttpServletRequest req,String id,String yijian) {
        ResultUtil resultUti = new ResultUtil();
        TbAdmin admin = adminService.selAdminByUserName(req.getSession().getAttribute("username").toString());
        Cashlog cashlog = partnerService.selcashlog(Integer.valueOf(id));
        cashlog.setFlag("1");
        cashlog.setAdname(admin.getFullname());
        cashlog.setAdmsg(yijian);
        if(partnerService.updatetcashlog(cashlog)>0){
                resultUti.setCode(0);
                resultUti.setMsg("审核成功");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("审核失败");
        }
        return resultUti;
    }

    @RequestMapping("/getCustomerList")
    @ResponseBody
    public ResultUtil customerList(HttpServletRequest req,Integer page,Integer limit,UserSearch search) {
        TbAdmin admin = adminService.selAdminByUserName(req.getSession().getAttribute("username").toString());
        search.setPartnerId(admin.getPhone());
        ResultUtil admins = customerService.selCustomer(page, limit,search);
        return admins;
    }

    @RequestMapping("/index")
    public String partner(HttpServletRequest req) {
        return "partner";
    }

    @RequestMapping(value = "/register", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResultUtil register(String username,String password,String vcode) {
        ResultUtil resultUti = new ResultUtil();
        if(!vcode.toLowerCase().equals(ShiroUtils.getKaptcha("kaptcha").toLowerCase())){
            resultUti.setMsg("验证码不正确");
            return resultUti;
        }
        if(adminService.checkphone(username)>0){
            resultUti.setCode(1);
            resultUti.setMsg("手机号码已经注册");
            return resultUti;
        }
        TbAdmin admin = new TbAdmin();
        //生成二维码，未发布所以无法生成
        String token  = getAccessToken();
        if (token.equals("errer")){
            resultUti.setCode(1);



            resultUti.setMsg("注册失败");
            return resultUti;
        }
        try
        {
            URL url = new URL("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+token);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
            JSONObject paramJson = new JSONObject();
            paramJson.put("scene", username);
            paramJson.put("page", "pages/login/logins");
            paramJson.put("width", 430);
            paramJson.put("auto_color", true);
            printWriter.write(paramJson.toString());
            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            OutputStream os = new FileOutputStream(new File("D:/upload/"+username+".png"));
            int len;
            byte[] arr = new byte[1024];
            while ((len = bis.read(arr)) != -1)
            {
                os.write(arr, 0, len);
                os.flush();
            }
            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        admin.setPhone(username);
        admin.setUsername(username);
        admin.setFullname(username);
        admin.setRoleId((long)3);
        admin.setSex("1");
        admin.setPassword(password);
        admin.setCodeImg(username+".png");
        admin.setFlag("2");
        if(adminService.addPartnerAdmin(admin)>0){
            Account account = new Account();
            account.setFkPartnerId(username);
            account.setTmoney("0");
            account.setMoney("0");
            account.setSmoney("0");
            adminService.addAccount(account);
            resultUti.setCode(0);
            resultUti.setMsg("注册成功");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("注册失败");
        }
        return resultUti;
    }

    public String getAccessToken(){
        try {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxd7d2ddda96ee9dda&secret=407f43b298dd0ada25b22312362c23d3";
            URL getUrl=new URL(url);
            HttpURLConnection http=(HttpURLConnection)getUrl.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] b = new byte[size];
            is.read(b);
            String message = new String(b, "UTF-8");
            JSONObject json = JSONObject.fromObject(message);
            return json.getString("access_token");
        } catch (Exception e) {
            return "errer";
        }
    }
}
