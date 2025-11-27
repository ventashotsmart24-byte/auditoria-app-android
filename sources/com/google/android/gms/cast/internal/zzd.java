package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@VisibleForTesting
public class zzd extends zzp {
    private final List<zzat> zzb = Collections.synchronizedList(new ArrayList());

    public zzd(String str, String str2, String str3) {
        super(str, "MediaControlChannel", (String) null);
    }

    public final List<zzat> zza() {
        return this.zzb;
    }

    public final void zzb() {
        synchronized (this.zzb) {
            for (zzat zzc : this.zzb) {
                zzc.zzc(CastStatusCodes.CANCELED);
            }
        }
    }

    public final void zzc(zzat zzat) {
        this.zzb.add(zzat);
    }
}
