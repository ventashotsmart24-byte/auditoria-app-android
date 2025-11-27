package com.google.android.gms.cast.framework;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class zzd implements OnSuccessListener {
    public final /* synthetic */ CastContext zza;
    public final /* synthetic */ com.google.android.gms.internal.cast.zzd zzb;
    public final /* synthetic */ SharedPreferences zzc;

    public /* synthetic */ zzd(CastContext castContext, com.google.android.gms.internal.cast.zzd zzd, SharedPreferences sharedPreferences) {
        this.zza = castContext;
        this.zzb = zzd;
        this.zzc = sharedPreferences;
    }

    public final void onSuccess(Object obj) {
        this.zza.zzd(this.zzb, this.zzc, (Bundle) obj);
    }
}
