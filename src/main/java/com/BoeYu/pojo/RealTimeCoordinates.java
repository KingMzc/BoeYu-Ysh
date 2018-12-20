package com.BoeYu.pojo;

import java.util.HashMap;
import java.util.Map;

public class RealTimeCoordinates {
    private  String childId;
    private  String Coordinates;
    private static Map<String,String> map;
    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public String getCoordinates() {
        return Coordinates;
    }

    public void setCoordinates(String coordinates) {
        Coordinates = coordinates;
    }

    public Map<String,String> get(){
        map.put(this.getChildId(),this.getCoordinates());
       return map;
    }

    public static Map<String,String> getmap(){
        return map;
    }
    public static void setmap(String childId,String coordinates){
        if (map!=null){
            map.put(childId,coordinates);
        }else{
            map = new HashMap<String,String>();
            map.put(childId,coordinates);
        }

    }
}
