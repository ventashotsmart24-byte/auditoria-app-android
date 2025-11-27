package com.umeng.message.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.inapp.InAppMessageManager;
import java.io.File;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class aj {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static boolean f15350b = false;

    /* renamed from: c  reason: collision with root package name */
    private static volatile aj f15351c;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f15352a;

    private aj(Context context) {
        this.f15352a = context.getApplicationContext();
    }

    private void c() {
        if (f15350b) {
            UMLog.mutlInfo("UmengInAppMessageTracker", 2, "sendInAppCacheLog已经在队列里，忽略该请求");
            return;
        }
        f15350b = true;
        UMLog.mutlInfo("UmengInAppMessageTracker", 2, "sendInAppCacheLog开始");
        b.c(new Runnable() {
            public final void run() {
                try {
                    Iterator<af> it = InAppMessageManager.getInstance(aj.this.f15352a).b().iterator();
                    while (it.hasNext()) {
                        af next = it.next();
                        JSONObject b10 = aj.b(next.f15324b, next.f15325c, next.f15326d, next.f15327e, next.f15328f, next.f15329g, next.f15330h, next.f15331i, next.f15332j);
                        if (b10 != null && TextUtils.equals(b10.getString("success"), ITagManager.SUCCESS)) {
                            InAppMessageManager instance = InAppMessageManager.getInstance(aj.this.f15352a);
                            instance.f15236b.getContentResolver().delete(h.e(instance.f15236b), "MsgId=?", new String[]{next.f15324b});
                        }
                    }
                } catch (Exception e10) {
                    UPLog.w("UmengInAppMessageTracker", "sendInAppCacheLog error:" + e10.getMessage());
                } finally {
                    boolean unused = aj.f15350b = false;
                }
            }
        });
    }

    public static aj a(Context context) {
        if (f15351c == null) {
            synchronized (aj.class) {
                if (f15351c == null) {
                    f15351c = new aj(context);
                }
            }
        }
        return f15351c;
    }

    public static /* synthetic */ JSONObject b(String str, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", e.a());
        jSONObject.put("msg_id", str);
        jSONObject.put("msg_type", i10);
        jSONObject.put("num_display", i11);
        jSONObject.put("num_open_full", i12);
        jSONObject.put("num_open_top", i13);
        jSONObject.put("num_open_bottom", i14);
        jSONObject.put("num_close", i15);
        jSONObject.put("num_duration", i16);
        jSONObject.put("num_custom", i17);
        return g.a(jSONObject, "https://msg.umengcloud.com/admsg/v3/stats", UMUtils.getAppkey(y.a()), true);
    }

    public final void a(final ae aeVar) {
        if (f.b()) {
            UPLog.i("UmengInAppMessageTracker", "getSplashMsg failed, silent mode!");
            return;
        }
        c();
        b.c(new Runnable() {
            public final void run() {
                UInAppMessage uInAppMessage;
                UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get splash message begin");
                try {
                    JSONObject a10 = g.a(aj.a(), "https://msg.umengcloud.com/admsg/v3/launch", UMUtils.getAppkey(y.a()), true);
                    if (TextUtils.equals(a10.getString("success"), ITagManager.SUCCESS)) {
                        UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get splash message success".concat(String.valueOf(a10)));
                        JSONObject jSONObject = a10.getJSONObject("data");
                        InAppMessageManager.f15233d = jSONObject.getInt("pduration") * 1000;
                        InAppMessageManager.f15234e = jSONObject.getInt("sduration") * 1000;
                        aeVar.a(new UInAppMessage(jSONObject.getJSONObject("launch")));
                        InAppMessageManager instance = InAppMessageManager.getInstance(aj.this.f15352a);
                        StringBuilder sb = new StringBuilder();
                        sb.append(System.currentTimeMillis());
                        instance.b("KEY_SPLASH_TS", sb.toString());
                    } else if (!TextUtils.equals(a10.getString("success"), ITagManager.FAIL) || !TextUtils.equals(a10.getString("error"), "no message")) {
                        aeVar.a((UInAppMessage) null);
                    } else {
                        String a11 = InAppMessageManager.getInstance(aj.this.f15352a).a();
                        if (!TextUtils.isEmpty(a11)) {
                            try {
                                uInAppMessage = new UInAppMessage(new JSONObject(a11));
                            } catch (JSONException e10) {
                                e10.printStackTrace();
                                uInAppMessage = null;
                            }
                            if (uInAppMessage != null) {
                                InAppMessageManager.getInstance(aj.this.f15352a).a(new File(f.a(aj.this.f15352a, uInAppMessage.msg_id)));
                                InAppMessageManager.getInstance(aj.this.f15352a).a((UInAppMessage) null);
                            }
                        }
                    }
                } catch (Exception e11) {
                    UPLog.w("UmengInAppMessageTracker", "getSplashMsg error: ", e11.getMessage());
                    aeVar.a((UInAppMessage) null);
                }
            }
        });
    }

    public final void a(final String str, final ae aeVar) {
        if (f.b()) {
            UPLog.i("UmengInAppMessageTracker", "getCardMsg failed, silent mode!");
            return;
        }
        c();
        b.c(new Runnable() {
            public final void run() {
                UInAppMessage uInAppMessage;
                UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get card message begin");
                try {
                    JSONObject a10 = aj.a();
                    a10.put(Constants.ScionAnalytics.PARAM_LABEL, str);
                    JSONObject a11 = g.a(a10, "https://msg.umengcloud.com/admsg/v3/getmsg", UMUtils.getAppkey(y.a()), true);
                    if (TextUtils.equals(a11.getString("success"), ITagManager.SUCCESS)) {
                        UMLog.mutlInfo("UmengInAppMessageTracker", 2, "get card message success".concat(String.valueOf(a11)));
                        JSONObject jSONObject = a11.getJSONObject("data");
                        InAppMessageManager.f15233d = jSONObject.getInt("pduration") * 1000;
                        InAppMessageManager.f15234e = jSONObject.getInt("sduration") * 1000;
                        aeVar.b(new UInAppMessage(jSONObject.getJSONObject("card")));
                        InAppMessageManager instance = InAppMessageManager.getInstance(aj.this.f15352a);
                        String concat = "KEY_CARD_TS_".concat(String.valueOf(a10.optString(Constants.ScionAnalytics.PARAM_LABEL, "")));
                        StringBuilder sb = new StringBuilder();
                        sb.append(System.currentTimeMillis());
                        instance.b(concat, sb.toString());
                    } else if (!TextUtils.equals(a11.getString("success"), ITagManager.FAIL) || !TextUtils.equals(a11.getString("error"), "no message")) {
                        aeVar.b((UInAppMessage) null);
                    } else {
                        String a12 = InAppMessageManager.getInstance(aj.this.f15352a).a(str);
                        if (!TextUtils.isEmpty(a12)) {
                            try {
                                uInAppMessage = new UInAppMessage(new JSONObject(a12));
                            } catch (JSONException e10) {
                                e10.printStackTrace();
                                uInAppMessage = null;
                            }
                            if (uInAppMessage != null) {
                                InAppMessageManager.getInstance(aj.this.f15352a).a(new File(f.a(aj.this.f15352a, uInAppMessage.msg_id)));
                                InAppMessageManager.getInstance(aj.this.f15352a).a((UInAppMessage) null, str);
                            }
                        }
                    }
                } catch (Exception e11) {
                    UPLog.w("UmengInAppMessageTracker", "getCardMsg error: ", e11.getMessage());
                    aeVar.b((UInAppMessage) null);
                }
            }
        });
    }

    public final void a(String str, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        final String str2 = str;
        final int i18 = i10;
        final int i19 = i11;
        final int i20 = i12;
        final int i21 = i13;
        final int i22 = i14;
        final int i23 = i15;
        final int i24 = i16;
        final int i25 = i17;
        b.c(new Runnable() {
            public final void run() {
                try {
                    UMLog.mutlInfo("UmengInAppMessageTracker", 2, "track in app msg begin");
                    JSONObject b10 = aj.b(str2, i18, i19, i20, i21, i22, i23, i24, i25);
                    if (b10 != null && TextUtils.equals(b10.getString("success"), ITagManager.SUCCESS)) {
                        UMLog.mutlInfo("UmengInAppMessageTracker", 2, "track in app msg success");
                    }
                } catch (Exception e10) {
                    UPLog.w("UmengInAppMessageTracker", "trackInAppMessage error:" + e10.getMessage());
                    InAppMessageManager instance = InAppMessageManager.getInstance(aj.this.f15352a);
                    String str = str2;
                    int i10 = i18;
                    int i11 = i19;
                    int i12 = i20;
                    int i13 = i21;
                    int i14 = i22;
                    int i15 = i23;
                    int i16 = i24;
                    int i17 = i25;
                    if (!TextUtils.isEmpty(str)) {
                        b.c(new Runnable(str, i10, i11, i12, i13, i14, i15, i16, i17) {

                            /* renamed from: a */
                            final /* synthetic */ String f15240a;

                            /* renamed from: b */
                            final /* synthetic */ int f15241b;

                            /* renamed from: c */
                            final /* synthetic */ int f15242c;

                            /* renamed from: d */
                            final /* synthetic */ int f15243d;

                            /* renamed from: e */
                            final /* synthetic */ int f15244e;

                            /* renamed from: f */
                            final /* synthetic */ int f15245f;

                            /* renamed from: g */
                            final /* synthetic */ int f15246g;

                            /* renamed from: h */
                            final /* synthetic */ int f15247h;

                            /* renamed from: i */
                            final /* synthetic */ int f15248i;

                            public final void run(
/*
Method generation error in method: com.umeng.message.inapp.InAppMessageManager.1.run():void, dex: classes3.dex
                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.umeng.message.inapp.InAppMessageManager.1.run():void, class status: UNLOADED
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
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:363)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:322)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
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
                    }
                }
            }
        });
    }

    public static /* synthetic */ JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", e.a());
        jSONObject.put("pmode", InAppMessageManager.f15232a ? "0" : "1");
        return jSONObject;
    }
}
