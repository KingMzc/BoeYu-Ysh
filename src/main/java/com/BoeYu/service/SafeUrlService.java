package com.BoeYu.service;

import com.BoeYu.pojo.Region;
import com.BoeYu.pojo.RegionTime;
import com.BoeYu.pojo.RegionTimes;
import com.BoeYu.pojo.SafeUrl;

import java.util.List;

public interface SafeUrlService {
    int insert(SafeUrl record);

    List<SafeUrl> SelectSafeUrl(String childId,String type);

    int delteteSafeUrl(Integer id);

    int CheckRegion(String childId);

    void addRegion(String childId,String coordinate);

    void deleteRegion(String childId);

    int UpdateRegionCoordinate(String regionId,String coordinate);

    int UpdateRegionMater(String regionId,String mater);

    int UpdateRegionName(String regionId,String name);

    int UpdateRegionTimes(String regionId,String week,String startTime,String endTime);

    int addNewRegion(String childId,String name,String coordinate);

    int deleteRegionByID(String regionId);

    int deleteRegionTime(String regionId);

    Region SelectRegion(String regionId);

    List<RegionTime> SelectRegionTime(String regionId);

    List<RegionTimes> SelectRegionBychildId(String android,String week);

    List<Region> SelectRegions(String childId);
}
