package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JobInfoSchedulerService f5840a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JobParameters f5841b;

    public /* synthetic */ f(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f5840a = jobInfoSchedulerService;
        this.f5841b = jobParameters;
    }

    public final void run() {
        this.f5840a.lambda$onStartJob$0(this.f5841b);
    }
}
