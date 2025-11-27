package com.fasterxml.jackson.databind.ser.std;

import c3.h;
import java.text.DateFormat;
import java.util.Date;
import k3.c0;

public class k extends l {

    /* renamed from: d  reason: collision with root package name */
    public static final k f5767d = new k();

    public k() {
        this((Boolean) null, (DateFormat) null);
    }

    public long g(Date date) {
        if (date == null) {
            return 0;
        }
        return date.getTime();
    }

    /* renamed from: h */
    public void serialize(Date date, h hVar, c0 c0Var) {
        if (d(c0Var)) {
            hVar.e0(g(date));
        } else {
            e(date, hVar, c0Var);
        }
    }

    /* renamed from: i */
    public k f(Boolean bool, DateFormat dateFormat) {
        return new k(bool, dateFormat);
    }

    public k(Boolean bool, DateFormat dateFormat) {
        super(Date.class, bool, dateFormat);
    }
}
