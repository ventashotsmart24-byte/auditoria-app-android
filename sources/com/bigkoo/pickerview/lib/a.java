package com.bigkoo.pickerview.lib;

import android.os.Handler;
import android.os.Message;
import com.bigkoo.pickerview.lib.WheelView;

public final class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final WheelView f5108a;

    public a(WheelView wheelView) {
        this.f5108a = wheelView;
    }

    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1000) {
            this.f5108a.invalidate();
        } else if (i10 == 2000) {
            this.f5108a.h(WheelView.a.FLING);
        } else if (i10 == 3000) {
            this.f5108a.e();
        }
    }
}
