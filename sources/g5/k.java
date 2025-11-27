package g5;

import a6.d;
import a7.e;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import cn.bingoogolapple.bgabanner.BGABanner;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.view.BottomDecoration;
import com.mobile.brasiltv.view.adView.AdaptiveAdContainer;
import com.mobile.brasiltv.view.adView.IAdView;
import com.mobile.brasiltv.view.adView.SmallAdNativeContainer;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import h9.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.PosterList;
import mobile.com.requestframe.utils.response.Recommend;
import mobile.com.requestframe.utils.response.RecommendContentList;
import s9.l;
import t9.g;
import t9.i;
import t9.j;
import t9.w;

public final class k extends j5.b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f16949a;

    /* renamed from: b  reason: collision with root package name */
    public ChildColumnList f16950b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f16951c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f16952d = true;

    /* renamed from: e  reason: collision with root package name */
    public final List f16953e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public BGABanner f16954f;

    /* renamed from: g  reason: collision with root package name */
    public c f16955g;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f16956a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f16957b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(k kVar, View view) {
            super(1);
            this.f16956a = kVar;
            this.f16957b = view;
        }

        public final void b(PosterList posterList) {
            e eVar = e.f10706a;
            Context h10 = this.f16956a.f16949a;
            String fileUrl = posterList.getFileUrl();
            View view = this.f16957b;
            i.e(view, "null cannot be cast to non-null type android.widget.ImageView");
            eVar.b(h10, fileUrl, (ImageView) view, R.drawable.column_image_placeholder);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((PosterList) obj);
            return t.f17319a;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f16958a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(1);
            this.f16958a = view;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            View view = this.f16958a;
            i.e(view, "null cannot be cast to non-null type android.widget.ImageView");
            ((ImageView) view).setImageResource(R.drawable.column_image_placeholder);
        }
    }

    public static final class c extends ViewPager.n {

        /* renamed from: a  reason: collision with root package name */
        public String f16959a = "";

        /* renamed from: b  reason: collision with root package name */
        public List f16960b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f16961c;

        public c(k kVar) {
            this.f16961c = kVar;
        }

        public final void a(List list) {
            this.f16960b = list;
        }

        public final void b(String str) {
            i.g(str, "<set-?>");
            this.f16959a = str;
        }

        public void onPageSelected(int i10) {
            int i11;
            List list = this.f16960b;
            if (list != null) {
                k kVar = this.f16961c;
                int i12 = 0;
                if (list != null) {
                    i11 = list.size();
                } else {
                    i11 = 0;
                }
                if (i11 > 0 && kVar.w() && kVar.x()) {
                    List list2 = this.f16960b;
                    if (list2 != null) {
                        i12 = list2.size();
                    }
                    int i13 = i10 % i12;
                    if (i13 >= 0 && i13 < list.size() && i.b("4", ((RecommendContentList) list.get(i13)).getType())) {
                        i1.D(kVar.f16949a, "EVENT_RECOMMEND_AD_SHOW_CR", i13 + 1);
                    }
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(Context context, ChildColumnList childColumnList) {
        super(i9.j.d());
        i.g(context, f.X);
        i.g(childColumnList, "parentColumn");
        this.f16949a = context;
        this.f16950b = childColumnList;
        d dVar = d.f10667a;
        addItemType(dVar.a(), R.layout.item_recommend_banner);
        addItemType(dVar.b(), R.layout.adapter_recommend_item);
        addItemType(dVar.c(), R.layout.adapter_recommend_item);
        addItemType(dVar.h(), R.layout.item_native_ad);
        addItemType(dVar.k(), R.layout.item_smart_ad);
        this.f16955g = new c(this);
    }

    public static final void k(BGABanner bGABanner, View view, Object obj, int i10) {
        i.e(view, "null cannot be cast to non-null type android.widget.ImageView");
        ((ImageView) view).setImageResource(R.drawable.column_image_placeholder);
    }

    public static final void l(k kVar, BGABanner bGABanner, View view, Object obj, int i10) {
        i.g(kVar, "this$0");
        a7.d dVar = a7.d.f10697a;
        i.e(obj, "null cannot be cast to non-null type mobile.com.requestframe.utils.response.RecommendContentList");
        dVar.c(((RecommendContentList) obj).getPosterList(), dVar.f()).subscribe(new i(new a(kVar, view)), new j(new b(view)));
    }

    public static final void m(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void n(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void o(w wVar, k kVar, l lVar, w wVar2, BGABanner bGABanner, View view, Object obj, int i10) {
        String str;
        boolean z10;
        w wVar3 = wVar;
        k kVar2 = kVar;
        w wVar4 = wVar2;
        int i11 = i10;
        i.g(wVar3, "$recommendData");
        i.g(kVar2, "this$0");
        i.g(lVar, "$crFragBannerItem");
        i.g(wVar4, "$recommendCode");
        if (b0.I((Collection) wVar3.f19600a)) {
            RecommendContentList recommendContentList = (RecommendContentList) ((List) wVar3.f19600a).get(i11);
            if (i.b("4", recommendContentList.getType())) {
                String url = recommendContentList.getUrl();
                if (url == null || url.length() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    i1.D(kVar2.f16949a, "EVENT_RECOMMEND_AD_CLICK_CR", i11 + 1);
                    b0.j0(kVar2.f16949a, recommendContentList.getUrl(), false, true, false, false, 24, (Object) null);
                    return;
                }
                return;
            }
            a7.d dVar = a7.d.f10697a;
            String n10 = dVar.n(recommendContentList.getPosterList(), dVar.f());
            String str2 = "";
            if (n10 == null) {
                str = str2;
            } else {
                str = n10;
            }
            Context context = kVar2.f16949a;
            i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
            f5.c cVar = (f5.c) context;
            String type = recommendContentList.getType();
            String programType = recommendContentList.getProgramType();
            String contentId = recommendContentList.getContentId();
            EnterType enterType = EnterType.BANNER;
            String name = recommendContentList.getName();
            int b10 = lVar.b();
            StringBuilder sb = new StringBuilder();
            String alias = kVar2.f16950b.getAlias();
            if (alias == null) {
                alias = str2;
            }
            sb.append(alias);
            sb.append('/');
            String str3 = (String) wVar4.f19600a;
            if (str3 != null) {
                str2 = str3;
            }
            sb.append(str2);
            b0.r(cVar, type, programType, contentId, enterType, name, true, false, b10, sb.toString(), str);
        }
    }

    public static final void q(k kVar, View view) {
        i.g(kVar, "this$0");
        Context context = kVar.f16949a;
        i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.k((f5.c) context, kVar.f16950b, 0, true);
    }

    public static final void t(k kVar, n nVar, View view) {
        i.g(kVar, "this$0");
        i.g(nVar, "$crFragNormalItem");
        Context context = kVar.f16949a;
        i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.k((f5.c) context, kVar.f16950b, nVar.b(), true);
    }

    public final void A(boolean z10) {
        this.f16952d = z10;
        y(true);
    }

    public final void i(boolean z10) {
        int i10;
        BGABanner bGABanner = this.f16954f;
        if (bGABanner != null) {
            i10 = bGABanner.getItemCount();
        } else {
            i10 = 0;
        }
        if (i10 <= 1) {
            return;
        }
        if (z10) {
            BGABanner bGABanner2 = this.f16954f;
            if (bGABanner2 != null) {
                bGABanner2.startAutoPlay();
                return;
            }
            return;
        }
        BGABanner bGABanner3 = this.f16954f;
        if (bGABanner3 != null) {
            bGABanner3.stopAutoPlay();
        }
    }

    public final void j(BaseViewHolder baseViewHolder, l lVar) {
        this.f16954f = (BGABanner) baseViewHolder.getView(R.id.mRecommendBanner);
        baseViewHolder.setVisible(R.id.tvCrTips, true);
        boolean z10 = false;
        if (lVar.c().isEmpty()) {
            BGABanner bGABanner = this.f16954f;
            i.d(bGABanner);
            bGABanner.setAutoPlayAble(false);
            BGABanner bGABanner2 = this.f16954f;
            i.d(bGABanner2);
            bGABanner2.setAdapter(new e());
            BGABanner bGABanner3 = this.f16954f;
            i.d(bGABanner3);
            bGABanner3.setData(i9.i.b(Integer.valueOf(R.drawable.column_image_placeholder)), (List<String>) null);
            return;
        }
        w wVar = new w();
        wVar.f19600a = ((Recommend) lVar.c().get(0)).getContentList();
        w wVar2 = new w();
        wVar2.f19600a = ((Recommend) lVar.c().get(0)).getRecommendCode();
        BGABanner bGABanner4 = this.f16954f;
        i.d(bGABanner4);
        if (((List) wVar.f19600a).size() > 1) {
            z10 = true;
        }
        bGABanner4.setAutoPlayAble(z10);
        BGABanner bGABanner5 = this.f16954f;
        i.d(bGABanner5);
        bGABanner5.setAdapter(new f(this));
        BGABanner bGABanner6 = this.f16954f;
        i.d(bGABanner6);
        bGABanner6.setData((List) wVar.f19600a, (List<String>) null);
        BGABanner bGABanner7 = this.f16954f;
        i.d(bGABanner7);
        bGABanner7.setDelegate(new g(wVar, this, lVar, wVar2));
        BGABanner bGABanner8 = this.f16954f;
        i.d(bGABanner8);
        bGABanner8.getViewPager().removeOnPageChangeListener(this.f16955g);
        c cVar = this.f16955g;
        String a10 = lVar.a();
        if (a10 == null) {
            a10 = "";
        }
        cVar.b(a10);
        this.f16955g.a((List) wVar.f19600a);
        BGABanner bGABanner9 = this.f16954f;
        i.d(bGABanner9);
        bGABanner9.getViewPager().addOnPageChangeListener(this.f16955g);
        BGABanner bGABanner10 = this.f16954f;
        i.d(bGABanner10);
        int currentItem = bGABanner10.getViewPager().getCurrentItem() % ((List) wVar.f19600a).size();
        if (currentItem >= 0 && currentItem < ((List) wVar.f19600a).size() && i.b("4", ((RecommendContentList) ((List) wVar.f19600a).get(currentItem)).getType())) {
            i1.D(this.f16949a, "EVENT_RECOMMEND_AD_SHOW_CR", currentItem + 1);
        }
    }

    public final void p(BaseViewHolder baseViewHolder, m mVar) {
        ((TextView) baseViewHolder.getView(R.id.mColumnNameTv)).setText(this.f16949a.getResources().getString(R.string.cr_featured_categories));
        ((ImageView) baseViewHolder.getView(R.id.mMoreIv)).setOnClickListener(new h(this));
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.mRecommendColumnRV);
        recyclerView.setLayoutManager(new GridLayoutManager(this.f16949a, 3));
        recyclerView.addItemDecoration(new BottomDecoration(AutoUtils.getPercentHeightSize(9)));
        if (b0.I(mVar.a())) {
            r rVar = new r(this.f16949a, this.f16950b);
            recyclerView.setAdapter(rVar);
            rVar.setNewData(mVar.a());
        }
    }

    public final void r(BaseViewHolder baseViewHolder, e1 e1Var) {
        SmallAdNativeContainer smallAdNativeContainer = (SmallAdNativeContainer) baseViewHolder.getView(R.id.mSanvNativeContainer);
        if (e1Var.a().isShowAllAd()) {
            smallAdNativeContainer.setKeep(true);
            smallAdNativeContainer.loadAd(e1Var, true);
        } else if (e1Var.a().isShowOwnAd()) {
            smallAdNativeContainer.setKeep(true);
            smallAdNativeContainer.loadOwn(e1Var, true);
        } else {
            smallAdNativeContainer.hideView(true);
            return;
        }
        if (!this.f16953e.contains(smallAdNativeContainer)) {
            List list = this.f16953e;
            i.f(smallAdNativeContainer, "adView");
            list.add(smallAdNativeContainer);
        }
    }

    public final void s(BaseViewHolder baseViewHolder, n nVar) {
        boolean z10;
        int i10;
        String alias;
        TextView textView = (TextView) baseViewHolder.getView(R.id.mColumnNameTv);
        ChildColumnList a10 = nVar.a();
        if (a10 != null) {
            if (f0.b() || TextUtils.isEmpty(a10.getAlias())) {
                textView.setText(a10.getName());
            } else {
                textView.setText(a10.getAlias());
            }
        }
        ((ImageView) baseViewHolder.getView(R.id.mMoreIv)).setOnClickListener(new d(this, nVar));
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.mRecommendColumnRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f16949a, 0, false));
        List c10 = nVar.c();
        if (c10 == null || c10.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        String str = "";
        if (z10) {
            ArrayList arrayList = new ArrayList(10);
            for (int i11 = 0; i11 < 10; i11++) {
                arrayList.add(str);
            }
            z1 z1Var = new z1(false, 1, (g) null);
            recyclerView.setAdapter(z1Var);
            z1Var.setNewData(arrayList);
            return;
        }
        Context context = this.f16949a;
        ChildColumnList a11 = nVar.a();
        if (a11 != null) {
            i10 = a11.getId();
        } else {
            i10 = -1;
        }
        StringBuilder sb = new StringBuilder();
        String alias2 = this.f16950b.getAlias();
        if (alias2 == null) {
            alias2 = str;
        }
        sb.append(alias2);
        sb.append('/');
        ChildColumnList a12 = nVar.a();
        if (!(a12 == null || (alias = a12.getAlias()) == null)) {
            str = alias;
        }
        sb.append(str);
        y1 y1Var = new y1(context, i10, false, true, true, sb.toString());
        recyclerView.setAdapter(y1Var);
        y1Var.setNewData(nVar.c());
    }

    public final void u(BaseViewHolder baseViewHolder, f3 f3Var) {
        AdaptiveAdContainer adaptiveAdContainer = (AdaptiveAdContainer) baseViewHolder.getView(R.id.mAavSmartContainer);
        if (!a6.a.f10646a.s()) {
            adaptiveAdContainer.hideView(true);
            return;
        }
        if (!this.f16953e.contains(adaptiveAdContainer)) {
            List list = this.f16953e;
            i.f(adaptiveAdContainer, "adView");
            list.add(adaptiveAdContainer);
        }
        adaptiveAdContainer.loadAd(f3Var, true);
    }

    /* renamed from: v */
    public void convert(BaseViewHolder baseViewHolder, MultiItemEntity multiItemEntity) {
        i.g(baseViewHolder, "helper");
        i.g(multiItemEntity, PlistBuilder.KEY_ITEM);
        int itemType = multiItemEntity.getItemType();
        d dVar = d.f10667a;
        if (itemType == dVar.a()) {
            j(baseViewHolder, (l) multiItemEntity);
        } else if (itemType == dVar.b()) {
            p(baseViewHolder, (m) multiItemEntity);
        } else if (itemType == dVar.c()) {
            s(baseViewHolder, (n) multiItemEntity);
        } else if (itemType == dVar.h()) {
            r(baseViewHolder, (e1) multiItemEntity);
        } else if (itemType == dVar.k()) {
            u(baseViewHolder, (f3) multiItemEntity);
        }
    }

    public final boolean w() {
        return this.f16951c;
    }

    public final boolean x() {
        return this.f16952d;
    }

    public final void y(boolean z10) {
        boolean z11;
        for (IAdView iAdView : this.f16953e) {
            if (!this.f16951c || !this.f16952d) {
                z11 = false;
            } else {
                z11 = true;
            }
            iAdView.hostVisibilityChange(z11, z10);
        }
    }

    public final void z(boolean z10) {
        this.f16951c = z10;
        y(!z10);
    }
}
