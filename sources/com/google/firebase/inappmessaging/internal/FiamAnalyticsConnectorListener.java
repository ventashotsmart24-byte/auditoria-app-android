package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.umeng.analytics.pro.f;
import io.reactivex.FlowableEmitter;

final class FiamAnalyticsConnectorListener implements AnalyticsConnector.AnalyticsConnectorListener {
    private FlowableEmitter<String> emitter;

    public FiamAnalyticsConnectorListener(FlowableEmitter<String> flowableEmitter) {
        this.emitter = flowableEmitter;
    }

    public void onMessageTriggered(int i10, Bundle bundle) {
        if (i10 == 2) {
            this.emitter.onNext(bundle.getString(f.ax));
        }
    }
}
