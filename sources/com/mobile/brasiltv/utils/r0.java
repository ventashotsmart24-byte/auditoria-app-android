package com.mobile.brasiltv.utils;

import ba.c;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.HashMap;
import javax.crypto.spec.SecretKeySpec;
import t9.i;
import w6.i;

public final class r0 {

    /* renamed from: a  reason: collision with root package name */
    public static final r0 f12611a = new r0();

    /* renamed from: b  reason: collision with root package name */
    public static String f12612b = "8nSjighe4534yY15371QUkgnuiekd6r4trf3";

    public static /* synthetic */ String c(r0 r0Var, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return r0Var.b(str, z10);
    }

    public final String a(String str) {
        i.g(str, "encryptStr");
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance();
        i.f(instance, "getInstance()");
        instance.setTimeInMillis(currentTimeMillis);
        instance.add(6, 7);
        long j10 = (long) 1000;
        HashMap hashMap = new HashMap();
        hashMap.put("account", str);
        hashMap.put("account_type", "0");
        hashMap.put("name", str);
        hashMap.put("avatar", (Object) null);
        hashMap.put("age", (Object) null);
        hashMap.put("gender", (Object) null);
        long j11 = currentTimeMillis / j10;
        hashMap.put(Claims.ISSUED_AT, String.valueOf(j11));
        hashMap.put(Claims.NOT_BEFORE, String.valueOf(j11));
        hashMap.put("exp", String.valueOf(instance.getTimeInMillis() / j10));
        byte[] bytes = f12612b.getBytes(c.f11331b);
        i.f(bytes, "this as java.lang.String).getBytes(charset)");
        String compact = Jwts.builder().setHeaderParam(Header.TYPE, Header.JWT_TYPE).setHeaderParam("alg", "HS256").claims(hashMap).signWith(new SecretKeySpec(bytes, SignatureAlgorithm.HS256.getJcaName())).compact();
        i.f(compact, "tokenStr");
        return compact;
    }

    public final String b(String str, boolean z10) {
        boolean z11;
        String str2;
        String str3 = "ACMPNY37Q2";
        String str4 = "";
        i.c cVar = w6.i.f9510g;
        String H = cVar.H();
        if (H == null || H.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            str2 = cVar.l();
        } else {
            str2 = cVar.H();
        }
        try {
            String b10 = l.b(str2);
            r0 r0Var = f12611a;
            t9.i.f(b10, "encryptStr");
            str4 = r0Var.a(b10);
            if (z10) {
                str3 = "ROMANC84WZ";
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return str + "?channel_id=" + str3 + "&jwt_token=" + str4;
    }
}
