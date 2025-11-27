package com.efs.sdk.base.core.cache;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.titans.entity.CdnType;
import java.io.File;

public final class b extends Handler implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    boolean f5185a;

    /* renamed from: b  reason: collision with root package name */
    boolean f5186b;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f5187a = new b((byte) 0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    public static b a() {
        return a.f5187a;
    }

    public final void handleMessage(Message message) {
        if (message.what != 2) {
            Log.w("efs.cache", "disk listener not support command: " + message.what);
            return;
        }
        WorkThreadUtil.submit(this);
    }

    public final void run() {
        boolean z10;
        CacheManager.getInstance();
        File h10 = com.efs.sdk.base.core.util.a.h(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (h10.exists()) {
            for (File next : FileUtil.listFiles(h10)) {
                if (CacheManager.a(next.getName())) {
                    CacheManager.a(next);
                }
            }
        }
        CacheManager.getInstance();
        File i10 = com.efs.sdk.base.core.util.a.i(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (i10.exists()) {
            for (File next2 : FileUtil.listFiles(i10)) {
                if (CacheManager.a(next2.getName())) {
                    CacheManager.a(next2);
                }
            }
        }
        long parseLong = Long.parseLong(com.efs.sdk.base.core.config.remote.b.a().a("disk_bytes", "4194304"));
        long folderSize = FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.h(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid())) + FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()));
        boolean z11 = true;
        if (folderSize < parseLong) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f5185a = z10;
        if (!z10) {
            Log.w("efs.cache", "Cache Limited! curr " + folderSize + "byte, max " + parseLong + " byte.");
        }
        long parseLong2 = Long.parseLong(com.efs.sdk.base.core.config.remote.b.a().a("apm_codelog_store_max", CdnType.DIGITAL_TYPE_PCDN)) * 1024 * 1024;
        long folderSize2 = FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.i(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid())) + FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.e(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()));
        if (folderSize2 >= parseLong2) {
            z11 = false;
        }
        this.f5186b = z11;
        if (!z11) {
            Log.w("efs.cache", "code log. Cache Limited! curr " + folderSize2 + "byte, max " + parseLong2 + " byte.");
        }
        sendEmptyMessageDelayed(2, 600000);
    }

    private b() {
        super(com.efs.sdk.base.core.util.concurrent.a.f5313a.getLooper());
        this.f5185a = true;
        this.f5186b = true;
        sendEmptyMessageDelayed(2, 60000);
    }
}
