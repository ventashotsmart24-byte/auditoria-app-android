package b8;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.umeng.analytics.pro.f;
import t9.g;
import t9.i;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0148a f11196a = new C0148a((g) null);

    /* renamed from: b8.a$a  reason: collision with other inner class name */
    public static final class C0148a {
        public C0148a() {
        }

        public /* synthetic */ C0148a(g gVar) {
            this();
        }

        public final boolean a(Context context) {
            i.g(context, f.X);
            Object systemService = context.getSystemService("connectivity");
            i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            NetworkInfo networkInfo = ((ConnectivityManager) systemService).getNetworkInfo(0);
            if (networkInfo == null || !networkInfo.isConnected()) {
                return false;
            }
            return true;
        }

        public final boolean b(Context context) {
            i.g(context, f.X);
            Object systemService = context.getSystemService("connectivity");
            i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        }

        public final boolean c(Context context) {
            i.g(context, f.X);
            Object systemService = context.getSystemService("connectivity");
            i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            NetworkInfo networkInfo = ((ConnectivityManager) systemService).getNetworkInfo(1);
            if (networkInfo == null || !networkInfo.isConnected()) {
                return false;
            }
            return true;
        }
    }
}
