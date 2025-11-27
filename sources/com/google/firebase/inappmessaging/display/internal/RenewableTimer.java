package com.google.firebase.inappmessaging.display.internal;

import android.os.CountDownTimer;

public class RenewableTimer {
    private CountDownTimer mCountDownTimer;

    public interface Callback {
        void onFinish();
    }

    public void cancel() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mCountDownTimer = null;
        }
    }

    public void start(Callback callback, long j10, long j11) {
        final Callback callback2 = callback;
        this.mCountDownTimer = new CountDownTimer(j10, j11) {
            public void onFinish() {
                callback2.onFinish();
            }

            public void onTick(long j10) {
            }
        }.start();
    }
}
