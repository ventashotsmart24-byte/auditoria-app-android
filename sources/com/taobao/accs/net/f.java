package com.taobao.accs.net;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.taobao.accs.internal.AccsJobService;
import com.umeng.analytics.pro.k;
import e1.v;

class f extends g {

    /* renamed from: c  reason: collision with root package name */
    private JobScheduler f13050c;

    public f(Context context) {
        super(context);
    }

    public void a(int i10) {
        if (this.f13050c == null) {
            this.f13050c = v.a(this.f13053a.getSystemService("jobscheduler"));
        }
        this.f13050c.cancel(k.f14288b);
        long j10 = (long) (i10 * 1000);
        int unused = this.f13050c.schedule(new JobInfo.Builder(k.f14288b, new ComponentName(this.f13053a.getPackageName(), AccsJobService.class.getName())).setMinimumLatency(j10).setOverrideDeadline(j10).setRequiredNetworkType(1).build());
    }
}
