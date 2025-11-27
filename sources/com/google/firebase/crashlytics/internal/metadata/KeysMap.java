package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class KeysMap {
    private final Map<String, String> keys = new HashMap();
    private final int maxEntries;
    private final int maxEntryLength;

    public KeysMap(int i10, int i11) {
        this.maxEntries = i10;
        this.maxEntryLength = i11;
    }

    private String sanitizeKey(String str) {
        if (str != null) {
            return sanitizeString(str, this.maxEntryLength);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public static String sanitizeString(String str, int i10) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        if (trim.length() > i10) {
            return trim.substring(0, i10);
        }
        return trim;
    }

    public synchronized Map<String, String> getKeys() {
        return Collections.unmodifiableMap(new HashMap(this.keys));
    }

    public synchronized boolean setKey(String str, String str2) {
        String sanitizeKey = sanitizeKey(str);
        if (this.keys.size() >= this.maxEntries) {
            if (!this.keys.containsKey(sanitizeKey)) {
                Logger logger = Logger.getLogger();
                logger.w("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.maxEntries);
                return false;
            }
        }
        String sanitizeString = sanitizeString(str2, this.maxEntryLength);
        if (CommonUtils.nullSafeEquals(this.keys.get(sanitizeKey), sanitizeString)) {
            return false;
        }
        Map<String, String> map = this.keys;
        if (str2 == null) {
            sanitizeString = "";
        }
        map.put(sanitizeKey, sanitizeString);
        return true;
    }

    public synchronized void setKeys(Map<String, String> map) {
        String str;
        int i10 = 0;
        for (Map.Entry next : map.entrySet()) {
            String sanitizeKey = sanitizeKey((String) next.getKey());
            if (this.keys.size() >= this.maxEntries) {
                if (!this.keys.containsKey(sanitizeKey)) {
                    i10++;
                }
            }
            String str2 = (String) next.getValue();
            Map<String, String> map2 = this.keys;
            if (str2 == null) {
                str = "";
            } else {
                str = sanitizeString(str2, this.maxEntryLength);
            }
            map2.put(sanitizeKey, str);
        }
        if (i10 > 0) {
            Logger logger = Logger.getLogger();
            logger.w("Ignored " + i10 + " entries when adding custom keys. Maximum allowable: " + this.maxEntries);
        }
    }
}
