package com.umeng.analytics.pro;

import com.raizlabs.android.dbflow.sql.language.Operator;

public final class de {

    /* renamed from: a  reason: collision with root package name */
    public final String f14137a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f14138b;

    /* renamed from: c  reason: collision with root package name */
    public final int f14139c;

    public de() {
        this("", (byte) 0, 0);
    }

    public boolean a(de deVar) {
        if (this.f14137a.equals(deVar.f14137a) && this.f14138b == deVar.f14138b && this.f14139c == deVar.f14139c) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof de) {
            return a((de) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.f14137a + "' type: " + this.f14138b + " seqid:" + this.f14139c + Operator.Operation.GREATER_THAN;
    }

    public de(String str, byte b10, int i10) {
        this.f14137a = str;
        this.f14138b = b10;
        this.f14139c = i10;
    }
}
