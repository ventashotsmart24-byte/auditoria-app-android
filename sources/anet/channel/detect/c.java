package anet.channel.detect;

import android.text.TextUtils;
import android.util.Pair;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;

class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RequestStatistic f3655a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ExceptionDetector f3656b;

    public c(ExceptionDetector exceptionDetector, RequestStatistic requestStatistic) {
        this.f3656b = exceptionDetector;
        this.f3655a = requestStatistic;
    }

    public void run() {
        try {
            RequestStatistic requestStatistic = this.f3655a;
            if (requestStatistic != null) {
                if (!TextUtils.isEmpty(requestStatistic.ip) && this.f3655a.ret == 0) {
                    if ("guide-acs.m.taobao.com".equalsIgnoreCase(this.f3655a.host)) {
                        this.f3656b.f3640b = this.f3655a.ip;
                    } else if ("msgacs.m.taobao.com".equalsIgnoreCase(this.f3655a.host)) {
                        this.f3656b.f3641c = this.f3655a.ip;
                    } else if ("gw.alicdn.com".equalsIgnoreCase(this.f3655a.host)) {
                        this.f3656b.f3642d = this.f3655a.ip;
                    }
                }
                if (!TextUtils.isEmpty(this.f3655a.url)) {
                    this.f3656b.f3643e.add(Pair.create(this.f3655a.url, Integer.valueOf(this.f3655a.statusCode)));
                }
                if (this.f3656b.c()) {
                    this.f3656b.b();
                }
            }
        } catch (Throwable th) {
            ALog.e("anet.ExceptionDetector", "network detect fail.", (String) null, th, new Object[0]);
        }
    }
}
