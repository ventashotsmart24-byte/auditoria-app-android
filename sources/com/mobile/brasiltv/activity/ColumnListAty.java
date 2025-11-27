package com.mobile.brasiltv.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import b6.o;
import com.google.android.material.tabs.TabLayout;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.mine.activity.AccountBindAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.MarqueeTextView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.c0;
import f5.d0;
import f5.e0;
import f5.f0;
import g5.x;
import h9.t;
import i6.l;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.w;
import mobile.com.requestframe.utils.response.ChildColumnList;
import t9.i;
import t9.j;

public final class ColumnListAty extends f5.d implements l {

    /* renamed from: t  reason: collision with root package name */
    public static final a f11982t = new a((t9.g) null);

    /* renamed from: u  reason: collision with root package name */
    public static final String f11983u = "columnData";

    /* renamed from: v  reason: collision with root package name */
    public static final String f11984v = "position";

    /* renamed from: w  reason: collision with root package name */
    public static boolean f11985w;

    /* renamed from: x  reason: collision with root package name */
    public static boolean f11986x;

    /* renamed from: y  reason: collision with root package name */
    public static String f11987y = "iscr";

    /* renamed from: l  reason: collision with root package name */
    public int f11988l = -1;

    /* renamed from: m  reason: collision with root package name */
    public boolean f11989m;

    /* renamed from: n  reason: collision with root package name */
    public final h9.g f11990n = h9.h.b(new d(this));

    /* renamed from: o  reason: collision with root package name */
    public w f11991o;

    /* renamed from: p  reason: collision with root package name */
    public final h9.g f11992p = h9.h.b(new c(this));

    /* renamed from: q  reason: collision with root package name */
    public final ArrayList f11993q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    public final ArrayList f11994r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    public Map f11995s = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final String a() {
            return ColumnListAty.f11983u;
        }

        public final boolean b() {
            return ColumnListAty.f11986x;
        }

        public final String c() {
            return ColumnListAty.f11987y;
        }

        public final String d() {
            return ColumnListAty.f11984v;
        }

        public final boolean e() {
            return ColumnListAty.f11985w;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f11996a;

        /* renamed from: b  reason: collision with root package name */
        public final View f11997b;

        /* renamed from: c  reason: collision with root package name */
        public final Drawable f11998c;

        public b(String str, View view, Drawable drawable) {
            i.g(str, ParamsMap.MirrorParams.MIRROR_DOC_MODE);
            i.g(view, "view");
            this.f11996a = str;
            this.f11997b = view;
            this.f11998c = drawable;
        }

        public final Drawable a() {
            return this.f11998c;
        }

        public final String b() {
            return this.f11996a;
        }

        public final View c() {
            return this.f11997b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return i.b(this.f11996a, bVar.f11996a) && i.b(this.f11997b, bVar.f11997b) && i.b(this.f11998c, bVar.f11998c);
        }

        public int hashCode() {
            int hashCode = ((this.f11996a.hashCode() * 31) + this.f11997b.hashCode()) * 31;
            Drawable drawable = this.f11998c;
            return hashCode + (drawable == null ? 0 : drawable.hashCode());
        }

        public String toString() {
            return "TitleWrapperBean(text=" + this.f11996a + ", view=" + this.f11997b + ", stateIcon=" + this.f11998c + ASCIIPropertyListParser.ARRAY_END_TOKEN;
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ColumnListAty f11999a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ColumnListAty columnListAty) {
            super(0);
            this.f11999a = columnListAty;
        }

        public final Integer invoke() {
            return Integer.valueOf(n5.a.f8310a.a(this.f11999a));
        }
    }

