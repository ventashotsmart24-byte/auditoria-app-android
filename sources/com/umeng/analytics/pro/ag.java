package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class ag implements ac {

    /* renamed from: a  reason: collision with root package name */
    private Set<Integer> f13719a = null;

    public ag(Set<Integer> set) {
        this.f13719a = new HashSet(set);
    }

    public boolean a() {
        try {
            int i10 = Calendar.getInstance().get(11);
            Set<Integer> set = this.f13719a;
            if (set != null && set.contains(Integer.valueOf(i10))) {
                return true;
            }
            String str = "";
            for (Integer num : this.f13719a) {
                str = str + num + ",";
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "HourOn skipped. hour of day: " + i10 + "; config: " + str);
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean b() {
        return !a();
    }

    public long c() {
        return 0;
    }
}
