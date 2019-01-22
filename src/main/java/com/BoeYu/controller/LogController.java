package com.BoeYu.controller;

import com.BoeYu.pojo.UserSearch;
import com.BoeYu.service.LogService;
import com.BoeYu.util.*;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.*;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
@RequestMapping("log/")
public class LogController {

	@Autowired
	private LogService logServiceImpl;
	
	@RequestMapping("logList")
	@RequiresPermissions("log:log:list")
	public String logList(){
		return "page/log/logList";
	}
	
	@RequestMapping("getLogList")
	@RequiresPermissions("log:log:list")
	@ResponseBody
	public ResultUtil getLogList(Integer page, Integer limit, UserSearch search){
		return logServiceImpl.selLogList(page,limit,search);
	}
	private static final String WATERMARK = "watermark";
	private static final String APPID = "appid";


	public static void main(String[] args) throws FileNotFoundException {

		/*for (int i=3;i<101;i++){
			OutputStream os = new FileOutputStream(new File("C:/Users/Admin/Desktop/cs/"+i+".text"));
		}*/
		for (int i=1;i<101;i++){
			MyUtil.deletewj("C:/Users/Admin/Desktop/cs/"+i+".text");
		}


	}







}
