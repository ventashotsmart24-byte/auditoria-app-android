package n0;

import android.media.MediaRoute2Info;
import android.media.RouteDiscoveryPreference;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import n0.n0;

public abstract class i1 {
    public static List a(List list) {
        if (list == null) {
            return new ArrayList();
        }
        return (List) list.stream().filter(new h1()).map(new f1()).collect(Collectors.toList());
    }

    public static RouteDiscoveryPreference b(o0 o0Var) {
        if (o0Var == null || !o0Var.e()) {
            return new RouteDiscoveryPreference.Builder(new ArrayList(), false).build();
        }
        return new RouteDiscoveryPreference.Builder((List) o0Var.c().e().stream().map(new g1()).collect(Collectors.toList()), o0Var.d()).build();
    }

    public static n0 c(MediaRoute2Info mediaRoute2Info) {
        if (mediaRoute2Info == null) {
            return null;
        }
        n0.a f10 = new n0.a(mediaRoute2Info.getId(), mediaRoute2Info.getName().toString()).g(mediaRoute2Info.getConnectionState()).s(mediaRoute2Info.getVolumeHandling()).t(mediaRoute2Info.getVolumeMax()).r(mediaRoute2Info.getVolume()).k(mediaRoute2Info.getExtras()).j(true).f(false);
        CharSequence a10 = mediaRoute2Info.getDescription();
        if (a10 != null) {
            f10.h(a10.toString());
        }
        Uri a11 = mediaRoute2Info.getIconUri();
        if (a11 != null) {
            f10.l(a11);
        }
        Bundle a12 = mediaRoute2Info.getExtras();
        if (a12 == null || !a12.containsKey("androidx.mediarouter.media.KEY_EXTRAS") || !a12.containsKey("androidx.mediarouter.media.KEY_DEVICE_TYPE") || !a12.containsKey("androidx.mediarouter.media.KEY_CONTROL_FILTERS")) {
            return null;
        }
        f10.k(a12.getBundle("androidx.mediarouter.media.KEY_EXTRAS"));
        f10.i(a12.getInt("androidx.mediarouter.media.KEY_DEVICE_TYPE", 0));
        f10.p(a12.getInt("androidx.mediarouter.media.KEY_PLAYBACK_TYPE", 1));
        ArrayList parcelableArrayList = a12.getParcelableArrayList("androidx.mediarouter.media.KEY_CONTROL_FILTERS");
        if (parcelableArrayList != null) {
            f10.b(parcelableArrayList);
        }
        return f10.e();
    }

    public static String d(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -2065577523:
                if (str.equals("android.media.intent.category.REMOTE_PLAYBACK")) {
                    c10 = 0;
                    break;
                }
                break;
            case 956939050:
                if (str.equals("android.media.intent.category.LIVE_AUDIO")) {
                    c10 = 1;
                    break;
                }
                break;
            case 975975375:
                if (str.equals("android.media.intent.category.LIVE_VIDEO")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return "android.media.route.feature.REMOTE_PLAYBACK";
            case 1:
                return "android.media.route.feature.LIVE_AUDIO";
            case 2:
                return "android.media.route.feature.LIVE_VIDEO";
            default:
                return str;
        }
    }
}
