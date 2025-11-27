package com.google.android.gms.measurement.internal;

import android.util.Log;
import com.hpplay.cybergarage.soap.SOAP;

final class zzee implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzeh zzf;

    public zzee(zzeh zzeh, int i10, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzeh;
        this.zza = i10;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    public final void run() {
        zzew zzm = this.zzf.zzt.zzm();
        if (zzm.zzx()) {
            zzeh zzeh = this.zzf;
            if (zzeh.zza == 0) {
                if (zzeh.zzt.zzf().zzy()) {
                    zzeh zzeh2 = this.zzf;
                    zzeh2.zzt.zzaw();
                    zzeh2.zza = 'C';
                } else {
                    zzeh zzeh3 = this.zzf;
                    zzeh3.zzt.zzaw();
                    zzeh3.zza = 'c';
                }
            }
            zzeh zzeh4 = this.zzf;
            if (zzeh4.zzb < 0) {
                zzeh4.zzt.zzf().zzh();
                zzeh4.zzb = 74029;
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            zzeh zzeh5 = this.zzf;
            String str = "2" + charAt + zzeh5.zza + zzeh5.zzb + SOAP.DELIM + zzeh.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
            if (str.length() > 1024) {
                str = this.zzb.substring(0, 1024);
            }
            zzeu zzeu = zzm.zzb;
            if (zzeu != null) {
                zzeu.zzb(str, 1);
                return;
            }
            return;
        }
        Log.println(6, this.zzf.zzq(), "Persisted config not initialized. Not logging error/warn");
    }
}
