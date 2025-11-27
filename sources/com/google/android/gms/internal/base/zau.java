package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Looper;

public class zau extends Handler {
    public zau() {
    }

    public zau(Looper looper) {
        super(looper);
    }

    public zau(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }
}
