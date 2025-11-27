package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.a.a.a;
import com.taobao.agoo.a.a.d;
import com.taobao.agoo.a.b;
import com.umeng.analytics.pro.f;
import org.android.agoo.common.CallBack;
import org.android.agoo.common.Config;
import org.android.agoo.control.NotifManager;

public final class TaobaoRegister {
    private static final int EVENT_ID = 66001;
    static final String PREFERENCES = "Agoo_AppStore";
    static final String PROPERTY_APP_NOTIFICATION_CUSTOM_SOUND = "app_notification_custom_sound";
    static final String PROPERTY_APP_NOTIFICATION_ICON = "app_notification_icon";
    static final String PROPERTY_APP_NOTIFICATION_SOUND = "app_notification_sound";
    static final String PROPERTY_APP_NOTIFICATION_VIBRATE = "app_notification_vibrate";
    private static final String SERVICEID = "agooSend";
    protected static final String TAG = "TaobaoRegister";
    /* access modifiers changed from: private */
    public static boolean isRegisterSuccess;
    /* access modifiers changed from: private */
    public static b mRequestListener;

    private TaobaoRegister() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static void bindAgoo(Context context, String str, String str2, CallBack callBack) {
        bindAgoo(context, (ICallback) null);
    }

    public static void clickMessage(Context context, String str, String str2) {
        clickMessage(context, str, str2, 0, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: org.android.agoo.common.MsgDO} */
    /* JADX WARNING: type inference failed for: r4v0, types: [org.android.agoo.message.MessageService] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0075 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void dismissMessage(android.content.Context r9, java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "9"
            java.lang.String r1 = "TaobaoRegister"
            org.android.agoo.control.NotifManager r2 = new org.android.agoo.control.NotifManager
            r2.<init>()
            r3 = 0
            r4 = 0
            com.taobao.accs.utl.ALog$Level r5 = com.taobao.accs.utl.ALog.Level.I     // Catch:{ all -> 0x005c }
            boolean r5 = com.taobao.accs.utl.ALog.isPrintLog(r5)     // Catch:{ all -> 0x005c }
            if (r5 == 0) goto L_0x002a
            java.lang.String r5 = "dismissMessage"
            r6 = 4
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x005c }
            java.lang.String r7 = "msgid"
            r6[r3] = r7     // Catch:{ all -> 0x005c }
            r7 = 1
            r6[r7] = r10     // Catch:{ all -> 0x005c }
            java.lang.String r7 = "extData"
            r8 = 2
            r6[r8] = r7     // Catch:{ all -> 0x005c }
            r7 = 3
            r6[r7] = r11     // Catch:{ all -> 0x005c }
            com.taobao.accs.utl.ALog.i(r1, r5, r6)     // Catch:{ all -> 0x005c }
        L_0x002a:
            java.lang.String r5 = "accs"
            boolean r6 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x005c }
            if (r6 == 0) goto L_0x003a
            java.lang.String r9 = "messageId == null"
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ all -> 0x005c }
            com.taobao.accs.utl.ALog.d(r1, r9, r10)     // Catch:{ all -> 0x005c }
            return
        L_0x003a:
            r2.init(r9)     // Catch:{ all -> 0x005c }
            org.android.agoo.common.MsgDO r6 = new org.android.agoo.common.MsgDO     // Catch:{ all -> 0x005c }
            r6.<init>()     // Catch:{ all -> 0x005c }
            r6.msgIds = r10     // Catch:{ all -> 0x0059 }
            r6.extData = r11     // Catch:{ all -> 0x0059 }
            r6.messageSource = r5     // Catch:{ all -> 0x0059 }
            r6.msgStatus = r0     // Catch:{ all -> 0x0059 }
            org.android.agoo.control.AgooFactory r11 = new org.android.agoo.control.AgooFactory     // Catch:{ all -> 0x0059 }
            r11.<init>()     // Catch:{ all -> 0x0059 }
            r11.init(r9, r2, r4)     // Catch:{ all -> 0x0059 }
            r11.updateMsgStatus(r10, r0)     // Catch:{ all -> 0x0059 }
            r2.reportNotifyMessage(r6)
            goto L_0x0078
        L_0x0059:
            r9 = move-exception
            r4 = r6
            goto L_0x005d
        L_0x005c:
            r9 = move-exception
        L_0x005d:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r10.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r11 = "dismissMessage,error="
            r10.append(r11)     // Catch:{ all -> 0x0079 }
            r10.append(r9)     // Catch:{ all -> 0x0079 }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x0079 }
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ all -> 0x0079 }
            com.taobao.accs.utl.ALog.e(r1, r9, r10)     // Catch:{ all -> 0x0079 }
            if (r4 == 0) goto L_0x0078
            r2.reportNotifyMessage(r4)
        L_0x0078:
            return
        L_0x0079:
            r9 = move-exception
            if (r4 == 0) goto L_0x007f
            r2.reportNotifyMessage(r4)
        L_0x007f:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.dismissMessage(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: org.android.agoo.common.MsgDO} */
    /* JADX WARNING: type inference failed for: r3v0, types: [org.android.agoo.message.MessageService] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0072 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void exposureMessage(android.content.Context r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "TaobaoRegister"
            org.android.agoo.control.NotifManager r1 = new org.android.agoo.control.NotifManager
            r1.<init>()
            r2 = 0
            r3 = 0
            com.taobao.accs.utl.ALog$Level r4 = com.taobao.accs.utl.ALog.Level.I     // Catch:{ all -> 0x0059 }
            boolean r4 = com.taobao.accs.utl.ALog.isPrintLog(r4)     // Catch:{ all -> 0x0059 }
            if (r4 == 0) goto L_0x0028
            java.lang.String r4 = "exposureMessage"
            r5 = 4
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0059 }
            java.lang.String r6 = "msgid"
            r5[r2] = r6     // Catch:{ all -> 0x0059 }
            r6 = 1
            r5[r6] = r9     // Catch:{ all -> 0x0059 }
            java.lang.String r6 = "extData"
            r7 = 2
            r5[r7] = r6     // Catch:{ all -> 0x0059 }
            r6 = 3
            r5[r6] = r10     // Catch:{ all -> 0x0059 }
            com.taobao.accs.utl.ALog.i(r0, r4, r5)     // Catch:{ all -> 0x0059 }
        L_0x0028:
            java.lang.String r4 = "accs"
            java.lang.String r5 = "10"
            boolean r6 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0059 }
            if (r6 == 0) goto L_0x003a
            java.lang.String r8 = "messageId == null"
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ all -> 0x0059 }
            com.taobao.accs.utl.ALog.d(r0, r8, r9)     // Catch:{ all -> 0x0059 }
            return
        L_0x003a:
            r1.init(r8)     // Catch:{ all -> 0x0059 }
            org.android.agoo.common.MsgDO r6 = new org.android.agoo.common.MsgDO     // Catch:{ all -> 0x0059 }
            r6.<init>()     // Catch:{ all -> 0x0059 }
            r6.msgIds = r9     // Catch:{ all -> 0x0056 }
            r6.extData = r10     // Catch:{ all -> 0x0056 }
            r6.messageSource = r4     // Catch:{ all -> 0x0056 }
            r6.msgStatus = r5     // Catch:{ all -> 0x0056 }
            org.android.agoo.control.AgooFactory r9 = new org.android.agoo.control.AgooFactory     // Catch:{ all -> 0x0056 }
            r9.<init>()     // Catch:{ all -> 0x0056 }
            r9.init(r8, r1, r3)     // Catch:{ all -> 0x0056 }
            r1.reportNotifyMessage(r6)
            goto L_0x0075
        L_0x0056:
            r8 = move-exception
            r3 = r6
            goto L_0x005a
        L_0x0059:
            r8 = move-exception
        L_0x005a:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r9.<init>()     // Catch:{ all -> 0x0076 }
            java.lang.String r10 = "exposureMessage,error="
            r9.append(r10)     // Catch:{ all -> 0x0076 }
            r9.append(r8)     // Catch:{ all -> 0x0076 }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x0076 }
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ all -> 0x0076 }
            com.taobao.accs.utl.ALog.e(r0, r8, r9)     // Catch:{ all -> 0x0076 }
            if (r3 == 0) goto L_0x0075
            r1.reportNotifyMessage(r3)
        L_0x0075:
            return
        L_0x0076:
            r8 = move-exception
            if (r3 == 0) goto L_0x007c
            r1.reportNotifyMessage(r3)
        L_0x007c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.exposureMessage(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static boolean isRegisterSuccess() {
        return isRegisterSuccess;
    }

    public static void pingApp(Context context, String str, String str2, String str3, int i10) {
        NotifManager notifManager = new NotifManager();
        notifManager.init(context);
        notifManager.pingApp(str, str2, str3, i10);
    }

    @Deprecated
    public static synchronized void register(Context context, String str, String str2, String str3, IRegister iRegister) {
        synchronized (TaobaoRegister.class) {
            register(context, AccsClientConfig.DEFAULT_CONFIGTAG, str, str2, str3, iRegister);
        }
    }

    public static synchronized void removeAlias(Context context, String str, ICallback iCallback) {
        synchronized (TaobaoRegister.class) {
            ALog.i(TAG, a.JSON_CMD_REMOVEALIAS, new Object[0]);
            try {
                String g10 = Config.g(context);
                String a10 = Config.a(context);
                if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(g10) && context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, a10, Config.c(context));
                        if (mRequestListener == null) {
                            mRequestListener = new b(context.getApplicationContext());
                        }
                        GlobalClientInfo.getInstance(context).registerListener("AgooDeviceCmd", (AccsDataListener) mRequestListener);
                        String b10 = accsInstance.b(context, new ACCSManager.AccsRequest((String) null, "AgooDeviceCmd", a.c(a10, g10, str), (String) null));
                        if (TextUtils.isEmpty(b10)) {
                            if (iCallback != null) {
                                iCallback.onFailure("504.1", "accs channel disabled!");
                            }
                        } else if (iCallback != null) {
                            mRequestListener.f13286a.put(b10, iCallback);
                        }
                    }
                }
                if (iCallback != null) {
                    iCallback.onFailure("504.1", "input params null!!");
                }
                ALog.e(TAG, "setAlias param null", "appkey", a10, "deviceId", g10, "alias", str, f.X, context);
                return;
            } catch (Throwable th) {
                ALog.e(TAG, a.JSON_CMD_REMOVEALIAS, th, new Object[0]);
            }
        }
        return;
    }

    public static void removeAllAlias(Context context, ICallback iCallback) {
        ALog.i(TAG, "removeAllAlias", new Object[0]);
        try {
            String g10 = Config.g(context);
            String a10 = Config.a(context);
            if (!TextUtils.isEmpty(a10)) {
                if (!TextUtils.isEmpty(g10)) {
                    if (context != null) {
                        com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, a10, Config.c(context));
                        if (mRequestListener == null) {
                            mRequestListener = new b(context.getApplicationContext());
                        }
                        GlobalClientInfo.getInstance(context).registerListener("AgooDeviceCmd", (AccsDataListener) mRequestListener);
                        String b10 = accsInstance.b(context, new ACCSManager.AccsRequest((String) null, "AgooDeviceCmd", a.a(a10, g10), (String) null));
                        if (TextUtils.isEmpty(b10)) {
                            if (iCallback != null) {
                                iCallback.onFailure("504.1", "accs channel disabled!");
                                return;
                            }
                            return;
                        } else if (iCallback != null) {
                            mRequestListener.f13286a.put(b10, iCallback);
                            return;
                        } else {
                            return;
                        }
                    }
                }
            }
            if (iCallback != null) {
                iCallback.onFailure("504.1", "input params null!!");
            }
            ALog.e(TAG, "setAlias param null", "appkey", a10, "deviceId", g10, f.X, context);
        } catch (Throwable th) {
            ALog.e(TAG, "removeAllAlias", th, new Object[0]);
        }
    }

    private static synchronized void sendSwitch(Context context, ICallback iCallback, boolean z10) {
        synchronized (TaobaoRegister.class) {
            try {
                String g10 = Config.g(context);
                String a10 = Config.a(context);
                String j10 = UtilityImpl.j(context);
                if (!TextUtils.isEmpty(a10) && context != null) {
                    if (!TextUtils.isEmpty(g10) || !TextUtils.isEmpty(j10)) {
                        com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, a10, Config.c(context));
                        if (mRequestListener == null) {
                            mRequestListener = new b(context.getApplicationContext());
                        }
                        GlobalClientInfo.getInstance(context).registerListener("AgooDeviceCmd", (AccsDataListener) mRequestListener);
                        String b10 = accsInstance.b(context, new ACCSManager.AccsRequest((String) null, "AgooDeviceCmd", d.a(a10, g10, j10, z10), (String) null));
                        if (TextUtils.isEmpty(b10)) {
                            if (iCallback != null) {
                                iCallback.onFailure("503.2", "accs channel disabled!");
                            }
                        } else if (iCallback != null) {
                            mRequestListener.f13286a.put(b10, iCallback);
                        }
                    }
                }
                if (iCallback != null) {
                    iCallback.onFailure("503.3", "input params null!!");
                }
                ALog.e(TAG, "sendSwitch param null", "appkey", a10, "deviceId", g10, f.X, context, d.JSON_CMD_ENABLEPUSH, Boolean.valueOf(z10));
                return;
            } catch (Throwable th) {
                ALog.e(TAG, "sendSwitch", th, new Object[0]);
            }
        }
        return;
    }

    @Deprecated
    public static synchronized void setAccsConfigTag(Context context, String str) {
        synchronized (TaobaoRegister.class) {
        }
    }

    public static void setAgooMsgReceiveService(String str) {
        com.taobao.accs.client.a.f12913a = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void setAlias(android.content.Context r9, java.lang.String r10, com.taobao.agoo.ICallback r11) {
        /*
            java.lang.Class<com.taobao.agoo.TaobaoRegister> r0 = com.taobao.agoo.TaobaoRegister.class
            monitor-enter(r0)
            java.lang.String r1 = "TaobaoRegister"
            java.lang.String r2 = "setAlias"
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x00f4 }
            java.lang.String r5 = "alias"
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x00f4 }
            r5 = 1
            r4[r5] = r10     // Catch:{ all -> 0x00f4 }
            com.taobao.accs.utl.ALog.i(r1, r2, r4)     // Catch:{ all -> 0x00f4 }
            java.lang.String r1 = org.android.agoo.common.Config.g(r9)     // Catch:{ all -> 0x00f4 }
            java.lang.String r2 = org.android.agoo.common.Config.a(r9)     // Catch:{ all -> 0x00f4 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00f4 }
            if (r4 != 0) goto L_0x00c1
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00f4 }
            if (r4 != 0) goto L_0x00c1
            if (r9 == 0) goto L_0x00c1
            boolean r4 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x00f4 }
            if (r4 == 0) goto L_0x0033
            goto L_0x00c1
        L_0x0033:
            com.taobao.agoo.a.b r4 = mRequestListener     // Catch:{ all -> 0x00b5 }
            if (r4 != 0) goto L_0x0042
            com.taobao.agoo.a.b r4 = new com.taobao.agoo.a.b     // Catch:{ all -> 0x00b5 }
            android.content.Context r7 = r9.getApplicationContext()     // Catch:{ all -> 0x00b5 }
            r4.<init>(r7)     // Catch:{ all -> 0x00b5 }
            mRequestListener = r4     // Catch:{ all -> 0x00b5 }
        L_0x0042:
            com.taobao.agoo.a.a r4 = com.taobao.agoo.a.b.f13285b     // Catch:{ all -> 0x00b5 }
            boolean r4 = r4.d(r10)     // Catch:{ all -> 0x00b5 }
            if (r4 == 0) goto L_0x0060
            java.lang.String r9 = "TaobaoRegister"
            java.lang.String r1 = "setAlias already set"
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x00b5 }
            java.lang.String r3 = "alias"
            r2[r6] = r3     // Catch:{ all -> 0x00b5 }
            r2[r5] = r10     // Catch:{ all -> 0x00b5 }
            com.taobao.accs.utl.ALog.i(r9, r1, r2)     // Catch:{ all -> 0x00b5 }
            if (r11 == 0) goto L_0x005e
            r11.onSuccess()     // Catch:{ all -> 0x00b5 }
        L_0x005e:
            monitor-exit(r0)
            return
        L_0x0060:
            java.lang.String r3 = org.android.agoo.common.Config.c(r9)     // Catch:{ all -> 0x00b5 }
            com.taobao.accs.b r3 = com.taobao.accs.ACCSManager.getAccsInstance(r9, r2, r3)     // Catch:{ all -> 0x00b5 }
            com.taobao.agoo.a.a r4 = com.taobao.agoo.a.b.f13285b     // Catch:{ all -> 0x00b5 }
            java.lang.String r5 = r9.getPackageName()     // Catch:{ all -> 0x00b5 }
            boolean r4 = r4.b(r5)     // Catch:{ all -> 0x00b5 }
            if (r4 == 0) goto L_0x00ab
            com.taobao.accs.client.GlobalClientInfo r4 = com.taobao.accs.client.GlobalClientInfo.getInstance(r9)     // Catch:{ all -> 0x00b5 }
            java.lang.String r5 = "AgooDeviceCmd"
            com.taobao.agoo.a.b r7 = mRequestListener     // Catch:{ all -> 0x00b5 }
            r4.registerListener((java.lang.String) r5, (com.taobao.accs.base.AccsDataListener) r7)     // Catch:{ all -> 0x00b5 }
            byte[] r1 = com.taobao.agoo.a.a.a.a(r2, r1, r10)     // Catch:{ all -> 0x00b5 }
            com.taobao.accs.ACCSManager$AccsRequest r2 = new com.taobao.accs.ACCSManager$AccsRequest     // Catch:{ all -> 0x00b5 }
            java.lang.String r4 = "AgooDeviceCmd"
            r5 = 0
            r2.<init>(r5, r4, r1, r5)     // Catch:{ all -> 0x00b5 }
            java.lang.String r9 = r3.b((android.content.Context) r9, (com.taobao.accs.ACCSManager.AccsRequest) r2)     // Catch:{ all -> 0x00b5 }
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x00b5 }
            if (r1 == 0) goto L_0x009f
            if (r11 == 0) goto L_0x00bf
            java.lang.String r9 = "504.1"
            java.lang.String r10 = "accs channel disabled!"
            r11.onFailure(r9, r10)     // Catch:{ all -> 0x00b5 }
            goto L_0x00bf
        L_0x009f:
            if (r11 == 0) goto L_0x00bf
            r11.extra = r10     // Catch:{ all -> 0x00b5 }
            com.taobao.agoo.a.b r10 = mRequestListener     // Catch:{ all -> 0x00b5 }
            java.util.Map<java.lang.String, com.taobao.agoo.ICallback> r10 = r10.f13286a     // Catch:{ all -> 0x00b5 }
            r10.put(r9, r11)     // Catch:{ all -> 0x00b5 }
            goto L_0x00bf
        L_0x00ab:
            if (r11 == 0) goto L_0x00bf
            java.lang.String r9 = "504.1"
            java.lang.String r10 = "bindApp first!!"
            r11.onFailure(r9, r10)     // Catch:{ all -> 0x00b5 }
            goto L_0x00bf
        L_0x00b5:
            r9 = move-exception
            java.lang.String r10 = "TaobaoRegister"
            java.lang.String r11 = "setAlias"
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ all -> 0x00f4 }
            com.taobao.accs.utl.ALog.e(r10, r11, r9, r1)     // Catch:{ all -> 0x00f4 }
        L_0x00bf:
            monitor-exit(r0)
            return
        L_0x00c1:
            if (r11 == 0) goto L_0x00ca
            java.lang.String r4 = "504.1"
            java.lang.String r7 = "input params null!!"
            r11.onFailure(r4, r7)     // Catch:{ all -> 0x00f4 }
        L_0x00ca:
            java.lang.String r11 = "TaobaoRegister"
            java.lang.String r4 = "setAlias param null"
            r7 = 8
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x00f4 }
            java.lang.String r8 = "appkey"
            r7[r6] = r8     // Catch:{ all -> 0x00f4 }
            r7[r5] = r2     // Catch:{ all -> 0x00f4 }
            java.lang.String r2 = "deviceId"
            r7[r3] = r2     // Catch:{ all -> 0x00f4 }
            r2 = 3
            r7[r2] = r1     // Catch:{ all -> 0x00f4 }
            java.lang.String r1 = "alias"
            r2 = 4
            r7[r2] = r1     // Catch:{ all -> 0x00f4 }
            r1 = 5
            r7[r1] = r10     // Catch:{ all -> 0x00f4 }
            java.lang.String r10 = "context"
            r1 = 6
            r7[r1] = r10     // Catch:{ all -> 0x00f4 }
            r10 = 7
            r7[r10] = r9     // Catch:{ all -> 0x00f4 }
            com.taobao.accs.utl.ALog.e(r11, r4, r7)     // Catch:{ all -> 0x00f4 }
            monitor-exit(r0)
            return
        L_0x00f4:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.setAlias(android.content.Context, java.lang.String, com.taobao.agoo.ICallback):void");
    }

    @Deprecated
    public static void setBuilderSound(Context context, String str) {
    }

    public static void setEnv(Context context, @AccsClientConfig.ENV int i10) {
        ACCSClient.setEnvironment(context, i10);
    }

    public static void setIsRegisterSuccess(boolean z10) {
        isRegisterSuccess = z10;
    }

    @Deprecated
    public static void setNotificationIcon(Context context, int i10) {
    }

    @Deprecated
    public static void setNotificationSound(Context context, boolean z10) {
    }

    @Deprecated
    public static void setNotificationVibrate(Context context, boolean z10) {
    }

    @Deprecated
    public static void unBindAgoo(Context context, String str, String str2, CallBack callBack) {
        unbindAgoo(context, (ICallback) null);
    }

    public static void unbindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, false);
        UTMini.getInstance().commitEvent(EVENT_ID, "unregister", UtilityImpl.j(context));
    }

    @Deprecated
    public static void unregister(Context context, CallBack callBack) {
        unbindAgoo(context, (ICallback) null);
    }

    public static void bindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, true);
        UTMini.getInstance().commitEvent(EVENT_ID, "bindAgoo", UtilityImpl.j(context));
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0102 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void clickMessage(android.content.Context r21, java.lang.String r22, java.lang.String r23, int r24, long r25) {
        /*
            r0 = r21
            r1 = r22
            r2 = r23
            java.lang.String r3 = "8"
            java.lang.String r4 = "TaobaoRegister"
            org.android.agoo.control.NotifManager r5 = new org.android.agoo.control.NotifManager
            r5.<init>()
            r6 = 0
            com.taobao.accs.utl.ALog$Level r8 = com.taobao.accs.utl.ALog.Level.I     // Catch:{ all -> 0x00e8 }
            boolean r8 = com.taobao.accs.utl.ALog.isPrintLog(r8)     // Catch:{ all -> 0x00e8 }
            java.lang.String r9 = "clickMessage"
            r10 = 3
            r11 = 2
            r12 = 4
            r13 = 1
            if (r8 == 0) goto L_0x002f
            java.lang.Object[] r8 = new java.lang.Object[r12]     // Catch:{ all -> 0x00e8 }
            java.lang.String r14 = "msgid"
            r8[r6] = r14     // Catch:{ all -> 0x00e8 }
            r8[r13] = r1     // Catch:{ all -> 0x00e8 }
            java.lang.String r14 = "extData"
            r8[r11] = r14     // Catch:{ all -> 0x00e8 }
            r8[r10] = r2     // Catch:{ all -> 0x00e8 }
            com.taobao.accs.utl.ALog.i(r4, r9, r8)     // Catch:{ all -> 0x00e8 }
        L_0x002f:
            java.lang.String r8 = "accs"
            boolean r14 = android.text.TextUtils.isEmpty(r22)     // Catch:{ all -> 0x00e8 }
            if (r14 == 0) goto L_0x003f
            java.lang.String r0 = "messageId == null"
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ all -> 0x00e8 }
            com.taobao.accs.utl.ALog.d(r4, r0, r1)     // Catch:{ all -> 0x00e8 }
            return
        L_0x003f:
            r5.init(r0)     // Catch:{ all -> 0x00e8 }
            org.android.agoo.common.MsgDO r14 = new org.android.agoo.common.MsgDO     // Catch:{ all -> 0x00e8 }
            r14.<init>()     // Catch:{ all -> 0x00e8 }
            r14.evokeAppStatus = r13     // Catch:{ all -> 0x00e5 }
            r15 = r24 & 1
            if (r15 != r13) goto L_0x004f
            r15 = 1
            goto L_0x0050
        L_0x004f:
            r15 = 0
        L_0x0050:
            r7 = r24 & 2
            if (r7 != r11) goto L_0x0056
            r7 = 1
            goto L_0x0057
        L_0x0056:
            r7 = 0
        L_0x0057:
            r10 = r24 & 4
            if (r10 != r12) goto L_0x005d
            r10 = 1
            goto L_0x005e
        L_0x005d:
            r10 = 0
        L_0x005e:
            r12 = 8
            r11 = r24 & 8
            if (r11 != r12) goto L_0x0066
            r11 = 1
            goto L_0x0067
        L_0x0066:
            r11 = 0
        L_0x0067:
            r12 = r15 ^ r7
            r14.isGlobalClick = r12     // Catch:{ all -> 0x00e5 }
            if (r12 == 0) goto L_0x00cd
            r12 = 10
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ all -> 0x00e5 }
            java.lang.String r20 = "isLaunchByAgoo"
            r12[r6] = r20     // Catch:{ all -> 0x00e5 }
            java.lang.Boolean r20 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x00e5 }
            r12[r13] = r20     // Catch:{ all -> 0x00e5 }
            java.lang.String r13 = "isEvokeByAgoo"
            r18 = 2
            r12[r18] = r13     // Catch:{ all -> 0x00e5 }
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r15)     // Catch:{ all -> 0x00e5 }
            r16 = 3
            r12[r16] = r13     // Catch:{ all -> 0x00e5 }
            java.lang.String r13 = "isComeFromBg"
            r17 = 4
            r12[r17] = r13     // Catch:{ all -> 0x00e5 }
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r10)     // Catch:{ all -> 0x00e5 }
            r20 = 5
            r12[r20] = r13     // Catch:{ all -> 0x00e5 }
            java.lang.String r13 = "isSameDay"
            r20 = 6
            r12[r20] = r13     // Catch:{ all -> 0x00e5 }
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r11)     // Catch:{ all -> 0x00e5 }
            r20 = 7
            r12[r20] = r13     // Catch:{ all -> 0x00e5 }
            java.lang.String r13 = "lastActiveTime"
            r19 = 8
            r12[r19] = r13     // Catch:{ all -> 0x00e5 }
            java.lang.Long r13 = java.lang.Long.valueOf(r25)     // Catch:{ all -> 0x00e5 }
            r19 = 9
            r12[r19] = r13     // Catch:{ all -> 0x00e5 }
            com.taobao.accs.utl.ALog.e(r4, r9, r12)     // Catch:{ all -> 0x00e5 }
            r12 = r25
            r14.lastActiveTime = r12     // Catch:{ all -> 0x00e5 }
            if (r15 == 0) goto L_0x00be
            if (r10 != 0) goto L_0x00c0
        L_0x00be:
            if (r7 == 0) goto L_0x00cd
        L_0x00c0:
            if (r11 == 0) goto L_0x00ca
            if (r7 == 0) goto L_0x00c6
            r10 = 2
            goto L_0x00c7
        L_0x00c6:
            r10 = 3
        L_0x00c7:
            r14.evokeAppStatus = r10     // Catch:{ all -> 0x00e5 }
            goto L_0x00cd
        L_0x00ca:
            r7 = 4
            r14.evokeAppStatus = r7     // Catch:{ all -> 0x00e5 }
        L_0x00cd:
            r14.msgIds = r1     // Catch:{ all -> 0x00e5 }
            r14.extData = r2     // Catch:{ all -> 0x00e5 }
            r14.messageSource = r8     // Catch:{ all -> 0x00e5 }
            r14.msgStatus = r3     // Catch:{ all -> 0x00e5 }
            org.android.agoo.control.AgooFactory r2 = new org.android.agoo.control.AgooFactory     // Catch:{ all -> 0x00e5 }
            r2.<init>()     // Catch:{ all -> 0x00e5 }
            r7 = 0
            r2.init(r0, r5, r7)     // Catch:{ all -> 0x00e5 }
            r2.updateMsgStatus(r1, r3)     // Catch:{ all -> 0x00e5 }
            r5.reportNotifyMessage(r14)
            goto L_0x0105
        L_0x00e5:
            r0 = move-exception
            r7 = r14
            goto L_0x00ea
        L_0x00e8:
            r0 = move-exception
            r7 = 0
        L_0x00ea:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r1.<init>()     // Catch:{ all -> 0x0106 }
            java.lang.String r2 = "clickMessage,error="
            r1.append(r2)     // Catch:{ all -> 0x0106 }
            r1.append(r0)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0106 }
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ all -> 0x0106 }
            com.taobao.accs.utl.ALog.e(r4, r0, r1)     // Catch:{ all -> 0x0106 }
            if (r7 == 0) goto L_0x0105
            r5.reportNotifyMessage(r7)
        L_0x0105:
            return
        L_0x0106:
            r0 = move-exception
            if (r7 == 0) goto L_0x010c
            r5.reportNotifyMessage(r7)
        L_0x010c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.clickMessage(android.content.Context, java.lang.String, java.lang.String, int, long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0072, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00af, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void register(android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, com.taobao.agoo.IRegister r19) {
        /*
            r0 = r14
            r1 = r15
            r8 = r16
            r9 = r17
            r4 = r19
            java.lang.Class<com.taobao.agoo.TaobaoRegister> r10 = com.taobao.agoo.TaobaoRegister.class
            monitor-enter(r10)
            r2 = 3
            r3 = 2
            r5 = 1
            r6 = 0
            r7 = 4
            if (r0 == 0) goto L_0x0090
            boolean r11 = android.text.TextUtils.isEmpty(r16)     // Catch:{ all -> 0x00b0 }
            if (r11 != 0) goto L_0x0090
            boolean r11 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x00b0 }
            if (r11 == 0) goto L_0x0020
            goto L_0x0090
        L_0x0020:
            java.lang.String r11 = "TaobaoRegister"
            java.lang.String r12 = "register"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x00b0 }
            java.lang.String r13 = "appKey"
            r7[r6] = r13     // Catch:{ all -> 0x00b0 }
            r7[r5] = r8     // Catch:{ all -> 0x00b0 }
            java.lang.String r5 = "configTag"
            r7[r3] = r5     // Catch:{ all -> 0x00b0 }
            r7[r2] = r1     // Catch:{ all -> 0x00b0 }
            com.taobao.accs.utl.ALog.i(r11, r12, r7)     // Catch:{ all -> 0x00b0 }
            android.content.Context r11 = r14.getApplicationContext()     // Catch:{ all -> 0x00b0 }
            org.android.agoo.common.Config.f8577a = r1     // Catch:{ all -> 0x00b0 }
            org.android.agoo.common.Config.setAgooAppKey(r14, r8)     // Catch:{ all -> 0x00b0 }
            org.android.agoo.common.Config.a((android.content.Context) r14, (java.lang.String) r9)     // Catch:{ all -> 0x00b0 }
            com.taobao.accs.AccsClientConfig r2 = com.taobao.accs.AccsClientConfig.getConfigByTag(r15)     // Catch:{ all -> 0x00b0 }
            if (r2 != 0) goto L_0x005c
            com.taobao.accs.AccsClientConfig$Builder r2 = new com.taobao.accs.AccsClientConfig$Builder     // Catch:{ all -> 0x00b0 }
            r2.<init>()     // Catch:{ all -> 0x00b0 }
            com.taobao.accs.AccsClientConfig$Builder r2 = r2.setAppKey(r8)     // Catch:{ all -> 0x00b0 }
            com.taobao.accs.AccsClientConfig$Builder r2 = r2.setAppSecret(r9)     // Catch:{ all -> 0x00b0 }
            com.taobao.accs.AccsClientConfig$Builder r2 = r2.setTag(r15)     // Catch:{ all -> 0x00b0 }
            r2.build()     // Catch:{ all -> 0x00b0 }
            goto L_0x0062
        L_0x005c:
            java.lang.String r2 = r2.getAuthCode()     // Catch:{ all -> 0x00b0 }
            com.taobao.accs.client.a.f12914b = r2     // Catch:{ all -> 0x00b0 }
        L_0x0062:
            com.taobao.accs.b r12 = com.taobao.accs.ACCSManager.getAccsInstance(r14, r8, r15)     // Catch:{ all -> 0x00b0 }
            if (r12 != 0) goto L_0x0073
            if (r4 == 0) goto L_0x0071
            java.lang.String r0 = "503.2"
            java.lang.String r1 = "ACCSManager null"
            r4.onFailure(r0, r1)     // Catch:{ all -> 0x00b0 }
        L_0x0071:
            monitor-exit(r10)
            return
        L_0x0073:
            com.taobao.agoo.g r13 = new com.taobao.agoo.g     // Catch:{ all -> 0x00b0 }
            r1 = r13
            r2 = r11
            r3 = r14
            r4 = r19
            r5 = r16
            r6 = r18
            r7 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00b0 }
            r0 = r12
            r1 = r11
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r13
            r0.a((android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (com.taobao.accs.IAppReceiver) r5)     // Catch:{ all -> 0x00b0 }
            monitor-exit(r10)
            return
        L_0x0090:
            java.lang.String r0 = "TaobaoRegister"
            java.lang.String r9 = "register params null"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x00b0 }
            java.lang.String r11 = "appkey"
            r7[r6] = r11     // Catch:{ all -> 0x00b0 }
            r7[r5] = r8     // Catch:{ all -> 0x00b0 }
            java.lang.String r5 = "configTag"
            r7[r3] = r5     // Catch:{ all -> 0x00b0 }
            r7[r2] = r1     // Catch:{ all -> 0x00b0 }
            com.taobao.accs.utl.ALog.e(r0, r9, r7)     // Catch:{ all -> 0x00b0 }
            if (r4 == 0) goto L_0x00ae
            java.lang.String r0 = "503.2"
            java.lang.String r1 = "params null"
            r4.onFailure(r0, r1)     // Catch:{ all -> 0x00b0 }
        L_0x00ae:
            monitor-exit(r10)
            return
        L_0x00b0:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.register(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.taobao.agoo.IRegister):void");
    }

    public static synchronized void removeAlias(Context context, ICallback iCallback) {
        synchronized (TaobaoRegister.class) {
            ALog.i(TAG, a.JSON_CMD_REMOVEALIAS, new Object[0]);
            try {
                String g10 = Config.g(context);
                String h10 = Config.h(context);
                String a10 = Config.a(context);
                if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(g10) && context != null) {
                    if (!TextUtils.isEmpty(h10)) {
                        com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, a10, Config.c(context));
                        if (mRequestListener == null) {
                            mRequestListener = new b(context.getApplicationContext());
                        }
                        GlobalClientInfo.getInstance(context).registerListener("AgooDeviceCmd", (AccsDataListener) mRequestListener);
                        String b10 = accsInstance.b(context, new ACCSManager.AccsRequest((String) null, "AgooDeviceCmd", a.b(a10, g10, h10), (String) null));
                        if (TextUtils.isEmpty(b10)) {
                            if (iCallback != null) {
                                iCallback.onFailure("504.1", "accs channel disabled!");
                            }
                        } else if (iCallback != null) {
                            mRequestListener.f13286a.put(b10, iCallback);
                        }
                    }
                }
                if (iCallback != null) {
                    iCallback.onFailure("504.1", "input params null!!");
                }
                ALog.e(TAG, "setAlias param null", "appkey", a10, "deviceId", g10, a.JSON_PUSH_USER_TOKEN, h10, f.X, context);
                return;
            } catch (Throwable th) {
                ALog.e(TAG, a.JSON_CMD_REMOVEALIAS, th, new Object[0]);
            }
        }
        return;
    }
}
