package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzbt;
import e1.v;

public final class zzkf extends zzkh {
    private final AlarmManager zza = ((AlarmManager) this.zzt.zzau().getSystemService("alarm"));
    private zzap zzb;
    private Integer zzc;

    public zzkf(zzkt zzkt) {
        super(zzkt);
    }

    private final int zzf() {
        if (this.zzc == null) {
            this.zzc = Integer.valueOf("measurement".concat(String.valueOf(this.zzt.zzau().getPackageName())).hashCode());
        }
        return this.zzc.intValue();
    }

    private final PendingIntent zzh() {
        Context zzau = this.zzt.zzau();
        return PendingIntent.getBroadcast(zzau, 0, new Intent().setClassName(zzau, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), zzbs.zza);
    }

    private final zzap zzi() {
        if (this.zzb == null) {
            this.zzb = new zzke(this, this.zzf.zzq());
        }
        return this.zzb;
    }

    private final void zzj() {
        JobScheduler a10 = v.a(this.zzt.zzau().getSystemService("jobscheduler"));
        if (a10 != null) {
            a10.cancel(zzf());
        }
    }

    public final void zza() {
        zzW();
        this.zzt.zzay().zzj().zza("Unscheduling upload");
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzh());
        }
        zzi().zzb();
        if (Build.VERSION.SDK_INT >= 24) {
            zzj();
        }
    }

    public final boolean zzb() {
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzh());
        }
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        zzj();
        return false;
    }

    public final void zzd(long j10) {
        zzW();
        this.zzt.zzaw();
        Context zzau = this.zzt.zzau();
        if (!zzlb.zzaj(zzau)) {
            this.zzt.zzay().zzc().zza("Receiver not registered/enabled");
        }
        if (!zzlb.zzak(zzau, false)) {
            this.zzt.zzay().zzc().zza("Service not registered/enabled");
        }
        zza();
        this.zzt.zzay().zzj().zzb("Scheduling upload, millis", Long.valueOf(j10));
        long elapsedRealtime = this.zzt.zzav().elapsedRealtime() + j10;
        this.zzt.zzf();
        if (j10 < Math.max(0, ((Long) zzdu.zzw.zza((Object) null)).longValue()) && !zzi().zze()) {
            zzi().zzd(j10);
        }
        this.zzt.zzaw();
        if (Build.VERSION.SDK_INT >= 24) {
            Context zzau2 = this.zzt.zzau();
            ComponentName componentName = new ComponentName(zzau2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int zzf = zzf();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            zzbt.zza(zzau2, new JobInfo.Builder(zzf, componentName).setMinimumLatency(j10).setOverrideDeadline(j10 + j10).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
            return;
        }
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            this.zzt.zzf();
            alarmManager.setInexactRepeating(2, elapsedRealtime, Math.max(((Long) zzdu.zzr.zza((Object) null)).longValue(), j10), zzh());
        }
    }
}
