package com.efs.sdk.base;

import android.app.Application;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.efs.sdk.base.core.b.e;
import com.efs.sdk.base.core.cache.CacheManager;
import com.efs.sdk.base.core.cache.IFileFilter;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.config.remote.b;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.a;
import com.efs.sdk.base.custommapping.IUMPerfCallback;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.efs.sdk.base.processor.action.ILogEncryptAction;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EfsReporter {
    private static ControllerCenter sControllerCenter;
    private static IUMPerfCallback sUMPerfCallback;
    private final String TAG;

    public static class Builder {
        private static Map<String, EfsReporter> sInstanceMap = new ConcurrentHashMap();
        private static boolean sUseAppContext = true;
        private final String TAG;
        private GlobalEnvStruct mGlobalEnvStruct;

        public interface IPublicParams {
            Map<String, String> getRecordHeaders();
        }

        public Builder(Application application, String str, String str2) {
            this(application.getApplicationContext(), str, str2);
        }

        private static Context checkContext(Context context) {
            if (context == null) {
                Log.e("context can not be null!");
                throw null;
            } else if (!sUseAppContext || (context instanceof Application) || ((context = context.getApplicationContext()) != null && (context instanceof Application))) {
                return context;
            } else {
                Log.e("Can not get Application context from given context!");
                throw new IllegalArgumentException("Can not get Application context from given context!");
            }
        }

        private void checkParam(String str) {
            GlobalEnvStruct access$100 = sInstanceMap.get(str).getGlobalEnvStruct();
            if (!access$100.mAppContext.equals(getGlobalEnvStruct().mAppContext)) {
                throw new RuntimeException("efs-core: duplicate init, but " + "application context is different");
            } else if (!TextUtils.isEmpty(access$100.getSecret()) && !access$100.getSecret().equals(getGlobalEnvStruct().getSecret())) {
                throw new RuntimeException("efs-core: duplicate init, but " + "secret is different");
            } else if (access$100.isIntl() == getGlobalEnvStruct().isIntl()) {
                if (!TextUtils.isEmpty(getGlobalEnvStruct().getUid()) && !getGlobalEnvStruct().getUid().equals(access$100.getUid())) {
                    Log.w("efs.reporter.builder", "efs-core: duplicate init, but " + " uid is different");
                }
                if (getGlobalEnvStruct().getPublicParamMap() != null && getGlobalEnvStruct().getPublicParamMap().size() > 0) {
                    access$100.addPublicParams(getGlobalEnvStruct().getPublicParamMap());
                }
            } else {
                throw new RuntimeException("efs-core: duplicate init, but " + "intl setting is different");
            }
        }

        public Builder addEfsReporterObserver(IEfsReporterObserver iEfsReporterObserver) {
            this.mGlobalEnvStruct.addConfigObserver(iEfsReporterObserver);
            return this;
        }

        public EfsReporter build() {
            String appid = getGlobalEnvStruct().getAppid();
            if (!sInstanceMap.containsKey(appid)) {
                synchronized (EfsReporter.class) {
                    if (!sInstanceMap.containsKey(appid)) {
                        EfsReporter efsReporter = new EfsReporter(this);
                        sInstanceMap.put(appid, efsReporter);
                        return efsReporter;
                    }
                }
            }
            Log.w("efs.reporter.builder", "efs-core: duplicate init");
            checkParam(appid);
            return sInstanceMap.get(appid);
        }

        public Builder configRefreshAction(IConfigRefreshAction iConfigRefreshAction) {
            b.a().f5223b = iConfigRefreshAction;
            return this;
        }

        public Builder configRefreshDelayMills(long j10) {
            this.mGlobalEnvStruct.configRefreshDelayMills = j10;
            return this;
        }

        public Builder debug(boolean z10) {
            this.mGlobalEnvStruct.setDebug(z10);
            return this;
        }

        public Builder efsDirRootName(String str) {
            a.a(str);
            return this;
        }

        public Builder enablePaBackup(boolean z10) {
            this.mGlobalEnvStruct.setEnablePaBackup(z10);
            return this;
        }

        public Builder enableSendLog(boolean z10) {
            this.mGlobalEnvStruct.setEnableSendLog(z10);
            return this;
        }

        public Builder enableWaStat(boolean z10) {
            this.mGlobalEnvStruct.setEnableWaStat(z10);
            return this;
        }

        public GlobalEnvStruct getGlobalEnvStruct() {
            return this.mGlobalEnvStruct;
        }

        public Builder intl(boolean z10) {
            this.mGlobalEnvStruct.setIsIntl(z10);
            return this;
        }

        public Builder logDid(String str) {
            this.mGlobalEnvStruct.setLogDid(str);
            return this;
        }

        public Builder logEncryptAction(ILogEncryptAction iLogEncryptAction) {
            this.mGlobalEnvStruct.setLogEncryptAction(iLogEncryptAction);
            return this;
        }

        public Builder logUid(String str) {
            this.mGlobalEnvStruct.setLogUid(str);
            return this;
        }

        public Builder maxConcurrentUploadCnt(int i10) {
            e.a().f5148a = i10;
            return this;
        }

        public Builder maxConcurrentUploadCntCodeLog(int i10) {
            e.a().f5149b = i10;
            return this;
        }

        public Builder printLogDetail(boolean z10) {
            this.mGlobalEnvStruct.setPrintLogDetail(z10);
            return this;
        }

        public Builder publicParams(IPublicParams iPublicParams) {
            if (iPublicParams.getRecordHeaders() != null && iPublicParams.getRecordHeaders().size() > 0) {
                this.mGlobalEnvStruct.addPublicParams(iPublicParams.getRecordHeaders());
            }
            return this;
        }

        public Builder setOpenCodeLog(boolean z10) {
            this.mGlobalEnvStruct.setOpenCodeLog(z10);
            return this;
        }

        public Builder uid(String str) {
            this.mGlobalEnvStruct.setUid(str);
            return this;
        }

        public Builder(Context context, String str, String str2) {
            this.TAG = "efs.reporter.builder";
            Context checkContext = checkContext(context);
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("EfsReporter init, appid is empty");
            } else if (!TextUtils.isEmpty(str2)) {
                GlobalEnvStruct globalEnvStruct = new GlobalEnvStruct();
                this.mGlobalEnvStruct = globalEnvStruct;
                globalEnvStruct.mAppContext = checkContext;
                globalEnvStruct.setAppid(str);
                this.mGlobalEnvStruct.setSecret(str2);
            } else {
                throw new RuntimeException("EfsReporter init, secret is empty");
            }
        }

        public Builder publicParams(Map<String, String> map) {
            if (map.size() > 0) {
                this.mGlobalEnvStruct.addPublicParams(map);
            }
            return this;
        }
    }

    /* access modifiers changed from: private */
    public GlobalEnvStruct getGlobalEnvStruct() {
        return ControllerCenter.getGlobalEnvStruct();
    }

    public static void registerPerfCallback(IUMPerfCallback iUMPerfCallback) {
        sUMPerfCallback = iUMPerfCallback;
    }

    public void addPublicParams(Map<String, String> map) {
        if (map.size() > 0) {
            getGlobalEnvStruct().addPublicParams(map);
        }
    }

    public void flushRecordLogImmediately(String str) {
        CacheManager.getInstance().flushImmediately((byte) 1, str);
    }

    public Map<String, String> getAllConfig() {
        return b.a().c();
    }

    public void getAllSdkConfig(String[] strArr, IConfigCallback iConfigCallback) {
        b a10 = b.a();
        a10.f5226e.put(iConfigCallback, strArr);
        if (!a10.f5225d.mSDKConfigMap.isEmpty()) {
            a10.d();
        }
    }

    public void getAllSdkConfigFromServer(String[] strArr, IConfigCallback iConfigCallback) {
        b.a().f5227f.put(iConfigCallback, strArr);
    }

    public Map<String, Object> getStrategyMap() {
        return new HashMap(b.a().f5225d.mStrategyMap);
    }

    public void refreshConfig(String str) {
        b.a().a(str);
    }

    public void registerCallback(int i10, ValueCallback<Pair<Message, Message>> valueCallback) {
        getGlobalEnvStruct().registerCallback(i10, valueCallback);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0048 A[Catch:{ Exception -> 0x005c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void send(com.efs.sdk.base.protocol.ILogProtocol r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.efs.sdk.base.protocol.record.EfsJSONLog     // Catch:{ Exception -> 0x005c }
            if (r0 == 0) goto L_0x0060
            java.lang.String r0 = r5.getLogType()     // Catch:{ Exception -> 0x005c }
            int r1 = r0.hashCode()     // Catch:{ Exception -> 0x005c }
            r2 = -2128464309(0xffffffff8122364b, float:-2.9793654E-38)
            r3 = 1
            if (r1 == r2) goto L_0x0022
            r2 = 846000494(0x326cf16e, float:1.3791903E-8)
            if (r1 == r2) goto L_0x0018
            goto L_0x002c
        L_0x0018:
            java.lang.String r1 = "powerperf"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x005c }
            if (r0 == 0) goto L_0x002c
            r0 = 0
            goto L_0x002d
        L_0x0022:
            java.lang.String r1 = "startperf"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x005c }
            if (r0 == 0) goto L_0x002c
            r0 = 1
            goto L_0x002d
        L_0x002c:
            r0 = -1
        L_0x002d:
            java.lang.String r1 = "um_custom_mapping"
            if (r0 == 0) goto L_0x0048
            if (r0 == r3) goto L_0x0034
            goto L_0x0060
        L_0x0034:
            com.efs.sdk.base.custommapping.IUMPerfCallback r0 = sUMPerfCallback     // Catch:{ Exception -> 0x005c }
            if (r0 == 0) goto L_0x003d
            com.efs.sdk.base.custommapping.IUMPerfCallback$PerfType r2 = com.efs.sdk.base.custommapping.IUMPerfCallback.PerfType.PERF_TYPE_START     // Catch:{ Exception -> 0x005c }
            r0.onCallback(r2)     // Catch:{ Exception -> 0x005c }
        L_0x003d:
            r0 = r5
            com.efs.sdk.base.protocol.record.EfsJSONLog r0 = (com.efs.sdk.base.protocol.record.EfsJSONLog) r0     // Catch:{ Exception -> 0x005c }
            java.lang.String r2 = com.efs.sdk.base.custommapping.InnerCustomMappingManager.getCustomMappingJsonStr()     // Catch:{ Exception -> 0x005c }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x005c }
            goto L_0x0060
        L_0x0048:
            com.efs.sdk.base.custommapping.IUMPerfCallback r0 = sUMPerfCallback     // Catch:{ Exception -> 0x005c }
            if (r0 == 0) goto L_0x0051
            com.efs.sdk.base.custommapping.IUMPerfCallback$PerfType r2 = com.efs.sdk.base.custommapping.IUMPerfCallback.PerfType.PERF_TYPE_POWER     // Catch:{ Exception -> 0x005c }
            r0.onCallback(r2)     // Catch:{ Exception -> 0x005c }
        L_0x0051:
            r0 = r5
            com.efs.sdk.base.protocol.record.EfsJSONLog r0 = (com.efs.sdk.base.protocol.record.EfsJSONLog) r0     // Catch:{ Exception -> 0x005c }
            java.lang.String r2 = com.efs.sdk.base.custommapping.InnerCustomMappingManager.getCustomMappingJsonStr()     // Catch:{ Exception -> 0x005c }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x005c }
            goto L_0x0060
        L_0x005c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0060:
            com.efs.sdk.base.core.controller.ControllerCenter r0 = sControllerCenter
            r0.send(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.EfsReporter.send(com.efs.sdk.base.protocol.ILogProtocol):void");
    }

    public HttpResponse sendSyncImediatelly(String str, int i10, String str2, File file) {
        return sendSyncImediatelly(str, i10, str2, true, file);
    }

    public void setEnableRefreshConfigFromRemote(boolean z10) {
        b.a().f5224c = z10;
    }

    public void setFileFilterCodeLog(IFileFilter iFileFilter) {
        e.a().f5151d = iFileFilter;
    }

    private EfsReporter(Builder builder) {
        this.TAG = "efs.reporter";
        sControllerCenter = new ControllerCenter(builder);
    }

    public HttpResponse sendSyncImediatelly(String str, int i10, String str2, boolean z10, File file) {
        return sControllerCenter.sendSyncImmediately(str, i10, str2, z10, file);
    }

    public Map<String, Object> getAllSdkConfig() {
        return new HashMap(b.a().f5225d.mSDKConfigMap);
    }
}
