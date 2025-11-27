package com.fasterxml.jackson.databind.deser.std;

import c3.b;
import c3.k;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;
import java.util.UUID;
import k3.g;
import p3.c;

public class l0 extends o {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f5647a;

    static {
        int[] iArr = new int[127];
        f5647a = iArr;
        Arrays.fill(iArr, -1);
        for (int i10 = 0; i10 < 10; i10++) {
            f5647a[i10 + 48] = i10;
        }
        for (int i11 = 0; i11 < 6; i11++) {
            int[] iArr2 = f5647a;
            int i12 = i11 + 10;
            iArr2[i11 + 97] = i12;
            iArr2[i11 + 65] = i12;
        }
    }

    public l0() {
        super(UUID.class);
    }

    public static int m(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & UnsignedBytes.MAX_VALUE) | (bArr[i10] << Ascii.CAN) | ((bArr[i10 + 1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i10 + 2] & UnsignedBytes.MAX_VALUE) << 8);
    }

    public static long n(byte[] bArr, int i10) {
        return ((((long) m(bArr, i10 + 4)) << 32) >>> 32) | (((long) m(bArr, i10)) << 32);
    }

    public Object getEmptyValue(g gVar) {
        return new UUID(0, 0);
    }

    public int h(String str, int i10, g gVar, char c10) {
        throw gVar.L0(str, handledType(), String.format("Non-hex character '%c' (value 0x%s), not valid for UUID String", new Object[]{Character.valueOf(c10), Integer.toHexString(c10)}));
    }

    public final UUID i(String str, g gVar) {
        return (UUID) gVar.j0(handledType(), str, "UUID has to be represented by standard 36-char representation", new Object[0]);
    }

    /* renamed from: j */
    public UUID a(String str, g gVar) {
        if (str.length() == 36) {
            if (!(str.charAt(8) == '-' && str.charAt(13) == '-' && str.charAt(18) == '-' && str.charAt(23) == '-')) {
                i(str, gVar);
            }
            int q10 = q(str, 24, gVar);
            return new UUID((((long) p(str, 0, gVar)) << 32) + ((((long) q(str, 9, gVar)) << 16) | ((long) q(str, 14, gVar))), ((((long) p(str, 28, gVar)) << 32) >>> 32) | (((long) (q10 | (q(str, 19, gVar) << 16))) << 32));
        } else if (str.length() == 24) {
            return l(b.a().f(str), gVar);
        } else {
            return i(str, gVar);
        }
    }

    /* renamed from: k */
    public UUID b(Object obj, g gVar) {
        if (obj instanceof byte[]) {
            return l((byte[]) obj, gVar);
        }
        return (UUID) super.b(obj, gVar);
    }

    public final UUID l(byte[] bArr, g gVar) {
        if (bArr.length == 16) {
            return new UUID(n(bArr, 0), n(bArr, 8));
        }
        k S = gVar.S();
        throw c.v(S, "Can only construct UUIDs from byte[16]; got " + bArr.length + " bytes", bArr, handledType());
    }

    public int o(String str, int i10, g gVar) {
        char charAt = str.charAt(i10);
        int i11 = i10 + 1;
        char charAt2 = str.charAt(i11);
        if (charAt <= 127 && charAt2 <= 127) {
            int[] iArr = f5647a;
            int i12 = iArr[charAt2] | (iArr[charAt] << 4);
            if (i12 >= 0) {
                return i12;
            }
        }
        if (charAt > 127 || f5647a[charAt] < 0) {
            return h(str, i10, gVar, charAt);
        }
        return h(str, i11, gVar, charAt2);
    }

    public int p(String str, int i10, g gVar) {
        return (o(str, i10, gVar) << 24) + (o(str, i10 + 2, gVar) << 16) + (o(str, i10 + 4, gVar) << 8) + o(str, i10 + 6, gVar);
    }

    public int q(String str, int i10, g gVar) {
        return (o(str, i10, gVar) << 8) + o(str, i10 + 2, gVar);
    }
}
