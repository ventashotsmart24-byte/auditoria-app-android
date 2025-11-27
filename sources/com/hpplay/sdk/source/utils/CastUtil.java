package com.hpplay.sdk.source.utils;

import android.text.TextUtils;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.Map;

public class CastUtil {
    private static final boolean DEFAULT_ENABLE_MULTI_CHANNEL = false;
    private static final String KEY_HW_PCMODE = "ro.config.hw_emui_wfd_pc_mode";
    public static final String PLAT_TYPE_ANDROID = "android";
    public static final String PLAT_TYPE_H5 = "h5";
    public static final String PLAT_TYPE_IOS = "ios";
    public static final String PLAT_TYPE_LINUX = "linux";
    public static final String PLAT_TYPE_MAC = "Mac Os";
    public static final String PLAT_TYPE_PC = "pc";
    public static final String PLAT_TYPE_PHONE = "phone";
    private static final String TAG = "CastUtil";

    public static BrowserInfo getBrowserInfo(LelinkServiceInfo lelinkServiceInfo, int i10) {
        try {
            if (lelinkServiceInfo.getBrowserInfos() == null) {
                return null;
            }
            return lelinkServiceInfo.getBrowserInfos().get(Integer.valueOf(i10));
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    public static String getKey(LelinkServiceInfo lelinkServiceInfo) {
        if (!TextUtils.isEmpty(lelinkServiceInfo.getUid())) {
            return lelinkServiceInfo.getUid();
        }
        return lelinkServiceInfo.getIp() + lelinkServiceInfo.getName();
    }

    public static BrowserInfo getPreBrowserInfo(LelinkServiceInfo lelinkServiceInfo, int i10) {
        BrowserInfo browserInfo;
        BrowserInfo browserInfo2;
        if (i10 == 2) {
            try {
                if (!isSupportCloudMultiCast()) {
                    BrowserInfo browserInfo3 = lelinkServiceInfo.getBrowserInfos().get(1);
                    if (browserInfo3 != null) {
                        return browserInfo3;
                    }
                    if (LelinkConfig.isSupportYimMirror() && (browserInfo = lelinkServiceInfo.getBrowserInfos().get(4)) != null) {
                        return browserInfo;
                    }
                } else if (LelinkConfig.isSupportYimMirror() && (browserInfo2 = lelinkServiceInfo.getBrowserInfos().get(4)) != null) {
                    return browserInfo2;
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else if (i10 == 1) {
            if (isSupportCloudMultiCast()) {
                BrowserInfo browserInfo4 = lelinkServiceInfo.getBrowserInfos().get(4);
                if (browserInfo4 != null) {
                    return browserInfo4;
                }
            } else {
                BrowserInfo browserInfo5 = lelinkServiceInfo.getBrowserInfos().get(1);
                if (browserInfo5 != null) {
                    return browserInfo5;
                }
                BrowserInfo browserInfo6 = lelinkServiceInfo.getBrowserInfos().get(3);
                if (browserInfo6 != null) {
                    return browserInfo6;
                }
                BrowserInfo browserInfo7 = lelinkServiceInfo.getBrowserInfos().get(4);
                if (browserInfo7 != null) {
                    return browserInfo7;
                }
            }
        }
        return null;
    }

    public static BrowserInfo getPreConnectInfo(LelinkServiceInfo lelinkServiceInfo) {
        return getPreBrowserInfo(lelinkServiceInfo, 1);
    }

    public static BrowserInfo getPreMirrorInfo(LelinkServiceInfo lelinkServiceInfo) {
        return getPreBrowserInfo(lelinkServiceInfo, 2);
    }

    public static BrowserInfo getPrePushInfo(LelinkServiceInfo lelinkServiceInfo) {
        return getPreBrowserInfo(lelinkServiceInfo, 1);
    }

    public static BrowserInfo getPrePushInfoByProtocol(LelinkServiceInfo lelinkServiceInfo, int i10) {
        try {
            BrowserInfo browserInfo = lelinkServiceInfo.getBrowserInfos().get(Integer.valueOf(i10));
            if (browserInfo != null) {
                return browserInfo;
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        return getPreBrowserInfo(lelinkServiceInfo, 1);
    }

    public static String getSinkName(LelinkServiceInfo lelinkServiceInfo) {
        if (lelinkServiceInfo == null) {
            return null;
        }
        return lelinkServiceInfo.getName();
    }

    public static String getVersion() {
        return String.valueOf(41214);
    }

    public static boolean isFullScreen(int i10, BrowserInfo browserInfo) {
        if (i10 == 1) {
            return true;
        }
        if (i10 != 2 && Feature.isMUIChannel()) {
            return true;
        }
        return false;
    }

    public static boolean isSinkSupportMirror(LelinkServiceInfo lelinkServiceInfo) {
        if (isSupportLelink(lelinkServiceInfo) || isSupportIM(lelinkServiceInfo)) {
            return true;
        }
        return false;
    }

    public static boolean isSupportCloudMultiCast() {
        if (Preference.getInstance().get(Constant.KEY_CLOUD_MULTI_CAST, 0) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isSupportIM(LelinkServiceInfo lelinkServiceInfo) {
        if (lelinkServiceInfo == null) {
            return false;
        }
        try {
            if (lelinkServiceInfo.getBrowserInfos().get(4) != null) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return false;
        }
    }

    public static boolean isSupportLelink(LelinkServiceInfo lelinkServiceInfo) {
        if (lelinkServiceInfo == null) {
            return false;
        }
        try {
            if (lelinkServiceInfo.getBrowserInfos().get(1) != null) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return false;
        }
    }

    public static boolean isSupportLelinkV2(LelinkServiceInfo lelinkServiceInfo) {
        if (lelinkServiceInfo == null) {
            return false;
        }
        try {
            return isSupportLelinkV2(lelinkServiceInfo.getBrowserInfos().get(1));
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return false;
        }
    }

    public static boolean isSupportMultiChannel(LelinkServiceInfo lelinkServiceInfo) {
        if (!LelinkConfig.isSupportYimMirror()) {
            SourceLog.w(TAG, "isSupportMultiChannel false, not support cloud mirror");
            return false;
        } else if (!Feature.isLeboApp()) {
            SourceLog.w(TAG, "isSupportMultiChannel false, not lebo app");
            return false;
        } else if (!isSupportIM(lelinkServiceInfo)) {
            SourceLog.w(TAG, "isSupportMultiChannel false, has no im");
            return false;
        } else if (isSupportMultiChannel(lelinkServiceInfo, 4) || isSupportMultiChannel(lelinkServiceInfo, 1)) {
            String str = Preference.getInstance().get(Preference.KEY_MULTI_CHANNEL);
            SourceLog.w(TAG, "isSupportMultiChannel " + str);
            if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str) || Integer.parseInt(str) != 1) {
                return false;
            }
            return true;
        } else {
            SourceLog.w(TAG, "isSupportMultiChannel false, old sink");
            return false;
        }
    }

    public static boolean isUseLocalCast(LelinkServiceInfo lelinkServiceInfo) {
        BrowserInfo prePushInfo = getPrePushInfo(lelinkServiceInfo);
        if (prePushInfo == null || prePushInfo.getType() == 4) {
            return false;
        }
        return true;
    }

    public static void printSDKInfo() {
        SourceLog.i(TAG, "SDK info: 4.12.14/2023-04-20-10-00/lecast/1/ cu:" + Session.getInstance().getUID() + "/ hid:" + Session.getInstance().getHID());
    }

    public static void setLelinkPlat(LelinkServiceInfo lelinkServiceInfo, int i10) {
        if (lelinkServiceInfo != null) {
            try {
                BrowserInfo browserInfo = getBrowserInfo(lelinkServiceInfo, 1);
                if (browserInfo != null) {
                    String str = "android";
                    switch (i10) {
                        case 101:
                            str = "ios";
                            break;
                        case 102:
                            str = PLAT_TYPE_MAC;
                            break;
                        case 103:
                            str = PLAT_TYPE_PC;
                            break;
                        case 104:
                            str = PLAT_TYPE_H5;
                            break;
                        case 106:
                            str = PLAT_TYPE_LINUX;
                            break;
                        case 107:
                            str = "phone";
                            break;
                    }
                    Map<String, String> extras = browserInfo.getExtras();
                    if (extras != null) {
                        extras.put("pt", str);
                    }
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        }
    }

    public static boolean isSupportLelinkV2(BrowserInfo browserInfo) {
        if (browserInfo != null && "2".equals(browserInfo.getExtras().get("vv"))) {
            return true;
        }
        return false;
    }

    private static boolean isSupportMultiChannel(LelinkServiceInfo lelinkServiceInfo, int i10) {
        BrowserInfo browserInfo = getBrowserInfo(lelinkServiceInfo, i10);
        if (browserInfo == null) {
            return false;
        }
        try {
            if (!browserInfo.getExtras().containsKey(BrowserInfo.KEY_TUNNELS)) {
                SourceLog.w(TAG, "isSupportMultiChannel false, old sink");
                return false;
            }
            String str = browserInfo.getExtras().get(BrowserInfo.KEY_TUNNELS);
            if ("3".equals(str)) {
                return true;
            }
            SourceLog.w(TAG, "isSupportMultiChannel false, sink not support:" + str);
            return false;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }
}
