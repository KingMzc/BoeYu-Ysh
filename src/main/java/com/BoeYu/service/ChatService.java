package com.BoeYu.service;

import com.BoeYu.pojo.Chat;

import java.util.List;

public interface ChatService {
    int addChat(Chat chat);

    List<Chat> GetUnreadMsg(String toid,String sendid);

    List<Chat> GetReadImg(String toid,String sendid);
}
