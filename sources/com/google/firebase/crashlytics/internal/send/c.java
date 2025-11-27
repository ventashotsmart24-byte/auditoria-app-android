package com.google.firebase.crashlytics.internal.send;

import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReportQueue f10219a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f10220b;

    public /* synthetic */ c(ReportQueue reportQueue, CountDownLatch countDownLatch) {
        this.f10219a = reportQueue;
        this.f10220b = countDownLatch;
    }

    public final void run() {
        this.f10219a.lambda$flushScheduledReportsIfAble$0(this.f10220b);
    }
}
