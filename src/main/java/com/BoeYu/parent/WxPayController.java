package com.BoeYu.parent;

import com.BoeYu.pojo.Customer;
import com.BoeYu.service.CustomerService;
import com.BoeYu.util.ResultUtil;
import com.BoeYu.util.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("Api/parent")
public class WxPayController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/WxPay")
    @ResponseBody
    public ResultUtil SelectSafeChild(String token,String orderNo,String openid){

        ResultUtil resultUti=new ResultUtil();
        /*if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录! ");
            return resultUti;
        }*/
        String body = "boeyu-"+orderNo;// 订单详情
        //String ddje = (String) orderInfo.get("ddje");// 订单金额
        String ddje = "0.01";
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
     * 微信支付接口
     * @return
     * @author
     * @throws Exception
     */
    public Map<String, Object> wxpay(String orderNo,String body,String ddje,String openid) throws Exception {
        //Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> dat = new HashMap<String, Object>();
        // int je = Integer.valueOf(ddje);
        String str = ddje.replace(".", "");//  订单获取的实际支付金额
        //String str = "001";
        String zfje = str.replaceAll("^(0+)", "");
        Map<String, String> data = new HashMap<String, String>();
        data.put("appid", "wxd7d2ddda96ee9dda");
        data.put("body", body);
        //data.put("device_info", "WEB");
        data.put("mch_id", "1518621291");
        data.put("nonce_str", WXPayUtil.generateNonceStr());
        data.put("notify_url","http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php");
       // data.put("notify_url","http://61.136.101.137:9080/api.ukxueche/charge/uk_wxcall");
        //data.put("attach","wxzfcs");
        data.put("openid",openid);
        data.put("trade_type", "JSAPI");
        //data.put("total_fee", zfje);
        data.put("total_fee", zfje);
        data.put("out_trade_no", orderNo);
        data.put("spbill_create_ip", "14.23.150.211");
        /*<openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</openid>
   <out_trade_no>1415659990</out_trade_no>
   <spbill_create_ip>14.23.150.211</spbill_create_ip>*/

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
        System.out.println(resp);
        Map<String, String> signt = WXPayUtil.xmlToMap(resp);
        System.out.println(signt);

        if(signt.get("result_code").equals("FAIL")){
            dat.put("message",signt.get("err_code_des").toString());
        }else{
            Map<String, String> da = new HashMap<String, String>();
            da.put("appid",signt.get("appid"));
            da.put("partnerid","1518621291");
            da.put("package","Sign=WXPay");
            da.put("noncestr",signt.get("nonce_str"));
            da.put("timestamp",String.valueOf(WXPayUtil.getCurrentTimestamp()));
            da.put("prepayid",signt.get("prepay_id"));
            //WXPayUtil.generateSignature(da,"ff69280fdfbe238f519e9e9050fb1b5a");
            dat.put("appid",signt.get("appid"));
            dat.put("partnerid","1518621291");
            dat.put("package","Sign=WXPay");
            dat.put("noncestr",signt.get("nonce_str"));
            dat.put("timestamp",WXPayUtil.getCurrentTimestamp());
            dat.put("prepayid",signt.get("prepay_id"));
            dat.put("sign",WXPayUtil.generateSignature(da,"BoeyuYshXiongXiong3611OK2018YESW"));
        }
        System.out.println(dat);
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
