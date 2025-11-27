package b6;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import b6.z;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.LiveTabEntity;
import com.mobile.brasiltv.bean.event.RefreshChannelEPGEvent;
import com.mobile.brasiltv.bean.event.UpdateHighLightEvent;
import com.mobile.brasiltv.bean.event.UserIdentityChangeEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f0;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.view.CenterLayoutManager;
import com.msandroid.mobile.R;
import g5.h0;
import g5.v0;
import g5.w0;
import h9.g;
import h9.h;
import i6.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k7.f;
import l6.d1;
import mobile.com.requestframe.utils.response.ChildColumnList;
import t9.i;
import t9.j;
import w6.i;

public final class o2 extends e<d1> implements r {

    /* renamed from: i  reason: collision with root package name */
    public final List f4426i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public final List f4427j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public LiveTabEntity f4428k;

    /* renamed from: l  reason: collision with root package name */
    public d1 f4429l;

    /* renamed from: m  reason: collision with root package name */
    public final g f4430m = h.b(new d(this));

    /* renamed from: n  reason: collision with root package name */
    public final g f4431n = h.b(new a(this));

    /* renamed from: o  reason: collision with root package name */
    public final g f4432o = h.b(b.f11056a);

    /* renamed from: p  reason: collision with root package name */
    public Map f4433p = new LinkedHashMap();

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o2 f11055a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(o2 o2Var) {
            super(0);
            this.f11055a = o2Var;
        }

        /* renamed from: b */
        public final w0 invoke() {
            return new w0(this.f11055a.getChildFragmentManager(), this.f11055a.f4426i);
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f11056a = new b();

        public b() {
            super(0);
        }

        /* renamed from: b */
        public final ArrayList invoke() {
            ArrayList arrayList = new ArrayList();
            z.a aVar = z.f4508u;
            if (b0.I(aVar.d())) {
                ArrayList<ChildColumnList> d10 = aVar.d();
                i.d(d10);
                for (ChildColumnList id : d10) {
                    arrayList.add(Integer.valueOf(id.getId()));
                }
            }
            return arrayList;
        }
    }

    public static final class c implements ViewPager.j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o2 f11057a;

        public c(o2 o2Var) {
            this.f11057a = o2Var;
        }

        public void onPageScrollStateChanged(int i10) {
        }

        public void onPageScrolled(int i10, float f10, int i11) {
        }

