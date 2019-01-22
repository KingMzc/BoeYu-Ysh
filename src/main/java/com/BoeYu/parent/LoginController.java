package com.BoeYu.parent;

import com.BoeYu.controller.WebSocket;
import com.BoeYu.pojo.Child;
import com.BoeYu.pojo.Customer;
import com.BoeYu.pojo.MapWxidPhone;
import com.BoeYu.service.ChildService;
import com.BoeYu.service.CustomerService;
import com.BoeYu.util.Base64Util;
import com.BoeYu.util.ResultUtil;
import net.sf.json.JSONObject;
import org.bouncycastle.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.poi.util.StringUtil.UTF8;

@Controller
@RequestMapping("Api/parent")
public class LoginController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ChildService childService;

    private static String session_key="";

    private static String openid="";
    /**
     * 用户注册~~~~~
     *@参数  [phone, wxid, nickname, sex, yanzhengma]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/19
     */
    @RequestMapping("/Register")
    @ResponseBody
    public ResultUtil Register(String partnerId,String phone,String wxid,String nickname,String sex,String yanzhengma){
        ResultUtil resultUti=new ResultUtil();
        Customer customer = new Customer();
        if(partnerId!=null||partnerId!=""){
            customer.setPartnerId(partnerId);
        }
        customer.setPhone(phone);
        customer.setWxid(wxid);
        customer.setNickname(nickname);
        customer.setSex(sex);
        customer.setCreateTime(new Date());
        int flagp= customerService.selectPhone(customer.getPhone());
        if(flagp>0){
            resultUti.setCode(1);
            resultUti.setMsg("手机号码已经注册");
            return resultUti;
        }
        int flag = customerService.addCustomer(customer);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("注册成功");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("注册失败");
        }
        return resultUti;
    }

    @RequestMapping("/Setpassword")
    @ResponseBody
    public ResultUtil Setpassword(String phone,String password){
        ResultUtil resultUti=new ResultUtil();
        Customer customer = new Customer();
        customer.setPhone(phone);
        customer.setPassword(password);
        int flag = customerService.addCustomer(customer);
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("密码设置成功");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("密码设置失败");
        }
        return resultUti;
    }
    /**
     * 第一次登录 登录家注册
     *@参数  [request, encrypdata, ivdata, partnerId, code]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2019/1/11
     */
    @RequestMapping("/flogin")
    @ResponseBody

    public ResultUtil FLogin(HttpServletRequest request,String encrypdata,String ivdata,String partnerId,String code) throws Exception {
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
            if(customerService.selectPhone(phone)>0){
                if (customerService.selectPhonewx(phone,openid)>0){
                    Map<String,Object> map=customerService.loginInfo(phone,openid);
                    Customer customer = (Customer)map.get("customer");
                    request.getSession().setAttribute("customerid",customer.getPhone());
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
                    customerService.updateWxid(phone,openid);
                    Map<String,Object> map=customerService.loginInfo(phone,openid);
                    Customer customer = (Customer)map.get("customer");
                    request.getSession().setAttribute("customerid",customer.getPhone());
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
                Customer customer = new Customer();
                if(partnerId==null){
                }else{
                    if (!partnerId.equals("")){
                        customer.setPartnerId(partnerId);
                    }
                }
                customer.setPhone(phone);
                customer.setWxid(openid);
                customer.setNickname("");
                customer.setSex("");
                customer.setCreateTime(new Date());
                customerService.addCustomer(customer);
                    Map<String,Object> map=customerService.loginInfo(phone,openid);
                    customer = (Customer)map.get("customer");
                    Map<String,String > mp= MapWxidPhone.getMap();
                if(mp==null){
                    mp =new HashMap<String,String>();
                }
                    mp.put(phone,openid);
                    request.getSession().setAttribute("customerid",customer.getPhone());
                    resultUti.setCode(0);
                    resultUti.setMsg("登录成功");
                    resultUti.setData(map);
                return resultUti;
            }
        }
    }

    /**
     * 第二次登录。
     *@参数  [request, phone, wxid]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/11/14
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
            if(customerService.selectPhone(phone)>0){
                if (customerService.selectPhonewx(phone,wxid)>0){
                    Map<String,Object> map=customerService.loginInfo(phone,wxid);
                    if (map.get("customer").equals(0)){
                        resultUti.setCode(1);
                        resultUti.setMsg("手机号码微信号码不匹配！");
                        return resultUti;
                    }
                    Customer customer = (Customer)map.get("customer");
                    Map<String,String > mp= MapWxidPhone.getMap();
                    if(mp==null){
                        mp =new HashMap<String,String>();
                    }
                    mp.put(phone,wxid);
                    request.getSession().setAttribute("customerid",customer.getPhone());
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

    @RequestMapping("/Getchilds")
    @ResponseBody
    public ResultUtil Getchilds(String token){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录！");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        List<Child> list = customerService.GetChild(customer.getPhone());
        if(list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("暂无数据");
        }
        resultUti.setData(list);
        return resultUti;
    }

    @RequestMapping("/GetChildInfo")
    @ResponseBody
    public ResultUtil GetChildInfo(String token){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录！");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        Child child =childService.GetChildByAndroid(customer.getFkFamilyId());
        if(child!=null){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("暂无数据");
        }
        resultUti.setData(child);
        return resultUti;
    }

    @RequestMapping("/ShowMap")
    @ResponseBody
    public ResultUtil ShowMap(String token){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录！");
            return resultUti;
        }
        resultUti.setCode(0);
        resultUti.setMsg("查询成功");
        resultUti.setData("34.123174,108.446045");
        return resultUti;
    }

    @RequestMapping("/SwitchChild")
    @ResponseBody
    public ResultUtil SwitchChild(String token,String childId){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        if(customerService.CheckChild(childId)<=0){
            resultUti.setCode(1);
            resultUti.setMsg("没有找到这个孩子！");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        if(customerService.CheckChildIsCustomer(customer.getPhone(),childId)<=0){
            resultUti.setCode(1);
            resultUti.setMsg("没有权限绑定这个孩子!");
            return resultUti;
        }
        customer.setFkFamilyId(childId);
        int flag = customerService.updateChild(customer);
        if(flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("切换成功");
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("切换失败");
            return resultUti;
        }
    }
    @RequestMapping("/LockChild")
    @ResponseBody
    public ResultUtil LockChild(String token,String childId,String type) throws IOException {
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        if(customerService.CheckChild(childId)<=0){
            resultUti.setCode(1);
            resultUti.setMsg("没有找到这个孩子！");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        if(customerService.CheckChildIsCustomer(customer.getPhone(),childId)<=0){
            resultUti.setCode(1);
            resultUti.setMsg("没有权限锁屏这个孩子!");
            return resultUti;
        }
        Child child = new Child();
        child.setChildType(type);
        child.setAndroid(childId);
        int flag = customerService.LockChild(child);
        if(flag>0){
            WebSocket.sendmsg(childId,"LockScreen:"+type);
            resultUti.setCode(0);
            if (type.equals("1")){
                resultUti.setMsg("锁屏成功");
            }else{
                resultUti.setMsg("解锁成功");
            }
            return resultUti;
        }else{
            resultUti.setCode(1);
            if (type.equals("1")){
                resultUti.setMsg("锁屏失败");
            }else{
                resultUti.setMsg("解锁失败");
            }
            return resultUti;
        }
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


    public static boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if (!isMatch) {
                return false;
            }
            return true;
        }
    }
}
