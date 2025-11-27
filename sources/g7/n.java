package g7;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.bean.AudioTrackBean;
import com.mobile.brasiltv.bean.NoSubTitleData;
import com.mobile.brasiltv.bean.OffSubTitleData;
import com.mobile.brasiltv.bean.SubTitleData;
import com.mobile.brasiltv.bean.SubtitleStyleBean;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.ArrayList;
import n6.i;
import t9.j;

public final class n extends b {

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f17241b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f17242c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f17243d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f17244e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f17245f;

    /* renamed from: g  reason: collision with root package name */
    public final AutoLinearLayout f17246g;

    /* renamed from: h  reason: collision with root package name */
    public final AutoLinearLayout f17247h;

    /* renamed from: i  reason: collision with root package name */
    public final h9.g f17248i;

    /* renamed from: j  reason: collision with root package name */
    public final h9.g f17249j;

    /* renamed from: k  reason: collision with root package name */
    public final h9.g f17250k;

    /* renamed from: l  reason: collision with root package name */
    public final h9.g f17251l;

    /* renamed from: m  reason: collision with root package name */
    public e f17252m;

    public static final class a implements i.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f17253a;

        public a(n nVar) {
            this.f17253a = nVar;
        }

        /* renamed from: b */
        public void a(int i10, AudioTrackBean audioTrackBean) {
            t9.i.g(audioTrackBean, "data");
            e h10 = this.f17253a.f17252m;
            if (h10 != null) {
                h10.c(i10, audioTrackBean);
            }
        }
    }

    public static final class b implements i.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f17254a;

        public b(n nVar) {
            this.f17254a = nVar;
        }

        /* renamed from: b */
        public void a(int i10, SubTitleData subTitleData) {
            t9.i.g(subTitleData, "data");
            if (subTitleData instanceof OffSubTitleData) {
                this.f17254a.q(false);
                e h10 = this.f17254a.f17252m;
                if (h10 != null) {
                    h10.b(false);
                }
            } else if (!(subTitleData instanceof NoSubTitleData)) {
                this.f17254a.q(true);
                e h11 = this.f17254a.f17252m;
                if (h11 != null) {
                    h11.a(i10, subTitleData);
                }
            }
        }
    }

    public static final class c implements i.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f17255a;

        public c(n nVar) {
            this.f17255a = nVar;
        }

        /* renamed from: b */
        public void a(int i10, SubtitleStyleBean subtitleStyleBean) {
            t9.i.g(subtitleStyleBean, "data");
            e h10 = this.f17255a.f17252m;
            if (h10 != null) {
                h10.e(i10);
            }
        }
    }

    public static final class d implements i.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f17256a;

        public d(n nVar) {
            this.f17256a = nVar;
        }

        /* renamed from: b */
        public void a(int i10, String str) {
            t9.i.g(str, "data");
            e h10 = this.f17256a.f17252m;
            if (h10 != null) {
                h10.d(i10);
            }
        }
    }

    public interface e {
        void a(int i10, SubTitleData subTitleData);

        void b(boolean z10);

        void c(int i10, AudioTrackBean audioTrackBean);

        void d(int i10);

        void e(int i10);
    }

    public static final class f extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f17257a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Activity activity) {
            super(0);
            this.f17257a = activity;
        }

        /* renamed from: b */
        public final n6.i invoke() {
            return new n6.i(this.f17257a);
        }
    }

    public static final class g extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f17258a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Activity activity) {
            super(0);
            this.f17258a = activity;
        }

        /* renamed from: b */
        public final n6.i invoke() {
            return new n6.i(this.f17258a);
        }
    }

    public static final class h extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f17259a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Activity activity) {
            super(0);
            this.f17259a = activity;
        }

        /* renamed from: b */
        public final n6.i invoke() {
            return new n6.i(this.f17259a);
        }
    }

    public static final class i extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f17260a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(Activity activity) {
            super(0);
            this.f17260a = activity;
        }

        /* renamed from: b */
        public final n6.i invoke() {
            return new n6.i(this.f17260a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(Activity activity) {
        super(activity);
        t9.i.g(activity, "activity");
        this.f17248i = h9.h.b(new f(activity));
        this.f17249j = h9.h.b(new h(activity));
        this.f17250k = h9.h.b(new i(activity));
        this.f17251l = h9.h.b(new g(activity));
        View inflate = LayoutInflater.from(activity).inflate(R.layout.layout_pop_window_subtitle_audio, (ViewGroup) null);
        t9.i.f(inflate, "from(activity).inflate(R…dow_subtitle_audio, null)");
        setContentView(inflate);
        setBackgroundDrawable(new ColorDrawable(0));
        setClippingEnabled(false);
        View findViewById = inflate.findViewById(R.id.mRvAudio);
        t9.i.f(findViewById, "view.findViewById(R.id.mRvAudio)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.f17241b = recyclerView;
        View findViewById2 = inflate.findViewById(R.id.mRvLanguage);
        t9.i.f(findViewById2, "view.findViewById(R.id.mRvLanguage)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById2;
        this.f17242c = recyclerView2;
        View findViewById3 = inflate.findViewById(R.id.mRvColor);
        t9.i.f(findViewById3, "view.findViewById(R.id.mRvColor)");
        RecyclerView recyclerView3 = (RecyclerView) findViewById3;
        this.f17243d = recyclerView3;
        View findViewById4 = inflate.findViewById(R.id.mRvSize);
        t9.i.f(findViewById4, "view.findViewById(R.id.mRvSize)");
        RecyclerView recyclerView4 = (RecyclerView) findViewById4;
        this.f17244e = recyclerView4;
        View findViewById5 = inflate.findViewById(R.id.mTvClose);
        t9.i.f(findViewById5, "view.findViewById(R.id.mTvClose)");
        TextView textView = (TextView) findViewById5;
        this.f17245f = textView;
        View findViewById6 = inflate.findViewById(R.id.mLlLandStyle);
        t9.i.f(findViewById6, "view.findViewById(R.id.mLlLandStyle)");
        this.f17246g = (AutoLinearLayout) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.mLlLandSize);
        t9.i.f(findViewById7, "view.findViewById(R.id.mLlLandSize)");
        this.f17247h = (AutoLinearLayout) findViewById7;
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, 1, false));
        recyclerView.setAdapter(i());
        recyclerView2.setLayoutManager(new LinearLayoutManager(activity, 1, false));
        recyclerView2.setAdapter(k());
        recyclerView3.setLayoutManager(new LinearLayoutManager(activity, 1, false));
        recyclerView3.setAdapter(j());
        recyclerView4.setLayoutManager(new LinearLayoutManager(activity, 1, false));
        recyclerView4.setAdapter(l());
        i().f(new a(this));
        k().f(new b(this));
        j().f(new c(this));
        l().f(new d(this));
        textView.setOnClickListener(new m(this));
    }

    public static final void g(n nVar, View view) {
        t9.i.g(nVar, "this$0");
        nVar.dismiss();
    }

    public boolean e() {
        return true;
    }

    public final n6.i i() {
        return (n6.i) this.f17248i.getValue();
    }

    public final n6.i j() {
        return (n6.i) this.f17251l.getValue();
    }

    public final n6.i k() {
        return (n6.i) this.f17249j.getValue();
    }

    public final n6.i l() {
        return (n6.i) this.f17250k.getValue();
    }

    public final void m(ArrayList arrayList, int i10) {
        t9.i.g(arrayList, "data");
        i().e(arrayList);
        i().g(i10);
    }

    public final void n(ArrayList arrayList, int i10) {
        t9.i.g(arrayList, "data");
        j().e(arrayList);
        j().g(i10);
    }

    public final void o(e eVar) {
        t9.i.g(eVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f17252m = eVar;
    }

    public final void p(ArrayList arrayList, int i10) {
        t9.i.g(arrayList, "data");
        k().e(arrayList);
        k().g(i10);
    }

    public final void q(boolean z10) {
        if (z10) {
            this.f17246g.setVisibility(0);
            this.f17247h.setVisibility(0);
        } else {
            this.f17246g.setVisibility(8);
            this.f17247h.setVisibility(8);
        }
        l().h(z10);
        j().h(z10);
    }

    public final void r(ArrayList arrayList, int i10) {
        t9.i.g(arrayList, "data");
        l().e(arrayList);
        l().g(i10);
    }

    public final void s(int i10, int i11, int i12, int i13, boolean z10) {
        i().g(i10);
        if (i11 == -1) {
            k().g(0);
        } else {
            k().g(i11);
        }
        if (z10) {
            this.f17247h.setVisibility(0);
            this.f17246g.setVisibility(0);
        } else {
            this.f17247h.setVisibility(8);
            this.f17246g.setVisibility(8);
        }
        l().g(i12);
        j().g(i13);
        l().h(z10);
        j().h(z10);
    }
}
