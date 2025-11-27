package com.google.android.gms.cast.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

public final class zzn extends GoogleApi<Api.ApiOptions.NoOptions> {
    private static final Api.ClientKey<zzo> zza;
    private static final Api.AbstractClientBuilder<zzo, Api.ApiOptions.NoOptions> zzb;
    private static final Api<Api.ApiOptions.NoOptions> zzc;

    static {
        Api.ClientKey<zzo> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzi zzi = new zzi();
        zzb = zzi;
        zzc = new Api<>("CastApi.API", zzi, clientKey);
    }

    public zzn(Context context) {
        super(context, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
