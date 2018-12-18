package com.BoeYu.child;

import com.BoeYu.pojo.Chat;
import com.BoeYu.pojo.Child;
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
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("Api/child")
public class ChatChildController {
    @Autowired
    private ChatService chatService;
    @Autowired
    private ChildService childService;
    @RequestMapping(value = "/CunreadMsg")
    @ResponseBody
    public ResultUtil cunreadMsg(String android,String sendId){
        ResultUtil resultUti = new ResultUtil();
        List<Chat> list=chatService.GetUnreadMsg(GetChild(android).toString(),sendId);
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

    @RequestMapping(value = "/Cshow")
    @ResponseBody
    public String cshowVoice( String fileName,HttpServletResponse response) {
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            //图片的本地全路径
            fis = new FileInputStream(GlobalUtil.getValue("upfile.path")+"/"+ fileName);
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
        String fileSub = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."))
                .toLowerCase();
        if (".jpg".equals(fileSub) || ".jpeg".equals(fileSub) || ".png".equals(fileSub) || ".gif".equals(fileSub)||".mp3".equals(fileSub)) {
            Random d = new Random();
            String img = UUID.randomUUID().toString().replace("-", "") + d.nextInt(10000) + "" + fileSub;
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
            chat.setSendId(child.getId().toString());
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

    public Child GetChild(String android){
        Child child =childService.GetChildByAndroid(android);
        return child;
    }


}
