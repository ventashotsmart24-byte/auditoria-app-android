package com.umeng.message.proguard;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.cast.CastStatusCodes;
import com.hpplay.sdk.source.api.IConferenceMirrorListener;
import com.umeng.message.proguard.Cdo;
import com.umeng.message.proguard.bx;
import com.umeng.message.proguard.bz;
import com.umeng.message.proguard.cq;
import com.umeng.message.proguard.eh;
import com.umeng.message.push.R;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class dn extends dc {
    public dn(cz czVar) {
        super(czVar);
    }

    public static /* synthetic */ void a(dn dnVar, Activity activity, final ck ckVar, Bitmap bitmap, final da daVar) {
        if (activity.isFinishing()) {
            ce.b("FloatingIcon", "activity has finished skip.");
            cr.a().b(ckVar, IConferenceMirrorListener.CONFERENCE_GUESTMODE_SETGEUSTMODE_FAILED);
        } else if (ed.a(activity)) {
            ce.a("FloatingIcon", "activity window not match skipped.");
            cr.a().b(ckVar, 2024);
        } else if (dt.a().a((Class<? extends Activity>) activity.getClass())) {
            cr.a().b(ckVar, IConferenceMirrorListener.CONFERENCE_GUESTMODE_RESETGUESTMODE_OK);
            ce.a("FloatingIcon", "current activity not allow show ad:", activity.getClass().getName());
        } else {
            final Cdo doVar = new Cdo();
            final AnonymousClass2 r82 = new eh.a() {
                public final void c() {
                    eg egVar = doVar.f15825a;
                    if (egVar != null) {
                        egVar.post(new Runnable() {
                            public final void run() {
                                try {
                                    cr.a().a(ckVar, (cq.a) new cq.a() {
                                        public final void a() {
                                            cf cfVar = daVar.f15727a;
                                            if (cfVar != null) {
                                                cfVar.a();
                                            }
                                        }

                                        public final void a(String str) {
                                            cf cfVar = daVar.f15727a;
                                            if (cfVar != null) {
                                                cfVar.a(2010, str);
                                            }
                                        }
                                    });
                                    if (!ckVar.f15606b.optBoolean("expose_verify", false)) {
                                        AnonymousClass2 r12 = AnonymousClass2.this;
                                        eg egVar = doVar.f15825a;
                                        ckVar.f15611g = egVar.getWidth();
                                        ckVar.f15612h = egVar.getHeight();
                                        List<Integer> a10 = dw.a(egVar);
                                        if (!a10.isEmpty()) {
                                            for (Integer intValue : a10) {
                                                cr.a().c(ckVar, intValue.intValue());
                                            }
                                        }
                                        ckVar.f15606b.put("expose_verify", true);
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    }
                }

                public final void d() {
                }
            };
            View findViewById = activity.findViewById(R.id.umeng_fi_close);
            if (findViewById != null) {
                Object tag = findViewById.getTag();
                if (tag instanceof View.OnClickListener) {
                    ((View.OnClickListener) tag).onClick(findViewById);
                }
            }
            if (!(bitmap == null || ckVar == null)) {
                if (doVar.f15825a == null) {
                    doVar.f15825a = new eg(de.a());
                }
                doVar.f15825a.setAdImage(bitmap);
                doVar.f15825a.setIconClickListener(new View.OnClickListener() {
                    public final void onClick(
/*
Method generation error in method: com.umeng.message.proguard.do.1.onClick(android.view.View):void, dex: classes3.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.umeng.message.proguard.do.1.onClick(android.view.View):void, class status: UNLOADED
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
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
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
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                });
                doVar.f15825a.setCloseClickListener(new View.OnClickListener() {
                    public final void onClick(
/*
Method generation error in method: com.umeng.message.proguard.do.2.onClick(android.view.View):void, dex: classes3.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.umeng.message.proguard.do.2.onClick(android.view.View):void, class status: UNLOADED
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
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
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
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                });
                doVar.f15825a.setAdMarkVisibility(ckVar.f());
                doVar.a(activity);
                if (doVar.f15827c == null) {
                    doVar.f15827c = new dp(doVar);
                    bz.a().a((bz.b) doVar.f15827c);
                }
            }
            eg egVar = doVar.f15825a;
            if (egVar != null) {
                egVar.setOnStatusListener(r82);
            }
            final Cdo doVar2 = doVar;
            final ck ckVar2 = ckVar;
            final da daVar2 = daVar;
            final Bitmap bitmap2 = bitmap;
            doVar.f15826b = new Cdo.a() {
                public final void a() {
                    try {
                        doVar2.b();
                        ckVar2.f15606b.put("exposed_duration", r82.e());
                        cr.a().a(ckVar2, 2220);
                        cf cfVar = daVar2.f15727a;
                        if (cfVar != null) {
                            cfVar.b();
                        }
                        if (!bitmap2.isRecycled()) {
                            bitmap2.recycle();
                        }
                    } catch (Throwable unused) {
                    }
                }

                public final void a(final View view) {
                    try {
                        ckVar2.f15606b.put("clicked", true);
                        ckVar2.f15606b.put("exposed_duration", r82.e());
                        ck ckVar = ckVar2;
                        eh.a aVar = r82;
                        ckVar.f15617m = aVar.f15905g;
                        ckVar.f15618n = aVar.f15907i;
                        ckVar.f15619o = aVar.f15906h;
                        ckVar.f15620p = aVar.f15908j;
                        ckVar.f15621q = aVar.f15909k;
                        ckVar.f15622r = aVar.f15910l;
                        ckVar.f15623s = aVar.f15911m;
                        ckVar.f15624t = aVar.f15912n;
                        dy.a(de.a(), ckVar2, (cq.a) new cq.a() {
                            public final void a() {
                                cf cfVar = daVar2.f15727a;
                                if (cfVar != null) {
                                    cfVar.a(view);
                                }
                            }

                            public final void a(String str) {
                                cf cfVar = daVar2.f15727a;
                                if (cfVar != null) {
                                    cfVar.a(IConferenceMirrorListener.CONFERENCE_GUESTMODE_SETGEUSTMODE_OK, str);
                                }
                            }
                        });
                        doVar2.b();
                        if (!bitmap2.isRecycled()) {
                            bitmap2.recycle();
                        }
                    } catch (Throwable unused) {
                    }
                }
            };
        }
    }

    public final ck b() {
        ck a10 = ci.a(this.f15730b).a(this.f15729a);
        if (a10 == null) {
            ce.b("FloatingIcon", "type:", this.f15730b, " request ad failed.");
            throw new cd("request ad failed. code:2000");
        } else if (a10.f15608d == 0) {
            return a10;
        } else {
            throw new cd(a10.f15607c);
        }
    }

    public final bx.a b(final ck ckVar) {
        final Bitmap a10 = cc.a(de.a(), ckVar.b());
        if (a10 != null) {
            final AtomicReference atomicReference = new AtomicReference();
            AnonymousClass1 r22 = new da() {

                /* renamed from: f  reason: collision with root package name */
                private boolean f15806f = false;

                /* JADX WARNING: Can't wrap try/catch for region: R(7:32|33|34|35|(1:37)|38|39) */
                /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x009b */
                /* JADX WARNING: Removed duplicated region for block: B:37:0x00c5 A[Catch:{ all -> 0x0143, all -> 0x0156 }] */
                /* JADX WARNING: Unknown top exception splitter block from list: {B:67:0x0130=Splitter:B:67:0x0130, B:29:0x0088=Splitter:B:29:0x0088, B:34:0x009b=Splitter:B:34:0x009b, B:25:0x007c=Splitter:B:25:0x007c} */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void a(final android.app.Activity r9) {
                    /*
                        r8 = this;
                        boolean r0 = r8.f15806f
                        r1 = 2010(0x7da, float:2.817E-42)
                        r2 = 0
                        java.lang.String r3 = "FloatingIcon"
                        r4 = 1
                        if (r0 == 0) goto L_0x001b
                        java.lang.Object[] r9 = new java.lang.Object[r4]
                        java.lang.String r0 = "already called show."
                        r9[r2] = r0
                        com.umeng.message.proguard.ce.d(r3, r9)
                        com.umeng.message.proguard.cf r9 = r8.f15727a
                        if (r9 == 0) goto L_0x001a
                        r9.a(r1, r0)
                    L_0x001a:
                        return
                    L_0x001b:
                        r0 = 2
                        com.umeng.message.proguard.dn r5 = com.umeng.message.proguard.dn.this     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.cz r5 = r5.f15729a     // Catch:{ all -> 0x0143 }
                        boolean r5 = r5.f15718c     // Catch:{ all -> 0x0143 }
                        r6 = 2021(0x7e5, float:2.832E-42)
                        if (r5 == 0) goto L_0x0088
                        com.umeng.message.proguard.bz r9 = com.umeng.message.proguard.bz.a()     // Catch:{ all -> 0x0143 }
                        boolean r9 = r9.f15552a     // Catch:{ all -> 0x0143 }
                        if (r9 != 0) goto L_0x003c
                        com.umeng.message.proguard.cq r9 = com.umeng.message.proguard.cr.a()     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.ck r1 = r4     // Catch:{ all -> 0x0143 }
                        r5 = 2020(0x7e4, float:2.83E-42)
                        r9.b(r1, r5)     // Catch:{ all -> 0x0143 }
                        r8.f15806f = r4
                        return
                    L_0x003c:
                        com.umeng.message.proguard.bz r9 = com.umeng.message.proguard.bz.a()     // Catch:{ all -> 0x0143 }
                        android.app.Activity r9 = r9.b()     // Catch:{ all -> 0x0143 }
                        if (r9 == 0) goto L_0x007c
                        boolean r5 = r9.isFinishing()     // Catch:{ all -> 0x0143 }
                        if (r5 == 0) goto L_0x004d
                        goto L_0x007c
                    L_0x004d:
                        com.umeng.message.proguard.dt r5 = com.umeng.message.proguard.dt.a()     // Catch:{ all -> 0x0143 }
                        java.lang.Class r7 = r9.getClass()     // Catch:{ all -> 0x0143 }
                        boolean r5 = r5.a((java.lang.Class<? extends android.app.Activity>) r7)     // Catch:{ all -> 0x0143 }
                        if (r5 == 0) goto L_0x0088
                        com.umeng.message.proguard.cq r1 = com.umeng.message.proguard.cr.a()     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.ck r5 = r4     // Catch:{ all -> 0x0143 }
                        r6 = 2022(0x7e6, float:2.833E-42)
                        r1.b(r5, r6)     // Catch:{ all -> 0x0143 }
                        java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0143 }
                        java.lang.String r5 = "current activity not allow show ad:"
                        r1[r2] = r5     // Catch:{ all -> 0x0143 }
                        java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x0143 }
                        java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x0143 }
                        r1[r4] = r9     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.ce.a(r3, r1)     // Catch:{ all -> 0x0143 }
                        r8.f15806f = r4
                        return
                    L_0x007c:
                        com.umeng.message.proguard.cq r9 = com.umeng.message.proguard.cr.a()     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.ck r1 = r4     // Catch:{ all -> 0x0143 }
                        r9.b(r1, r6)     // Catch:{ all -> 0x0143 }
                        r8.f15806f = r4
                        return
                    L_0x0088:
                        com.umeng.message.proguard.dn r5 = com.umeng.message.proguard.dn.this     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.ck r7 = r4     // Catch:{ all -> 0x0143 }
                        boolean r5 = r5.a(r7)     // Catch:{ all -> 0x0143 }
                        if (r5 == 0) goto L_0x00cb
                        com.umeng.message.proguard.ck r9 = r4     // Catch:{ Exception -> 0x009b }
                        org.json.JSONObject r9 = r9.f15606b     // Catch:{ Exception -> 0x009b }
                        java.lang.String r5 = "exposed_timeout"
                        r9.put(r5, r4)     // Catch:{ Exception -> 0x009b }
                    L_0x009b:
                        com.umeng.message.proguard.cq r9 = com.umeng.message.proguard.cr.a()     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.ck r5 = r4     // Catch:{ all -> 0x0143 }
                        r6 = 2023(0x7e7, float:2.835E-42)
                        r9.b(r5, r6)     // Catch:{ all -> 0x0143 }
                        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0143 }
                        java.lang.String r5 = "expose invalid timeout config:"
                        r9.<init>(r5)     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.ck r5 = r4     // Catch:{ all -> 0x0143 }
                        int r5 = r5.h()     // Catch:{ all -> 0x0143 }
                        r9.append(r5)     // Catch:{ all -> 0x0143 }
                        java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0143 }
                        java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0143 }
                        r5[r2] = r9     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.ce.d(r3, r5)     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.cf r5 = r8.f15727a     // Catch:{ all -> 0x0143 }
                        if (r5 == 0) goto L_0x00c8
                        r5.a(r1, r9)     // Catch:{ all -> 0x0143 }
                    L_0x00c8:
                        r8.f15806f = r4
                        return
                    L_0x00cb:
                        com.umeng.message.proguard.dn r1 = com.umeng.message.proguard.dn.this     // Catch:{ all -> 0x0143 }
                        java.lang.ref.WeakReference<android.app.Activity> r1 = r1.f15732d     // Catch:{ all -> 0x0143 }
                        if (r1 == 0) goto L_0x00d8
                        java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0143 }
                        android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ all -> 0x0143 }
                        goto L_0x00d9
                    L_0x00d8:
                        r1 = 0
                    L_0x00d9:
                        java.lang.String r5 = "activity has finished skip."
                        if (r9 == 0) goto L_0x0114
                        boolean r7 = r9.isFinishing()     // Catch:{ all -> 0x0143 }
                        if (r7 == 0) goto L_0x00f6
                        java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x0143 }
                        r9[r2] = r5     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.ce.b(r3, r9)     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.cq r9 = com.umeng.message.proguard.cr.a()     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.ck r1 = r4     // Catch:{ all -> 0x0143 }
                        r9.b(r1, r6)     // Catch:{ all -> 0x0143 }
                        r8.f15806f = r4
                        return
                    L_0x00f6:
                        if (r9 == r1) goto L_0x0101
                        java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ all -> 0x0143 }
                        java.lang.String r5 = "current activity not match request activity."
                        r1[r2] = r5     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.ce.a(r3, r1)     // Catch:{ all -> 0x0143 }
                    L_0x0101:
                        android.view.Window r1 = r9.getWindow()     // Catch:{ all -> 0x0143 }
                        android.view.View r1 = r1.getDecorView()     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.dn$1$1 r5 = new com.umeng.message.proguard.dn$1$1     // Catch:{ all -> 0x0143 }
                        r5.<init>(r9)     // Catch:{ all -> 0x0143 }
                        r1.post(r5)     // Catch:{ all -> 0x0143 }
                        r8.f15806f = r4
                        return
                    L_0x0114:
                        if (r1 == 0) goto L_0x0130
                        boolean r9 = r1.isFinishing()     // Catch:{ all -> 0x0143 }
                        if (r9 == 0) goto L_0x011d
                        goto L_0x0130
                    L_0x011d:
                        android.view.Window r9 = r1.getWindow()     // Catch:{ all -> 0x0143 }
                        android.view.View r9 = r9.getDecorView()     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.dn$1$2 r5 = new com.umeng.message.proguard.dn$1$2     // Catch:{ all -> 0x0143 }
                        r5.<init>(r1)     // Catch:{ all -> 0x0143 }
                        r9.post(r5)     // Catch:{ all -> 0x0143 }
                        r8.f15806f = r4
                        return
                    L_0x0130:
                        java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x0143 }
                        r9[r2] = r5     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.ce.b(r3, r9)     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.cq r9 = com.umeng.message.proguard.cr.a()     // Catch:{ all -> 0x0143 }
                        com.umeng.message.proguard.ck r1 = r4     // Catch:{ all -> 0x0143 }
                        r9.b(r1, r6)     // Catch:{ all -> 0x0143 }
                        r8.f15806f = r4
                        return
                    L_0x0143:
                        r9 = move-exception
                        java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0156 }
                        java.lang.String r1 = "ad show error:"
                        r0[r2] = r1     // Catch:{ all -> 0x0156 }
                        java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0156 }
                        r0[r4] = r9     // Catch:{ all -> 0x0156 }
                        com.umeng.message.proguard.ce.a(r3, r0)     // Catch:{ all -> 0x0156 }
                        r8.f15806f = r4
                        return
                    L_0x0156:
                        r9 = move-exception
                        r8.f15806f = r4
                        throw r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.dn.AnonymousClass1.a(android.app.Activity):void");
                }
            };
            atomicReference.set(r22);
            return r22;
        }
        ce.b("FloatingIcon", "material download failed. sid:" + ckVar.c());
        cr.a().b(ckVar, CastStatusCodes.INVALID_REQUEST);
        throw new cd("material download failed.");
    }
}
