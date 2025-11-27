package com.google.android.gms.cast.framework.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzcn;
import o.l1;

final class zzl extends BroadcastReceiver {
    final /* synthetic */ MediaNotificationService zza;

    public zzl(MediaNotificationService mediaNotificationService) {
        this.zza = mediaNotificationService;
    }

    public final void onReceive(Context context, Intent intent) {
        PendingIntent pendingIntent;
        ComponentName componentName = (ComponentName) Preconditions.checkNotNull((ComponentName) intent.getParcelableExtra("targetActivity"));
        Intent intent2 = new Intent();
        intent2.setComponent(componentName);
        if (this.zza.zzq.zzf()) {
            intent2.setFlags(603979776);
            pendingIntent = zzcn.zza(context, 1, intent2, zzcn.zza | 134217728);
        } else {
            l1 d10 = l1.d(this.zza);
            d10.c(componentName);
            d10.a(intent2);
            pendingIntent = d10.e(1, zzcn.zza | 134217728);
        }
        try {
            ((PendingIntent) Preconditions.checkNotNull(pendingIntent)).send(context, 1, new Intent().setFlags(268435456));
        } catch (PendingIntent.CanceledException e10) {
            MediaNotificationService.zza.d(e10, "Sending PendingIntent failed", new Object[0]);
        }
    }
}
