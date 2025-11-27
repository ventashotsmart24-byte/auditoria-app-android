package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.collection.a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzci;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzcl;
import com.umeng.analytics.pro.bx;
import java.util.Map;

@DynamiteApi
public class AppMeasurementDynamiteService extends zzcb {
    @VisibleForTesting
    zzfr zza = null;
    private final Map zzb = new a();

    private final void zzb() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zzc(zzcf zzcf, String str) {
        zzb();
        this.zza.zzv().zzV(zzcf, str);
    }

    public void beginAdUnitExposure(String str, long j10) {
        zzb();
        this.zza.zzd().zzd(str, j10);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzb();
        this.zza.zzq().zzA(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j10) {
        zzb();
        this.zza.zzq().zzU((Boolean) null);
    }

    public void endAdUnitExposure(String str, long j10) {
        zzb();
        this.zza.zzd().zze(str, j10);
    }

    public void generateEventId(zzcf zzcf) {
        zzb();
        long zzq = this.zza.zzv().zzq();
        zzb();
        this.zza.zzv().zzU(zzcf, zzq);
    }

    public void getAppInstanceId(zzcf zzcf) {
        zzb();
        this.zza.zzaz().zzp(new zzi(this, zzcf));
    }

    public void getCachedAppInstanceId(zzcf zzcf) {
        zzb();
        zzc(zzcf, this.zza.zzq().zzo());
    }

    public void getConditionalUserProperties(String str, String str2, zzcf zzcf) {
        zzb();
        this.zza.zzaz().zzp(new zzm(this, zzcf, str, str2));
    }

    public void getCurrentScreenClass(zzcf zzcf) {
        zzb();
        zzc(zzcf, this.zza.zzq().zzp());
    }

    public void getCurrentScreenName(zzcf zzcf) {
        zzb();
        zzc(zzcf, this.zza.zzq().zzq());
    }

    public void getGmpAppId(zzcf zzcf) {
        String str;
        zzb();
        zzhx zzq = this.zza.zzq();
        if (zzq.zzt.zzw() != null) {
            str = zzq.zzt.zzw();
        } else {
            try {
                str = zzid.zzc(zzq.zzt.zzau(), "google_app_id", zzq.zzt.zzz());
            } catch (IllegalStateException e10) {
                zzq.zzt.zzay().zzd().zzb("getGoogleAppId failed with exception", e10);
                str = null;
            }
        }
        zzc(zzcf, str);
    }

    public void getMaxUserProperties(String str, zzcf zzcf) {
        zzb();
        this.zza.zzq().zzh(str);
        zzb();
        this.zza.zzv().zzT(zzcf, 25);
    }

    public void getSessionId(zzcf zzcf) {
        zzb();
        zzhx zzq = this.zza.zzq();
        zzq.zzt.zzaz().zzp(new zzhk(zzq, zzcf));
    }

    public void getTestFlag(zzcf zzcf, int i10) {
        zzb();
        if (i10 == 0) {
            this.zza.zzv().zzV(zzcf, this.zza.zzq().zzr());
        } else if (i10 == 1) {
            this.zza.zzv().zzU(zzcf, this.zza.zzq().zzm().longValue());
        } else if (i10 == 2) {
            zzlb zzv = this.zza.zzv();
            double doubleValue = this.zza.zzq().zzj().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzcf.zze(bundle);
            } catch (RemoteException e10) {
                zzv.zzt.zzay().zzk().zzb("Error returning double value to wrapper", e10);
            }
        } else if (i10 == 3) {
            this.zza.zzv().zzT(zzcf, this.zza.zzq().zzl().intValue());
        } else if (i10 == 4) {
            this.zza.zzv().zzP(zzcf, this.zza.zzq().zzi().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z10, zzcf zzcf) {
        zzb();
        this.zza.zzaz().zzp(new zzk(this, zzcf, str, str2, z10));
    }

    public void initForTests(Map map) {
        zzb();
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzcl zzcl, long j10) {
        zzfr zzfr = this.zza;
        if (zzfr == null) {
            this.zza = zzfr.zzp((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzcl, Long.valueOf(j10));
        } else {
            zzfr.zzay().zzk().zza("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(zzcf zzcf) {
        zzb();
        this.zza.zzaz().zzp(new zzn(this, zzcf));
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) {
        zzb();
        this.zza.zzq().zzE(str, str2, bundle, z10, z11, j10);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzcf zzcf, long j10) {
        Bundle bundle2;
        zzb();
        Preconditions.checkNotEmpty(str2);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.zza.zzaz().zzp(new zzj(this, zzcf, new zzaw(str2, new zzau(bundle), "app", j10), str));
    }

    public void logHealthData(int i10, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Object obj;
        Object obj2;
        zzb();
        Object obj3 = null;
        if (iObjectWrapper == null) {
            obj = null;
        } else {
            obj = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            obj2 = null;
        } else {
            obj2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj3 = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzay().zzt(i10, true, false, str, obj, obj2, obj3);
    }

    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j10) {
        zzb();
        zzhw zzhw = this.zza.zzq().zza;
        if (zzhw != null) {
            this.zza.zzq().zzB();
            zzhw.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j10) {
        zzb();
        zzhw zzhw = this.zza.zzq().zza;
        if (zzhw != null) {
            this.zza.zzq().zzB();
            zzhw.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j10) {
        zzb();
        zzhw zzhw = this.zza.zzq().zza;
        if (zzhw != null) {
            this.zza.zzq().zzB();
            zzhw.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j10) {
        zzb();
        zzhw zzhw = this.zza.zzq().zza;
        if (zzhw != null) {
            this.zza.zzq().zzB();
            zzhw.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcf zzcf, long j10) {
        zzb();
        zzhw zzhw = this.zza.zzq().zza;
        Bundle bundle = new Bundle();
        if (zzhw != null) {
            this.zza.zzq().zzB();
            zzhw.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.zza.zzay().zzk().zzb("Error returning bundle value to wrapper", e10);
        }
    }

    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j10) {
        zzb();
        if (this.zza.zzq().zza != null) {
            this.zza.zzq().zzB();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j10) {
        zzb();
        if (this.zza.zzq().zza != null) {
            this.zza.zzq().zzB();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void performAction(Bundle bundle, zzcf zzcf, long j10) {
        zzb();
        zzcf.zze((Bundle) null);
    }

    public void registerOnMeasurementEventListener(zzci zzci) {
        zzgs zzgs;
        zzb();
        synchronized (this.zzb) {
            zzgs = (zzgs) this.zzb.get(Integer.valueOf(zzci.zzd()));
            if (zzgs == null) {
                zzgs = new zzp(this, zzci);
                this.zzb.put(Integer.valueOf(zzci.zzd()), zzgs);
            }
        }
        this.zza.zzq().zzJ(zzgs);
    }

    public void resetAnalyticsData(long j10) {
        zzb();
        this.zza.zzq().zzK(j10);
    }

    public void setConditionalUserProperty(Bundle bundle, long j10) {
        zzb();
        if (bundle == null) {
            this.zza.zzay().zzd().zza("Conditional user property must not be null");
        } else {
            this.zza.zzq().zzQ(bundle, j10);
        }
    }

    public void setConsent(Bundle bundle, long j10) {
        zzb();
        zzhx zzq = this.zza.zzq();
        zzq.zzt.zzaz().zzq(new zzgv(zzq, bundle, j10));
    }

    public void setConsentThirdParty(Bundle bundle, long j10) {
        zzb();
        this.zza.zzq().zzR(bundle, -20, j10);
    }

    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j10) {
        zzb();
        this.zza.zzs().zzw((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    public void setDataCollectionEnabled(boolean z10) {
        zzb();
        zzhx zzq = this.zza.zzq();
        zzq.zza();
        zzq.zzt.zzaz().zzp(new zzht(zzq, z10));
    }

    public void setDefaultEventParameters(Bundle bundle) {
        Bundle bundle2;
        zzb();
        zzhx zzq = this.zza.zzq();
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzq.zzt.zzaz().zzp(new zzgw(zzq, bundle2));
    }

    public void setEventInterceptor(zzci zzci) {
        zzb();
        zzo zzo = new zzo(this, zzci);
        if (this.zza.zzaz().zzs()) {
            this.zza.zzq().zzT(zzo);
        } else {
            this.zza.zzaz().zzp(new zzl(this, zzo));
        }
    }

    public void setInstanceIdProvider(zzck zzck) {
        zzb();
    }

    public void setMeasurementEnabled(boolean z10, long j10) {
        zzb();
        this.zza.zzq().zzU(Boolean.valueOf(z10));
    }

    public void setMinimumSessionDuration(long j10) {
        zzb();
    }

    public void setSessionTimeoutDuration(long j10) {
        zzb();
        zzhx zzq = this.zza.zzq();
        zzq.zzt.zzaz().zzp(new zzha(zzq, j10));
    }

    public void setUserId(String str, long j10) {
        zzb();
        zzhx zzq = this.zza.zzq();
        if (str == null || !TextUtils.isEmpty(str)) {
            zzq.zzt.zzaz().zzp(new zzgx(zzq, str));
            zzq.zzX((String) null, bx.f13988d, str, true, j10);
            return;
        }
        zzq.zzt.zzay().zzk().zza("User ID must be non-empty or null");
    }

    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z10, long j10) {
        zzb();
        this.zza.zzq().zzX(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z10, j10);
    }

    public void unregisterOnMeasurementEventListener(zzci zzci) {
        zzgs zzgs;
        zzb();
        synchronized (this.zzb) {
            zzgs = (zzgs) this.zzb.remove(Integer.valueOf(zzci.zzd()));
        }
        if (zzgs == null) {
            zzgs = new zzp(this, zzci);
        }
        this.zza.zzq().zzZ(zzgs);
    }
}
