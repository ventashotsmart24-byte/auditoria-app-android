package com.efs.sdk.pa.a;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import android.view.View;
import android.view.ViewTreeObserver;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.pa.PA;
import com.efs.sdk.pa.PAANRListener;
import com.efs.sdk.pa.PAMsgListener;
import com.efs.sdk.pa.a.b;
import com.efs.sdk.pa.a.g;

public final class c implements PA {

    /* renamed from: a  reason: collision with root package name */
    private boolean f5541a;

    /* renamed from: b  reason: collision with root package name */
    private Looper f5542b = Looper.myLooper();

    /* renamed from: c  reason: collision with root package name */
    private e f5543c;

    /* renamed from: d  reason: collision with root package name */
    private f f5544d;

    /* renamed from: e  reason: collision with root package name */
    private a f5545e;

    /* renamed from: f  reason: collision with root package name */
    private b f5546f = new b();

    /* renamed from: g  reason: collision with root package name */
    private g f5547g = new g();

    /* renamed from: h  reason: collision with root package name */
    private boolean f5548h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5549i;

    public c(boolean z10) {
        this.f5549i = z10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029 A[SYNTHETIC, Splitter:B:16:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void enableDumpToFile(java.lang.String r3) {
        /*
            r2 = this;
            com.efs.sdk.pa.a.f r0 = r2.f5544d
            if (r0 == 0) goto L_0x002c
            if (r3 == 0) goto L_0x002c
            java.lang.String r1 = r3.trim()
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0011
            goto L_0x002c
        L_0x0011:
            r0.f5558c = r3
            java.io.BufferedOutputStream r1 = r0.f5559d
            if (r1 != 0) goto L_0x002c
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0026 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0026 }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0024 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0024 }
            r0.f5559d = r3     // Catch:{ Exception -> 0x0024 }
            return
        L_0x0024:
            goto L_0x0027
        L_0x0026:
            r1 = 0
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()     // Catch:{ Exception -> 0x002c }
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.pa.a.c.enableDumpToFile(java.lang.String):void");
    }

    public final void enableLog(boolean z10) {
        this.f5541a = z10;
        this.f5546f.f5535b = z10;
        this.f5547g.f5561b = z10;
        f fVar = this.f5544d;
        if (fVar != null) {
            fVar.f5557b = z10;
        }
    }

    public final int endCalFPS(String str) {
        if (!this.f5548h) {
            return -1;
        }
        b bVar = this.f5546f;
        int i10 = 0;
        if (!(str == null || str.trim().length() == 0)) {
            b.a aVar = bVar.f5534a.get(str);
            if (aVar == null) {
                return 0;
            }
            View view = aVar.f5539d;
            if (!(view == null || aVar.f5538c == null)) {
                view.getViewTreeObserver().removeOnPreDrawListener(aVar.f5538c);
            }
            bVar.f5534a.remove(str);
            int currentTimeMillis = (int) (((float) aVar.f5537b) / (((float) (System.currentTimeMillis() - aVar.f5536a)) / 1000.0f));
            if (currentTimeMillis > 0) {
                i10 = currentTimeMillis;
            }
            if (bVar.f5535b) {
                Log.e("PerformanceAnalyze", "key=" + str + ",fps=" + i10);
            }
        }
        return i10;
    }

    public final long endCalTime(String str) {
        if (!this.f5548h) {
            return -1;
        }
        g gVar = this.f5547g;
        long j10 = 0;
        if (!(str == null || str.trim().length() == 0)) {
            g.a aVar = gVar.f5560a.get(str);
            if (aVar == null) {
                return 0;
            }
            gVar.f5560a.remove(str);
            j10 = System.currentTimeMillis() - aVar.f5562a;
            if (gVar.f5561b) {
                Log.e("PerformanceAnalyze", "key=" + str + ",consumeTime=" + j10);
            }
        }
        return j10;
    }

    public final void registerPAANRListener(Context context, PAANRListener pAANRListener) {
        registerPAANRListener(context, pAANRListener, 2000);
    }

    public final void registerPAMsgListener(PAMsgListener pAMsgListener) {
        if (this.f5543c == null) {
            this.f5543c = new e();
        }
        this.f5542b.setMessageLogging(this.f5543c);
        if (this.f5544d == null) {
            this.f5544d = new f();
        }
        f fVar = this.f5544d;
        fVar.f5557b = this.f5541a;
        fVar.f5556a = pAMsgListener;
        this.f5543c.f5550a.add(fVar);
    }

    public final void start() {
        if (this.f5549i || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            this.f5548h = true;
            e eVar = this.f5543c;
            if (eVar != null) {
                this.f5542b.setMessageLogging(eVar);
            }
            a aVar = this.f5545e;
            if (aVar != null && aVar.f5521f) {
                aVar.f5521f = false;
                aVar.f5522g.post(aVar.f5528m);
                aVar.f5525j = SystemClock.uptimeMillis();
            }
        }
    }

    public final void startCalFPS(String str, View view) {
        if (this.f5548h) {
            b bVar = this.f5546f;
            if (str != null && str.trim().length() != 0 && view != null && bVar.f5534a.get(str) == null) {
                b.a aVar = new b.a((byte) 0);
                aVar.f5539d = view;
                b.a.AnonymousClass1 r62 = new ViewTreeObserver.OnPreDrawListener() {
                    public final boolean onPreDraw(
/*
Method generation error in method: com.efs.sdk.pa.a.b.a.1.onPreDraw():boolean, dex: classes.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.efs.sdk.pa.a.b.a.1.onPreDraw():boolean, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                };
                aVar.f5538c = r62;
                aVar.f5539d.getViewTreeObserver().addOnPreDrawListener(r62);
                aVar.f5536a = System.currentTimeMillis();
                bVar.f5534a.put(str, aVar);
            }
        }
    }

    public final void startCalTime(String str) {
        if (this.f5548h) {
            g gVar = this.f5547g;
            if (str != null && str.trim().length() != 0 && gVar.f5560a.get(str) == null) {
                g.a aVar = new g.a((byte) 0);
                aVar.f5562a = System.currentTimeMillis();
                gVar.f5560a.put(str, aVar);
            }
        }
    }

    public final void stop() {
        this.f5548h = false;
        this.f5542b.setMessageLogging((Printer) null);
        a aVar = this.f5545e;
        if (aVar != null) {
            aVar.f5521f = true;
            aVar.f5522g.removeCallbacksAndMessages((Object) null);
            aVar.f5516a = true;
        }
    }

    public final void unRegisterPAMsgListener() {
        f fVar = this.f5544d;
        if (fVar != null) {
            fVar.f5556a = null;
        }
        e eVar = this.f5543c;
        if (eVar != null) {
            eVar.f5550a.remove(fVar);
        }
    }

    public final void unregisterPAANRListener() {
    }

    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j10) {
        registerPAANRListener(context, pAANRListener, j10, Looper.getMainLooper().getThread());
    }

    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j10, Thread thread) {
        if (this.f5545e == null) {
            if (thread != null) {
                this.f5545e = new a((Application) context.getApplicationContext(), j10);
            } else {
                this.f5545e = new a((Application) context.getApplicationContext(), j10, false);
            }
        }
        this.f5545e.f5523h = pAANRListener;
    }
}
