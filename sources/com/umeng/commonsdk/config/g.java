package com.umeng.commonsdk.config;

import com.umeng.commonsdk.debug.UMRTLog;
import org.android.agoo.common.Config;

public class g implements e {
    public void a(String str, Object obj, String[] strArr) {
        if (str != null && str.length() > 0) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong == -1) {
                    UMRTLog.e(Config.TAG, "--->>> SensitiveFieldHandler: handleConfigItem: invalid config value.");
                    return;
                }
                UMRTLog.i(Config.TAG, "--->>> CollectFieldJudgment: handleConfigItem: item : " + str);
                if (obj != null && (obj instanceof b)) {
                    int i10 = 0;
                    while (i10 < strArr.length) {
                        try {
                            String str2 = strArr[i10];
                            if (d.a(str2)) {
                                ((b) obj).a(str2, Boolean.valueOf(a.a(parseLong, i10)));
                            }
                            i10++;
                        } catch (Throwable unused) {
                            return;
                        }
                    }
                }
            } catch (Throwable unused2) {
                UMRTLog.e(Config.TAG, "--->>> SensitiveFieldHandler: handleConfigItem: parseLong exception.");
            }
        }
    }
}
