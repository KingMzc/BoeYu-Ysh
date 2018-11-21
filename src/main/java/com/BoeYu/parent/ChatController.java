package com.BoeYu.parent;

import com.BoeYu.pojo.Chat;
import com.BoeYu.pojo.Customer;
import com.BoeYu.service.ChatService;
import com.BoeYu.service.CustomerService;
import com.BoeYu.util.GlobalUtil;
import com.BoeYu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

@Controller
@RequestMapping("Api/parent")
public class ChatController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ChatService chatService;

    @RequestMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public ResultUtil uploadFile(String type,String token,String toid,MultipartFile file, HttpServletRequest req) {
        if (file == null) {
            return ResultUtil.error("文件不能为空！");
        }
        if(CheckToken(token)==false){
            return ResultUtil.error("登录身份过期请重新登录!");
        }
        Customer customer = GetCustomer(token);
        Date date = new Date();
        Chat chat = new Chat();
        String fileSub = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."))
                .toLowerCase();
        if (".jpg".equals(fileSub) || ".jpeg".equals(fileSub) || ".png".equals(fileSub) || ".gif".equals(fileSub)||".mp3".equals(fileSub)) {
            Random d = new Random();
            String img = UUID.randomUUID().toString().replace("-", "") + d.nextInt(10000) + "" + fileSub;
            try {
                    chat.setChattype(type);
                File f=new File(GlobalUtil.getValue("upfile.path"));
                if(!f.exists()){
                    System.out.println("上传图片或者文档！");
                    f.mkdirs();
                }
                file.transferTo(new File(f, img));
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            chat.setChatMsg(img);
            chat.setSendId(customer.getId().toString());
            chat.setToId(toid);
            chat.setCreateTime(date);
            if (type.equals("3")){
                chat.setIsread("3");
            }else {
                chat.setIsread("0");
            }
            chatService.addChat(chat);
            return ResultUtil.ok();
        } else {
            return ResultUtil.error("文件格式不支持,请重新选择！");
        }
    }

    @RequestMapping(value = "/show")
    @ResponseBody
    public ResultUtil showPic(String token,String fileName, HttpServletResponse response) {
        if(CheckToken(token)==false){
            return ResultUtil.error("登录身份过期请重新登录!");
        }
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            //图片的本地全路径
            fis = new FileInputStream(GlobalUtil.getValue("upfile.path")+"/"+ fileName);
            os = response.getOutputStream();
            System.out.println("上传文件");
            int count = 0;
            byte[] buffer = new byte[1024 * 8];
            while ((count = fis.read(buffer)) != -1) {
                os.write(buffer, 0, count);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fis.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultUtil.ok();
    }

    @RequestMapping(value = "/unreadMsg")
    @ResponseBody
    public ResultUtil unreadMsg(String token,String sendId){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        List<Chat> list=chatService.GetUnreadMsg(GetCustomer(token).toString(),sendId);
        if(list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功!");
            resultUti.setData(list);
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("暂无记录!");
            return resultUti;
        }
    }
    @RequestMapping(value = "/readImg")
    @ResponseBody
    public ResultUtil readImg(String token,String sendId){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        List<Chat> list=chatService.GetReadImg(GetCustomer(token).toString(),sendId);
        if(list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功!");
            resultUti.setData(list);
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("暂无记录!");
            return resultUti;
        }
    }

    public Customer GetCustomer(String token){
        Customer customer = customerService.GetCustomerByToken(token);
        return customer;
    }
    public boolean CheckToken(String token){
        boolean check = true;
        int flag = customerService.selectToken(token);
        if(flag!=1){
            check=false;
        }
        return check;
    }
}