    public static final class d extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ColumnListAty f12000a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ColumnListAty columnListAty) {
            super(0);
            this.f12000a = columnListAty;
        }

        /* renamed from: b */
        public final ChildColumnList invoke() {
            Serializable serializableExtra = this.f12000a.getIntent().getSerializableExtra(ColumnListAty.f11982t.a());
            i.e(serializableExtra, "null cannot be cast to non-null type mobile.com.requestframe.utils.response.ChildColumnList");
            return (ChildColumnList) serializableExtra;
        }
    }

    public static final class e implements TabLayout.OnTabSelectedListener {
        public void onTabReselected(TabLayout.Tab tab) {
        }

        public void onTabSelected(TabLayout.Tab tab) {
        }

        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public static final class f implements ViewPager.j {
        public void onPageScrollStateChanged(int i10) {
        }

        public void onPageScrolled(int i10, float f10, int i11) {
        }

        public void onPageSelected(int i10) {
        }
    }

    public static final class g implements KoocanEmptyView.ReloadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ColumnListAty f12001a;

        public g(ColumnListAty columnListAty) {
            this.f12001a = columnListAty;
        }

        public void onClick() {
            this.f12001a.S2().l(this.f12001a.g3());
        }
    }

    public static final class h extends j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f12002a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ColumnListAty f12003b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(List list, ColumnListAty columnListAty) {
            super(1);
            this.f12002a = list;
            this.f12003b = columnListAty;
        }

        public final void b(List list) {
            if (this.f12002a.size() == list.size()) {
                List list2 = this.f12002a;
                ColumnListAty columnListAty = this.f12003b;
                int i10 = 0;
                for (Object next : list2) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        i9.j.j();
                    }
                    ChildColumnList childColumnList = (ChildColumnList) next;
                    b bVar = (b) list.get(i10);
                    TabLayout.Tab tabAt = ((TabLayout) columnListAty.Z2(R$id.columnListTabLayout)).getTabAt(i10);
                    if (tabAt != null) {
                        tabAt.setText((CharSequence) bVar.b());
                    }
                    if (!(bVar.a() == null || tabAt == null)) {
                        tabAt.setIcon(bVar.a());
                    }
                    if (tabAt != null) {
                        tabAt.setCustomView(bVar.c());
                    }
                    i10 = i11;
                }
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return t.f17319a;
        }
    }

    public static final void j3(ColumnListAty columnListAty, View view) {
        i.g(columnListAty, "this$0");
        int currentItem = ((ViewPager) columnListAty.Z2(R$id.columnListViewPager)).getCurrentItem();
        if (columnListAty.f11993q.size() > 0 && currentItem < columnListAty.f11993q.size()) {
            Object obj = columnListAty.f11993q.get(currentItem);
            i.e(obj, "null cannot be cast to non-null type com.mobile.brasiltv.fragment.ColumnListFrag");
            ((o) obj).u3();
        }
    }

    public static final void k3(ColumnListAty columnListAty, View view) {
        i.g(columnListAty, "this$0");
        b0.c0(columnListAty, SearchAty.class);
    }

    public static final void n3(ColumnListAty columnListAty, View view) {
        i.g(columnListAty, "this$0");
        i1.N(columnListAty.Q1());
        b0.c0(columnListAty, AccountBindAty.class);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005e, code lost:
        if (r5 == null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0060, code lost:
        r5 = com.mobile.brasiltv.utils.b0.W(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0065, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0087, code lost:
        r4 = a3.e.a(r4, "key_poster");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        if (r4 == null) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008d, code lost:
        r4 = com.mobile.brasiltv.utils.b0.W(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0092, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x005a, code lost:
        r5 = a3.e.a(r5, "key_poster");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List r3(java.util.List r11, com.mobile.brasiltv.activity.ColumnListAty r12) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "key_poster"
            java.lang.String r2 = "$t"
            t9.i.g(r11, r2)
            java.lang.String r2 = "this$0"
            t9.i.g(r12, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r11 = r11.iterator()
        L_0x0017:
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto L_0x00f9
            java.lang.Object r3 = r11.next()
            mobile.com.requestframe.utils.response.ChildColumnList r3 = (mobile.com.requestframe.utils.response.ChildColumnList) r3
            a7.d r4 = a7.d.f10697a
            java.util.List r5 = r3.getPosterList()
            java.lang.String r6 = r4.g()
            java.lang.String r5 = r4.n(r5, r6)
            java.util.List r6 = r3.getPosterList()
            java.lang.String r7 = r4.h()
            java.lang.String r4 = r4.n(r6, r7)
            android.view.LayoutInflater r6 = r12.getLayoutInflater()
            r7 = 2131558652(0x7f0d00fc, float:1.8742626E38)
            r8 = 0
            android.view.View r6 = r6.inflate(r7, r8)
            com.bumptech.glide.RequestManager r7 = com.bumptech.glide.Glide.with((androidx.fragment.app.e) r12)     // Catch:{ Exception -> 0x0075 }
            boolean r9 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0075 }
            if (r9 == 0) goto L_0x005a
            if (r5 != 0) goto L_0x0066
            java.lang.String r5 = a3.e.a(r0, r1)     // Catch:{ Exception -> 0x0075 }
            goto L_0x0066
        L_0x005a:
            java.lang.String r5 = a3.e.a(r5, r1)     // Catch:{ Exception -> 0x0075 }
            if (r5 == 0) goto L_0x0065
            com.bumptech.glide.load.model.GlideUrl r5 = com.mobile.brasiltv.utils.b0.W(r5)     // Catch:{ Exception -> 0x0075 }
            goto L_0x0066
        L_0x0065:
            r5 = r8
        L_0x0066:
            com.bumptech.glide.RequestBuilder r5 = r7.load((java.lang.Object) r5)     // Catch:{ Exception -> 0x0075 }
            com.bumptech.glide.request.FutureTarget r5 = r5.submit()     // Catch:{ Exception -> 0x0075 }
            java.lang.Object r5 = r5.get()     // Catch:{ Exception -> 0x0075 }
            android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5     // Catch:{ Exception -> 0x0075 }
            goto L_0x0076
        L_0x0075:
            r5 = r8
        L_0x0076:
            com.bumptech.glide.RequestManager r7 = com.bumptech.glide.Glide.with((androidx.fragment.app.e) r12)     // Catch:{ Exception -> 0x00a2 }
            boolean r9 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00a2 }
            if (r9 == 0) goto L_0x0087
            if (r4 != 0) goto L_0x0093
            java.lang.String r4 = a3.e.a(r0, r1)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x0093
        L_0x0087:
            java.lang.String r4 = a3.e.a(r4, r1)     // Catch:{ Exception -> 0x00a2 }
            if (r4 == 0) goto L_0x0092
            com.bumptech.glide.load.model.GlideUrl r4 = com.mobile.brasiltv.utils.b0.W(r4)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x0093
        L_0x0092:
            r4 = r8
        L_0x0093:
            com.bumptech.glide.RequestBuilder r4 = r7.load((java.lang.Object) r4)     // Catch:{ Exception -> 0x00a2 }
            com.bumptech.glide.request.FutureTarget r4 = r4.submit()     // Catch:{ Exception -> 0x00a2 }
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x00a2 }
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00a4
        L_0x00a2:
            r4 = r8
        L_0x00a4:
            java.lang.String r7 = "inflate"
            if (r5 == 0) goto L_0x00e0
            if (r4 == 0) goto L_0x00e0
            int r3 = r5.getIntrinsicWidth()
            int r8 = r5.getIntrinsicHeight()
            r9 = 16908294(0x1020006, float:2.3877246E-38)
            android.view.View r9 = r6.findViewById(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            float r3 = (float) r3
            r10 = 40
            int r10 = com.zhy.autolayout.utils.AutoUtils.getPercentHeightSize(r10)
            float r10 = (float) r10
            float r8 = (float) r8
            float r10 = r10 / r8
            float r3 = r3 * r10
            int r3 = (int) r3
            r9.width = r3
            com.mobile.brasiltv.view.FixGifStateDrawable r3 = new com.mobile.brasiltv.view.FixGifStateDrawable
            r3.<init>(r4, r5)
            com.mobile.brasiltv.activity.ColumnListAty$b r4 = new com.mobile.brasiltv.activity.ColumnListAty$b
            t9.i.f(r6, r7)
            r4.<init>(r0, r6, r3)
            r2.add(r4)
            goto L_0x0017
        L_0x00e0:
            com.mobile.brasiltv.activity.ColumnListAty$b r4 = new com.mobile.brasiltv.activity.ColumnListAty$b
            java.lang.String r5 = r3.getAlias()
            java.lang.String r3 = r3.getName()
            java.lang.String r3 = com.mobile.brasiltv.utils.b0.c(r5, r3)
            t9.i.f(r6, r7)
            r4.<init>(r3, r6, r8)
            r2.add(r4)
            goto L_0x0017
        L_0x00f9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.activity.ColumnListAty.r3(java.util.List, com.mobile.brasiltv.activity.ColumnListAty):java.util.List");
    }

    public static final void s3(s9.l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void R2() {
        p3(new w(this, this));
        ViewGroup.LayoutParams layoutParams = ((AutoRelativeLayout) Z2(R$id.rl_column_list_title)).getLayoutParams();
        i.e(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        boolean z10 = false;
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, f3(), 0, 0);
        this.f11988l = getIntent().getIntExtra(f11984v, -1);
        this.f11989m = getIntent().getBooleanExtra(f11987y, false);
        f11985w = i.b(g3().getRestricted(), "1");
        if (g3().getId() == RootColumnId.freeVodId) {
            z10 = true;
        }
        f11986x = z10;
        ((TextView) Z2(R$id.tv_title)).setText(b0.e(g3().getAlias(), g3().getName()));
        i3();
        l3();
        m3();
    }

    public int T2() {
        return R.layout.activity_column_list;
    }

    public View Z2(int i10) {
        Map map = this.f11995s;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public void a() {
        ((KoocanEmptyView) Z2(R$id.column_loadingView)).setVisibility(0);
    }

    public void c(String str) {
        i.g(str, "errorCode");
        j1.h(this, str);
        int i10 = R$id.column_loadingView;
        ((KoocanEmptyView) Z2(i10)).setReloadListener(new g(this));
        ((KoocanEmptyView) Z2(i10)).setVisibility(0);
        ((KoocanEmptyView) Z2(i10)).changeType(KoocanEmptyView.Type.NO_WIFI);
    }

    public void f(List list) {
        i.g(list, "t");
        int i10 = 0;
        for (Object next : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                i9.j.j();
            }
            ChildColumnList childColumnList = (ChildColumnList) next;
            int i12 = R$id.columnListTabLayout;
            ((TabLayout) Z2(i12)).addTab(((TabLayout) Z2(i12)).newTab().setText((CharSequence) b0.c(childColumnList.getAlias(), childColumnList.getName())));
            this.f11994r.add(b0.c(childColumnList.getAlias(), childColumnList.getName()));
            o oVar = new o();
            int id = childColumnList.getId();
            StringBuilder sb = new StringBuilder();
            String alias = g3().getAlias();
            String str = "";
            if (alias == null) {
                alias = str;
            }
            sb.append(alias);
            sb.append('/');
            String alias2 = childColumnList.getAlias();
            if (alias2 != null) {
                str = alias2;
            }
            sb.append(str);
            o3(oVar, id, i10, sb.toString());
            this.f11993q.add(oVar);
            i10 = i11;
        }
        int i13 = R$id.columnListViewPager;
        ArrayList arrayList = this.f11993q;
        ArrayList arrayList2 = this.f11994r;
        androidx.fragment.app.o supportFragmentManager = getSupportFragmentManager();
        i.f(supportFragmentManager, "supportFragmentManager");
        ((ViewPager) Z2(i13)).setAdapter(new x(arrayList, arrayList2, supportFragmentManager));
        int i14 = R$id.columnListTabLayout;
        ((TabLayout) Z2(i14)).setupWithViewPager((ViewPager) Z2(i13));
        q3(list);
        if (this.f11988l != -1) {
            TabLayout.Tab tabAt = ((TabLayout) Z2(i14)).getTabAt(this.f11988l);
            i.d(tabAt);
            tabAt.isSelected();
            ((ViewPager) Z2(i13)).setCurrentItem(this.f11988l);
        }
    }

    public final int f3() {
        return ((Number) this.f11992p.getValue()).intValue();
    }

    public ChildColumnList g3() {
        return (ChildColumnList) this.f11990n.getValue();
    }

    /* renamed from: h3 */
    public w S2() {
        w wVar = this.f11991o;
        if (wVar != null) {
            return wVar;
        }
        i.w("mPresenter");
        return null;
    }

    public final void i3() {
        ((ImageView) Z2(R$id.iv_back)).setOnClickListener(this);
        ((AutoRelativeLayout) Z2(R$id.rl_column_list_title)).setOnClickListener(new c0(this));
        ((ImageView) Z2(R$id.mVodImageSearch)).setOnClickListener(new d0(this));
        ((TabLayout) Z2(R$id.columnListTabLayout)).addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new e());
        ((ViewPager) Z2(R$id.columnListViewPager)).addOnPageChangeListener(new f());
    }

    public void k() {
        ((KoocanEmptyView) Z2(R$id.column_loadingView)).setVisibility(8);
    }

    public void k2() {
        n2();
    }

    public final void l3() {
        S2().l(g3());
    }

    public final void m3() {
        if (!d6.b.f6366a.y() || !f11986x) {
            ((MarqueeTextView) Z2(R$id.mTvBindTip)).setVisibility(8);
            return;
        }
        int i10 = R$id.mTvBindTip;
        ((MarqueeTextView) Z2(i10)).setVisibility(0);
        ((MarqueeTextView) Z2(i10)).setOnClickListener(new f5.b0(this));
    }

    public final void o3(Fragment fragment, int i10, int i11, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("columnId", i10);
        bundle.putInt("COLUMN_INDEX", i11);
        bundle.putBoolean("COLUMN_FREE", f11986x);
        bundle.putString("tdc_from", str);
        bundle.putBoolean("iscr", this.f11989m);
        fragment.setArguments(bundle);
    }

    public void onClick(View view) {
        i.g(view, "view");
        if (i.b(view, (ImageView) Z2(R$id.iv_back))) {
            finish();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void p3(w wVar) {
        i.g(wVar, "<set-?>");
        this.f11991o = wVar;
    }

    public final void q3(List list) {
        Observable.fromCallable(new e0(list, this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f0(new h(list, this)));
    }
}
