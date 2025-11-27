package com.efs.sdk.pa;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.pa.a.c;
import com.efs.sdk.pa.config.ConfigManager;
import com.efs.sdk.pa.config.IEfsReporter;
import com.efs.sdk.pa.config.PackageLevel;
import java.util.HashMap;

public class PAFactory {
    private static final long DEFAULT_TIME_OUT_TIME = 2000;
    private static final long INVALID_TIME_OUT_TIME = 0;
    private static final long MAX_TIME_OUT_TIME = 4000;
    private static final String TAG = "pafactory";
    static final ThreadLocal<PA> sThreadLocal = new ThreadLocal<>();
    private ConfigManager mConfigManager;
    private Context mContext;
    private HashMap<String, String> mExtend;
    private IPaClient mPaClient;
    private EfsReporter mReporter;
    private IEfsReporter mReporterFactory;
    private String mSerial;
    private String mSver;
    private long mTimeOutTime;
    private PATraceListener mTraceListener;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private PackageLevel f5504a;

        /* renamed from: b  reason: collision with root package name */
        private IEfsReporter f5505b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f5506c;

        /* renamed from: d  reason: collision with root package name */
        private Context f5507d;

        /* renamed from: e  reason: collision with root package name */
        private String f5508e;

        /* renamed from: f  reason: collision with root package name */
        private HashMap<String, String> f5509f;

        /* renamed from: g  reason: collision with root package name */
        private String f5510g;

        /* renamed from: h  reason: collision with root package name */
        private long f5511h = PAFactory.DEFAULT_TIME_OUT_TIME;

        /* renamed from: i  reason: collision with root package name */
        private PATraceListener f5512i;

        /* renamed from: j  reason: collision with root package name */
        private IPaClient f5513j;

        public Builder(Context context, IEfsReporter iEfsReporter) {
            if (context == null) {
                throw new RuntimeException("context Should Not null");
            } else if (iEfsReporter != null) {
                this.f5505b = iEfsReporter;
                this.f5507d = context;
            } else {
                throw new RuntimeException("reporter Should Not Empty");
            }
        }

        public PAFactory build() {
            if (this.f5504a != null) {
                return new PAFactory(this.f5507d, this.f5504a, this.f5505b, this.f5506c, this.f5508e, this.f5509f, this.f5510g, this.f5511h, this.f5512i, this.f5513j);
            }
            throw new RuntimeException(String.format("%s Should Not Null", new Object[]{""}));
        }

        public Builder extendLogInfo(HashMap<String, String> hashMap) {
            this.f5509f = hashMap;
            return this;
        }

        public Builder isNewInstall(boolean z10) {
            this.f5506c = z10;
            return this;
        }

        public Builder packageLevel(PackageLevel packageLevel) {
            this.f5504a = packageLevel;
            return this;
        }

        public Builder serial(String str) {
            this.f5508e = str;
            return this;
        }

        public Builder setPaClient(IPaClient iPaClient) {
            this.f5513j = iPaClient;
            return this;
        }

        public Builder sver(String str) {
            this.f5510g = str;
            return this;
        }

        public Builder timeoutTime(long j10) {
            if (j10 <= 0) {
                this.f5511h = PAFactory.DEFAULT_TIME_OUT_TIME;
            } else if (j10 > PAFactory.MAX_TIME_OUT_TIME) {
                this.f5511h = PAFactory.DEFAULT_TIME_OUT_TIME;
                return this;
            } else {
                this.f5511h = j10;
            }
            return this;
        }

        public Builder traceListener(PATraceListener pATraceListener) {
            this.f5512i = pATraceListener;
            return this;
        }
    }

    public ConfigManager getConfigManager() {
        return this.mConfigManager;
    }

    public Context getContext() {
        return this.mContext;
    }

    public HashMap<String, String> getExtend() {
        return this.mExtend;
    }

    public IPaClient getPaClient() {
        return this.mPaClient;
    }

    public synchronized PA getPaInstance() {
        PA pa2;
        ThreadLocal<PA> threadLocal = sThreadLocal;
        pa2 = threadLocal.get();
        if (pa2 == null) {
            pa2 = new c(this.mConfigManager.enableTracer());
            pa2.registerPAANRListener(this.mContext, new a(this), this.mTimeOutTime);
            threadLocal.set(pa2);
        }
        return pa2;
    }

    public EfsReporter getReporter() {
        EfsReporter efsReporter;
        if (this.mReporter == null) {
            IEfsReporter iEfsReporter = this.mReporterFactory;
            if (iEfsReporter != null) {
                efsReporter = iEfsReporter.getReporter();
            } else {
                efsReporter = null;
            }
            this.mReporter = efsReporter;
        }
        return this.mReporter;
    }

    public String getSerial() {
        return this.mSerial;
    }

    public String getSver() {
        return this.mSver;
    }

    public PATraceListener getTraceListener() {
        return this.mTraceListener;
    }

    private PAFactory(Context context, PackageLevel packageLevel, IEfsReporter iEfsReporter, boolean z10, String str, HashMap<String, String> hashMap, String str2, long j10, PATraceListener pATraceListener, IPaClient iPaClient) {
        this.mReporterFactory = iEfsReporter;
        this.mSerial = str;
        this.mExtend = hashMap;
        this.mSver = str2;
        this.mContext = context;
        this.mTraceListener = pATraceListener;
        this.mPaClient = iPaClient;
        this.mTimeOutTime = j10;
        this.mConfigManager = new ConfigManager(context, packageLevel, iEfsReporter, z10);
    }
}
