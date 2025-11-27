package com.taobao.accs.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import anet.channel.SessionCenter;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.a.a;
import com.taobao.accs.b;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.c;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.g;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;
import com.taobao.accs.utl.k;
import com.taobao.accs.utl.l;
import com.taobao.accs.utl.v;
import com.umeng.analytics.pro.f;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.Config;

public class ACCSManagerImpl implements b {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static String f13004c = "ACCSMgrImpl_";

    /* renamed from: a  reason: collision with root package name */
    private int f13005a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f13006b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public c f13007d;

    /* renamed from: e  reason: collision with root package name */
    private Random f13008e = new Random();

    /* renamed from: f  reason: collision with root package name */
    private l.b f13009f = new a(this);

    public ACCSManagerImpl(Context context, String str) {
        GlobalClientInfo.f12899a = context.getApplicationContext();
        this.f13006b = str;
        this.f13007d = new c(str);
        if (v.e(context)) {
            l.a().a(this.f13009f);
        }
        f13004c += this.f13006b;
    }

    public void c(Context context, String str) {
        if (!UtilityImpl.d(context)) {
            Intent b10 = b(context, 6);
            if (b10 == null) {
                a(context, 6, str, (String) null);
                return;
            }
            String c10 = this.f13007d.c();
            if (!TextUtils.isEmpty(c10)) {
                b10.putExtra(Constants.KEY_APP_KEY, c10);
                b10.putExtra(Constants.KEY_SERVICE_ID, str);
                if (UtilityImpl.isMainProcess(context)) {
                    a(context, Message.buildUnbindService(this.f13007d.b((String) null), this.f13006b, b10), 6, false);
                }
            }
        }
    }

    public void e(Context context) {
        GlobalClientInfo.getInstance(context).clearLoginInfoImpl();
    }

    public void b(Context context, String str) {
        if (!UtilityImpl.d(context) && !UtilityImpl.d(context)) {
            Intent b10 = b(context, 5);
            if (b10 == null) {
                a(context, 5, str, (String) null);
                return;
            }
            String c10 = this.f13007d.c();
            if (!TextUtils.isEmpty(c10)) {
                b10.putExtra(Constants.KEY_APP_KEY, c10);
                b10.putExtra(Constants.KEY_SERVICE_ID, str);
                if (UtilityImpl.isMainProcess(context)) {
                    Message buildBindService = Message.buildBindService(this.f13007d.b((String) null), this.f13006b, b10);
                    if (!(buildBindService == null || buildBindService.getNetPermanceMonitor() == null)) {
                        buildBindService.getNetPermanceMonitor().setDataId(buildBindService.dataId);
                        buildBindService.getNetPermanceMonitor().setMsgType(3);
                        buildBindService.getNetPermanceMonitor().setHost(buildBindService.host.toString());
                    }
                    a(context, buildBindService, 5, false);
                }
                this.f13007d.b();
            }
        }
    }

    public void d(Context context) {
        UtilityImpl.focusEnableService(context);
    }

