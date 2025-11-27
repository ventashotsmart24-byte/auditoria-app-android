package com.taobao.accs;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.SessionCenter;
import anet.channel.entity.ENV;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.v;
import com.umeng.analytics.pro.bd;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ACCSClient {
    private static String TAG = "ACCSClient";
    public static Map<String, ACCSClient> mACCSClients = new ConcurrentHashMap(2);
    private static Context mContext;
    private String OTAG = TAG;
    protected b mAccsManager;
    private AccsClientConfig mConfig;

    public ACCSClient(AccsClientConfig accsClientConfig) {
        this.mConfig = accsClientConfig;
        this.OTAG += accsClientConfig.getTag();
        if (mContext == null) {
            mContext = GlobalClientInfo.f12899a;
        }
        this.mAccsManager = ACCSManager.getAccsInstance(mContext, accsClientConfig.getAppKey(), accsClientConfig.getTag());
    }

    public static ACCSClient getAccsClient() {
        return getAccsClient((String) null);
    }

    public static synchronized String init(Context context, String str) {
        String init;
        synchronized (ACCSClient.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
                    if (!AccsClientConfig.loadedStaticConfig) {
                        configByTag = new AccsClientConfig.Builder().setAppKey(str).build();
                        ALog.i(TAG, "init", "create config, appkey as tag");
                    }
                    init = init(context, configByTag);
                }
            }
            throw new AccsException("params error");
        }
        return init;
    }

    public static synchronized void setEnvironment(Context context, @AccsClientConfig.ENV int i10) {
        synchronized (ACCSClient.class) {
            if (i10 < 0 || i10 > 2) {
                try {
                    ALog.e(TAG, "env error", bd.f13841a, Integer.valueOf(i10));
                    i10 = 0;
                } catch (AccsException e10) {
                    ALog.e(TAG, "setEnvironment update client", e10, new Object[0]);
                } catch (Throwable th) {
                    try {
                        ALog.e(TAG, "setEnvironment", th, new Object[0]);
                    } catch (Throwable th2) {
                        v.a(context, i10);
                        throw th2;
                    }
                }
            }
            int i11 = AccsClientConfig.mEnv;
            AccsClientConfig.mEnv = i10;
            if (i11 != i10 && v.e(context)) {
                ALog.i(TAG, "setEnvironment", "preEnv", Integer.valueOf(i11), "toEnv", Integer.valueOf(i10));
                v.c(context);
                v.f(context);
                v.d(context);
                if (i10 == 2) {
                    SessionCenter.switchEnvironment(ENV.TEST);
                } else if (i10 == 1) {
                    SessionCenter.switchEnvironment(ENV.PREPARE);
                }
                for (Map.Entry key : mACCSClients.entrySet()) {
                    getAccsClient((String) key.getKey());
                }
            }
            v.a(context, i10);
        }
    }

    private void updateConfig(AccsClientConfig accsClientConfig) {
        this.mConfig = accsClientConfig;
        b accsInstance = ACCSManager.getAccsInstance(mContext, accsClientConfig.getAppKey(), accsClientConfig.getTag());
        this.mAccsManager = accsInstance;
        if (accsInstance != null) {
            accsInstance.a(accsClientConfig);
        }
    }

    public void bindApp(String str, IAppReceiver iAppReceiver) {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "bindApp mAccsManager null", new Object[0]);
        } else {
            bVar.a(mContext, this.mConfig.getAppKey(), this.mConfig.getAppSecret(), str, iAppReceiver);
        }
    }

    public void bindService(String str) {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "bindService mAccsManager null", new Object[0]);
        } else {
            bVar.b(mContext, str);
        }
    }

    public void bindUser(String str) {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "bindUser mAccsManager null", new Object[0]);
        } else {
            bVar.a(mContext, str);
        }
    }

    public boolean cancel(String str) {
        b bVar = this.mAccsManager;
        if (bVar != null) {
            return bVar.a(str);
        }
        ALog.e(this.OTAG, "cancel mAccsManager null", new Object[0]);
        return false;
    }

    public void clearLoginInfo() {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "clearLoginInfo mAccsManager null", new Object[0]);
        } else {
            bVar.e(mContext);
        }
    }

    public void forceDisableService() {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "forceDisableService mAccsManager null", new Object[0]);
        } else {
            bVar.c(mContext);
        }
    }

    public void forceEnableService() {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "forceEnableService mAccsManager null", new Object[0]);
        } else {
            bVar.d(mContext);
        }
    }

    public Map<String, Boolean> forceReConnectChannel() {
        b bVar = this.mAccsManager;
        if (bVar != null) {
            return bVar.c();
        }
        ALog.e(this.OTAG, "forceReConnectChannel mAccsManager null", new Object[0]);
        return null;
    }

    public Map<String, Boolean> getChannelState() {
        b bVar = this.mAccsManager;
        if (bVar != null) {
            return bVar.b();
        }
        ALog.e(this.OTAG, "getChannelState mAccsManager null", new Object[0]);
        return null;
    }

    @Deprecated
    public String getUserUnit() {
        return null;
    }

    public boolean isAccsConnected() {
        b bVar = this.mAccsManager;
        if (bVar == null || !bVar.a()) {
            return false;
        }
        return true;
    }

    public boolean isChannelError(int i10) {
        b bVar = this.mAccsManager;
        if (bVar != null) {
            return bVar.a(i10);
        }
        ALog.e(this.OTAG, "isChannelError mAccsManager null", new Object[0]);
        return true;
    }

    public boolean isNetworkReachable() {
        b bVar = this.mAccsManager;
        if (bVar != null) {
            return bVar.b(mContext);
        }
        ALog.e(this.OTAG, "isNetworkReachable mAccsManager null", new Object[0]);
        return false;
    }

    public void registerConnectStateListener(AccsConnectStateListener accsConnectStateListener) {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "registerConnectStateListener mAccsManager null", new Object[0]);
        } else {
            bVar.a(accsConnectStateListener);
        }
    }

    public void registerDataListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "registerDataListener mAccsManager null", new Object[0]);
        } else {
            bVar.a(mContext, str, accsAbstractDataListener);
        }
    }

    public void registerSerivce(String str, String str2) {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "registerSerivce mAccsManager null", new Object[0]);
        } else {
            bVar.a(mContext, str, str2);
        }
    }

    public void sendBusinessAck(String str, String str2, String str3, short s10, String str4, Map<Integer, String> map) {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "sendBusinessAck mAccsManager null", new Object[0]);
        } else {
            bVar.a(str, str2, str3, s10, str4, map);
        }
    }

    public String sendData(ACCSManager.AccsRequest accsRequest) {
        b bVar = this.mAccsManager;
        if (bVar != null) {
            return bVar.a(mContext, accsRequest);
        }
        ALog.e(this.OTAG, "sendData mAccsManager null", new Object[0]);
        return null;
    }

    public String sendPushResponse(ACCSManager.AccsRequest accsRequest, TaoBaseService.ExtraInfo extraInfo) {
        b bVar = this.mAccsManager;
        if (bVar != null) {
            return bVar.a(mContext, accsRequest, extraInfo);
        }
        ALog.e(this.OTAG, "sendPushResponse mAccsManager null", new Object[0]);
        return null;
    }

    public String sendRequest(ACCSManager.AccsRequest accsRequest) {
        b bVar = this.mAccsManager;
        if (bVar != null) {
            return bVar.b(mContext, accsRequest);
        }
        ALog.e(this.OTAG, "sendRequest mAccsManager null", new Object[0]);
        return null;
    }

    public void setLoginInfo(ILoginInfo iLoginInfo) {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "setLoginInfo mAccsManager null", new Object[0]);
        } else {
            bVar.a(mContext, iLoginInfo);
        }
    }

    public void startInAppConnection(String str, IAppReceiver iAppReceiver) {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "startInAppConnection mAccsManager null", new Object[0]);
            return;
        }
        Context context = mContext;
        String appKey = this.mConfig.getAppKey();
        this.mConfig.getAppSecret();
        bVar.a(context, appKey, str, iAppReceiver);
    }

    public void unRegisterConnectStateListener(AccsConnectStateListener accsConnectStateListener) {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "unRegisterConnectStateListener mAccsManager null", new Object[0]);
        } else {
            bVar.b(accsConnectStateListener);
        }
    }

    public void unRegisterDataListener(String str) {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "unRegisterDataListener mAccsManager null", new Object[0]);
        } else {
            bVar.e(mContext, str);
        }
    }

    public void unRegisterSerivce(String str) {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "unRegisterSerivce mAccsManager null", new Object[0]);
        } else {
            bVar.d(mContext, str);
        }
    }

    public void unbindService(String str) {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "unbindService mAccsManager null", new Object[0]);
        } else {
            bVar.c(mContext, str);
        }
    }

    public void unbindUser() {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "unbindUser mAccsManager null", new Object[0]);
        } else {
            bVar.a(mContext);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0089, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.taobao.accs.ACCSClient getAccsClient(java.lang.String r9) {
        /*
            java.lang.Class<com.taobao.accs.ACCSClient> r0 = com.taobao.accs.ACCSClient.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x009f }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001a
            java.lang.String r9 = "default"
            java.lang.String r1 = TAG     // Catch:{ all -> 0x009f }
            java.lang.String r4 = "getAccsClient"
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x009f }
            java.lang.String r6 = "configTag is null, use default!"
            r5[r3] = r6     // Catch:{ all -> 0x009f }
            com.taobao.accs.utl.ALog.w(r1, r4, r5)     // Catch:{ all -> 0x009f }
        L_0x001a:
            java.lang.String r1 = TAG     // Catch:{ all -> 0x009f }
            java.lang.String r4 = "getAccsClient"
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x009f }
            java.lang.String r7 = "configTag"
            r6[r3] = r7     // Catch:{ all -> 0x009f }
            r6[r2] = r9     // Catch:{ all -> 0x009f }
            com.taobao.accs.utl.ALog.i(r1, r4, r6)     // Catch:{ all -> 0x009f }
            com.taobao.accs.AccsClientConfig r1 = com.taobao.accs.AccsClientConfig.getConfigByTag(r9)     // Catch:{ all -> 0x009f }
            if (r1 == 0) goto L_0x008a
            java.util.Map<java.lang.String, com.taobao.accs.ACCSClient> r4 = mACCSClients     // Catch:{ all -> 0x009f }
            java.lang.Object r4 = r4.get(r9)     // Catch:{ all -> 0x009f }
            com.taobao.accs.ACCSClient r4 = (com.taobao.accs.ACCSClient) r4     // Catch:{ all -> 0x009f }
            if (r4 != 0) goto L_0x0052
            java.lang.String r2 = TAG     // Catch:{ all -> 0x009f }
            java.lang.String r4 = "getAccsClient create client"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x009f }
            com.taobao.accs.utl.ALog.d(r2, r4, r3)     // Catch:{ all -> 0x009f }
            com.taobao.accs.ACCSClient r2 = new com.taobao.accs.ACCSClient     // Catch:{ all -> 0x009f }
            r2.<init>(r1)     // Catch:{ all -> 0x009f }
            java.util.Map<java.lang.String, com.taobao.accs.ACCSClient> r3 = mACCSClients     // Catch:{ all -> 0x009f }
            r3.put(r9, r2)     // Catch:{ all -> 0x009f }
            r2.updateConfig(r1)     // Catch:{ all -> 0x009f }
            monitor-exit(r0)
            return r2
        L_0x0052:
            com.taobao.accs.AccsClientConfig r9 = r4.mConfig     // Catch:{ all -> 0x009f }
            boolean r9 = r1.equals(r9)     // Catch:{ all -> 0x009f }
            if (r9 == 0) goto L_0x0064
            java.lang.String r9 = TAG     // Catch:{ all -> 0x009f }
            java.lang.String r1 = "getAccsClient exists"
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x009f }
            com.taobao.accs.utl.ALog.i(r9, r1, r2)     // Catch:{ all -> 0x009f }
            goto L_0x0088
        L_0x0064:
            java.lang.String r9 = TAG     // Catch:{ all -> 0x009f }
            java.lang.String r6 = "getAccsClient update config"
            r7 = 4
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x009f }
            java.lang.String r8 = "old config"
            r7[r3] = r8     // Catch:{ all -> 0x009f }
            com.taobao.accs.AccsClientConfig r3 = r4.mConfig     // Catch:{ all -> 0x009f }
            java.lang.String r3 = r3.getTag()     // Catch:{ all -> 0x009f }
            r7[r2] = r3     // Catch:{ all -> 0x009f }
            java.lang.String r2 = "new config"
            r7[r5] = r2     // Catch:{ all -> 0x009f }
            java.lang.String r2 = r1.getTag()     // Catch:{ all -> 0x009f }
            r3 = 3
            r7[r3] = r2     // Catch:{ all -> 0x009f }
            com.taobao.accs.utl.ALog.i(r9, r6, r7)     // Catch:{ all -> 0x009f }
            r4.updateConfig(r1)     // Catch:{ all -> 0x009f }
        L_0x0088:
            monitor-exit(r0)
            return r4
        L_0x008a:
            java.lang.String r9 = TAG     // Catch:{ all -> 0x009f }
            java.lang.String r1 = "getAccsClient"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x009f }
            java.lang.String r4 = "configTag not exist, please init first!!"
            r2[r3] = r4     // Catch:{ all -> 0x009f }
            com.taobao.accs.utl.ALog.e(r9, r1, r2)     // Catch:{ all -> 0x009f }
            com.taobao.accs.AccsException r9 = new com.taobao.accs.AccsException     // Catch:{ all -> 0x009f }
            java.lang.String r1 = "configTag not exist"
            r9.<init>((java.lang.String) r1)     // Catch:{ all -> 0x009f }
            throw r9     // Catch:{ all -> 0x009f }
        L_0x009f:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.ACCSClient.getAccsClient(java.lang.String):com.taobao.accs.ACCSClient");
    }

    public void bindUser(String str, boolean z10) {
        b bVar = this.mAccsManager;
        if (bVar == null) {
            ALog.e(this.OTAG, "bindUser mAccsManager null", new Object[0]);
        } else {
            bVar.a(mContext, str, z10);
        }
    }

    public static synchronized String init(Context context, AccsClientConfig accsClientConfig) {
        String tag;
        synchronized (ACCSClient.class) {
            if (context == null || accsClientConfig == null) {
                throw new AccsException("init AccsClient params error");
            }
            mContext = context.getApplicationContext();
            GlobalClientInfo.f12899a = context.getApplicationContext();
            ALog.d(TAG, "init", "config", accsClientConfig);
            tag = accsClientConfig.getTag();
        }
        return tag;
    }
}
