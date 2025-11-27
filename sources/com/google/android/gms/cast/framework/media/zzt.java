package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.CastUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public final class zzt extends RemoteMediaClient.Callback {
    final /* synthetic */ MediaQueue zza;

    public zzt(MediaQueue mediaQueue) {
        this.zza = mediaQueue;
    }

    public final void onStatusUpdated() {
        long zza2 = this.zza.zzp();
        MediaQueue mediaQueue = this.zza;
        if (zza2 != mediaQueue.zza) {
            mediaQueue.zza = zza2;
            mediaQueue.zzl();
            MediaQueue mediaQueue2 = this.zza;
            if (mediaQueue2.zza != 0) {
                mediaQueue2.zzo();
            }
        }
    }

    public final void zza(int[] iArr) {
        List<Integer> zzf = CastUtils.zzf(iArr);
        if (!this.zza.zzb.equals(zzf)) {
            this.zza.zzx();
            this.zza.zzd.evictAll();
            this.zza.zze.clear();
            MediaQueue mediaQueue = this.zza;
            mediaQueue.zzb = zzf;
            MediaQueue.zzk(mediaQueue);
            this.zza.zzv();
            this.zza.zzu();
        }
    }

    public final void zzb(int[] iArr, int i10) {
        int i11;
        int length = iArr.length;
        if (i10 == 0) {
            i11 = this.zza.zzb.size();
        } else {
            i11 = this.zza.zzc.get(i10, -1);
            if (i11 == -1) {
                this.zza.zzo();
                return;
            }
        }
        this.zza.zzx();
        this.zza.zzb.addAll(i11, CastUtils.zzf(iArr));
        MediaQueue.zzk(this.zza);
        MediaQueue.zze(this.zza, i11, length);
        this.zza.zzu();
    }

    public final void zzc(MediaQueueItem[] mediaQueueItemArr) {
        HashSet hashSet = new HashSet();
        this.zza.zze.clear();
        int length = mediaQueueItemArr.length;
        int i10 = 0;
        while (i10 < length) {
            MediaQueueItem mediaQueueItem = mediaQueueItemArr[i10];
            int itemId = mediaQueueItem.getItemId();
            this.zza.zzd.put(Integer.valueOf(itemId), mediaQueueItem);
            int i11 = this.zza.zzc.get(itemId, -1);
            if (i11 == -1) {
                this.zza.zzo();
                return;
            } else {
                hashSet.add(Integer.valueOf(i11));
                i10++;
            }
        }
        for (Integer intValue : this.zza.zze) {
            int i12 = this.zza.zzc.get(intValue.intValue(), -1);
            if (i12 != -1) {
                hashSet.add(Integer.valueOf(i12));
            }
        }
        this.zza.zze.clear();
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        this.zza.zzx();
        this.zza.zzw(CastUtils.zzi(arrayList));
        this.zza.zzu();
    }

    public final void zzd(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            this.zza.zzd.remove(Integer.valueOf(i10));
            int i11 = this.zza.zzc.get(i10, -1);
            if (i11 == -1) {
                this.zza.zzo();
                return;
            }
            this.zza.zzc.delete(i10);
            arrayList.add(Integer.valueOf(i11));
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            this.zza.zzx();
            this.zza.zzb.removeAll(CastUtils.zzf(iArr));
            MediaQueue.zzk(this.zza);
            MediaQueue.zzf(this.zza, CastUtils.zzi(arrayList));
            this.zza.zzu();
        }
    }

    public final void zze(List<Integer> list, List<Integer> list2, int i10) {
        int i11;
        ArrayList arrayList = new ArrayList();
        if (i10 == 0) {
            i11 = this.zza.zzb.size();
        } else if (list2.isEmpty()) {
            this.zza.zzg.w("Received a Queue Reordered message with an empty reordered items IDs list.", new Object[0]);
            i11 = -1;
        } else {
            i11 = this.zza.zzc.get(i10, -1);
            if (i11 == -1) {
                i11 = this.zza.zzc.get(list2.get(0).intValue(), -1);
            }
        }
        for (Integer intValue : list2) {
            int i12 = this.zza.zzc.get(intValue.intValue(), -1);
            if (i12 == -1) {
                this.zza.zzo();
                return;
            }
            arrayList.add(Integer.valueOf(i12));
        }
        this.zza.zzx();
        MediaQueue mediaQueue = this.zza;
        mediaQueue.zzb = list;
        MediaQueue.zzk(mediaQueue);
        MediaQueue.zzg(this.zza, arrayList, i11);
        this.zza.zzu();
    }

    public final void zzf(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = iArr[i10];
            this.zza.zzd.remove(Integer.valueOf(i11));
            int i12 = this.zza.zzc.get(i11, -1);
            if (i12 == -1) {
                this.zza.zzo();
                return;
            } else {
                arrayList.add(Integer.valueOf(i12));
                i10++;
            }
        }
        Collections.sort(arrayList);
        this.zza.zzx();
        this.zza.zzw(CastUtils.zzi(arrayList));
        this.zza.zzu();
    }

    public final void zzg() {
        this.zza.zzo();
    }
}
