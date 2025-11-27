package b6;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.e;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.LiveTabEpgNotificationEvent;
import com.mobile.brasiltv.utils.s0;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LinerItemDecoration;
import com.mobile.brasiltv.view.LoadingDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import g5.g0;
import g5.k0;
import h9.h;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;
import t9.j;

public final class r extends f implements k0.a, g0 {

    /* renamed from: j  reason: collision with root package name */
    public static final a f4434j = new a((g) null);

    /* renamed from: k  reason: collision with root package name */
    public static String f4435k = "";

    /* renamed from: l  reason: collision with root package name */
    public static String f4436l = "";

    /* renamed from: m  reason: collision with root package name */
    public static int f4437m = -1;

    /* renamed from: e  reason: collision with root package name */
    public final h9.g f4438e = h.b(new c(this));

    /* renamed from: f  reason: collision with root package name */
    public LinearLayoutManagerWrapper f4439f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayoutManagerWrapper f4440g;

    /* renamed from: h  reason: collision with root package name */
    public final h9.g f4441h = h.b(new b(this));

    /* renamed from: i  reason: collision with root package name */
    public Map f4442i = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a() {
            return r.f4436l;
        }

        public final String b() {
            return r.f4435k;
        }

        public final int c() {
            return r.f4437m;
        }

        public final void d(String str) {
            i.g(str, "<set-?>");
            r.f4436l = str;
        }

        public final void e(String str) {
            i.g(str, "<set-?>");
            r.f4435k = str;
        }

        public final void f(int i10) {
            r.f4437m = i10;
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f11069a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(r rVar) {
            super(0);
            this.f11069a = rVar;
        }

        /* renamed from: b */
        public final k0 invoke() {
            e activity = this.f11069a.getActivity();
            i.d(activity);
            return new k0(activity, this.f11069a);
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f11070a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(r rVar) {
            super(0);
            this.f11070a = rVar;
        }

        public final Integer invoke() {
            Bundle arguments = this.f11070a.getArguments();
            int i10 = 0;
            if (arguments != null) {
                i10 = arguments.getInt("fragment_live_tab_index", 0);
            }
            return Integer.valueOf(i10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        if (com.mobile.brasiltv.utils.b0.I(r4) == true) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void P0(java.util.List r4) {
        /*
            r3 = this;
            g5.k0 r0 = r3.f3()
            java.util.List r0 = r0.getData()
            r0.clear()
            r0 = 0
            r3.showLoading(r0)
            if (r4 == 0) goto L_0x0019
            boolean r1 = com.mobile.brasiltv.utils.b0.I(r4)
            r2 = 1
            if (r1 != r2) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r2 = 0
        L_0x001a:
            if (r2 == 0) goto L_0x004d
            int r1 = com.mobile.brasiltv.R$id.mRecyclerViewEpg
            android.view.View r1 = r3.Y2(r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            if (r1 != 0) goto L_0x0027
            goto L_0x002a
        L_0x0027:
            r1.setVisibility(r0)
        L_0x002a:
            g5.k0 r0 = r3.f3()
            java.util.List r0 = r0.getData()
            r0.addAll(r4)
            g5.k0 r4 = r3.f3()
            r4.notifyDataSetChanged()
            int r4 = com.mobile.brasiltv.R$id.mLlNoData
            android.view.View r4 = r3.Y2(r4)
            com.zhy.autolayout.AutoLinearLayout r4 = (com.zhy.autolayout.AutoLinearLayout) r4
            if (r4 != 0) goto L_0x0047
            goto L_0x005b
        L_0x0047:
            r0 = 8
            r4.setVisibility(r0)
            goto L_0x005b
        L_0x004d:
            int r4 = com.mobile.brasiltv.R$id.mLlNoData
            android.view.View r4 = r3.Y2(r4)
            com.zhy.autolayout.AutoLinearLayout r4 = (com.zhy.autolayout.AutoLinearLayout) r4
            if (r4 != 0) goto L_0x0058
            goto L_0x005b
        L_0x0058:
            r4.setVisibility(r0)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.r.P0(java.util.List):void");
    }

    public void T2() {
    }

    public void X2() {
        this.f4442i.clear();
    }

    public View Y2(int i10) {
        View findViewById;
        Map map = this.f4442i;
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

    public final k0 f3() {
        return (k0) this.f4441h.getValue();
    }

    public final void g3() {
        this.f4439f = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        LinerItemDecoration linerItemDecoration = new LinerItemDecoration(s0.a(getActivity(), 1.0f), 0, true);
        this.f4440g = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        int i10 = R$id.mRecyclerViewEpg;
        RecyclerView recyclerView = (RecyclerView) Y2(i10);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(this.f4440g);
        }
        RecyclerView recyclerView2 = (RecyclerView) Y2(i10);
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(linerItemDecoration);
        }
        RecyclerView recyclerView3 = (RecyclerView) Y2(i10);
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(f3());
        }
    }

    @xa.j
    public final void liveTabEpgNotificationEvent(LiveTabEpgNotificationEvent liveTabEpgNotificationEvent) {
        i.g(liveTabEpgNotificationEvent, "event");
        showLoading(true);
        RecyclerView recyclerView = (RecyclerView) Y2(R$id.mRecyclerViewEpg);
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) Y2(R$id.mLlNoData);
        if (autoLinearLayout != null) {
            autoLinearLayout.setVisibility(8);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!xa.c.c().h(this)) {
            xa.c.c().o(this);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        i.g(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_live_epg, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        X2();
    }

    public void onStop() {
        super.onStop();
        showLoading(false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        i.g(view, "view");
        super.onViewCreated(view, bundle);
        g3();
    }

    public final void showLoading(boolean z10) {
        FragmentManager fragmentManager;
        if (z10) {
            LoadingDialog.Companion companion = LoadingDialog.Companion;
            e activity = getActivity();
            if (activity != null) {
                fragmentManager = activity.getFragmentManager();
            } else {
                fragmentManager = null;
            }
            companion.show(fragmentManager);
            return;
        }
        LoadingDialog.Companion.hidden();
    }
}
