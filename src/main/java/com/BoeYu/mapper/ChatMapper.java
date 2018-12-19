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
}