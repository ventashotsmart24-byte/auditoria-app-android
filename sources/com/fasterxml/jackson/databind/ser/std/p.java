package com.fasterxml.jackson.databind.ser.std;

import a4.i;
import c3.h;
import c3.n;
import i3.b;
import java.net.InetAddress;
import k3.c0;

public class p extends h0 implements i {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5776a;

    public p() {
        this(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0025 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.o b(k3.c0 r2, k3.d r3) {
        /*
            r1 = this;
            java.lang.Class r0 = r1.handledType()
            b3.k$d r2 = r1.findFormatOverrides(r2, r3, r0)
            if (r2 == 0) goto L_0x001a
            b3.k$c r2 = r2.i()
            boolean r3 = r2.a()
            if (r3 != 0) goto L_0x0018
            b3.k$c r3 = b3.k.c.ARRAY
            if (r2 != r3) goto L_0x001a
        L_0x0018:
            r2 = 1
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            boolean r3 = r1.f5776a
            if (r2 == r3) goto L_0x0025
            com.fasterxml.jackson.databind.ser.std.p r3 = new com.fasterxml.jackson.databind.ser.std.p
            r3.<init>(r2)
            return r3
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.p.b(k3.c0, k3.d):k3.o");
    }

    /* renamed from: c */
    public void serialize(InetAddress inetAddress, h hVar, c0 c0Var) {
        String str;
        if (this.f5776a) {
            str = inetAddress.getHostAddress();
        } else {
            str = inetAddress.toString().trim();
            int indexOf = str.indexOf(47);
            if (indexOf >= 0) {
                if (indexOf == 0) {
                    str = str.substring(1);
                } else {
                    str = str.substring(0, indexOf);
                }
            }
        }
        hVar.z0(str);
    }

    /* renamed from: d */
    public void serializeWithType(InetAddress inetAddress, h hVar, c0 c0Var, w3.h hVar2) {
        b g10 = hVar2.g(hVar, hVar2.f(inetAddress, InetAddress.class, n.VALUE_STRING));
        serialize(inetAddress, hVar, c0Var);
        hVar2.h(hVar, g10);
    }

    public p(boolean z10) {
        super(InetAddress.class);
        this.f5776a = z10;
    }
}
