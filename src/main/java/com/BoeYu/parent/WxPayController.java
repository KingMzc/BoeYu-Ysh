package com.BoeYu.parent;

import com.BoeYu.pojo.Customer;
import com.BoeYu.pojo.Vip;
import com.BoeYu.service.CustomerService;
import com.BoeYu.util.ResultUtil;
import com.BoeYu.util.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("Api/parent")
public class WxPayController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/WxPay")
    @ResponseBody
    public ResultUtil WxPay(String token,String orderNo,String openid){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }
        String body = "boeyu-"+orderNo;// 订单详情
        Vip vip = customerService.selectByPrimaryKey(Integer.valueOf(orderNo));
        //String ddje = (String) orderInfo.get("ddje");// 订单金额
        String ddje = String.valueOf((vip.getPrice()*100));
        orderNo = (new Date()).toString()+orderNo;
        try {
            Map<String, Object> wxpay = wxpay(orderNo,body,ddje,openid);
            resultUti.setCode(0);
            resultUti.setMsg("支付订单提交成功!");
            resultUti.setData(wxpay);
        } catch (Exception e) {
            resultUti.setCode(1);
            resultUti.setMsg("服务器内部错误!");
        }
            return resultUti;
    }

    /**
     * 微信异步通知
     */
    @ResponseBody
    @RequestMapping(value = "/Wxcall", method = { RequestMethod.GET, RequestMethod.POST })
    public String callBack(HttpServletRequest request, HttpServletResponse response){
        //System.out.println("微信支付成功,微信发送的callback信息,请注意修改订单信息");
        //InputStream is = null;
        try {
            InputStream inStream = request.getInputStream();
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            String resultxml = new String(outSteam.toByteArray(), "utf-8");
            //is = request.getInputStream();//获取请求的流信息(这里是微信发的xml格式所有只能使用流来读)
            //String xml = WXPayUtil.inputStream2String(is, "UTF-8");
            Map<String, String> notifyMap = WXPayUtil.xmlToMap(resultxml);//将微信发的xml转map
            if(notifyMap.get("return_code").equals("SUCCESS")){
                if(notifyMap.get("result_code").equals("SUCCESS")){
                    String ordersSn = notifyMap.get("out_trade_no");//商户订单号 
                    String amountpaid = notifyMap.get("total_fee");//实际支付的订单金额:单位 分
                    //支付成功执行业务逻辑
                    System.out.println("-------------------------------------------------------"+ordersSn);
                    //int returnResult = drvSchoolOrdersService.updateHdOrders(ordersSn);
                    // BigDecimal amountPay = (new BigDecimal(amountpaid).divide(new BigDecimal("100"))).setScale(2);//将分转换成元-实际支付金额:元
                    //String openid = notifyMap.get("openid");  //如果有需要可以获取
                    //String trade_type = notifyMap.get("trade_type");  
                    /*以下是自己的业务处理------仅做参考
                     * 更新order对应字段/已支付金额/状态码
                     */
                }
            }
            //告诉微信服务器收到信息了，不要在调用回调action了========这里很重要回复微信服务器信息用流发送一个xml即可
            response.getWriter().write("<xml><return_code><![CDATA[SUCCESS]]></return_code></xml>");
            inStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 微信支付接口
     * @return
     * @author
     * @throws Exception
     */
    public Map<String, Object> wxpay(String orderNo,String body,String ddje,String openid) throws Exception {
        //Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> dat = new HashMap<String, Object>();
        Map<String, String> data = new HashMap<String, String>();
        data.put("appid", "wxd7d2ddda96ee9dda");
        data.put("mch_id", "1518621291");
        data.put("nonce_str", WXPayUtil.generateNonceStr());
        data.put("body", body);
        data.put("out_trade_no", orderNo);
        data.put("total_fee", ddje);
        data.put("spbill_create_ip", "14.23.150.211");
        data.put("notify_url","http://ysh.boeyu.com/Api/parent/Wxcall");
        data.put("trade_type", "JSAPI");
        data.put("openid",openid);
        String UTF8 = "UTF-8";
        String reqBody = WXPayUtil.generateSignedXml(data,"BoeyuYshXiongXiong3611OK2018YESW");
        URL httpUrl = new URL("https://api.mch.weixin.qq.com/pay/unifiedorder");
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
        httpURLConnection.setRequestProperty("Host", "api.mch.weixin.qq.com");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(10*1000);
        httpURLConnection.setReadTimeout(10*1000);
        httpURLConnection.connect();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(reqBody.getBytes(UTF8));
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
                e.printStackTrace();
            }
        }
        if (inputStream!=null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (outputStream!=null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拼接字符串："+resp);
        Map<String, String> signt = WXPayUtil.xmlToMap(resp);
        System.out.println("拼接后的Map"+signt);
        if(signt.get("result_code").equals("FAIL")){
            dat.put("message",signt.get("err_code_des").toString());
        }else{
            Map<String, String> da = new HashMap<String, String>();
            da.put("appId",signt.get("appid"));
            da.put("timeStamp",String.valueOf(WXPayUtil.getCurrentTimestamp()));
            da.put("nonceStr",signt.get("nonce_str"));
            da.put("package","prepay_id="+signt.get("prepay_id"));
            da.put("signType","MD5");
            System.out.println("二次签名的Map："+da);
            dat.put("appid",signt.get("appid"));
            //dat.put("partnerid","1518621291");
            dat.put("package","prepay_id="+signt.get("prepay_id"));
            dat.put("noncestr",signt.get("nonce_str"));
            dat.put("timestamp",da.get("timeStamp"));
            //dat.put("prepayid",signt.get("prepay_id"));
            dat.put("sign",WXPayUtil.generateSignature(da,"BoeyuYshXiongXiong3611OK2018YESW"));
        }
        //System.out.println(dat);
        return dat;
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
