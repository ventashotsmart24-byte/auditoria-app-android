package com.umeng.powersdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import com.efs.sdk.pa.config.ConfigManager;
import java.util.Map;
import java.util.Random;

public class PowerConfigManager {

    /* renamed from: a  reason: collision with root package name */
    private final String f16163a = "PageConfigManager";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f16164b;

    /* renamed from: c  reason: collision with root package name */
    private EfsReporter f16165c;

    /* renamed from: d  reason: collision with root package name */
    private int f16166d = 100;

    /* renamed from: e  reason: collision with root package name */
    private final int f16167e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f16168f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16169g = false;

    public PowerConfigManager(Context context, EfsReporter efsReporter) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor edit2;
        SharedPreferences.Editor edit3;
        SharedPreferences.Editor edit4;
        SharedPreferences.Editor edit5;
        Context applicationContext = context.getApplicationContext();
        this.f16164b = applicationContext;
        this.f16165c = efsReporter;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("efs_power", 0);
        if (sharedPreferences != null) {
            this.f16168f = sharedPreferences.getInt("apm_powerperf_sampling_rate_last", 0);
        }
        SharedPreferences sharedPreferences2 = this.f16164b.getSharedPreferences("efs_power", 0);
        int i10 = sharedPreferences2 != null ? sharedPreferences2.getInt("apm_powerperf_sampling_rate", -1) : -1;
        this.f16165c.getAllSdkConfig(new String[]{"apm_powerperf_sampling_rate", "apm_powerperf_collect_interval", "apm_powerperf_collect_max_period_sec"}, new IConfigCallback() {
            public final void onChange(Map<String, Object> map) {
                SharedPreferences.Editor edit;
                try {
                    SharedPreferences sharedPreferences = PowerConfigManager.this.f16164b.getSharedPreferences("efs_power", 0);
                    if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null && map != null) {
                        Object obj = map.get("apm_powerperf_sampling_rate");
                        if (obj != null) {
                            edit.putInt("apm_powerperf_sampling_rate", Integer.parseInt(obj.toString()));
                        }
                        Object obj2 = map.get("apm_powerperf_collect_interval");
                        if (obj2 != null) {
                            edit.putInt("apm_powerperf_collect_interval", Integer.parseInt(obj2.toString()));
                        }
                        Object obj3 = map.get("apm_powerperf_collect_max_period_sec");
                        if (obj3 != null) {
                            edit.putInt("apm_powerperf_collect_max_period_sec", Integer.parseInt(obj3.toString()));
                        }
                        edit.apply();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        if (i10 != -1) {
            this.f16166d = i10;
        }
        boolean z10 = true;
        if (!SamplingWhiteListUtil.isHitWL()) {
            SharedPreferences sharedPreferences3 = this.f16164b.getSharedPreferences("efs_power", 0);
            long j10 = sharedPreferences3 != null ? sharedPreferences3.getLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0) : 0;
            boolean z11 = sharedPreferences3 != null ? sharedPreferences3.getBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
            int i11 = this.f16166d;
            if (i11 == 0) {
                if (!(!z11 || sharedPreferences3 == null || (edit5 = sharedPreferences3.edit()) == null)) {
                    edit5.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false);
                    edit5.commit();
                }
                if (!(j10 == 0 || sharedPreferences3 == null || (edit4 = sharedPreferences3.edit()) == null)) {
                    edit4.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0);
                    edit4.commit();
                }
            } else {
                boolean z12 = i11 != this.f16168f;
                Long valueOf = Long.valueOf(j10);
                int i12 = this.f16166d;
                Long valueOf2 = Long.valueOf(System.currentTimeMillis());
                Long valueOf3 = Long.valueOf(valueOf2.longValue() - valueOf.longValue());
                if (z11 && valueOf3.longValue() < 86400000 && !z12) {
                    String str = PowerManager.TAG;
                } else if (valueOf3.longValue() >= 86400000 || z12) {
                    if (i12 != 0 && (i12 == 100 || new Random().nextInt(100) <= i12)) {
                        String str2 = PowerManager.TAG;
                    } else {
                        String str3 = PowerManager.TAG;
                        z10 = false;
                    }
                    SharedPreferences sharedPreferences4 = this.f16164b.getSharedPreferences("efs_power", 0);
                    if (!(sharedPreferences4 == null || (edit3 = sharedPreferences4.edit()) == null)) {
                        edit3.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, z10);
                        edit3.apply();
                    }
                    if (!(sharedPreferences4 == null || (edit2 = sharedPreferences4.edit()) == null)) {
                        edit2.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, valueOf2.longValue());
                        edit2.apply();
                    }
                } else {
                    String str4 = PowerManager.TAG;
                }
            }
            z10 = false;
        }
        this.f16169g = z10;
        SharedPreferences sharedPreferences5 = this.f16164b.getSharedPreferences("efs_power", 0);
        if (sharedPreferences5 != null && (edit = sharedPreferences5.edit()) != null) {
            edit.putInt("apm_powerperf_sampling_rate_last", this.f16166d);
            edit.apply();
        }
    }

    public boolean enableTracer() {
        return this.f16169g;
    }
}
