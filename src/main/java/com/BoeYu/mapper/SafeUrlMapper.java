package com.BoeYu.mapper;

import com.BoeYu.pojo.SafeUrl;
import com.BoeYu.pojo.SafeUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SafeUrlMapper {
    long countByExample(SafeUrlExample example);

    int deleteByExample(SafeUrlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SafeUrl record);

    int insertSelective(SafeUrl record);

    List<SafeUrl> selectByExample(SafeUrlExample example);

    SafeUrl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SafeUrl record, @Param("example") SafeUrlExample example);

    int updateByExample(@Param("record") SafeUrl record, @Param("example") SafeUrlExample example);

    int updateByPrimaryKeySelective(SafeUrl record);

    int updateByPrimaryKey(SafeUrl record);

    List<SafeUrl> selectSafeUrl(String childId,String type);

    List<SafeUrl> SelectSafeUrll(String childId);
}