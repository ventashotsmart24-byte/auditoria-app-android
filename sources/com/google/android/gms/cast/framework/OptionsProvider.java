package com.google.android.gms.cast.framework;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import java.util.List;

public interface OptionsProvider {
    @RecentlyNullable
    List<SessionProvider> getAdditionalSessionProviders(@RecentlyNonNull Context context);

    @RecentlyNonNull
    CastOptions getCastOptions(@RecentlyNonNull Context context);
}
