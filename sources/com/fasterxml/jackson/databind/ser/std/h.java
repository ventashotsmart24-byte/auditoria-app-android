package com.fasterxml.jackson.databind.ser.std;

import java.text.DateFormat;
import java.util.Calendar;
import k3.c0;

public class h extends l {

    /* renamed from: d  reason: collision with root package name */
    public static final h f5766d = new h();

    public h() {
        this((Boolean) null, (DateFormat) null);
    }

    public long g(Calendar calendar) {
        if (calendar == null) {
            return 0;
        }
        return calendar.getTimeInMillis();
    }

    /* renamed from: h */
    public void serialize(Calendar calendar, c3.h hVar, c0 c0Var) {
        if (d(c0Var)) {
            hVar.e0(g(calendar));
        } else {
            e(calendar.getTime(), hVar, c0Var);
        }
    }

    /* renamed from: i */
    public h f(Boolean bool, DateFormat dateFormat) {
        return new h(bool, dateFormat);
    }

    public h(Boolean bool, DateFormat dateFormat) {
        super(Calendar.class, bool, dateFormat);
    }
}
