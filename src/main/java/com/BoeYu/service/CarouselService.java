package com.BoeYu.service;

import com.BoeYu.pojo.TbCarousel;
import com.BoeYu.util.ResultUtil;

public interface CarouselService {
	//获取轮播图
	public ResultUtil selCarousels(Integer page,Integer limit);

	//添加轮播信息
	public void insCarouselService(TbCarousel carousel);

	public void updCarouselStatusById(Integer id, Integer status);

	public void delCarouselById(Integer id);

	public void delCarouselByIds(String carouselStr);

	public TbCarousel selCarouselById(Integer id);

	public void updCarouselService(TbCarousel carousel);
}
