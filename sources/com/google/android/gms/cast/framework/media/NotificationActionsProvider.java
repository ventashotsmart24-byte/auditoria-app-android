package com.google.android.gms.cast.framework.media;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import java.util.List;

public abstract class NotificationActionsProvider {
    private final Context zza;
    private final zzg zzb = new zzaa(this, (zzz) null);

    public NotificationActionsProvider(@RecentlyNonNull Context context) {
        this.zza = context.getApplicationContext();
    }

    @RecentlyNonNull
    public Context getApplicationContext() {
        return this.zza;
    }

    @RecentlyNonNull
    public abstract int[] getCompactViewActionIndices();

    @RecentlyNonNull
    public abstract List<NotificationAction> getNotificationActions();

    public final zzg zza() {
        return this.zzb;
    }
}
