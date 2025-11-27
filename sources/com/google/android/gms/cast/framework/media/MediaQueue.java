package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import android.util.SparseIntArray;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzco;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;

public class MediaQueue {
    long zza;
    List<Integer> zzb;
    final SparseIntArray zzc;
    LruCache<Integer, MediaQueueItem> zzd;
    final List<Integer> zze;
    final Deque<Integer> zzf;
    /* access modifiers changed from: private */
    public final Logger zzg = new Logger("MediaQueue");
    private final RemoteMediaClient zzh;
    private final int zzi;
    private final Handler zzj;
    private TimerTask zzk;
    private PendingResult<RemoteMediaClient.MediaChannelResult> zzl;
    private PendingResult<RemoteMediaClient.MediaChannelResult> zzm;
    private Set<Callback> zzn = new HashSet();

    public static abstract class Callback {
        public void itemsInsertedInRange(int i10, int i11) {
        }

        public void itemsReloaded() {
        }

        public void itemsRemovedAtIndexes(@RecentlyNonNull int[] iArr) {
        }

        public void itemsReorderedAtIndexes(@RecentlyNonNull List<Integer> list, int i10) {
        }

        public void itemsUpdatedAtIndexes(@RecentlyNonNull int[] iArr) {
        }

        public void mediaQueueChanged() {
        }

        public void mediaQueueWillChange() {
        }
    }

    public MediaQueue(RemoteMediaClient remoteMediaClient, int i10, int i11) {
        this.zzh = remoteMediaClient;
        this.zzi = Math.max(20, 1);
        this.zzb = new ArrayList();
        this.zzc = new SparseIntArray();
        this.zze = new ArrayList();
        this.zzf = new ArrayDeque(20);
        this.zzj = new zzco(Looper.getMainLooper());
        this.zzk = new zzr(this);
        remoteMediaClient.registerCallback(new zzt(this));
        zzt(20);
        this.zza = zzp();
        zzo();
    }

    public static /* bridge */ /* synthetic */ void zze(MediaQueue mediaQueue, int i10, int i11) {
        for (Callback itemsInsertedInRange : mediaQueue.zzn) {
            itemsInsertedInRange.itemsInsertedInRange(i10, i11);
        }
    }

    public static /* bridge */ /* synthetic */ void zzf(MediaQueue mediaQueue, int[] iArr) {
        for (Callback itemsRemovedAtIndexes : mediaQueue.zzn) {
            itemsRemovedAtIndexes.itemsRemovedAtIndexes(iArr);
        }
    }

    public static /* bridge */ /* synthetic */ void zzg(MediaQueue mediaQueue, List list, int i10) {
        for (Callback itemsReorderedAtIndexes : mediaQueue.zzn) {
            itemsReorderedAtIndexes.itemsReorderedAtIndexes(list, i10);
        }
    }

    public static /* bridge */ /* synthetic */ void zzj(MediaQueue mediaQueue) {
        if (!mediaQueue.zzf.isEmpty() && mediaQueue.zzl == null && mediaQueue.zza != 0) {
            PendingResult<RemoteMediaClient.MediaChannelResult> zzh2 = mediaQueue.zzh.zzh(CastUtils.zzi(mediaQueue.zzf));
            mediaQueue.zzl = zzh2;
            zzh2.setResultCallback(new zzq(mediaQueue));
            mediaQueue.zzf.clear();
        }
    }

    public static /* bridge */ /* synthetic */ void zzk(MediaQueue mediaQueue) {
        mediaQueue.zzc.clear();
        for (int i10 = 0; i10 < mediaQueue.zzb.size(); i10++) {
            mediaQueue.zzc.put(mediaQueue.zzb.get(i10).intValue(), i10);
        }
    }

    /* access modifiers changed from: private */
    public final long zzp() {
        MediaStatus mediaStatus = this.zzh.getMediaStatus();
        if (mediaStatus == null || mediaStatus.zzd()) {
            return 0;
        }
        return mediaStatus.zzb();
    }

    private final void zzq() {
        this.zzj.removeCallbacks(this.zzk);
    }

    private final void zzr() {
        PendingResult<RemoteMediaClient.MediaChannelResult> pendingResult = this.zzm;
        if (pendingResult != null) {
            pendingResult.cancel();
            this.zzm = null;
        }
    }

    private final void zzs() {
        PendingResult<RemoteMediaClient.MediaChannelResult> pendingResult = this.zzl;
        if (pendingResult != null) {
            pendingResult.cancel();
            this.zzl = null;
        }
    }

    private final void zzt(int i10) {
        this.zzd = new zzs(this, i10);
    }

