package com.BoeYu.mapper;

import com.BoeYu.pojo.TbCarousel;
import com.BoeYu.pojo.TbCarouselExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCarouselMapper {
    int countByExample(TbCarouselExample example);

    int deleteByExample(TbCarouselExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbCarousel record);

    int insertSelective(TbCarousel record);

    List<TbCarousel> selectByExample(TbCarouselExample example);

    TbCarousel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbCarousel record, @Param("example") TbCarouselExample example);

    int updateByExample(@Param("record") TbCarousel record, @Param("example") TbCarouselExample example);

    int updateByPrimaryKeySelective(TbCarousel record);

    int updateByPrimaryKey(TbCarousel record);
}