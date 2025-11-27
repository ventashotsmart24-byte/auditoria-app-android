package com.hpplay.common.utils;

public class WifiInfoCache {
    public static String wIdbss;
    public static String wIdbssNoneColon;
    public static String wIdss;

    public static void clearCache() {
        wIdss = null;
        wIdbss = null;
        wIdbssNoneColon = null;
    }
}
