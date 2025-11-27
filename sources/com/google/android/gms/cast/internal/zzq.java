package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzq implements Cast.ApplicationConnectionResult {
    private final Status zza;
    private final ApplicationMetadata zzb;
    private final String zzc;
    private final String zzd;
    private final boolean zze;

    public zzq(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z10) {
        this.zza = status;
        this.zzb = applicationMetadata;
        this.zzc = str;
        this.zzd = str2;
        this.zze = z10;
    }

    public final ApplicationMetadata getApplicationMetadata() {
        return this.zzb;
    }

    public final String getApplicationStatus() {
        return this.zzc;
    }

    public final String getSessionId() {
        return this.zzd;
    }

    public final Status getStatus() {
        return this.zza;
    }

    public final boolean getWasLaunched() {
        return this.zze;
    }
}