    public void e(Context context, String str) {
        GlobalClientInfo.getInstance(context).unregisterListener(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086 A[Catch:{ all -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ab A[Catch:{ all -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ba A[Catch:{ all -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f0 A[Catch:{ all -> 0x00ff }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, com.taobao.accs.IAppReceiver r14) {
        /*
            r9 = this;
            java.lang.String r0 = "ACCS_SDK"
            if (r10 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.String r1 = f13004c
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            java.lang.String r4 = "appKey"
            r2[r3] = r4
            r5 = 1
            r2[r5] = r11
            java.lang.String r6 = "bindApp"
            com.taobao.accs.utl.ALog.i(r1, r6, r2)
            java.lang.String r1 = r10.getPackageName()
            com.taobao.accs.data.Message r1 = com.taobao.accs.data.Message.buildParameterError(r1, r5)
            boolean r2 = com.taobao.accs.utl.UtilityImpl.d(r10)
            if (r2 == 0) goto L_0x0031
            java.lang.String r2 = f13004c
            java.lang.String r7 = "accs disabled, try enable"
            java.lang.Object[] r8 = new java.lang.Object[r3]
            com.taobao.accs.utl.ALog.e(r2, r7, r8)
            com.taobao.accs.utl.UtilityImpl.focusEnableService(r10)
        L_0x0031:
            boolean r2 = android.text.TextUtils.isEmpty(r11)
            if (r2 == 0) goto L_0x003f
            com.taobao.accs.c r10 = r9.f13007d
            r11 = -14
            r10.a((com.taobao.accs.data.Message) r1, (int) r11)
            return
        L_0x003f:
            com.taobao.accs.c r1 = r9.f13007d
            r1.c(r13)
            com.taobao.accs.c r1 = r9.f13007d
            r1.d(r11)
            if (r14 == 0) goto L_0x0054
            com.taobao.accs.client.GlobalClientInfo r1 = com.taobao.accs.client.GlobalClientInfo.getInstance(r10)
            java.lang.String r2 = r9.f13006b
            r1.setAppReceiver(r2, r14)
        L_0x0054:
            com.taobao.accs.utl.UtilityImpl.enableService(r10)
            android.content.Intent r14 = r9.b((android.content.Context) r10, (int) r5)
            if (r14 != 0) goto L_0x005e
            return
        L_0x005e:
            com.taobao.accs.client.GlobalClientInfo r1 = com.taobao.accs.client.GlobalClientInfo.getInstance(r10)     // Catch:{ all -> 0x00ff }
            android.content.pm.PackageInfo r1 = r1.getPackageInfo()     // Catch:{ all -> 0x00ff }
            java.lang.String r1 = r1.versionName     // Catch:{ all -> 0x00ff }
            boolean r2 = com.taobao.accs.utl.UtilityImpl.c(r10)     // Catch:{ all -> 0x00ff }
            if (r2 != 0) goto L_0x0083
            boolean r2 = com.taobao.accs.utl.UtilityImpl.a((java.lang.String) r0, (android.content.Context) r10)     // Catch:{ all -> 0x00ff }
            if (r2 != 0) goto L_0x0083
            boolean r0 = com.taobao.accs.utl.UtilityImpl.b((java.lang.String) r0, (android.content.Context) r10)     // Catch:{ all -> 0x00ff }
            if (r0 != 0) goto L_0x0083
            boolean r0 = org.android.agoo.common.Config.a()     // Catch:{ all -> 0x00ff }
            if (r0 == 0) goto L_0x0081
            goto L_0x0083
        L_0x0081:
            r0 = 0
            goto L_0x0084
        L_0x0083:
            r0 = 1
        L_0x0084:
            if (r0 == 0) goto L_0x0096
            java.lang.String r2 = f13004c     // Catch:{ all -> 0x00ff }
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x00ff }
            java.lang.String r8 = "need force bind"
            r7[r3] = r8     // Catch:{ all -> 0x00ff }
            com.taobao.accs.utl.ALog.d(r2, r6, r7)     // Catch:{ all -> 0x00ff }
            java.lang.String r2 = "fouce_bind"
            r14.putExtra(r2, r5)     // Catch:{ all -> 0x00ff }
        L_0x0096:
            r14.putExtra(r4, r11)     // Catch:{ all -> 0x00ff }
            java.lang.String r11 = "ttid"
            r14.putExtra(r11, r13)     // Catch:{ all -> 0x00ff }
            java.lang.String r11 = "appVersion"
            r14.putExtra(r11, r1)     // Catch:{ all -> 0x00ff }
            java.lang.String r11 = "app_sercet"
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x00ff }
            if (r13 == 0) goto L_0x00b1
            com.taobao.accs.c r12 = r9.f13007d     // Catch:{ all -> 0x00ff }
            java.lang.String r12 = r12.d()     // Catch:{ all -> 0x00ff }
        L_0x00b1:
            r14.putExtra(r11, r12)     // Catch:{ all -> 0x00ff }
            boolean r11 = com.taobao.accs.utl.UtilityImpl.isMainProcess(r10)     // Catch:{ all -> 0x00ff }
            if (r11 == 0) goto L_0x00f0
            com.taobao.accs.c r11 = r9.f13007d     // Catch:{ all -> 0x00ff }
            r12 = 0
            java.lang.String r11 = r11.b((java.lang.String) r12)     // Catch:{ all -> 0x00ff }
            java.lang.String r12 = r9.f13006b     // Catch:{ all -> 0x00ff }
            com.taobao.accs.data.Message r11 = com.taobao.accs.data.Message.buildBindApp(r11, r12, r10, r14)     // Catch:{ all -> 0x00ff }
            if (r11 == 0) goto L_0x00ec
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r12 = r11.getNetPermanceMonitor()     // Catch:{ all -> 0x00ff }
            if (r12 == 0) goto L_0x00ec
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r12 = r11.getNetPermanceMonitor()     // Catch:{ all -> 0x00ff }
            java.lang.String r13 = r11.dataId     // Catch:{ all -> 0x00ff }
            r12.setDataId(r13)     // Catch:{ all -> 0x00ff }
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r12 = r11.getNetPermanceMonitor()     // Catch:{ all -> 0x00ff }
            r12.setMsgType(r5)     // Catch:{ all -> 0x00ff }
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r12 = r11.getNetPermanceMonitor()     // Catch:{ all -> 0x00ff }
            java.net.URL r13 = r11.host     // Catch:{ all -> 0x00ff }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00ff }
            r12.setHost(r13)     // Catch:{ all -> 0x00ff }
        L_0x00ec:
            r9.a((android.content.Context) r10, (com.taobao.accs.data.Message) r11, (int) r5, (boolean) r0)     // Catch:{ all -> 0x00ff }
            goto L_0x00f9
        L_0x00f0:
            java.lang.String r10 = f13004c     // Catch:{ all -> 0x00ff }
            java.lang.String r11 = "bindApp only allow in main process"
            java.lang.Object[] r12 = new java.lang.Object[r3]     // Catch:{ all -> 0x00ff }
            com.taobao.accs.utl.ALog.w(r10, r11, r12)     // Catch:{ all -> 0x00ff }
        L_0x00f9:
            com.taobao.accs.c r10 = r9.f13007d     // Catch:{ all -> 0x00ff }
            r10.b()     // Catch:{ all -> 0x00ff }
            goto L_0x0109
        L_0x00ff:
            r10 = move-exception
            java.lang.String r11 = f13004c
            java.lang.String r12 = "bindApp exception"
            java.lang.Object[] r13 = new java.lang.Object[r3]
            com.taobao.accs.utl.ALog.e(r11, r12, r10, r13)
        L_0x0109:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.ACCSManagerImpl.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.taobao.accs.IAppReceiver):void");
    }

    public void d(Context context, String str) {
        GlobalClientInfo.getInstance(context).unRegisterService(str);
    }

    public void c(Context context) {
        UtilityImpl.focusDisableService(context);
    }

    public Map<String, Boolean> c() {
        SessionCenter.getInstance(this.f13007d.c()).forceRecreateAccsSession();
        return b();
    }

    public String b(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return b(context, str, str2, bArr, str3, str4, (URL) null);
    }

    public String b(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        Context context2 = context;
        return b(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, (String) null));
    }

    public String b(Context context, ACCSManager.AccsRequest accsRequest) {
        return a(context, accsRequest, (String) null, true);
    }

    public boolean b(Context context) {
        return UtilityImpl.i(context);
    }

    private Intent b(Context context, int i10) {
        if (i10 == 1 || !UtilityImpl.d(context)) {
            Intent intent = new Intent();
            intent.setAction(Constants.ACTION_COMMAND);
            intent.setClassName(context.getPackageName(), j.channelService);
            intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
            intent.putExtra("command", i10);
            intent.putExtra(Constants.KEY_APP_KEY, this.f13007d.c());
            intent.putExtra(Constants.KEY_CONFIG_TAG, this.f13006b);
            return intent;
        }
        ALog.e(f13004c, "getIntent null command:" + i10 + " accs enabled:" + UtilityImpl.d(context), new Object[0]);
        return null;
    }

    public Map<String, Boolean> b() {
        String b10 = this.f13007d.b((String) null);
        HashMap hashMap = new HashMap();
        hashMap.put(b10, Boolean.FALSE);
        if (SessionCenter.getInstance(this.f13007d.c()).getThrowsException(b10, 60000) != null) {
            hashMap.put(b10, Boolean.TRUE);
        }
        String str = f13004c;
        ALog.d(str, "getChannelState " + hashMap.toString(), new Object[0]);
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r8, com.taobao.accs.data.Message r9, int r10, boolean r11) {
        /*
            r7 = this;
            com.taobao.accs.c r0 = r7.f13007d
            r0.a()
            r0 = 0
            if (r9 != 0) goto L_0x0021
            java.lang.String r9 = f13004c
            java.lang.String r11 = "message is null"
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.taobao.accs.utl.ALog.e(r9, r11, r0)
            java.lang.String r8 = r8.getPackageName()
            com.taobao.accs.data.Message r8 = com.taobao.accs.data.Message.buildParameterError(r8, r10)
            com.taobao.accs.c r9 = r7.f13007d
            r10 = -2
            r9.a((com.taobao.accs.data.Message) r8, (int) r10)
            goto L_0x00e1
        L_0x0021:
            r8 = 200(0xc8, float:2.8E-43)
            r1 = 2
            r2 = 1
            if (r10 == r2) goto L_0x00a3
            if (r10 == r1) goto L_0x0074
            r3 = 3
            if (r10 == r3) goto L_0x002e
            goto L_0x00c6
        L_0x002e:
            com.taobao.accs.c r3 = r7.f13007d
            java.lang.String r4 = r9.getPackageName()
            java.lang.String r5 = r9.userinfo
            boolean r3 = r3.a((java.lang.String) r4, (java.lang.String) r5)
            if (r3 == 0) goto L_0x00c6
            if (r11 != 0) goto L_0x00c6
            java.lang.String r3 = f13004c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r9.getPackageName()
            r4.append(r5)
            java.lang.String r5 = "/"
            r4.append(r5)
            java.lang.String r5 = r9.userinfo
            r4.append(r5)
            java.lang.String r5 = " isUserBinded"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.String r6 = "isForceBind"
            r5[r0] = r6
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            r5[r2] = r11
            com.taobao.accs.utl.ALog.i(r3, r4, r5)
            com.taobao.accs.c r11 = r7.f13007d
            r11.a((com.taobao.accs.data.Message) r9, (int) r8)
            goto L_0x00a1
        L_0x0074:
            com.taobao.accs.c r11 = r7.f13007d
            java.lang.String r3 = r9.getPackageName()
            boolean r11 = r11.f(r3)
            if (r11 == 0) goto L_0x00c6
            java.lang.String r11 = f13004c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r9.getPackageName()
            r3.append(r4)
            java.lang.String r4 = " isAppUnbinded"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r4 = new java.lang.Object[r0]
            com.taobao.accs.utl.ALog.i(r11, r3, r4)
            com.taobao.accs.c r11 = r7.f13007d
            r11.a((com.taobao.accs.data.Message) r9, (int) r8)
        L_0x00a1:
            r8 = 0
            goto L_0x00c7
        L_0x00a3:
            java.lang.String r3 = r9.getPackageName()
            com.taobao.accs.c r4 = r7.f13007d
            boolean r4 = r4.e(r3)
            if (r4 == 0) goto L_0x00c6
            if (r11 != 0) goto L_0x00c6
            java.lang.String r11 = f13004c
            java.lang.Object[] r4 = new java.lang.Object[r1]
            java.lang.String r5 = "package"
            r4[r0] = r5
            r4[r2] = r3
            java.lang.String r3 = "isAppBinded"
            com.taobao.accs.utl.ALog.i(r11, r3, r4)
            com.taobao.accs.c r11 = r7.f13007d
            r11.a((com.taobao.accs.data.Message) r9, (int) r8)
            goto L_0x00a1
        L_0x00c6:
            r8 = 1
        L_0x00c7:
            if (r8 == 0) goto L_0x00e1
            java.lang.String r8 = f13004c
            java.lang.Object[] r11 = new java.lang.Object[r1]
            java.lang.String r1 = "command"
            r11[r0] = r1
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r11[r2] = r10
            java.lang.String r10 = "sendControlMessage"
            com.taobao.accs.utl.ALog.i(r8, r10, r11)
            com.taobao.accs.c r8 = r7.f13007d
            r8.a((com.taobao.accs.data.Message) r9, (boolean) r2)
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.ACCSManagerImpl.a(android.content.Context, com.taobao.accs.data.Message, int, boolean):void");
    }

    public void b(AccsConnectStateListener accsConnectStateListener) {
        if (accsConnectStateListener != null) {
            this.f13007d.b(accsConnectStateListener);
        }
    }

    public void a(Context context, String str) {
        a(context, str, false);
    }

    public void a(Context context, String str, boolean z10) {
        try {
            ALog.i(f13004c, "bindUser", "userId", str);
            if (UtilityImpl.d(context)) {
                ALog.e(f13004c, "accs disabled", new Object[0]);
                return;
            }
            Intent b10 = b(context, 3);
            if (b10 == null) {
                ALog.e(f13004c, "intent null", new Object[0]);
                a(context, 3, (String) null, (String) null);
                return;
            }
            String c10 = this.f13007d.c();
            if (TextUtils.isEmpty(c10)) {
                ALog.e(f13004c, "appKey null", new Object[0]);
                return;
            }
            if (UtilityImpl.c(context) || z10) {
                ALog.i(f13004c, "force bind User", new Object[0]);
                b10.putExtra(Constants.KEY_FOUCE_BIND, true);
                z10 = true;
            }
            b10.putExtra(Constants.KEY_APP_KEY, c10);
            b10.putExtra(Constants.KEY_USER_ID, str);
            if (UtilityImpl.isMainProcess(context)) {
                Message buildBindUser = Message.buildBindUser(this.f13007d.b((String) null), this.f13006b, b10);
                if (!(buildBindUser == null || buildBindUser.getNetPermanceMonitor() == null)) {
                    buildBindUser.getNetPermanceMonitor().setDataId(buildBindUser.dataId);
                    buildBindUser.getNetPermanceMonitor().setMsgType(2);
                    buildBindUser.getNetPermanceMonitor().setHost(buildBindUser.host.toString());
                }
                a(context, buildBindUser, 3, z10);
            }
            this.f13007d.b();
        } catch (Throwable th) {
            ALog.e(f13004c, "bindUser", th, new Object[0]);
        }
    }

    public void a(Context context) {
        if (!UtilityImpl.d(context) && !UtilityImpl.d(context)) {
            Intent b10 = b(context, 4);
            if (b10 == null) {
                a(context, 4, (String) null, (String) null);
                return;
            }
            String c10 = this.f13007d.c();
            if (!TextUtils.isEmpty(c10)) {
                b10.putExtra(Constants.KEY_APP_KEY, c10);
                if (UtilityImpl.isMainProcess(context)) {
                    a(context, Message.buildUnbindUser(this.f13007d.b((String) null), this.f13006b, b10), 4, false);
                }
            }
        }
    }

    public String a(Context context, String str, String str2, byte[] bArr, String str3) {
        return a(context, str, str2, bArr, str3, (String) null);
    }

    public String a(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return a(context, str, str2, bArr, str3, str4, (URL) null);
    }

    public String a(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        Context context2 = context;
        return a(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, (String) null));
    }

    public String a(Context context, ACCSManager.AccsRequest accsRequest) {
        ACCSManager.AccsRequest accsRequest2 = accsRequest;
        try {
            boolean d10 = UtilityImpl.d(context);
            if (!UtilityImpl.isMainProcess(context)) {
                ALog.e(f13004c, "sendData not in mainprocess", new Object[0]);
                return null;
            }
            if (!d10) {
                if (accsRequest2 != null) {
                    if (TextUtils.isEmpty(this.f13007d.c())) {
                        k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest2.serviceId, "1", "data appkey null");
                        ALog.e(f13004c, "sendData appkey null", new Object[0]);
                        return null;
                    }
                    this.f13007d.a();
                    Message buildSendData = Message.buildSendData(this.f13007d.b((String) null), this.f13006b, this.f13007d.e(), context, context.getPackageName(), accsRequest);
                    if (!(buildSendData == null || buildSendData.getNetPermanceMonitor() == null)) {
                        buildSendData.getNetPermanceMonitor().onSend();
                    }
                    if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(buildSendData.serviceId)) {
                        ALog.e(f13004c, "sendMessage", Constants.KEY_DATA_ID, buildSendData.getDataId());
                    }
                    this.f13007d.a(buildSendData, true);
                    return accsRequest2.dataId;
                }
            }
            if (d10) {
                k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest2.serviceId, "1", "accs disable");
            } else {
                k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", "data null");
            }
            String str = f13004c;
            ALog.e(str, "sendData dataInfo null or disable:" + d10, new Object[0]);
            return null;
        } catch (Throwable th) {
            String str2 = accsRequest2.serviceId;
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str2, "1", "data " + th.toString());
            ALog.e(f13004c, "sendData", th, "dataid", accsRequest2.dataId);
        }
    }

    public String a(Context context, ACCSManager.AccsRequest accsRequest, String str, boolean z10) {
        ACCSManager.AccsRequest accsRequest2 = accsRequest;
        if (accsRequest2 == null) {
            try {
                ALog.e(f13004c, "sendRequest request null", new Object[0]);
                k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, (String) null, "1", "request null");
                return null;
            } catch (Throwable th) {
                if (accsRequest2 != null) {
                    String str2 = accsRequest2.serviceId;
                    k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str2, "1", "request " + th.toString());
                    ALog.e(f13004c, "sendRequest", th, Constants.KEY_DATA_ID, accsRequest2.dataId);
                }
            }
        } else if (!UtilityImpl.isMainProcess(context)) {
            ALog.e(f13004c, "sendRequest not in mainprocess", new Object[0]);
            return null;
        } else if (UtilityImpl.d(context)) {
            ALog.e(f13004c, "sendRequest disable", new Object[0]);
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest2.serviceId, "1", "accs disable");
            return null;
        } else if (TextUtils.isEmpty(this.f13007d.c())) {
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest2.serviceId, "1", "request appkey null");
            ALog.e(f13004c, "sendRequest appkey null", new Object[0]);
            return null;
        } else {
            this.f13007d.a();
            Message buildRequest = Message.buildRequest(context, this.f13007d.b((String) null), this.f13006b, "", str == null ? context.getPackageName() : str, Constants.TARGET_SERVICE_PRE, accsRequest, z10);
            if (!(buildRequest == null || buildRequest.getNetPermanceMonitor() == null)) {
                buildRequest.getNetPermanceMonitor().onSend();
            }
            this.f13007d.a(buildRequest, true);
            return accsRequest2.dataId;
        }
    }

    public String a(Context context, ACCSManager.AccsRequest accsRequest, TaoBaseService.ExtraInfo extraInfo) {
        if (context == null || accsRequest == null) {
            ALog.e(f13004c, "sendPushResponse input null", f.X, context, "response", accsRequest, "extraInfo", extraInfo);
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", "sendPushResponse null");
            return null;
        }
        try {
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "push response total");
            if (UtilityImpl.d(context)) {
                k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "sendPushResponse accs disable");
                return null;
            }
            String c10 = this.f13007d.c();
            if (TextUtils.isEmpty(c10)) {
                k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "sendPushResponse appkey null");
                ALog.e(f13004c, "sendPushResponse appkey null", new Object[0]);
                return null;
            }
            if (extraInfo == null) {
                extraInfo = new TaoBaseService.ExtraInfo();
            }
            extraInfo.connType = 1;
            extraInfo.fromHost = "https://" + AccsClientConfig.getConfigByTag(Config.c(context)).getInappHost();
            extraInfo.fromPackage = context.getPackageName();
            ALog.i(f13004c, "sendPushResponse", "isMainProcess", Boolean.valueOf(UtilityImpl.isMainProcess(context)));
            accsRequest.host = new URL(extraInfo.fromHost);
            if (UtilityImpl.isMainProcess(context)) {
                a(context, accsRequest, context.getPackageName(), false);
            } else {
                Intent intent = new Intent(Constants.ACTION_SEND);
                intent.setClassName(extraInfo.fromPackage, j.msgService);
                intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
                intent.putExtra(Constants.KEY_SEND_REQDATA, accsRequest);
                intent.putExtra(Constants.KEY_APP_KEY, c10);
                intent.putExtra(Constants.KEY_CONFIG_TAG, this.f13006b);
                a.a(context, intent);
            }
            return null;
        } catch (Throwable th) {
            String str = accsRequest.serviceId;
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", "push response " + th.toString());
            String str2 = f13004c;
            ALog.e(str2, "sendPushResponse dataid:" + accsRequest.dataId, th, new Object[0]);
        }
    }

    public boolean a() {
        try {
            c cVar = this.f13007d;
            return cVar != null && cVar.f();
        } catch (Exception unused) {
            return false;
        }
    }

    @Deprecated
    public void a(Context context, int i10) {
        ACCSClient.setEnvironment(context, i10);
    }

    private void a(Context context, int i10, String str, String str2) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("command", i10);
        intent.putExtra(Constants.KEY_SERVICE_ID, str);
        intent.putExtra(Constants.KEY_DATA_ID, str2);
        intent.putExtra(Constants.KEY_APP_KEY, this.f13007d.c());
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.f13006b);
        intent.putExtra("errorCode", i10 == 2 ? 200 : 300);
        g.a(context, intent);
    }

    public void a(Context context, String str, int i10) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        if (!TextUtils.isEmpty(str)) {
            edit.putString(Constants.KEY_PROXY_HOST, str);
        }
        edit.putInt(Constants.KEY_PROXY_PORT, i10);
        edit.apply();
    }

    public void a(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        GlobalClientInfo.getInstance(context).setAppReceiver(this.f13006b, iAppReceiver);
        if (!UtilityImpl.isMainProcess(context)) {
            ALog.d(f13004c, "inapp only init in main process!", new Object[0]);
            return;
        }
        String str3 = f13004c;
        ALog.d(str3, "startInAppConnection APPKEY:" + str, new Object[0]);
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.equals(this.f13007d.c(), str)) {
                this.f13007d.c(str2);
                this.f13007d.d(str);
            }
            this.f13007d.a();
        }
    }

    public void a(Context context, ILoginInfo iLoginInfo) {
        GlobalClientInfo.getInstance(context).setLoginInfoImpl(this.f13006b, iLoginInfo);
    }

    public boolean a(String str) {
        return this.f13007d.a(str);
    }

    public boolean a(int i10) {
        return ErrorCode.isChannelError(i10);
    }

    public void a(Context context, String str, String str2) {
        GlobalClientInfo.getInstance(context).registerService(str, str2);
    }

    public void a(Context context, String str, AccsAbstractDataListener accsAbstractDataListener) {
        GlobalClientInfo.getInstance(context).registerListener(str, accsAbstractDataListener);
    }

    public void a(AccsConnectStateListener accsConnectStateListener) {
        if (accsConnectStateListener != null) {
            this.f13007d.a(accsConnectStateListener);
        }
    }

    public void a(String str, String str2, String str3, short s10, String str4, Map<Integer, String> map) {
        this.f13007d.a(Message.buildPushAck(this.f13007d.b((String) null), this.f13006b, str, str2, str3, true, s10, str4, map), true);
    }

    public void a(AccsClientConfig accsClientConfig) {
        this.f13007d.a(accsClientConfig);
    }

    /* access modifiers changed from: private */
    public void a(c cVar) {
        ThreadPoolExecutorFactory.schedule(new b(this, cVar), (long) this.f13008e.nextInt(6), TimeUnit.SECONDS);
    }
}
