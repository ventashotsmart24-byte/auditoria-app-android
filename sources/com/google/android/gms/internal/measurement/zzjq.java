package com.google.android.gms.internal.measurement;

import com.hpplay.sdk.source.mdns.xbill.dns.Message;

final class zzjq {
    private final Object zza;
    private final int zzb;

    public zzjq(Object obj, int i10) {
        this.zza = obj;
        this.zzb = i10;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjq)) {
            return false;
        }
        zzjq zzjq = (zzjq) obj;
        if (this.zza == zzjq.zza && this.zzb == zzjq.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * Message.MAXLENGTH) + this.zzb;
    }
}
