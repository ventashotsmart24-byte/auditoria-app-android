package com.efs.sdk.base.core.config.remote;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.efs.sdk.base.IConfigRefreshAction;
import com.efs.sdk.base.core.b.h;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONObject;

public final class b implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public static final Random f5222a = new Random();

    /* renamed from: b  reason: collision with root package name */
    public IConfigRefreshAction f5223b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5224c;

    /* renamed from: d  reason: collision with root package name */
    public RemoteConfig f5225d;

    /* renamed from: e  reason: collision with root package name */
    public Map<IConfigCallback, String[]> f5226e;

    /* renamed from: f  reason: collision with root package name */
    public Map<IConfigCallback, String[]> f5227f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Handler f5228g;

    /* renamed from: h  reason: collision with root package name */
    private d f5229h;

    /* renamed from: i  reason: collision with root package name */
    private long f5230i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5231j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f5232k;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f5236a = new b((byte) 0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    private void f() {
        boolean z10;
        try {
            z10 = this.f5229h.a(this.f5225d);
        } catch (Throwable unused) {
            z10 = false;
        }
        if (!z10) {
            this.f5228g.sendEmptyMessageDelayed(3, 3000);
        }
    }

    private IConfigRefreshAction g() {
        IConfigRefreshAction iConfigRefreshAction = this.f5223b;
        if (iConfigRefreshAction == null) {
            return a.a();
        }
        return iConfigRefreshAction;
    }

    private boolean h() {
        boolean z10;
        d.b();
        long j10 = 0;
        try {
            d dVar = this.f5229h;
            dVar.c();
            if (dVar.f5238a != null) {
                j10 = dVar.f5238a.getLong("last_refresh_time", 0);
            }
        } catch (Throwable unused) {
        }
        if (System.currentTimeMillis() - j10 >= this.f5225d.f5219d * 60 * 1000) {
            z10 = true;
        } else {
            z10 = false;
        }
        Log.i("efs.config", "isUpdate ".concat(String.valueOf(z10)));
        return z10;
    }

    private void i() {
        try {
            for (ValueCallback<Pair<Message, Message>> onReceiveValue : ControllerCenter.getGlobalEnvStruct().getCallback(1)) {
                Message obtain = Message.obtain((Handler) null, 1, new JSONObject(this.f5225d.mSDKConfigMap).toString());
                Message obtain2 = Message.obtain();
                onReceiveValue.onReceiveValue(new Pair(obtain, obtain2));
                obtain.recycle();
                obtain2.recycle();
            }
            for (IEfsReporterObserver onConfigChange : ControllerCenter.getGlobalEnvStruct().getEfsReporterObservers()) {
                onConfigChange.onConfigChange();
            }
        } catch (Throwable th) {
            Log.e("efs.config", th);
        }
    }

    private void j() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                try {
                    for (IConfigCallback iConfigCallback : b.this.f5227f.keySet()) {
                        String[] strArr = (String[]) b.this.f5227f.get(iConfigCallback);
                        HashMap hashMap = new HashMap();
                        if (!(strArr == null || strArr.length == 0)) {
                            for (String str : strArr) {
                                if (b.this.f5225d.mSDKConfigMap.containsKey(str)) {
                                    hashMap.put(str, b.this.c().get(str));
                                    Log.i("efs.config.register", "[from server] configCallback key is " + str + " ## value is " + b.this.c().get(str));
                                }
                            }
                        }
                        iConfigCallback.onChange(hashMap);
                    }
                    b.this.f5227f.clear();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public final boolean handleMessage(Message message) {
        RemoteConfig remoteConfig;
        int i10 = message.what;
        if (i10 == 0) {
            boolean a10 = d.a();
            Log.i("efs.config", "delete old config is ".concat(String.valueOf(a10)));
            if (a10) {
                this.f5228g.sendEmptyMessage(1);
            } else {
                d dVar = this.f5229h;
                dVar.c();
                if (dVar.f5238a == null) {
                    remoteConfig = null;
                } else {
                    RemoteConfig a11 = RemoteConfig.a();
                    a11.mConfigVersion = dVar.f5238a.getInt("cver", -1);
                    Set<String> keySet = dVar.f5238a.getAll().keySet();
                    HashMap hashMap = new HashMap();
                    for (String next : keySet) {
                        String string = dVar.f5238a.getString(next, "");
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(next, string);
                        }
                    }
                    a11.a((Map<String, String>) hashMap);
                    a11.a(dVar.f5238a.getString("sign", ""));
                    remoteConfig = a11;
                }
                if (remoteConfig == null) {
                    Log.i("efs.config", "first load local config false.");
                } else if (a(remoteConfig)) {
                    Log.i("efs.config", "current config to same.");
                } else {
                    this.f5225d = remoteConfig;
                    String str = "load config from storage";
                    if (-1 != remoteConfig.mConfigVersion) {
                        i();
                        Log.i("efs.config.register", "call back");
                        d();
                        j();
                        str = str + " and notify observer";
                    }
                    Log.i("efs.config", str);
                }
            }
        } else if (i10 == 1) {
            int i11 = message.arg1;
            if (i11 <= this.f5225d.mConfigVersion) {
                Log.i("efs.config", "current config version is " + i11 + ", no need to refresh");
                Log.i("efs.config", "current config version(" + this.f5225d.mConfigVersion + ") is " + i11 + ", no need to refresh");
            } else {
                e();
            }
        } else if (i10 == 2) {
            try {
                if (h.a.f5170a.a()) {
                    if (!h()) {
                        Log.i("efs.config", "No update is required, less than 8h since the last update");
                        int parseInt = Integer.parseInt(UMEnvelopeBuild.imprintProperty(ControllerCenter.getGlobalEnvStruct().mAppContext, "apm_setting_cver", "-1"));
                        Log.d("efs.config", "APM_CVER_FROM_COMMON from UMEnvelopeBuild.imprintProperty is " + parseInt + " and mRemoteConfig.getConfigVersion() is " + this.f5225d.mConfigVersion);
                        if (parseInt > this.f5225d.mConfigVersion) {
                            this.f5228g.sendEmptyMessage(4);
                        }
                    } else {
                        Log.i("efs.config", "update config");
                        e();
                    }
                    ImprintHandler.getImprintService(ControllerCenter.getGlobalEnvStruct().mAppContext).registImprintCallback("apm_setting_cver", new UMImprintChangeCallback() {
                        public final void onImprintValueChanged(String str, String str2) {
                            try {
                                int parseInt = Integer.parseInt(str2);
                                if (b.this.f5232k == parseInt) {
                                    Log.d("efs.config", "APM_CVER_FROM_COMMON from onImprintValueChanged is equals to mCverFromCommonListener");
                                    return;
                                }
                                int unused = b.this.f5232k = parseInt;
                                Log.d("efs.config", "APM_CVER_FROM_COMMON from onImprintValueChanged is " + parseInt + " and mRemoteConfig.getConfigVersion() is " + b.this.f5225d.mConfigVersion);
                                if (parseInt > b.this.f5225d.mConfigVersion) {
                                    b.this.f5228g.sendEmptyMessage(4);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if (i10 == 3) {
            f();
        } else if (i10 == 4) {
            e();
        }
        return true;
    }

    private b() {
        this.f5224c = true;
        this.f5226e = new HashMap();
        this.f5227f = new HashMap();
        this.f5231j = false;
        this.f5232k = -1;
        this.f5228g = new Handler(com.efs.sdk.base.core.util.concurrent.a.f5313a.getLooper(), this);
        this.f5229h = new d();
        this.f5225d = RemoteConfig.a();
        this.f5230i = ControllerCenter.getGlobalEnvStruct().configRefreshDelayMills;
        this.f5231j = ControllerCenter.getGlobalEnvStruct().isOpenCodeLog();
    }

    private void e() {
        if (!h.a.f5170a.a()) {
            Log.i("efs.config", "has no permission to refresh config from remote");
        } else if (!this.f5224c) {
            Log.i("efs.config", "disable refresh config from remote");
        } else {
            String refresh = g().refresh();
            Log.i("efs.config", "from server. efs config is ".concat(String.valueOf(refresh)));
            if (TextUtils.isEmpty(refresh)) {
                Log.e("efs.config", "config is empty");
            } else {
                a(refresh);
            }
        }
    }

    public final void b() {
        this.f5228g.sendEmptyMessage(0);
        this.f5228g.sendEmptyMessageDelayed(2, this.f5230i);
    }

    public final Map<String, String> c() {
        return new HashMap(this.f5225d.mSDKConfigMap);
    }

    public final void d() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                try {
                    for (IConfigCallback iConfigCallback : b.this.f5226e.keySet()) {
                        String[] strArr = (String[]) b.this.f5226e.get(iConfigCallback);
                        HashMap hashMap = new HashMap();
                        if (!(strArr == null || strArr.length == 0)) {
                            for (String str : strArr) {
                                if (b.this.f5225d.mSDKConfigMap.containsKey(str)) {
                                    hashMap.put(str, b.this.c().get(str));
                                    Log.i("efs.config.register", "configCallback key is " + str + " ## value is " + b.this.c().get(str));
                                }
                            }
                        }
                        iConfigCallback.onChange(hashMap);
                    }
                    b.this.f5226e.clear();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static b a() {
        return a.f5236a;
    }

    public final void a(int i10) {
        if (i10 <= this.f5225d.mConfigVersion) {
            Log.i("efs.config", "current config version is " + i10 + ", no need to refresh");
            return;
        }
        Message obtain = Message.obtain();
        obtain.arg1 = i10;
        obtain.what = 1;
        this.f5228g.sendMessage(obtain);
    }

    public final String a(String str, String str2) {
        String str3 = this.f5225d.mSDKConfigMap.containsKey(str) ? this.f5225d.mSDKConfigMap.get(str) : str2;
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public final String a(boolean z10) {
        if (z10) {
            return "https://" + this.f5225d.f5218c;
        }
        return this.f5225d.f5217b + this.f5225d.f5218c;
    }

    public final void a(String str) {
        RemoteConfig a10 = RemoteConfig.a();
        if (!c.a(str, a10)) {
            this.f5228g.sendEmptyMessageDelayed(1, 3000);
        } else if (!a(a10)) {
            this.f5225d = a10;
            f();
            i();
            d();
            j();
        }
    }

    private boolean a(RemoteConfig remoteConfig) {
        if (this.f5231j) {
            return false;
        }
        if (this.f5225d.mConfigVersion >= remoteConfig.mConfigVersion) {
            return true;
        }
        Log.i("efs.config", "current config version (" + this.f5225d.mConfigVersion + ") is older than another (" + remoteConfig.mConfigVersion + ")");
        return false;
    }
}
