package com.BoeYu.service.impl;

import com.BoeYu.mapper.ChatMapper;
import com.BoeYu.pojo.Chat;
import com.BoeYu.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatMapper chatMapper;
    @Override
    public int addChat(Chat chat) {
        return chatMapper.insert(chat);
    }

    @Override
    public List<Chat> GetUnreadMsg(String toid,String sendid) {
        return chatMapper.selectIsReadMsg(toid,sendid);
    }

    @Override
    public List<Chat> GetReadImg(String toid, String sendid) {
        return chatMapper.selectReadImg(toid,sendid);
    }


}
