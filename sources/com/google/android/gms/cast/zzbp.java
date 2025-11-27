package com.google.android.gms.cast;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zza;
import com.google.android.gms.cast.internal.zzae;
import com.google.android.gms.cast.internal.zzag;
import com.google.android.gms.cast.internal.zzai;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.cast.internal.zzy;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzco;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class zzbp extends GoogleApi<Cast.CastOptions> implements zzr {
    public static final /* synthetic */ int zzf = 0;
    /* access modifiers changed from: private */
    public static final Logger zzg = new Logger("CastClient");
    private static final Api.AbstractClientBuilder<zzx, Cast.CastOptions> zzh;
    private static final Api<Cast.CastOptions> zzi;
    final zzbo zza = new zzbo(this);
    TaskCompletionSource<Cast.ApplicationConnectionResult> zzb;
    TaskCompletionSource<Status> zzc;
    final Map<Long, TaskCompletionSource<Void>> zzd;
    final Map<String, Cast.MessageReceivedCallback> zze;
    private Handler zzj;
    /* access modifiers changed from: private */
    public boolean zzk;
    /* access modifiers changed from: private */
    public boolean zzl;
    private final AtomicLong zzm;
    private final Object zzn = new Object();
    private final Object zzo = new Object();
    /* access modifiers changed from: private */
    public ApplicationMetadata zzp;
    /* access modifiers changed from: private */
    public String zzq;
    private double zzr;
    private boolean zzs;
    private int zzt;
    private int zzu;
    private zzar zzv;
    /* access modifiers changed from: private */
    public final CastDevice zzw;
    /* access modifiers changed from: private */
    public final Cast.Listener zzx;
    /* access modifiers changed from: private */
    public final List<zzq> zzy = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public int zzz;

    static {
        zzbg zzbg = new zzbg();
        zzh = zzbg;
        zzi = new Api<>("Cast.API_CXLESS", zzbg, zzai.zzb);
    }

    public zzbp(Context context, Cast.CastOptions castOptions) {
        super(context, zzi, castOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(castOptions, "CastOptions cannot be null");
        this.zzx = castOptions.zzb;
        this.zzw = castOptions.zza;
        this.zzd = new HashMap();
        this.zze = new HashMap();
        this.zzm = new AtomicLong(0);
        this.zzz = 1;
        zzm();
    }

    public static /* bridge */ /* synthetic */ void zzC(zzbp zzbp, Cast.ApplicationConnectionResult applicationConnectionResult) {
        synchronized (zzbp.zzn) {
            TaskCompletionSource<Cast.ApplicationConnectionResult> taskCompletionSource = zzbp.zzb;
            if (taskCompletionSource != null) {
                taskCompletionSource.setResult(applicationConnectionResult);
            }
            zzbp.zzb = null;
        }
    }

    public static /* bridge */ /* synthetic */ void zzD(zzbp zzbp, long j10, int i10) {
        TaskCompletionSource taskCompletionSource;
        synchronized (zzbp.zzd) {
            Map<Long, TaskCompletionSource<Void>> map = zzbp.zzd;
            Long valueOf = Long.valueOf(j10);
            taskCompletionSource = map.get(valueOf);
            zzbp.zzd.remove(valueOf);
        }
        if (taskCompletionSource == null) {
            return;
        }
        if (i10 == 0) {
            taskCompletionSource.setResult(null);
        } else {
            taskCompletionSource.setException(zzO(i10));
        }
    }

    public static /* bridge */ /* synthetic */ void zzE(zzbp zzbp, int i10) {
        synchronized (zzbp.zzo) {
            TaskCompletionSource<Status> taskCompletionSource = zzbp.zzc;
            if (taskCompletionSource != null) {
                if (i10 == 0) {
                    taskCompletionSource.setResult(new Status(0));
                } else {
                    taskCompletionSource.setException(zzO(i10));
                }
                zzbp.zzc = null;
            }
        }
    }

    private static ApiException zzO(int i10) {
        return ApiExceptionUtil.fromStatus(new Status(i10));
    }

    /* access modifiers changed from: private */
    public final Task<Boolean> zzP(zzag zzag) {
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(registerListener(zzag, "castDeviceControllerListenerKey").getListenerKey(), "Key must not be null"), 8415);
    }

    private final void zzQ() {
        boolean z10;
        if (this.zzz == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "Not connected to device");
    }

    /* access modifiers changed from: private */
    public final void zzR() {
        zzg.d("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zze) {
            this.zze.clear();
        }
    }

    private final void zzS(TaskCompletionSource<Cast.ApplicationConnectionResult> taskCompletionSource) {
        synchronized (this.zzn) {
            if (this.zzb != null) {
                zzT(2477);
            }
            this.zzb = taskCompletionSource;
        }
    }

    /* access modifiers changed from: private */
    public final void zzT(int i10) {
        synchronized (this.zzn) {
            TaskCompletionSource<Cast.ApplicationConnectionResult> taskCompletionSource = this.zzb;
            if (taskCompletionSource != null) {
                taskCompletionSource.setException(zzO(i10));
            }
            this.zzb = null;
        }
    }

    private final void zzU() {
        boolean z10 = true;
        if (this.zzz == 1) {
            z10 = false;
        }
        Preconditions.checkState(z10, "Not active connection");
    }

    public static /* bridge */ /* synthetic */ Handler zzn(zzbp zzbp) {
        if (zzbp.zzj == null) {
            zzbp.zzj = new zzco(zzbp.getLooper());
        }
        return zzbp.zzj;
    }

    public static /* bridge */ /* synthetic */ void zzx(zzbp zzbp) {
        zzbp.zzt = -1;
        zzbp.zzu = -1;
        zzbp.zzp = null;
        zzbp.zzq = null;
        zzbp.zzr = 0.0d;
        zzbp.zzm();
        zzbp.zzs = false;
        zzbp.zzv = null;
    }

    public static /* bridge */ /* synthetic */ void zzy(zzbp zzbp, zza zza2) {
        boolean z10;
        String zza3 = zza2.zza();
        if (!CastUtils.zzh(zza3, zzbp.zzq)) {
            zzbp.zzq = zza3;
            z10 = true;
        } else {
            z10 = false;
        }
        zzg.d("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z10), Boolean.valueOf(zzbp.zzl));
        Cast.Listener listener = zzbp.zzx;
        if (listener != null && (z10 || zzbp.zzl)) {
            listener.onApplicationStatusChanged();
        }
        zzbp.zzl = false;
    }

    public static /* bridge */ /* synthetic */ void zzz(zzbp zzbp, zzy zzy2) {
        boolean z10;
        boolean z11;
        boolean z12;
        ApplicationMetadata zze2 = zzy2.zze();
        if (!CastUtils.zzh(zze2, zzbp.zzp)) {
            zzbp.zzp = zze2;
            zzbp.zzx.onApplicationMetadataChanged(zze2);
        }
        double zzb2 = zzy2.zzb();
        if (Double.isNaN(zzb2) || Math.abs(zzb2 - zzbp.zzr) <= 1.0E-7d) {
            z10 = false;
        } else {
            zzbp.zzr = zzb2;
            z10 = true;
        }
        boolean zzg2 = zzy2.zzg();
        if (zzg2 != zzbp.zzs) {
            zzbp.zzs = zzg2;
            z10 = true;
        }
        Logger logger = zzg;
        logger.d("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z10), Boolean.valueOf(zzbp.zzk));
        Cast.Listener listener = zzbp.zzx;
        if (listener != null && (z10 || zzbp.zzk)) {
            listener.onVolumeChanged();
        }
        Double.isNaN(zzy2.zza());
        int zzc2 = zzy2.zzc();
        if (zzc2 != zzbp.zzt) {
            zzbp.zzt = zzc2;
            z11 = true;
        } else {
            z11 = false;
        }
        logger.d("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z11), Boolean.valueOf(zzbp.zzk));
        Cast.Listener listener2 = zzbp.zzx;
        if (listener2 != null && (z11 || zzbp.zzk)) {
            listener2.onActiveInputStateChanged(zzbp.zzt);
        }
        int zzd2 = zzy2.zzd();
        if (zzd2 != zzbp.zzu) {
            zzbp.zzu = zzd2;
            z12 = true;
        } else {
            z12 = false;
        }
        logger.d("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z12), Boolean.valueOf(zzbp.zzk));
        Cast.Listener listener3 = zzbp.zzx;
        if (listener3 != null && (z12 || zzbp.zzk)) {
            listener3.onStandbyStateChanged(zzbp.zzu);
        }
        if (!CastUtils.zzh(zzbp.zzv, zzy2.zzf())) {
            zzbp.zzv = zzy2.zzf();
        }
        zzbp.zzk = false;
    }

    public final /* synthetic */ void zzF(String str, String str2, zzbq zzbq, zzx zzx2, TaskCompletionSource taskCompletionSource) {
        zzQ();
        ((zzae) zzx2.getService()).zzg(str, str2, (zzbq) null);
        zzS(taskCompletionSource);
    }

    public final /* synthetic */ void zzG(String str, LaunchOptions launchOptions, zzx zzx2, TaskCompletionSource taskCompletionSource) {
        zzQ();
        ((zzae) zzx2.getService()).zzh(str, launchOptions);
        zzS(taskCompletionSource);
    }

    public final /* synthetic */ void zzH(Cast.MessageReceivedCallback messageReceivedCallback, String str, zzx zzx2, TaskCompletionSource taskCompletionSource) {
        zzU();
        if (messageReceivedCallback != null) {
            ((zzae) zzx2.getService()).zzr(str);
        }
        taskCompletionSource.setResult(null);
    }

    public final /* synthetic */ void zzI(String str, String str2, String str3, zzx zzx2, TaskCompletionSource taskCompletionSource) {
        long incrementAndGet = this.zzm.incrementAndGet();
        zzQ();
        try {
            this.zzd.put(Long.valueOf(incrementAndGet), taskCompletionSource);
            ((zzae) zzx2.getService()).zzm(str2, str3, incrementAndGet);
        } catch (RemoteException e10) {
            this.zzd.remove(Long.valueOf(incrementAndGet));
            taskCompletionSource.setException(e10);
        }
    }

    public final /* synthetic */ void zzJ(String str, Cast.MessageReceivedCallback messageReceivedCallback, zzx zzx2, TaskCompletionSource taskCompletionSource) {
        zzU();
        ((zzae) zzx2.getService()).zzr(str);
        if (messageReceivedCallback != null) {
            ((zzae) zzx2.getService()).zzk(str);
        }
        taskCompletionSource.setResult(null);
    }

    public final /* synthetic */ void zzK(boolean z10, zzx zzx2, TaskCompletionSource taskCompletionSource) {
        ((zzae) zzx2.getService()).zzn(z10, this.zzr, this.zzs);
        taskCompletionSource.setResult(null);
    }

    public final /* synthetic */ void zzL(double d10, zzx zzx2, TaskCompletionSource taskCompletionSource) {
        ((zzae) zzx2.getService()).zzo(d10, this.zzr, this.zzs);
        taskCompletionSource.setResult(null);
    }

    public final /* synthetic */ void zzM(String str, zzx zzx2, TaskCompletionSource taskCompletionSource) {
        zzQ();
        ((zzae) zzx2.getService()).zzp(str);
        synchronized (this.zzo) {
            if (this.zzc != null) {
                taskCompletionSource.setException(zzO(CastStatusCodes.INVALID_REQUEST));
            } else {
                this.zzc = taskCompletionSource;
            }
        }
    }

    public final double zza() {
        zzQ();
        return this.zzr;
    }

    public final int zzb() {
        zzQ();
        return this.zzt;
    }

    public final int zzc() {
        zzQ();
        return this.zzu;
    }

    public final ApplicationMetadata zzd() {
        zzQ();
        return this.zzp;
    }

    public final Task<Void> zze() {
        ListenerHolder registerListener = registerListener(this.zza, "castDeviceControllerListenerKey");
        RegistrationMethods.Builder builder = RegistrationMethods.builder();
        zzay zzay = new zzay(this);
        return doRegisterEventListener(builder.withHolder(registerListener).register(zzay).unregister(zzav.zza).setFeatures(zzat.zzb).setMethodKey(8428).build());
    }

    public final Task<Void> zzf() {
        Task<Void> doWrite = doWrite(TaskApiCall.builder().run(zzaw.zza).setMethodKey(8403).build());
        zzR();
        zzP(this.zza);
        return doWrite;
    }

    public final Task<Void> zzg(String str) {
        Cast.MessageReceivedCallback remove;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.zze) {
                remove = this.zze.remove(str);
            }
            return doWrite(TaskApiCall.builder().run(new zzba(this, remove, str)).setMethodKey(8414).build());
        }
        throw new IllegalArgumentException("Channel namespace cannot be null or empty");
    }

    public final Task<Void> zzh(String str, String str2) {
        CastUtils.throwIfInvalidNamespace(str);
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() <= 524288) {
            return doWrite(TaskApiCall.builder().run(new zzbf(this, (String) null, str, str2)).setMethodKey(8405).build());
        } else {
            zzg.w("Message send failed. Message exceeds maximum size", new Object[0]);
            throw new IllegalArgumentException("Message exceeds maximum size524288");
        }
    }

    public final Task<Void> zzi(String str, Cast.MessageReceivedCallback messageReceivedCallback) {
        CastUtils.throwIfInvalidNamespace(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zze) {
                this.zze.put(str, messageReceivedCallback);
            }
        }
        return doWrite(TaskApiCall.builder().run(new zzbc(this, str, messageReceivedCallback)).setMethodKey(8413).build());
    }

    public final String zzj() {
        zzQ();
        return this.zzq;
    }

    public final void zzk(zzq zzq2) {
        Preconditions.checkNotNull(zzq2);
        this.zzy.add(zzq2);
    }

    public final boolean zzl() {
        zzQ();
        return this.zzs;
    }

    public final double zzm() {
        if (this.zzw.hasCapability(2048)) {
            return 0.02d;
        }
        if (!this.zzw.hasCapability(4) || this.zzw.hasCapability(1) || "Chromecast Audio".equals(this.zzw.getModelName())) {
            return 0.05d;
        }
        return 0.02d;
    }
}
