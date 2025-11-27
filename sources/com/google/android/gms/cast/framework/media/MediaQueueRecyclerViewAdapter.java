package com.google.android.gms.cast.framework.media;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.d0;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.media.MediaQueue;

public abstract class MediaQueueRecyclerViewAdapter<VH extends RecyclerView.d0> extends RecyclerView.g {
    private final MediaQueue zza;
    private final MediaQueue.Callback zzb;

    public MediaQueueRecyclerViewAdapter(@RecentlyNonNull MediaQueue mediaQueue) {
        this.zza = mediaQueue;
        zzx zzx = new zzx(this, (zzw) null);
        this.zzb = zzx;
        mediaQueue.registerCallback(zzx);
    }

    public void dispose() {
        this.zza.unregisterCallback(this.zzb);
    }

    @RecentlyNullable
    public MediaQueueItem getItem(int i10) {
        return this.zza.getItemAtIndex(i10);
    }

    public int getItemCount() {
        return this.zza.getItemCount();
    }

    public long getItemId(int i10) {
        return (long) this.zza.itemIdAtIndex(i10);
    }

    @RecentlyNonNull
    public MediaQueue getMediaQueue() {
        return this.zza;
    }
}
