package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import anet.channel.entity.ConnType;

final class zzhw implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzhx zza;

    public /* synthetic */ zzhw(zzhx zzhx, zzhv zzhv) {
        this.zza = zzhx;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzfr zzfr;
        boolean z10;
        String str;
        try {
            this.zza.zzt.zzay().zzj().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                zzfr = this.zza.zzt;
            } else {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.zza.zzt.zzv();
                        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        boolean z11 = true;
                        if ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (true != z10) {
                            str = ConnType.PK_AUTO;
                        } else {
                            str = "gs";
                        }
                        String str2 = str;
                        String queryParameter = data.getQueryParameter("referrer");
                        if (bundle != null) {
                            z11 = false;
                        }
                        this.zza.zzt.zzaz().zzp(new zzhu(this, z11, data, str2, queryParameter));
                        zzfr = this.zza.zzt;
                    }
                }
                zzfr = this.zza.zzt;
            }
        } catch (RuntimeException e10) {
            this.zza.zzt.zzay().zzd().zzb("Throwable caught in onActivityCreated", e10);
            zzfr = this.zza.zzt;
        } catch (Throwable th) {
            this.zza.zzt.zzs().zzr(activity, bundle);
            throw th;
        }
        zzfr.zzs().zzr(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzt.zzs().zzs(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzt.zzs().zzt(activity);
        zzkc zzu = this.zza.zzt.zzu();
        zzu.zzt.zzaz().zzp(new zzjv(zzu, zzu.zzt.zzav().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        zzkc zzu = this.zza.zzt.zzu();
        zzu.zzt.zzaz().zzp(new zzju(zzu, zzu.zzt.zzav().elapsedRealtime()));
        this.zza.zzt.zzs().zzu(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzt.zzs().zzv(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
