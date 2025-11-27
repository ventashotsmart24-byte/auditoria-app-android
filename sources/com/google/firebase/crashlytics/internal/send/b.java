package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;

public final /* synthetic */ class b implements TransportScheduleCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReportQueue f10216a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f10217b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsReportWithSessionId f10218c;

    public /* synthetic */ b(ReportQueue reportQueue, TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.f10216a = reportQueue;
        this.f10217b = taskCompletionSource;
        this.f10218c = crashlyticsReportWithSessionId;
    }

    public final void onSchedule(Exception exc) {
        this.f10216a.lambda$sendReport$1(this.f10217b, this.f10218c, exc);
    }
}
