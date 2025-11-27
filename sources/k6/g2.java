package k6;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.cybergarage.xml.XML;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.PlayAty;
import com.mobile.brasiltv.bean.AudioTrackBean;
import com.mobile.brasiltv.bean.SubTitleData;
import com.mobile.brasiltv.bean.SubtitleManager;
import com.mobile.brasiltv.bean.event.VodFavEvent;
import com.mobile.brasiltv.bean.event.VodSubEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.utils.a1;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.view.MsgNotifyDialog;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.titan.ranger.bean.Program;
import com.titans.entity.RangerPlayTag;
import com.umeng.analytics.pro.bd;
import i6.f0;
import i6.g0;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import mobile.com.requestframe.utils.response.AddFavorite;
import mobile.com.requestframe.utils.response.AddFavoriteResult;
import mobile.com.requestframe.utils.response.AddSubscribeResult;
import mobile.com.requestframe.utils.response.AssetData;
import mobile.com.requestframe.utils.response.DelFavoriteResult;
import mobile.com.requestframe.utils.response.DelSubscribeResult;
import mobile.com.requestframe.utils.response.EpisodeList;
import mobile.com.requestframe.utils.response.GetItemDataResult;
import mobile.com.requestframe.utils.response.GetItemDataResultData;
import mobile.com.requestframe.utils.response.Movie;
import mobile.com.requestframe.utils.response.ProgramSeason;
import mobile.com.requestframe.utils.response.SearchByContent;
import mobile.com.requestframe.utils.response.SearchByContentData;
import mobile.com.requestframe.utils.response.StartPlayVODData;
import mobile.com.requestframe.utils.response.StartPlayVODResult;
import mobile.com.requestframe.utils.response.SubData;
import mobile.com.requestframe.utils.response.SubItem;
import mobile.com.requestframe.utils.response.TotalMovieList;
import w6.i;

