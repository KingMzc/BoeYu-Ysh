package com.BoeYu.service.impl;

import com.BoeYu.mapper.RegionMapper;
import com.BoeYu.mapper.RegionTimeMapper;
import com.BoeYu.mapper.SafeUrlMapper;
import com.BoeYu.pojo.Region;
import com.BoeYu.pojo.RegionTime;
import com.BoeYu.pojo.RegionTimes;
import com.BoeYu.pojo.SafeUrl;
import com.BoeYu.service.SafeUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SafeUrlServiceImpl implements SafeUrlService {
    @Autowired
    private SafeUrlMapper safeUrlMapper;
    @Autowired
    private RegionMapper regionMapper;
    @Autowired
    private RegionTimeMapper regionTimeMapper;

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

    @Override
    public int CheckRegion(String childId) {
        return regionMapper.CheckRegion(childId);
    }

    @Override
    public void addRegion(String childId, String coordinate) {
        int flag = 0;
        Region region = new  Region();
        region.setFkChildId(childId);
        region.setCoordinate(coordinate);
        region.setCreatetime(new Date());
        region.setMater("1000");
        RegionTime regionTime =new RegionTime();
        regionTime.setStarttime("00:00");
        regionTime.setEndtime("23:59");
        region.setName("家");
        regionMapper.addRegion(region);
        regionTime.setFkRegionId(region.getId().toString());
        for (int i=1;i<=7;i++){
            regionTime.setWeek(String.valueOf(i));
            regionTimeMapper.insert(regionTime);
        }
        region.setId(null);
        region.setName("学校");
        regionMapper.addRegion(region);
        regionTime.setFkRegionId(region.getId().toString());
        for (int i=1;i<=7;i++){
            regionTime.setWeek(String.valueOf(i));
            regionTimeMapper.insert(regionTime);
        }

    }

    @Override
    public void deleteRegion(String childId) {
        regionMapper.deleteRegion(childId);
    }

    @Override
    public int UpdateRegionCoordinate(String regionId, String coordinate) {
        Region region = new  Region();
        region.setId(Integer.valueOf(regionId));
        region.setCoordinate(coordinate);
        return regionMapper.UpdateRegionCoordinate(region);
    }

    @Override
    public int UpdateRegionMater(String regionId, String mater) {
        Region region = new  Region();
        region.setId(Integer.valueOf(regionId));
        region.setMater(mater);
        return regionMapper.UpdateRegionMater(region);
    }

    @Override
    public int UpdateRegionName(String regionId, String name) {
        Region region = new  Region();
        region.setId(Integer.valueOf(regionId));
        region.setName(name);
        return regionMapper.UpdateRegionName(region);
    }

    @Override
    public int UpdateRegionTimes(String regionId, String week, String startTime, String endTime) {
        RegionTime regionTime =new RegionTime();
        regionTime.setFkRegionId(regionId);
        regionTime.setWeek(week);
        regionTime.setStarttime(startTime);
        regionTime.setEndtime(endTime);
        return regionTimeMapper.UpdateRegionTimes(regionTime);
    }

    @Override
    public int addNewRegion(String childId, String name, String coordinate) {
        int flag=0;
        Region region = new  Region();
        region.setFkChildId(childId);
        region.setCoordinate(coordinate);
        region.setCreatetime(new Date());
        region.setMater("1000");
        RegionTime regionTime =new RegionTime();
        regionTime.setStarttime("");
        regionTime.setEndtime("");
        region.setName(name);
        regionMapper.addRegion(region);
        regionTime.setFkRegionId(region.getId().toString());
        for (int i=1;i<=7;i++){
            regionTime.setWeek(String.valueOf(i));
            if (regionTimeMapper.insert(regionTime)>0){
                flag++;
            }
        }
        return flag;
    }

    @Override
    public int deleteRegionByID(String regionId) {
        return regionMapper.delete(regionId);
    }

    @Override
    public int deleteRegionTime(String regionId) {
        return regionTimeMapper.deleteRegionTimes(regionId);
    }

    @Override
    public Region SelectRegion(String regionId) {
        return regionMapper.selectByPrimaryKey(Integer.valueOf(regionId));
    }

    @Override
    public List<RegionTime> SelectRegionTime(String regionId) {
        return regionTimeMapper.SelectRegionTime(regionId);
    }

    @Override
    public List<RegionTimes> SelectRegionBychildId(String android, String week) {
        return regionMapper.selectRegionBychildId(android,week);
    }

    @Override
    public List<Region> SelectRegions(String childId) {
        return regionMapper.SelectRegions(childId);
    }
}
