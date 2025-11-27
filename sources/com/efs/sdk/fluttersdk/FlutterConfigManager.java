package com.efs.sdk.fluttersdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.StatFs;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.umeng.analytics.pro.bt;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class FlutterConfigManager {

    /* renamed from: a  reason: collision with root package name */
    private final String f5317a = "FlutterConfigManager";

    /* renamed from: b  reason: collision with root package name */
    private final int f5318b = 0;

    /* renamed from: c  reason: collision with root package name */
    private EfsReporter f5319c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f5320d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f5321e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f5322f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f5323g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f5324h = false;

    /* renamed from: i  reason: collision with root package name */
    private Context f5325i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f5326j = false;

    public FlutterConfigManager(Context context, EfsReporter efsReporter) {
        this.f5325i = context;
        this.f5319c = efsReporter;
        efsReporter.getAllSdkConfig(new String[]{"flutter_pv_sampling_rate", "flutter_pv_max_count", "flutter_dart_exception_state", "flutter_dart_exception_max_count"}, new IConfigCallback() {
            public final void onChange(Map<String, Object> map) {
                try {
                    Object obj = map.get("flutter_pv_sampling_rate");
                    if (obj != null) {
                        int unused = FlutterConfigManager.this.f5320d = Integer.parseInt(obj.toString());
                        FlutterConfigManager flutterConfigManager = FlutterConfigManager.this;
                        boolean unused2 = flutterConfigManager.f5324h = FlutterConfigManager.a(flutterConfigManager.f5320d);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    Object obj2 = map.get("flutter_pv_max_count");
                    if (obj2 != null) {
                        int unused3 = FlutterConfigManager.this.f5321e = Integer.parseInt(obj2.toString());
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                try {
                    Object obj3 = map.get("flutter_dart_exception_state");
                    if (obj3 != null) {
                        int unused4 = FlutterConfigManager.this.f5322f = Integer.parseInt(obj3.toString());
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                try {
                    Object obj4 = map.get("flutter_dart_exception_max_count");
                    if (obj4 != null) {
                        int unused5 = FlutterConfigManager.this.f5323g = Integer.parseInt(obj4.toString());
                    }
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                boolean unused6 = FlutterConfigManager.this.f5326j = true;
            }
        });
    }

    public Map<String, Object> getCloudConfig() {
        if (!this.f5326j) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("flutter_pv_max_count", Integer.valueOf(this.f5321e));
        hashMap.put("flutter_dart_exception_state", Integer.valueOf(this.f5322f));
        hashMap.put("flutter_dart_exception_max_count", Integer.valueOf(this.f5323g));
        hashMap.put("flutter_pv_sampling_hit", Boolean.valueOf(this.f5324h));
        return hashMap;
    }

    public Map<String, Object> getNativeParams() {
        HashMap hashMap = null;
        if (!this.f5326j) {
            return null;
        }
        try {
            HashMap hashMap2 = new HashMap();
            try {
                Intent registerReceiver = this.f5325i.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                hashMap2.put(bt.Z, Integer.valueOf(registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0)));
                hashMap2.put("temperature", Integer.valueOf(registerReceiver.getIntExtra("temperature", 0)));
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                long blockSizeLong = statFs.getBlockSizeLong();
                long blockCountLong = statFs.getBlockCountLong() * blockSizeLong;
                long availableBlocksLong = statFs.getAvailableBlocksLong() * blockSizeLong;
                Locale locale = Locale.getDefault();
                Object[] objArr = new Object[1];
                double d10 = (double) availableBlocksLong;
                double d11 = (double) blockCountLong;
                Double.isNaN(d10);
                Double.isNaN(d11);
                objArr[0] = Double.valueOf((d10 / d11) * 100.0d);
                hashMap2.put("disk_ratio", String.format(locale, "%.2f", objArr));
                hashMap2.putAll(GlobalInfoManager.getInstance().getGlobalInfo().getGlobalInfoMap());
                hashMap2.putAll(ControllerCenter.getGlobalEnvStruct().getPublicParamMap());
                return hashMap2;
            } catch (Throwable unused) {
                hashMap = hashMap2;
            }
        } catch (Throwable unused2) {
            return hashMap;
        }
    }

    public boolean isFlutterEnable() {
        return this.f5324h;
    }

    public static /* synthetic */ boolean a(int i10) {
        if (SamplingWhiteListUtil.isHitWL()) {
            return true;
        }
        if (i10 != 0) {
            return i10 == 100 || new Random().nextInt(100) <= i10;
        }
        return false;
    }
}
