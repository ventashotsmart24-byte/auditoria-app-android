package com.google.android.gms.cast;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.cast.zzcf;
import com.google.android.gms.internal.cast.zzck;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzw implements RemoteCall {
    public final /* synthetic */ CastRemoteDisplayClient zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ PendingIntent zzc;
    public final /* synthetic */ CastDevice zzd;
    public final /* synthetic */ String zze;
    public final /* synthetic */ zzah zzf;

    public /* synthetic */ zzw(CastRemoteDisplayClient castRemoteDisplayClient, int i10, zzah zzah, PendingIntent pendingIntent, CastDevice castDevice, String str, byte[] bArr) {
        this.zza = castRemoteDisplayClient;
        this.zzb = i10;
        this.zzf = zzah;
        this.zzc = pendingIntent;
        this.zzd = castDevice;
        this.zze = str;
    }

    public final void accept(Object obj, Object obj2) {
        CastRemoteDisplayClient castRemoteDisplayClient = this.zza;
        int i10 = this.zzb;
        zzah zzah = this.zzf;
        PendingIntent pendingIntent = this.zzc;
        CastDevice castDevice = this.zzd;
        String str = this.zze;
        zzcf zzcf = (zzcf) obj;
        Bundle bundle = new Bundle();
        bundle.putInt("configuration", i10);
        ((zzck) zzcf.getService()).zzh(new zzy(castRemoteDisplayClient, (TaskCompletionSource) obj2, zzcf, zzah, (byte[]) null), pendingIntent, castDevice.getDeviceId(), str, bundle);
    }
}
