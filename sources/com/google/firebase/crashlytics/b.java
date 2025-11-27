package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;

public final /* synthetic */ class b implements AnalyticsEventLogger {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsDeferredProxy f10201a;

    public /* synthetic */ b(AnalyticsDeferredProxy analyticsDeferredProxy) {
        this.f10201a = analyticsDeferredProxy;
    }

    public final void logEvent(String str, Bundle bundle) {
        this.f10201a.lambda$getAnalyticsEventLogger$1(str, bundle);
    }
}
