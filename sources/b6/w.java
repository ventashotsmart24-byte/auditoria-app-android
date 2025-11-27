package b6;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.e;
import androidx.recyclerview.widget.RecyclerView;
import b6.z;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.AlreadyQueryFavEvent;
import com.mobile.brasiltv.bean.event.ClickChannelEpgEvent;
import com.mobile.brasiltv.bean.event.ReadyPlayFavEvent;
import com.mobile.brasiltv.bean.event.UpdateChannelEvent;
import com.mobile.brasiltv.bean.event.UpdateFavStatusEvent;
import com.mobile.brasiltv.bean.event.UpdateHighLightEvent;
import com.mobile.brasiltv.bean.event.UserIdentityChangeEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.s0;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LinerItemDecoration;
import com.msandroid.mobile.R;
import g5.l0;
import h9.g;
import h9.h;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k7.f;
import mobile.com.requestframe.utils.response.Channel;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.Favorite;
import mobile.com.requestframe.utils.response.LiveAddress;
import mobile.com.requestframe.utils.response.PosterList;
import org.greenrobot.eventbus.ThreadMode;
import s9.l;
import t9.i;
import t9.j;

public final class w extends f {

    /* renamed from: e  reason: collision with root package name */
    public final g f4501e = h.b(new b(this));

    /* renamed from: f  reason: collision with root package name */
    public LinearLayoutManagerWrapper f4502f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList f4503g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f4504h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public ArrayList f4505i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public final g f4506j = h.b(a.f11167a);

    /* renamed from: k  reason: collision with root package name */
    public Map f4507k = new LinkedHashMap();

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f11167a = new a();

        public a() {
            super(0);
        }

