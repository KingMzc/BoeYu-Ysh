package com.BoeYu.service.impl;

import com.BoeYu.mapper.AppRecordMapper;
import com.BoeYu.pojo.AppRecord;
import com.BoeYu.service.AppTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppTypeServiceImpl implements AppTypeService {
    @Autowired
    private AppRecordMapper appRecordMapper;
    @Override
    public List<AppRecord> GetAppType(String childId) {
        return appRecordMapper.GetAppType(childId);
    }

    @Override
    public int updateAppType(String id, String type) {
        return appRecordMapper.updateAppType(id,type);
    }
}
