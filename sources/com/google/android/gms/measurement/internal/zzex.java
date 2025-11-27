package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import anet.channel.entity.ConnType;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzbr;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.bt;

final class zzex implements Runnable {
    final /* synthetic */ zzbr zza;
    final /* synthetic */ ServiceConnection zzb;
    final /* synthetic */ zzey zzc;

    public zzex(zzey zzey, zzbr zzbr, ServiceConnection serviceConnection) {
        this.zzc = zzey;
        this.zza = zzbr;
        this.zzb = serviceConnection;
    }

    public final void run() {
        zzey zzey = this.zzc;
        zzez zzez = zzey.zza;
        String zza2 = zzey.zzb;
        zzbr zzbr = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        zzez.zza.zzaz().zzg();
        Bundle bundle = new Bundle();
        bundle.putString(bt.f13921o, zza2);
        Bundle bundle2 = null;
        try {
            Bundle zzd = zzbr.zzd(bundle);
            if (zzd == null) {
                zzez.zza.zzay().zzd().zza("Install Referrer Service returned a null response");
            } else {
                bundle2 = zzd;
            }
        } catch (Exception e10) {
            zzez.zza.zzay().zzd().zzb("Exception occurred while retrieving the Install Referrer", e10.getMessage());
        }
        zzez.zza.zzaz().zzg();
        zzfr.zzO();
        if (bundle2 != null) {
            long j10 = bundle2.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j10 == 0) {
                zzez.zza.zzay().zzk().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle2.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzez.zza.zzay().zzd().zza("No referrer defined in Install Referrer response");
                } else {
                    zzez.zza.zzay().zzj().zzb("InstallReferrer API result", string);
                    Bundle zzs = zzez.zza.zzv().zzs(Uri.parse(Operator.Operation.EMPTY_PARAM.concat(string)));
                    if (zzs == null) {
                        zzez.zza.zzay().zzd().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = zzs.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j11 = bundle2.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j11 == 0) {
                                zzez.zza.zzay().zzd().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zzs.putLong("click_timestamp", j11);
                            }
                        }
                        if (j10 == zzez.zza.zzm().zzd.zza()) {
                            zzez.zza.zzay().zzj().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzez.zza.zzJ()) {
                            zzez.zza.zzm().zzd.zzb(j10);
                            zzez.zza.zzay().zzj().zzb("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            zzs.putString("_cis", "referrer API v2");
                            zzez.zza.zzq().zzF(ConnType.PK_AUTO, "_cmp", zzs, zza2);
                        }
                    }
                }
            }
        }
        ConnectionTracker.getInstance().unbindService(zzez.zza.zzau(), serviceConnection);
    }
}
