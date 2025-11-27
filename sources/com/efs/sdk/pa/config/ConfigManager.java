package com.efs.sdk.pa.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import java.util.Map;
import java.util.Random;

public class ConfigManager {
    private static final int A_DAY = 86400000;
    public static final String FLAG_PA_CHECK_IN_STATE = "8f2f54c08600aa25915617fa1371441b";
    public static final String FLAG_PA_FORE_CHECK_TIME = "03f870871950c148387b251894ed3e88";
    private static final int MAX_ANR_STATS_COUNT = 50;
    private static final int MAX_ANR_TRACE_RATE = 100;
    private static final String MODEL_SP = "paconfig";
    public static final String PA_LEVEL = "pa_level";
    private static final String STATS_ANR_LOG_COUNT = "apm_anr_count";
    private final String APM_PATRACE_SWITCH_RATE_CURRENT = "apm_patrace_switch_rate";
    private final String APM_PATRACE_SWITCH_RATE_LAST = "apm_patrace_switch_rate_last";
    private final int DEF_CLOSE_RATE;
    private final String TAG = "WpkPaConfig";
    private boolean mCheckIn;
    private int mCurrentRate;
    private IEfsReporter mEfsReporter;
    private int mLastRate;
    private PackageLevel mPackageLevel;
    private SharedPreferences mSharedPreferences;

    public ConfigManager(Context context, PackageLevel packageLevel, IEfsReporter iEfsReporter, boolean z10) {
        boolean z11 = false;
        this.DEF_CLOSE_RATE = 0;
        this.mCheckIn = false;
        this.mPackageLevel = packageLevel;
        this.mEfsReporter = iEfsReporter;
        this.mSharedPreferences = SharedPreferencesUtils.getSharedPreferences(context, MODEL_SP);
        initRate();
        if (z10) {
            resetUploadSmoothLogCnt();
            z11 = enableAnrTracer();
        } else if (isCountEnable() && enableAnrTracer()) {
            z11 = true;
        }
        this.mCheckIn = z11;
        resetRate();
    }

    private boolean checkIn(boolean z10, Long l10, boolean z11, int i10) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Long valueOf2 = Long.valueOf(valueOf.longValue() - l10.longValue());
        if (z11 && valueOf2.longValue() < 86400000 && !z10) {
            return true;
        }
        if (valueOf2.longValue() < 86400000 && !z10) {
            return false;
        }
        boolean random = random(i10);
        putBooleanValue(FLAG_PA_CHECK_IN_STATE, random);
        putLongValue(FLAG_PA_FORE_CHECK_TIME, valueOf.longValue());
        return random;
    }

    private boolean enableAnrTracer() {
        long j10 = this.mSharedPreferences.getLong(FLAG_PA_FORE_CHECK_TIME, 0);
        boolean z10 = false;
        boolean z11 = this.mSharedPreferences.getBoolean(FLAG_PA_CHECK_IN_STATE, false);
        if (this.mCurrentRate == 0) {
            if (z11) {
                putBooleanValue(FLAG_PA_CHECK_IN_STATE, false);
            }
            if (j10 != 0) {
                putLongValue(FLAG_PA_FORE_CHECK_TIME, 0);
            }
            return false;
        } else if (SamplingWhiteListUtil.isHitWL()) {
            return true;
        } else {
            if (this.mCurrentRate != this.mLastRate) {
                z10 = true;
            }
            return checkIn(z10, Long.valueOf(j10), z11, this.mCurrentRate);
        }
    }

    private int getCurrentConfigRate() {
        int i10 = this.mSharedPreferences.getInt("apm_patrace_switch_rate", -1);
        this.mEfsReporter.getReporter().getAllSdkConfig(new String[]{"apm_patrace_switch_rate"}, new IConfigCallback() {
            public final void onChange(Map<String, Object> map) {
                Object obj = map.get("apm_patrace_switch_rate");
                if (obj != null) {
                    try {
                        ConfigManager.this.putIntValue("apm_patrace_switch_rate", Integer.parseInt(obj.toString()));
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        return i10;
    }

    private void initRate() {
        this.mLastRate = this.mSharedPreferences.getInt("apm_patrace_switch_rate_last", 0);
        int currentConfigRate = getCurrentConfigRate();
        if (currentConfigRate != -1) {
            this.mCurrentRate = currentConfigRate;
        } else if (this.mPackageLevel == PackageLevel.TRIAL) {
            this.mCurrentRate = 100;
        } else {
            this.mCurrentRate = 0;
        }
    }

    private boolean isCountEnable() {
        if (this.mSharedPreferences.getLong(STATS_ANR_LOG_COUNT, 0) > 50) {
            return false;
        }
        return true;
    }

    private void putBooleanValue(String str, boolean z10) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putBoolean(str, z10);
        edit.apply();
    }

    /* access modifiers changed from: private */
    public void putIntValue(String str, int i10) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt(str, i10);
        edit.apply();
    }

    private void putLongValue(String str, long j10) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putLong(str, j10);
        edit.apply();
    }

    private boolean random(int i10) {
        if (i10 == 0) {
            return false;
        }
        if (i10 != 100 && new Random().nextInt(100) > i10) {
            return false;
        }
        return true;
    }

    private void resetRate() {
        putIntValue("apm_patrace_switch_rate_last", this.mCurrentRate);
    }

    private void resetUploadSmoothLogCnt() {
        putLongValue(STATS_ANR_LOG_COUNT, 0);
    }

    public boolean enableTracer() {
        return this.mCheckIn;
    }

    public void increaseUploadSmoothLogCnt() {
        putLongValue(STATS_ANR_LOG_COUNT, this.mSharedPreferences.getLong(STATS_ANR_LOG_COUNT, 0) + 1);
    }
}
