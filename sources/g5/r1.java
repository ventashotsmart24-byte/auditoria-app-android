package g5;

import a7.e;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import cn.bingoogolapple.bgabanner.BGABanner;
import com.advertlib.bean.AdInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.activity.SpecialAty;
import com.mobile.brasiltv.activity.TopTenActivity;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.view.adView.AdaptiveAdContainer;
import com.mobile.brasiltv.view.adView.IAdView;
import com.mobile.brasiltv.view.adView.ReportImageView;
import com.mobile.brasiltv.view.adView.SmallAdNativeContainer;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.f;
import h9.t;
import i9.r;
import java.util.ArrayList;
import java.util.List;
import mobile.com.requestframe.utils.response.Channel;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.HomeAsset;
import mobile.com.requestframe.utils.response.HomeRecommend;
import mobile.com.requestframe.utils.response.PosterList;
import mobile.com.requestframe.utils.response.Recommend;
import mobile.com.requestframe.utils.response.RecommendContentList;
import mobile.com.requestframe.utils.response.ShelveAsset;
import mobile.com.requestframe.utils.response.ShelvePoster;
import s1.m;
import s1.q;
import s9.l;
import t9.g;
import t9.i;
import t9.j;
import w6.i;

public final class r1 extends j5.b {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f17073a;

    /* renamed from: b  reason: collision with root package name */
    public ChildColumnList f17074b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17075c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f17076d = true;

    /* renamed from: e  reason: collision with root package name */
    public final List f17077e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public BGABanner f17078f;

    /* renamed from: g  reason: collision with root package name */
    public d f17079g;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f17080a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f17081b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(r1 r1Var, ImageView imageView) {
            super(1);
            this.f17080a = r1Var;
            this.f17081b = imageView;
        }

