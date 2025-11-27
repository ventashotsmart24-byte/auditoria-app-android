package n0;

import android.content.Context;
import android.media.MediaRouter;
import android.media.RemoteControlClient;
import java.util.ArrayList;
import java.util.List;

public abstract class l1 {

    public interface a {
        void b(Object obj, Object obj2);

        void c(Object obj, Object obj2, int i10);

        void e(Object obj);

        void f(int i10, Object obj);

        void g(Object obj);

        void h(int i10, Object obj);

        void j(Object obj);

        void k(Object obj);
    }

    public static class b extends MediaRouter.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final a f7951a;

        public b(a aVar) {
            this.f7951a = aVar;
        }

        public void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f7951a.j(routeInfo);
        }

        public void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f7951a.e(routeInfo);
        }

        public void onRouteGrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup, int i10) {
            this.f7951a.c(routeInfo, routeGroup, i10);
        }

        public void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f7951a.g(routeInfo);
        }

        public void onRouteSelected(MediaRouter mediaRouter, int i10, MediaRouter.RouteInfo routeInfo) {
            this.f7951a.h(i10, routeInfo);
        }

        public void onRouteUngrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup) {
            this.f7951a.b(routeInfo, routeGroup);
        }

        public void onRouteUnselected(MediaRouter mediaRouter, int i10, MediaRouter.RouteInfo routeInfo) {
            this.f7951a.f(i10, routeInfo);
        }

        public void onRouteVolumeChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f7951a.k(routeInfo);
        }
    }

    public static final class c {
        public static CharSequence a(Object obj, Context context) {
            return ((MediaRouter.RouteInfo) obj).getName(context);
        }

        public static int b(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getPlaybackStream();
        }

        public static int c(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getPlaybackType();
        }

        public static int d(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getSupportedTypes();
        }

        public static Object e(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getTag();
        }

        public static int f(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getVolume();
        }

        public static int g(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getVolumeHandling();
        }

        public static int h(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getVolumeMax();
        }

        public static void i(Object obj, int i10) {
            ((MediaRouter.RouteInfo) obj).requestSetVolume(i10);
        }

        public static void j(Object obj, int i10) {
            ((MediaRouter.RouteInfo) obj).requestUpdateVolume(i10);
        }

        public static void k(Object obj, Object obj2) {
            ((MediaRouter.RouteInfo) obj).setTag(obj2);
        }
    }

    public static final class d {
        public static void a(Object obj, CharSequence charSequence) {
            ((MediaRouter.UserRouteInfo) obj).setName(charSequence);
        }

        public static void b(Object obj, int i10) {
            ((MediaRouter.UserRouteInfo) obj).setPlaybackStream(i10);
        }

        public static void c(Object obj, int i10) {
            ((MediaRouter.UserRouteInfo) obj).setPlaybackType(i10);
        }

        public static void d(Object obj, Object obj2) {
            ((MediaRouter.UserRouteInfo) obj).setRemoteControlClient((RemoteControlClient) obj2);
        }

        public static void e(Object obj, int i10) {
            ((MediaRouter.UserRouteInfo) obj).setVolume(i10);
        }

        public static void f(Object obj, Object obj2) {
            ((MediaRouter.UserRouteInfo) obj).setVolumeCallback((MediaRouter.VolumeCallback) obj2);
        }

        public static void g(Object obj, int i10) {
            ((MediaRouter.UserRouteInfo) obj).setVolumeHandling(i10);
        }

        public static void h(Object obj, int i10) {
            ((MediaRouter.UserRouteInfo) obj).setVolumeMax(i10);
        }
    }

    public interface e {
        void a(Object obj, int i10);

        void d(Object obj, int i10);
    }

    public static class f extends MediaRouter.VolumeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final e f7952a;

        public f(e eVar) {
            this.f7952a = eVar;
        }

        public void onVolumeSetRequest(MediaRouter.RouteInfo routeInfo, int i10) {
            this.f7952a.d(routeInfo, i10);
        }

        public void onVolumeUpdateRequest(MediaRouter.RouteInfo routeInfo, int i10) {
            this.f7952a.a(routeInfo, i10);
        }
    }

    public static void a(Object obj, Object obj2) {
        ((MediaRouter) obj).addUserRoute((MediaRouter.UserRouteInfo) obj2);
    }

    public static Object b(Object obj, String str, boolean z10) {
        return ((MediaRouter) obj).createRouteCategory(str, z10);
    }

    public static Object c(Object obj, Object obj2) {
        return ((MediaRouter) obj).createUserRoute((MediaRouter.RouteCategory) obj2);
    }

    public static Object d(e eVar) {
        return new f(eVar);
    }

    public static Object e(Context context) {
        return context.getSystemService("media_router");
    }

    public static List f(Object obj) {
        MediaRouter mediaRouter = (MediaRouter) obj;
        int routeCount = mediaRouter.getRouteCount();
        ArrayList arrayList = new ArrayList(routeCount);
        for (int i10 = 0; i10 < routeCount; i10++) {
            arrayList.add(mediaRouter.getRouteAt(i10));
        }
        return arrayList;
    }

    public static Object g(Object obj, int i10) {
        return ((MediaRouter) obj).getSelectedRoute(i10);
    }

    public static void h(Object obj, Object obj2) {
        ((MediaRouter) obj).removeCallback((MediaRouter.Callback) obj2);
    }

    public static void i(Object obj, Object obj2) {
        ((MediaRouter) obj).removeUserRoute((MediaRouter.UserRouteInfo) obj2);
    }

    public static void j(Object obj, int i10, Object obj2) {
        ((MediaRouter) obj).selectRoute(i10, (MediaRouter.RouteInfo) obj2);
    }
}
