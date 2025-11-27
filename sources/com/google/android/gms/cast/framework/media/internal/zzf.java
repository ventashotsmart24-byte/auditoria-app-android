package com.google.android.gms.cast.framework.media.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.internal.cast.zzm;

public final class zzf extends AsyncTask<Uri, Long, Bitmap> {
    private static final Logger zza = new Logger("FetchBitmapTask");
    private final zzi zzb;
    private final zzb zzc;

    public zzf(Context context, int i10, int i11, boolean z10, long j10, int i12, int i13, int i14, zzb zzb2, byte[] bArr) {
        this.zzc = zzb2;
        this.zzb = zzm.zze(context.getApplicationContext(), this, new zze(this, (zzd) null), i10, i11, false, 2097152, 5, 333, 10000);
    }

    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        Uri uri;
        zzi zzi;
        Uri[] uriArr = (Uri[]) objArr;
        if (uriArr.length != 1 || (uri = uriArr[0]) == null || (zzi = this.zzb) == null) {
            return null;
        }
        try {
            return zzi.zze(uri);
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "doFetch", zzi.class.getSimpleName());
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        zzb zzb2 = this.zzc;
        if (zzb2 != null) {
            zzb2.zzb(bitmap);
        }
    }
}
