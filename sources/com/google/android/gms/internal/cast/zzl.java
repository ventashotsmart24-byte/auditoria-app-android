package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class zzl {
    private static final Logger zza = new Logger("FeatureUsageAnalytics");
    private static final String zzb = "20.1.0";
    private static zzl zzc;
    private final zzd zzd;
    private final SharedPreferences zze;
    private final String zzf;
    private final Runnable zzg = new zzk(this);
    private final Handler zzh = new zzco(Looper.getMainLooper());
    private final Set<zzju> zzi;
    private final Set<zzju> zzj;
    private long zzk;

    private zzl(SharedPreferences sharedPreferences, zzd zzd2, String str) {
        this.zze = sharedPreferences;
        this.zzd = zzd2;
        this.zzf = str;
        HashSet hashSet = new HashSet();
        this.zzi = hashSet;
        HashSet hashSet2 = new HashSet();
        this.zzj = hashSet2;
        String string = sharedPreferences.getString("feature_usage_sdk_version", (String) null);
        String string2 = sharedPreferences.getString("feature_usage_package_name", (String) null);
        hashSet.clear();
        hashSet2.clear();
        this.zzk = 0;
        if (!zzb.equals(string) || !str.equals(string2)) {
            HashSet hashSet3 = new HashSet();
            for (String next : sharedPreferences.getAll().keySet()) {
                if (next.startsWith("feature_usage_timestamp_")) {
                    hashSet3.add(next);
                }
            }
            hashSet3.add("feature_usage_last_report_time");
            zzh(hashSet3);
            this.zze.edit().putString("feature_usage_sdk_version", zzb).putString("feature_usage_package_name", this.zzf).apply();
            return;
        }
        this.zzk = sharedPreferences.getLong("feature_usage_last_report_time", 0);
        long zze2 = zze();
        HashSet hashSet4 = new HashSet();
        for (String next2 : sharedPreferences.getAll().keySet()) {
            if (next2.startsWith("feature_usage_timestamp_")) {
                long j10 = this.zze.getLong(next2, 0);
                if (j10 != 0 && zze2 - j10 > 1209600000) {
                    hashSet4.add(next2);
                } else if (next2.startsWith("feature_usage_timestamp_reported_feature_")) {
                    zzju zzf2 = zzf(next2.substring(41));
                    this.zzj.add(zzf2);
                    this.zzi.add(zzf2);
                } else if (next2.startsWith("feature_usage_timestamp_detected_feature_")) {
                    this.zzi.add(zzf(next2.substring(41)));
                }
            }
        }
        zzh(hashSet4);
        Preconditions.checkNotNull(this.zzh);
        Preconditions.checkNotNull(this.zzg);
        zzi();
    }

    public static synchronized zzl zza(SharedPreferences sharedPreferences, zzd zzd2, String str) {
        zzl zzl;
        synchronized (zzl.class) {
            if (zzc == null) {
                zzc = new zzl(sharedPreferences, zzd2, str);
            }
            zzl = zzc;
        }
        return zzl;
    }

    @VisibleForTesting
    public static String zzb(String str, String str2) {
        return String.format("%s%s", new Object[]{str, str2});
    }

    public static /* synthetic */ void zzc(zzl zzl) {
        long j10;
        if (!zzl.zzi.isEmpty()) {
            if (true != zzl.zzj.equals(zzl.zzi)) {
                j10 = 86400000;
            } else {
                j10 = 172800000;
            }
            long zze2 = zzl.zze();
            long j11 = zzl.zzk;
            if (j11 == 0 || zze2 - j11 >= j10) {
                zza.d("Upload the feature usage report.", new Object[0]);
                zzkj zza2 = zzkk.zza();
                zza2.zzb(zzb);
                zza2.zza(zzl.zzf);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(zzl.zzi);
                zzkd zza3 = zzke.zza();
                zza3.zza(arrayList);
                zza3.zzb((zzkk) zza2.zzp());
                zzkt zzc2 = zzku.zzc();
                zzc2.zzc((zzke) zza3.zzp());
                zzl.zzd.zzb((zzku) zzc2.zzp(), 243);
                SharedPreferences.Editor edit = zzl.zze.edit();
                if (!zzl.zzj.equals(zzl.zzi)) {
                    zzl.zzj.clear();
                    zzl.zzj.addAll(zzl.zzi);
                    for (zzju zza4 : zzl.zzj) {
                        String num = Integer.toString(zza4.zza());
                        String zzg2 = zzl.zzg(num);
                        String zzb2 = zzb("feature_usage_timestamp_reported_feature_", num);
                        if (!TextUtils.equals(zzg2, zzb2)) {
                            long j12 = zzl.zze.getLong(zzg2, 0);
                            edit.remove(zzg2);
                            if (j12 != 0) {
                                edit.putLong(zzb2, j12);
                            }
                        }
                    }
                }
                zzl.zzk = zze2;
                edit.putLong("feature_usage_last_report_time", zze2).apply();
            }
        }
    }

    public static void zzd(zzju zzju) {
        zzl zzl = zzc;
        if (zzl != null) {
            zzl.zze.edit().putLong(zzl.zzg(Integer.toString(zzju.zza())), zzl.zze()).apply();
            zzl.zzi.add(zzju);
            zzl.zzi();
        }
    }

    private final long zze() {
        return DefaultClock.getInstance().currentTimeMillis();
    }

    private static zzju zzf(String str) {
        try {
            return zzju.zzb(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return zzju.DEVELOPER_FEATURE_FLAG_UNKNOWN;
        }
    }

    private final String zzg(String str) {
        String zzb2 = zzb("feature_usage_timestamp_reported_feature_", str);
        if (this.zze.contains(zzb2)) {
            return zzb2;
        }
        return zzb("feature_usage_timestamp_detected_feature_", str);
    }

    private final void zzh(Set<String> set) {
        if (!set.isEmpty()) {
            SharedPreferences.Editor edit = this.zze.edit();
            for (String remove : set) {
                edit.remove(remove);
            }
            edit.apply();
        }
    }

    private final void zzi() {
        this.zzh.post(this.zzg);
    }
}