public final class g2 implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f17728a;

    /* renamed from: b  reason: collision with root package name */
    public final g0 f17729b;

    /* renamed from: c  reason: collision with root package name */
    public AssetData f17730c;

    /* renamed from: d  reason: collision with root package name */
    public Disposable f17731d;

    /* renamed from: e  reason: collision with root package name */
    public Disposable f17732e;

    /* renamed from: f  reason: collision with root package name */
    public Disposable f17733f;

    /* renamed from: g  reason: collision with root package name */
    public final h9.g f17734g = h9.h.b(new q(this));

    /* renamed from: h  reason: collision with root package name */
    public String f17735h = "";

    /* renamed from: i  reason: collision with root package name */
    public Disposable f17736i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap f17737j;

    /* renamed from: k  reason: collision with root package name */
    public HashMap f17738k;

    /* renamed from: l  reason: collision with root package name */
    public Movie f17739l;

    /* renamed from: m  reason: collision with root package name */
    public String f17740m;

    /* renamed from: n  reason: collision with root package name */
    public List f17741n;

    /* renamed from: o  reason: collision with root package name */
    public HashMap f17742o;

    /* renamed from: p  reason: collision with root package name */
    public AudioTrackBean f17743p;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f17744a = new a();

        public a() {
            super(1);
        }

        /* renamed from: b */
        public final List invoke(SearchByContentData searchByContentData) {
            t9.i.g(searchByContentData, "it");
            SearchByContent data = searchByContentData.getData();
            if (data != null) {
                return data.getAssetList();
            }
            return null;
        }
    }

    public static final class a0 extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f17745a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VodSubEvent f17746b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17747a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17747a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f12639a, this.f17747a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a0(g2 g2Var, VodSubEvent vodSubEvent) {
            this.f17745a = g2Var;
            this.f17746b = vodSubEvent;
        }

        /* renamed from: f */
        public void onNext(AddSubscribeResult addSubscribeResult) {
            t9.i.g(addSubscribeResult, "t");
            this.f17746b.getData().setSubscribeId(addSubscribeResult.getData().getSubscribeId());
            this.f17746b.getData().setHasSubscribe("1");
            this.f17745a.f0().f0(this.f17746b.getData());
            this.f17745a.f0().i0();
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (TextUtils.equals("portal100062", str)) {
                f1.a.j(f1.f12517a, this.f17745a.S(), R.string.vod_sub_limit, 0, 4, (Object) null);
            } else {
                com.mobile.brasiltv.utils.x.f12622a.w(this.f17745a.S(), new a(str));
            }
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f17748a = new b();

        public b() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(List list) {
            t9.i.g(list, "it");
            return Boolean.valueOf(com.mobile.brasiltv.utils.b0.I(list));
        }
    }

    public static final class b0 extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f17749a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VodSubEvent f17750b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17751a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17751a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f12639a, this.f17751a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public b0(g2 g2Var, VodSubEvent vodSubEvent) {
            this.f17749a = g2Var;
            this.f17750b = vodSubEvent;
        }

        /* renamed from: f */
        public void onNext(DelSubscribeResult delSubscribeResult) {
            t9.i.g(delSubscribeResult, "t");
            this.f17750b.getData().setHasSubscribe("0");
            this.f17749a.f0().f0(this.f17750b.getData());
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.x.f12622a.w(this.f17749a.S(), new a(str));
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f17752a;

        public c(g2 g2Var) {
            this.f17752a = g2Var;
        }

        /* renamed from: f */
        public void onNext(List list) {
            t9.i.g(list, "t");
            this.f17752a.f0().G1(list);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final d f17753a = new d();

        public d() {
            super(1);
        }

        /* renamed from: b */
        public final List invoke(SearchByContentData searchByContentData) {
            t9.i.g(searchByContentData, "it");
            SearchByContent data = searchByContentData.getData();
            if (data != null) {
                return data.getAssetList();
            }
            return null;
        }
    }

    public static final class e extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final e f17754a = new e();

        public e() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(List list) {
            t9.i.g(list, "it");
            return Boolean.valueOf(com.mobile.brasiltv.utils.b0.I(list));
        }
    }

    public static final class f extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f17755a;

        public f(g2 g2Var) {
            this.f17755a = g2Var;
        }

        /* renamed from: f */
        public void onNext(List list) {
            t9.i.g(list, "t");
            this.f17755a.f0().G1(list);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }
    }

    public static final class g extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f17756a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17757b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(g2 g2Var, String str) {
            super(1);
            this.f17756a = g2Var;
            this.f17757b = str;
        }

        /* renamed from: b */
        public final List invoke(List list) {
            boolean z10;
            int i10;
            String str;
            String str2;
            t9.i.g(list, "data");
            ArrayList arrayList = new ArrayList();
            g2 g2Var = this.f17756a;
            String str3 = this.f17757b;
            Iterator it = list.iterator();
            Object obj = null;
            SubTitleData subTitleData = null;
            while (it.hasNext()) {
                SubData subData = (SubData) it.next();
                List<SubItem> component1 = subData.component1();
                String component2 = subData.component2();
                SubTitleData subTitleData2 = new SubTitleData();
                t9.i.d(component2);
                subTitleData2.setLanguage(component2);
                t9.i.d(component1);
                ArrayList<SubItem> arrayList2 = new ArrayList<>();
                for (T next : component1) {
                    if (t9.i.b("srt", ((SubItem) next).getFileType())) {
                        arrayList2.add(next);
                    }
                }
                for (SubItem subItem : arrayList2) {
                    String url = subItem.getUrl();
                    t9.i.d(url);
                    String a10 = a3.e.a(url, "key_subtitle");
                    String str4 = "";
                    if (a10 == null) {
                        a10 = str4;
                    }
                    subTitleData2.setSubUrl(a10);
                    String md5 = subItem.getMd5();
                    if (md5 == null) {
                        md5 = str4;
                    }
                    subTitleData2.setMd5(md5);
                    String url2 = subItem.getUrl();
                    if (url2 == null || !ba.t.o(url2, "srt", false, 2, obj)) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (z10) {
                        if (url2 != null) {
                            i10 = 2;
                            str2 = url2.substring(ba.t.D(url2, Operator.Operation.DIVISION, 0, false, 6, (Object) null) + 1);
                            t9.i.f(str2, "this as java.lang.String).substring(startIndex)");
                        } else {
                            i10 = 2;
                            str2 = null;
                        }
                        if (str2 != null && str2.length() >= 4) {
                            str4 = str2.substring(0, str2.length() - 4);
                            t9.i.f(str4, "this as java.lang.String…ing(startIndex, endIndex)");
                        }
                    } else {
                        i10 = 2;
                        if (url2 != null) {
                            str = url2.substring(ba.t.D(url2, "preview/", 0, false, 6, (Object) null) + 8);
                            t9.i.f(str, "this as java.lang.String).substring(startIndex)");
                        } else {
                            str = null;
                        }
                        if (str != null && ba.t.o(str, Operator.Operation.EMPTY_PARAM, false, 2, (Object) null)) {
                            str4 = ba.t.V(str, Operator.Operation.EMPTY_PARAM, (String) null, 2, (Object) null);
                        }
                    }
                    subTitleData2.setFilePath(a6.e.a(g2Var.S(), str3, str4, component2));
                    arrayList.add(subTitleData2);
                    int mGlobalLanguage = SubtitleManager.INSTANCE.getMGlobalLanguage();
                    String str5 = "pt";
                    if (mGlobalLanguage != 0) {
                        if (mGlobalLanguage == 1) {
                            str5 = XML.DEFAULT_CONTENT_LANGUAGE;
                        } else if (mGlobalLanguage == i10) {
                            str5 = "es";
                        }
                    }
                    obj = null;
                    if (ba.t.o(component2, str5, false, i10, (Object) null)) {
                        subTitleData = subTitleData2;
                    }
                }
            }
            if (subTitleData != null) {
                t9.i.d(subTitleData);
                arrayList.remove(subTitleData);
                arrayList.add(0, subTitleData);
            }
            return arrayList;
        }
    }

    public static final class h extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final h f17758a = new h();

        public h() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(List list) {
            t9.i.g(list, "it");
            if (list.isEmpty()) {
                k7.f.f("no have srt sub", new Object[0]);
            }
            return Boolean.valueOf(!list.isEmpty());
        }
    }

    public static final class i extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f17759a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17760b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(g2 g2Var, String str) {
            super(1);
            this.f17759a = g2Var;
            this.f17760b = str;
        }

        public final void b(List list) {
            g2 g2Var = this.f17759a;
            com.mobile.brasiltv.utils.b0.U(g2Var, "subtitle成功 " + list);
            ((SubTitleData) list.get(0)).setSelected(true);
            g0 f02 = this.f17759a.f0();
            t9.i.f(list, "it");
            f02.I0(list);
            this.f17759a.I0(this.f17760b, list);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return h9.t.f17319a;
        }
    }

    public static final class j extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final j f17761a = new j();

        public j() {
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

    public static final class k extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f17762a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VodFavEvent f17763b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17764a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17764a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f12639a;
                String p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f17764a, (String) null, (String) null, 6, (Object) null);
                yVar.c(this.f17764a);
                f1.f12517a.x(p10);
            }
        }

        public k(g2 g2Var, VodFavEvent vodFavEvent) {
            this.f17762a = g2Var;
            this.f17763b = vodFavEvent;
        }

        /* renamed from: f */
        public void onNext(DelFavoriteResult delFavoriteResult) {
            t9.i.g(delFavoriteResult, "t");
            this.f17763b.getData().setHasFavorite("0");
            this.f17762a.f0().W0(this.f17763b.getData());
            this.f17762a.D0(this.f17763b.getData().getContentId());
        }

        public void onError(Throwable th) {
            t9.i.g(th, "e");
            super.onError(th);
            this.f17762a.D0(this.f17763b.getData().getContentId());
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.x.f12622a.w(this.f17762a.S(), new a(str));
        }
    }

    public static final class l extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f17765a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VodFavEvent f17766b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17767a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17767a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f12639a, this.f17767a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public l(g2 g2Var, VodFavEvent vodFavEvent) {
            this.f17765a = g2Var;
            this.f17766b = vodFavEvent;
        }

        /* renamed from: f */
        public void onNext(AddFavoriteResult addFavoriteResult) {
            t9.i.g(addFavoriteResult, "t");
            AssetData data = this.f17766b.getData();
            List<AddFavorite> favoriteList = addFavoriteResult.getData().getFavoriteList();
            t9.i.d(favoriteList);
            Integer favoriteId = favoriteList.get(0).getFavoriteId();
            t9.i.d(favoriteId);
            data.setFavoriteId(favoriteId.intValue());
            this.f17766b.getData().setHasFavorite("1");
            this.f17765a.f0().W0(this.f17766b.getData());
            this.f17765a.D0(this.f17766b.getData().getContentId());
        }

        public void onError(Throwable th) {
            t9.i.g(th, "e");
            super.onError(th);
            this.f17765a.D0(this.f17766b.getData().getContentId());
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (TextUtils.equals("portal100061", str)) {
                f1.a.j(f1.f12517a, this.f17765a.S(), R.string.vod_fav_limit, 0, 4, (Object) null);
            } else {
                com.mobile.brasiltv.utils.x.f12622a.w(this.f17765a.S(), new a(str));
            }
        }
    }

    public static final class m extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final m f17768a = new m();

        public static final class a implements Comparator {
            public final int compare(Object obj, Object obj2) {
                return j9.a.a(Integer.valueOf(((ProgramSeason) obj).getSeasonNumber()), Integer.valueOf(((ProgramSeason) obj2).getSeasonNumber()));
            }
        }

        public m() {
            super(1);
        }

        /* renamed from: b */
        public final AssetData invoke(GetItemDataResult getItemDataResult) {
            List<ProgramSeason> list;
            AssetData assetData;
            List list2;
            AssetData assetData2;
            t9.i.g(getItemDataResult, "it");
            GetItemDataResultData data = getItemDataResult.getData();
            if (data == null || (assetData2 = data.getAssetData()) == null) {
                list = null;
            } else {
                list = assetData2.getSameSeasonSeriesList();
            }
            GetItemDataResultData data2 = getItemDataResult.getData();
            if (data2 != null) {
                assetData = data2.getAssetData();
            } else {
                assetData = null;
            }
            if (assetData != null) {
                if (list != null) {
                    list2 = i9.r.C(list, new a());
                } else {
                    list2 = null;
                }
                assetData.setSameSeasonSeriesList(list2);
            }
            GetItemDataResultData data3 = getItemDataResult.getData();
            if (data3 != null) {
                return data3.getAssetData();
            }
            return null;
        }
    }

    public static final class n extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f17769a;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17770a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17770a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f12639a, this.f17770a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public n(g2 g2Var) {
            this.f17769a = g2Var;
        }

        /* renamed from: f */
        public void onNext(AssetData assetData) {
            t9.i.g(assetData, "t");
            com.mobile.brasiltv.utils.b0.U(this, "加载节目数据 " + assetData);
            if (assetData.getSimpleProgramList().isEmpty()) {
                g0.b.b(this.f17769a.f0(), (String) null, 1, (Object) null);
                return;
            }
            this.f17769a.f17730c = assetData;
            this.f17769a.f0().N0(assetData);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17769a.f0().y0(str);
            com.mobile.brasiltv.utils.x.f12622a.w(this.f17769a.S(), new a(str));
        }
    }

    public static final class o extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final o f17771a = new o();

        public static final class a implements Comparator {
            public final int compare(Object obj, Object obj2) {
                return j9.a.a(Integer.valueOf(((ProgramSeason) obj).getSeasonNumber()), Integer.valueOf(((ProgramSeason) obj2).getSeasonNumber()));
            }
        }

        public o() {
            super(1);
        }

        /* renamed from: b */
        public final GetItemDataResult invoke(GetItemDataResult getItemDataResult) {
            List<ProgramSeason> list;
            AssetData assetData;
            AssetData assetData2;
            t9.i.g(getItemDataResult, "it");
            GetItemDataResultData data = getItemDataResult.getData();
            List list2 = null;
            if (data == null || (assetData2 = data.getAssetData()) == null) {
                list = null;
            } else {
                list = assetData2.getSameSeasonSeriesList();
            }
            GetItemDataResultData data2 = getItemDataResult.getData();
            if (data2 != null) {
                assetData = data2.getAssetData();
            } else {
                assetData = null;
            }
            if (assetData != null) {
                if (list != null) {
                    list2 = i9.r.C(list, new a());
                }
                assetData.setSameSeasonSeriesList(list2);
            }
            return getItemDataResult;
        }
    }

    public static final class p extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f17772a;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17773a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17773a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f12639a, this.f17773a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public p(g2 g2Var) {
            this.f17772a = g2Var;
        }

        /* renamed from: f */
        public void onNext(GetItemDataResult getItemDataResult) {
            AssetData assetData;
            t9.i.g(getItemDataResult, "t");
            this.f17772a.f0().g0(false);
            GetItemDataResultData data = getItemDataResult.getData();
            if (data != null) {
                assetData = data.getAssetData();
            } else {
                assetData = null;
            }
            com.mobile.brasiltv.utils.b0.U(this, "load season program: " + assetData);
            if (assetData != null) {
                this.f17772a.f0().d0(assetData);
            }
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17772a.f17731d = disposable;
            this.f17772a.f0().g0(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17772a.f0().g0(false);
            com.mobile.brasiltv.utils.x.f12622a.w(this.f17772a.S(), new a(str));
        }
    }

    public static final class q extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f17774a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(g2 g2Var) {
            super(0);
            this.f17774a = g2Var;
        }

        /* renamed from: b */
        public final MobileDao invoke() {
            Context applicationContext = this.f17774a.S().getApplicationContext();
            t9.i.f(applicationContext, "context.applicationContext");
            return new MobileDao(applicationContext);
        }
    }

    public static final class r extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t9.w f17775a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g2 f17776b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17777c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f17778d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(t9.w wVar, g2 g2Var, String str, List list) {
            super(1);
            this.f17775a = wVar;
            this.f17776b = g2Var;
            this.f17777c = str;
            this.f17778d = list;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "it");
            if (bool.booleanValue()) {
                this.f17776b.f0().D2(this.f17776b.V(), this.f17776b.U());
                g0 f02 = this.f17776b.f0();
                String str = this.f17777c;
                Object obj = this.f17775a.f19600a;
                t9.i.d(obj);
                f02.T1(str, (Program) obj);
                this.f17776b.n0();
                this.f17776b.g0(this.f17778d, this.f17777c);
            }
        }
    }

    public static final class s extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final s f17779a = new s();

        public s() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f17319a;
        }
    }

    public static final class t extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f17780a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(g2 g2Var) {
            super(1);
            this.f17780a = g2Var;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
            if (r0 != false) goto L_0x004a;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Boolean invoke(mobile.com.requestframe.utils.response.StartPlayVODResult r5) {
            /*
                r4 = this;
                java.lang.String r0 = "it"
                t9.i.g(r5, r0)
                mobile.com.requestframe.utils.response.StartPlayVODData r0 = r5.getData()
                r1 = 0
                if (r0 == 0) goto L_0x0011
                java.util.List r0 = r0.getEpisodeList()
                goto L_0x0012
            L_0x0011:
                r0 = r1
            L_0x0012:
                r2 = 0
                r3 = 1
                if (r0 == 0) goto L_0x001f
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x001d
                goto L_0x001f
            L_0x001d:
                r0 = 0
                goto L_0x0020
            L_0x001f:
                r0 = 1
            L_0x0020:
                if (r0 != 0) goto L_0x004a
                mobile.com.requestframe.utils.response.StartPlayVODData r0 = r5.getData()
                if (r0 == 0) goto L_0x003b
                java.util.List r0 = r0.getEpisodeList()
                if (r0 == 0) goto L_0x003b
                java.lang.Object r0 = r0.get(r2)
                mobile.com.requestframe.utils.response.EpisodeList r0 = (mobile.com.requestframe.utils.response.EpisodeList) r0
                if (r0 == 0) goto L_0x003b
                java.util.List r0 = r0.getTotalMovieList()
                goto L_0x003c
            L_0x003b:
                r0 = r1
            L_0x003c:
                if (r0 == 0) goto L_0x0047
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x0045
                goto L_0x0047
            L_0x0045:
                r0 = 0
                goto L_0x0048
            L_0x0047:
                r0 = 1
            L_0x0048:
                if (r0 == 0) goto L_0x0053
            L_0x004a:
                k6.g2 r0 = r4.f17780a
                i6.g0 r0 = r0.f0()
                i6.g0.b.a(r0, r1, r3, r3, r1)
            L_0x0053:
                mobile.com.requestframe.utils.response.StartPlayVODData r5 = r5.getData()
                if (r5 == 0) goto L_0x006b
                java.util.List r5 = r5.getEpisodeList()
                if (r5 == 0) goto L_0x006b
                java.lang.Object r5 = r5.get(r2)
                mobile.com.requestframe.utils.response.EpisodeList r5 = (mobile.com.requestframe.utils.response.EpisodeList) r5
                if (r5 == 0) goto L_0x006b
                java.util.List r1 = r5.getTotalMovieList()
            L_0x006b:
                boolean r5 = com.mobile.brasiltv.utils.b0.I(r1)
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: k6.g2.t.invoke(mobile.com.requestframe.utils.response.StartPlayVODResult):java.lang.Boolean");
        }
    }

    public static final class u extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t9.w f17781a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t9.w f17782b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ t9.u f17783c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g2 f17784d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(t9.w wVar, t9.w wVar2, t9.u uVar, g2 g2Var) {
            super(1);
            this.f17781a = wVar;
            this.f17782b = wVar2;
            this.f17783c = uVar;
            this.f17784d = g2Var;
        }

        /* renamed from: b */
        public final HashMap invoke(StartPlayVODResult startPlayVODResult) {
            int i10;
            t9.i.g(startPlayVODResult, "it");
            t9.w wVar = this.f17781a;
            StartPlayVODData data = startPlayVODResult.getData();
            t9.i.d(data);
            List<EpisodeList> episodeList = data.getEpisodeList();
            t9.i.d(episodeList);
            wVar.f19600a = episodeList.get(0).getSubtitleList();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            t9.w wVar2 = this.f17782b;
            StartPlayVODData data2 = startPlayVODResult.getData();
            t9.i.d(data2);
            List<EpisodeList> episodeList2 = data2.getEpisodeList();
            t9.i.d(episodeList2);
            String programContentId = episodeList2.get(0).getProgramContentId();
            if (programContentId == null) {
                programContentId = "";
            }
            wVar2.f19600a = programContentId;
            t9.u uVar = this.f17783c;
            StartPlayVODData data3 = startPlayVODResult.getData();
            t9.i.d(data3);
            List<EpisodeList> episodeList3 = data3.getEpisodeList();
            t9.i.d(episodeList3);
            Integer episodeNumber = episodeList3.get(0).getEpisodeNumber();
            if (episodeNumber != null) {
                i10 = episodeNumber.intValue();
            } else {
                i10 = -1;
            }
            uVar.f19598a = i10;
            StartPlayVODData data4 = startPlayVODResult.getData();
            t9.i.d(data4);
            List<EpisodeList> episodeList4 = data4.getEpisodeList();
            t9.i.d(episodeList4);
            List<TotalMovieList> totalMovieList = episodeList4.get(0).getTotalMovieList();
            t9.i.d(totalMovieList);
            for (TotalMovieList totalMovieList2 : totalMovieList) {
                hashMap2.put(totalMovieList2.getQuality(), totalMovieList2);
                if (com.mobile.brasiltv.utils.b0.I(totalMovieList2.getMovieList())) {
                    String quality = totalMovieList2.getQuality();
                    int hashCode = quality.hashCode();
                    if (hashCode != 1604548) {
                        if (hashCode != 1688155) {
                            if (hashCode == 46737913 && quality.equals("1080p")) {
                                hashMap.put("1080p", totalMovieList2);
                            }
                        } else if (quality.equals("720p")) {
                            hashMap.put("720p", totalMovieList2);
                        }
                    } else if (quality.equals("480p")) {
                        hashMap.put("480p", totalMovieList2);
                    }
                }
            }
            this.f17784d.N0(hashMap2);
            this.f17784d.H0(hashMap2);
            return hashMap;
        }
    }

    public static final class v extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f17785a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(g2 g2Var) {
            super(1);
            this.f17785a = g2Var;
        }

        /* renamed from: b */
        public final Boolean invoke(HashMap hashMap) {
            t9.i.g(hashMap, "map");
            boolean z10 = true;
            if (hashMap.isEmpty()) {
                g0.b.a(this.f17785a.f0(), (String) null, true, 1, (Object) null);
            } else {
                this.f17785a.N(hashMap);
            }
            if (hashMap.size() <= 0) {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class w extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17786a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g2 f17787b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(String str, g2 g2Var) {
            super(1);
            this.f17786a = str;
            this.f17787b = g2Var;
        }

        /* renamed from: b */
        public final Boolean invoke(HashMap hashMap) {
            t9.i.g(hashMap, "it");
            if (!t9.i.b(this.f17786a, this.f17787b.f17735h)) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
    }

    public static final class x extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f17788a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f17789b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ t9.w f17790c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f17791d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t9.u f17792e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t9.w f17793f;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17794a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17794a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f12639a;
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f17794a, yVar.m(), (String) null, 4, (Object) null));
            }
        }

        public x(g2 g2Var, boolean z10, t9.w wVar, String str, t9.u uVar, t9.w wVar2) {
            this.f17788a = g2Var;
            this.f17789b = z10;
            this.f17790c = wVar;
            this.f17791d = str;
            this.f17792e = uVar;
            this.f17793f = wVar2;
        }

        /* renamed from: f */
        public void onNext(HashMap hashMap) {
            t9.i.g(hashMap, "map");
            com.mobile.brasiltv.utils.b0.U(this, "点播鉴权成功 " + hashMap);
            this.f17788a.f0().u1(this.f17789b);
            this.f17788a.O0(hashMap);
            this.f17788a.s0(hashMap, (String) this.f17790c.f19600a, this.f17791d, this.f17792e.f19598a, (List) this.f17793f.f19600a);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.b0.U(this, "点播鉴权失败 " + str);
            g0.b.a(this.f17788a.f0(), str, false, 2, (Object) null);
            com.mobile.brasiltv.utils.x.f12622a.w(this.f17788a.S(), new a(str));
        }
    }

    public static final class y extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final y f17795a = new y();

        public y() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(Long l10) {
            t9.i.g(l10, "it");
            return Boolean.valueOf(r5.i.f19378a.I());
        }
    }

    public static final class z implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f17796a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HashMap f17797b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17798c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f17799d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17800e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f17801f;

        public z(g2 g2Var, HashMap hashMap, String str, String str2, int i10, List list) {
            this.f17796a = g2Var;
            this.f17797b = hashMap;
            this.f17798c = str;
            this.f17799d = str2;
            this.f17800e = i10;
            this.f17801f = list;
        }

        public void a(long j10) {
            Disposable A = this.f17796a.f17736i;
            if (A != null) {
                A.dispose();
            }
            this.f17796a.s0(this.f17797b, this.f17798c, this.f17799d, this.f17800e, this.f17801f);
        }

        public void onComplete() {
            r5.i iVar = r5.i.f19378a;
            iVar.K(true);
            iVar.L("32600");
            this.f17796a.s0(this.f17797b, this.f17798c, this.f17799d, this.f17800e, this.f17801f);
        }

        public void onError(Throwable th) {
            t9.i.g(th, "e");
        }

        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            a(((Number) obj).longValue());
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            this.f17796a.f17736i = disposable;
        }
    }

    public g2(f5.c cVar, g0 g0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(g0Var, "view");
        this.f17728a = cVar;
        this.f17729b = g0Var;
        g0Var.Y0(this);
        this.f17737j = new HashMap();
        this.f17738k = new HashMap();
        this.f17740m = "";
        this.f17741n = new ArrayList();
        this.f17742o = new HashMap();
    }

    public static final HashMap A0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (HashMap) lVar.invoke(obj);
    }

    public static final boolean B0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final boolean C0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final boolean K0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List Q(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean R(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List d0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean e0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List h0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean i0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final void j0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void k0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final AssetData p0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (AssetData) lVar.invoke(obj);
    }

    public static final GetItemDataResult r0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (GetItemDataResult) lVar.invoke(obj);
    }

    public static /* synthetic */ void t0(g2 g2Var, HashMap hashMap, String str, String str2, int i10, List list, int i11, Object obj) {
        int i12;
        if ((i11 & 8) != 0) {
            i12 = -1;
        } else {
            i12 = i10;
        }
        if ((i11 & 16) != 0) {
            list = null;
        }
        g2Var.s0(hashMap, str, str2, i12, list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0051, code lost:
        r5 = r5.getMovieList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void u0(java.util.HashMap r32, k6.g2 r33, java.lang.String r34, java.lang.String r35, t9.w r36, int r37, java.util.List r38, io.reactivex.ObservableEmitter r39) {
        /*
            r0 = r32
            r1 = r33
            r2 = r35
            r3 = r36
            r4 = r39
            java.lang.String r5 = "$map"
            t9.i.g(r0, r5)
            java.lang.String r5 = "this$0"
            t9.i.g(r1, r5)
            java.lang.String r5 = "$seriesContentId"
            r6 = r34
            t9.i.g(r6, r5)
            java.lang.String r5 = "$contentId"
            t9.i.g(r2, r5)
            java.lang.String r5 = "$program"
            t9.i.g(r3, r5)
            java.lang.String r5 = "it"
            t9.i.g(r4, r5)
            boolean r5 = r32.isEmpty()
            if (r5 == 0) goto L_0x0036
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r4.onNext(r0)
            return
        L_0x0036:
            f5.c r5 = r1.f17728a
            java.lang.String r7 = "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty"
            t9.i.e(r5, r7)
            com.mobile.brasiltv.activity.PlayAty r5 = (com.mobile.brasiltv.activity.PlayAty) r5
            o6.b r5 = r5.j3()
            java.lang.String r5 = r5.c()
            java.lang.Object r5 = r0.get(r5)
            mobile.com.requestframe.utils.response.TotalMovieList r5 = (mobile.com.requestframe.utils.response.TotalMovieList) r5
            r8 = 0
            r9 = 0
            if (r5 == 0) goto L_0x005e
            java.util.List r5 = r5.getMovieList()
            if (r5 == 0) goto L_0x005e
            java.lang.Object r5 = r5.get(r9)
            mobile.com.requestframe.utils.response.Movie r5 = (mobile.com.requestframe.utils.response.Movie) r5
            goto L_0x005f
        L_0x005e:
            r5 = r8
        L_0x005f:
            r1.G0(r5)
            r1.F0(r8)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            com.mobile.brasiltv.bean.SubtitleManager r10 = com.mobile.brasiltv.bean.SubtitleManager.INSTANCE
            int r10 = r10.getMGlobalAudioLanguage()
            java.lang.String r11 = "por"
            r12 = 1
            if (r10 == 0) goto L_0x0080
            if (r10 == r12) goto L_0x007e
            r13 = 2
            if (r10 == r13) goto L_0x007b
            goto L_0x0080
        L_0x007b:
            java.lang.String r11 = "spa"
            goto L_0x0080
        L_0x007e:
            java.lang.String r11 = "eng"
        L_0x0080:
            boolean r10 = android.text.TextUtils.isEmpty(r34)
            if (r10 == 0) goto L_0x0087
            r6 = r2
        L_0x0087:
            com.mobile.brasiltv.db.MobileDao r10 = r33.W()
            com.mobile.brasiltv.db.AudioSettingBean r6 = r10.queryAudioSetting(r6)
            java.util.Set r0 = r32.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r10 = 0
        L_0x0098:
            boolean r13 = r0.hasNext()
            if (r13 == 0) goto L_0x0288
            java.lang.Object r13 = r0.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r14 = r13.getKey()
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r13 = r13.getValue()
            mobile.com.requestframe.utils.response.TotalMovieList r13 = (mobile.com.requestframe.utils.response.TotalMovieList) r13
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.List r16 = r13.getMovieList()
            t9.i.d(r16)
            java.util.Iterator r22 = r16.iterator()
        L_0x00c0:
            boolean r16 = r22.hasNext()
            if (r16 == 0) goto L_0x020b
            java.lang.Object r16 = r22.next()
            r8 = r16
            mobile.com.requestframe.utils.response.Movie r8 = (mobile.com.requestframe.utils.response.Movie) r8
            java.util.List r16 = r8.getLicenseList()
            if (r16 == 0) goto L_0x00de
            boolean r16 = r16.isEmpty()
            if (r16 == 0) goto L_0x00db
            goto L_0x00de
        L_0x00db:
            r16 = 0
            goto L_0x00e0
        L_0x00de:
            r16 = 1
        L_0x00e0:
            if (r16 == 0) goto L_0x00e7
        L_0x00e2:
            r32 = r0
            r0 = r15
            goto L_0x0203
        L_0x00e7:
            java.util.List r12 = r8.getLicenseList()
            java.lang.String r23 = ""
            if (r12 == 0) goto L_0x0101
            java.lang.Object r12 = r12.get(r9)
            mobile.com.requestframe.utils.response.License r12 = (mobile.com.requestframe.utils.response.License) r12
            if (r12 == 0) goto L_0x0101
            java.lang.String r12 = r12.getLicense()
            if (r12 != 0) goto L_0x00fe
            goto L_0x0101
        L_0x00fe:
            r17 = r12
            goto L_0x0103
        L_0x0101:
            r17 = r23
        L_0x0103:
            java.util.List r12 = r8.getLicenseList()
            if (r12 == 0) goto L_0x011b
            java.lang.Object r12 = r12.get(r9)
            mobile.com.requestframe.utils.response.License r12 = (mobile.com.requestframe.utils.response.License) r12
            if (r12 == 0) goto L_0x011b
            java.lang.String r12 = r12.getTag()
            if (r12 != 0) goto L_0x0118
            goto L_0x011b
        L_0x0118:
            r9 = r38
            goto L_0x011f
        L_0x011b:
            r9 = r38
            r12 = r23
        L_0x011f:
            boolean r12 = r9.contains(r12)
            if (r12 == 0) goto L_0x00e2
            com.titan.ranger.bean.Media r12 = new com.titan.ranger.bean.Media
            java.lang.String r16 = r8.getContentId()
            if (r16 != 0) goto L_0x012f
            r16 = r23
        L_0x012f:
            java.lang.String r18 = r8.getAudioInfo()
            if (r18 != 0) goto L_0x0137
            r18 = r23
        L_0x0137:
            java.lang.String r19 = r8.getEncodeFormat()
            if (r19 != 0) goto L_0x0140
            r20 = r23
            goto L_0x0142
        L_0x0140:
            r20 = r19
        L_0x0142:
            java.lang.String r19 = r8.getVideoFormat()
            r32 = r0
            r0 = r15
            if (r19 != 0) goto L_0x014e
            r21 = r23
            goto L_0x0150
        L_0x014e:
            r21 = r19
        L_0x0150:
            r15 = r12
            r19 = r14
            r15.<init>(r16, r17, r18, r19, r20, r21)
            r5.add(r12)
            java.lang.String r12 = r8.getAudioInfo()
            if (r12 != 0) goto L_0x0162
            r15 = r23
            goto L_0x0163
        L_0x0162:
            r15 = r12
        L_0x0163:
            java.lang.String r12 = ","
            java.lang.String[] r16 = new java.lang.String[]{r12}
            r17 = 0
            r18 = 0
            r19 = 6
            r20 = 0
            java.util.List r12 = ba.t.M(r15, r16, r17, r18, r19, r20)
            java.util.Iterator r12 = r12.iterator()
            r28 = 0
        L_0x017b:
            boolean r15 = r12.hasNext()
            if (r15 == 0) goto L_0x0201
            java.lang.Object r15 = r12.next()
            int r16 = r28 + 1
            if (r28 >= 0) goto L_0x018c
            i9.j.j()
        L_0x018c:
            java.lang.String r15 = (java.lang.String) r15
            com.mobile.brasiltv.bean.AudioTrackBean r9 = new com.mobile.brasiltv.bean.AudioTrackBean
            java.lang.String r17 = r8.getContentId()
            if (r17 != 0) goto L_0x0199
            r25 = r23
            goto L_0x019b
        L_0x0199:
            r25 = r17
        L_0x019b:
            java.lang.String r17 = r8.getAudioInfo()
            if (r17 != 0) goto L_0x01a4
            r26 = r23
            goto L_0x01a6
        L_0x01a4:
            r26 = r17
        L_0x01a6:
            r29 = 0
            r30 = 16
            r31 = 0
            r24 = r9
            r27 = r15
            r24.<init>(r25, r26, r27, r28, r29, r30, r31)
            r34 = r10
            f5.c r10 = r1.f17728a
            t9.i.e(r10, r7)
            com.mobile.brasiltv.activity.PlayAty r10 = (com.mobile.brasiltv.activity.PlayAty) r10
            o6.b r10 = r10.j3()
            java.lang.String r10 = r10.c()
            boolean r10 = t9.i.b(r10, r14)
            if (r10 == 0) goto L_0x01f6
            com.mobile.brasiltv.bean.AudioTrackBean r10 = r33.U()
            if (r10 != 0) goto L_0x01f6
            if (r6 == 0) goto L_0x01d7
            java.lang.String r10 = r6.getAudioLanguage()
            goto L_0x01d8
        L_0x01d7:
            r10 = 0
        L_0x01d8:
            if (r10 == 0) goto L_0x01e3
            if (r6 == 0) goto L_0x01e1
            java.lang.String r10 = r6.getAudioLanguage()
            goto L_0x01e4
        L_0x01e1:
            r10 = 0
            goto L_0x01e4
        L_0x01e3:
            r10 = r11
        L_0x01e4:
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L_0x01f6
            r10 = 1
            r9.setSelected(r10)
            r1.F0(r9)
            r1.G0(r8)
            r10 = 1
            goto L_0x01f8
        L_0x01f6:
            r10 = r34
        L_0x01f8:
            r0.add(r9)
            r9 = r38
            r28 = r16
            goto L_0x017b
        L_0x0201:
            r34 = r10
        L_0x0203:
            r15 = r0
            r8 = 0
            r9 = 0
            r12 = 1
            r0 = r32
            goto L_0x00c0
        L_0x020b:
            r32 = r0
            r0 = r15
            f5.c r8 = r1.f17728a
            t9.i.e(r8, r7)
            com.mobile.brasiltv.activity.PlayAty r8 = (com.mobile.brasiltv.activity.PlayAty) r8
            o6.b r8 = r8.j3()
            java.lang.String r8 = r8.c()
            boolean r8 = t9.i.b(r8, r14)
            if (r8 == 0) goto L_0x0258
            com.mobile.brasiltv.bean.AudioTrackBean r8 = r33.U()
            if (r8 != 0) goto L_0x0258
            boolean r8 = r0.isEmpty()
            r9 = 1
            r8 = r8 ^ r9
            if (r8 == 0) goto L_0x0258
            if (r10 != 0) goto L_0x0258
            r8 = 0
            java.lang.Object r12 = r0.get(r8)
            com.mobile.brasiltv.bean.AudioTrackBean r12 = (com.mobile.brasiltv.bean.AudioTrackBean) r12
            r12.setSelected(r9)
            java.lang.Object r9 = r0.get(r8)
            com.mobile.brasiltv.bean.AudioTrackBean r9 = (com.mobile.brasiltv.bean.AudioTrackBean) r9
            r1.F0(r9)
            java.util.List r9 = r13.getMovieList()
            if (r9 == 0) goto L_0x0253
            java.lang.Object r9 = r9.get(r8)
            mobile.com.requestframe.utils.response.Movie r9 = (mobile.com.requestframe.utils.response.Movie) r9
            goto L_0x0254
        L_0x0253:
            r9 = 0
        L_0x0254:
            r1.G0(r9)
            goto L_0x0259
        L_0x0258:
            r8 = 0
        L_0x0259:
            java.util.HashMap r9 = r33.V()
            java.lang.Object r9 = r9.get(r14)
            java.util.Collection r9 = (java.util.Collection) r9
            if (r9 == 0) goto L_0x026e
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x026c
            goto L_0x026e
        L_0x026c:
            r9 = 0
            goto L_0x026f
        L_0x026e:
            r9 = 1
        L_0x026f:
            if (r9 == 0) goto L_0x0281
            boolean r9 = r0.isEmpty()
            r12 = 1
            r9 = r9 ^ r12
            if (r9 == 0) goto L_0x0282
            java.util.HashMap r9 = r33.V()
            r9.put(r14, r0)
            goto L_0x0282
        L_0x0281:
            r12 = 1
        L_0x0282:
            r0 = r32
            r8 = 0
            r9 = 0
            goto L_0x0098
        L_0x0288:
            boolean r0 = r5.isEmpty()
            r0 = r0 ^ r12
            if (r0 == 0) goto L_0x02b3
            mobile.com.requestframe.utils.response.Movie r0 = r33.X()
            if (r0 == 0) goto L_0x02b3
            r0 = r37
            com.titan.ranger.bean.Program r0 = r1.M(r2, r5, r0)
            r3.f19600a = r0
            i6.g0 r0 = r1.f17729b
            long r0 = r0.z1()
            java.lang.Object r2 = r3.f19600a
            t9.i.d(r2)
            com.titan.ranger.bean.Program r2 = (com.titan.ranger.bean.Program) r2
            r2.setStart(r0)
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r4.onNext(r0)
            goto L_0x02b8
        L_0x02b3:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r4.onNext(r0)
        L_0x02b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.g2.u0(java.util.HashMap, k6.g2, java.lang.String, java.lang.String, t9.w, int, java.util.List, io.reactivex.ObservableEmitter):void");
    }

    public static final void v0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void w0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean z0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public final void D0(String str) {
        PlayAty.a aVar = PlayAty.G;
        if (aVar.b().contains(str)) {
            aVar.b().remove(str);
        }
    }

    public void E0(String str, AssetData assetData) {
        t9.i.g(str, "contentId");
        t9.i.g(assetData, "program");
        this.f17730c = assetData;
    }

    public void F0(AudioTrackBean audioTrackBean) {
        this.f17743p = audioTrackBean;
    }

    public void G0(Movie movie) {
        this.f17739l = movie;
    }

    public final void H0(HashMap hashMap) {
        ArrayList arrayList = new ArrayList();
        if (hashMap.containsKey("1080p")) {
            Object obj = hashMap.get("1080p");
            t9.i.d(obj);
            if (com.mobile.brasiltv.utils.b0.I(((TotalMovieList) obj).getMovieList())) {
                arrayList.add(new o6.d("1080P", "1080p", true, true));
            } else {
                arrayList.add(new o6.d("1080P", "1080p", true, false));
            }
        }
        if (hashMap.containsKey("720p")) {
            Object obj2 = hashMap.get("720p");
            t9.i.d(obj2);
            if (com.mobile.brasiltv.utils.b0.I(((TotalMovieList) obj2).getMovieList())) {
                arrayList.add(new o6.d("720P", "720p", true, true));
            } else {
                arrayList.add(new o6.d("720P", "720p", true, false));
            }
        }
        if (hashMap.containsKey("480p")) {
            Object obj3 = hashMap.get("480p");
            t9.i.d(obj3);
            if (com.mobile.brasiltv.utils.b0.I(((TotalMovieList) obj3).getMovieList())) {
                arrayList.add(new o6.d("480P", "480p", false, true));
            } else {
                arrayList.add(new o6.d("480P", "480p", false, false));
            }
        }
        Y().clear();
        Y().addAll(arrayList);
    }

    public final void I0(String str, List list) {
        new a1().d(str, list);
    }

    public final void J0(HashMap hashMap, String str, String str2, int i10, List list) {
        Disposable disposable;
        Disposable disposable2 = this.f17736i;
        if (disposable2 != null) {
            t9.i.d(disposable2);
            if (!disposable2.isDisposed() && (disposable = this.f17736i) != null) {
                disposable.dispose();
            }
        }
        Observable.intervalRange(0, 45, 0, 2, TimeUnit.SECONDS).filter(new u1(y.f17795a)).compose(p0.a()).subscribe(new z(this, hashMap, str, str2, i10, list));
    }

    public final void L0(String str, VodSubEvent vodSubEvent) {
        w6.i.f9510g.b().L0(str, vodSubEvent.getData().getName(), vodSubEvent.getData().getContentId()).compose(this.f17728a.O1()).subscribe(new a0(this, vodSubEvent));
    }

    public final Program M(String str, List list, int i10) {
        String str2;
        String str3;
        String contentId;
        String name;
        String value = RangerPlayTag.VOD.getValue();
        AssetData assetData = this.f17730c;
        if (assetData == null || (name = assetData.getName()) == null) {
            str2 = "";
        } else {
            str2 = name;
        }
        String valueOf = String.valueOf(i10);
        String c10 = PlayAty.G.c();
        Movie X = X();
        if (X == null || (contentId = X.getContentId()) == null) {
            str3 = "";
        } else {
            str3 = contentId;
        }
        return new Program(str, value, str2, valueOf, c10, bd.f13853m, list, str3, 0);
    }

    public final void M0(VodSubEvent vodSubEvent) {
        w6.i.f9510g.b().X0(new int[]{vodSubEvent.getData().getSubscribeId()}).compose(this.f17728a.O1()).subscribe(new b0(this, vodSubEvent));
    }

    public final void N(HashMap hashMap) {
        f5.c cVar = this.f17728a;
        t9.i.e(cVar, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
        if (!hashMap.containsKey(((PlayAty) cVar).j3().c())) {
            f5.c cVar2 = this.f17728a;
            t9.i.e(cVar2, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
            if (t9.i.b(((PlayAty) cVar2).j3().c(), "480p")) {
                if (hashMap.containsKey("720p")) {
                    f5.c cVar3 = this.f17728a;
                    t9.i.e(cVar3, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                    ((PlayAty) cVar3).A3(o6.c.b());
                } else if (hashMap.containsKey("1080p")) {
                    f5.c cVar4 = this.f17728a;
                    t9.i.e(cVar4, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                    ((PlayAty) cVar4).A3(o6.c.a());
                }
            }
            f5.c cVar5 = this.f17728a;
            t9.i.e(cVar5, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
            if (t9.i.b(((PlayAty) cVar5).j3().c(), "720p")) {
                if (hashMap.containsKey("480p")) {
                    f5.c cVar6 = this.f17728a;
                    t9.i.e(cVar6, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                    ((PlayAty) cVar6).A3(o6.c.c());
                } else if (hashMap.containsKey("1080p")) {
                    f5.c cVar7 = this.f17728a;
                    t9.i.e(cVar7, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                    ((PlayAty) cVar7).A3(o6.c.a());
                }
            }
            f5.c cVar8 = this.f17728a;
            t9.i.e(cVar8, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
            if (t9.i.b(((PlayAty) cVar8).j3().c(), "1080p")) {
                if (hashMap.containsKey("720p")) {
                    f5.c cVar9 = this.f17728a;
                    t9.i.e(cVar9, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                    ((PlayAty) cVar9).A3(o6.c.b());
                } else if (hashMap.containsKey("480p")) {
                    f5.c cVar10 = this.f17728a;
                    t9.i.e(cVar10, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                    ((PlayAty) cVar10).A3(o6.c.c());
                }
            }
            MainAty.a aVar = MainAty.A;
            f5.c cVar11 = this.f17728a;
            t9.i.e(cVar11, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
            aVar.n(((PlayAty) cVar11).j3().b());
        }
    }

    public final void N0(HashMap hashMap) {
        Z().clear();
        Z().putAll(hashMap);
    }

    public void O() {
        Disposable disposable = this.f17731d;
        boolean z10 = false;
        if (disposable != null && !disposable.isDisposed()) {
            z10 = true;
        }
        if (z10) {
            Disposable disposable2 = this.f17731d;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.f17731d = null;
        }
    }

    public final void O0(HashMap hashMap) {
        a0().clear();
        a0().putAll(hashMap);
    }

    public final void P(String str) {
        t9.i.g(str, "contentId");
        w6.i.f9510g.b().f1(str).compose(this.f17728a.O1()).map(new v1(a.f17744a)).filter(new w1(b.f17748a)).subscribe(new c(this));
    }

    public final f5.c S() {
        return this.f17728a;
    }

    public final String T() {
        if (t9.i.b(Locale.getDefault().getLanguage(), "zh")) {
            return "zh";
        }
        return XML.DEFAULT_CONTENT_LANGUAGE;
    }

    public AudioTrackBean U() {
        return this.f17743p;
    }

    public HashMap V() {
        return this.f17742o;
    }

    public final MobileDao W() {
        return (MobileDao) this.f17734g.getValue();
    }

    public Movie X() {
        return this.f17739l;
    }

    public List Y() {
        return this.f17741n;
    }

    public HashMap Z() {
        return this.f17738k;
    }

    public void a(String str, String str2, int i10, String str3, String str4, boolean z10, boolean z11, boolean z12, String str5, int[] iArr, boolean z13) {
        t9.i.g(str, "programId");
        t9.i.g(str2, "contentId");
        t9.i.g(str3, "type");
        t9.i.g(str4, "vodQuality");
        this.f17735h = str2;
        x0(str, str2, i10, str3, str4, z10, z11, z12, str5, iArr, z13);
    }

    public HashMap a0() {
        return this.f17737j;
    }

    public AssetData b0() {
        return this.f17730c;
    }

    public final void c0(String str, String str2) {
        t9.i.g(str, "contentId");
        t9.i.g(str2, "type");
        w6.i.f9510g.b().O1(str, str2).compose(this.f17728a.O1()).map(new f2(d.f17753a)).filter(new p1(e.f17754a)).subscribe(new f(this));
    }

    public void e() {
    }

    public final g0 f0() {
        return this.f17729b;
    }

    public void g() {
    }

    public final void g0(List list, String str) {
        boolean z10;
        Disposable disposable = this.f17733f;
        if (disposable != null) {
            disposable.dispose();
        }
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f17729b.I0(new ArrayList());
            k7.f.f("no have sub", new Object[0]);
            return;
        }
        this.f17733f = Observable.just(list).subscribeOn(Schedulers.io()).compose(this.f17728a.O1()).map(new q1(new g(this, str))).filter(new r1(h.f17758a)).observeOn(AndroidSchedulers.mainThread()).subscribe(new s1(new i(this, str)), new t1(j.f17761a));
    }

    public void l0(String str, VodFavEvent vodFavEvent, boolean z10) {
        t9.i.g(str, "type");
        t9.i.g(vodFavEvent, "event");
        String hasFavorite = vodFavEvent.getData().getHasFavorite();
        if (t9.i.b(hasFavorite, "1")) {
            w6.i.f9510g.b().o1(new int[]{vodFavEvent.getData().getFavoriteId()}).subscribe(new k(this, vodFavEvent));
        } else if (t9.i.b(hasFavorite, "0")) {
            w6.i.f9510g.b().b1(str, i9.i.b(vodFavEvent.getData().getContentId()), z10).subscribe(new l(this, vodFavEvent));
        }
    }

    public void m0(String str, VodSubEvent vodSubEvent) {
        t9.i.g(str, "type");
        t9.i.g(vodSubEvent, "event");
        String hasSubscribe = vodSubEvent.getData().getHasSubscribe();
        if (t9.i.b(hasSubscribe, "0")) {
            if (q5.i.f19305a.j(this.f17728a)) {
                L0(str, vodSubEvent);
            } else {
                new MsgNotifyDialog(this.f17728a, 2).show();
            }
        } else if (t9.i.b(hasSubscribe, "1")) {
            M0(vodSubEvent);
        }
    }

    public final void n0() {
        this.f17729b.w2();
    }

    public void o0(String str, String str2, String str3, boolean z10) {
        t9.i.g(str, "contentId");
        t9.i.g(str2, "type");
        t9.i.g(str3, "programType");
        this.f17729b.G2();
        String T = T();
        com.mobile.brasiltv.utils.b0.U(this, "cur language environment: " + T);
        w6.i.f9510g.b().y1(str, str2, "0", T).map(new e2(m.f17768a)).compose(this.f17728a.O1()).subscribe(new n(this));
    }

    public void q0(ProgramSeason programSeason, String str) {
        t9.i.g(programSeason, "programSeason");
        t9.i.g(str, "vodType");
        w6.i.f9510g.b().y1(programSeason.getContentId(), str, "0", T()).map(new a2(o.f17771a)).compose(this.f17728a.O1()).subscribe(new p(this));
    }

    public final void s0(HashMap hashMap, String str, String str2, int i10, List list) {
        boolean z10;
        t9.i.g(hashMap, "map");
        t9.i.g(str, "contentId");
        t9.i.g(str2, "seriesContentId");
        r5.i iVar = r5.i.f19378a;
        List x10 = iVar.x(r5.k.VOD);
        if (x10 == null || x10.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            t9.w wVar = new t9.w();
            V().clear();
            Disposable disposable = this.f17732e;
            if (disposable != null) {
                disposable.dispose();
            }
            this.f17732e = Observable.create(new b2(hashMap, this, str2, str, wVar, i10, x10)).compose(this.f17728a.O1()).compose(p0.a()).subscribe(new c2(new r(wVar, this, str, list)), new d2(s.f17779a));
        } else if (!iVar.I()) {
            J0(hashMap, str, str2, i10, list);
        } else {
            com.mobile.brasiltv.utils.b0.U(this, "slb获取失败....");
            this.f17729b.d2();
        }
    }

    public final void x0(String str, String str2, int i10, String str3, String str4, boolean z10, boolean z11, boolean z12, String str5, int[] iArr, boolean z13) {
        y0(str, str2, i10, str3, str4, z10, z11, z12, str5, iArr, z13);
    }

    public final void y0(String str, String str2, int i10, String str3, String str4, boolean z10, boolean z11, boolean z12, String str5, int[] iArr, boolean z13) {
        Integer num;
        String str6;
        String str7 = str2;
        int i11 = i10;
        String str8 = str3;
        StringBuilder sb = new StringBuilder();
        sb.append("点播鉴权成功 = ");
        sb.append(z10);
        sb.append(" and isFree: ");
        sb.append(z11);
        sb.append(" and userIdentity = ");
        i.c cVar = w6.i.f9510g;
        sb.append(cVar.I());
        com.mobile.brasiltv.utils.b0.U(this, sb.toString());
        com.mobile.brasiltv.utils.b0.U(this, "auth program: contentId: " + str7 + " parentColumnId: " + i11 + " type: " + str8 + " vodQuality: " + str4);
        if (z12) {
            com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
            if (!hVar.h().isEmpty()) {
                H0(hVar.g());
                this.f17729b.u1(z13);
                O0(hVar.h());
                this.f17729b.D1();
                return;
            }
        }
        boolean z14 = z13;
        if (i11 == -1) {
            str6 = "1";
            num = null;
        } else {
            num = Integer.valueOf(i10);
            str6 = "0";
        }
        String str9 = t9.i.b(str8, "0") ? str : "";
        t9.w wVar = new t9.w();
        wVar.f19600a = "";
        t9.u uVar = new t9.u();
        uVar.f19598a = -1;
        t9.w wVar2 = new t9.w();
        cVar.b().m2(str6, num, str2, str9, str5, iArr).compose(this.f17728a.O1()).filter(new o1(new t(this))).map(new x1(new u(wVar2, wVar, uVar, this))).filter(new y1(new v(this))).filter(new z1(new w(str7, this))).observeOn(AndroidSchedulers.mainThread()).subscribe(new x(this, z13, wVar, str9, uVar, wVar2));
    }
}
