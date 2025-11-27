package q5;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.view.OrientationEventListener;
import com.umeng.analytics.pro.f;
import t9.g;
import t9.i;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public Activity f19327a;

    /* renamed from: b  reason: collision with root package name */
    public e f19328b;

    /* renamed from: c  reason: collision with root package name */
    public c f19329c;

    /* renamed from: d  reason: collision with root package name */
    public int f19330d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19331e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19332f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19333g;

    public static final class a extends e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f19334a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f19335b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(j jVar, d dVar, Activity activity) {
            super(activity);
            this.f19334a = jVar;
            this.f19335b = dVar;
        }

        public void a() {
            if (this.f19334a.h().getResources().getConfiguration().orientation == 2) {
                this.f19334a.v(true);
            }
            if (this.f19334a.k() && this.f19334a.j() && this.f19334a.h().getResources().getConfiguration().orientation == 1) {
                this.f19334a.r();
                d dVar = this.f19335b;
                if (dVar != null) {
                    dVar.b();
                }
            }
        }

        public void b() {
            if (this.f19334a.h().getResources().getConfiguration().orientation == 1) {
                this.f19334a.v(true);
            }
            if (this.f19334a.k() && this.f19334a.j() && this.f19334a.h().getResources().getConfiguration().orientation == 2) {
                this.f19334a.r();
                d dVar = this.f19335b;
                if (dVar != null) {
                    dVar.a();
                }
            }
        }
    }

    public static final class b extends c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f19336f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(j jVar, ContentResolver contentResolver) {
            super(contentResolver, "accelerometer_rotation");
            this.f19336f = jVar;
            i.f(contentResolver, "contentResolver");
        }

        public void a() {
            j jVar = this.f19336f;
            jVar.w(jVar.o());
        }

        public void b() {
            j jVar = this.f19336f;
            jVar.w(jVar.o());
            if (this.f19336f.k()) {
                this.f19336f.r();
            } else {
                this.f19336f.u();
            }
        }
    }

    public static abstract class c extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public final String f19337a = "DataObserver";

        /* renamed from: b  reason: collision with root package name */
        public ContentResolver f19338b;

        /* renamed from: c  reason: collision with root package name */
        public String f19339c;

        /* renamed from: d  reason: collision with root package name */
        public Uri f19340d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f19341e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ContentResolver contentResolver, String str) {
            super((Handler) null);
            i.g(contentResolver, "contentResolver");
            i.g(str, "action");
            this.f19338b = contentResolver;
            this.f19339c = str;
        }

        public abstract void a();

        public abstract void b();

        public final void c() {
            a();
            if (!this.f19341e) {
                this.f19341e = true;
                String str = this.f19339c;
                if (str != null) {
                    this.f19338b.registerContentObserver(Settings.System.getUriFor(str), false, this);
                    return;
                }
                Uri uri = this.f19340d;
                if (uri != null) {
                    ContentResolver contentResolver = this.f19338b;
                    i.d(uri);
                    contentResolver.registerContentObserver(uri, false, this);
                }
            }
        }

        public final void d() {
            if (this.f19341e) {
                this.f19341e = false;
                this.f19338b.unregisterContentObserver(this);
            }
        }

        public void onChange(boolean z10) {
            super.onChange(z10);
            b();
        }
    }

    public interface d {
        void a();

        void b();
    }

    public static abstract class e extends OrientationEventListener {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Context context) {
            super(context);
            i.g(context, f.X);
        }

        public abstract void a();

        public abstract void b();

        public void onOrientationChanged(int i10) {
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13 = true;
            if (i10 < 0 || i10 >= 31) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10 && i10 < 330) {
                if (150 > i10 || i10 >= 211) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (!z11) {
                    if (90 > i10 || i10 >= 121) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (!z12) {
                        if (240 > i10 || i10 >= 301) {
                            z13 = false;
                        }
                        if (!z13) {
                            return;
                        }
                    }
                    a();
                    return;
                }
            }
            b();
        }
    }

    public j(Activity activity, d dVar) {
        i.g(activity, "activity");
        this.f19327a = activity;
        this.f19330d = 1;
        this.f19332f = o();
        this.f19330d = this.f19327a.getRequestedOrientation();
        this.f19328b = new a(this, dVar, this.f19327a);
        this.f19329c = new b(this, this.f19327a.getContentResolver());
    }

    public final void a() {
        this.f19333g = false;
        this.f19328b.disable();
        this.f19329c.d();
    }

    public final void b() {
        this.f19327a.setRequestedOrientation(this.f19330d);
        a();
    }

    public final void c() {
        this.f19327a.getResources().getConfiguration().orientation = 1;
        this.f19327a.setRequestedOrientation(this.f19330d);
        a();
    }

    public final void d() {
        this.f19333g = true;
        this.f19328b.enable();
        this.f19329c.c();
    }

    public final void e() {
        d();
    }

    public final void f() {
        r();
        d();
    }

    public final void g() {
        if (l() || this.f19327a.getResources().getConfiguration().orientation == 2) {
            u();
            d();
        }
    }

    public final Activity h() {
        return this.f19327a;
    }

    public final boolean i() {
        return this.f19333g;
    }

    public final boolean j() {
        return this.f19331e;
    }

    public final boolean k() {
        return this.f19332f;
    }

    public final boolean l() {
        if (this.f19327a.getRequestedOrientation() == 0 || this.f19327a.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public final boolean m() {
        if (this.f19327a.getRequestedOrientation() == 14) {
            return true;
        }
        return false;
    }

    public final boolean n() {
        if (this.f19327a.getRequestedOrientation() == 1 || this.f19327a.getRequestedOrientation() == 7 || this.f19327a.getResources().getConfiguration().orientation == 1) {
            return true;
        }
        return false;
    }

    public final boolean o() {
        if (Settings.System.getInt(this.f19327a.getContentResolver(), "accelerometer_rotation", 0) == 1) {
            return true;
        }
        return false;
    }

    public final void p(s9.a aVar) {
        i.g(aVar, "callback");
        if (l() || this.f19327a.getResources().getConfiguration().orientation == 2) {
            u();
            d();
            return;
        }
        aVar.invoke();
        this.f19327a.finish();
    }

    public final void q() {
        if (n()) {
            s();
        } else {
            u();
        }
    }

    public final void r() {
        this.f19327a.setRequestedOrientation(4);
    }

    public final void s() {
        this.f19327a.getResources().getConfiguration().orientation = 2;
        this.f19327a.setRequestedOrientation(0);
        this.f19331e = false;
    }

    public final void t() {
        this.f19327a.setRequestedOrientation(14);
        a();
    }

    public final void u() {
        this.f19327a.getResources().getConfiguration().orientation = 1;
        this.f19327a.setRequestedOrientation(1);
        this.f19331e = false;
    }

    public final void v(boolean z10) {
        this.f19331e = z10;
    }

    public final void w(boolean z10) {
        this.f19332f = z10;
    }

    public final void x() {
        d();
        r();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(Activity activity, d dVar, int i10, g gVar) {
        this(activity, (i10 & 2) != 0 ? null : dVar);
    }
}
