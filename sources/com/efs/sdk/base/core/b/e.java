package com.efs.sdk.base.core.b;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.core.b.h;
import com.efs.sdk.base.core.cache.CacheManager;
import com.efs.sdk.base.core.cache.IFileFilter;
import com.efs.sdk.base.core.cache.f;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public final class e extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public int f5148a;

    /* renamed from: b  reason: collision with root package name */
    public int f5149b;

    /* renamed from: c  reason: collision with root package name */
    public d f5150c;

    /* renamed from: d  reason: collision with root package name */
    public IFileFilter f5151d;

    /* renamed from: e  reason: collision with root package name */
    private d f5152e;

    /* renamed from: f  reason: collision with root package name */
    private d f5153f;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f5154g;

    /* renamed from: h  reason: collision with root package name */
    private List<String> f5155h;

    /* renamed from: i  reason: collision with root package name */
    private AtomicInteger f5156i;

    /* renamed from: j  reason: collision with root package name */
    private AtomicInteger f5157j;

    /* renamed from: k  reason: collision with root package name */
    private IFileFilter f5158k;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final e f5159a = new e((byte) 0);
    }

    public /* synthetic */ e(byte b10) {
        this();
    }

    public static e a() {
        return a.f5159a;
    }

    public final void b(Object obj, int i10) {
        Message obtain = Message.obtain();
        obtain.what = 11;
        obtain.obj = obj;
        obtain.arg1 = i10;
        sendMessage(obtain);
    }

    public final void handleMessage(Message message) {
        int i10;
        int i11;
        super.handleMessage(message);
        if (h.a.f5170a.a()) {
            int i12 = message.what;
            if (i12 == 0) {
                String netStatus = GlobalInfoManager.getInstance().getNetStatus();
                if (NetworkUtil.NETWORK_CLASS_DENIED.equalsIgnoreCase(netStatus) || NetworkUtil.NETWORK_CLASS_DISCONNECTED.equalsIgnoreCase(netStatus)) {
                    Log.i("efs.send_log", "log cann't be send because net status is ".concat(String.valueOf(netStatus)));
                    sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                    return;
                }
                List<LogDto> emptyList = Collections.emptyList();
                try {
                    emptyList = CacheManager.getInstance().getLogDto(this.f5148a, this.f5158k);
                } catch (Throwable unused) {
                }
                for (LogDto next : emptyList) {
                    if ("wa".equals(next.getLogType()) || c.a().a(next.getLogType(), next.getBodySize())) {
                        d dVar = this.f5150c;
                        if ("wa".equals(next.getLogType())) {
                            dVar = this.f5153f;
                        }
                        String uuid = UUID.randomUUID().toString();
                        this.f5154g.add(uuid);
                        if (WorkThreadUtil.submit(new f(next, dVar, uuid)) == null) {
                            a(uuid, -1);
                        }
                    }
                }
                if (this.f5154g.size() <= 0) {
                    sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                }
            } else if (i12 == 1) {
                Object obj = message.obj;
                if (obj != null) {
                    this.f5154g.remove(obj.toString());
                }
                if (message.arg1 != 0) {
                    i10 = this.f5156i.incrementAndGet();
                } else {
                    i10 = 0;
                }
                if (!this.f5154g.isEmpty()) {
                    return;
                }
                if (i10 < 5) {
                    sendEmptyMessage(0);
                    return;
                }
                this.f5156i.set(0);
                sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendDelayMills());
                Log.i("efs.send_log", "request error cnt gt 5, next request delay 10s");
            } else if (i12 != 10) {
                if (i12 == 11) {
                    Object obj2 = message.obj;
                    if (obj2 != null) {
                        this.f5155h.remove(obj2.toString());
                    }
                    if (message.arg1 != 0) {
                        i11 = this.f5157j.incrementAndGet();
                    } else {
                        i11 = 0;
                    }
                    if (this.f5155h.isEmpty()) {
                        if (i11 == 0) {
                            Log.i("efs.send_log", "send secess.");
                            this.f5151d.finish();
                        }
                        if (i11 < 5) {
                            sendEmptyMessage(10);
                            return;
                        }
                        this.f5157j.set(0);
                        sendEmptyMessageDelayed(10, ControllerCenter.getGlobalEnvStruct().getLogSendDelayMills());
                        Log.i("efs.send_log", "request error cnt gt 5, next request delay 10s");
                    }
                }
            } else if (!this.f5151d.hasTask()) {
                Log.i("efs.send_log", "-> none task. return.");
            } else {
                String netStatus2 = GlobalInfoManager.getInstance().getNetStatus();
                if (NetworkUtil.NETWORK_CLASS_DENIED.equalsIgnoreCase(netStatus2) || NetworkUtil.NETWORK_CLASS_DISCONNECTED.equalsIgnoreCase(netStatus2)) {
                    Log.i("efs.send_log", "log cann't be send because net status is ".concat(String.valueOf(netStatus2)));
                    Log.i("efs.send_log", "-> none net. over.");
                    sendEmptyMessageDelayed(10, 300000);
                    return;
                }
                List<LogDto> emptyList2 = Collections.emptyList();
                try {
                    emptyList2 = CacheManager.getInstance().getLogDtoCodeLog(this.f5149b, this.f5151d);
                } catch (Throwable unused2) {
                }
                for (LogDto gVar : emptyList2) {
                    d dVar2 = this.f5152e;
                    String uuid2 = UUID.randomUUID().toString();
                    this.f5155h.add(uuid2);
                    if (WorkThreadUtil.submit(new g(gVar, dVar2, uuid2)) == null) {
                        b(uuid2, -1);
                    }
                }
                if (this.f5155h.size() > 0) {
                    return;
                }
                if (CacheManager.getInstance().getCodeLogList() == null || CacheManager.getInstance().getCodeLogList().isEmpty()) {
                    Log.i("efs.send_log", "-> deal done and none log. return.");
                    sendEmptyMessageDelayed(10, 300000);
                } else if (this.f5151d.hasTask()) {
                    Log.i("efs.send_log", "-> deal done and has task. next interval.");
                    this.f5151d.finish();
                    sendEmptyMessageDelayed(10, ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                } else {
                    Log.i("efs.send_log", "-> deal done and none task. return.");
                }
            }
        }
    }

    private e() {
        super(com.efs.sdk.base.core.util.concurrent.a.f5313a.getLooper());
        this.f5148a = 5;
        this.f5149b = 1000;
        this.f5154g = new ArrayList();
        this.f5155h = new ArrayList();
        this.f5156i = new AtomicInteger(0);
        this.f5157j = new AtomicInteger(0);
        this.f5150c = new a();
        this.f5152e = new b();
        this.f5153f = new com.efs.sdk.base.core.d.e();
        this.f5158k = new f();
    }

    public final void a(Object obj, int i10) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = obj;
        obtain.arg1 = i10;
        sendMessage(obtain);
    }
}
