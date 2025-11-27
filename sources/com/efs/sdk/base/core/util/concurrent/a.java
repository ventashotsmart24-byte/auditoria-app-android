package com.efs.sdk.base.core.util.concurrent;

import android.os.HandlerThread;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static HandlerThread f5313a;

    static {
        HandlerThread handlerThread = new HandlerThread("efs-base", 10);
        f5313a = handlerThread;
        handlerThread.start();
    }
}
