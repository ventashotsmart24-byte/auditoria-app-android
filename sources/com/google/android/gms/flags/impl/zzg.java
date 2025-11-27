package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzg implements Callable<Long> {
    private final /* synthetic */ SharedPreferences zzo;
    private final /* synthetic */ String zzp;
    private final /* synthetic */ Long zzs;

    public zzg(SharedPreferences sharedPreferences, String str, Long l10) {
        this.zzo = sharedPreferences;
        this.zzp = str;
        this.zzs = l10;
    }

    public final /* synthetic */ Object call() {
        return Long.valueOf(this.zzo.getLong(this.zzp, this.zzs.longValue()));
    }
}
