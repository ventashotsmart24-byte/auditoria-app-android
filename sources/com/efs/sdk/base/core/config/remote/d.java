package com.efs.sdk.base.core.config.remote;

import android.content.SharedPreferences;
import com.efs.sdk.base.core.b.c;
import com.efs.sdk.base.core.b.h;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.a;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import java.io.File;
import java.util.Map;

public final class d implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    volatile SharedPreferences f5238a;

    public static void b() {
        File a10 = a.a(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (a10.exists()) {
            a10.delete();
        }
    }

    private void d() {
        if (this.f5238a == null) {
            synchronized (c.class) {
                if (this.f5238a == null) {
                    String appid = ControllerCenter.getGlobalEnvStruct().getAppid();
                    this.f5238a = SharedPreferencesUtils.getSharedPreferences(ControllerCenter.getGlobalEnvStruct().mAppContext, EncodeUtil.base64EncodeToStr(("config_" + appid.toLowerCase()).getBytes()));
                    this.f5238a.registerOnSharedPreferenceChangeListener(this);
                }
            }
        }
    }

    public final boolean a(RemoteConfig remoteConfig) {
        c();
        if (this.f5238a == null) {
            return false;
        }
        SharedPreferences.Editor edit = this.f5238a.edit();
        edit.clear();
        edit.putInt("cver", remoteConfig.mConfigVersion);
        edit.putLong("last_refresh_time", System.currentTimeMillis());
        for (Map.Entry next : remoteConfig.mSDKConfigMap.entrySet()) {
            edit.putString((String) next.getKey(), (String) next.getValue());
        }
        edit.putString("sign", remoteConfig.f5216a);
        edit.apply();
        return true;
    }

    public final void c() {
        try {
            d();
        } catch (Throwable th) {
            Log.e("efs.config", "init sharedpreferences error", th);
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (!h.a.f5170a.a()) {
            b.a().b();
        }
    }

    public static boolean a() {
        GlobalEnvStruct globalEnvStruct = ControllerCenter.getGlobalEnvStruct();
        File b10 = a.b(globalEnvStruct.mAppContext, globalEnvStruct.getAppid());
        if (!b10.exists()) {
            return false;
        }
        FileUtil.delete(b10);
        return true;
    }
}