        public void onPageSelected(int i10) {
            this.f11057a.r3(i10);
        }
    }

    public static final class d extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o2 f11058a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(o2 o2Var) {
            super(0);
            this.f11058a = o2Var;
        }

        /* renamed from: b */
        public final v0 invoke() {
            e activity = this.f11058a.getActivity();
            if (activity != null) {
                return new v0(activity);
            }
            return null;
        }
    }

    public static final void k3(o2 o2Var, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        i.g(o2Var, "this$0");
        ((ViewPager) o2Var.h3(R$id.liveViewPager)).setCurrentItem(i10);
        o2Var.r3(i10);
    }

    public static final void s3(RecyclerView.o oVar, o2 o2Var, int i10) {
        i.g(o2Var, "this$0");
        oVar.smoothScrollToPosition((RecyclerView) o2Var.h3(R$id.recyclerView), new RecyclerView.a0(), i10);
    }

    public void G(List list, int i10) {
        i.g(list, "list");
        z.f4508u.g().put(i10, list);
    }

    public void T2() {
    }

    public void X2() {
        this.f4433p.clear();
    }

    public void Y2() {
        boolean z10;
        z.a aVar = z.f4508u;
        if (b0.I(aVar.d())) {
            ArrayList d10 = aVar.d();
            i.d(d10);
            Iterator it = d10.iterator();
            int i10 = 0;
            while (true) {
                boolean z11 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                int i11 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                ChildColumnList childColumnList = (ChildColumnList) next;
                String str = "";
                if (!f0.b()) {
                    String alias = childColumnList.getAlias();
                    if (alias == null || alias.length() == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10) {
                        List list = this.f4426i;
                        String alias2 = childColumnList.getAlias();
                        i.d(alias2);
                        list.add(alias2);
                        List list2 = this.f4427j;
                        String alias3 = childColumnList.getAlias();
                        if (alias3 != null) {
                            str = alias3;
                        }
                        if (i10 != 0) {
                            z11 = false;
                        }
                        list2.add(new LiveTabEntity(str, z11, i10));
                        i10 = i11;
                    }
                }
                List list3 = this.f4426i;
                String alias4 = childColumnList.getAlias();
                i.d(alias4);
                list3.add(alias4);
                List list4 = this.f4427j;
                String alias5 = childColumnList.getAlias();
                if (alias5 != null) {
                    str = alias5;
                }
                if (i10 != 0) {
                    z11 = false;
                }
                list4.add(new LiveTabEntity(str, z11, i10));
                i10 = i11;
            }
            this.f4428k = (LiveTabEntity) this.f4427j.get(0);
            int i12 = R$id.liveViewPager;
            if (((ViewPager) h3(i12)) != null) {
                ((ViewPager) h3(i12)).setAdapter(l3());
                ((ViewPager) h3(i12)).addOnPageChangeListener(new c(this));
            }
            CenterLayoutManager centerLayoutManager = new CenterLayoutManager(getActivity(), 0, false);
            int i13 = R$id.recyclerView;
            ((RecyclerView) h3(i13)).setHasFixedSize(true);
            ((RecyclerView) h3(i13)).setLayoutManager(centerLayoutManager);
            ((RecyclerView) h3(i13)).setAdapter(p3());
            v0 p32 = p3();
            if (p32 != null) {
                p32.setNewData(this.f4427j);
            }
            v0 p33 = p3();
            if (p33 != null) {
                p33.setOnItemClickListener(new n2(this));
            }
            int o32 = o3();
            if (!m3().isEmpty()) {
                ((ViewPager) h3(i12)).setCurrentItem(o32);
                r3(o32);
            }
            z.a aVar2 = z.f4508u;
            if (aVar2.e() != null) {
                d1 n32 = a3();
                ChildColumnList e10 = aVar2.e();
                i.d(e10);
                n32.n(e10.getId(), true);
            }
        }
    }

    public int c3() {
        return R.layout.frag_live_tab;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0089  */
    @xa.j(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void clickSearchChannel(com.mobile.brasiltv.bean.event.ClickSearchChannelEvent r7) {
        /*
            r6 = this;
            java.lang.String r0 = "event"
            t9.i.g(r7, r0)
            b6.z$a r0 = b6.z.f4508u
            mobile.com.requestframe.utils.response.Channel r1 = r7.getChannel()
            java.lang.String r1 = r1.getChannelCode()
            r0.n(r1)
            mobile.com.requestframe.utils.response.ChildColumnList r1 = r0.e()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x007a
            w6.i$c r1 = w6.i.f9510g
            java.lang.String r4 = r1.e()
            java.lang.String r5 = "1"
            boolean r4 = t9.i.b(r4, r5)
            if (r4 == 0) goto L_0x007a
            java.lang.String r4 = r1.I()
            boolean r4 = t9.i.b(r4, r5)
            if (r4 != 0) goto L_0x003e
            java.lang.String r1 = r1.I()
            java.lang.String r4 = "2"
            boolean r1 = t9.i.b(r1, r4)
            if (r1 == 0) goto L_0x007a
        L_0x003e:
            android.util.SparseArray r1 = r0.g()
            mobile.com.requestframe.utils.response.ChildColumnList r0 = r0.e()
            t9.i.d(r0)
            int r0 = r0.getId()
            java.lang.Object r0 = r1.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x007a
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x005a:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x007b
            java.lang.Object r4 = r0.next()
            mobile.com.requestframe.utils.response.Channel r4 = (mobile.com.requestframe.utils.response.Channel) r4
            mobile.com.requestframe.utils.response.Channel r5 = r7.getChannel()
            java.lang.String r5 = r5.getChannelCode()
            java.lang.String r4 = r4.getChannelCode()
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 == 0) goto L_0x005a
            r1 = 1
            goto L_0x005a
        L_0x007a:
            r1 = 0
        L_0x007b:
            if (r1 == 0) goto L_0x0089
            int r7 = com.mobile.brasiltv.R$id.liveViewPager
            android.view.View r7 = r6.h3(r7)
            androidx.viewpager.widget.ViewPager r7 = (androidx.viewpager.widget.ViewPager) r7
            r7.setCurrentItem(r2)
            goto L_0x0094
        L_0x0089:
            int r7 = com.mobile.brasiltv.R$id.liveViewPager
            android.view.View r7 = r6.h3(r7)
            androidx.viewpager.widget.ViewPager r7 = (androidx.viewpager.widget.ViewPager) r7
            r7.setCurrentItem(r3)
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.o2.clickSearchChannel(com.mobile.brasiltv.bean.event.ClickSearchChannelEvent):void");
    }

    @xa.j(sticky = true)
    public final void getCurEpg(RefreshChannelEPGEvent refreshChannelEPGEvent) {
        i.g(refreshChannelEPGEvent, "event");
        List<Fragment> s02 = getChildFragmentManager().s0();
        i.f(s02, "childFragmentManager.fragments");
        for (Fragment fragment : s02) {
            if ((fragment instanceof h0) && fragment.isVisible()) {
                ((h0) fragment).V0();
            }
        }
    }

    public View h3(int i10) {
        View findViewById;
        Map map = this.f4433p;
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

    public final boolean j3() {
        Boolean bool;
        Context context = getContext();
        if (context != null) {
            bool = Boolean.valueOf(n0.c(n0.f12601a, context, "live_first_play_free_column", false, 4, (Object) null));
        } else {
            bool = null;
        }
        i.c cVar = w6.i.f9510g;
        if ((t9.i.b(cVar.I(), "1") || t9.i.b(cVar.I(), "2")) && t9.i.b(cVar.e(), "1") && t9.i.b(bool, Boolean.TRUE)) {
            return true;
        }
        return false;
    }

    public final w0 l3() {
        return (w0) this.f4431n.getValue();
    }

    public final ArrayList m3() {
        return (ArrayList) this.f4432o.getValue();
    }

    /* renamed from: n3 */
    public d1 a3() {
        d1 d1Var = this.f4429l;
        if (d1Var != null) {
            return d1Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final int o3() {
        n0 n0Var = n0.f12601a;
        Context context = getContext();
        t9.i.d(context);
        int d10 = n0Var.d(context, "live_last_play_column_index", 0);
        if (j3() && q3() != -1) {
            d10 = q3();
        }
        if (d10 == -1) {
            return 0;
        }
        return d10;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        t3(new d1(this, this));
        if (!xa.c.c().h(this)) {
            xa.c.c().o(this);
        }
    }

    public void onDestroy() {
        xa.c.c().r(this);
        super.onDestroy();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (!z10 && getContext() != null) {
            int o32 = o3();
            if (!m3().isEmpty()) {
                ((ViewPager) h3(R$id.liveViewPager)).setCurrentItem(o32);
                r3(o32);
            }
            List<Fragment> s02 = getChildFragmentManager().s0();
            t9.i.f(s02, "childFragmentManager.fragments");
            for (Fragment fragment : s02) {
                if ((fragment instanceof h0) && fragment.isVisible()) {
                    ((h0) fragment).k2();
                }
            }
        }
    }

    public final v0 p3() {
        return (v0) this.f4430m.getValue();
    }

    public void q2() {
        xa.c.c().m(new RefreshChannelEPGEvent());
    }

    public final int q3() {
        int i10 = -1;
        if (!m3().isEmpty() && z.f4508u.e() != null) {
            int i11 = 0;
            for (Object next : m3()) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    i9.j.j();
                }
                int intValue = ((Number) next).intValue();
                ChildColumnList e10 = z.f4508u.e();
                t9.i.d(e10);
                if (e10.getId() == intValue) {
                    i10 = i11;
                }
                i11 = i12;
            }
        }
        return i10;
    }

    public final void r3(int i10) {
        LiveTabEntity liveTabEntity;
        v0 p32 = p3();
        RecyclerView.o oVar = null;
        if (p32 != null) {
            liveTabEntity = (LiveTabEntity) p32.getItem(i10);
        } else {
            liveTabEntity = null;
        }
        if (!t9.i.b(liveTabEntity, this.f4428k)) {
            if (liveTabEntity != null) {
                liveTabEntity.setSelected(true);
            }
            LiveTabEntity liveTabEntity2 = this.f4428k;
            if (liveTabEntity2 != null) {
                if (liveTabEntity2 != null) {
                    liveTabEntity2.setSelected(false);
                }
                v0 p33 = p3();
                if (p33 != null) {
                    p33.notifyDataSetChanged();
                }
            }
            this.f4428k = liveTabEntity;
            int i11 = R$id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) h3(i11);
            if (recyclerView != null) {
                oVar = recyclerView.getLayoutManager();
            }
            if (oVar != null) {
                ((RecyclerView) h3(i11)).postDelayed(new m2(oVar, this, i10), 100);
            }
        }
    }

    @xa.j
    public final void readyHighLightItem(UpdateHighLightEvent updateHighLightEvent) {
        int i10;
        t9.i.g(updateHighLightEvent, "event");
        e activity = getActivity();
        if (activity != null) {
            i10 = n0.f12601a.d(activity, "live_last_play_column_index", 0);
        } else {
            i10 = 0;
        }
        f.e("从全屏返回 channelCode：" + updateHighLightEvent.getCode() + ", columnPosition: " + i10, new Object[0]);
        if (i10 >= 0) {
            Log.e("currentItem", String.valueOf(i10));
            ((ViewPager) h3(R$id.liveViewPager)).setCurrentItem(i10, false);
        } else {
            ((ViewPager) h3(R$id.liveViewPager)).setCurrentItem(0, false);
        }
        List<Fragment> s02 = getChildFragmentManager().s0();
        t9.i.f(s02, "childFragmentManager.fragments");
        for (Fragment fragment : s02) {
            if ((fragment instanceof h0) && fragment.isVisible()) {
                ((h0) fragment).c1();
            }
        }
    }

    public void t3(d1 d1Var) {
        t9.i.g(d1Var, "<set-?>");
        this.f4429l = d1Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cd, code lost:
        if (r11.contains(r1) == false) goto L_0x00d1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bc  */
    @xa.j(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateRestrict(com.mobile.brasiltv.bean.event.UpdateRestrictEvent r11) {
        /*
            r10 = this;
            java.lang.String r0 = "event"
            t9.i.g(r11, r0)
            b6.z$a r0 = b6.z.f4508u
            java.util.ArrayList r1 = r0.d()
            if (r1 == 0) goto L_0x011f
            boolean r1 = com.mobile.brasiltv.utils.f0.b()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x003d
            mobile.com.requestframe.utils.response.ChildColumnList r1 = r0.a()
            t9.i.d(r1)
            java.lang.String r1 = r1.getAlias()
            if (r1 == 0) goto L_0x002b
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r1 = 0
            goto L_0x002c
        L_0x002b:
            r1 = 1
        L_0x002c:
            if (r1 != 0) goto L_0x003d
            mobile.com.requestframe.utils.response.ChildColumnList r1 = r0.a()
            t9.i.d(r1)
            java.lang.String r1 = r1.getAlias()
            t9.i.d(r1)
            goto L_0x0048
        L_0x003d:
            mobile.com.requestframe.utils.response.ChildColumnList r1 = r0.a()
            t9.i.d(r1)
            java.lang.String r1 = r1.getName()
        L_0x0048:
            r5 = r1
            java.lang.String r11 = r11.getStatus()
            java.lang.String r1 = "0"
            boolean r11 = t9.i.b(r11, r1)
            if (r11 == 0) goto L_0x00bc
            java.util.ArrayList r11 = r0.d()
            if (r11 == 0) goto L_0x0065
            mobile.com.requestframe.utils.response.ChildColumnList r1 = r0.a()
            t9.i.d(r1)
            r11.remove(r1)
        L_0x0065:
            java.util.ArrayList r11 = r10.m3()
            mobile.com.requestframe.utils.response.ChildColumnList r0 = r0.a()
            t9.i.d(r0)
            int r0 = r0.getId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r11.remove(r0)
            java.util.List r11 = r10.f4426i
            if (r11 == 0) goto L_0x0082
            r11.remove(r5)
        L_0x0082:
            java.util.List r11 = r10.f4427j
            java.util.Iterator r11 = r11.iterator()
        L_0x0088:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x00a0
            java.lang.Object r0 = r11.next()
            r1 = r0
            com.mobile.brasiltv.bean.LiveTabEntity r1 = (com.mobile.brasiltv.bean.LiveTabEntity) r1
            java.lang.String r1 = r1.getName()
            boolean r1 = t9.i.b(r1, r5)
            if (r1 == 0) goto L_0x0088
            goto L_0x00a1
        L_0x00a0:
            r0 = 0
        L_0x00a1:
            r11 = r0
            com.mobile.brasiltv.bean.LiveTabEntity r11 = (com.mobile.brasiltv.bean.LiveTabEntity) r11
            if (r11 == 0) goto L_0x00ab
            java.util.List r11 = r10.f4427j
            r11.remove(r0)
        L_0x00ab:
            g5.w0 r11 = r10.l3()
            r11.notifyDataSetChanged()
            g5.v0 r11 = r10.p3()
            if (r11 == 0) goto L_0x011f
            r11.notifyDataSetChanged()
            goto L_0x011f
        L_0x00bc:
            java.util.ArrayList r11 = r0.d()
            if (r11 == 0) goto L_0x00d0
            mobile.com.requestframe.utils.response.ChildColumnList r1 = r0.a()
            t9.i.d(r1)
            boolean r11 = r11.contains(r1)
            if (r11 != 0) goto L_0x00d0
            goto L_0x00d1
        L_0x00d0:
            r2 = 0
        L_0x00d1:
            if (r2 == 0) goto L_0x010f
            java.util.ArrayList r11 = r0.d()
            if (r11 == 0) goto L_0x00e3
            mobile.com.requestframe.utils.response.ChildColumnList r1 = r0.a()
            t9.i.d(r1)
            r11.add(r1)
        L_0x00e3:
            java.util.ArrayList r11 = r10.m3()
            mobile.com.requestframe.utils.response.ChildColumnList r0 = r0.a()
            t9.i.d(r0)
            int r0 = r0.getId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r11.add(r0)
            java.util.List r11 = r10.f4426i
            if (r11 == 0) goto L_0x0100
            r11.add(r5)
        L_0x0100:
            java.util.List r11 = r10.f4427j
            com.mobile.brasiltv.bean.LiveTabEntity r0 = new com.mobile.brasiltv.bean.LiveTabEntity
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            r11.add(r0)
        L_0x010f:
            g5.w0 r11 = r10.l3()
            r11.notifyDataSetChanged()
            g5.v0 r11 = r10.p3()
            if (r11 == 0) goto L_0x011f
            r11.notifyDataSetChanged()
        L_0x011f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.o2.updateRestrict(com.mobile.brasiltv.bean.event.UpdateRestrictEvent):void");
    }

    @xa.j
    public final void userIdentityChange(UserIdentityChangeEvent userIdentityChangeEvent) {
        boolean z10;
        t9.i.g(userIdentityChangeEvent, "event");
        r0.A.f("");
        List<Fragment> s02 = getChildFragmentManager().s0();
        t9.i.f(s02, "childFragmentManager.fragments");
        for (Fragment fragment : s02) {
            if (fragment instanceof h0) {
                ((h0) fragment).S0(Boolean.TRUE);
            }
        }
        if (w6.i.f9510g.H().length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            d6.a.f16338a.m();
        }
    }
}
