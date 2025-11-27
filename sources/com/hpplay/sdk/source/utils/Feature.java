package com.hpplay.sdk.source.utils;

import com.hpplay.sdk.source.api.BuildConfig;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.config.LelinkConfig;

public class Feature {
    private static final String TAG = "Feature";

    public static String cloudMirrorSupportProtocol() {
        if (hasCloudMirror()) {
            return "4";
        }
        return "0";
    }

    public static boolean hasCloudMirror() {
        return LelinkConfig.isSupportYimMirror();
    }

    public static boolean isAuthFailedBrowse() {
        if (isBilibiliChannel() || isVivoChannel() || isOPPOChannel() || isSmartis() || isMUIChannel() || isXunleiChannel() || isNubiaChannel() || isHweiChannel()) {
            return true;
        }
        return false;
    }

    public static boolean isBilibiliChannel() {
        return LelinkConfig.getSdkChannel().equals("bilibili");
    }

    @Deprecated
    public static boolean isConferenceSDK() {
        return false;
    }

    public static boolean isDisableCrs(String str) {
        if (Channel.BAIDU_NET_DISK.equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean isDisableIM() {
        if (Session.getInstance().isDisableIM() || isOPPOChannel() || isZTEChannel() || isNubiaChannel()) {
            return true;
        }
        return false;
    }

    public static boolean isHappyTest() {
        if (LelinkConfig.getSdkChannel().equals("happytest") || LelinkConfig.getSdkChannel().equals(BuildConfig.SDK_CHANNEL)) {
            return true;
        }
        return false;
    }

    public static boolean isHisenChannel() {
        return LelinkConfig.getSdkChannel().equals("hisen");
    }

    public static boolean isHweiChannel() {
        return new StringBuilder(LelinkConfig.getSdkChannel()).reverse().toString().equals("iewauh");
    }

    public static boolean isHwpad() {
        return LelinkConfig.getSdkChannel().equals("hwpad");
    }

    public static boolean isKangka() {
        return LelinkConfig.getSdkChannel().equals("kangka");
    }

    public static boolean isLeboApp() {
        return LelinkConfig.getSdkChannel().equals("leboapk");
    }

    public static boolean isMUIChannel() {
        return LelinkConfig.getSdkChannel().equals("mui");
    }

    public static boolean isMirrorCustomMode() {
        if (isMUIChannel() || isVivoChannel() || isOPPOChannel() || isNubiaChannel() || isSmartis() || isHweiChannel()) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static boolean isMirrorMode() {
        return false;
    }

    public static boolean isNubiaChannel() {
        return LelinkConfig.getSdkChannel().equals("nubia");
    }

    public static boolean isOPPOChannel() {
        return LelinkConfig.getSdkChannel().equals("oppo");
    }

    public static boolean isPhone360() {
        return LelinkConfig.getSdkChannel().equals("phone360");
    }

    public static boolean isPico() {
        return "12663".equals(Session.getInstance().appKey);
    }

    public static boolean isSmartis() {
        return LelinkConfig.getSdkChannel().equals("smartis");
    }

    public static boolean isTclChannel() {
        return LelinkConfig.getSdkChannel().equals("tcl");
    }

    public static boolean isVivoChannel() {
        if (LelinkConfig.getSdkChannel().equals("vivo") || LelinkConfig.getSdkChannel().equals("vivo2")) {
            return true;
        }
        return false;
    }

    public static boolean isVmosChannel() {
        return LelinkConfig.getSdkChannel().equals("vmos");
    }

    public static boolean isXigua() {
        return LelinkConfig.getSdkChannel().equals("xigua");
    }

    public static boolean isXunleiChannel() {
        return LelinkConfig.getSdkChannel().equals("xunlei");
    }

    public static boolean isYoulexueChannel() {
        return LelinkConfig.getSdkChannel().equals("ylx");
    }

    public static boolean isZTEChannel() {
        return "zte".equals(LelinkConfig.getSdkChannel());
    }
}
