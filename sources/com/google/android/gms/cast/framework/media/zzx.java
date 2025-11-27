package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.MediaQueue;
import java.util.List;

final class zzx extends MediaQueue.Callback {
    final /* synthetic */ MediaQueueRecyclerViewAdapter zza;

    public /* synthetic */ zzx(MediaQueueRecyclerViewAdapter mediaQueueRecyclerViewAdapter, zzw zzw) {
        this.zza = mediaQueueRecyclerViewAdapter;
    }

    public final void itemsInsertedInRange(int i10, int i11) {
        this.zza.notifyItemRangeInserted(i10, i11);
    }

    public final void itemsReloaded() {
        this.zza.notifyDataSetChanged();
    }

    public final void itemsRemovedAtIndexes(int[] iArr) {
        int length = iArr.length;
        if (length <= 1) {
            for (int i10 = 0; i10 < length; i10 = 1) {
                this.zza.notifyItemRemoved(iArr[0]);
            }
            return;
        }
        this.zza.notifyDataSetChanged();
    }

    public final void itemsReorderedAtIndexes(List<Integer> list, int i10) {
        this.zza.notifyDataSetChanged();
    }

    public final void itemsUpdatedAtIndexes(int[] iArr) {
        for (int notifyItemChanged : iArr) {
            this.zza.notifyItemChanged(notifyItemChanged);
        }
    }

    public final void mediaQueueChanged() {
    }

    public final void mediaQueueWillChange() {
    }
}
