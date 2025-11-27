package com.google.android.gms.cast.framework;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.RecentlyNonNull;
import androidx.mediarouter.app.MediaRouteActionProvider;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.mediarouter.app.e;
import b0.t;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzju;
import com.google.android.gms.internal.cast.zzl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import n0.s0;

public final class CastButtonFactory {
    private static final Logger zza = new Logger("CastButtonFactory");
    private static final List<WeakReference<MenuItem>> zzb = new ArrayList();
    private static final List<WeakReference<MediaRouteButton>> zzc = new ArrayList();

    private CastButtonFactory() {
    }

    @RecentlyNonNull
    public static MenuItem setUpMediaRouteButton(@RecentlyNonNull Context context, @RecentlyNonNull Menu menu, int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(menu);
        MenuItem findItem = menu.findItem(i10);
        if (findItem != null) {
            try {
                zzb(context, findItem, (e) null);
                zzb.add(new WeakReference(findItem));
                zzl.zzd(zzju.CAST_DEFAULT_MEDIA_ROUTER_DIALOG);
                return findItem;
            } catch (IllegalArgumentException unused) {
                throw new IllegalArgumentException(String.format(Locale.ROOT, "menu item with ID %d doesn't have a MediaRouteActionProvider.", new Object[]{Integer.valueOf(i10)}));
            }
        } else {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "menu doesn't contain a menu item whose ID is %d.", new Object[]{Integer.valueOf(i10)}));
        }
    }

    public static void zza(@RecentlyNonNull Context context) {
        for (WeakReference<MenuItem> weakReference : zzb) {
            MenuItem menuItem = (MenuItem) weakReference.get();
            if (menuItem != null) {
                try {
                    zzb(context, menuItem, (e) null);
                } catch (IllegalArgumentException e10) {
                    zza.w("Unexpected exception when refreshing MediaRouteSelectors for Cast buttons", e10);
                }
            }
        }
        for (WeakReference<MediaRouteButton> weakReference2 : zzc) {
            MediaRouteButton mediaRouteButton = (MediaRouteButton) weakReference2.get();
            if (mediaRouteButton != null) {
                zzc(context, mediaRouteButton, (e) null);
            }
        }
    }

    private static void zzb(Context context, MenuItem menuItem, e eVar) {
        s0 mergedSelector;
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaRouteActionProvider mediaRouteActionProvider = (MediaRouteActionProvider) t.a(menuItem);
        if (mediaRouteActionProvider != null) {
            CastContext zza2 = CastContext.zza(context);
            if (zza2 != null && (mergedSelector = zza2.getMergedSelector()) != null) {
                mediaRouteActionProvider.o(mergedSelector);
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    private static void zzc(Context context, MediaRouteButton mediaRouteButton, e eVar) {
        s0 mergedSelector;
        Preconditions.checkMainThread("Must be called from the main thread.");
        CastContext zza2 = CastContext.zza(context);
        if (zza2 != null && (mergedSelector = zza2.getMergedSelector()) != null) {
            mediaRouteButton.setRouteSelector(mergedSelector);
        }
    }

    public static void setUpMediaRouteButton(@RecentlyNonNull Context context, @RecentlyNonNull MediaRouteButton mediaRouteButton) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (mediaRouteButton != null) {
            zzc(context, mediaRouteButton, (e) null);
            zzc.add(new WeakReference(mediaRouteButton));
        }
        zzl.zzd(zzju.CAST_DEFAULT_MEDIA_ROUTER_DIALOG);
    }
}
