package com.umeng.analytics.pro;

import com.raizlabs.android.dbflow.sql.language.Operator;

public class db {

    /* renamed from: a  reason: collision with root package name */
    public final String f14129a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f14130b;

    /* renamed from: c  reason: collision with root package name */
    public final short f14131c;

    public db() {
        this("", (byte) 0, 0);
    }

    public boolean a(db dbVar) {
        if (this.f14130b == dbVar.f14130b && this.f14131c == dbVar.f14131c) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "<TField name:'" + this.f14129a + "' type:" + this.f14130b + " field-id:" + this.f14131c + Operator.Operation.GREATER_THAN;
    }

    public db(String str, byte b10, short s10) {
        this.f14129a = str;
        this.f14130b = b10;
        this.f14131c = s10;
    }
}
