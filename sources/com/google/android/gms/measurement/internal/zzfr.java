package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.entity.ConnType;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zznw;
import com.umeng.umcrash.UMCrash;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzfr implements zzgm {
    private static volatile zzfr zzd;
    private zzdy zzA;
    private boolean zzB = false;
    private Boolean zzC;
    private long zzD;
    private volatile Boolean zzE;
    private volatile boolean zzF;
    private int zzG;
    private final AtomicInteger zzH = new AtomicInteger(0);
    @VisibleForTesting
    protected Boolean zza;
    @VisibleForTesting
    protected Boolean zzb;
    @VisibleForTesting
    final long zzc;
    private final Context zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final boolean zzi;
    private final zzab zzj;
    private final zzag zzk;
    private final zzew zzl;
    private final zzeh zzm;
    private final zzfo zzn;
    private final zzkc zzo;
    private final zzlb zzp;
    private final zzec zzq;
    private final Clock zzr;
    private final zzim zzs;
    private final zzhx zzt;
    private final zzd zzu;
    private final zzib zzv;
    private final String zzw;
    private zzea zzx;
    private zzjm zzy;
    private zzaq zzz;

    public zzfr(zzgu zzgu) {
        long j10;
        Bundle bundle;
        boolean z10 = false;
        Preconditions.checkNotNull(zzgu);
        Context context = zzgu.zza;
        zzab zzab = new zzab(context);
        this.zzj = zzab;
        zzdr.zza = zzab;
        this.zze = context;
        this.zzf = zzgu.zzb;
        this.zzg = zzgu.zzc;
        this.zzh = zzgu.zzd;
        this.zzi = zzgu.zzh;
        this.zzE = zzgu.zze;
        this.zzw = zzgu.zzj;
        this.zzF = true;
        zzcl zzcl = zzgu.zzg;
        if (!(zzcl == null || (bundle = zzcl.zzg) == null)) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zza = (Boolean) obj;
            }
            Object obj2 = zzcl.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzb = (Boolean) obj2;
            }
        }
        zzib.zze(context);
        Clock instance = DefaultClock.getInstance();
        this.zzr = instance;
        Long l10 = zzgu.zzi;
        if (l10 != null) {
            j10 = l10.longValue();
        } else {
            j10 = instance.currentTimeMillis();
        }
        this.zzc = j10;
        this.zzk = new zzag(this);
        zzew zzew = new zzew(this);
        zzew.zzv();
        this.zzl = zzew;
        zzeh zzeh = new zzeh(this);
        zzeh.zzv();
        this.zzm = zzeh;
        zzlb zzlb = new zzlb(this);
        zzlb.zzv();
        this.zzp = zzlb;
        this.zzq = new zzec(new zzgt(zzgu, this));
        this.zzu = new zzd(this);
        zzim zzim = new zzim(this);
        zzim.zzb();
        this.zzs = zzim;
        zzhx zzhx = new zzhx(this);
        zzhx.zzb();
        this.zzt = zzhx;
        zzkc zzkc = new zzkc(this);
        zzkc.zzb();
        this.zzo = zzkc;
        zzib zzib = new zzib(this);
        zzib.zzv();
        this.zzv = zzib;
        zzfo zzfo = new zzfo(this);
        zzfo.zzv();
        this.zzn = zzfo;
        zzcl zzcl2 = zzgu.zzg;
        z10 = (zzcl2 == null || zzcl2.zzb == 0) ? true : z10;
        if (context.getApplicationContext() instanceof Application) {
            zzhx zzq2 = zzq();
            if (zzq2.zzt.zze.getApplicationContext() instanceof Application) {
                Application application = (Application) zzq2.zzt.zze.getApplicationContext();
                if (zzq2.zza == null) {
                    zzq2.zza = new zzhw(zzq2, (zzhv) null);
                }
                if (z10) {
                    application.unregisterActivityLifecycleCallbacks(zzq2.zza);
                    application.registerActivityLifecycleCallbacks(zzq2.zza);
                    zzq2.zzt.zzay().zzj().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzay().zzk().zza("Application context is not an Application");
        }
        zzfo.zzp(new zzfq(this, zzgu));
    }

    public static /* bridge */ /* synthetic */ void zzA(zzfr zzfr, zzgu zzgu) {
        zzfr.zzaz().zzg();
        zzfr.zzk.zzn();
        zzaq zzaq = new zzaq(zzfr);
        zzaq.zzv();
        zzfr.zzz = zzaq;
        zzdy zzdy = new zzdy(zzfr, zzgu.zzf);
        zzdy.zzb();
        zzfr.zzA = zzdy;
        zzea zzea = new zzea(zzfr);
        zzea.zzb();
        zzfr.zzx = zzea;
        zzjm zzjm = new zzjm(zzfr);
        zzjm.zzb();
        zzfr.zzy = zzjm;
        zzfr.zzp.zzw();
        zzfr.zzl.zzw();
        zzfr.zzA.zzc();
        zzef zzi2 = zzfr.zzay().zzi();
        zzfr.zzk.zzh();
        zzi2.zzb("App measurement initialized, version", 74029L);
        zzfr.zzay().zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzl2 = zzdy.zzl();
        if (TextUtils.isEmpty(zzfr.zzf)) {
            if (zzfr.zzv().zzae(zzl2)) {
                zzfr.zzay().zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzfr.zzay().zzi().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(zzl2)));
            }
        }
        zzfr.zzay().zzc().zza("Debug-level message logging enabled");
        if (zzfr.zzG != zzfr.zzH.get()) {
            zzfr.zzay().zzd().zzc("Not all components initialized", Integer.valueOf(zzfr.zzG), Integer.valueOf(zzfr.zzH.get()));
        }
        zzfr.zzB = true;
    }

    public static final void zzO() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzP(zzgk zzgk) {
        if (zzgk == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzQ(zzf zzf2) {
        if (zzf2 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzf2.zze()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzf2.getClass())));
        }
    }

    private static final void zzR(zzgl zzgl) {
        if (zzgl == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzgl.zzx()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzgl.getClass())));
        }
    }

    public static zzfr zzp(Context context, zzcl zzcl, Long l10) {
        Bundle bundle;
        if (zzcl != null && (zzcl.zze == null || zzcl.zzf == null)) {
            zzcl = new zzcl(zzcl.zza, zzcl.zzb, zzcl.zzc, zzcl.zzd, (String) null, (String) null, zzcl.zzg, (String) null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzd == null) {
            synchronized (zzfr.class) {
                if (zzd == null) {
                    zzd = new zzfr(new zzgu(context, zzcl, l10));
                }
            }
        } else if (!(zzcl == null || (bundle = zzcl.zzg) == null || !bundle.containsKey("dataCollectionDefaultEnabled"))) {
            Preconditions.checkNotNull(zzd);
            zzd.zzE = Boolean.valueOf(zzcl.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzd);
        return zzd;
    }

    public final void zzB() {
        this.zzH.incrementAndGet();
    }

    public final /* synthetic */ void zzC(String str, int i10, Throwable th, byte[] bArr, Map map) {
        if (!(i10 == 200 || i10 == 204)) {
            if (i10 == 304) {
                i10 = 304;
            }
            zzay().zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i10), th);
        }
        if (th == null) {
            zzm().zzn.zza(true);
            if (bArr == null || bArr.length == 0) {
                zzay().zzc().zza("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString("deeplink", "");
                String optString2 = jSONObject.optString("gclid", "");
                double optDouble = jSONObject.optDouble(UMCrash.SP_KEY_TIMESTAMP, 0.0d);
                if (TextUtils.isEmpty(optString)) {
                    zzay().zzc().zza("Deferred Deep Link is empty.");
                    return;
                }
                zzlb zzv2 = zzv();
                zzfr zzfr = zzv2.zzt;
                if (!TextUtils.isEmpty(optString)) {
                    List<ResolveInfo> queryIntentActivities = zzv2.zzt.zze.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("gclid", optString2);
                        bundle.putString("_cis", "ddp");
                        this.zzt.zzG(ConnType.PK_AUTO, "_cmp", bundle);
                        zzlb zzv3 = zzv();
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                SharedPreferences.Editor edit = zzv3.zzt.zze.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                edit.putString("deeplink", optString);
                                edit.putLong(UMCrash.SP_KEY_TIMESTAMP, Double.doubleToRawLongBits(optDouble));
                                if (edit.commit()) {
                                    zzv3.zzt.zze.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                                    return;
                                }
                                return;
                            } catch (RuntimeException e10) {
                                zzv3.zzt.zzay().zzd().zzb("Failed to persist Deferred Deep Link. exception", e10);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                zzay().zzk().zzc("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            } catch (JSONException e11) {
                zzay().zzd().zzb("Failed to parse the Deferred Deep Link response. exception", e11);
                return;
            }
        }
        zzay().zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i10), th);
    }

    public final void zzD() {
        this.zzG++;
    }

    public final void zzE() {
        zzaz().zzg();
        zzR(zzr());
        String zzl2 = zzh().zzl();
        Pair zzb2 = zzm().zzb(zzl2);
        if (!this.zzk.zzr() || ((Boolean) zzb2.second).booleanValue() || TextUtils.isEmpty((CharSequence) zzb2.first)) {
            zzay().zzc().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        zzib zzr2 = zzr();
        zzr2.zzu();
        ConnectivityManager connectivityManager = (ConnectivityManager) zzr2.zzt.zze.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            zzay().zzk().zza("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        zzlb zzv2 = zzv();
        zzh().zzt.zzk.zzh();
        URL zzE2 = zzv2.zzE(74029, zzl2, (String) zzb2.first, zzm().zzo.zza() - 1);
        if (zzE2 != null) {
            zzib zzr3 = zzr();
            zzfp zzfp = new zzfp(this);
            zzr3.zzg();
            zzr3.zzu();
            Preconditions.checkNotNull(zzE2);
            Preconditions.checkNotNull(zzfp);
            zzr3.zzt.zzaz().zzo(new zzia(zzr3, zzl2, zzE2, (byte[]) null, (Map) null, zzfp, (byte[]) null));
        }
    }

    public final void zzF(boolean z10) {
        this.zzE = Boolean.valueOf(z10);
    }

    public final void zzG(boolean z10) {
        zzaz().zzg();
        this.zzF = z10;
    }

    public final void zzH(zzcl zzcl) {
        zzai zzai;
        zzaz().zzg();
        zzai zzc2 = zzm().zzc();
        zzew zzm2 = zzm();
        zzfr zzfr = zzm2.zzt;
        zzm2.zzg();
        int i10 = 100;
        int i11 = zzm2.zza().getInt("consent_source", 100);
        zzag zzag = this.zzk;
        zzfr zzfr2 = zzag.zzt;
        Boolean zzk2 = zzag.zzk("google_analytics_default_allow_ad_storage");
        zzag zzag2 = this.zzk;
        zzfr zzfr3 = zzag2.zzt;
        Boolean zzk3 = zzag2.zzk("google_analytics_default_allow_analytics_storage");
        if (!(zzk2 == null && zzk3 == null) && zzm().zzl(-10)) {
            zzai = new zzai(zzk2, zzk3);
            i10 = -10;
        } else {
            if (!TextUtils.isEmpty(zzh().zzm()) && (i11 == 0 || i11 == 30 || i11 == 10 || i11 == 30 || i11 == 30 || i11 == 40)) {
                zzq().zzS(zzai.zza, -10, this.zzc);
            } else if (TextUtils.isEmpty(zzh().zzm()) && zzcl != null && zzcl.zzg != null && zzm().zzl(30)) {
                zzai = zzai.zza(zzcl.zzg);
                if (!zzai.equals(zzai.zza)) {
                    i10 = 30;
                }
            }
            zzai = null;
        }
        if (zzai != null) {
            zzq().zzS(zzai, i10, this.zzc);
            zzc2 = zzai;
        }
        zzq().zzV(zzc2);
        if (zzm().zzc.zza() == 0) {
            zzay().zzj().zzb("Persisting first open", Long.valueOf(this.zzc));
            zzm().zzc.zzb(this.zzc);
        }
        zzq().zzb.zzc();
        if (zzM()) {
            if (!TextUtils.isEmpty(zzh().zzm()) || !TextUtils.isEmpty(zzh().zzk())) {
                zzlb zzv2 = zzv();
                String zzm3 = zzh().zzm();
                zzew zzm4 = zzm();
                zzm4.zzg();
                String string = zzm4.zza().getString("gmp_app_id", (String) null);
                String zzk4 = zzh().zzk();
                zzew zzm5 = zzm();
                zzm5.zzg();
                if (zzv2.zzam(zzm3, string, zzk4, zzm5.zza().getString("admob_app_id", (String) null))) {
                    zzay().zzi().zza("Rechecking which service to use due to a GMP App Id change");
                    zzew zzm6 = zzm();
                    zzm6.zzg();
                    Boolean zzd2 = zzm6.zzd();
                    SharedPreferences.Editor edit = zzm6.zza().edit();
                    edit.clear();
                    edit.apply();
                    if (zzd2 != null) {
                        zzm6.zzh(zzd2);
                    }
                    zzi().zzj();
                    this.zzy.zzs();
                    this.zzy.zzr();
                    zzm().zzc.zzb(this.zzc);
                    zzm().zze.zzb((String) null);
                }
                zzew zzm7 = zzm();
                String zzm8 = zzh().zzm();
                zzm7.zzg();
                SharedPreferences.Editor edit2 = zzm7.zza().edit();
                edit2.putString("gmp_app_id", zzm8);
                edit2.apply();
                zzew zzm9 = zzm();
                String zzk5 = zzh().zzk();
                zzm9.zzg();
                SharedPreferences.Editor edit3 = zzm9.zza().edit();
                edit3.putString("admob_app_id", zzk5);
                edit3.apply();
            }
            if (!zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
                zzm().zze.zzb((String) null);
            }
            zzq().zzO(zzm().zze.zza());
            zznw.zzc();
            if (this.zzk.zzs((String) null, zzdu.zzac)) {
                try {
                    zzv().zzt.zze.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                } catch (ClassNotFoundException unused) {
                    if (!TextUtils.isEmpty(zzm().zzp.zza())) {
                        zzay().zzk().zza("Remote config removed with active feature rollouts");
                        zzm().zzp.zzb((String) null);
                    }
                }
            }
            if (!TextUtils.isEmpty(zzh().zzm()) || !TextUtils.isEmpty(zzh().zzk())) {
                boolean zzJ = zzJ();
                if (!zzm().zzj() && !this.zzk.zzv()) {
                    zzm().zzi(!zzJ);
                }
                if (zzJ) {
                    zzq().zzz();
                }
                zzu().zza.zza();
                zzt().zzu(new AtomicReference());
                zzt().zzH(zzm().zzs.zza());
            }
        } else if (zzJ()) {
            if (!zzv().zzad("android.permission.INTERNET")) {
                zzay().zzd().zza("App is missing INTERNET permission");
            }
            if (!zzv().zzad("android.permission.ACCESS_NETWORK_STATE")) {
                zzay().zzd().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Wrappers.packageManager(this.zze).isCallerInstantApp() && !this.zzk.zzx()) {
                if (!zzlb.zzaj(this.zze)) {
                    zzay().zzd().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzlb.zzak(this.zze, false)) {
                    zzay().zzd().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzay().zzd().zza("Uploading is not possible. App measurement disabled");
        }
        zzm().zzi.zza(true);
    }

    public final boolean zzI() {
        if (this.zzE == null || !this.zzE.booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean zzJ() {
        if (zza() == 0) {
            return true;
        }
        return false;
    }

    public final boolean zzK() {
        zzaz().zzg();
        return this.zzF;
    }

    public final boolean zzL() {
        return TextUtils.isEmpty(this.zzf);
    }

    public final boolean zzM() {
        boolean z10;
        if (this.zzB) {
            zzaz().zzg();
            Boolean bool = this.zzC;
            if (bool == null || this.zzD == 0 || (!bool.booleanValue() && Math.abs(this.zzr.elapsedRealtime() - this.zzD) > 1000)) {
                this.zzD = this.zzr.elapsedRealtime();
                boolean z11 = true;
                if (!zzv().zzad("android.permission.INTERNET") || !zzv().zzad("android.permission.ACCESS_NETWORK_STATE") || (!Wrappers.packageManager(this.zze).isCallerInstantApp() && !this.zzk.zzx() && (!zzlb.zzaj(this.zze) || !zzlb.zzak(this.zze, false)))) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                Boolean valueOf = Boolean.valueOf(z10);
                this.zzC = valueOf;
                if (valueOf.booleanValue()) {
                    if (!zzv().zzX(zzh().zzm(), zzh().zzk()) && TextUtils.isEmpty(zzh().zzk())) {
                        z11 = false;
                    }
                    this.zzC = Boolean.valueOf(z11);
                }
            }
            return this.zzC.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    public final boolean zzN() {
        return this.zzi;
    }

    public final int zza() {
        zzaz().zzg();
        if (this.zzk.zzv()) {
            return 1;
        }
        Boolean bool = this.zzb;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        zzaz().zzg();
        if (!this.zzF) {
            return 8;
        }
        Boolean zzd2 = zzm().zzd();
        if (zzd2 == null) {
            zzag zzag = this.zzk;
            zzab zzab = zzag.zzt.zzj;
            Boolean zzk2 = zzag.zzk("firebase_analytics_collection_enabled");
            if (zzk2 == null) {
                Boolean bool2 = this.zza;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (this.zzE == null || this.zzE.booleanValue()) {
                    return 0;
                } else {
                    return 7;
                }
            } else if (zzk2.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (zzd2.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    public final Context zzau() {
        return this.zze;
    }

    public final Clock zzav() {
        return this.zzr;
    }

    public final zzab zzaw() {
        return this.zzj;
    }

    public final zzeh zzay() {
        zzR(this.zzm);
        return this.zzm;
    }

    public final zzfo zzaz() {
        zzR(this.zzn);
        return this.zzn;
    }

    public final zzd zzd() {
        zzd zzd2 = this.zzu;
        if (zzd2 != null) {
            return zzd2;
        }
        throw new IllegalStateException("Component not created");
    }

    public final zzag zzf() {
        return this.zzk;
    }

    public final zzaq zzg() {
        zzR(this.zzz);
        return this.zzz;
    }

    public final zzdy zzh() {
        zzQ(this.zzA);
        return this.zzA;
    }

    public final zzea zzi() {
        zzQ(this.zzx);
        return this.zzx;
    }

    public final zzec zzj() {
        return this.zzq;
    }

    public final zzeh zzl() {
        zzeh zzeh = this.zzm;
        if (zzeh == null || !zzeh.zzx()) {
            return null;
        }
        return zzeh;
    }

    public final zzew zzm() {
        zzP(this.zzl);
        return this.zzl;
    }

    public final zzfo zzo() {
        return this.zzn;
    }

    public final zzhx zzq() {
        zzQ(this.zzt);
        return this.zzt;
    }

    public final zzib zzr() {
        zzR(this.zzv);
        return this.zzv;
    }

    public final zzim zzs() {
        zzQ(this.zzs);
        return this.zzs;
    }

    public final zzjm zzt() {
        zzQ(this.zzy);
        return this.zzy;
    }

    public final zzkc zzu() {
        zzQ(this.zzo);
        return this.zzo;
    }

    public final zzlb zzv() {
        zzP(this.zzp);
        return this.zzp;
    }

    public final String zzw() {
        return this.zzf;
    }

    public final String zzx() {
        return this.zzg;
    }

    public final String zzy() {
        return this.zzh;
    }

    public final String zzz() {
        return this.zzw;
    }
}
