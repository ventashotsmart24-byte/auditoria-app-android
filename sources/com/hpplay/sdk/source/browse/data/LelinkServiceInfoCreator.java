package com.hpplay.sdk.source.browse.data;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.common.utils.FieldUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.bean.StrategyBean;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.android.agoo.message.MessageService;
import org.json.JSONObject;

public class LelinkServiceInfoCreator {
    private static final int BASE_PORT = 52244;
    private static final String IP_PREFIX_REGEX = "(?<!\\d)\\d{1,3}\\.\\d{1,3}(?=\\.\\d)";
    private static final String TAG = "LelinkServiceInfoCreator";

    public static LelinkServiceInfo createByServiceBrowseInfo(JSONObject jSONObject, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject2 = jSONObject;
        int i11 = i10;
        try {
            String optString = jSONObject2.optString(ParamsMap.DeviceParams.KEY_UID);
            String optString2 = jSONObject2.optString("appId");
            int optInt = jSONObject2.optInt("isOnline", 1);
            String optString3 = jSONObject2.optString("serviceBody");
            SourceLog.i(TAG, "createByServiceBrowseInfo serviceBody:" + optString3);
            if (TextUtils.isEmpty(optString3)) {
                return null;
            }
            if ("null".equals(optString3)) {
                return null;
            }
            JSONObject jSONObject3 = new JSONObject(optString3);
            String optString4 = jSONObject3.optString("ip");
            String optString5 = jSONObject3.optString("remote_port");
            String optString6 = jSONObject3.optString("localip");
            String str5 = optString4;
            String optString7 = jSONObject3.optString("localport");
            if (TextUtils.isEmpty(optString6)) {
                optString6 = str5;
            }
            if (!TextUtils.isEmpty(optString7)) {
                optString5 = optString7;
            }
            String optString8 = jSONObject3.optString("name");
            if (TextUtils.isEmpty(optString6)) {
                str2 = TAG;
                if (i11 != 11) {
                    return null;
                }
            } else {
                str2 = TAG;
            }
            try {
                String optString9 = jSONObject3.optString("bssid");
                Object obj = "name";
                String optString10 = jSONObject3.optString(BrowserInfo.KEY_FE);
                Object obj2 = "ip";
                String optString11 = jSONObject3.optString(BrowserInfo.KEY_POL);
                Object obj3 = BrowserInfo.KEY_POL;
                String optString12 = jSONObject3.optString("sdkVer");
                String optString13 = jSONObject3.optString(BrowserInfo.KEY_TUNNELS);
                Object obj4 = BrowserInfo.KEY_TUNNELS;
                String optString14 = jSONObject3.optString(BrowserInfo.KEY_VER);
                String str6 = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    str4 = jSONObject3.optString("a");
                    str3 = optString13;
                } else {
                    str3 = optString13;
                    str4 = str6;
                }
                Object obj5 = "a";
                BrowserInfo browserInfo = new BrowserInfo(4, i11);
                browserInfo.setUid(optString);
                browserInfo.setName(optString8);
                browserInfo.setIp(optString6);
                boolean z10 = true;
                if (optInt != 1) {
                    z10 = false;
                }
                browserInfo.setOnLine(z10);
                browserInfo.setPort(HapplayUtils.parsePort(optString5));
                HashMap hashMap = new HashMap();
                hashMap.put("u", optString);
                hashMap.put("bssid", optString9);
                hashMap.put(BrowserInfo.KEY_FE, optString10);
                hashMap.put(obj2, optString6);
                hashMap.put("port", optString5);
                hashMap.put(obj, optString8);
                hashMap.put(obj3, optString11);
                hashMap.put(BrowserInfo.KEY_SDK_VERSION, optString12);
                hashMap.put(BrowserInfo.KEY_VER, optString14);
                hashMap.put(obj5, str4);
                if (!TextUtils.isEmpty(str3)) {
                    hashMap.put(obj4, str3);
                }
                browserInfo.setExtras(hashMap);
                return new LelinkServiceInfo(i11, browserInfo);
            } catch (Exception e10) {
                e = e10;
                str = str2;
                SourceLog.w(str, (Throwable) e);
                return null;
            }
        } catch (Exception e11) {
            e = e11;
            str = TAG;
            SourceLog.w(str, (Throwable) e);
            return null;
        }
    }

    public static LelinkServiceInfo createByServiceTxtInfo(JSONObject jSONObject, int i10) {
        JSONObject jSONObject2 = jSONObject;
        int i11 = i10;
        String optString = jSONObject2.optString("a");
        String optString2 = jSONObject2.optString(ParamsMap.DeviceParams.KEY_UID);
        String optString3 = jSONObject2.optString("name");
        String optString4 = jSONObject2.optString(FieldUtil.getString(FieldUtil.f10533m));
        String optString5 = jSONObject2.optString("ip");
        String optString6 = jSONObject2.optString("port");
        String optString7 = jSONObject2.optString("pt");
        jSONObject2.optString("vv");
        String optString8 = jSONObject2.optString(BrowserInfo.KEY_TUNNELS);
        try {
            Object obj = BrowserInfo.KEY_TUNNELS;
            BrowserInfo browserInfo = new BrowserInfo(4, i11);
            browserInfo.setUid(optString2);
            browserInfo.setName(optString3);
            browserInfo.setIp(optString5);
            browserInfo.setOnLine(true);
            browserInfo.setPort(HapplayUtils.parsePort(optString6));
            HashMap hashMap = new HashMap();
            hashMap.put("u", optString2);
            hashMap.put("pt", optString7);
            hashMap.put("name", optString3);
            hashMap.put("ip", optString5);
            hashMap.put("port", optString6);
            hashMap.put("lelinkport", optString6);
            hashMap.put("airplay", optString6);
            hashMap.put("raop", optString6);
            hashMap.put(BrowserInfo.KEY_M, optString4);
            hashMap.put("a", optString);
            if (!TextUtils.isEmpty(optString8)) {
                hashMap.put(obj, optString8);
            }
            browserInfo.setExtras(hashMap);
            return new LelinkServiceInfo(i10, browserInfo);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    public static LelinkServiceInfo createIMServiceByUID(String str, String str2, String str3, String str4, String str5, int i10) {
        try {
            BrowserInfo browserInfo = new BrowserInfo(4, i10);
            browserInfo.setUid(str2);
            browserInfo.setOnLine(true);
            browserInfo.setName(str3);
            HashMap hashMap = new HashMap();
            hashMap.put("u", str2);
            hashMap.put("pt", str4);
            hashMap.put("a", str);
            hashMap.put("vv", "2");
            hashMap.put(BrowserInfo.KEY_TUNNELS, str5);
            browserInfo.setExtras(hashMap);
            return new LelinkServiceInfo(i10, browserInfo);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    public static LelinkServiceInfo createNfcServiceInfo(Map<String, String> map) {
        if (map != null) {
            try {
                if (map.size() > 0) {
                    LelinkServiceInfo lelinkServiceInfo = new LelinkServiceInfo();
                    lelinkServiceInfo.setUid(map.get(BrowserInfo.KEY_CNAME));
                    lelinkServiceInfo.setIp(map.get("ip"));
                    lelinkServiceInfo.setPort(Integer.parseInt(map.get(BrowserInfo.KEY_REMOTEPORT)));
                    lelinkServiceInfo.setName(map.get(BrowserInfo.KEY_DEVICE_NAME));
                    BrowserInfo browserInfo = new BrowserInfo(1, 7);
                    browserInfo.setIp(map.get("ip"));
                    browserInfo.setName(map.get(BrowserInfo.KEY_DEVICE_NAME));
                    browserInfo.setUid(map.get(BrowserInfo.KEY_CNAME));
                    browserInfo.setPort(Integer.parseInt(map.get(BrowserInfo.KEY_REMOTEPORT)));
                    HashMap hashMap = new HashMap();
                    hashMap.put("name", map.get(BrowserInfo.KEY_DEVICE_NAME));
                    hashMap.put("ip", map.get("ip"));
                    hashMap.put("u", map.get(BrowserInfo.KEY_CNAME));
                    hashMap.put("lelinkport", map.get(BrowserInfo.KEY_REMOTEPORT));
                    hashMap.put("port", map.get(BrowserInfo.KEY_REMOTEPORT));
                    hashMap.put("raop", map.get(BrowserInfo.KEY_REMOTEPORT));
                    hashMap.put("airplay", map.get(BrowserInfo.KEY_REMOTEPORT));
                    hashMap.put("vv", "2");
                    hashMap.put("version", "2.0");
                    browserInfo.setExtras(hashMap);
                    lelinkServiceInfo.updateByBrowseInfo(browserInfo);
                    return lelinkServiceInfo;
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, e10.toString());
            }
        }
        return null;
    }

    private static LelinkServiceInfo getCacheInfo(int i10, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        String optString = jSONObject.optString("u");
        String optString2 = jSONObject.optString("name");
        BrowserInfo browserInfo = new BrowserInfo(4, 4);
        browserInfo.setUid(optString);
        browserInfo.setName(optString2);
        HashMap hashMap = new HashMap();
        hashMap.put("u", optString);
        hashMap.put(BrowserInfo.KEY_DEVICE_NAME, optString2);
        browserInfo.setExtras(hashMap);
        return new LelinkServiceInfo(i10, browserInfo);
    }

    public static LelinkServiceInfo getConferenceFuzzyMatchingInfo(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            SourceLog.i(TAG, "getConferenceFuzzyMatchingInfo data json is empty");
            return null;
        }
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("ip");
        int optInt = jSONObject.optInt("linkPort");
        String optString3 = jSONObject.optString("raopPort");
        BrowserInfo browserInfo = new BrowserInfo(1, 6);
        browserInfo.setName(optString);
        browserInfo.setIp(optString2);
        browserInfo.setPort(optInt);
        HashMap hashMap = new HashMap();
        hashMap.put("raop", optString3);
        hashMap.put("lelinkport", String.valueOf(optInt));
        hashMap.put("vv", "2");
        hashMap.put(BrowserInfo.KEY_ISCONFERENCE, "1");
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.optString(next));
        }
        browserInfo.setExtras(hashMap);
        LelinkServiceInfo lelinkServiceInfo = new LelinkServiceInfo(6, browserInfo);
        lelinkServiceInfo.setPinCode(jSONObject.optString(Constants.KEY_HTTP_CODE));
        return lelinkServiceInfo;
    }

    public static LelinkServiceInfo getConferenceInfo(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 == null || jSONObject.length() <= 0) {
            SourceLog.i(TAG, "getConferenceInfo data json is empty");
            return null;
        }
        String optString = jSONObject2.optString("name");
        String optString2 = jSONObject2.optString("ip");
        int optInt = jSONObject2.optInt("linkPort");
        String optString3 = jSONObject2.optString("raopPort");
        String optString4 = jSONObject2.optString(BrowserInfo.KEY_AGENT_PORT);
        BrowserInfo browserInfo = new BrowserInfo(1, 6);
        browserInfo.setName(optString);
        browserInfo.setIp(optString2);
        browserInfo.setPort(optInt);
        try {
            StrategyBean instance = StrategyBean.getInstance();
            JSONObject optJSONObject = jSONObject2.optJSONObject("testingConfig");
            int optInt2 = optJSONObject.optInt(Constants.KEY_TIMES);
            int optInt3 = optJSONObject.optInt("cumulativeNumber");
            int optInt4 = optJSONObject.optInt("delayTime");
            int optInt5 = optJSONObject.optInt("intervalTime");
            int optInt6 = optJSONObject.optInt("toastStatus");
            instance.setCumulativeNumber(optInt3 * 1000);
            instance.setDuration((long) (optInt2 * 60 * 1000));
            instance.setToastStatus(optInt6);
            instance.setIntervalCount(optInt5);
            instance.setTimeout((long) optInt4);
        } catch (Exception e10) {
            SourceLog.w(TAG, "", e10);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("raop", optString3);
        hashMap.put(BrowserInfo.KEY_AGENT_PORT, optString4);
        hashMap.put("lelinkport", String.valueOf(optInt));
        hashMap.put("vv", "2");
        hashMap.put(BrowserInfo.KEY_ISCONFERENCE, "1");
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject2.optString(next));
        }
        browserInfo.setExtras(hashMap);
        LelinkServiceInfo lelinkServiceInfo = new LelinkServiceInfo(6, browserInfo);
        lelinkServiceInfo.setPinCode(str);
        return lelinkServiceInfo;
    }

    public static LelinkServiceInfo getLelinkTxtInfo(String str, String str2, String str3, String str4, String str5, String str6, int i10) {
        try {
            JSONObject optJSONObject = new JSONObject(str6).optJSONObject("leLinkTxt");
            if (optJSONObject != null) {
                if (optJSONObject.length() > 0) {
                    BrowserInfo browserInfo = new BrowserInfo(1, i10);
                    browserInfo.setUid(str);
                    browserInfo.setName(str2);
                    browserInfo.setIp(str3);
                    browserInfo.setLocalWifi(true);
                    browserInfo.setOnLine(true);
                    browserInfo.setPort(HapplayUtils.parsePort(str4));
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, optJSONObject.optString(next));
                    }
                    hashMap.put("pt", str5);
                    hashMap.put("htv", "1");
                    browserInfo.setExtras(hashMap);
                    return new LelinkServiceInfo(2, browserInfo);
                }
            }
            SourceLog.i(TAG, "getLelinkTxtInfo lelinkTxt is empty");
            return null;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    public static LelinkServiceInfo getLocalCacheInfo(JSONObject jSONObject) {
        return getCacheInfo(3, jSONObject);
    }

    public static LelinkServiceInfo getLocalPinCodeInfo(Context context, String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str) || str.length() != 9) {
            SourceLog.i(TAG, "PinCode is empty or PinCode length not equlas 9");
        } else if (str.startsWith("7") || str.startsWith(MessageService.MSG_ACCS_NOTIFY_CLICK) || str.startsWith(MessageService.MSG_ACCS_NOTIFY_DISMISS)) {
            int parseInt = Integer.parseInt(str.substring(1, 4));
            int parseInt2 = (parseInt * Integer.parseInt(str.substring(6, 8))) + Integer.parseInt(str.substring(4, 6));
            int parseInt3 = Integer.parseInt(str.substring(8)) + BASE_PORT;
            int i10 = parseInt2 / 256;
            int i11 = parseInt2 % 256;
            Matcher matcher = Pattern.compile(IP_PREFIX_REGEX).matcher(DeviceUtil.getIPAddress(context));
            if (matcher.find()) {
                String group = matcher.group();
                str2 = String.format(Locale.getDefault(), "%s.%d.%d", new Object[]{group, Integer.valueOf(i10), Integer.valueOf(i11)});
            }
            BrowserInfo browserInfo = new BrowserInfo(1, 5);
            browserInfo.setIp(str2);
            browserInfo.setPort(parseInt3);
            HashMap hashMap = new HashMap();
            hashMap.put("ip", str2);
            hashMap.put("port", String.valueOf(parseInt3));
            hashMap.put("airplay", String.valueOf(parseInt3));
            hashMap.put("lelinkport", String.valueOf(parseInt3));
            hashMap.put("raop", String.valueOf(parseInt3));
            browserInfo.setExtras(hashMap);
            LelinkServiceInfo lelinkServiceInfo = new LelinkServiceInfo(5, browserInfo);
            lelinkServiceInfo.setPinCode(str);
            return lelinkServiceInfo;
        }
        return null;
    }

    public static LelinkServiceInfo getNetPinCodeInfo(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 == null || jSONObject.length() <= 0) {
            SourceLog.i(TAG, "getNetPinCodeInfo data json is empty");
            return null;
        }
        String optString = jSONObject2.optString("ip");
        String optString2 = jSONObject2.optString(ParamsMap.DeviceParams.KEY_RAOP_PORT);
        String optString3 = jSONObject2.optString(ParamsMap.DeviceParams.KEY_AIRPLAY_PORT);
        String optString4 = jSONObject2.optString(ParamsMap.DeviceParams.KEY_MIRROR_PORT);
        int optInt = jSONObject2.optInt("link_port");
        jSONObject2.optString("agent_port");
        String optString5 = jSONObject2.optString("remote_port");
        String optString6 = jSONObject2.optString(FieldUtil.getString(FieldUtil.f10533m));
        String optString7 = jSONObject2.optString("version");
        jSONObject2.optString("tmp");
        jSONObject2.optString("hostname");
        String optString8 = jSONObject2.optString("name");
        jSONObject2.optString("extendStr");
        String optString9 = jSONObject2.optString("pt");
        String optString10 = jSONObject2.optString(BrowserInfo.KEY_TUNNELS);
        Object obj = BrowserInfo.KEY_TUNNELS;
        BrowserInfo browserInfo = new BrowserInfo(1, 5);
        browserInfo.setName(optString8);
        browserInfo.setIp(optString);
        browserInfo.setPort(optInt);
        HashMap hashMap = new HashMap();
        hashMap.put("ip", optString);
        hashMap.put("lelinkport", String.valueOf(optInt));
        hashMap.put("airplay", optString3);
        hashMap.put("mirror", optString4);
        hashMap.put("remote", optString5);
        hashMap.put("raop", optString2);
        hashMap.put("version", optString7);
        hashMap.put(BrowserInfo.KEY_M, optString6);
        hashMap.put("pt", optString9);
        hashMap.put(obj, optString10);
        browserInfo.setExtras(hashMap);
        LelinkServiceInfo lelinkServiceInfo = new LelinkServiceInfo(6, browserInfo);
        lelinkServiceInfo.setPinCode(str);
        return lelinkServiceInfo;
    }

    public static LelinkServiceInfo getQRCodeInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            Map<String, String> urlParams = getUrlParams(str);
            if (urlParams == null || urlParams.isEmpty()) {
                SourceLog.i(TAG, "getQRCodeInfo param is empty");
                return null;
            }
            BrowserInfo browserInfo = new BrowserInfo(4, 2);
            HashMap hashMap = new HashMap();
            browserInfo.setUid(urlParams.get(BrowserInfo.KEY_CNAME));
            browserInfo.setName(urlParams.get(BrowserInfo.KEY_DEVICE_NAME));
            browserInfo.setIp(urlParams.get("ip"));
            browserInfo.setPort(HapplayUtils.parsePort(urlParams.get(BrowserInfo.KEY_REMOTEPORT)));
            for (Map.Entry next : urlParams.entrySet()) {
                hashMap.put(next.getKey(), next.getValue());
            }
            browserInfo.setExtras(hashMap);
            return new LelinkServiceInfo(2, browserInfo);
        }
        throw new IllegalArgumentException("qrUrl can't not be empty");
    }

    public static LelinkServiceInfo getRemoteCacheInfo(JSONObject jSONObject) {
        return getCacheInfo(4, jSONObject);
    }

    private static Map<String, String> getUrlParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String split : str.split(DispatchConstants.SIGN_SPLIT_SYMBOL)) {
            String[] split2 = split.split(Operator.Operation.EQUALS);
            if (split2.length == 2) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        return hashMap;
    }
}
