package g7;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.bean.AudioTrackBean;
import com.mobile.brasiltv.bean.NoSubTitleData;
import com.mobile.brasiltv.bean.OffSubTitleData;
import com.mobile.brasiltv.bean.SubTitleData;
import com.mobile.brasiltv.bean.SubtitleStyleBean;
import com.mobile.brasiltv.view.HorizontalDecoration;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import n6.k;
import t9.j;

public final class p extends b {

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f17262b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f17263c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f17264d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f17265e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f17266f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f17267g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f17268h;

    /* renamed from: i  reason: collision with root package name */
    public final h9.g f17269i;

    /* renamed from: j  reason: collision with root package name */
    public final h9.g f17270j;

    /* renamed from: k  reason: collision with root package name */
    public final h9.g f17271k;

    /* renamed from: l  reason: collision with root package name */
    public final h9.g f17272l;

    /* renamed from: m  reason: collision with root package name */
    public e f17273m;

    public static final class a implements k.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f17274a;

        public a(p pVar) {
            this.f17274a = pVar;
        }

        /* renamed from: b */
        public void a(int i10, AudioTrackBean audioTrackBean) {
            t9.i.g(audioTrackBean, "data");
            e h10 = this.f17274a.f17273m;
            if (h10 != null) {
                h10.c(i10, audioTrackBean);
            }
        }
    }

    public static final class b implements k.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f17275a;

        public b(p pVar) {
            this.f17275a = pVar;
        }

        /* renamed from: b */
        public void a(int i10, SubTitleData subTitleData) {
            t9.i.g(subTitleData, "data");
            if (subTitleData instanceof OffSubTitleData) {
                this.f17275a.q(false);
                e h10 = this.f17275a.f17273m;
                if (h10 != null) {
                    h10.b(false);
                }
            } else if (!(subTitleData instanceof NoSubTitleData)) {
                this.f17275a.q(true);
                e h11 = this.f17275a.f17273m;
                if (h11 != null) {
                    h11.a(i10, subTitleData);
                }
            }
        }
    }

    public static final class c implements k.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f17276a;

        public c(p pVar) {
            this.f17276a = pVar;
        }

        /* renamed from: b */
        public void a(int i10, SubtitleStyleBean subtitleStyleBean) {
            t9.i.g(subtitleStyleBean, "data");
            e h10 = this.f17276a.f17273m;
            if (h10 != null) {
                h10.e(i10);
            }
        }
    }

    public static final class d implements k.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f17277a;

        public d(p pVar) {
            this.f17277a = pVar;
        }

        /* renamed from: b */
        public void a(int i10, String str) {
            t9.i.g(str, "data");
            e h10 = this.f17277a.f17273m;
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
        public final /* synthetic */ Activity f17278a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Activity activity) {
            super(0);
            this.f17278a = activity;
        }

        /* renamed from: b */
        public final k invoke() {
            return new k(this.f17278a);
        }
    }

    public static final class g extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f17279a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Activity activity) {
            super(0);
            this.f17279a = activity;
        }

        /* renamed from: b */
        public final k invoke() {
            return new k(this.f17279a);
        }
    }

    public static final class h extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f17280a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Activity activity) {
            super(0);
            this.f17280a = activity;
        }

        /* renamed from: b */
        public final k invoke() {
            return new k(this.f17280a);
        }
    }

    public static final class i extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f17281a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(Activity activity) {
            super(0);
            this.f17281a = activity;
        }

        /* renamed from: b */
        public final k invoke() {
            return new k(this.f17281a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(Activity activity) {
        super(activity);
        t9.i.g(activity, "activity");
        this.f17269i = h9.h.b(new f(activity));
        this.f17270j = h9.h.b(new h(activity));
        this.f17271k = h9.h.b(new i(activity));
        this.f17272l = h9.h.b(new g(activity));
        View inflate = LayoutInflater.from(activity).inflate(R.layout.layout_pop_window_subtitle, (ViewGroup) null);
        t9.i.f(inflate, "from(activity).inflate(R…op_window_subtitle, null)");
        setContentView(inflate);
        setBackgroundDrawable(new ColorDrawable(0));
        View findViewById = inflate.findViewById(R.id.mRvAudio);
        t9.i.f(findViewById, "view.findViewById(R.id.mRvAudio)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.f17262b = recyclerView;
        View findViewById2 = inflate.findViewById(R.id.mRvLanguage);
        t9.i.f(findViewById2, "view.findViewById(R.id.mRvLanguage)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById2;
        this.f17263c = recyclerView2;
        View findViewById3 = inflate.findViewById(R.id.mRvColor);
        t9.i.f(findViewById3, "view.findViewById(R.id.mRvColor)");
        RecyclerView recyclerView3 = (RecyclerView) findViewById3;
        this.f17264d = recyclerView3;
        View findViewById4 = inflate.findViewById(R.id.mRvSize);
        t9.i.f(findViewById4, "view.findViewById(R.id.mRvSize)");
        RecyclerView recyclerView4 = (RecyclerView) findViewById4;
        this.f17265e = recyclerView4;
        View findViewById5 = inflate.findViewById(R.id.mIvClose);
        t9.i.f(findViewById5, "view.findViewById(R.id.mIvClose)");
        ImageView imageView = (ImageView) findViewById5;
        this.f17266f = imageView;
        View findViewById6 = inflate.findViewById(R.id.mTvStyleTitle);
        t9.i.f(findViewById6, "view.findViewById(R.id.mTvStyleTitle)");
        this.f17267g = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.mTvSizeTitle);
        t9.i.f(findViewById7, "view.findViewById(R.id.mTvSizeTitle)");
        this.f17268h = (TextView) findViewById7;
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, 0, false));
        recyclerView.addItemDecoration(new HorizontalDecoration(AutoUtils.getPercentWidthSize(10)));
        recyclerView.setAdapter(i());
        recyclerView2.setLayoutManager(new LinearLayoutManager(activity, 0, false));
        recyclerView2.addItemDecoration(new HorizontalDecoration(AutoUtils.getPercentWidthSize(10)));
        recyclerView2.setAdapter(k());
        recyclerView3.setLayoutManager(new LinearLayoutManager(activity, 0, false));
        recyclerView3.addItemDecoration(new HorizontalDecoration(AutoUtils.getPercentWidthSize(10)));
        recyclerView3.setAdapter(j());
        recyclerView4.setLayoutManager(new LinearLayoutManager(activity, 0, false));
        recyclerView4.addItemDecoration(new HorizontalDecoration(AutoUtils.getPercentWidthSize(10)));
        recyclerView4.setAdapter(l());
        i().f(new a(this));
        k().f(new b(this));
        j().f(new c(this));
        l().f(new d(this));
        imageView.setOnClickListener(new o(this));
    }

    public static final void g(p pVar, View view) {
        t9.i.g(pVar, "this$0");
        pVar.dismiss();
    }

    public final k i() {
        return (k) this.f17269i.getValue();
    }

    public final k j() {
        return (k) this.f17272l.getValue();
    }

    public final k k() {
        return (k) this.f17270j.getValue();
    }

    public final k l() {
        return (k) this.f17271k.getValue();
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
        this.f17273m = eVar;
    }

    public final void p(ArrayList arrayList, int i10) {
        t9.i.g(arrayList, "data");
        k().e(arrayList);
        k().g(i10);
    }

    public final void q(boolean z10) {
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
        l().g(i12);
        j().g(i13);
        l().h(z10);
        j().h(z10);
    }
}
