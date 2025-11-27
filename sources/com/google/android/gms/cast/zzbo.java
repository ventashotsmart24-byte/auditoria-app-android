package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zza;
import com.google.android.gms.cast.internal.zzaf;
import com.google.android.gms.cast.internal.zzq;
import com.google.android.gms.cast.internal.zzy;
import com.google.android.gms.common.api.Status;

final class zzbo extends zzaf {
    final /* synthetic */ zzbp zza;

    public zzbo(zzbp zzbp) {
        this.zza = zzbp;
    }

    public final void zzb(ApplicationMetadata applicationMetadata, String str, String str2, boolean z10) {
        this.zza.zzp = applicationMetadata;
        this.zza.zzq = str;
        zzbp.zzC(this.zza, new zzq(new Status(0), applicationMetadata, str, str2, z10));
    }

    public final void zzc(int i10) {
        this.zza.zzT(i10);
    }

    public final void zzd(int i10) {
        zzbp.zzE(this.zza, i10);
        if (this.zza.zzx != null) {
            zzbp.zzn(this.zza).post(new zzbh(this, i10));
        }
    }

    public final void zze(int i10) {
        zzbp.zzE(this.zza, i10);
    }

    public final void zzf(zza zza2) {
        zzbp.zzn(this.zza).post(new zzbl(this, zza2));
    }

    public final void zzg(int i10) {
        zzbp.zzE(this.zza, i10);
    }

    public final void zzh(String str, byte[] bArr) {
        zzbp.zzg.d("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
    }

    public final void zzi(int i10) {
        zzbp.zzn(this.zza).post(new zzbi(this, i10));
    }

    public final void zzj(zzy zzy) {
        zzbp.zzn(this.zza).post(new zzbm(this, zzy));
    }

    public final void zzk(int i10) {
        zzbp.zzn(this.zza).post(new zzbj(this, i10));
    }

    public final void zzl(String str, long j10) {
        zzbp.zzD(this.zza, j10, 0);
    }

    public final void zzm(String str, long j10, int i10) {
        zzbp.zzD(this.zza, j10, i10);
    }

    public final void zzn(String str, double d10, boolean z10) {
        zzbp.zzg.d("Deprecated callback: \"onStatusReceived\"", new Object[0]);
    }

    public final void zzo(int i10) {
        zzbp.zzn(this.zza).post(new zzbk(this, i10));
    }

    public final void zzp(String str, String str2) {
        zzbp.zzg.d("Receive (type=text, ns=%s) %s", str, str2);
        zzbp.zzn(this.zza).post(new zzbn(this, str, str2));
    }
}
