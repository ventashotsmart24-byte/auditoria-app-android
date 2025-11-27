package com.taobao.accs.client;

import android.content.Context;
import com.taobao.accs.ChannelService;
import com.taobao.accs.IProcessName;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.t;

public class GlobalConfig {
    private static boolean enableAlarmHeartbeat = false;
    public static boolean enableCookie = true;
    private static boolean enableJobHeartbeat = false;
    public static AccsConfig.ACCS_GROUP mGroup = AccsConfig.ACCS_GROUP.OPEN;
    private static int sReportThirdTokenDelay = 10;

    public static int getReportThirdTokenDelay() {
        return sReportThirdTokenDelay;
    }

    public static boolean isAlarmHeartbeatEnable() {
        return enableAlarmHeartbeat;
    }

    public static boolean isJobHeartbeatEnable() {
        return enableJobHeartbeat;
    }

    public static void setAlarmHeartbeatEnable(boolean z10) {
        ALog.d("GlobalConfig", "setAlarmHeartbeatEnable", "enable", Boolean.valueOf(z10));
        enableAlarmHeartbeat = z10;
    }

    public static void setChannelProcessName(String str) {
        a.f12916d = str;
    }

    public static void setChannelReuse(boolean z10, AccsConfig.ACCS_GROUP accs_group) {
        GlobalClientInfo.f12902d = z10;
        mGroup = accs_group;
    }

    public static void setControlFrameMaxRetry(int i10) {
        Message.CONTROL_MAX_RETRY_TIMES = i10;
    }

    public static void setCurrProcessNameImpl(IProcessName iProcessName) {
        a.f12917e = iProcessName;
    }

    public static void setEnableForeground(Context context, boolean z10) {
        int i10 = 0;
        ALog.i("GlobalConfig", "setEnableForeground", "enable", Boolean.valueOf(z10));
        if (z10) {
            i10 = 21;
        }
        t.a(context, ChannelService.SUPPORT_FOREGROUND_VERSION_KEY, i10);
    }

    public static void setJobHeartbeatEnable(boolean z10) {
        ALog.d("GlobalConfig", "setJobHeartBeatEnable", "enable", Boolean.valueOf(z10));
        enableJobHeartbeat = z10;
    }

    public static void setMainProcessName(String str) {
        a.f12915c = str;
    }

    public static void setReportThirdTokenDelay(int i10) {
        if (i10 < 0) {
            sReportThirdTokenDelay = 0;
        } else {
            sReportThirdTokenDelay = Math.min(i10, 10);
        }
    }
}
