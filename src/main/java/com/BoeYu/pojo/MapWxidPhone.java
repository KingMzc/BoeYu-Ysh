package com.BoeYu.pojo;

import java.util.Map;

public class MapWxidPhone {
    private static Map<String,String> map;

    public static Map<String, String> getMap() {
        return map;
    }

    public static void setMap(Map<String, String> map) {
        MapWxidPhone.map = map;
    }
}
