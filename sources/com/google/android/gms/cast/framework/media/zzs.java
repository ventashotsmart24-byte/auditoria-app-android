package com.google.android.gms.cast.framework.media;

import android.util.LruCache;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.common.internal.Preconditions;

final class zzs extends LruCache<Integer, MediaQueueItem> {
    final /* synthetic */ MediaQueue zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzs(MediaQueue mediaQueue, int i10) {
        super(i10);
        this.zza = mediaQueue;
    }

    public final /* bridge */ /* synthetic */ void entryRemoved(boolean z10, Object obj, Object obj2, Object obj3) {
        Integer num = (Integer) obj;
        MediaQueueItem mediaQueueItem = (MediaQueueItem) obj2;
        MediaQueueItem mediaQueueItem2 = (MediaQueueItem) obj3;
        if (z10) {
            Preconditions.checkNotNull(this.zza.zze);
            this.zza.zze.add(num);
        }
    }
}
