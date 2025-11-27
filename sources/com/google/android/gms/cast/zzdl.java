package com.google.android.gms.cast;

import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.cast.internal.zzar;
import com.google.android.gms.cast.internal.zzc;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;

@VisibleForTesting
abstract class zzdl extends zzc<RemoteMediaPlayer.MediaChannelResult> {
    private zzar zza;
    protected final WeakReference<GoogleApiClient> zzg;
    final /* synthetic */ RemoteMediaPlayer zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdl(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzh = remoteMediaPlayer;
        this.zzg = new WeakReference<>(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzdk(this, status);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0031 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ void doExecute(com.google.android.gms.common.api.Api.AnyClient r5) {
        /*
            r4 = this;
            com.google.android.gms.cast.internal.zzw r5 = (com.google.android.gms.cast.internal.zzw) r5
            com.google.android.gms.cast.RemoteMediaPlayer r0 = r4.zzh
            java.lang.Object r0 = r0.zza
            monitor-enter(r0)
            java.lang.ref.WeakReference<com.google.android.gms.common.api.GoogleApiClient> r1 = r4.zzg     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x004c }
            com.google.android.gms.common.api.GoogleApiClient r1 = (com.google.android.gms.common.api.GoogleApiClient) r1     // Catch:{ all -> 0x004c }
            r2 = 2100(0x834, float:2.943E-42)
            if (r1 != 0) goto L_0x0024
            com.google.android.gms.common.api.Status r5 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x004c }
            r5.<init>(r2)     // Catch:{ all -> 0x004c }
            com.google.android.gms.cast.zzdk r1 = new com.google.android.gms.cast.zzdk     // Catch:{ all -> 0x004c }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x004c }
            r4.setResult(r1)     // Catch:{ all -> 0x004c }
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            return
        L_0x0024:
            com.google.android.gms.cast.RemoteMediaPlayer r3 = r4.zzh     // Catch:{ all -> 0x004c }
            com.google.android.gms.cast.zzdi r3 = r3.zzc     // Catch:{ all -> 0x004c }
            r3.zzc(r1)     // Catch:{ all -> 0x004c }
            r4.zza(r5)     // Catch:{ IllegalArgumentException -> 0x004a, all -> 0x0031 }
            goto L_0x003e
        L_0x0031:
            com.google.android.gms.common.api.Status r5 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x004c }
            r5.<init>(r2)     // Catch:{ all -> 0x004c }
            com.google.android.gms.cast.zzdk r1 = new com.google.android.gms.cast.zzdk     // Catch:{ all -> 0x004c }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x004c }
            r4.setResult(r1)     // Catch:{ all -> 0x004c }
        L_0x003e:
            com.google.android.gms.cast.RemoteMediaPlayer r5 = r4.zzh     // Catch:{ all -> 0x004c }
            com.google.android.gms.cast.zzdi r5 = r5.zzc     // Catch:{ all -> 0x004c }
            r1 = 0
            r5.zzc(r1)     // Catch:{ all -> 0x004c }
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            return
        L_0x004a:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x004c }
        L_0x004c:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.zzdl.doExecute(com.google.android.gms.common.api.Api$AnyClient):void");
    }

    public abstract void zza(zzw zzw);

    public final zzar zzb() {
        if (this.zza == null) {
            this.zza = new zzdj(this);
        }
        return this.zza;
    }
}
