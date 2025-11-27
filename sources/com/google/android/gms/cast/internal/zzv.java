package com.google.android.gms.cast.internal;

import android.os.Handler;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.cast.zzco;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
final class zzv extends zzaf {
    private final AtomicReference<zzw> zza;
    private final Handler zzb;

    public zzv(zzw zzw) {
        this.zza = new AtomicReference<>(zzw);
        this.zzb = new zzco(zzw.getLooper());
    }

    public final void zzb(ApplicationMetadata applicationMetadata, String str, String str2, boolean z10) {
        zzw zzw = this.zza.get();
        if (zzw != null) {
            zzw.zzh = applicationMetadata;
            zzw.zzy = applicationMetadata.getApplicationId();
            zzw.zzz = str2;
            zzw.zzo = str;
            synchronized (zzw.zzf) {
                if (zzw.zzC != null) {
                    zzw.zzC.setResult(new zzq(new Status(0), applicationMetadata, str, str2, z10));
                    zzw.zzC = null;
                }
            }
        }
    }

    public final void zzc(int i10) {
        zzw zzw = this.zza.get();
        if (zzw != null) {
            zzw.zzR(i10);
        }
    }

    public final void zzd(int i10) {
        zzw zzw = this.zza.get();
        if (zzw != null) {
            zzw.zzy = null;
            zzw.zzz = null;
            zzw.zzab(i10);
            if (zzw.zzj != null) {
                this.zzb.post(new zzr(this, zzw, i10));
            }
        }
    }

    public final void zze(int i10) {
        zzw zzw = this.zza.get();
        if (zzw != null) {
            zzw.zzab(i10);
        }
    }

    public final void zzf(zza zza2) {
        zzw zzw = this.zza.get();
        if (zzw != null) {
            zzw.zze.d("onApplicationStatusChanged", new Object[0]);
            this.zzb.post(new zzt(this, zzw, zza2));
        }
    }

    public final void zzg(int i10) {
        zzw zzw = this.zza.get();
        if (zzw != null) {
            zzw.zzab(i10);
        }
    }

    public final void zzh(String str, byte[] bArr) {
        if (this.zza.get() != null) {
            zzw.zze.d("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
        }
    }

    public final void zzi(int i10) {
    }

    public final void zzj(zzy zzy) {
        zzw zzw = this.zza.get();
        if (zzw != null) {
            zzw.zze.d("onDeviceStatusChanged", new Object[0]);
            this.zzb.post(new zzs(this, zzw, zzy));
        }
    }

    public final void zzk(int i10) {
        zzw zzq = zzq();
        if (zzq != null) {
            zzw.zze.d("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i10));
            if (i10 != 0) {
                zzq.triggerConnectionSuspended(2);
            }
        }
    }

    public final void zzl(String str, long j10) {
        zzw zzw = this.zza.get();
        if (zzw != null) {
            zzw.zzaa(j10, 0);
        }
    }

    public final void zzm(String str, long j10, int i10) {
        zzw zzw = this.zza.get();
        if (zzw != null) {
            zzw.zzaa(j10, i10);
        }
    }

    public final void zzn(String str, double d10, boolean z10) {
        zzw.zze.d("Deprecated callback: \"onStatusreceived\"", new Object[0]);
    }

    public final void zzo(int i10) {
    }

    public final void zzp(String str, String str2) {
        zzw zzw = this.zza.get();
        if (zzw != null) {
            zzw.zze.d("Receive (type=text, ns=%s) %s", str, str2);
            this.zzb.post(new zzu(this, zzw, str, str2));
        }
    }

    public final zzw zzq() {
        zzw andSet = this.zza.getAndSet((Object) null);
        if (andSet == null) {
            return null;
        }
        andSet.zzY();
        return andSet;
    }

    public final boolean zzr() {
        if (this.zza.get() == null) {
            return true;
        }
        return false;
    }
}
