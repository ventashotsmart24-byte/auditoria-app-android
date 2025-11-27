package com.alibaba.sdk.android.httpdns.probe;

import com.alibaba.sdk.android.httpdns.c;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private f f5010a;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f5011b = new ConcurrentHashMap<>();
    private String host;
    private String[] ips;

    /* renamed from: j  reason: collision with root package name */
    private long f5012j;
    private int port;

    public a(long j10, String str, String[] strArr, int i10, f fVar) {
        this.f5012j = j10;
        this.host = str;
        this.ips = strArr;
        this.port = i10;
        this.f5010a = fVar;
    }

    private c a(String[] strArr) {
        String[] strArr2 = this.ips;
        if (strArr2 == null || strArr2.length == 0 || strArr == null || strArr.length == 0) {
            return null;
        }
        String str = strArr2[0];
        String str2 = strArr[0];
        return new c(this.host, strArr, str, str2, this.f5011b.containsKey(str) ? this.f5011b.get(str).longValue() : 2147483647L, this.f5011b.containsKey(str2) ? this.f5011b.get(str2).longValue() : 2147483647L);
    }

    public void run() {
        String[] a10;
        String[] strArr = this.ips;
        if (strArr != null && strArr.length != 0) {
            CountDownLatch countDownLatch = new CountDownLatch(this.ips.length);
            for (String gVar : this.ips) {
                c.a().execute(new g(gVar, this.port, countDownLatch, this.f5011b));
            }
            try {
                countDownLatch.await(NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS, TimeUnit.MILLISECONDS);
                if (this.f5010a != null && (a10 = a(this.f5011b)) != null && a10.length != 0) {
                    this.f5010a.a(this.f5012j, a(a10));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    private String[] a(ConcurrentHashMap<String, Long> concurrentHashMap) {
        if (concurrentHashMap == null) {
            return null;
        }
        int size = concurrentHashMap.size();
        String[] strArr = new String[size];
        int i10 = 0;
        for (String str : concurrentHashMap.keySet()) {
            strArr[i10] = new String(str);
            i10++;
        }
        for (int i11 = 0; i11 < size - 1; i11++) {
            int i12 = 0;
            while (i12 < (size - i11) - 1) {
                int i13 = i12 + 1;
                if (concurrentHashMap.get(strArr[i12]).longValue() > concurrentHashMap.get(strArr[i13]).longValue()) {
                    String str2 = strArr[i12];
                    strArr[i12] = strArr[i13];
                    strArr[i13] = str2;
                }
                i12 = i13;
            }
        }
        return strArr;
    }
}
