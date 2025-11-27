package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Locale;

@KeepForSdk
public class Logger {
    @RecentlyNonNull
    protected final String zza;
    private final boolean zzb;
    private boolean zzc;
    private String zzd;

    @KeepForSdk
    public Logger(@RecentlyNonNull String str) {
        boolean z10;
        Preconditions.checkNotEmpty(str, "The log tag cannot be null or empty.");
        this.zza = str;
        if (str.length() <= 23) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzb = z10;
        this.zzc = false;
    }

    @KeepForSdk
    public void d(@RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        if (zzd()) {
            zza(str, objArr);
        }
    }

    @KeepForSdk
    public void e(@RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        Log.e(this.zza, zza(str, objArr));
    }

    @KeepForSdk
    public void i(@RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        zza(str, objArr);
    }

    @KeepForSdk
    public void v(@RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
    }

    @KeepForSdk
    public void w(@RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        zza(str, objArr);
    }

    @RecentlyNonNull
    public final String zza(@RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(Locale.ROOT, str, objArr);
        }
        if (TextUtils.isEmpty(this.zzd)) {
            return str;
        }
        String valueOf = String.valueOf(this.zzd);
        String valueOf2 = String.valueOf(str);
        if (valueOf2.length() != 0) {
            return valueOf.concat(valueOf2);
        }
        return new String(valueOf);
    }

    public final void zzb(boolean z10) {
        this.zzc = true;
    }

    public final void zzc(@RecentlyNonNull String str) {
        String str2 = null;
        if (!TextUtils.isEmpty((CharSequence) null)) {
            str2 = String.format("[%s] ", new Object[]{null});
        }
        this.zzd = str2;
    }

    public final boolean zzd() {
        if (this.zzc) {
            return true;
        }
        if (!this.zzb || !Log.isLoggable(this.zza, 3)) {
            return false;
        }
        return true;
    }

    @KeepForSdk
    public void e(@RecentlyNonNull Throwable th, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        Log.e(this.zza, zza(str, objArr), th);
    }

    @KeepForSdk
    public void i(@RecentlyNonNull Throwable th, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        zza(str, objArr);
    }

    @KeepForSdk
    public void w(@RecentlyNonNull Throwable th, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        zza(str, objArr);
    }

    @KeepForSdk
    public void d(@RecentlyNonNull Throwable th, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        if (zzd()) {
            zza(str, objArr);
        }
    }
}
