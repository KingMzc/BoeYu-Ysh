package com.BoeYu.service;

import com.BoeYu.pojo.SafeUrl;

import java.util.List;

public interface SafeUrlService {
    int insert(SafeUrl record);

    List<SafeUrl> SelectSafeUrl(String childId,String type);

    int delteteSafeUrl(Integer id);
}
