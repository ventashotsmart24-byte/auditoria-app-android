package z1;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bigbee.bean.ServerTime;
import com.dcs.bean.DomainInfo;
import com.google.gson.Gson;
import com.taobao.accs.utl.BaseMonitor;
import f2.b;
import f2.d;
import f2.e;
import i2.f;
import i2.h;
import okhttp3.Dns;
import okhttp3.Interceptor;
import t9.i;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f9920a = a.class.getSimpleName();

    /* renamed from: z1.a$a  reason: collision with other inner class name */
    public static final class C0139a implements b {
        public void a(d dVar, g2.a aVar) {
            i.g(dVar, "request");
            i.g(aVar, "response");
            i2.a aVar2 = i2.a.f6993a;
            aVar2.k(false);
            if (!aVar.d() || TextUtils.isEmpty(aVar.b())) {
                aVar2.m(SystemClock.elapsedRealtime());
                return;
            }
            try {
                ServerTime serverTime = (ServerTime) new Gson().fromJson(aVar.b(), ServerTime.class);
                if (serverTime != null) {
                    h.f7019a.b(serverTime.getTimestamp());
                    aVar2.m(SystemClock.elapsedRealtime());
                }
            } catch (Exception unused) {
            }
        }

        public void b(d dVar, Exception exc) {
            i.g(dVar, "request");
            i.g(exc, "e");
            i2.a aVar = i2.a.f6993a;
            aVar.k(false);
            aVar.m(SystemClock.elapsedRealtime());
            exc.printStackTrace();
            if (b2.a.f4202d != null) {
                t2.a aVar2 = t2.a.f9350a;
                DomainInfo domainInfo = b2.a.f4202d;
                i.f(domainInfo, "TDC");
                aVar2.q(domainInfo, "key_tdc");
            }
        }
    }

    public final void a(Dns dns, Interceptor interceptor) {
        String str;
        i.g(dns, BaseMonitor.COUNT_POINT_DNS);
        f fVar = f.f7018a;
        String str2 = b2.a.f4203e;
        i.f(str2, "URL_HOST_MAIN");
        if (fVar.b(str2)) {
            str = "http://";
        } else {
            str = "https://";
        }
        i2.a.f6993a.k(true);
        e2.a.f6467b.a().c(new f2.a().i(str + b2.a.f4203e + b2.a.f4201c + b2.a.f4200b, str + b2.a.f4204f + b2.a.f4201c + b2.a.f4200b).h(e.GET).b(dns).f(interceptor).a(new C0139a()));
    }
}
