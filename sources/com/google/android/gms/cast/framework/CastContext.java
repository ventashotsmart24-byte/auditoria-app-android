package com.google.android.gms.cast.framework;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.Destination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.cast.CredentialsData;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.cast.internal.zzg;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.zzat;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.cast.zzaj;
import com.google.android.gms.internal.cast.zzar;
import com.google.android.gms.internal.cast.zzd;
import com.google.android.gms.internal.cast.zzh;
import com.google.android.gms.internal.cast.zzju;
import com.google.android.gms.internal.cast.zzku;
import com.google.android.gms.internal.cast.zzl;
import com.google.android.gms.internal.cast.zzm;
import com.google.android.gms.internal.cast.zzo;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import n0.s0;
import n0.t0;

public class CastContext {
    @RecentlyNonNull
    public static final String OPTIONS_PROVIDER_CLASS_NAME_KEY = "com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME";
    private static final Logger zza = new Logger("CastContext");
    private static final Object zzb = new Object();
    private static CastContext zzc;
    private final Context zzd;
    private final zzw zze;
    private final SessionManager zzf;
    private final zzr zzg;
    private final PrecacheManager zzh;
    private final MediaNotificationManager zzi;
    private final CastOptions zzj;
    private final zzaj zzk;
    private final List<SessionProvider> zzl;
    private zzo zzm;
    private CastReasonCodes zzn;

    private CastContext(Context context, CastOptions castOptions, List<SessionProvider> list, zzaj zzaj) {
        Context applicationContext = context.getApplicationContext();
        this.zzd = applicationContext;
        this.zzj = castOptions;
        this.zzk = zzaj;
        this.zzl = list;
        zzi();
        try {
            zzw zza2 = zzm.zza(applicationContext, castOptions, zzaj, zzh());
            this.zze = zza2;
            try {
                this.zzg = new zzr(zza2.zzf());
                try {
                    SessionManager sessionManager = new SessionManager(zza2.zzg(), applicationContext);
                    this.zzf = sessionManager;
                    this.zzi = new MediaNotificationManager(sessionManager);
                    this.zzh = new PrecacheManager(castOptions, sessionManager, new zzn(applicationContext));
                    zzar zzn2 = zzaj.zzn();
                    if (zzn2 != null) {
                        zzn2.zzc(sessionManager);
                    }
                    zzn zzn3 = new zzn(applicationContext);
                    zzn3.doRead(TaskApiCall.builder().run(new zze(zzn3, new String[]{"com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", "com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE", "com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED"})).setFeatures(zzat.zzd).setAutoResolveMissingFeatures(false).setMethodKey(8425).build()).addOnSuccessListener(new zzc(this));
                    zzn zzn4 = new zzn(applicationContext);
                    zzn4.doRead(TaskApiCall.builder().run(new zzf(zzn4, new String[]{"com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES"})).setFeatures(zzat.zzh).setAutoResolveMissingFeatures(false).setMethodKey(8427).build()).addOnSuccessListener(new zzb(this));
                } catch (RemoteException e10) {
                    throw new IllegalStateException("Failed to call getSessionManagerImpl", e10);
                }
            } catch (RemoteException e11) {
                throw new IllegalStateException("Failed to call getDiscoveryManagerImpl", e11);
            }
        } catch (RemoteException e12) {
            throw new IllegalStateException("Failed to call newCastContextImpl", e12);
        }
    }

