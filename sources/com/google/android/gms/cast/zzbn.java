package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;

public final /* synthetic */ class zzbn implements Runnable {
    public final /* synthetic */ zzbo zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzbn(zzbo zzbo, String str, String str2) {
        this.zza = zzbo;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void run() {
        Cast.MessageReceivedCallback messageReceivedCallback;
        zzbo zzbo = this.zza;
        String str = this.zzb;
        String str2 = this.zzc;
        synchronized (zzbo.zza.zze) {
            messageReceivedCallback = zzbo.zza.zze.get(str);
        }
        if (messageReceivedCallback != null) {
            messageReceivedCallback.onMessageReceived(zzbo.zza.zzw, str, str2);
            return;
        }
        zzbp.zzg.d("Discarded message for unknown namespace '%s'", str);
    }
}
