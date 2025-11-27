package com.google.android.gms.internal.cast;

import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.internal.zzi;
import com.google.android.gms.cast.framework.media.internal.zzk;
import com.google.android.gms.cast.framework.zzag;
import com.google.android.gms.cast.framework.zzaj;
import com.google.android.gms.cast.framework.zzar;
import com.google.android.gms.cast.framework.zzat;
import com.google.android.gms.cast.framework.zzt;
import com.google.android.gms.cast.framework.zzw;
import com.google.android.gms.cast.framework.zzz;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.Map;

public final class zzm {
    private static final Logger zza = new Logger("CastDynamiteModule");

    public static zzw zza(Context context, CastOptions castOptions, zzs zzs, Map<String, IBinder> map) {
        return zzf(context).zze(ObjectWrapper.wrap(context.getApplicationContext()), castOptions, zzs, map);
    }

    public static zzz zzb(Context context, CastOptions castOptions, IObjectWrapper iObjectWrapper, zzt zzt) {
        if (iObjectWrapper == null) {
            return null;
        }
        try {
            return zzf(context).zzf(castOptions, iObjectWrapper, zzt);
        } catch (RemoteException | zzat e10) {
            zza.d(e10, "Unable to call %s on %s.", "newCastSessionImpl", zzq.class.getSimpleName());
            return null;
        }
    }

    public static zzag zzc(Service service, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        if (!(iObjectWrapper == null || iObjectWrapper2 == null)) {
            try {
                return zzf(service.getApplicationContext()).zzg(ObjectWrapper.wrap(service), iObjectWrapper, iObjectWrapper2);
            } catch (RemoteException | zzat e10) {
                zza.d(e10, "Unable to call %s on %s.", "newReconnectionServiceImpl", zzq.class.getSimpleName());
            }
        }
        return null;
    }

    public static zzaj zzd(Context context, String str, String str2, zzar zzar) {
        try {
            return zzf(context).zzh(str, str2, zzar);
        } catch (RemoteException | zzat e10) {
            zza.d(e10, "Unable to call %s on %s.", "newSessionImpl", zzq.class.getSimpleName());
            return null;
        }
    }

    public static zzi zze(Context context, AsyncTask<Uri, Long, Bitmap> asyncTask, zzk zzk, int i10, int i11, boolean z10, long j10, int i12, int i13, int i14) {
        try {
            return zzf(context.getApplicationContext()).zzi(ObjectWrapper.wrap(asyncTask), zzk, i10, i11, false, 2097152, 5, 333, 10000);
        } catch (RemoteException | zzat e10) {
            zza.d(e10, "Unable to call %s on %s.", "newFetchBitmapTaskImpl", zzq.class.getSimpleName());
            return null;
        }
    }

    private static zzq zzf(Context context) {
        try {
            IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.cast.framework.dynamite").instantiate("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl");
            if (instantiate == null) {
                return null;
            }
            IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
            if (queryLocalInterface instanceof zzq) {
                return (zzq) queryLocalInterface;
            }
            return new zzp(instantiate);
        } catch (DynamiteModule.LoadingException e10) {
            throw new zzat(e10);
        }
    }
}
