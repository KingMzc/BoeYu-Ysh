package com.BoeYu.service.impl;

import com.BoeYu.mapper.SafeUrlMapper;
import com.BoeYu.pojo.SafeUrl;
import com.BoeYu.service.SafeUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SafeUrlServiceImpl implements SafeUrlService {
    @Autowired
    private SafeUrlMapper safeUrlMapper;

    @Override
    public int insert(SafeUrl safeUrl) {
        return safeUrlMapper.insert(safeUrl);
    }

    @Override
    public List<SafeUrl> SelectSafeUrl(String childId,String type) {
        return safeUrlMapper.selectSafeUrl(childId,type);
    }

    @Override
    public int delteteSafeUrl(Integer id) {
        return safeUrlMapper.deleteByPrimaryKey(id);
    }
}
