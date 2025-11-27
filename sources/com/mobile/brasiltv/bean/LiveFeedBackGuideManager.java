package com.mobile.brasiltv.bean;

import com.mobile.brasiltv.app.App;

public final class LiveFeedBackGuideManager extends BaseGuideManager {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LiveFeedBackGuideManager(android.content.Context r12, android.view.View r13, java.lang.String r14, java.lang.String r15, com.mobile.brasiltv.view.dialog.GuideDialog.Direction r16) {
        /*
            r11 = this;
            java.lang.String r0 = "content"
            r5 = r15
            t9.i.g(r15, r0)
            java.lang.String r0 = "diretion"
            r6 = r16
            t9.i.g(r6, r0)
            r7 = 0
            r8 = 1
            r9 = 1
            r10 = 0
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.bean.LiveFeedBackGuideManager.<init>(android.content.Context, android.view.View, java.lang.String, java.lang.String, com.mobile.brasiltv.view.dialog.GuideDialog$Direction):void");
    }

    public void alreadyShow() {
        if (getKey() != null) {
            App.f6050e.a().getSharedPreferences("show_gesture", 0).edit().putBoolean(getKey(), true).apply();
        }
    }

    public boolean isShow() {
        if (getKey() == null) {
            return true;
        }
        return !App.f6050e.a().getSharedPreferences("show_gesture", 0).getBoolean(getKey(), false);
    }
}
