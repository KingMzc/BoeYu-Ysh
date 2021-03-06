package com.BoeYu.parent;

import com.BoeYu.controller.WebSocket;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Controller
@RequestMapping("Api/parent")
public class ChatController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ChatService chatService;


    @RequestMapping(value = "/UpdateIsreadMsg")
    @ResponseBody
    public ResultUtil UpdateIsreadMsg(String token,String sendId){
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        int flag=chatService.UpdateIsreadMsg(sendId,customer.getPhone());
        if (flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("修改成功!");
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("修改失败!");
            return resultUti;
        }
    }

    /**
     * 获取未读消息条数
     *@参数  [token, toId]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2019/1/4
     */
    @RequestMapping(value = "/ParentGetUnChatNumber")
    @ResponseBody
    public ResultUtil ParentGetUnChatNumber(String token,String sendId) throws IOException {
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        int flag =chatService.GetUnChatNumber(customer.getPhone(),sendId);

            resultUti.setCode(0);
            resultUti.setMsg("查询成功");
            resultUti.setData(flag);
        return resultUti;
    }
    /**
     * 实时获取未读消息
     *@参数  [token, toId]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2019/1/4
     */
    @RequestMapping(value = "/ParentGetUnChat")
    @ResponseBody
    public ResultUtil ParentGetUnChat(String token,String sendId) throws IOException {
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        List<Chat> list =chatService.GetUnChat(sendId,customer.getPhone());
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
     * 家长端获取消息类表
     *@参数  [token, toId, pageSize, page]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/28
     */
    @RequestMapping(value = "/ParentGetChatList")
    @ResponseBody
    public ResultUtil ParentGetChatList(String token,String toId,String pageSize,String page) throws IOException {
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        List<Chat> list =chatService.ParentGetChatList(customer.getPhone(),toId,pageSize,page);
        if(list.size()>0){
            resultUti.setCode(0);
            resultUti.setData(list);
            resultUti.setMsg("查询成功");
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("暂无数据");
        }
        return resultUti;
    }

    @RequestMapping(value = "/ParentChat", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public ResultUtil ParentChat(String tflag,String token,String type,String toId, String message ,MultipartFile file, HttpServletRequest req) throws IOException {
        ResultUtil resultUti = new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        Date date = new Date();
        Chat chat = new Chat();
        Random d = new Random();
        chat.setSendId(customer.getPhone());
        chat.setToId(toId);
        chat.setCreateTime(date);
        chat.setIsread("0");
        chat.setChattype(type);
        if (type.equals("0")){
            if (file == null) {
                resultUti.setCode(1);
                resultUti.setMsg("文件不能为空！");
                return resultUti;
            }
            String img = UUID.randomUUID().toString().replace("-", "") + d.nextInt(10000) + ".jpg" ;
            try {
                chat.setChattype(type);
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
            chat.setChatMsg(img);
        }else if (type.equals("1")){
            if (file == null) {
                resultUti.setCode(1);
                resultUti.setMsg("文件不能为空！");
                return resultUti;
            }
            String img = UUID.randomUUID().toString().replace("-", "") + d.nextInt(10000) + ".mp3" ;
            try {
                chat.setTflag(tflag);
                chat.setChattype(type);
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
            chat.setChatMsg(img);
        }else{
            if (message == null) {
                resultUti.setCode(1);
                resultUti.setMsg("消息不能为空！");
                return resultUti;
            }
            chat.setChatMsg(message);
        }
        int flag= chatService.addChat(chat);
        //开始发送消息
        if(flag>0){
            WebSocket.sendmsg(toId,"NewMessage:"+customer.getPhone());
            resultUti.setCode(0);
            resultUti.setMsg("发送成功");
            resultUti.setData(new Date());
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("发送失败");
        }
        return resultUti;

    }

    @RequestMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public ResultUtil uploadFile(String type,String token,String toid,@RequestParam("file") MultipartFile file, HttpServletRequest req) {
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
            if (type.equals("3")||type.equals("0")){
                chat.setIsread("3");
            }else {
                chat.setIsread("0");
            }
            chatService.addChat(chat);
            return ResultUtil.ok("上传成功");
        } else {
            return ResultUtil.error("文件格式不支持,请重新选择！");
        }
    }

    @RequestMapping(value = "/show")
    @ResponseBody
    public ResultUtil showPic(String token,String fileName, HttpServletResponse response) {
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            //图片的本地全路径
            fis = new FileInputStream(GlobalUtil.getValue("upfile.path")+"/"+ fileName);
            os = response.getOutputStream();
            //System.out.println("上传文件");
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
        return ResultUtil.ok("显示成功");
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
        List<Chat> list=chatService.GetUnreadMsg(GetCustomer(token).getPhone(),sendId);
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
    public ResultUtil readImg(String token,String toId){
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Chat chat=chatService.GetReadImg(GetCustomer(token).getPhone(),toId);
        if(chat!=null){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功!");
            resultUti.setData(chat.getChatMsg());
            return resultUti;
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("暂无记录!");
            return resultUti;
        }
    }
    /**
     * 发送远程截图指令
     *@参数  [token, toId]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/26
     */
    @RequestMapping(value = "/Screenshot")
    @ResponseBody
    public ResultUtil Screenshot(String token,String toId) throws IOException {
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        WebSocket.sendmsg(toId,"Screenshot:"+customer.getPhone());
        resultUti.setCode(0);
        resultUti.setMsg("远程截图");
        return resultUti;
    }

    @RequestMapping(value = "/FastStart")
    @ResponseBody
    public ResultUtil FastStart(String token,String toId,String applicationId) throws IOException {
        ResultUtil resultUti=new ResultUtil();
        if(CheckToken(token)==false){
            resultUti.setCode(1);
            resultUti.setMsg("登录身份过期请重新登录!");
            return resultUti;
        }
        Customer customer = GetCustomer(token);
        int flag = WebSocket.sendmsg(toId,"FastStart:"+applicationId);
        if(flag>0){
            resultUti.setCode(0);
            resultUti.setMsg("启动成功");
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("启动失败");
        }
        return resultUti;
    }

    @RequestMapping("/shangchuan")
    @ResponseBody
    public void banneradd(@RequestParam("file") CommonsMultipartFile f, HttpServletResponse resp, HttpServletRequest req) throws IOException {
        String type=req.getParameter("type");

        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = "D:/upload";
        File file = new File(savePath);
        //判断上传文件的保存目录是否存在
        if (!file.exists()) {
            //创建目录
            file.mkdirs();
        }
        PrintWriter out = resp.getWriter();
        //String img_name=f.getOriginalFilename().substring( 0,f.getOriginalFilename().indexOf( "." )); //名字前半部分
        //文件名后缀
        String img_ext="";
        if(f.getOriginalFilename().contains(".")){
            img_ext = f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf(".")); //后缀
        }
        String  img_name ="";
        if(!"".equals(type)){
            //用UUID给上传的文件改名字
            img_name =type+"_"+UUID.randomUUID().toString() + img_ext;
            //开始上传
            f.transferTo(new File(savePath, img_name));
        }
        //判断是否上传成功
        File image_path = new File(savePath + "//" +img_name);

        if (image_path.exists()){
            //获取文件大小
            out.print("{\"result\":0,\"file_name\":\"" + img_name + "\",\"fileSize\":\""+image_path.length()+"\"}");
        }else{
            out.print("{\"result\":\"1\"}");
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
