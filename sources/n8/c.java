package n8;

import android.content.Context;
import android.os.SystemClock;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.umeng.analytics.pro.f;
import java.util.Arrays;
import l8.h;
import r8.a;
import r8.b;
import t9.i;
import t9.z;

public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public final String f19050a = c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public int f19051b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f19052c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f19053d;

    /* renamed from: e  reason: collision with root package name */
    public r8.a f19054e;

    /* renamed from: f  reason: collision with root package name */
    public int f19055f;

    /* renamed from: g  reason: collision with root package name */
    public int f19056g = 3;

    /* renamed from: h  reason: collision with root package name */
    public String f19057h = "";

    /* renamed from: i  reason: collision with root package name */
    public final a.C0281a f19058i = new a(this);

    public static final class a implements a.C0281a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f19059a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f19060b;

        public a(c cVar) {
            this.f19060b = cVar;
        }

        public void a(a.b bVar) {
            i.g(bVar, "holder");
            this.f19059a = true;
            if (i.b(bVar.getRenderView(), this.f19060b.f19054e)) {
                this.f19060b.f19053d = null;
                h.f7639m.a().I(this.f19060b.f19051b, (Surface) null, this.f19060b.j());
            }
        }

        public void b(a.b bVar, int i10, int i11) {
            i.g(bVar, "holder");
            if (i.b(bVar.getRenderView(), this.f19060b.f19054e)) {
                this.f19060b.f19053d = bVar;
                this.f19060b.l(String.valueOf(SystemClock.elapsedRealtime()));
                h.f7639m.a().I(this.f19060b.f19051b, bVar.openSurface(), this.f19060b.j());
            }
        }

        public void c(a.b bVar, int i10, int i11, int i12) {
            i.g(bVar, "holder");
            i.b(bVar.getRenderView(), this.f19060b.f19054e);
        }

        public void d(int i10, int i11) {
        }
    }

    public void a(ViewGroup viewGroup) {
        i.g(viewGroup, "videoView");
        this.f19052c = viewGroup;
    }

    public void b(int i10, String str, Context context, Integer num) {
        int i11;
        i.g(str, "value");
        h a10 = h.f7639m.a();
        if (num != null) {
            i11 = num.intValue();
        } else {
            i11 = 0;
        }
        a10.H(i10, "player", str, context, i11);
    }

    public void c(int i10, int i11) {
        View view;
        r8.a aVar = this.f19054e;
        if (aVar != null) {
            aVar.setVideoSize(i10, i11);
        }
        r8.a aVar2 = this.f19054e;
        if (aVar2 != null && (view = aVar2.getView()) != null) {
            view.requestLayout();
        }
    }

    public void d(int i10) {
        this.f19051b = i10;
    }

    public void e(Context context, int i10) {
        i.g(context, f.X);
        if (i10 == 0) {
            k((r8.a) null);
        } else if (i10 == 1) {
            k(new b(context));
        } else if (i10 != 2) {
            z zVar = z.f19601a;
            i.f(String.format("invalid render %d\n", Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1)), "format(format, *args)");
        } else {
            k(new r8.c(context));
        }
    }

    public void f() {
        this.f19052c = null;
    }

    public View getRenderView() {
        r8.a aVar = this.f19054e;
        if (aVar != null) {
            return aVar.getView();
        }
        return null;
    }

    public final String j() {
        return this.f19057h;
    }

    public final void k(r8.a aVar) {
        if (this.f19054e != null) {
            h.f7639m.a().I(this.f19051b, (Surface) null, this.f19057h);
            r8.a aVar2 = this.f19054e;
            i.d(aVar2);
            View view = aVar2.getView();
            i.f(view, "mRenderView!!.view");
            r8.a aVar3 = this.f19054e;
            i.d(aVar3);
            aVar3.a(this.f19058i);
            this.f19054e = null;
            ViewGroup viewGroup = this.f19052c;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        if (aVar != null) {
            this.f19054e = aVar;
            aVar.setAspectRatio(this.f19056g);
            r8.a aVar4 = this.f19054e;
            i.d(aVar4);
            View view2 = aVar4.getView();
            i.f(view2, "mRenderView!!.getView()");
            if (this.f19051b == 1 && (view2 instanceof SurfaceView)) {
                ((SurfaceView) view2).setZOrderMediaOverlay(true);
            }
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            ViewGroup viewGroup2 = this.f19052c;
            if (viewGroup2 != null) {
                viewGroup2.addView(view2);
            }
            r8.a aVar5 = this.f19054e;
            i.d(aVar5);
            aVar5.b(this.f19058i);
            r8.a aVar6 = this.f19054e;
            i.d(aVar6);
            aVar6.setVideoRotation(this.f19055f);
        }
    }

    public final void l(String str) {
        i.g(str, "<set-?>");
        this.f19057h = str;
    }

    public void setAspectRatio(int i10) {
        this.f19056g = i10;
        r8.a aVar = this.f19054e;
        if (aVar != null) {
            i.d(aVar);
            aVar.setAspectRatio(this.f19056g);
        }
    }
}
