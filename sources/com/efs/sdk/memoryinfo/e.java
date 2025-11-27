package com.efs.sdk.memoryinfo;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class e {
    /* access modifiers changed from: package-private */
    public final List<EfsJSONLog> B = new ArrayList();
    /* access modifiers changed from: package-private */
    public volatile boolean C;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final EfsReporter f5404a;

    public e(final Context context, EfsReporter efsReporter) {
        this.f5404a = efsReporter;
        String uMId = UMUtils.getUMId(context);
        this.C = !TextUtils.isEmpty(uMId);
        if (!this.C) {
            ImprintHandler.getImprintService(context).registImprintCallback(bt.f13913g, new UMImprintChangeCallback() {
                public final void onImprintValueChanged(String str, String str2) {
                    try {
                        if (bt.f13913g.equals(str)) {
                            HashMap hashMap = new HashMap(1);
                            hashMap.put(UMCrash.KEY_HEADER_UMID, str2);
                            e.this.f5404a.addPublicParams(hashMap);
                            synchronized (e.class) {
                                boolean unused = e.this.C = true;
                            }
                            for (EfsJSONLog a10 : e.this.B) {
                                e.this.a(a10);
                            }
                            new StringBuilder("send cache:").append(e.this.B.size());
                            boolean z10 = a.DEBUG;
                            e.this.B.clear();
                            ImprintHandler.getImprintService(context).unregistImprintCallback(bt.f13913g, this);
                        }
                    } catch (Throwable th) {
                        f.a("umid ", th);
                    }
                }
            });
            return;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(UMCrash.KEY_HEADER_UMID, uMId);
        efsReporter.addPublicParams(hashMap);
    }

    public final void a(EfsJSONLog efsJSONLog) {
        try {
            this.f5404a.send(efsJSONLog);
        } catch (Throwable th) {
            f.a("send", th);
        }
    }
}
