package com.fasterxml.jackson.databind.ser.std;

import a4.i;
import c3.h;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import d4.y;
import java.util.UUID;
import k3.c0;
import k3.j;
import u3.f;
import u3.m;

public class o0 extends h0 implements i {

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f5774b = "0123456789abcdef".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f5775a;

    public o0() {
        this((Boolean) null);
    }

    public static final void c(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) (i10 >> 24);
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >> 16);
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i10 >> 8);
        bArr[i13 + 1] = (byte) i10;
    }

    public static void d(int i10, char[] cArr, int i11) {
        e(i10 >> 16, cArr, i11);
        e(i10, cArr, i11 + 4);
    }

    public static void e(int i10, char[] cArr, int i11) {
        char[] cArr2 = f5774b;
        cArr[i11] = cArr2[(i10 >> 12) & 15];
        int i12 = i11 + 1;
        cArr[i12] = cArr2[(i10 >> 8) & 15];
        int i13 = i12 + 1;
        cArr[i13] = cArr2[(i10 >> 4) & 15];
        cArr[i13 + 1] = cArr2[i10 & 15];
    }

    public static final byte[] f(UUID uuid) {
        byte[] bArr = new byte[16];
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        c((int) (mostSignificantBits >> 32), bArr, 0);
        c((int) mostSignificantBits, bArr, 4);
        c((int) (leastSignificantBits >> 32), bArr, 8);
        c((int) leastSignificantBits, bArr, 12);
        return bArr;
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        visitStringFormat(fVar, jVar, m.UUID);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.o b(k3.c0 r2, k3.d r3) {
        /*
            r1 = this;
            java.lang.Class r0 = r1.handledType()
            b3.k$d r2 = r1.findFormatOverrides(r2, r3, r0)
            if (r2 == 0) goto L_0x001c
            b3.k$c r2 = r2.i()
            b3.k$c r3 = b3.k.c.BINARY
            if (r2 != r3) goto L_0x0015
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            goto L_0x001d
        L_0x0015:
            b3.k$c r3 = b3.k.c.STRING
            if (r2 != r3) goto L_0x001c
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            goto L_0x001d
        L_0x001c:
            r2 = 0
        L_0x001d:
            java.lang.Boolean r3 = r1.f5775a
            boolean r3 = java.util.Objects.equals(r2, r3)
            if (r3 != 0) goto L_0x002b
            com.fasterxml.jackson.databind.ser.std.o0 r3 = new com.fasterxml.jackson.databind.ser.std.o0
            r3.<init>(r2)
            return r3
        L_0x002b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.o0.b(k3.c0, k3.d):k3.o");
    }

    public boolean g(h hVar) {
        Boolean bool = this.f5775a;
        if (bool != null) {
            return bool.booleanValue();
        }
        if ((hVar instanceof y) || !hVar.f()) {
            return false;
        }
        return true;
    }

    /* renamed from: h */
    public boolean isEmpty(c0 c0Var, UUID uuid) {
        if (uuid.getLeastSignificantBits() == 0 && uuid.getMostSignificantBits() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public void serialize(UUID uuid, h hVar, c0 c0Var) {
        if (g(hVar)) {
            hVar.S(f(uuid));
            return;
        }
        char[] cArr = new char[36];
        long mostSignificantBits = uuid.getMostSignificantBits();
        d((int) (mostSignificantBits >> 32), cArr, 0);
        cArr[8] = ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER;
        int i10 = (int) mostSignificantBits;
        e(i10 >>> 16, cArr, 9);
        cArr[13] = ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER;
        e(i10, cArr, 14);
        cArr[18] = ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER;
        long leastSignificantBits = uuid.getLeastSignificantBits();
        e((int) (leastSignificantBits >>> 48), cArr, 19);
        cArr[23] = ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER;
        e((int) (leastSignificantBits >>> 32), cArr, 24);
        d((int) leastSignificantBits, cArr, 28);
        hVar.A0(cArr, 0, 36);
    }

    public o0(Boolean bool) {
        super(UUID.class);
        this.f5775a = bool;
    }
}