    @RecentlyNullable
    public static CastContext getSharedInstance() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return zzc;
    }

    @RecentlyNullable
    public static CastContext zza(@RecentlyNonNull Context context) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return getSharedInstance(context);
        } catch (RuntimeException e10) {
            zza.e("Failed to load module from Google Play services. Cast will not work properly. Might due to outdated Google Play services. Ignoring this failure silently.", e10);
            return null;
        }
    }

    public static /* synthetic */ void zzc(@RecentlyNonNull CastContext castContext, @RecentlyNonNull Bundle bundle) {
        boolean z10 = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED");
        boolean z11 = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED");
        if (!z10) {
            if (z11) {
                z11 = true;
            } else {
                return;
            }
        }
        String packageName = castContext.zzd.getPackageName();
        String format = String.format(Locale.ROOT, "%s.%s", new Object[]{castContext.zzd.getPackageName(), "client_cast_analytics_data"});
        TransportRuntime.initialize(castContext.zzd);
        Transport<zzku> transport = TransportRuntime.getInstance().newFactory((Destination) CCTDestination.INSTANCE).getTransport("CAST_SENDER_SDK", zzku.class, zza.zza);
        long j10 = bundle.getLong("com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE");
        SharedPreferences sharedPreferences = castContext.zzd.getApplicationContext().getSharedPreferences(format, 0);
        zzd zza2 = zzd.zza(sharedPreferences, transport, j10);
        if (z10) {
            zzn zzn2 = new zzn(castContext.zzd);
            zzn2.doRead(TaskApiCall.builder().run(new zzg(zzn2, new String[]{"com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR", "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON"})).setFeatures(zzat.zzg).setAutoResolveMissingFeatures(false).setMethodKey(8426).build()).addOnSuccessListener(new zzd(castContext, zza2, sharedPreferences));
        }
        if (z11) {
            Preconditions.checkNotNull(sharedPreferences);
            Preconditions.checkNotNull(zza2);
            zzl.zza(sharedPreferences, zza2, packageName);
            zzl.zzd(zzju.CAST_CONTEXT);
        }
    }

    private static OptionsProvider zzg(Context context) {
        try {
            Bundle bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                zza.e("Bundle is null", new Object[0]);
            }
            String string = bundle.getString(OPTIONS_PROVIDER_CLASS_NAME_KEY);
            if (string != null) {
                return (OptionsProvider) Class.forName(string).asSubclass(OptionsProvider.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            throw new IllegalStateException("The fully qualified name of the implementation of OptionsProvider must be provided as a metadata in the AndroidManifest.xml with key com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME.");
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e10) {
            throw new IllegalStateException("Failed to initialize CastContext.", e10);
        }
    }

    private final Map<String, IBinder> zzh() {
        HashMap hashMap = new HashMap();
        zzo zzo = this.zzm;
        if (zzo != null) {
            hashMap.put(zzo.getCategory(), this.zzm.zza());
        }
        List<SessionProvider> list = this.zzl;
        if (list != null) {
            for (SessionProvider next : list) {
                Preconditions.checkNotNull(next, "Additional SessionProvider must not be null.");
                String checkNotEmpty = Preconditions.checkNotEmpty(next.getCategory(), "Category for SessionProvider must not be null or empty string.");
                Preconditions.checkArgument(!hashMap.containsKey(checkNotEmpty), String.format("SessionProvider for category %s already added", new Object[]{checkNotEmpty}));
                hashMap.put(checkNotEmpty, next.zza());
            }
        }
        return hashMap;
    }

    private final void zzi() {
        zzo zzo;
        if (!TextUtils.isEmpty(this.zzj.getReceiverApplicationId())) {
            zzo = new zzo(this.zzd, this.zzj, this.zzk);
        } else {
            zzo = null;
        }
        this.zzm = zzo;
    }

    private static final boolean zzj(CastSession castSession, double d10, boolean z10) {
        if (z10) {
            try {
                double volume = castSession.getVolume() + d10;
                if (volume > 1.0d) {
                    volume = 1.0d;
                }
                castSession.setVolume(volume);
            } catch (IOException | IllegalStateException e10) {
                zza.e("Unable to call CastSession.setVolume(double).", e10);
            }
        }
        return true;
    }

    @Deprecated
    public void addAppVisibilityListener(@RecentlyNonNull AppVisibilityListener appVisibilityListener) {
    }

    public void addCastStateListener(@RecentlyNonNull CastStateListener castStateListener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(castStateListener);
        this.zzf.zzc(castStateListener);
    }

    @RecentlyNonNull
    public CastOptions getCastOptions() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzj;
    }

    public int getCastReasonCodeForCastStatusCode(int i10) {
        CastReasonCodes castReasonCodes = this.zzn;
        if (castReasonCodes != null) {
            return castReasonCodes.zza(i10);
        }
        zza.w("castReasonCodes hasn't been initialized yet", new Object[0]);
        return 0;
    }

    public int getCastState() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzf.zza();
    }

    @RecentlyNonNull
    public MediaNotificationManager getMediaNotificationManager() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzi;
    }

    @RecentlyNullable
    public s0 getMergedSelector() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return s0.d(this.zze.zze());
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "getMergedSelectorAsBundle", zzw.class.getSimpleName());
            return null;
        }
    }

    @RecentlyNonNull
    public PrecacheManager getPrecacheManager() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzh;
    }

    @RecentlyNonNull
    public SessionManager getSessionManager() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzf;
    }

    @Deprecated
    public boolean isAppVisible() {
        return false;
    }

    public boolean onDispatchVolumeKeyEventBeforeJellyBean(@RecentlyNonNull KeyEvent keyEvent) {
        CastSession currentCastSession;
        boolean z10;
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (PlatformVersion.isAtLeastJellyBean() || (currentCastSession = this.zzf.getCurrentCastSession()) == null || !currentCastSession.isConnected()) {
            return false;
        }
        double volumeDeltaBeforeIceCreamSandwich = getCastOptions().getVolumeDeltaBeforeIceCreamSandwich();
        if (keyEvent.getAction() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 24) {
            zzj(currentCastSession, volumeDeltaBeforeIceCreamSandwich, z10);
            return true;
        } else if (keyCode != 25) {
            return false;
        } else {
            zzj(currentCastSession, -volumeDeltaBeforeIceCreamSandwich, z10);
            return true;
        }
    }

    @Deprecated
    public void removeAppVisibilityListener(@RecentlyNonNull AppVisibilityListener appVisibilityListener) {
    }

    public void removeCastStateListener(@RecentlyNonNull CastStateListener castStateListener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (castStateListener != null) {
            this.zzf.zzd(castStateListener);
        }
    }

    public void setLaunchCredentialsData(@RecentlyNonNull CredentialsData credentialsData) {
        LaunchOptions.Builder builder = new LaunchOptions.Builder(this.zzj.getLaunchOptions());
        builder.setCredentialsData(credentialsData);
        this.zzj.zza(builder.build());
        zzi();
    }

    public void setReceiverApplicationId(@RecentlyNonNull String str) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!TextUtils.equals(str, this.zzj.getReceiverApplicationId())) {
            this.zzj.zzb(str);
            zzi();
            try {
                this.zze.zzh(str, zzh());
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "setReceiverApplicationId", zzw.class.getSimpleName());
            }
            CastButtonFactory.zza(this.zzd);
        }
    }

    @ShowFirstParty
    public final zzr zzb() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzg;
    }

    public final /* synthetic */ void zzd(zzd zzd2, SharedPreferences sharedPreferences, Bundle bundle) {
        Preconditions.checkNotNull(this.zzf);
        String packageName = this.zzd.getPackageName();
        new zzh(sharedPreferences, zzd2, bundle, packageName).zzn(this.zzf);
    }

    public final /* synthetic */ void zze(Bundle bundle) {
        this.zzn = new CastReasonCodes(bundle);
    }

    public final boolean zzf() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return this.zze.zzi();
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "hasActivityInRecents", zzw.class.getSimpleName());
            return false;
        }
    }

    @RecentlyNonNull
    public static CastContext getSharedInstance(@RecentlyNonNull Context context) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (zzc == null) {
            synchronized (zzb) {
                if (zzc == null) {
                    OptionsProvider zzg2 = zzg(context.getApplicationContext());
                    CastOptions castOptions = zzg2.getCastOptions(context.getApplicationContext());
                    try {
                        zzc = new CastContext(context, castOptions, zzg2.getAdditionalSessionProviders(context.getApplicationContext()), new zzaj(t0.i(context), castOptions));
                    } catch (zzat e10) {
                        throw new RuntimeException(e10);
                    }
                }
            }
        }
        return zzc;
    }
}
