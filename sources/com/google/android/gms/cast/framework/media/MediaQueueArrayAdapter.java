package com.google.android.gms.cast.framework.media;

import android.content.Context;
import android.widget.ArrayAdapter;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.media.MediaQueue;

public abstract class MediaQueueArrayAdapter extends ArrayAdapter<MediaQueueItem> {
    private final MediaQueue zza;
    private final MediaQueue.Callback zzb;

    public MediaQueueArrayAdapter(@RecentlyNonNull MediaQueue mediaQueue, @RecentlyNonNull Context context, int i10) {
        super(context, i10);
        this.zza = mediaQueue;
        zzv zzv = new zzv(this, (zzu) null);
        this.zzb = zzv;
        mediaQueue.registerCallback(zzv);
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public void dispose() {
        this.zza.unregisterCallback(this.zzb);
    }

    public int getCount() {
        return this.zza.getItemCount();
    }

    @RecentlyNullable
    public MediaQueueItem getItem(int i10) {
        return this.zza.getItemAtIndex(i10);
    }

    public long getItemId(int i10) {
        return (long) this.zza.itemIdAtIndex(i10);
    }

    @RecentlyNonNull
    public MediaQueue getMediaQueue() {
        return this.zza;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isEmpty() {
        if (this.zza.getItemCount() == 0) {
            return true;
        }
        return false;
    }

    public boolean isEnabled(int i10) {
        if (this.zza.getItemAtIndex(i10, false) != null) {
            return true;
        }
        return false;
    }
}
