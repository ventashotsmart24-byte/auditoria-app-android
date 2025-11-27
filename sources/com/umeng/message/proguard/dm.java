package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.google.android.gms.cast.CastStatusCodes;
import com.umeng.message.proguard.bx;
import java.lang.ref.WeakReference;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class dm extends dc {
    public dm(cz czVar) {
        super(czVar);
    }

    public final ck b() {
        ck a10 = ci.a(this.f15730b).a(this.f15729a);
        if (a10 == null) {
            ce.b("Banner", "type:", this.f15730b, " request ad failed.");
            throw new cd("request ad failed.");
        } else if (a10.f15608d == 0) {
            return a10;
        } else {
            throw new cd(a10.f15607c);
        }
    }

    public final bx.a b(ck ckVar) {
        Bitmap bitmap;
        if (ckVar.f15605a != this.f15730b) {
            return null;
        }
        final boolean z10 = this.f15729a.f15718c;
        final WeakReference<Activity> weakReference = this.f15732d;
        Context a10 = de.a();
        int a11 = ckVar.a();
        int a12 = bs.a(a11);
        if (a12 == 0) {
            ce.b("Banner", "type:" + bx.c.BANNER + " style:" + a11);
            return null;
        }
        if (a12 != bs.f15533b) {
            if (a12 == bs.f15532a || a12 == bs.f15535d) {
                bitmap = cc.a(a10, ckVar.b());
            } else {
                bitmap = null;
            }
            if (bitmap == null) {
                ce.b("Banner", "material download failed. sid:" + ckVar.c());
                cr.a().b(ckVar, CastStatusCodes.INVALID_REQUEST);
                throw new cd("material download failed.");
            }
        } else {
            bitmap = null;
        }
        if (a12 == bs.f15532a || (!TextUtils.isEmpty(ckVar.d()) && !TextUtils.isEmpty(ckVar.e()))) {
            final long max = Math.max(ckVar.f15606b.optLong(IjkMediaPlayer.OnNativeInvokeListener.ARG_FD), 3000);
            final ck ckVar2 = ckVar;
            final Bitmap bitmap2 = bitmap;
            return new da() {

                /* renamed from: h  reason: collision with root package name */
                private boolean f15801h = false;

                /* JADX WARNING: Can't wrap try/catch for region: R(7:14|15|16|17|(1:19)|20|21) */
                /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0043 */
                /* JADX WARNING: Removed duplicated region for block: B:19:0x006d A[Catch:{ all -> 0x00b0, all -> 0x00c4 }] */
                /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0043=Splitter:B:16:0x0043, B:34:0x0099=Splitter:B:34:0x0099} */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void a(android.app.Activity r7) {
                    /*
                        r6 = this;
                        boolean r7 = r6.f15801h
                        r0 = 2010(0x7da, float:2.817E-42)
                        r1 = 0
                        java.lang.String r2 = "Banner"
                        r3 = 1
                        if (r7 == 0) goto L_0x001b
                        java.lang.Object[] r7 = new java.lang.Object[r3]
                        java.lang.String r3 = "already called show."
                        r7[r1] = r3
                        com.umeng.message.proguard.ce.d(r2, r7)
                        com.umeng.message.proguard.cf r7 = r6.f15727a
                        if (r7 == 0) goto L_0x001a
                        r7.a(r0, r3)
                    L_0x001a:
                        return
                    L_0x001b:
                        boolean r7 = r6     // Catch:{ all -> 0x00b0 }
                        if (r7 == 0) goto L_0x0030
                        com.umeng.message.proguard.dk r7 = new com.umeng.message.proguard.dk     // Catch:{ all -> 0x00b0 }
                        com.umeng.message.proguard.ck r0 = r5     // Catch:{ all -> 0x00b0 }
                        android.graphics.Bitmap r4 = r7     // Catch:{ all -> 0x00b0 }
                        r7.<init>(r0, r4)     // Catch:{ all -> 0x00b0 }
                        long r4 = r8     // Catch:{ all -> 0x00b0 }
                        com.umeng.message.proguard.dh.a(r7, r4, r6)     // Catch:{ all -> 0x00b0 }
                        r6.f15801h = r3
                        return
                    L_0x0030:
                        com.umeng.message.proguard.dc r7 = com.umeng.message.proguard.dc.this     // Catch:{ all -> 0x00b0 }
                        com.umeng.message.proguard.ck r4 = r5     // Catch:{ all -> 0x00b0 }
                        boolean r7 = r7.a(r4)     // Catch:{ all -> 0x00b0 }
                        if (r7 == 0) goto L_0x0073
                        com.umeng.message.proguard.ck r7 = r5     // Catch:{ Exception -> 0x0043 }
                        org.json.JSONObject r7 = r7.f15606b     // Catch:{ Exception -> 0x0043 }
                        java.lang.String r4 = "exposed_timeout"
                        r7.put(r4, r3)     // Catch:{ Exception -> 0x0043 }
                    L_0x0043:
                        com.umeng.message.proguard.cq r7 = com.umeng.message.proguard.cr.a()     // Catch:{ all -> 0x00b0 }
                        com.umeng.message.proguard.ck r4 = r5     // Catch:{ all -> 0x00b0 }
                        r5 = 2009(0x7d9, float:2.815E-42)
                        r7.b(r4, r5)     // Catch:{ all -> 0x00b0 }
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
                        java.lang.String r4 = "expose invalid! timeout config:"
                        r7.<init>(r4)     // Catch:{ all -> 0x00b0 }
                        com.umeng.message.proguard.ck r4 = r5     // Catch:{ all -> 0x00b0 }
                        int r4 = r4.h()     // Catch:{ all -> 0x00b0 }
                        r7.append(r4)     // Catch:{ all -> 0x00b0 }
                        java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00b0 }
                        java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x00b0 }
                        r4[r1] = r7     // Catch:{ all -> 0x00b0 }
                        com.umeng.message.proguard.ce.d(r2, r4)     // Catch:{ all -> 0x00b0 }
                        com.umeng.message.proguard.cf r4 = r6.f15727a     // Catch:{ all -> 0x00b0 }
                        if (r4 == 0) goto L_0x0070
                        r4.a(r0, r7)     // Catch:{ all -> 0x00b0 }
                    L_0x0070:
                        r6.f15801h = r3
                        return
                    L_0x0073:
                        java.lang.ref.WeakReference r7 = r10     // Catch:{ all -> 0x00b0 }
                        if (r7 == 0) goto L_0x007e
                        java.lang.Object r7 = r7.get()     // Catch:{ all -> 0x00b0 }
                        android.app.Activity r7 = (android.app.Activity) r7     // Catch:{ all -> 0x00b0 }
                        goto L_0x007f
                    L_0x007e:
                        r7 = 0
                    L_0x007f:
                        if (r7 == 0) goto L_0x0099
                        boolean r0 = r7.isFinishing()     // Catch:{ all -> 0x00b0 }
                        if (r0 == 0) goto L_0x0088
                        goto L_0x0099
                    L_0x0088:
                        com.umeng.message.proguard.dk r0 = new com.umeng.message.proguard.dk     // Catch:{ all -> 0x00b0 }
                        com.umeng.message.proguard.ck r4 = r5     // Catch:{ all -> 0x00b0 }
                        android.graphics.Bitmap r5 = r7     // Catch:{ all -> 0x00b0 }
                        r0.<init>(r4, r5)     // Catch:{ all -> 0x00b0 }
                        long r4 = r8     // Catch:{ all -> 0x00b0 }
                        com.umeng.message.proguard.dh.a(r7, r0, r4, r6)     // Catch:{ all -> 0x00b0 }
                        r6.f15801h = r3
                        return
                    L_0x0099:
                        java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ all -> 0x00b0 }
                        java.lang.String r0 = "activity has finished skip."
                        r7[r1] = r0     // Catch:{ all -> 0x00b0 }
                        com.umeng.message.proguard.ce.b(r2, r7)     // Catch:{ all -> 0x00b0 }
                        com.umeng.message.proguard.cq r7 = com.umeng.message.proguard.cr.a()     // Catch:{ all -> 0x00b0 }
                        com.umeng.message.proguard.ck r0 = r5     // Catch:{ all -> 0x00b0 }
                        r4 = 2005(0x7d5, float:2.81E-42)
                        r7.b(r0, r4)     // Catch:{ all -> 0x00b0 }
                        r6.f15801h = r3
                        return
                    L_0x00b0:
                        r7 = move-exception
                        r0 = 2
                        java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x00c4 }
                        java.lang.String r4 = "ad show error:"
                        r0[r1] = r4     // Catch:{ all -> 0x00c4 }
                        java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x00c4 }
                        r0[r3] = r7     // Catch:{ all -> 0x00c4 }
                        com.umeng.message.proguard.ce.a(r2, r0)     // Catch:{ all -> 0x00c4 }
                        r6.f15801h = r3
                        return
                    L_0x00c4:
                        r7 = move-exception
                        r6.f15801h = r3
                        throw r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.dm.AnonymousClass1.a(android.app.Activity):void");
                }

                public final void b() {
                    dc dcVar = dc.this;
                    dcVar.f15731c = null;
                    dcVar.f15732d = null;
                    a((bx.d) null);
                }
            };
        }
        ce.b("Banner", "banner title or content not match.");
        return null;
    }
}
