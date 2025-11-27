package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.common.internal.Objects;

public final class zze {
    public int zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public boolean zzf;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        zze zze2 = (zze) obj;
        if (this.zza == zze2.zza && this.zzb == zze2.zzb && this.zzc == zze2.zzc && this.zzd == zze2.zzd && this.zze == zze2.zze && this.zzf == zze2.zzf) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Boolean.valueOf(this.zzf));
    }
}