        public final Integer invoke() {
            z.a aVar = z.f4508u;
            int i10 = 0;
            if (b0.I(aVar.d())) {
                ArrayList d10 = aVar.d();
                i.d(d10);
                i10 = ((ChildColumnList) d10.get(0)).getId();
            }
            return Integer.valueOf(i10);
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f11168a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(w wVar) {
            super(0);
            this.f11168a = wVar;
        }

        /* renamed from: b */
        public final l0 invoke() {
            Context context = this.f11168a.getContext();
            i.d(context);
            l0 l0Var = new l0(context);
            l0Var.d(true);
            return l0Var;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f11169a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(w wVar) {
            super(1);
            this.f11169a = wVar;
        }

        public final void b(Integer num) {
            this.f11169a.j3().getData().clear();
            this.f11169a.j3().getData().addAll(this.f11169a.f4504h);
            this.f11169a.j3().notifyDataSetChanged();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return t.f17319a;
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final d f11170a = new d();

        public d() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final void n3(w wVar, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        ClickChannelEpgEvent clickChannelEpgEvent;
        i.g(wVar, "this$0");
        int id = view.getId();
        if (id == R.id.mFavWrapper) {
            wVar.k3(i10);
        } else if (id == R.id.mImageEpg) {
            xa.c c10 = xa.c.c();
            String alias = ((Channel) wVar.f4504h.get(i10)).getAlias();
            if (alias != null) {
                clickChannelEpgEvent = new ClickChannelEpgEvent(((Channel) wVar.f4504h.get(i10)).getChannelCode(), ((Channel) wVar.f4504h.get(i10)).getName(), wVar.i3(), alias);
            } else {
                clickChannelEpgEvent = null;
            }
            c10.m(clickChannelEpgEvent);
        } else if (id == R.id.mLayoutProgram && wVar.f4504h.size() > 0 && i10 <= wVar.f4504h.size() - 1) {
            wVar.f3(i10, ((Channel) wVar.f4504h.get(i10)).getChannelCode());
        }
    }

    public static final void r3(w wVar, ObservableEmitter observableEmitter) {
        i.g(wVar, "this$0");
        i.g(observableEmitter, "it");
        wVar.f4503g.clear();
        wVar.f4503g.addAll(d6.a.f16338a.i());
        wVar.h3();
        wVar.g3();
        observableEmitter.onNext(0);
    }

    public static final void s3(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void t3(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void T2() {
    }

    public void X2() {
        this.f4507k.clear();
    }

    @xa.j
    public final void alreadyQueryFav(AlreadyQueryFavEvent alreadyQueryFavEvent) {
        i.g(alreadyQueryFavEvent, "event");
        q3();
    }

    public View c3(int i10) {
        View findViewById;
        Map map = this.f4507k;
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

    public final void f3(int i10, String str) {
        boolean z10;
        String f10 = z.f4508u.f();
        if (f10 == null) {
            f10 = "";
        }
        f.e("clickItem position: " + i10 + " + channelCode: " + str + " + lastChannelCode " + f10, new Object[0]);
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || i.b(str, f10)) {
            b0.U(this, "不播放，当前curPlayIndex：" + i10);
            return;
        }
        b0.U(this, "换台 position: " + i10 + ", channelCode: " + str);
        n0 n0Var = n0.f12601a;
        e activity = getActivity();
        i.d(activity);
        int d10 = n0Var.d(activity, "live_last_play_column_index", 0);
        e activity2 = getActivity();
        i.d(activity2);
        n0Var.i(activity2, "live_last_play_column_index", -1);
        j3().c(i10);
        j3().notifyDataSetChanged();
        p3(this.f4504h, i10);
        this.f4505i.clear();
        this.f4505i.addAll(this.f4504h);
        xa.c.c().j(new ReadyPlayFavEvent(this.f4505i, i10, d10));
    }

    public final void g3() {
        String f10 = z.f4508u.f();
        if (f10 == null) {
            f10 = "";
        }
        int i10 = 0;
        for (Object next : this.f4504h) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                i9.j.j();
            }
            if (i.b(f10, ((Channel) next).getChannelCode())) {
                j3().c(i10);
                return;
            }
            i10 = i11;
        }
        j3().c(-1);
    }

    public final void h3() {
        w wVar = this;
        wVar.f4504h.clear();
        if (wVar.f4503g.size() > 0) {
            for (Favorite favorite : wVar.f4503g) {
                ArrayList arrayList = wVar.f4504h;
                String contentId = favorite.getContentId();
                i.d(contentId);
                String name = favorite.getName();
                i.d(name);
                Channel channel = r4;
                Channel channel2 = new Channel(contentId, name, favorite.getAlias(), 0, favorite.getPosterUrl(), (String) null, "0", (String) null, (String) null, (List<? extends PosterList>) null, (List<LiveAddress>) null);
                arrayList.add(channel);
                wVar = this;
            }
        }
    }

    public final int i3() {
        return ((Number) this.f4506j.getValue()).intValue();
    }

    public final l0 j3() {
        return (l0) this.f4501e.getValue();
    }

    public final void k3(int i10) {
        if (i10 < this.f4504h.size()) {
            Object obj = this.f4504h.get(i10);
            i.f(obj, "channelList[pos]");
            Channel channel = (Channel) obj;
            d6.a aVar = d6.a.f16338a;
            if (!aVar.l(channel.getChannelCode())) {
                aVar.f(channel.getChannelCode());
                j3().g(channel.getChannelCode(), i10);
                aVar.h(channel);
            }
        }
    }

    public final void l3() {
        d6.a aVar = d6.a.f16338a;
        if (aVar.j() == 3 && (!aVar.i().isEmpty())) {
            q3();
        } else if (aVar.j() == 1) {
            aVar.m();
        }
    }

    public final void m3() {
        j3().setOnItemChildClickListener(new s(this));
    }

    public final void o3() {
        LinerItemDecoration linerItemDecoration = new LinerItemDecoration(s0.a(getActivity(), 1.0f), 0, true);
        this.f4502f = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        int i10 = R$id.mRecyclerViewLiveInfo;
        RecyclerView recyclerView = (RecyclerView) c3(i10);
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = this.f4502f;
        if (linearLayoutManagerWrapper == null) {
            i.w("layoutManager");
            linearLayoutManagerWrapper = null;
        }
        recyclerView.setLayoutManager(linearLayoutManagerWrapper);
        ((RecyclerView) c3(i10)).addItemDecoration(linerItemDecoration);
        ((RecyclerView) c3(i10)).setAdapter(j3());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!xa.c.c().h(this)) {
            xa.c.c().o(this);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        i.g(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_live_fav, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (!z10) {
            j3().notifyDataSetChanged();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        i.g(view, "view");
        super.onViewCreated(view, bundle);
        o3();
        m3();
        l3();
    }

    public final void p3(List list, int i10) {
        i.g(list, "listChannel");
        if (list.size() > i10 && i10 >= 0) {
            z.a aVar = z.f4508u;
            aVar.n(((Channel) list.get(i10)).getChannelCode());
            n0 n0Var = n0.f12601a;
            Context context = getContext();
            i.d(context);
            n0Var.j(context, "live_last_play_chanel", aVar.f());
        }
    }

    public final void q3() {
        Observable.create(new t(this)).compose(p0.a()).subscribe(new u(new c(this)), new v(d.f11170a));
    }

    @xa.j
    public final void readyHighLightItem(UpdateHighLightEvent updateHighLightEvent) {
        i.g(updateHighLightEvent, "event");
        f.e("从全屏返回 LiveFavFrag 刷新页面", new Object[0]);
        g3();
        j3().notifyDataSetChanged();
    }

    @xa.j
    public final void updateFavStatus(UpdateFavStatusEvent updateFavStatusEvent) {
        i.g(updateFavStatusEvent, "event");
        q3();
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void userLogOut(UserIdentityChangeEvent userIdentityChangeEvent) {
        i.g(userIdentityChangeEvent, "event");
        if (i.b(w6.i.f9510g.I(), "1")) {
            this.f4503g.clear();
            this.f4504h.clear();
            j3().getData().clear();
            j3().notifyDataSetChanged();
            return;
        }
        l3();
    }

    @xa.j
    public final void whenLiveItemClickPlay(UpdateChannelEvent updateChannelEvent) {
        i.g(updateChannelEvent, "event");
        f.e("LiveItem点击播放 LiveFavFrag 刷新页面", new Object[0]);
        g3();
        j3().notifyDataSetChanged();
    }
}
