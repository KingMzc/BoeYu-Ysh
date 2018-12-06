package com.BoeYu.service;

import com.BoeYu.pojo.AppRecord;

import java.util.List;

public interface AppTypeService  {
    List<AppRecord> GetAppType(String childId);

    int updateAppType(String id,String type);
}
