package com.BoeYu.service;

import com.BoeYu.pojo.Chat;
import com.BoeYu.pojo.Family;

import java.util.List;
import java.util.Map;

public interface ChatService {
    int addChat(Chat chat);

    List<Chat> GetUnreadMsg(String toid,String sendid);

    Chat GetReadImg(String toid,String sendid);

    List<Map<String,Object>> GetChatList(String android);

    List<Chat> ParentGetChatList(String sendId,String toId,String pageSize,String page);

    List<Chat> ChildGetChatList(String sendId,String toId,String pageSize,String page);

    int GetUnChatNumber(String sendId,String toId);

    List<Chat> GetUnChat(String sendId,String toId);

    int UpdateIsreadMsg(String sendId,String toId);
}
