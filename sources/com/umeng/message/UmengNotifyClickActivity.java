package com.umeng.message;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;

public abstract class UmengNotifyClickActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private final UmengNotifyClick f15216a = new UmengNotifyClick() {
        public final void onChangeBadgeNumber(UMessage uMessage) {
            if (UmengNotifyClickActivity.this.canChangeBadgeNum(uMessage)) {
                super.onChangeBadgeNumber(uMessage);
            }
        }

        public final void onMessage(final UMessage uMessage) {
            if (!UmengNotifyClickActivity.this.isFinishing()) {
                UmengNotifyClickActivity.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        try {
                            UmengNotifyClickActivity.this.onMessage(uMessage);
                        } catch (Throwable th) {
                            UPLog.e("UmengNotifyClickActivity", th);
                        }
                    }
                });
            }
        }

        public final void onMessageReceived(Intent intent) {
            UmengNotifyClickActivity.this.onMessage(intent);
        }
    };

    public boolean canChangeBadgeNum(UMessage uMessage) {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15216a.onCreate(this, getIntent());
    }

    @Deprecated
    public void onMessage(Intent intent) {
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f15216a.onNewIntent(intent);
    }

    public void onMessage(UMessage uMessage) {
    }
}
