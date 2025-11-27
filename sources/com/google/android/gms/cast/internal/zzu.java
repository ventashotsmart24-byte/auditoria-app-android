package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.Cast;

final class zzu implements Runnable {
    final /* synthetic */ zzw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;

    public zzu(zzv zzv, zzw zzw, String str, String str2) {
        this.zza = zzw;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void run() {
        Cast.MessageReceivedCallback messageReceivedCallback;
        synchronized (this.zza.zzk) {
            messageReceivedCallback = (Cast.MessageReceivedCallback) this.zza.zzk.get(this.zzb);
        }
        if (messageReceivedCallback != null) {
            messageReceivedCallback.onMessageReceived(this.zza.zzi, this.zzb, this.zzc);
            return;
        }
        zzw.zze.d("Discarded message for unknown namespace '%s'", this.zzb);
    }
}
