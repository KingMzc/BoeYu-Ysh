package com.BoeYu.service.impl;

import com.BoeYu.mapper.SafeUrlMapper;
import com.BoeYu.pojo.SafeUrl;
import com.BoeYu.service.SafeUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SafeUrlServiceImpl implements SafeUrlService {
    @Autowired
    private SafeUrlMapper safeUrlMapper;

    @Override
    public int insert(SafeUrl safeUrl) {
        return safeUrlMapper.insert(safeUrl);
    }
}
