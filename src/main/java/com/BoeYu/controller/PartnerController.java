package com.BoeYu.controller;

import com.BoeYu.pojo.*;
import com.BoeYu.service.AdminService;
import com.BoeYu.service.CustomerService;
import com.BoeYu.service.PartnerService;
import com.BoeYu.util.*;
import net.sf.json.JSONObject;
import org.bouncycastle.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.spec.AlgorithmParameterSpec;
import java.util.*;

import static org.apache.poi.util.StringUtil.UTF8;

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

    private static String session_key="";

    private static String openid="";


    /**
     * 第一次登录
     *@参数  [request, encrypdata, ivdata, code, address]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2019/1/22
     */
    @RequestMapping("/flogin")
    @ResponseBody
    public ResultUtil FLogin(HttpServletRequest request,String encrypdata,String ivdata,String code,String address ) throws Exception {
        ResultUtil resultUti=new ResultUtil();
        if (encrypdata==null||encrypdata.length()<=0||ivdata==null||ivdata.length()<=0||code==null||code.length()<=0){
            resultUti.setCode(1);
            resultUti.setMsg("参数为空！");
            return resultUti;
        }else{
            if(Checkcode(code).length()<=0){
                resultUti.setCode(1);
                resultUti.setMsg("code为无效参数！");
                return resultUti;
            }
            String phone = GetwxPhone(encrypdata,ivdata);
            if(phone.contains("*")||phone==null||phone.length()<=0){
                resultUti.setCode(2);
                resultUti.setMsg("请升级最新版的微信！");
                return resultUti;
            }
            if(partnerService.selectPhone(phone)>0){
                if (partnerService.selectPhonewx(phone,openid)>0){
                    Map<String,Object> map=partnerService.loginInfo(phone,openid);
                   // TbAdmin tbAdmin =(TbAdmin)map.get("Admin");
                   // request.getSession().setAttribute("customerid",customer.getPhone());
                    Map<String,String > mp= MapWxidPhone.getMap();
                    if(mp==null){
                        mp =new HashMap<String,String>();
                    }
                    mp.put(phone,openid);
                    resultUti.setCode(0);
                    resultUti.setMsg("登录成功");
                    resultUti.setData(map);
                    return resultUti;
                }else{
                    partnerService.updateWxid(phone,openid);
                    Map<String,Object> map=partnerService.loginInfo(phone,openid);
                    Map<String,String > mp= MapWxidPhone.getMap();
                    if(mp==null){
                        mp =new HashMap<String,String>();
                    }
                    mp.put(phone,openid);
                    resultUti.setCode(0);
                    resultUti.setMsg("登录成功");
                    resultUti.setData(map);
                    return resultUti;
                }
            }else{
                TbAdmin tbAdmin =new TbAdmin();
                if(address==null){
                }else{
                    if (address.length()>0){
                        tbAdmin.setAddress(address);
                    }
                }
                tbAdmin.setPhone(phone);
                tbAdmin.setWxid(openid);
                tbAdmin.setPassword("e10adc3949ba59abbe56e057f20f883e");
                tbAdmin.setSex("");
                tbAdmin.setUsername(phone);
                tbAdmin.setFullname(phone);
                tbAdmin.setFlag(adminService.selDictionaryval("check"));
                String token  = getAccessToken();
                if (token.equals("errer")){
                    tbAdmin.setCodeImg("");
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
                    paramJson.put("scene", phone);
                    paramJson.put("page", "pages/login/logins");
                    paramJson.put("width", 430);
                    paramJson.put("auto_color", true);
                    printWriter.write(paramJson.toString());
                    // flush输出流的缓冲
                    printWriter.flush();
                    //开始获取数据
                    BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
                    OutputStream os = new FileOutputStream(new File("D:/upload/"+phone+".png"));
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
                    tbAdmin.setCodeImg("");
                }
                tbAdmin.setRoleId((long)3);
                tbAdmin.setCodeImg(phone+".png");
                if(adminService.addPartnerAdmin(tbAdmin)>0){
                    Account account = new Account();
                    account.setFkPartnerId(phone);
                    account.setTmoney("0");
                    account.setMoney("0");
                    account.setSmoney("0");
                    adminService.addAccount(account);
                }
                partnerService.addAdmin(tbAdmin);
                Map<String,Object> map=partnerService.loginInfo(phone,openid);
                Map<String,String > mp= MapWxidPhone.getMap();
                if(mp==null){
                    mp =new HashMap<String,String>();
                }
                mp.put(phone,openid);
                //request.getSession().setAttribute("customerid",customer.getPhone());
                resultUti.setCode(0);
                resultUti.setMsg("登录成功");
                resultUti.setData(map);
                return resultUti;
            }
        }
    }

    /**
     *@参数  [request, phone, wxid]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2019/1/22
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultUtil Login(HttpServletRequest request,String phone,String wxid){
        ResultUtil resultUti=new ResultUtil();
        if (phone==null||phone.length()<=0||wxid==null||wxid.length()<=0){
            resultUti.setCode(1);
            resultUti.setMsg("手机号码微信号码为空");
            return resultUti;
        }else{
            if(partnerService.selectPhone(phone)>0){
                if (partnerService.selectPhonewx(phone,wxid)>0){
                    Map<String,Object> map=partnerService.loginInfo(phone,wxid);
                    Map<String,String > mp= MapWxidPhone.getMap();
                    if(mp==null){
                        mp =new HashMap<String,String>();
                    }
                    mp.put(phone,wxid);
                    resultUti.setCode(0);
                    resultUti.setMsg("登录成功");
                    resultUti.setData(map);
                    return resultUti;
                }else{
                    resultUti.setCode(1);
                    resultUti.setMsg("手机号码微信号码不匹配！");
                    return resultUti;
                }
            }else{
                resultUti.setCode(1);
                resultUti.setMsg("手机号码未注册");
                return resultUti;
            }
        }
    }
    /**
     *@参数  [token, id]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2019/1/22
     */
    @RequestMapping("/deleteBank")
    @ResponseBody
    public ResultUtil deleteBank(String token, String id){
        ResultUtil resultUti=new ResultUtil();
        if(CheckAdminToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        if (partnerService.deleteBank(id)>0){
            resultUti.setCode(0);
            resultUti.setMsg("删除成功");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("删除失败");
        }
        return resultUti;
    }

    /**
     *@参数  [token]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2019/1/24
     */
    @RequestMapping("/GetPartnerInfo")
    @ResponseBody
    public ResultUtil GetPartnerInfo(String token){
        ResultUtil resultUti=new ResultUtil();
        if(CheckAdminToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        TbAdmin tbAdmin = adminService.selAdminByToken(token);
        if (tbAdmin!=null){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(tbAdmin);
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("暂无数据");
        }
        return resultUti;
    }

    /**
     *@参数  [token, phone]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2019/1/24
     */
    @RequestMapping("/GetPartnerAccount")
    @ResponseBody
    public ResultUtil GetPartnerIfo(String token,String phone){
        ResultUtil resultUti=new ResultUtil();
        if(CheckAdminToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        Map<String,Object> map=partnerService.partnerInfo(phone);
        if (map!=null){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(map);
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("暂无数据");
        }
        return resultUti;
    }

    /**
     *@参数  [token, file, BankId, BankName]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2019/1/22
     */
    @RequestMapping("/addBankId")
    @ResponseBody
    public ResultUtil addBankId(String token, MultipartFile file, String BankId, String BankName){
        ResultUtil resultUti=new ResultUtil();
        if(CheckAdminToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        if (file == null) {
            resultUti.setCode(1);
            resultUti.setMsg("文件不能为空! ");
            return resultUti;
        }
            String img = MyUtil.shangchuan(file);
        if (img.equals("")){
            resultUti.setCode(1);
            resultUti.setMsg("文件上传失败");
            return resultUti;
        }
            Adminbank adminbank = new Adminbank();
            adminbank.setBankimg(img);
            adminbank.setBankid(BankId);
            adminbank.setBankname(BankName);
            adminbank.setFkAdminId(GetAdmin(token).getPhone());
            adminbank.setCreatetime(new Date());
            if(partnerService.addBankId(adminbank)>0){
                resultUti.setCode(0);
                resultUti.setMsg("新增成功");
            }else {
                resultUti.setCode(1);
                resultUti.setMsg("新增失败");
            }
        return resultUti;
    }
    /**
     *@参数  [token, filez, filef, sfzhm, name]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2019/1/22
     */
    @RequestMapping("/addIdCard")
    @ResponseBody
    public ResultUtil addIdCard(String token, String filez,String filef,String sfzhm, String name){
        ResultUtil resultUti=new ResultUtil();
        if(CheckAdminToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        TbAdmin tbAdmin = new TbAdmin();
        tbAdmin.setFullname(name);
        tbAdmin.setIdcardz(filez);
        tbAdmin.setIdcardf(filef);
        tbAdmin.setSfzhm(sfzhm);
        tbAdmin.setPhone(GetAdmin(token).getPhone());
        if(partnerService.updateAdmin(tbAdmin)>0){
            resultUti.setCode(0);
            resultUti.setMsg("身份修改成功");
        }else {
            resultUti.setCode(1);
            resultUti.setMsg("身份修改失败");
        }
        return resultUti;
    }
    /**
     *@参数  [token, time]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2019/1/22
     */
    @RequestMapping("/cashlogList")
    @ResponseBody
    public ResultUtil cashlogList(String token, String time){
        ResultUtil resultUti=new ResultUtil();
        if(CheckAdminToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        List<cashList> list = partnerService.selcashlist(GetAdmin(token).getPhone(),time);
        if (list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(list);
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("暂无数据 ");
        }
        return resultUti;
    }
    /**
     *@参数  [token]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2019/1/22
     */
    @RequestMapping("/getBankList")
    @ResponseBody
    public ResultUtil getBankList(String token){
        ResultUtil resultUti=new ResultUtil();
        if(CheckAdminToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        List<Adminbank> list = partnerService.selBankList(GetAdmin(token).getPhone());
        if (list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(list);
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("暂无数据 ");
        }
        return resultUti;
    }

    @RequestMapping("/Feedback")
    @ResponseBody
    public ResultUtil Feedback(String token,String content) {
        ResultUtil resultUti = new ResultUtil();
        if(CheckAdminToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        TbAdmin tbAdmin = GetAdmin(token);
        Feedback feedback =new Feedback();
        feedback.setFkCustomerId(tbAdmin.getPhone());
        feedback.setContent(content);
        feedback.setType("0");
        feedback.setCreateTime(new Date());
        customerService.addFeedback(feedback);
        resultUti.setCode(0);
        resultUti.setMsg("反馈成功");
        return resultUti;
    }

    /**
     *@参数  [token, idcardz, idcardf, bank, zhanghu, bankid, money, tmoney]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2019/1/22
     */
    @RequestMapping("/GetMoney")
    @ResponseBody
    public ResultUtil GetMoney(String token, String idcardz,String idcardf,String bank,String zhanghu,String bankid,String money,String tmoney){
        ResultUtil resultUti=new ResultUtil();
        if(CheckAdminToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        TbAdmin admin = GetAdmin(token);
        if (partnerService.selectcashlog(admin.getPhone())>0){
            resultUti.setCode(1);
            resultUti.setMsg("已经有一笔提现正在审核，请勿重复提交！");
            return resultUti;
        }
        Cashlog cashlog = new Cashlog();
        cashlog.setZhanghu(zhanghu);
        cashlog.setBank(bank);
        cashlog.setFkPartnerId(admin.getPhone());
        cashlog.setFlag("2");
        cashlog.setIdcardz(idcardz);
        cashlog.setIdcardf(idcardf);
        cashlog.setMoney(money);
        cashlog.setTmoney(tmoney);
        cashlog.setBankid(bankid);
        cashlog.setNickname(admin.getFullname());
        cashlog.setCreatetime(new Date());
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
    /**
     *@参数  [token, file]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2019/1/24
     */
    @RequestMapping("/upsfz")
    @ResponseBody
    public ResultUtil upsfz(String token,MultipartFile file){
        ResultUtil resultUti=new ResultUtil();
        if(CheckAdminToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        if (file == null) {
            resultUti.setCode(1);
            resultUti.setMsg("上传文件为空! ");
            return resultUti;
        }
        String img = MyUtil.shangchuan(file);
        if (img.equals("")){
            resultUti.setCode(1);
            resultUti.setMsg("文件上传失败");
            return resultUti;
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("上传成功");
            resultUti.setData(img);
        }
        return resultUti;
    }




//web 端

    @RequestMapping("/List")
    public String partnerList() {
        return "page/partner/adminList";
    }

    @RequestMapping("/getAdminList")
    @ResponseBody
    public ResultUtil getAdminList(Integer page,Integer limit,AdminSearch search) {
        ResultUtil admins = adminService.selpAdmins(page, limit,search);
        return admins;
    }
    @RequestMapping("/editAdmin/{id}")
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
        admin.setFlag(adminService.selDictionaryval("check"));
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

    public static String GetwxPhone(String encrypdata,String ivdata)  {
        JSONObject jsonObj=null;
        String phone=null;
        try {
            byte[] encrypdat  = Base64Util.decode(encrypdata);
            byte[] iv = Base64Util.decode(ivdata);
            byte[] session_k = Base64Util.decode(session_key);
            int base = 16;
            if (session_k.length % base != 0) {
                int groups = session_k.length / base + (session_k.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(session_k, 0, temp, 0, session_k.length);
                session_k = temp;
            }
            if (iv.length % base != 0) {
                int groups = iv.length / base + (iv.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(iv, 0, temp, 0, iv.length);
                iv = temp;
            }
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(session_k, "AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            phone =new String(cipher.doFinal(encrypdat),"UTF-8");
            jsonObj = JSONObject.fromObject(phone);
        } catch (Exception e) {
            phone="*";
            return phone;
        }
        return  jsonObj.getString("phoneNumber");
    }

    public static String Checkcode(String code)throws IOException{
        String flag = "";
        try{
            URL httpUrl = new URL("https://api.weixin.qq.com/sns/jscode2session?appid=wxd7d2ddda96ee9dda&secret=407f43b298dd0ada25b22312362c23d3&js_code=" + code + "&grant_type=authorization_code");
            HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(10*1000);
            httpURLConnection.setReadTimeout(10*1000);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            //获取内容
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, UTF8));
            final StringBuffer stringBuffer = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            String resp = stringBuffer.toString();
            if (stringBuffer!=null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    flag="";
                }
            }
            if (inputStream!=null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    flag="";
                }
            }
            if (outputStream!=null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    flag="";
                }
            }
            JSONObject jsonObj = JSONObject.fromObject(resp);
            if(jsonObj.getString("session_key")==null||jsonObj.getString("openid")==null){
            }else{
                session_key = jsonObj.getString("session_key");
                openid = jsonObj.getString("openid");
                flag="1";
            }
        }catch (Exception e){
            flag="";
        }
        return flag;
    }

    public boolean CheckAdminToken(String token){
        boolean check = true;
        int flag = adminService.selectToken(token);
        if(flag!=1){
            check=false;
        }
        return check;
    }

    public TbAdmin GetAdmin(String token){
        TbAdmin tbAdmin = adminService.selAdminByToken(token);
        return tbAdmin;
    }
}
