package ma;

import android.content.Context;
import com.umeng.analytics.pro.f;
import ha.c;
import ja.b;
import java.util.List;
import okhttp3.Dns;
import t9.i;

public final class o implements Dns {

    /* renamed from: a  reason: collision with root package name */
    public final Context f7916a;

    /* renamed from: b  reason: collision with root package name */
    public b f7917b = b.f7201f.a();

    public static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f19004a;

        public a(o oVar) {
            this.f19004a = oVar;
        }

        public void a(String str, String str2, String str3, String str4) {
            i.g(str, "type");
            i.g(str2, "hostnameMapper");
            i.g(str3, "mapper");
            i.g(str4, "resolver");
            d.f18993a.a(this.f19004a.a(), str, str2, str3, str4);
        }
    }

    public o(Context context) {
        i.g(context, f.X);
        this.f7916a = context;
    }

    public final Context a() {
        return this.f7916a;
    }

    public List lookup(String str) {
        i.g(str, "hostname");
        this.f7917b.o(new a(this));
        return this.f7917b.j(str, ".bigbee");
    }
}
