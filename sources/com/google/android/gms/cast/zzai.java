package com.google.android.gms.cast;

import android.view.Display;
import com.google.android.gms.tasks.OnCompleteListener;

final class zzai implements OnCompleteListener<Display> {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    public zzai(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.zza = castRemoteDisplayLocalService;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        com.google.android.gms.cast.CastRemoteDisplayLocalService.zzl(r4.zza, r5.getResult());
        com.google.android.gms.cast.CastRemoteDisplayLocalService.zzd.set(false);
        r5 = r4.zza.zzo;
        r0 = r4.zza.zzp;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
        if (r5 == null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0061, code lost:
        if (r0 == null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        com.google.android.gms.common.stats.ConnectionTracker.getInstance().unbindService(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
        com.google.android.gms.cast.CastRemoteDisplayLocalService.zza.d("No need to unbind service, already unbound", new java.lang.Object[0]);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onComplete(com.google.android.gms.tasks.Task<android.view.Display> r5) {
        /*
            r4 = this;
            boolean r0 = r5.isSuccessful()
            r1 = 0
            if (r0 != 0) goto L_0x0018
            com.google.android.gms.cast.internal.Logger r5 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zza
            java.lang.String r0 = "Connection was not successful"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r5.e(r0, r1)
            com.google.android.gms.cast.CastRemoteDisplayLocalService r5 = r4.zza
            com.google.android.gms.cast.CastRemoteDisplayLocalService.zzo(r5)
            return
        L_0x0018:
            com.google.android.gms.cast.internal.Logger r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zza
            java.lang.String r2 = "startRemoteDisplay successful"
            java.lang.Object[] r3 = new java.lang.Object[r1]
            r0.d(r2, r3)
            java.lang.Object r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzc
            monitor-enter(r0)
            com.google.android.gms.cast.CastRemoteDisplayLocalService r2 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zze     // Catch:{ all -> 0x0082 }
            if (r2 != 0) goto L_0x0040
            com.google.android.gms.cast.internal.Logger r5 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zza     // Catch:{ all -> 0x0082 }
            java.lang.String r2 = "Remote Display started but session already cancelled"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0082 }
            r5.d(r2, r1)     // Catch:{ all -> 0x0082 }
            com.google.android.gms.cast.CastRemoteDisplayLocalService r5 = r4.zza     // Catch:{ all -> 0x0082 }
            com.google.android.gms.cast.CastRemoteDisplayLocalService.zzo(r5)     // Catch:{ all -> 0x0082 }
            monitor-exit(r0)     // Catch:{ all -> 0x0082 }
            return
        L_0x0040:
            monitor-exit(r0)     // Catch:{ all -> 0x0082 }
            java.lang.Object r5 = r5.getResult()
            android.view.Display r5 = (android.view.Display) r5
            com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = r4.zza
            com.google.android.gms.cast.CastRemoteDisplayLocalService.zzl(r0, r5)
            java.util.concurrent.atomic.AtomicBoolean r5 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzd
            r5.set(r1)
            com.google.android.gms.cast.CastRemoteDisplayLocalService r5 = r4.zza
            android.content.Context r5 = r5.zzo
            com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = r4.zza
            android.content.ServiceConnection r0 = r0.zzp
            if (r5 == 0) goto L_0x0076
            if (r0 == 0) goto L_0x0076
            com.google.android.gms.common.stats.ConnectionTracker r2 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ IllegalArgumentException -> 0x006b }
            r2.unbindService(r5, r0)     // Catch:{ IllegalArgumentException -> 0x006b }
            goto L_0x0076
        L_0x006b:
            com.google.android.gms.cast.internal.Logger r5 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zza
            java.lang.String r0 = "No need to unbind service, already unbound"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r5.d(r0, r1)
        L_0x0076:
            com.google.android.gms.cast.CastRemoteDisplayLocalService r5 = r4.zza
            r0 = 0
            r5.zzp = null
            com.google.android.gms.cast.CastRemoteDisplayLocalService r5 = r4.zza
            r5.zzo = null
            return
        L_0x0082:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0082 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.zzai.onComplete(com.google.android.gms.tasks.Task):void");
    }
}
