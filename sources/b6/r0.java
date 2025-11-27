package b6;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b6.z;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.CheckPwdSuccessEvent;
import com.mobile.brasiltv.bean.event.ClickChannelEpgEvent;
import com.mobile.brasiltv.bean.event.LiveFragVisibleEvent;
import com.mobile.brasiltv.bean.event.RefreshEPGEvent;
import com.mobile.brasiltv.bean.event.UpdateAllChannelEvent;
import com.mobile.brasiltv.bean.event.UpdateChannelEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f0;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.s0;
import com.mobile.brasiltv.view.KoocanSwipeRefreshLayout;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LinerItemDecoration;
import com.mobile.brasiltv.view.RecyclerLoadMoreView;
import com.mobile.brasiltv.view.SCCustomTextView;
import com.mobile.brasiltv.view.dialog.BindEmailOrPhoneNotification;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import g5.h0;
import g5.l0;
import g5.n0;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import l6.u;
import mobile.com.requestframe.utils.response.Channel;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.EpgResultData;
import t9.w;
import w6.i;

public final class r0 extends e<u> implements j6.e, SwipeRefreshLayout.j, h0 {
    public static final a A = new a((t9.g) null);
    public static final String B = "bundleLiveType";
    public static final String C = "0";
    public static final String D = "1";
    public static final String E = "2";
    public static HashMap F = new HashMap();
    public static HashMap G = new HashMap();
    public static String H = "";

    /* renamed from: i  reason: collision with root package name */
    public ArrayList f4443i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public LinearLayoutManagerWrapper f4444j;

    /* renamed from: k  reason: collision with root package name */
    public int f4445k = -1;

    /* renamed from: l  reason: collision with root package name */
    public int f4446l = -1;

    /* renamed from: m  reason: collision with root package name */
    public boolean f4447m;

    /* renamed from: n  reason: collision with root package name */
    public int f4448n = -1;

    /* renamed from: o  reason: collision with root package name */
    public int f4449o;

    /* renamed from: p  reason: collision with root package name */
    public Disposable f4450p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f4451q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f4452r;

    /* renamed from: s  reason: collision with root package name */
    public final h9.g f4453s = h9.h.b(b.f11071a);

    /* renamed from: t  reason: collision with root package name */
    public final h9.g f4454t = h9.h.b(new r(this));

    /* renamed from: u  reason: collision with root package name */
    public final h9.g f4455u = h9.h.b(new l(this));

    /* renamed from: v  reason: collision with root package name */
    public final h9.g f4456v = h9.h.b(new m(this));

    /* renamed from: w  reason: collision with root package name */
    public g6.d f4457w;

    /* renamed from: x  reason: collision with root package name */
    public final h9.g f4458x = h9.h.b(new n(this));

    /* renamed from: y  reason: collision with root package name */
    public u f4459y;

    /* renamed from: z  reason: collision with root package name */
    public Map f4460z = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final String a() {
            return r0.B;
        }

        public final String b() {
            return r0.C;
        }

        public final String c() {
            return r0.D;
        }

        public final HashMap d() {
            return r0.G;
        }

        public final HashMap e() {
            return r0.F;
        }

