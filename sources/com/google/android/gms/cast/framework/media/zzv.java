package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.MediaQueue;
import java.util.List;

final class zzv extends MediaQueue.Callback {
    final /* synthetic */ MediaQueueArrayAdapter zza;

    public /* synthetic */ zzv(MediaQueueArrayAdapter mediaQueueArrayAdapter, zzu zzu) {
        this.zza = mediaQueueArrayAdapter;
    }

    public final void itemsInsertedInRange(int i10, int i11) {
        this.zza.notifyDataSetChanged();
    }

    public final void itemsReloaded() {
        this.zza.notifyDataSetChanged();
    }

    public final void itemsRemovedAtIndexes(int[] iArr) {
        this.zza.notifyDataSetChanged();
    }

    public final void itemsReorderedAtIndexes(List<Integer> list, int i10) {
        this.zza.notifyDataSetChanged();
    }

    public final void itemsUpdatedAtIndexes(int[] iArr) {
        this.zza.notifyDataSetChanged();
    }

    public final void mediaQueueChanged() {
        this.zza.notifyDataSetChanged();
    }

    public final void mediaQueueWillChange() {
    }
}
