package com.efs.sdk.base.core.b;

import android.content.Context;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

public final class h {

    /* renamed from: b  reason: collision with root package name */
    static FileLock f5166b;

    /* renamed from: a  reason: collision with root package name */
    volatile int f5167a;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final h f5170a = new h((byte) 0);
    }

    public /* synthetic */ h(byte b10) {
        this();
    }

    public final boolean a() {
        if (this.f5167a == 2) {
            return true;
        }
        if (this.f5167a != 0) {
            return false;
        }
        a(ControllerCenter.getGlobalEnvStruct().mAppContext);
        return false;
    }

    private h() {
        this.f5167a = 0;
        a(ControllerCenter.getGlobalEnvStruct().mAppContext);
    }

    private synchronized void a(final Context context) {
        Log.w("efs.send_log", "tryFileLock start! ");
        this.f5167a = 1;
        new Thread(new Runnable() {
            public final void run() {
                FileLock lock;
                try {
                    File a10 = com.efs.sdk.base.core.util.a.a(context);
                    if (!a10.exists()) {
                        a10.mkdirs();
                    }
                    File file = new File(a10.getPath() + File.separator + "sendlock");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    do {
                        lock = new FileOutputStream(file).getChannel().lock();
                        h.f5166b = lock;
                    } while (!lock.isValid());
                    Log.w("efs.send_log", "tryFileLock sendlock sucess! processname: " + ProcessUtil.getCurrentProcessName());
                    h.this.f5167a = 2;
                } catch (Exception e10) {
                    Log.w("efs.send_log", "tryFileLock fail! " + e10.getMessage());
                    h.this.f5167a = 0;
                }
            }
        }).start();
    }
}
