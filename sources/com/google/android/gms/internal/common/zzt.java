package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;

final class zzt extends zzw {
    final /* synthetic */ zzu zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzt(zzu zzu, zzx zzx, CharSequence charSequence) {
        super(zzx, charSequence);
        this.zza = zzu;
    }

    public final int zzc(int i10) {
        return i10 + 1;
    }

    public final int zzd(int i10) {
        zzo zzo = this.zza.zza;
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzs.zzb(i10, length, FirebaseAnalytics.Param.INDEX);
        while (i10 < length) {
            if (zzo.zza(charSequence.charAt(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }
}
