package com.umeng.analytics.filter;

import android.util.Base64;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static final String f13686b = "Ă";

    /* renamed from: a  reason: collision with root package name */
    private final String f13687a = "MD5";

    /* renamed from: c  reason: collision with root package name */
    private MessageDigest f13688c;

    /* renamed from: d  reason: collision with root package name */
    private Set<Object> f13689d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private boolean f13690e;

    public d(boolean z10, String str) {
        this.f13690e = z10;
        try {
            this.f13688c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
        }
        if (str != null) {
            int i10 = 0;
            if (z10) {
                try {
                    byte[] decode = Base64.decode(str.getBytes(), 0);
                    while (i10 < decode.length / 4) {
                        int i11 = i10 * 4;
                        this.f13689d.add(Integer.valueOf(((decode[i11 + 0] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) + ((decode[i11 + 1] & UnsignedBytes.MAX_VALUE) << 16) + ((decode[i11 + 2] & UnsignedBytes.MAX_VALUE) << 8) + (decode[i11 + 3] & UnsignedBytes.MAX_VALUE)));
                        i10++;
                    }
                } catch (IllegalArgumentException e11) {
                    e11.printStackTrace();
                }
            } else {
                String[] split = str.split(f13686b);
                int length = split.length;
                while (i10 < length) {
                    this.f13689d.add(split[i10]);
                    i10++;
                }
            }
        }
    }

    private Integer c(String str) {
        try {
            this.f13688c.update(str.getBytes());
            byte[] digest = this.f13688c.digest();
            return Integer.valueOf(((digest[0] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) + ((digest[1] & UnsignedBytes.MAX_VALUE) << 16) + ((digest[2] & UnsignedBytes.MAX_VALUE) << 8) + (digest[3] & UnsignedBytes.MAX_VALUE));
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public boolean a(String str) {
        if (this.f13690e) {
            return this.f13689d.contains(c(str));
        }
        return this.f13689d.contains(str);
    }

    public void b(String str) {
        if (this.f13690e) {
            this.f13689d.add(c(str));
        } else {
            this.f13689d.add(str);
        }
    }

    public String toString() {
        if (this.f13690e) {
            byte[] bArr = new byte[(this.f13689d.size() * 4)];
            Iterator<Object> it = this.f13689d.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                int i11 = i10 + 1;
                bArr[i10] = (byte) ((-16777216 & intValue) >> 24);
                int i12 = i11 + 1;
                bArr[i11] = (byte) ((16711680 & intValue) >> 16);
                int i13 = i12 + 1;
                bArr[i12] = (byte) ((65280 & intValue) >> 8);
                i10 = i13 + 1;
                bArr[i13] = (byte) (intValue & 255);
            }
            return new String(Base64.encode(bArr, 0));
        }
        StringBuilder sb = new StringBuilder();
        for (Object next : this.f13689d) {
            if (sb.length() > 0) {
                sb.append(f13686b);
            }
            sb.append(next.toString());
        }
        return sb.toString();
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        for (Object append : this.f13689d) {
            sb.append(append);
            if (sb.length() > 0) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }
}
