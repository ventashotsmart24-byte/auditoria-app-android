package com.google.android.gms.internal.measurement;

import android.content.Context;
import javax.annotation.Nullable;

final class zzhc extends zzhz {
    private final Context zza;
    private final zzii zzb;

    public zzhc(Context context, @Nullable zzii zzii) {
        if (context != null) {
            this.zza = context;
            this.zzb = zzii;
            return;
        }
        throw new NullPointerException("Null context");
    }

    public final boolean equals(Object obj) {
        zzii zzii;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzhz) {
            zzhz zzhz = (zzhz) obj;
            if (!this.zza.equals(zzhz.zza()) || ((zzii = this.zzb) != null ? !zzii.equals(zzhz.zzb()) : zzhz.zzb() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzii zzii = this.zzb;
        if (zzii == null) {
            i10 = 0;
        } else {
            i10 = zzii.hashCode();
        }
        return hashCode ^ i10;
    }

    public final String toString() {
        String obj = this.zza.toString();
        String valueOf = String.valueOf(this.zzb);
        return "FlagsContext{context=" + obj + ", hermeticFileOverrides=" + valueOf + "}";
    }

    public final Context zza() {
        return this.zza;
    }

    @Nullable
    public final zzii zzb() {
        return this.zzb;
    }
}
