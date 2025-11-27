package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class am implements ac {

    /* renamed from: a  reason: collision with root package name */
    private Set<Integer> f13730a = null;

    public am(Set<Integer> set) {
        this.f13730a = new HashSet(set);
    }

    public boolean a() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(System.currentTimeMillis());
            int i10 = 7;
            int i11 = instance.get(7) - 1;
            if (i11 != 0) {
                i10 = i11;
            }
            Set<Integer> set = this.f13730a;
            if (set != null && set.contains(Integer.valueOf(i10))) {
                return true;
            }
            String str = "";
            for (Integer num : this.f13730a) {
                str = str + num + ",";
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "WeekOn skipped. day of week: " + i10 + "; config: " + str);
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
