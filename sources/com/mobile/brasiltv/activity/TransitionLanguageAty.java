package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.msandroid.mobile.R;
import f5.c;

public class TransitionLanguageAty extends c {

    /* renamed from: k  reason: collision with root package name */
    public Handler f12253k = new a();

    public class a extends Handler {
        public a() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            TransitionLanguageAty.this.startActivity(new Intent(TransitionLanguageAty.this, MainAty.class));
            TransitionLanguageAty.this.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_transition_language);
    }

    public void onResume() {
        super.onResume();
        this.f12253k.sendEmptyMessageDelayed(0, 1000);
    }
}
