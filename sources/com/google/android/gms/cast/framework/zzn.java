package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import java.util.HashSet;

final class zzn extends Cast.Listener {
    final /* synthetic */ CastSession zza;

    public /* synthetic */ zzn(CastSession castSession, zzm zzm) {
        this.zza = castSession;
    }

    public final void onActiveInputStateChanged(int i10) {
        for (Cast.Listener onActiveInputStateChanged : new HashSet(this.zza.zzd)) {
            onActiveInputStateChanged.onActiveInputStateChanged(i10);
        }
    }

    public final void onApplicationDisconnected(int i10) {
        CastSession.zzg(this.zza, i10);
        this.zza.notifySessionEnded(i10);
        for (Cast.Listener onApplicationDisconnected : new HashSet(this.zza.zzd)) {
            onApplicationDisconnected.onApplicationDisconnected(i10);
        }
    }

    public final void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        for (Cast.Listener onApplicationMetadataChanged : new HashSet(this.zza.zzd)) {
            onApplicationMetadataChanged.onApplicationMetadataChanged(applicationMetadata);
        }
    }

    public final void onApplicationStatusChanged() {
        for (Cast.Listener onApplicationStatusChanged : new HashSet(this.zza.zzd)) {
            onApplicationStatusChanged.onApplicationStatusChanged();
        }
    }

    public final void onStandbyStateChanged(int i10) {
        for (Cast.Listener onStandbyStateChanged : new HashSet(this.zza.zzd)) {
            onStandbyStateChanged.onStandbyStateChanged(i10);
        }
    }

    public final void onVolumeChanged() {
        for (Cast.Listener onVolumeChanged : new HashSet(this.zza.zzd)) {
            onVolumeChanged.onVolumeChanged();
        }
    }
}
