package com.BoeYu.child;

import com.BoeYu.controller.WebSocket;
import com.BoeYu.pojo.Chat;
import com.BoeYu.pojo.Child;
import com.BoeYu.pojo.Family;
import com.BoeYu.service.ChatService;
import com.BoeYu.service.ChildService;
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
import java.io.*;
import java.util.*;

@Controller
@RequestMapping("Api/child")
public class ChatChildController {
    @Autowired
    private ChatService chatService;
    @Autowired
    private ChildService childService;

    @RequestMapping(value = "/UpdateIsreadMsg")
    @ResponseBody
    public ResultUtil UpdateIsreadMsg(String android,String sendId){
        ResultUtil resultUti = new ResultUtil();
        int flag=chatService.UpdateIsreadMsg(sendId,android);
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
     * 孩子获取
     *@参数  [android]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/27
     */
    @RequestMapping(value = "/GetChatList")
    @ResponseBody
    public ResultUtil GetChatList(String android){
        ResultUtil resultUti = new ResultUtil();
        List<Map<String,Object>> list=chatService.GetChatList(android);
        if (list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功!");
            resultUti.setData(list);
            return resultUti;
        }else{
            resultUti.setCode(0);
            resultUti.setMsg("暂无记录!");
            return resultUti;
        }
    }
    /**
     * 孩子端获取分页消息
     *@参数  [android, toId, pageSize, page]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/28
     */
    @RequestMapping(value = "/ChildGetChatList")
    @ResponseBody
    public ResultUtil ChildGetChatList(String android,String toId,String pageSize,String page) throws IOException {
        ResultUtil resultUti=new ResultUtil();
        List<Chat> list =chatService.ChildGetChatList(android,toId,pageSize,page);
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

    @RequestMapping(value = "/CunreadMsg")
    @ResponseBody
    public ResultUtil cunreadMsg(String android,String sendId){
        ResultUtil resultUti = new ResultUtil();
        List<Chat> list=chatService.GetUnreadMsg(sendId,android);
        if (list.size()>0){
            resultUti.setCode(0);
            resultUti.setMsg("查询成功!");
            resultUti.setData(list);
            return resultUti;
        }else{
            resultUti.setCode(0);
              resultUti.setMsg("暂无记录!");
            return resultUti;
        }
    }
    /**
     * 孩子端发送消息
     *@参数  [android, type, toid, message, file, req]
     *@返回值  com.BoeYu.util.ResultUtil
     *@创建人  KingRoc
     *@创建时间  2018/12/28
     */
    @RequestMapping(value = "/ChildChat", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public ResultUtil ChildChat(String tflag,String android,String type,String toId, String message ,MultipartFile file, HttpServletRequest req) throws IOException {
        ResultUtil resultUti = new ResultUtil();
        String messagee=message;
        Date date = new Date();
        Chat chat = new Chat();
        Random d = new Random();
        chat.setSendId(android);
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
            chat.setChatMsg(messagee);
        }
        int flag= chatService.addChat(chat);
        if(flag>0){
            WebSocket.sendmsg(toId,"NewMessage:"+android);
            resultUti.setCode(0);
            resultUti.setMsg("发送成功");
            resultUti.setData(new Date());
        }else{
            resultUti.setCode(1);
            resultUti.setMsg("发送失败");
        }
        return resultUti;

    }

    @RequestMapping(value = "/Cshow")
    @ResponseBody
    public String cshowVoice( String fileName,HttpServletResponse response) {
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            //图片的本地全路径
            fis = new FileInputStream(GlobalUtil.getValue("upfile.path")+"/"+ fileName);
            if(fis==null){
                return "文件损坏";
            }
            os = response.getOutputStream();
            System.out.println("上传");
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
        return "ok";
    }

    @RequestMapping(value = "/Cupload", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public ResultUtil cuploadFile(String type,String android, String toid, MultipartFile file, HttpServletRequest req) {
        if (file == null) {
            return ResultUtil.error("文件不能为空！");
        }
        Child child = GetChild(android);
        Date date = new Date();
        Chat chat = new Chat();
        /*String fileSub = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."))
                .toLowerCase();
        if (".jpg".equals(fileSub) || ".jpeg".equals(fileSub) || ".png".equals(fileSub) || ".gif".equals(fileSub)||".mp3".equals(fileSub)) {*/
            Random d = new Random();
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
            chat.setSendId(child.getAndroid());
            chat.setToId(toid);
            chat.setCreateTime(date);
            if (type.equals("3")){
                chat.setIsread("3");
            }else {
                chat.setIsread("0");
            }
            chatService.addChat(chat);
            return ResultUtil.ok();
       /* } else {
            return ResultUtil.error("文件格式不支持,请重新选择！");
        }*/
    }

    public Child GetChild(String android){
        Child child =childService.GetChildByAndroid(android);
        return child;
    }


}
