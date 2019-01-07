package com.BoeYu.service.impl;

import com.BoeYu.mapper.ChatMapper;
import com.BoeYu.mapper.FamilyMapper;
import com.BoeYu.pojo.Chat;
import com.BoeYu.pojo.Family;
import com.BoeYu.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatMapper chatMapper;
    @Autowired
    private FamilyMapper familyMapper;
    @Override
    public int addChat(Chat chat) {
        return chatMapper.insert(chat);
    }

    @Override
    public List<Chat> GetUnreadMsg(String toid,String sendid) {

        return chatMapper.selectIsReadMsg(sendid,toid);
    }

    @Override
    public Chat GetReadImg(String toid, String sendid) {
        return chatMapper.selectReadImg(toid,sendid);
    }

    @Override
    public List<Map<String,Object>> GetChatList(String android) {
        List<Map<String,Object>> chatlist = new ArrayList<Map<String,Object>>();
        Map<String,Object>  map= new HashMap<String,Object>();
        List<Family> list = familyMapper.GetChatList(android);
        for(int i=0;i<list.size();i++){
            map.put("count",chatMapper.selectCountIsReadMsg(android,list.get(i).getFkCustomerId()));
            map.put("family",list.get(i));
            map.put("chat",chatMapper.selectlastIsReadMsg(android,list.get(i).getFkCustomerId()));
            chatlist.add(map);
        }
        return chatlist;
    }

    @Override
    public List<Chat> ParentGetChatList(String sendId, String toId, String pageSize, String page) {
        /*int PS=Integer.valueOf(pageSize);
        int P=(Integer.valueOf(page)-1)*Integer.valueOf(pageSize);*/
        int PS=Integer.valueOf(pageSize);
        int P=Integer.valueOf(page);
        return chatMapper.ParentGetChatList(sendId,toId,PS,P);
    }

    @Override
    public List<Chat> ChildGetChatList(String sendId, String toId, String pageSize, String page) {
        int PS=Integer.valueOf(pageSize);
        int P=Integer.valueOf(page);
        return chatMapper.ChildGetChatList(sendId,toId,PS,P);
    }

    @Override
    public int GetUnChatNumber(String sendId, String toId) {
        return chatMapper.GetUnChatNumber(sendId,toId);
    }

    @Override
    public List<Chat> GetUnChat(String sendId, String toId) {
        return chatMapper.GetUnChat(sendId,toId);
    }

    @Override
    public int UpdateIsreadMsg(String sendId, String toId) {
        return chatMapper.UpdateIsreadMsg(sendId,toId);
    }


}
