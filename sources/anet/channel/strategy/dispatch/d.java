package anet.channel.strategy.dispatch;

import android.os.Build;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anet.channel.util.c;
import com.taobao.accs.antibrush.b;
import java.util.Map;
import java.util.Set;

class d {
    public static final String TAG = "amdc.DispatchParamBuilder";

    public static Map a(Map<String, Object> map) {
        IAmdcSign sign = AmdcRuntimeInfo.getSign();
        if (sign == null || TextUtils.isEmpty(sign.getAppkey())) {
            ALog.e(TAG, "amdc sign is null or appkey is empty", (String) null, new Object[0]);
            return null;
        }
        NetworkStatusHelper.NetworkStatus status = NetworkStatusHelper.getStatus();
        if (!NetworkStatusHelper.isConnected()) {
            ALog.e(TAG, "no network, don't send amdc request", (String) null, new Object[0]);
            return null;
        }
        map.put("appkey", sign.getAppkey());
        map.put("v", "5.0");
        map.put(DispatchConstants.PLATFORM, "android");
        map.put(DispatchConstants.PLATFORM_VERSION, Build.VERSION.RELEASE);
        if (!TextUtils.isEmpty(GlobalAppRuntimeInfo.getUserId())) {
            map.put("sid", GlobalAppRuntimeInfo.getUserId());
        }
        map.put(DispatchConstants.NET_TYPE, status.toString());
        map.put("carrier", NetworkStatusHelper.getCarrier());
        map.put(DispatchConstants.MNC, NetworkStatusHelper.getSimOp());
        if (AmdcRuntimeInfo.latitude != 0.0d) {
            map.put("lat", String.valueOf(AmdcRuntimeInfo.latitude));
        }
        if (AmdcRuntimeInfo.longitude != 0.0d) {
            map.put("lng", String.valueOf(AmdcRuntimeInfo.longitude));
        }
        map.putAll(AmdcRuntimeInfo.getParams());
        map.put("channel", AmdcRuntimeInfo.appChannel);
        map.put(DispatchConstants.APP_NAME, AmdcRuntimeInfo.appName);
        map.put("appVersion", AmdcRuntimeInfo.appVersion);
        map.put(DispatchConstants.STACK_TYPE, Integer.toString(a()));
        map.put("domain", b(map));
        map.put(DispatchConstants.SIGNTYPE, sign.useSecurityGuard() ? b.KEY_SEC : "noSec");
        map.put("t", String.valueOf(System.currentTimeMillis()));
        String a10 = a(sign, map);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        map.put("sign", a10);
        return map;
    }

    private static String b(Map map) {
        StringBuilder sb = new StringBuilder();
        for (String append : (Set) map.remove(DispatchConstants.HOSTS)) {
            sb.append(append);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static int a() {
        int c10 = c.c();
        if (c10 != 2) {
            return c10 != 3 ? 4 : 1;
        }
        return 2;
    }

    public static String a(IAmdcSign iAmdcSign, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(anet.channel.strategy.utils.d.d(map.get("appkey")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get("domain")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get(DispatchConstants.APP_NAME)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get("appVersion")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get("bssid")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get("channel")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get("deviceId")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get("lat")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get("lng")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get(DispatchConstants.MACHINE)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get(DispatchConstants.NET_TYPE)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get(DispatchConstants.OTHER)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get(DispatchConstants.PLATFORM)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get(DispatchConstants.PLATFORM_VERSION)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get(DispatchConstants.PRE_IP)));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get("sid")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get("t")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get("v")));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(anet.channel.strategy.utils.d.d(map.get(DispatchConstants.SIGNTYPE)));
        try {
            return iAmdcSign.sign(sb.toString());
        } catch (Exception e10) {
            ALog.e(TAG, "get sign failed", (String) null, e10, new Object[0]);
            return null;
        }
    }
}
