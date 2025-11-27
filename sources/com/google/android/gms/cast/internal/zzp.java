package com.google.android.gms.cast.internal;

import android.text.TextUtils;

public class zzp {
    protected final Logger zza;
    private final String zzb;
    private zzaq zzc;

    public zzp(String str, String str2, String str3) {
        CastUtils.throwIfInvalidNamespace(str);
        this.zzb = str;
        Logger logger = new Logger("MediaControlChannel");
        this.zza = logger;
        if (!TextUtils.isEmpty((CharSequence) null)) {
            logger.zzc((String) null);
        }
    }

    public final long zzd() {
        zzaq zzaq = this.zzc;
        if (zzaq != null) {
            return zzaq.zza();
        }
        this.zza.e("Attempt to generate requestId without a sink", new Object[0]);
        return 0;
    }

    public final String zze() {
        return this.zzb;
    }

    public void zzf() {
        throw null;
    }

    public final void zzg(String str, long j10, String str2) {
        zzaq zzaq = this.zzc;
        if (zzaq == null) {
            this.zza.e("Attempt to send text message without a sink", new Object[0]);
        } else {
            zzaq.zzb(this.zzb, str, j10, (String) null);
        }
    }

    public final void zzh(zzaq zzaq) {
        this.zzc = zzaq;
        if (zzaq == null) {
            zzf();
        }
    }
}
