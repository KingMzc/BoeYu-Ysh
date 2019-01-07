package com.BoeYu.mapper;

import com.BoeYu.pojo.Chat;
import com.BoeYu.pojo.ChatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatMapper {
    long countByExample(ChatExample example);

    int deleteByExample(ChatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Chat record);

    int insertSelective(Chat record);

    List<Chat> selectByExample(ChatExample example);

    Chat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Chat record, @Param("example") ChatExample example);

    int updateByExample(@Param("record") Chat record, @Param("example") ChatExample example);

    int updateByPrimaryKeySelective(Chat record);

    int updateByPrimaryKey(Chat record);

    List<Chat> selectIsReadMsg(String toid,String sendid);

    Chat selectReadImg(String toid,String sendid);

    int deleteChild(String android);

    int selectCountIsReadMsg(String toid,String sendid);

    Chat selectlastIsReadMsg(String toid,String sendid);

    List<Chat> ParentGetChatList(String sendId, String toId, int pageSize, int page);

    List<Chat> ChildGetChatList(String sendId, String toId, int pageSize, int page);

    int GetUnChatNumber(String sendId, String toId);

    List<Chat> GetUnChat(String sendId, String toId);

    int UpdateIsreadMsg(String sendId,String toId);
}