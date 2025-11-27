package com.umeng.message.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.api.UPushInAppMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class am {

    /* renamed from: a  reason: collision with root package name */
    transient boolean f15383a = true;

    /* renamed from: b  reason: collision with root package name */
    Future<?> f15384b;

    /* renamed from: c  reason: collision with root package name */
    private final LinkedList<ap> f15385c = new LinkedList<>();

    private void c() {
        Future<?> future = this.f15384b;
        if (future != null && !future.isDone() && !future.isCancelled()) {
            UPLog.i("Pop", "cancel cache task", Boolean.valueOf(future.cancel(false)));
        }
        final LinkedList linkedList = new LinkedList();
        synchronized (this.f15385c) {
            if (!this.f15385c.isEmpty()) {
                linkedList.addAll(this.f15385c);
            }
        }
        this.f15383a = linkedList.isEmpty();
        UPLog.i("Pop", "save task", Integer.valueOf(linkedList.size()));
        this.f15384b = b.a(new Runnable() {
            public final void run() {
                am.this.f15384b = null;
                File a10 = bp.a((Context) y.a());
                if (!linkedList.isEmpty()) {
                    bp.a(linkedList, a10);
                    UPLog.i("Pop", "save", linkedList);
                } else if (a10.exists()) {
                    a10.delete();
                    UPLog.i("Pop", "clear");
                }
            }
        }, 1, TimeUnit.SECONDS);
    }

    public final void a(ap apVar) {
        synchronized (this.f15385c) {
            this.f15385c.addFirst(apVar);
            if (this.f15385c.size() > 1) {
                Collections.sort(this.f15385c, new Comparator<ap>() {
                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        return Long.signum(((ap) obj).f15401a.getMsgTime() - ((ap) obj2).f15401a.getMsgTime()) * -1;
                    }
                });
            }
            int i10 = ak.a().c().f15390b;
            while (this.f15385c.size() > i10) {
                ap removeLast = this.f15385c.removeLast();
                try {
                    UPLog.i("Pop", "add unShow msgId", removeLast.f15401a.getMsgId());
                    UPushInAppMessageHandler inAppMessageHandler = v.a().getInAppMessageHandler();
                    if (inAppMessageHandler != null) {
                        inAppMessageHandler.onMessageIgnored(y.a(), removeLast.f15401a);
                    }
                } catch (Throwable th) {
                    UPLog.e("Pop", th);
                }
            }
            c();
        }
    }

    public final boolean b(ap apVar) {
        boolean remove;
        synchronized (this.f15385c) {
            remove = this.f15385c.remove(apVar);
        }
        if (remove) {
            c();
        }
        return remove;
    }

    public final void b() {
        LinkedList linkedList = (LinkedList) bp.a(bp.a((Context) y.a()));
        if (linkedList != null && !linkedList.isEmpty()) {
            synchronized (this.f15385c) {
                this.f15385c.clear();
                this.f15385c.addAll(linkedList);
            }
            this.f15383a = false;
        }
        if (!this.f15383a) {
            UPLog.i("Pop", "load", linkedList);
        }
    }

    public final ap a() {
        ap apVar;
        boolean z10;
        synchronized (this.f15385c) {
            boolean z11 = false;
            while (true) {
                if (this.f15385c.isEmpty()) {
                    apVar = null;
                    break;
                }
                apVar = this.f15385c.getFirst();
                long j10 = ak.a().c().f15393e;
                if (j10 <= 0) {
                    z10 = false;
                } else {
                    z10 = System.currentTimeMillis() - apVar.f15402b <= j10;
                    if (!z10) {
                        UPLog.i("Pop", "msg time invalid", apVar.f15401a.getMsgId(), "received", new SimpleDateFormat("MM-dd HH:mm:ss", Locale.getDefault()).format(Long.valueOf(apVar.f15402b)), "valid", Long.valueOf((j10 / 1000) / 60));
                    }
                }
                if (z10) {
                    UPushInAppMessageHandler inAppMessageHandler = v.a().getInAppMessageHandler();
                    if (inAppMessageHandler == null || !inAppMessageHandler.isOnlyShowLatestMessage()) {
                        break;
                    }
                    if (apVar.f15401a.getMsgTime() > MessageSharedPrefs.getInstance(y.a()).f15211b.b("ia_latest_ts", -1)) {
                        break;
                    }
                }
                this.f15385c.remove(apVar);
                UPLog.i("Pop", "get unShow msgId", apVar.f15401a.getMsgId());
                try {
                    UPushInAppMessageHandler inAppMessageHandler2 = v.a().getInAppMessageHandler();
                    if (inAppMessageHandler2 != null) {
                        inAppMessageHandler2.onMessageIgnored(y.a(), apVar.f15401a);
                    }
                } catch (Throwable th) {
                    UPLog.e("Pop", th);
                }
                z11 = true;
            }
            if (z11) {
                c();
            }
        }
        return apVar;
    }

    public final ap a(String str) {
        synchronized (this.f15385c) {
            Iterator<ap> it = this.f15385c.iterator();
            while (it.hasNext()) {
                ap next = it.next();
                UMessage uMessage = next.f15401a;
                if (uMessage != null && TextUtils.equals(str, uMessage.getMsgId())) {
                    return next;
                }
            }
            return null;
        }
    }
}