        public final void f(String str) {
            t9.i.g(str, "<set-?>");
            r0.H = str;
        }
    }

    public static final class b extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f11071a = new b();

        public b() {
            super(0);
        }

        /* renamed from: b */
        public final ArrayList invoke() {
            ArrayList<ChildColumnList> d10;
            ArrayList arrayList = new ArrayList();
            z.a aVar = z.f4508u;
            if (b0.I(aVar.d()) && (d10 = aVar.d()) != null) {
                for (ChildColumnList id : d10) {
                    arrayList.add(Integer.valueOf(id.getId()));
                }
            }
            return arrayList;
        }
    }

    public static final class c extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f11072a = new c();

        public c() {
            super(1);
        }

        /* renamed from: b */
        public final ObservableSource invoke(List list) {
            t9.i.g(list, "list");
            int i10 = 0;
            for (Object next : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                if (ba.s.g(z.f4508u.f(), ((Channel) next).getChannelCode(), false, 2, (Object) null)) {
                    return Observable.just(Integer.valueOf(i10));
                }
                i10 = i11;
            }
            return Observable.just(-1);
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r0 f11073a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(r0 r0Var) {
            super(1);
            this.f11073a = r0Var;
        }

        public final void b(Integer num) {
            if (num == null || num.intValue() != -1) {
                LinearLayoutManagerWrapper C3 = this.f11073a.f4444j;
                if (C3 != null) {
                    t9.i.e(num, "null cannot be cast to non-null type kotlin.Int");
                    C3.scrollToPositionWithOffset(num.intValue(), 0);
                }
                r0 r0Var = this.f11073a;
                t9.i.f(num, "it");
                r0Var.W3(num.intValue());
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return h9.t.f17319a;
        }
    }

    public static final class e extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final e f11074a = new e();

        public e() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final class f extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f11075a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(w wVar) {
            super(1);
            this.f11075a = wVar;
        }

        /* renamed from: b */
        public final ObservableSource invoke(List list) {
            t9.i.g(list, "list");
            w wVar = this.f11075a;
            int i10 = 0;
            for (Object next : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                if (t9.i.b(wVar.f19600a, ((Channel) next).getChannelCode())) {
                    return Observable.just(Integer.valueOf(i10));
                }
                i10 = i11;
            }
            return Observable.just(-1);
        }
    }

    public static final class g extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r0 f11076a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(r0 r0Var) {
            super(1);
            this.f11076a = r0Var;
        }

        public final void b(Integer num) {
            l0 G3 = this.f11076a.f4();
            if (G3 != null) {
                t9.i.f(num, "it");
                G3.c(num.intValue());
            }
            l0 G32 = this.f11076a.f4();
            if (G32 != null) {
                G32.notifyDataSetChanged();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return h9.t.f17319a;
        }
    }

    public static final class h extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final h f11077a = new h();

        public h() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final class i extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final i f11078a = new i();

        public i() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Long l10) {
            String c10 = y6.b.c();
            a aVar = r0.A;
            aVar.d().clear();
            for (Map.Entry entry : aVar.e().entrySet()) {
                for (EpgResultData epgResultData : (Iterable) entry.getValue()) {
                    String date = epgResultData.getDate();
                    t9.i.f(c10, "nowTime");
                    String substring = c10.substring(0, 10);
                    t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    if (t9.i.b(date, substring)) {
                        String start = epgResultData.getStart();
                        String substring2 = c10.substring(11, 16);
                        t9.i.f(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        if (start.compareTo(substring2) < 0) {
                            String stop = epgResultData.getStop();
                            String substring3 = c10.substring(11, 16);
                            t9.i.f(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                            if (stop.compareTo(substring3) > 0) {
                                r0.A.d().put(entry.getKey(), epgResultData);
                            }
                        }
                    }
                }
            }
        }
    }

    public static final class j extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r0 f11079a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(r0 r0Var) {
            super(1);
            this.f11079a = r0Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Long l10) {
            l0 G3 = this.f11079a.f4();
            if (b0.I(G3 != null ? G3.getData() : null)) {
                l0 G32 = this.f11079a.f4();
                if (G32 != null) {
                    G32.notifyDataSetChanged();
                }
                xa.c.c().j(new RefreshEPGEvent());
            }
        }
    }

    public static final class k extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final k f11080a = new k();

        public k() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f17319a;
        }
    }

    public static final class l extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r0 f11081a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(r0 r0Var) {
            super(0);
            this.f11081a = r0Var;
        }

        /* renamed from: b */
        public final l0 invoke() {
            androidx.fragment.app.e activity = this.f11081a.getActivity();
            if (activity != null) {
                return new l0(activity);
            }
            return null;
        }
    }

    public static final class m extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r0 f11082a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(r0 r0Var) {
            super(0);
            this.f11082a = r0Var;
        }

        /* renamed from: b */
        public final n0 invoke() {
            ArrayList<ChildColumnList> d10;
            boolean z10;
            ArrayList arrayList = new ArrayList();
            z.a aVar = z.f4508u;
            if (b0.I(aVar.d()) && (d10 = aVar.d()) != null) {
                for (ChildColumnList childColumnList : d10) {
                    if (!f0.b()) {
                        String alias = childColumnList.getAlias();
                        if (alias == null || alias.length() == 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (!z10) {
                            String alias2 = childColumnList.getAlias();
                            if (alias2 == null) {
                                alias2 = "";
                            }
                            arrayList.add(alias2);
                        }
                    }
                    arrayList.add(childColumnList.getName());
                }
            }
            androidx.fragment.app.e activity = this.f11082a.getActivity();
            if (activity != null) {
                return new n0(activity, arrayList, z.f4508u.d());
            }
            return null;
        }
    }

    public static final class n extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r0 f11083a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(r0 r0Var) {
            super(0);
            this.f11083a = r0Var;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r0 = r0.getString(b6.r0.A.a());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String invoke() {
            /*
                r2 = this;
                b6.r0 r0 = r2.f11083a
                android.os.Bundle r0 = r0.getArguments()
                if (r0 == 0) goto L_0x0014
                b6.r0$a r1 = b6.r0.A
                java.lang.String r1 = r1.a()
                java.lang.String r0 = r0.getString(r1)
                if (r0 != 0) goto L_0x0016
            L_0x0014:
                java.lang.String r0 = ""
            L_0x0016:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: b6.r0.n.invoke():java.lang.String");
        }
    }

    public static final class o extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f11084a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(w wVar) {
            super(1);
            this.f11084a = wVar;
        }

        /* renamed from: b */
        public final Boolean invoke(Channel channel) {
            t9.i.g(channel, "it");
            return Boolean.valueOf(t9.i.b(this.f11084a.f19600a, channel.getChannelCode()));
        }
    }

    public static final class p extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r0 f11085a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ w f11086b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(r0 r0Var, w wVar) {
            super(1);
            this.f11085a = r0Var;
            this.f11086b = wVar;
        }

        public final void b(Channel channel) {
            this.f11085a.L3(this.f11085a.f4443i.indexOf(channel), (String) this.f11086b.f19600a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Channel) obj);
            return h9.t.f17319a;
        }
    }

    public static final class q extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final q f11087a = new q();

        public q() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final class r extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r0 f11088a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(r0 r0Var) {
            super(0);
            this.f11088a = r0Var;
        }

        public final Integer invoke() {
            Bundle arguments = this.f11088a.getArguments();
            int i10 = 0;
            if (arguments != null) {
                i10 = arguments.getInt("fragment_live_index", 0);
            }
            return Integer.valueOf(i10);
        }
    }

    public static final class s extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final s f11089a = new s();

        public s() {
            super(1);
        }

        public final void b(Channel channel) {
            z.f4508u.b().put(channel.getChannelCode(), channel);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Channel) obj);
            return h9.t.f17319a;
        }
    }

    public static final class t extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final t f11090a = new t();

        public t() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final void G4(r0 r0Var, DialogInterface dialogInterface) {
        t9.i.g(r0Var, "this$0");
        r0Var.f4457w = null;
    }

    public static /* synthetic */ void N3(r0 r0Var, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        r0Var.M3(i10, z10);
    }

    public static final void P3(r0 r0Var, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        t9.i.g(r0Var, "this$0");
        if (i10 < r0Var.f4443i.size()) {
            int id = view.getId();
            if (id == R.id.mImageEpg) {
                xa.c c10 = xa.c.c();
                String channelCode = ((Channel) r0Var.f4443i.get(i10)).getChannelCode();
                String name = ((Channel) r0Var.f4443i.get(i10)).getName();
                int i11 = r0Var.f4449o;
                String alias = ((Channel) r0Var.f4443i.get(i10)).getAlias();
                if (alias == null) {
                    alias = "";
                }
                c10.m(new ClickChannelEpgEvent(channelCode, name, i11, alias));
            } else if (id == R.id.mLayoutProgram) {
                r0Var.L3(i10, ((Channel) r0Var.f4443i.get(i10)).getChannelCode());
            }
        }
    }

    public static final void Q3(r0 r0Var) {
        t9.i.g(r0Var, "this$0");
        l0 f42 = r0Var.f4();
        if (f42 != null) {
            f42.loadMoreEnd(true);
        }
    }

    public static final ObservableSource R3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final void S3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void T3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final ObservableSource X3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final void Y3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void Z3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void c4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void d4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void e4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean p4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final void q4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void r4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void w4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void x4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void A4(u uVar) {
        t9.i.g(uVar, "<set-?>");
        this.f4459y = uVar;
    }

    public final void B4() {
        int i10 = R$id.mEmptyRefreshLayout;
        if (((SwipeRefreshLayout) w3(i10)) != null) {
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) w3(i10);
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setVisibility(8);
            }
            SCCustomTextView sCCustomTextView = (SCCustomTextView) w3(R$id.mLiveNoNetHintTopTv);
            if (sCCustomTextView != null) {
                sCCustomTextView.setVisibility(8);
            }
            KoocanSwipeRefreshLayout koocanSwipeRefreshLayout = (KoocanSwipeRefreshLayout) w3(R$id.mRefreshLayout);
            if (koocanSwipeRefreshLayout != null) {
                koocanSwipeRefreshLayout.setVisibility(0);
            }
        }
    }

    public final void C4(int i10, int i11) {
        l0 f42;
        l0 f43;
        l0 f44;
        l0 f45 = f4();
        if (f45 != null) {
            f45.c(i11);
        }
        if (!(i10 == -1 || (f44 = f4()) == null)) {
            f44.notifyItemChanged(i10);
        }
        if (!(i11 == -1 || (f43 = f4()) == null)) {
            f43.notifyItemChanged(i11);
        }
        int s42 = s4();
        if (i10 != s42 && s42 != -1 && (f42 = f4()) != null) {
            f42.notifyItemChanged(s42);
        }
    }

    public final void D4() {
        KoocanSwipeRefreshLayout koocanSwipeRefreshLayout = (KoocanSwipeRefreshLayout) w3(R$id.mRefreshLayout);
        if (koocanSwipeRefreshLayout != null) {
            koocanSwipeRefreshLayout.setVisibility(8);
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) w3(R$id.mEmptyRefreshLayout);
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setVisibility(0);
        }
        SCCustomTextView sCCustomTextView = (SCCustomTextView) w3(R$id.mLiveNoNetHintTopTv);
        if (sCCustomTextView != null) {
            sCCustomTextView.setVisibility(0);
        }
        SCCustomTextView sCCustomTextView2 = (SCCustomTextView) w3(R$id.noNetHintTv);
        if (sCCustomTextView2 != null) {
            sCCustomTextView2.setVisibility(4);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (b8.a.f11196a.b(r0) == true) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E4() {
        /*
            r3 = this;
            boolean r0 = r3.P2()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            androidx.fragment.app.e r0 = r3.getActivity()
            r1 = 0
            if (r0 == 0) goto L_0x0018
            b8.a$a r2 = b8.a.f11196a
            boolean r0 = r2.b(r0)
            r2 = 1
            if (r0 != r2) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r2 = 0
        L_0x0019:
            if (r2 == 0) goto L_0x0057
            int r0 = com.mobile.brasiltv.R$id.mRefreshLayout
            android.view.View r0 = r3.w3(r0)
            com.mobile.brasiltv.view.KoocanSwipeRefreshLayout r0 = (com.mobile.brasiltv.view.KoocanSwipeRefreshLayout) r0
            if (r0 != 0) goto L_0x0026
            goto L_0x002b
        L_0x0026:
            r2 = 8
            r0.setVisibility(r2)
        L_0x002b:
            int r0 = com.mobile.brasiltv.R$id.mEmptyRefreshLayout
            android.view.View r0 = r3.w3(r0)
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) r0
            if (r0 != 0) goto L_0x0036
            goto L_0x0039
        L_0x0036:
            r0.setVisibility(r1)
        L_0x0039:
            int r0 = com.mobile.brasiltv.R$id.noNetHintTv
            android.view.View r0 = r3.w3(r0)
            com.mobile.brasiltv.view.SCCustomTextView r0 = (com.mobile.brasiltv.view.SCCustomTextView) r0
            if (r0 != 0) goto L_0x0044
            goto L_0x0048
        L_0x0044:
            r2 = 4
            r0.setVisibility(r2)
        L_0x0048:
            int r0 = com.mobile.brasiltv.R$id.mLiveNoNetHintTopTv
            android.view.View r0 = r3.w3(r0)
            com.mobile.brasiltv.view.SCCustomTextView r0 = (com.mobile.brasiltv.view.SCCustomTextView) r0
            if (r0 != 0) goto L_0x0053
            goto L_0x005a
        L_0x0053:
            r0.setVisibility(r1)
            goto L_0x005a
        L_0x0057:
            r3.D4()
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.r0.E4():void");
    }

    public final boolean F4() {
        g6.d dVar;
        if (!MainAty.A.f()) {
            return true;
        }
        if (this.f4457w == null) {
            Context context = getContext();
            if (context != null) {
                dVar = new g6.d(context);
            } else {
                dVar = null;
            }
            this.f4457w = dVar;
            if (dVar != null) {
                dVar.setOnDismissListener(new f0(this));
            }
        }
        g6.d dVar2 = this.f4457w;
        if (dVar2 != null) {
            dVar2.h(true);
        }
        g6.d dVar3 = this.f4457w;
        if (dVar3 == null) {
            return false;
        }
        dVar3.show();
        return false;
    }

    public void G(List list, int i10) {
        t9.i.g(list, "list");
        z.f4508u.g().put(i10, list);
    }

    public final boolean I3() {
        if (getContext() == null) {
            return false;
        }
        com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f12601a;
        Context context = getContext();
        t9.i.d(context);
        boolean c10 = com.mobile.brasiltv.utils.n0.c(n0Var, context, "live_first_play_free_column", false, 4, (Object) null);
        i.c cVar = w6.i.f9510g;
        if ((t9.i.b(cVar.I(), "1") || t9.i.b(cVar.I(), "2")) && t9.i.b(cVar.e(), "1") && c10) {
            return true;
        }
        return false;
    }

    public final boolean J3() {
        if (I3() && this.f4443i.size() > 0) {
            z.f4508u.n(((Channel) this.f4443i.get(0)).getChannelCode());
        }
        return t9.i.b(z.f4508u.f(), H);
    }

    public final boolean K3() {
        d6.b bVar = d6.b.f6366a;
        if (bVar.a() && (!bVar.c() || bVar.b() || bVar.d())) {
            return true;
        }
        Context context = getContext();
        if (context == null) {
            return false;
        }
        new BindEmailOrPhoneNotification(context).show();
        return false;
    }

    public final void L3(int i10, String str) {
        boolean z10;
        Integer num;
        String str2;
        ChildColumnList b10;
        androidx.fragment.app.e activity;
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 && !t9.i.b(str, H)) {
            androidx.fragment.app.e activity2 = getActivity();
            UpdateChannelEvent updateChannelEvent = null;
            if (activity2 != null) {
                num = Integer.valueOf(com.mobile.brasiltv.utils.n0.f12601a.d(activity2, "live_last_play_column_index", 0));
            } else {
                num = null;
            }
            androidx.fragment.app.e activity3 = getActivity();
            if (activity3 != null) {
                com.mobile.brasiltv.utils.n0.f12601a.i(activity3, "live_last_play_column_index", this.f4448n);
            }
            i.c cVar = w6.i.f9510g;
            if (((t9.i.b(cVar.e(), "1") && t9.i.b(cVar.I(), "1")) || t9.i.b(cVar.I(), "2")) && (activity = getActivity()) != null) {
                com.mobile.brasiltv.utils.n0.f12601a.g(activity, "live_first_play_free_column", false);
            }
            W3(i10);
            y4(this.f4443i, i10);
            H = str;
            xa.c c10 = xa.c.c();
            if (num != null) {
                int intValue = num.intValue();
                ArrayList arrayList = this.f4443i;
                String h42 = h4();
                int i11 = this.f4449o;
                n0 g42 = g4();
                if (g42 == null || (b10 = g42.b()) == null || (str2 = b10.getAlias()) == null) {
                    str2 = "";
                }
                updateChannelEvent = new UpdateChannelEvent(arrayList, i10, true, h42, i11, str2, intValue);
            }
            c10.j(updateChannelEvent);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f2, code lost:
        if (r5 != false) goto L_0x00f7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void M3(int r8, boolean r9) {
        /*
            r7 = this;
            r0 = -1
            r1 = 0
            if (r8 != r0) goto L_0x0006
            r0 = 0
            goto L_0x0007
        L_0x0006:
            r0 = r8
        L_0x0007:
            java.util.ArrayList r2 = r7.b4()
            boolean r2 = com.mobile.brasiltv.utils.b0.G(r2)
            if (r2 == 0) goto L_0x0012
            return
        L_0x0012:
            java.util.ArrayList r2 = r7.b4()
            int r2 = r2.size()
            if (r0 < r2) goto L_0x001d
            r0 = 0
        L_0x001d:
            java.util.ArrayList r2 = r7.b4()
            java.lang.Object r2 = r2.get(r0)
            java.lang.String r3 = "allColumnIdList[index]"
            t9.i.f(r2, r3)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            r7.f4448n = r0
            r7.f4449o = r2
            r7.U3(r0)
            g5.l0 r0 = r7.f4()
            if (r0 == 0) goto L_0x0046
            java.util.List r0 = r0.getData()
            if (r0 == 0) goto L_0x0046
            r0.clear()
        L_0x0046:
            g5.l0 r0 = r7.f4()
            if (r0 == 0) goto L_0x004f
            r0.notifyDataSetChanged()
        L_0x004f:
            int r0 = com.mobile.brasiltv.R$id.tvTips
            android.view.View r3 = r7.w3(r0)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r4 = 8
            r3.setVisibility(r4)
            java.lang.String r3 = "LiveItemFrag"
            java.lang.String r8 = java.lang.String.valueOf(r8)
            android.util.Log.e(r3, r8)
            b6.z$a r8 = b6.z.f4508u
            mobile.com.requestframe.utils.response.ChildColumnList r3 = r8.a()
            r5 = 1
            if (r3 == 0) goto L_0x0076
            int r3 = r3.getId()
            if (r2 != r3) goto L_0x0076
            r3 = 1
            goto L_0x0077
        L_0x0076:
            r3 = 0
        L_0x0077:
            if (r3 == 0) goto L_0x0086
            boolean r3 = r7.K3()
            if (r3 == 0) goto L_0x0085
            boolean r3 = r7.F4()
            if (r3 != 0) goto L_0x0086
        L_0x0085:
            return
        L_0x0086:
            if (r9 != 0) goto L_0x010f
            android.util.SparseArray r9 = r8.g()
            int r9 = r9.indexOfKey(r2)
            if (r9 < 0) goto L_0x010f
            android.util.SparseArray r9 = r8.g()
            java.lang.Object r9 = r9.get(r2)
            java.util.List r9 = (java.util.List) r9
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x00a6
            r7.D4()
            goto L_0x00a9
        L_0x00a6:
            r7.B4()
        L_0x00a9:
            g5.l0 r9 = r7.f4()
            java.lang.String r3 = "LiveFrag.mChannelMap[columnId]"
            if (r9 == 0) goto L_0x00c7
            java.util.List r9 = r9.getData()
            if (r9 == 0) goto L_0x00c7
            android.util.SparseArray r6 = r8.g()
            java.lang.Object r6 = r6.get(r2)
            t9.i.f(r6, r3)
            java.util.Collection r6 = (java.util.Collection) r6
            r9.addAll(r6)
        L_0x00c7:
            r7.V3()
            android.view.View r9 = r7.w3(r0)
            android.widget.TextView r9 = (android.widget.TextView) r9
            android.util.SparseArray r0 = r8.g()
            java.lang.Object r0 = r0.get(r2)
            t9.i.f(r0, r3)
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r5
            if (r0 == 0) goto L_0x00f5
            mobile.com.requestframe.utils.response.ChildColumnList r0 = r8.a()
            if (r0 == 0) goto L_0x00f1
            int r0 = r0.getId()
            if (r2 != r0) goto L_0x00f1
            goto L_0x00f2
        L_0x00f1:
            r5 = 0
        L_0x00f2:
            if (r5 == 0) goto L_0x00f5
            goto L_0x00f7
        L_0x00f5:
            r1 = 8
        L_0x00f7:
            r9.setVisibility(r1)
            java.util.ArrayList r9 = r7.f4443i
            r9.clear()
            java.util.ArrayList r9 = r7.f4443i
            android.util.SparseArray r8 = r8.g()
            java.lang.Object r8 = r8.get(r2)
            java.util.Collection r8 = (java.util.Collection) r8
            r9.addAll(r8)
            goto L_0x0116
        L_0x010f:
            l6.u r8 = r7.a3()
            r8.k(r2, r1)
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.r0.M3(int, boolean):void");
    }

    public final void O3() {
        boolean z10;
        SwipeRefreshLayout swipeRefreshLayout;
        KoocanSwipeRefreshLayout koocanSwipeRefreshLayout;
        FrameLayout frameLayout = (FrameLayout) w3(R$id.mFlLoading);
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        if (this.f4447m) {
            this.f4447m = false;
            int i10 = R$id.mRefreshLayout;
            KoocanSwipeRefreshLayout koocanSwipeRefreshLayout2 = (KoocanSwipeRefreshLayout) w3(i10);
            boolean z11 = true;
            if (koocanSwipeRefreshLayout2 == null || !koocanSwipeRefreshLayout2.isRefreshing()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10 && (koocanSwipeRefreshLayout = (KoocanSwipeRefreshLayout) w3(i10)) != null) {
                koocanSwipeRefreshLayout.setRefreshing(false);
            }
            int i11 = R$id.mEmptyRefreshLayout;
            SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) w3(i11);
            if (swipeRefreshLayout2 == null || !swipeRefreshLayout2.isRefreshing()) {
                z11 = false;
            }
            if (z11 && (swipeRefreshLayout = (SwipeRefreshLayout) w3(i11)) != null) {
                swipeRefreshLayout.setRefreshing(false);
            }
        }
    }

    public /* bridge */ /* synthetic */ void S0(Boolean bool) {
        z4(bool.booleanValue());
    }

    public void T2() {
        int i10;
        if (getContext() != null) {
            int k42 = k4();
            n0 g42 = g4();
            if (g42 != null) {
                i10 = g42.getItemCount();
            } else {
                i10 = 0;
            }
            if (k42 >= i10) {
                n4();
                k42 = 0;
            }
            N3(this, k42, false, 2, (Object) null);
            if (k42 != this.f4448n) {
                N3(this, k42, false, 2, (Object) null);
                if (this.f4451q || !J3()) {
                    o4();
                }
            } else if (this.f4452r) {
                o4();
            }
            a4();
            this.f4451q = false;
            this.f4452r = false;
        }
    }

    public void U2() {
        if (Q2()) {
            O3();
        }
    }

    public final void U3(int i10) {
        int i11;
        n0 g42;
        n0 g43 = g4();
        if (g43 != null) {
            i11 = g43.getItemCount();
        } else {
            i11 = 0;
        }
        if (i11 > i10 && (g42 = g4()) != null) {
            g42.h(i10);
        }
    }

    public void V0() {
        Disposable disposable = this.f4450p;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f4450p = Observable.interval(5, 900, TimeUnit.SECONDS).compose(O2()).doOnNext(new a0(i.f11078a)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i0(new j(this)), new j0(k.f11080a));
    }

    public void V2() {
        super.V2();
    }

    public final void V3() {
        List list;
        w wVar = new w();
        String f10 = z.f4508u.f();
        if (f10 == null) {
            f10 = "";
        }
        wVar.f19600a = f10;
        l0 f42 = f4();
        if (f42 != null) {
            list = f42.getData();
        } else {
            list = null;
        }
        Observable.just(list).flatMap(new m0(new f(wVar))).compose(p0.a()).subscribe(new n0(new g(this)), new o0(h.f11077a));
    }

    public final void W3(int i10) {
        int i11 = this.f4446l;
        this.f4445k = i11;
        this.f4446l = i10;
        C4(i11, i10);
    }

    public void X2() {
        this.f4460z.clear();
    }

    public void Y2() {
        LinerItemDecoration linerItemDecoration = new LinerItemDecoration(s0.a(getActivity(), 1.0f), 0, true);
        this.f4444j = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        int i10 = R$id.mRecyclerViewLiveInfo;
        RecyclerView recyclerView = (RecyclerView) w3(i10);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(this.f4444j);
        }
        RecyclerView recyclerView2 = (RecyclerView) w3(i10);
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(linerItemDecoration);
        }
        int i11 = R$id.mRefreshLayout;
        KoocanSwipeRefreshLayout koocanSwipeRefreshLayout = (KoocanSwipeRefreshLayout) w3(i11);
        if (koocanSwipeRefreshLayout != null) {
            koocanSwipeRefreshLayout.setColorSchemeResources(R.color.color_important);
        }
        int i12 = R$id.mEmptyRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) w3(i12);
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setColorSchemeResources(R.color.color_important);
        }
        KoocanSwipeRefreshLayout koocanSwipeRefreshLayout2 = (KoocanSwipeRefreshLayout) w3(i11);
        if (koocanSwipeRefreshLayout2 != null) {
            koocanSwipeRefreshLayout2.setOnRefreshListener(this);
        }
        SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) w3(i12);
        if (swipeRefreshLayout2 != null) {
            swipeRefreshLayout2.setOnRefreshListener(this);
        }
        KoocanSwipeRefreshLayout koocanSwipeRefreshLayout3 = (KoocanSwipeRefreshLayout) w3(i11);
        if (koocanSwipeRefreshLayout3 != null) {
            koocanSwipeRefreshLayout3.setDistanceToTriggerSync(AutoUtils.getPercentHeightSize(500));
        }
        l0 f42 = f4();
        if (f42 != null) {
            f42.setOnItemChildClickListener(new k0(this));
        }
        RecyclerView recyclerView3 = (RecyclerView) w3(i10);
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(f4());
        }
        l0 f43 = f4();
        if (f43 != null) {
            f43.bindToRecyclerView((RecyclerView) w3(i10));
        }
        l0 f44 = f4();
        if (f44 != null) {
            f44.setOnLoadMoreListener(new l0(this));
        }
        l0 f45 = f4();
        if (f45 != null) {
            f45.setLoadMoreView(new RecyclerLoadMoreView());
        }
        m4();
    }

    public final void a4() {
        List data;
        int i10;
        List data2;
        List data3;
        int i11 = 0;
        if (I3() || b0.H(z.f4508u.f())) {
            l0 f42 = f4();
            if (!(f42 == null || (data = f42.getData()) == null)) {
                i11 = data.size();
            }
            if (i11 > 0) {
                c1();
                int j42 = j4();
                if (k4() == j42) {
                    U3(j42);
                    return;
                }
                return;
            }
            return;
        }
        l0 f43 = f4();
        if (f43 == null || (data3 = f43.getData()) == null) {
            i10 = 0;
        } else {
            i10 = data3.size();
        }
        if (i10 > 0) {
            LinearLayoutManagerWrapper linearLayoutManagerWrapper = this.f4444j;
            if (linearLayoutManagerWrapper != null) {
                linearLayoutManagerWrapper.scrollToPositionWithOffset(0, 0);
            }
            U3(0);
            W3(0);
            l0 f44 = f4();
            if (f44 != null && (data2 = f44.getData()) != null) {
                y4(data2, this.f4446l);
            }
        }
    }

    public final ArrayList b4() {
        return (ArrayList) this.f4453s.getValue();
    }

    public void c1() {
        List list;
        l0 f42 = f4();
        if (f42 != null) {
            list = f42.getData();
        } else {
            list = null;
        }
        Observable.just(list).flatMap(new p0(c.f11072a)).compose(p0.a()).subscribe(new q0(new d(this)), new b0(e.f11074a));
    }

    public int c3() {
        return R.layout.frag_live_item;
    }

    @xa.j
    public final void checkPwdSuccess(CheckPwdSuccessEvent checkPwdSuccessEvent) {
        boolean z10;
        boolean z11;
        boolean z12;
        List data;
        g6.d dVar;
        t9.i.g(checkPwdSuccessEvent, "event");
        int i10 = 0;
        MainAty.A.o(false);
        z.a aVar = z.f4508u;
        ChildColumnList a10 = aVar.a();
        if (a10 == null || this.f4449o != a10.getId()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            g6.d dVar2 = this.f4457w;
            if (dVar2 == null || !dVar2.isShowing()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11 && (dVar = this.f4457w) != null) {
                dVar.cancel();
            }
            if (aVar.g().indexOfKey(this.f4449o) >= 0) {
                k7.f.e("直接加载当前栏目", new Object[0]);
                List list = (List) aVar.g().get(this.f4449o);
                if (list == null || !list.isEmpty()) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (z12) {
                    D4();
                } else {
                    B4();
                }
                l0 f42 = f4();
                if (!(f42 == null || (data = f42.getData()) == null)) {
                    Object obj = aVar.g().get(this.f4449o);
                    t9.i.f(obj, "LiveFrag.mChannelMap[currentColumnId]");
                    data.addAll((Collection) obj);
                }
                V3();
                TextView textView = (TextView) w3(R$id.tvTips);
                Object obj2 = aVar.g().get(this.f4449o);
                t9.i.f(obj2, "LiveFrag.mChannelMap[currentColumnId]");
                if (!(true ^ ((Collection) obj2).isEmpty())) {
                    i10 = 8;
                }
                textView.setVisibility(i10);
                this.f4443i.clear();
                this.f4443i.addAll((Collection) aVar.g().get(this.f4449o));
                return;
            }
            k7.f.e("请求当前栏目", new Object[0]);
            a3().k(this.f4449o, false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a6  */
    @xa.j(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void clickSearchChannel(com.mobile.brasiltv.bean.event.ClickSearchChannelEvent r7) {
        /*
            r6 = this;
            java.lang.String r0 = "event"
            t9.i.g(r7, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "播放搜索的频道 channelCode: "
            r0.append(r1)
            mobile.com.requestframe.utils.response.Channel r1 = r7.getChannel()
            java.lang.String r1 = r1.getChannelCode()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            k7.f.e(r0, r2)
            b6.z$a r0 = b6.z.f4508u
            mobile.com.requestframe.utils.response.Channel r2 = r7.getChannel()
            java.lang.String r2 = r2.getChannelCode()
            r0.n(r2)
            java.lang.String r2 = ""
            H = r2
            mobile.com.requestframe.utils.response.ChildColumnList r2 = r0.e()
            r3 = 1
            if (r2 == 0) goto L_0x009d
            w6.i$c r2 = w6.i.f9510g
            java.lang.String r4 = r2.e()
            java.lang.String r5 = "1"
            boolean r4 = t9.i.b(r4, r5)
            if (r4 == 0) goto L_0x009d
            java.lang.String r4 = r2.I()
            boolean r4 = t9.i.b(r4, r5)
            if (r4 != 0) goto L_0x0060
            java.lang.String r2 = r2.I()
            java.lang.String r4 = "2"
            boolean r2 = t9.i.b(r2, r4)
            if (r2 == 0) goto L_0x009d
        L_0x0060:
            android.util.SparseArray r2 = r0.g()
            mobile.com.requestframe.utils.response.ChildColumnList r0 = r0.e()
            if (r0 == 0) goto L_0x006f
            int r0 = r0.getId()
            goto L_0x0070
        L_0x006f:
            r0 = 0
        L_0x0070:
            java.lang.Object r0 = r2.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x009d
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
        L_0x007d:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x009e
            java.lang.Object r4 = r0.next()
            mobile.com.requestframe.utils.response.Channel r4 = (mobile.com.requestframe.utils.response.Channel) r4
            mobile.com.requestframe.utils.response.Channel r5 = r7.getChannel()
            java.lang.String r5 = r5.getChannelCode()
            java.lang.String r4 = r4.getChannelCode()
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 == 0) goto L_0x007d
            r2 = 1
            goto L_0x007d
        L_0x009d:
            r2 = 0
        L_0x009e:
            r7 = 0
            r0 = 2
            if (r2 == 0) goto L_0x00a6
            N3(r6, r3, r1, r0, r7)
            goto L_0x00a9
        L_0x00a6:
            N3(r6, r1, r1, r0, r7)
        L_0x00a9:
            r6.o4()
            r6.c1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.r0.clickSearchChannel(com.mobile.brasiltv.bean.event.ClickSearchChannelEvent):void");
    }

    public final l0 f4() {
        return (l0) this.f4455u.getValue();
    }

    @xa.j
    public final void fragVisibleEvent(LiveFragVisibleEvent liveFragVisibleEvent) {
        t9.i.g(liveFragVisibleEvent, "event");
        if (liveFragVisibleEvent.getVisible()) {
            V2();
        } else {
            U2();
        }
    }

    public void g(List list, int i10) {
        t9.i.g(list, "list");
        O3();
        z.f4508u.g().put(i10, list);
        Integer num = (Integer) b4().get(0);
        if (num != null && num.intValue() == i10) {
            v4(list);
        }
        if (this.f4449o == i10) {
            l4(list);
            this.f4443i.clear();
            this.f4443i.addAll(list);
            o4();
        }
    }

    public final n0 g4() {
        return (n0) this.f4456v.getValue();
    }

    public final void h() {
        FrameLayout frameLayout;
        if (!this.f4447m && (frameLayout = (FrameLayout) w3(R$id.mFlLoading)) != null) {
            frameLayout.setVisibility(0);
        }
    }

    public String h4() {
        return (String) this.f4458x.getValue();
    }

    /* renamed from: i4 */
    public u a3() {
        u uVar = this.f4459y;
        if (uVar != null) {
            return uVar;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final int j4() {
        if (getContext() == null) {
            return 0;
        }
        com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f12601a;
        Context context = getContext();
        t9.i.d(context);
        int d10 = n0Var.d(context, "live_last_play_column_index", 0);
        if (I3() && t4() != -1) {
            d10 = t4();
        }
        if (d10 == -1) {
            return 0;
        }
        return d10;
    }

    public void k2() {
        T2();
    }

    public final int k4() {
        return ((Number) this.f4454t.getValue()).intValue();
    }

    public final void l4(List list) {
        boolean z10;
        List data;
        List data2;
        int i10;
        boolean z11;
        V0();
        TextView textView = (TextView) w3(R$id.tvTips);
        boolean z12 = false;
        if (textView != null) {
            if (!list.isEmpty()) {
                ChildColumnList a10 = z.f4508u.a();
                if (a10 == null || this.f4449o != a10.getId()) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    i10 = 0;
                    textView.setVisibility(i10);
                }
            }
            i10 = 8;
            textView.setVisibility(i10);
        }
        l0 f42 = f4();
        if (!(f42 == null || (data2 = f42.getData()) == null)) {
            data2.clear();
        }
        l0 f43 = f4();
        if (!(f43 == null || (data = f43.getData()) == null)) {
            data.addAll(list);
        }
        l0 f44 = f4();
        if (f44 != null) {
            f44.notifyDataSetChanged();
        }
        if (!list.isEmpty()) {
            B4();
        } else {
            D4();
        }
        if (!this.f4447m) {
            if (H.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                a4();
            }
        }
        if (H.length() > 0) {
            z12 = true;
        }
        if (z12) {
            V3();
        }
    }

    public final void m4() {
        n4();
        this.f4451q = false;
        j4();
    }

    public final void n4() {
        String str;
        Context context = getContext();
        if (context != null) {
            str = com.mobile.brasiltv.utils.n0.f12601a.e(context, "live_last_play_chanel_NORMAL", "");
        } else {
            str = null;
        }
        if (b0.H(str)) {
            z.a aVar = z.f4508u;
            if (!t9.i.b(str, aVar.f())) {
                Context context2 = getContext();
                if (context2 != null) {
                    com.mobile.brasiltv.utils.n0.f12601a.i(context2, "live_last_play_column_index", 0);
                }
                aVar.n(str);
            }
        }
        this.f4451q = true;
    }

    public final void o4() {
        boolean z10;
        w wVar = new w();
        String f10 = z.f4508u.f();
        if (f10 == null) {
            f10 = "";
        }
        wVar.f19600a = f10;
        if (f10.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 && !I3()) {
            Observable.fromIterable(this.f4443i).filter(new c0(new o(wVar))).compose(p0.a()).subscribe(new d0(new p(this, wVar)), new e0(q.f11087a));
        } else if (this.f4443i.size() > 0) {
            L3(0, ((Channel) this.f4443i.get(0)).getChannelCode());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        A4(new u(this, this));
        xa.c.c().o(this);
    }

    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.f4450p;
        if (disposable != null) {
            disposable.dispose();
        }
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        Disposable disposable = this.f4450p;
        if (disposable != null) {
            disposable.dispose();
        }
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        X2();
    }

    public void onError() {
        O3();
        E4();
    }

    public void onLoading() {
        String.valueOf(k4());
        h();
    }

    public void onRefresh() {
        boolean z10;
        ChildColumnList a10 = z.f4508u.a();
        if (a10 == null || this.f4449o != a10.getId()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10 || (K3() && F4())) {
            this.f4447m = true;
            B4();
            u4();
            return;
        }
        ((KoocanSwipeRefreshLayout) w3(R$id.mRefreshLayout)).setRefreshing(false);
    }

    public void onResume() {
        super.onResume();
        if (getUserVisibleHint() && this.f4452r && z.f4508u.h()) {
            o4();
            a4();
            boolean z10 = false;
            this.f4452r = false;
            Disposable disposable = this.f4450p;
            if (disposable != null) {
                if (disposable != null && disposable.isDisposed()) {
                    z10 = true;
                }
                if (z10) {
                    V0();
                }
            }
        }
    }

    public void onStop() {
        super.onStop();
        FrameLayout frameLayout = (FrameLayout) w3(R$id.mFlLoading);
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public final int s4() {
        boolean z10;
        z.a aVar = z.f4508u;
        int i10 = -1;
        if (aVar.g().indexOfKey(this.f4449o) >= 0) {
            List list = (List) aVar.g().get(this.f4449o);
            int i11 = 0;
            if (list == null || list.isEmpty()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                List list2 = (List) aVar.g().get(this.f4449o);
                t9.i.f(list2, "channelList");
                for (Object next : list2) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        i9.j.j();
                    }
                    if (t9.i.b(((Channel) next).getChannelCode(), H)) {
                        i10 = i11;
                    }
                    i11 = i12;
                }
            }
        }
        return i10;
    }

    public final int t4() {
        boolean z10;
        int i10 = -1;
        if (!b4().isEmpty() && z.f4508u.e() != null) {
            int i11 = 0;
            for (Object next : b4()) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    i9.j.j();
                }
                int intValue = ((Number) next).intValue();
                ChildColumnList e10 = z.f4508u.e();
                if (e10 == null || e10.getId() != intValue) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10) {
                    i10 = i11;
                }
                i11 = i12;
            }
        }
        return i10;
    }

    public final void u4() {
        h();
        a3().k(this.f4449o, false);
    }

    public final void v4(List list) {
        t9.i.g(list, "liveProgramBean");
        z.a aVar = z.f4508u;
        aVar.b().clear();
        if (!list.isEmpty()) {
            aVar.j(((Channel) list.get(0)).getChannelCode());
        }
        xa.c.c().m(new UpdateAllChannelEvent(list));
        Observable.fromIterable(list).subscribe(new g0(s.f11089a), new h0(t.f11090a));
    }

    public View w3(int i10) {
        View findViewById;
        Map map = this.f4460z;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void y4(List list, int i10) {
        t9.i.g(list, "listChannel");
        if (list.size() > i10 && i10 >= 0) {
            z.a aVar = z.f4508u;
            aVar.n(((Channel) list.get(i10)).getChannelCode());
            Context context = getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.n0.f12601a.j(context, "live_last_play_chanel", aVar.f());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void z4(boolean r8) {
        /*
            r7 = this;
            r7.f4452r = r8
            b6.z$a r8 = b6.z.f4508u
            java.util.ArrayList r0 = r8.d()
            if (r0 == 0) goto L_0x00e6
            boolean r0 = com.mobile.brasiltv.utils.f0.b()
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0038
            mobile.com.requestframe.utils.response.ChildColumnList r0 = r8.e()
            if (r0 == 0) goto L_0x001e
            java.lang.String r0 = r0.getAlias()
            goto L_0x001f
        L_0x001e:
            r0 = r3
        L_0x001f:
            if (r0 == 0) goto L_0x002a
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r0 = 0
            goto L_0x002b
        L_0x002a:
            r0 = 1
        L_0x002b:
            if (r0 != 0) goto L_0x0038
            mobile.com.requestframe.utils.response.ChildColumnList r0 = r8.e()
            if (r0 == 0) goto L_0x0042
            java.lang.String r3 = r0.getAlias()
            goto L_0x0042
        L_0x0038:
            mobile.com.requestframe.utils.response.ChildColumnList r0 = r8.e()
            if (r0 == 0) goto L_0x0042
            java.lang.String r3 = r0.getName()
        L_0x0042:
            w6.i$c r0 = w6.i.f9510g
            java.lang.String r4 = r0.e()
            java.lang.String r5 = "1"
            boolean r4 = t9.i.b(r4, r5)
            java.lang.String r6 = ""
            if (r4 == 0) goto L_0x00c5
            java.lang.String r4 = r0.I()
            boolean r4 = t9.i.b(r4, r5)
            if (r4 != 0) goto L_0x0068
            java.lang.String r0 = r0.I()
            java.lang.String r4 = "2"
            boolean r0 = t9.i.b(r0, r4)
            if (r0 == 0) goto L_0x00c5
        L_0x0068:
            java.util.ArrayList r0 = r7.b4()
            mobile.com.requestframe.utils.response.ChildColumnList r1 = r8.e()
            t9.i.d(r1)
            int r1 = r1.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x00b8
            java.util.ArrayList r0 = r7.b4()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00a2
            java.util.ArrayList r0 = r7.b4()
            mobile.com.requestframe.utils.response.ChildColumnList r8 = r8.e()
            t9.i.d(r8)
            int r8 = r8.getId()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r0.add(r2, r8)
            goto L_0x00b8
        L_0x00a2:
            java.util.ArrayList r0 = r7.b4()
            mobile.com.requestframe.utils.response.ChildColumnList r8 = r8.e()
            t9.i.d(r8)
            int r8 = r8.getId()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r0.add(r8)
        L_0x00b8:
            g5.n0 r8 = r7.g4()
            if (r8 == 0) goto L_0x00e6
            if (r3 != 0) goto L_0x00c1
            r3 = r6
        L_0x00c1:
            r8.c(r2, r3)
            goto L_0x00e6
        L_0x00c5:
            java.util.ArrayList r0 = r7.b4()
            mobile.com.requestframe.utils.response.ChildColumnList r8 = r8.e()
            if (r8 == 0) goto L_0x00d3
            int r1 = r8.getId()
        L_0x00d3:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
            r0.remove(r8)
            g5.n0 r8 = r7.g4()
            if (r8 == 0) goto L_0x00e6
            if (r3 != 0) goto L_0x00e3
            r3 = r6
        L_0x00e3:
            r8.g(r3)
        L_0x00e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.r0.z4(boolean):void");
    }
}
