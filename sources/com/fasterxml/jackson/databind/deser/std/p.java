package com.fasterxml.jackson.databind.deser.std;

import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import k3.k;

public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    public static final HashSet f5663a = new HashSet();

    static {
        Class[] clsArr = {UUID.class, AtomicBoolean.class, AtomicInteger.class, AtomicLong.class, StackTraceElement.class, ByteBuffer.class, Void.class};
        for (int i10 = 0; i10 < 7; i10++) {
            f5663a.add(clsArr[i10].getName());
        }
        for (Class name : o.g()) {
            f5663a.add(name.getName());
        }
    }

    public static k a(Class cls, String str) {
        if (!f5663a.contains(str)) {
            return null;
        }
        o f10 = o.f(cls);
        if (f10 != null) {
            return f10;
        }
        if (cls == UUID.class) {
            return new l0();
        }
        if (cls == StackTraceElement.class) {
            return new z();
        }
        if (cls == AtomicBoolean.class) {
            return new b();
        }
        if (cls == AtomicInteger.class) {
            return new c();
        }
        if (cls == AtomicLong.class) {
            return new d();
        }
        if (cls == ByteBuffer.class) {
            return new g();
        }
        if (cls == Void.class) {
            return u.f5687a;
        }
        return null;
    }
}
