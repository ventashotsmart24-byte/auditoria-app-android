package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;

public final class zzh {
    /* access modifiers changed from: private */
    public static final Logger zza = new Logger("ApplicationAnalytics");
    /* access modifiers changed from: private */
    public final zzd zzb;
    /* access modifiers changed from: private */
    public final zzj zzc;
    private final Runnable zzd = new zze(this);
    private final Handler zze = new zzco(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final SharedPreferences zzf;
    /* access modifiers changed from: private */
    public zzi zzg;

    public zzh(SharedPreferences sharedPreferences, zzd zzd2, Bundle bundle, String str) {
        this.zzf = sharedPreferences;
        this.zzb = zzd2;
        this.zzc = new zzj(bundle, str);
    }

    public static /* synthetic */ void zzf(zzh zzh) {
        zzi zzi = zzh.zzg;
        if (zzi != null) {
            zzh.zzb.zzb(zzh.zzc.zza(zzi), 223);
        }
        zzh.zzs();
    }

    public static /* bridge */ /* synthetic */ void zzj(zzh zzh, CastSession castSession, int i10) {
        zzh.zzq(castSession);
        zzh.zzb.zzb(zzh.zzc.zze(zzh.zzg, i10), 228);
        zzh.zzp();
        zzh.zzg = null;
    }

    public static /* bridge */ /* synthetic */ void zzk(zzh zzh, SharedPreferences sharedPreferences, String str) {
        if (zzh.zzv(str)) {
            zza.d("Use the existing ApplicationAnalyticsSession if it is available and valid.", new Object[0]);
            Preconditions.checkNotNull(zzh.zzg);
            return;
        }
        zzh.zzg = zzi.zzb(sharedPreferences);
        if (zzh.zzv(str)) {
            zza.d("Use the restored ApplicationAnalyticsSession if it is valid.", new Object[0]);
            Preconditions.checkNotNull(zzh.zzg);
            zzi.zza = zzh.zzg.zzd + 1;
            return;
        }
        zza.d("The restored ApplicationAnalyticsSession is not valid, create a new one.", new Object[0]);
        zzi zza2 = zzi.zza();
        zzh.zzg = zza2;
        zza2.zzb = zzo();
        zzh.zzg.zzf = str;
    }

    private static String zzo() {
        return ((CastContext) Preconditions.checkNotNull(CastContext.getSharedInstance())).getCastOptions().getReceiverApplicationId();
    }

    /* access modifiers changed from: private */
    public final void zzp() {
        this.zze.removeCallbacks(this.zzd);
    }

    /* access modifiers changed from: private */
    public final void zzq(CastSession castSession) {
        CastDevice castDevice;
        if (zzu()) {
            if (castSession != null) {
                castDevice = castSession.getCastDevice();
            } else {
                castDevice = null;
            }
            if (castDevice != null && !TextUtils.equals(this.zzg.zzc, castDevice.zzb())) {
                zzt(castDevice);
            }
            Preconditions.checkNotNull(this.zzg);
            return;
        }
        zza.w("The analyticsSession should not be null for logging. Create a dummy one.", new Object[0]);
        zzr(castSession);
    }

    /* access modifiers changed from: private */
    public final void zzr(CastSession castSession) {
        CastDevice castDevice;
        int i10 = 0;
        zza.d("Create a new ApplicationAnalyticsSession based on CastSession", new Object[0]);
        zzi zza2 = zzi.zza();
        this.zzg = zza2;
        zza2.zzb = zzo();
        if (castSession == null) {
            castDevice = null;
        } else {
            castDevice = castSession.getCastDevice();
        }
        if (castDevice != null) {
            zzt(castDevice);
        }
        Preconditions.checkNotNull(this.zzg);
        zzi zzi = this.zzg;
        if (castSession != null) {
            i10 = castSession.zzk();
        }
        zzi.zzi = i10;
        Preconditions.checkNotNull(this.zzg);
    }

    /* access modifiers changed from: private */
    public final void zzs() {
        ((Handler) Preconditions.checkNotNull(this.zze)).postDelayed((Runnable) Preconditions.checkNotNull(this.zzd), 300000);
    }

    private final void zzt(CastDevice castDevice) {
        zzi zzi = this.zzg;
        if (zzi != null) {
            zzi.zzc = castDevice.zzb();
            zzi.zzg = castDevice.zza();
            zzi.zzh = castDevice.getModelName();
        }
    }

    private final boolean zzu() {
        String str;
        if (this.zzg == null) {
            zza.d("The analytics session is null when matching with application ID.", new Object[0]);
            return false;
        }
        String zzo = zzo();
        if (zzo == null || (str = this.zzg.zzb) == null || !TextUtils.equals(str, zzo)) {
            zza.d("The analytics session doesn't match the application ID %s", zzo);
            return false;
        }
        Preconditions.checkNotNull(this.zzg);
        return true;
    }

    private final boolean zzv(String str) {
        String str2;
        if (!zzu()) {
            return false;
        }
        Preconditions.checkNotNull(this.zzg);
        if (str != null && (str2 = this.zzg.zzf) != null && TextUtils.equals(str2, str)) {
            return true;
        }
        zza.d("The analytics session doesn't match the receiver session ID %s.", str);
        return false;
    }

    public final void zzn(SessionManager sessionManager) {
        sessionManager.addSessionManagerListener(new zzg(this, (zzf) null), CastSession.class);
    }
}
