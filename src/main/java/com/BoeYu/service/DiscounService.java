package com.BoeYu.service;

import com.BoeYu.util.ResultUtil;

public interface DiscounService {

    String addDiscoun(String csize,String distype,String endtime);

    ResultUtil selDiscoun(Integer page, Integer limit);

    int updateExport(String [] id);
}
