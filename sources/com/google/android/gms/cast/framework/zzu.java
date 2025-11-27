package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;
import java.util.Map;

public final class zzu extends zza implements zzw {
    public zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ICastContext");
    }

    public final Bundle zze() {
        Parcel zzb = zzb(1, zza());
        Bundle bundle = (Bundle) zzc.zza(zzb, Bundle.CREATOR);
        zzb.recycle();
        return bundle;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.cast.framework.zzad zzf() {
        /*
            r4 = this;
            r0 = 6
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.cast.framework.IDiscoveryManager"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.cast.framework.zzad
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.cast.framework.zzad r1 = (com.google.android.gms.cast.framework.zzad) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.cast.framework.zzac r2 = new com.google.android.gms.cast.framework.zzac
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.zzu.zzf():com.google.android.gms.cast.framework.zzad");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.cast.framework.zzal zzg() {
        /*
            r4 = this;
            r0 = 5
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzb(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.cast.framework.ISessionManager"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.cast.framework.zzal
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.cast.framework.zzal r1 = (com.google.android.gms.cast.framework.zzal) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.cast.framework.zzak r2 = new com.google.android.gms.cast.framework.zzak
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.zzu.zzg():com.google.android.gms.cast.framework.zzal");
    }

    public final void zzh(String str, Map map) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeMap(map);
        zzc(11, zza);
    }

    public final boolean zzi() {
        Parcel zzb = zzb(12, zza());
        boolean zzf = zzc.zzf(zzb);
        zzb.recycle();
        return zzf;
    }
}
