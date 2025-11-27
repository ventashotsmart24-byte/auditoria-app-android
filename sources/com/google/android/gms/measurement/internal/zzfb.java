package com.google.android.gms.measurement.internal;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.analytics.pro.bt;
import java.util.HashMap;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzfb implements Callable {
    public final /* synthetic */ zzfi zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfb(zzfi zzfi, String str) {
        this.zza = zzfi;
        this.zzb = str;
    }

    public final Object call() {
        zzfi zzfi = this.zza;
        String str = this.zzb;
        zzh zzj = zzfi.zzf.zzi().zzj(str);
        HashMap hashMap = new HashMap();
        hashMap.put(DispatchConstants.PLATFORM, "android");
        hashMap.put(bt.f13921o, str);
        zzfi.zzt.zzf().zzh();
        hashMap.put("gmp_version", 74029L);
        if (zzj != null) {
            String zzw = zzj.zzw();
            if (zzw != null) {
                hashMap.put("app_version", zzw);
            }
            hashMap.put("app_version_int", Long.valueOf(zzj.zzb()));
            hashMap.put("dynamite_version", Long.valueOf(zzj.zzk()));
        }
        return hashMap;
    }
}