    /* access modifiers changed from: private */
    public final void zzu() {
        for (Callback mediaQueueChanged : this.zzn) {
            mediaQueueChanged.mediaQueueChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void zzv() {
        for (Callback itemsReloaded : this.zzn) {
            itemsReloaded.itemsReloaded();
        }
    }

    /* access modifiers changed from: private */
    public final void zzw(int[] iArr) {
        for (Callback itemsUpdatedAtIndexes : this.zzn) {
            itemsUpdatedAtIndexes.itemsUpdatedAtIndexes(iArr);
        }
    }

    /* access modifiers changed from: private */
    public final void zzx() {
        for (Callback mediaQueueWillChange : this.zzn) {
            mediaQueueWillChange.mediaQueueWillChange();
        }
    }

    private final void zzy() {
        zzq();
        this.zzj.postDelayed(this.zzk, 500);
    }

    @RecentlyNonNull
    public PendingResult<RemoteMediaClient.MediaChannelResult> fetchMoreItemsRelativeToIndex(int i10, int i11, int i12) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (this.zza == 0) {
            return RemoteMediaClient.zzd(2100, "No active media session");
        }
        int itemIdAtIndex = itemIdAtIndex(i10);
        if (itemIdAtIndex == 0) {
            return RemoteMediaClient.zzd(CastStatusCodes.INVALID_REQUEST, "index out of bound");
        }
        return this.zzh.zzf(itemIdAtIndex, i11, i12);
    }

    @RecentlyNullable
    public MediaQueueItem getItemAtIndex(int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return getItemAtIndex(i10, true);
    }

    public int getItemCount() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzb.size();
    }

    @RecentlyNonNull
    public int[] getItemIds() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return CastUtils.zzi(this.zzb);
    }

    public int indexOfItemWithId(int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzc.get(i10, -1);
    }

    public int itemIdAtIndex(int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (i10 < 0 || i10 >= this.zzb.size()) {
            return 0;
        }
        return this.zzb.get(i10).intValue();
    }

    public void registerCallback(@RecentlyNonNull Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzn.add(callback);
    }

    public void setCacheCapacity(int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        LruCache<Integer, MediaQueueItem> lruCache = this.zzd;
        ArrayList arrayList = new ArrayList();
        zzt(i10);
        int size = lruCache.size();
        for (Map.Entry next : lruCache.snapshot().entrySet()) {
            if (size > i10) {
                int i11 = this.zzc.get(((Integer) next.getKey()).intValue(), -1);
                if (i11 != -1) {
                    arrayList.add(Integer.valueOf(i11));
                }
            } else {
                this.zzd.put((Integer) next.getKey(), (MediaQueueItem) next.getValue());
            }
            size--;
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            zzx();
            zzw(CastUtils.zzi(arrayList));
            zzu();
        }
    }

    public void unregisterCallback(@RecentlyNonNull Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzn.remove(callback);
    }

    public final void zzl() {
        zzx();
        this.zzb.clear();
        this.zzc.clear();
        this.zzd.evictAll();
        this.zze.clear();
        zzq();
        this.zzf.clear();
        zzr();
        zzs();
        zzv();
        zzu();
    }

    public final void zzm(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
        Status status = mediaChannelResult.getStatus();
        int statusCode = status.getStatusCode();
        if (statusCode != 0) {
            this.zzg.w(String.format("Error fetching queue item ids, statusCode=%s, statusMessage=%s", new Object[]{Integer.valueOf(statusCode), status.getStatusMessage()}), new Object[0]);
        }
        this.zzm = null;
        if (!this.zzf.isEmpty()) {
            zzy();
        }
    }

    public final void zzn(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
        Status status = mediaChannelResult.getStatus();
        int statusCode = status.getStatusCode();
        if (statusCode != 0) {
            this.zzg.w(String.format("Error fetching queue items, statusCode=%s, statusMessage=%s", new Object[]{Integer.valueOf(statusCode), status.getStatusMessage()}), new Object[0]);
        }
        this.zzl = null;
        if (!this.zzf.isEmpty()) {
            zzy();
        }
    }

    public final void zzo() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (this.zza != 0 && this.zzm == null) {
            zzr();
            zzs();
            PendingResult<RemoteMediaClient.MediaChannelResult> zzg2 = this.zzh.zzg();
            this.zzm = zzg2;
            zzg2.setResultCallback(new zzp(this));
        }
    }

    @RecentlyNullable
    public MediaQueueItem getItemAtIndex(int i10, boolean z10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (i10 < 0 || i10 >= this.zzb.size()) {
            return null;
        }
        int intValue = this.zzb.get(i10).intValue();
        LruCache<Integer, MediaQueueItem> lruCache = this.zzd;
        Integer valueOf = Integer.valueOf(intValue);
        MediaQueueItem mediaQueueItem = lruCache.get(valueOf);
        if (mediaQueueItem == null && z10 && !this.zzf.contains(valueOf)) {
            while (this.zzf.size() >= this.zzi) {
                this.zzf.removeFirst();
            }
            this.zzf.add(Integer.valueOf(intValue));
            zzy();
        }
        return mediaQueueItem;
    }
}