        public final void b(PosterList posterList) {
            e eVar = e.f10706a;
            Activity K = this.f17080a.K();
            String fileUrl = posterList.getFileUrl();
            ImageView imageView = this.f17081b;
            i.f(imageView, "ivBanner");
            eVar.b(K, fileUrl, imageView, R.drawable.column_image_placeholder);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((PosterList) obj);
            return t.f17319a;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f17082a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ImageView imageView) {
            super(1);
            this.f17082a = imageView;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            this.f17082a.setImageResource(R.drawable.column_image_placeholder);
        }
    }

    public static final class c implements v1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f17083a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f17084b;

        public c(r1 r1Var, List list) {
            this.f17083a = r1Var;
            this.f17084b = list;
        }

        public void a(String str) {
            boolean z10;
            i.g(str, "mediaType");
            m mVar = m.f9270a;
            Activity K = this.f17083a.K();
            a6.a aVar = a6.a.f10646a;
            String h10 = aVar.h();
            i.c cVar = w6.i.f9510g;
            List A = mVar.A(K, h10, cVar.I(), true, cVar.r());
            boolean z11 = true;
            if (A == null || A.isEmpty()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(r.G(A));
                arrayList.addAll(this.f17084b);
                BGABanner l10 = this.f17083a.f17078f;
                t9.i.d(l10);
                if (arrayList.size() <= 1) {
                    z11 = false;
                }
                l10.setAutoPlayAble(z11);
                BGABanner l11 = this.f17083a.f17078f;
                t9.i.d(l11);
                l11.setData((int) R.layout.item_bga_banner_recommend, (List<? extends Object>) arrayList, (List<String>) null);
                this.f17083a.f17079g.b(arrayList);
                this.f17083a.f17079g.a(aVar.h());
                BGABanner l12 = this.f17083a.f17078f;
                t9.i.d(l12);
                l12.getViewPager().addOnPageChangeListener(this.f17083a.f17079g);
                mVar.d0(this.f17083a.K(), aVar.h(), ((AdInfo) A.get(0)).getAd_id());
            }
        }
    }

    public static final class d extends ViewPager.n {

        /* renamed from: a  reason: collision with root package name */
        public String f17085a = "";

        /* renamed from: b  reason: collision with root package name */
        public List f17086b;

        /* renamed from: c  reason: collision with root package name */
        public String f17087c = "";

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ r1 f17088d;

        public d(r1 r1Var) {
            this.f17088d = r1Var;
        }

        public final void a(String str) {
            t9.i.g(str, "<set-?>");
            this.f17087c = str;
        }

        public final void b(List list) {
            this.f17086b = list;
        }

        public final void c(String str) {
            t9.i.g(str, "<set-?>");
            this.f17085a = str;
        }

        public void onPageSelected(int i10) {
            int i11;
            List list = this.f17086b;
            if (list != null) {
                r1 r1Var = this.f17088d;
                int i12 = 0;
                if (list != null) {
                    i11 = list.size();
                } else {
                    i11 = 0;
                }
                if (i11 > 0 && r1Var.L() && r1Var.M()) {
                    List list2 = this.f17086b;
                    if (list2 != null) {
                        i12 = list2.size();
                    }
                    int i13 = i10 % i12;
                    if (i13 >= 0 && i13 < list.size()) {
                        Object obj = list.get(i13);
                        if ((obj instanceof RecommendContentList) && t9.i.b("4", ((RecommendContentList) obj).getType())) {
                            r1Var.P(this.f17085a, i13);
                        }
                        if (obj instanceof AdInfo) {
                            m.f9270a.d0(r1Var.K(), this.f17087c, ((AdInfo) obj).getAd_id());
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r1(Activity activity, ChildColumnList childColumnList) {
        super(i9.j.d());
        t9.i.g(activity, f.X);
        t9.i.g(childColumnList, "parentColumn");
        this.f17073a = activity;
        this.f17074b = childColumnList;
        a6.d dVar = a6.d.f10667a;
        addItemType(dVar.i(), R.layout.adapter_recommend_item);
        addItemType(dVar.h(), R.layout.item_native_ad);
        addItemType(dVar.k(), R.layout.item_smart_ad);
        addItemType(dVar.e(), R.layout.item_recommend_banner);
        addItemType(dVar.g(), R.layout.item_home_first_banner);
        addItemType(dVar.f(), R.layout.item_free_entrance);
        addItemType(dVar.l(), R.layout.adapter_recommend_item);
        addItemType(dVar.j(), R.layout.adapter_home_special_new_item);
        addItemType(dVar.d(), R.layout.adapter_home_top_new);
        this.f17079g = new d(this);
    }

    public static final void C(p2 p2Var, r1 r1Var, View view) {
        String str;
        String str2;
        int i10;
        String alias;
        String name;
        t9.i.g(p2Var, "$recommendSpecialItem");
        t9.i.g(r1Var, "this$0");
        ChildColumnList a10 = p2Var.a();
        if (a10 == null || (name = a10.getName()) == null) {
            str = "";
        } else {
            str = name;
        }
        ChildColumnList a11 = p2Var.a();
        if (a11 == null || (alias = a11.getAlias()) == null) {
            str2 = "";
        } else {
            str2 = alias;
        }
        ChildColumnList a12 = p2Var.a();
        if (a12 != null) {
            i10 = a12.getId();
        } else {
            i10 = 0;
        }
        HomeRecommend homeRecommend = new HomeRecommend(str, str2, Integer.valueOf(i10), "", "", "", "", (List<HomeAsset>) null, (List<? extends PosterList>) null, (List<Channel>) null, (List<HomeRecommend>) null);
        Activity activity = r1Var.f17073a;
        t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.u((f5.c) activity, homeRecommend);
    }

    public static final void D(r1 r1Var, p2 p2Var, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        ShelveAsset shelveAsset;
        List<ShelvePoster> list;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i11;
        String alias;
        r1 r1Var2 = r1Var;
        t9.i.g(r1Var2, "this$0");
        t9.i.g(p2Var, "$recommendSpecialItem");
        Object obj = baseQuickAdapter.getData().get(i10);
        String str6 = null;
        if (obj instanceof ShelveAsset) {
            shelveAsset = (ShelveAsset) obj;
        } else {
            shelveAsset = null;
        }
        a7.d dVar = a7.d.f10697a;
        if (shelveAsset != null) {
            list = shelveAsset.getPosterList();
        } else {
            list = null;
        }
        String o10 = dVar.o(list, dVar.g());
        String str7 = "";
        if (o10 == null) {
            str = str7;
        } else {
            str = o10;
        }
        Activity activity = r1Var2.f17073a;
        t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        f5.c cVar = (f5.c) activity;
        if (shelveAsset != null) {
            str2 = shelveAsset.getType();
        } else {
            str2 = null;
        }
        if (shelveAsset != null) {
            str3 = shelveAsset.getProgramType();
        } else {
            str3 = null;
        }
        if (shelveAsset != null) {
            str4 = shelveAsset.getContentId();
        } else {
            str4 = null;
        }
        EnterType enterType = EnterType.HOME;
        if (shelveAsset != null && (alias = shelveAsset.getAlias()) != null) {
            str5 = alias;
        } else if (shelveAsset != null) {
            str5 = shelveAsset.getName();
        } else {
            str5 = null;
        }
        ChildColumnList a10 = p2Var.a();
        if (a10 != null) {
            i11 = a10.getId();
        } else {
            i11 = 0;
        }
        StringBuilder sb = new StringBuilder();
        String alias2 = r1Var2.f17074b.getAlias();
        if (alias2 != null) {
            str7 = alias2;
        }
        sb.append(str7);
        sb.append('/');
        ChildColumnList a11 = p2Var.a();
        if (a11 != null) {
            str6 = a11.getAlias();
        }
        sb.append(str6);
        b0.r(cVar, str2, str3, str4, enterType, str5, false, false, i11, sb.toString(), str);
    }

    public static final void G(r1 r1Var, View view) {
        t9.i.g(r1Var, "this$0");
        if (RootColumnId.specialColumn != null) {
            Activity activity = r1Var.f17073a;
            t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
            b0.c0((f5.c) activity, SpecialAty.class);
        }
    }

    public static final void I(r1 r1Var, o2 o2Var, View view) {
        String str;
        String str2;
        t9.i.g(r1Var, "this$0");
        t9.i.g(o2Var, "$homeFragTopItem");
        Intent intent = new Intent(r1Var.f17073a, TopTenActivity.class);
        Bundle bundle = new Bundle();
        TopTenActivity.a aVar = TopTenActivity.f12233v;
        String c10 = aVar.c();
        ChildColumnList a10 = o2Var.a();
        Integer num = null;
        if (a10 != null) {
            str = a10.getName();
        } else {
            str = null;
        }
        bundle.putSerializable(c10, str);
        String a11 = aVar.a();
        ChildColumnList a12 = o2Var.a();
        if (a12 != null) {
            str2 = a12.getAlias();
        } else {
            str2 = null;
        }
        bundle.putSerializable(a11, str2);
        String b10 = aVar.b();
        ChildColumnList a13 = o2Var.a();
        if (a13 != null) {
            num = Integer.valueOf(a13.getId());
        }
        bundle.putSerializable(b10, num);
        intent.putExtras(bundle);
        r1Var.f17073a.startActivity(intent);
    }

    public static final void q(BGABanner bGABanner, View view, Object obj, int i10) {
        t9.i.e(view, "null cannot be cast to non-null type android.widget.ImageView");
        ((ImageView) view).setImageResource(R.drawable.column_image_placeholder);
    }

    public static final void r(r1 r1Var, BGABanner bGABanner, View view, Object obj, int i10) {
        r1 r1Var2 = r1Var;
        View view2 = view;
        Object obj2 = obj;
        t9.i.g(r1Var2, "this$0");
        ImageView imageView = (ImageView) view2.findViewById(R.id.mIvBanner);
        TextView textView = (TextView) view2.findViewById(R.id.mTvAdFlag);
        if (obj2 instanceof RecommendContentList) {
            a7.d dVar = a7.d.f10697a;
            dVar.c(((RecommendContentList) obj2).getPosterList(), dVar.f()).subscribe(new q1(new a(r1Var2, imageView)), new h1(new b(imageView)));
            textView.setVisibility(8);
        } else if (obj2 instanceof AdInfo) {
            m mVar = m.f9270a;
            Activity activity = r1Var2.f17073a;
            t9.i.f(imageView, "ivBanner");
            AdInfo adInfo = (AdInfo) obj2;
            m.h0(mVar, activity, imageView, adInfo.getMedia_type(), adInfo, Integer.valueOf(R.drawable.column_image_placeholder), (l) null, (Integer) null, false, 0, 480, (Object) null);
            if (adInfo.isShowFlag()) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        } else {
            imageView.setImageResource(R.drawable.column_image_placeholder);
            textView.setVisibility(8);
        }
    }

    public static final void s(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void t(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void u(r1 r1Var, s1 s1Var, String str, BGABanner bGABanner, View view, Object obj, int i10) {
        String str2;
        String str3;
        r1 r1Var2 = r1Var;
        Object obj2 = obj;
        t9.i.g(r1Var2, "this$0");
        t9.i.g(s1Var, "$recommendFragBannerItem");
        boolean z10 = false;
        if (obj2 instanceof RecommendContentList) {
            RecommendContentList recommendContentList = (RecommendContentList) obj2;
            if (t9.i.b("4", recommendContentList.getType())) {
                String url = recommendContentList.getUrl();
                if (url == null || url.length() == 0) {
                    z10 = true;
                }
                if (!z10) {
                    r1Var2.O(s1Var.a(), i10);
                    b0.j0(r1Var2.f17073a, recommendContentList.getUrl(), false, true, false, false, 24, (Object) null);
                    return;
                }
                return;
            }
            a7.d dVar = a7.d.f10697a;
            String n10 = dVar.n(recommendContentList.getPosterList(), dVar.f());
            String str4 = "";
            if (n10 == null) {
                str2 = str4;
            } else {
                str2 = n10;
            }
            Activity activity = r1Var2.f17073a;
            t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
            f5.c cVar = (f5.c) activity;
            String type = recommendContentList.getType();
            String programType = recommendContentList.getProgramType();
            String contentId = recommendContentList.getContentId();
            EnterType enterType = EnterType.BANNER;
            String name = recommendContentList.getName();
            if (name != null) {
                str3 = ba.t.W(name).toString();
            } else {
                str3 = null;
            }
            String str5 = str3;
            int b10 = s1Var.b();
            StringBuilder sb = new StringBuilder();
            String alias = r1Var2.f17074b.getAlias();
            if (alias == null) {
                alias = str4;
            }
            sb.append(alias);
            sb.append('/');
            if (str != null) {
                str4 = str;
            }
            sb.append(str4);
            b0.r(cVar, type, programType, contentId, enterType, str5, false, false, b10, sb.toString(), str2);
        } else if (obj2 instanceof AdInfo) {
            AdInfo adInfo = (AdInfo) obj2;
            String action = adInfo.getAction();
            if (action == null || action.length() == 0) {
                z10 = true;
            }
            if (!z10 && t9.i.b(adInfo.getAction_type(), "1")) {
                a6.a.u(a6.a.f10646a, r1Var2.f17073a, adInfo.getAction(), false, 4, (Object) null);
                q qVar = q.f9311a;
                Activity activity2 = r1Var2.f17073a;
                qVar.h(activity2, d6.b.f6366a.m(activity2), adInfo.getMedia_type(), adInfo);
            } else if (t9.i.b(adInfo.getAction_type(), CdnType.DIGITAL_TYPE_PCDN)) {
                b0.m(r1Var2.f17073a);
            }
        }
    }

    public static final void w(r1 r1Var, View view) {
        t9.i.g(r1Var, "this$0");
        Activity activity = r1Var.f17073a;
        t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.k((f5.c) activity, RootColumnId.freeVodColumn, -1, false);
    }

    public static final void z(t1 t1Var, r1 r1Var, View view) {
        String str;
        String str2;
        int i10;
        String alias;
        String name;
        t9.i.g(t1Var, "$recommendFragItem");
        t9.i.g(r1Var, "this$0");
        ChildColumnList a10 = t1Var.a();
        if (a10 == null || (name = a10.getName()) == null) {
            str = "";
        } else {
            str = name;
        }
        ChildColumnList a11 = t1Var.a();
        if (a11 == null || (alias = a11.getAlias()) == null) {
            str2 = "";
        } else {
            str2 = alias;
        }
        ChildColumnList a12 = t1Var.a();
        if (a12 != null) {
            i10 = a12.getId();
        } else {
            i10 = 0;
        }
        HomeRecommend homeRecommend = new HomeRecommend(str, str2, Integer.valueOf(i10), "", "", "", "", (List<HomeAsset>) null, (List<? extends PosterList>) null, (List<Channel>) null, (List<HomeRecommend>) null);
        Activity activity = r1Var.f17073a;
        t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.u((f5.c) activity, homeRecommend);
    }

    public final void A(BaseViewHolder baseViewHolder, e1 e1Var) {
        SmallAdNativeContainer smallAdNativeContainer = (SmallAdNativeContainer) baseViewHolder.getView(R.id.mSanvNativeContainer);
        if (e1Var.a().isShowAllAd()) {
            smallAdNativeContainer.setKeep(true);
            t9.i.f(smallAdNativeContainer, "adView");
            SmallAdNativeContainer.loadAd$default(smallAdNativeContainer, e1Var, false, 2, (Object) null);
        } else if (e1Var.a().isShowOwnAd()) {
            smallAdNativeContainer.setKeep(true);
            t9.i.f(smallAdNativeContainer, "adView");
            SmallAdNativeContainer.loadOwn$default(smallAdNativeContainer, e1Var, false, 2, (Object) null);
        } else {
            t9.i.f(smallAdNativeContainer, "adView");
            SmallAdNativeContainer.hideView$default(smallAdNativeContainer, false, 1, (Object) null);
            return;
        }
        if (!this.f17077e.contains(smallAdNativeContainer)) {
            this.f17077e.add(smallAdNativeContainer);
        }
    }

    public final void B(BaseViewHolder baseViewHolder, p2 p2Var) {
        List list;
        TextView textView = (TextView) baseViewHolder.getView(R.id.mTvColumnName);
        ChildColumnList a10 = p2Var.a();
        if (a10 != null) {
            if (f0.b() || TextUtils.isEmpty(a10.getAlias())) {
                textView.setText(a10.getName());
            } else {
                textView.setText(a10.getAlias());
            }
        }
        ((ImageView) baseViewHolder.getView(R.id.mMoreIv)).setOnClickListener(new g1(p2Var, this));
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.mRecommendColumnRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f17073a, 0, false));
        g2 g2Var = new g2(this.f17073a);
        recyclerView.setAdapter(g2Var);
        List b10 = p2Var.b();
        if (b10 != null) {
            list = r.D(b10, 10);
        } else {
            list = null;
        }
        g2Var.setNewData(list);
        g2Var.setOnItemClickListener(new i1(this, p2Var));
    }

    public final void E(BaseViewHolder baseViewHolder, f3 f3Var) {
        AdaptiveAdContainer adaptiveAdContainer = (AdaptiveAdContainer) baseViewHolder.getView(R.id.mAavSmartContainer);
        if (!a6.a.f10646a.s()) {
            t9.i.f(adaptiveAdContainer, "adView");
            AdaptiveAdContainer.hideView$default(adaptiveAdContainer, false, 1, (Object) null);
            return;
        }
        if (!this.f17077e.contains(adaptiveAdContainer)) {
            List list = this.f17077e;
            t9.i.f(adaptiveAdContainer, "adView");
            list.add(adaptiveAdContainer);
        }
        t9.i.f(adaptiveAdContainer, "adView");
        AdaptiveAdContainer.loadAd$default(adaptiveAdContainer, f3Var, false, 2, (Object) null);
    }

    public final void F(BaseViewHolder baseViewHolder, u1 u1Var) {
        List list;
        TextView textView = (TextView) baseViewHolder.getView(R.id.mColumnNameTv);
        ChildColumnList a10 = u1Var.a();
        if (a10 != null) {
            if (f0.b() || TextUtils.isEmpty(a10.getAlias())) {
                textView.setText(a10.getName());
            } else {
                textView.setText(a10.getAlias());
            }
        }
        ((ImageView) baseViewHolder.getView(R.id.mMoreIv)).setOnClickListener(new p1(this));
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.mRecommendColumnRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f17073a, 0, false));
        d2 d2Var = new d2(this.f17073a);
        recyclerView.setAdapter(d2Var);
        List b10 = u1Var.b();
        if (b10 != null) {
            list = r.D(b10, 10);
        } else {
            list = null;
        }
        d2Var.setNewData(list);
    }

    public final void H(BaseViewHolder baseViewHolder, o2 o2Var) {
        boolean z10;
        List list;
        TextView textView = (TextView) baseViewHolder.getView(R.id.mTvColumnName);
        ChildColumnList a10 = o2Var.a();
        if (a10 != null) {
            if (f0.b() || TextUtils.isEmpty(a10.getAlias())) {
                textView.setText(a10.getName());
            } else {
                textView.setText(a10.getAlias());
            }
        }
        ((ImageView) baseViewHolder.getView(R.id.mIvMore)).setOnClickListener(new j1(this, o2Var));
        List b10 = o2Var.b();
        int i10 = 0;
        if (b10 == null || b10.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.mRvContent);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.f17073a, 0, false));
            List b11 = o2Var.b();
            String str = null;
            if (b11 != null) {
                list = r.D(b11, 10);
            } else {
                list = null;
            }
            Activity activity = this.f17073a;
            ChildColumnList a11 = o2Var.a();
            if (a11 != null) {
                i10 = a11.getId();
            }
            t9.i.d(list);
            StringBuilder sb = new StringBuilder();
            String alias = this.f17074b.getAlias();
            if (alias == null) {
                alias = "";
            }
            sb.append(alias);
            sb.append('/');
            ChildColumnList a12 = o2Var.a();
            if (a12 != null) {
                str = a12.getAlias();
            }
            sb.append(str);
            k2 k2Var = new k2(activity, i10, list, sb.toString());
            recyclerView.setAdapter(k2Var);
            k2Var.notifyDataSetChanged();
        }
    }

    /* renamed from: J */
    public void convert(BaseViewHolder baseViewHolder, MultiItemEntity multiItemEntity) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(multiItemEntity, PlistBuilder.KEY_ITEM);
        int itemType = multiItemEntity.getItemType();
        a6.d dVar = a6.d.f10667a;
        if (itemType == dVar.i()) {
            y(baseViewHolder, (t1) multiItemEntity);
        } else if (itemType == dVar.h()) {
            A(baseViewHolder, (e1) multiItemEntity);
        } else if (itemType == dVar.k()) {
            E(baseViewHolder, (f3) multiItemEntity);
        } else if (itemType == dVar.e()) {
            p(baseViewHolder, (s1) multiItemEntity);
        } else if (itemType == dVar.g()) {
            androidx.appcompat.app.m.a(multiItemEntity);
            x(baseViewHolder, (e0) null);
        } else if (itemType == dVar.f()) {
            v(baseViewHolder, (b0) multiItemEntity);
        } else if (itemType == dVar.l()) {
            F(baseViewHolder, (u1) multiItemEntity);
        } else if (itemType == dVar.d()) {
            H(baseViewHolder, (o2) multiItemEntity);
        } else if (itemType == dVar.j()) {
            B(baseViewHolder, (p2) multiItemEntity);
        }
    }

    public final Activity K() {
        return this.f17073a;
    }

    public final boolean L() {
        return this.f17075c;
    }

    public final boolean M() {
        return this.f17076d;
    }

    public final void N(boolean z10) {
        boolean z11;
        for (IAdView iAdView : this.f17077e) {
            if (!this.f17075c || !this.f17076d) {
                z11 = false;
            } else {
                z11 = true;
            }
            iAdView.hostVisibilityChange(z11, z10);
        }
    }

    public final void O(String str, int i10) {
        String str2;
        StringBuilder sb = new StringBuilder();
        i.c cVar = w6.i.f9510g;
        sb.append(cVar.v());
        sb.append("_movies");
        if (t9.i.b(str, sb.toString())) {
            str2 = "EVENT_RECOMMEND_AD_CLICK_MOVIE";
        } else {
            if (t9.i.b(str, cVar.v() + "_series")) {
                str2 = "EVENT_RECOMMEND_AD_CLICK_SERIES";
            } else {
                if (t9.i.b(str, cVar.v() + "_kids")) {
                    str2 = "EVENT_RECOMMEND_AD_CLICK_KIDS";
                } else {
                    if (t9.i.b(str, cVar.v() + "_animes")) {
                        str2 = "EVENT_RECOMMEND_AD_CLICK_ANIME";
                    } else {
                        str2 = "";
                    }
                }
            }
        }
        i1.D(this.f17073a, str2, i10 + 1);
    }

    public final void P(String str, int i10) {
        String str2;
        StringBuilder sb = new StringBuilder();
        i.c cVar = w6.i.f9510g;
        sb.append(cVar.v());
        sb.append("_movies");
        if (t9.i.b(str, sb.toString())) {
            str2 = "EVENT_RECOMMEND_AD_SHOW_MOVIE";
        } else {
            if (t9.i.b(str, cVar.v() + "_series")) {
                str2 = "EVENT_RECOMMEND_AD_SHOW_SERIES";
            } else {
                if (t9.i.b(str, cVar.v() + "_kids")) {
                    str2 = "EVENT_RECOMMEND_AD_SHOW_KIDS";
                } else {
                    if (t9.i.b(str, cVar.v() + "_animes")) {
                        str2 = "EVENT_RECOMMEND_AD_SHOW_ANIME";
                    } else {
                        str2 = "";
                    }
                }
            }
        }
        i1.D(this.f17073a, str2, i10 + 1);
    }

    public final void Q(boolean z10) {
        this.f17075c = z10;
        N(!z10);
    }

    public final void R(boolean z10) {
        this.f17076d = z10;
        N(true);
    }

    public final void o(boolean z10) {
        int i10;
        BGABanner bGABanner = this.f17078f;
        if (bGABanner != null) {
            i10 = bGABanner.getItemCount();
        } else {
            i10 = 0;
        }
        if (i10 <= 1) {
            return;
        }
        if (z10) {
            BGABanner bGABanner2 = this.f17078f;
            if (bGABanner2 != null) {
                bGABanner2.startAutoPlay();
                return;
            }
            return;
        }
        BGABanner bGABanner3 = this.f17078f;
        if (bGABanner3 != null) {
            bGABanner3.stopAutoPlay();
        }
    }

    public final void p(BaseViewHolder baseViewHolder, s1 s1Var) {
        boolean z10;
        this.f17078f = (BGABanner) baseViewHolder.getView(R.id.mRecommendBanner);
        boolean z11 = false;
        if (s1Var.c().isEmpty()) {
            BGABanner bGABanner = this.f17078f;
            t9.i.d(bGABanner);
            bGABanner.setAutoPlayAble(false);
            BGABanner bGABanner2 = this.f17078f;
            t9.i.d(bGABanner2);
            bGABanner2.setAdapter(new k1());
            BGABanner bGABanner3 = this.f17078f;
            t9.i.d(bGABanner3);
            bGABanner3.setData(i9.i.b(Integer.valueOf(R.drawable.column_image_placeholder)), (List<String>) null);
            return;
        }
        List<RecommendContentList> contentList = ((Recommend) s1Var.c().get(0)).getContentList();
        String recommendCode = ((Recommend) s1Var.c().get(0)).getRecommendCode();
        BGABanner bGABanner4 = this.f17078f;
        t9.i.d(bGABanner4);
        if (contentList.size() > 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        bGABanner4.setAutoPlayAble(z10);
        BGABanner bGABanner5 = this.f17078f;
        t9.i.d(bGABanner5);
        bGABanner5.setAdapter(new l1(this));
        BGABanner bGABanner6 = this.f17078f;
        t9.i.d(bGABanner6);
        bGABanner6.setData((int) R.layout.item_bga_banner_recommend, (List<? extends Object>) contentList, (List<String>) null);
        BGABanner bGABanner7 = this.f17078f;
        t9.i.d(bGABanner7);
        bGABanner7.setDelegate(new m1(this, s1Var, recommendCode));
        BGABanner bGABanner8 = this.f17078f;
        t9.i.d(bGABanner8);
        bGABanner8.getViewPager().removeOnPageChangeListener(this.f17079g);
        d dVar = this.f17079g;
        String a10 = s1Var.a();
        String str = "";
        if (a10 == null) {
            a10 = str;
        }
        dVar.c(a10);
        this.f17079g.b(contentList);
        BGABanner bGABanner9 = this.f17078f;
        t9.i.d(bGABanner9);
        bGABanner9.getViewPager().addOnPageChangeListener(this.f17079g);
        BGABanner bGABanner10 = this.f17078f;
        t9.i.d(bGABanner10);
        int currentItem = bGABanner10.getViewPager().getCurrentItem() % contentList.size();
        if (currentItem >= 0 && currentItem < contentList.size() && t9.i.b("4", contentList.get(currentItem).getType())) {
            String a11 = s1Var.a();
            if (a11 != null) {
                str = a11;
            }
            P(str, currentItem);
        }
        String a12 = s1Var.a();
        if (a12 != null && ba.t.o(a12, "_Recommended", false, 2, (Object) null)) {
            z11 = true;
        }
        if (z11) {
            m.T(m.f9270a, new c(this, contentList), (String) null, 2, (Object) null);
        }
    }

    public final void v(BaseViewHolder baseViewHolder, b0 b0Var) {
        ((FrameLayout) baseViewHolder.getView(R.id.llOpenFree)).setOnClickListener(new o1(this));
    }

    public final void x(BaseViewHolder baseViewHolder, e0 e0Var) {
        ReportImageView reportImageView = (ReportImageView) baseViewHolder.getView(R.id.mIvFirstBannerAd);
        reportImageView.setKeep(true);
        TextView textView = (TextView) baseViewHolder.getView(R.id.mTvFirstBannerFlag);
        t9.i.f(reportImageView, "ivAd");
        throw null;
    }

    public final void y(BaseViewHolder baseViewHolder, t1 t1Var) {
        int i10;
        List list;
        String alias;
        TextView textView = (TextView) baseViewHolder.getView(R.id.mColumnNameTv);
        ChildColumnList a10 = t1Var.a();
        if (a10 != null) {
            if (f0.b() || TextUtils.isEmpty(a10.getAlias())) {
                textView.setText(a10.getName());
            } else {
                textView.setText(a10.getAlias());
            }
        }
        ((ImageView) baseViewHolder.getView(R.id.mMoreIv)).setOnClickListener(new n1(t1Var, this));
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.mRecommendColumnRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f17073a, 0, false));
        Activity activity = this.f17073a;
        ChildColumnList a11 = t1Var.a();
        if (a11 != null) {
            i10 = a11.getId();
        } else {
            i10 = -1;
        }
        StringBuilder sb = new StringBuilder();
        String alias2 = this.f17074b.getAlias();
        String str = "";
        if (alias2 == null) {
            alias2 = str;
        }
        sb.append(alias2);
        sb.append('/');
        ChildColumnList a12 = t1Var.a();
        if (!(a12 == null || (alias = a12.getAlias()) == null)) {
            str = alias;
        }
        sb.append(str);
        y1 y1Var = new y1(activity, i10, false, true, false, sb.toString(), 16, (g) null);
        recyclerView.setAdapter(y1Var);
        List b10 = t1Var.b();
        if (b10 != null) {
            list = r.D(b10, 10);
        } else {
            list = null;
        }
        y1Var.setNewData(list);
    }
}
