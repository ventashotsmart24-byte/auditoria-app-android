package com.mobile.brasiltv.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.AudioTrackBean;
import com.mobile.brasiltv.bean.BaseGuideManager;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.bean.event.CastPlaySuccessEvent;
import com.mobile.brasiltv.bean.event.CastToCloseOtherPlayEvent;
import com.mobile.brasiltv.bean.event.GoToSharingEvent;
import com.mobile.brasiltv.bean.event.RequestAuthEvent;
import com.mobile.brasiltv.bean.event.SelectedSeason;
import com.mobile.brasiltv.bean.event.ShowVodSharingGuideEvent;
import com.mobile.brasiltv.bean.event.VodFavEvent;
import com.mobile.brasiltv.bean.event.VodSubEvent;
import com.mobile.brasiltv.db.Album;
import com.mobile.brasiltv.db.VodDao;
import com.mobile.brasiltv.mine.activity.AccountBindAty;
import com.mobile.brasiltv.player.TitanPlayerController;
import com.mobile.brasiltv.player.view.ProgramActorInfoView;
import com.mobile.brasiltv.player.view.ProgramRecommendInfoView;
import com.mobile.brasiltv.player.view.ProgramSetInfoView;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.h;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.DivisionLineView;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.KoocanNestedScrollView;
import com.mobile.brasiltv.view.MarqueeTextView;
import com.mobile.brasiltv.view.adView.IAdShowControl;
import com.mobile.brasiltv.view.adView.SmallAdNativeContainer;
import com.mobile.brasiltv.view.adView.SmallAdNativeView;
import com.mobile.brasiltv.view.dialog.CommTipsDialog;
import com.mobile.brasiltv.view.dialog.GuideDialog;
import com.msandroid.mobile.R;
import com.titan.ranger.bean.Program;
import com.titans.widget.TitanVODView;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import f5.t2;
import f5.u2;
import f5.v2;
import f5.w2;
import f5.x2;
import f5.y2;
import g5.e1;
import h9.t;
import i6.f0;
import i6.g0;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.g2;
import k7.f;
import mobile.com.requestframe.utils.response.AssetData;
import mobile.com.requestframe.utils.response.Movie;
import mobile.com.requestframe.utils.response.SimpleProgramList;
import na.e;
import org.greenrobot.eventbus.ThreadMode;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

public final class PlayAty extends f5.d implements g0, m6.a {
    public static final a G = new a((g) null);
    public static String H = " ";
    public static String I = "";
    public static String J = "1";
    public static String K = "";
    public static ArrayList L = new ArrayList();
    public int A;
    public String B;
    public boolean C;
    public g2 D;
    public PopupWindow E;
    public Map F = new LinkedHashMap();

    /* renamed from: l  reason: collision with root package name */
    public VodDao f5972l = new VodDao(this);

    /* renamed from: m  reason: collision with root package name */
    public String f5973m = "";

    /* renamed from: n  reason: collision with root package name */
    public String f5974n = "";

    /* renamed from: o  reason: collision with root package name */
    public String f5975o = "";

    /* renamed from: p  reason: collision with root package name */
    public EnterType f5976p = EnterType.CATEGORY;

    /* renamed from: q  reason: collision with root package name */
    public String f5977q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f5978r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f5979s;

    /* renamed from: t  reason: collision with root package name */
    public int f5980t = -1;

    /* renamed from: u  reason: collision with root package name */
    public boolean f5981u;

    /* renamed from: v  reason: collision with root package name */
    public o6.b f5982v = o6.c.c();

    /* renamed from: w  reason: collision with root package name */
    public boolean f5983w;

    /* renamed from: x  reason: collision with root package name */
    public String f5984x = "";

    /* renamed from: y  reason: collision with root package name */
    public String f5985y = "";

    /* renamed from: z  reason: collision with root package name */
    public String f5986z = "";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a() {
            return PlayAty.H;
        }

        public final ArrayList b() {
            return PlayAty.L;
        }

        public final String c() {
            return PlayAty.K;
        }

        public final void d(String str) {
            i.g(str, "<set-?>");
            PlayAty.J = str;
        }
    }

    public static final class b implements SmallAdNativeView.NativeAdCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PlayAty f12088a;

        public b(PlayAty playAty) {
            this.f12088a = playAty;
        }

        public void onAttachNativeAd() {
            SmallAdNativeContainer smallAdNativeContainer = (SmallAdNativeContainer) this.f12088a.a3(R$id.adNativeView);
            if (smallAdNativeContainer != null) {
                smallAdNativeContainer.setVisibility(0);
            }
        }

        public void onCloseNativeAd() {
            SmallAdNativeContainer smallAdNativeContainer = (SmallAdNativeContainer) this.f12088a.a3(R$id.adNativeView);
            if (smallAdNativeContainer != null) {
                smallAdNativeContainer.setVisibility(8);
            }
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f12089a = new c();

        public c() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            Intent putExtra = intent.putExtra("from_type", "VOD");
            i.f(putExtra, "intent.putExtra(Constant…, Constant.FROM_TYPE_VOD)");
            return putExtra;
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PlayAty f12090a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(PlayAty playAty) {
            super(1);
            this.f12090a = playAty;
        }

        public final void b(CommTipsDialog commTipsDialog) {
            i.g(commTipsDialog, "it");
            commTipsDialog.dismiss();
            this.f12090a.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((CommTipsDialog) obj);
            return t.f17319a;
        }
    }

    public static final void D3(PlayAty playAty, boolean z10, String str) {
        String str2;
        i.g(playAty, "this$0");
        i.g(str, "$errorCode");
        ((AutoFrameLayout) playAty.a3(R$id.mPlayLoadingView)).setVisibility(8);
        if (z10) {
            str2 = playAty.getResources().getString(R.string.vod_no_media);
        } else {
            str2 = ma.j.a(playAty, str);
        }
        TitanPlayerController titanPlayerController = (TitanPlayerController) playAty.a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            i.f(str2, "errorMessage");
            titanPlayerController.B4(str2);
        }
    }

    public static final void F3(PlayAty playAty) {
        i.g(playAty, "this$0");
        Context Q1 = playAty.Q1();
        int i10 = R$id.mInfoView;
        String string = playAty.a3(i10).getContext().getString(R.string.sharing_guide_tips);
        i.f(string, "mInfoView.context.getStr…tring.sharing_guide_tips)");
        new BaseGuideManager(Q1, (AutoLinearLayout) ((ProgramActorInfoView) playAty.a3(i10).findViewById(R$id.mActorInfoView))._$_findCachedViewById(R$id.mShareLayout), "keyVodSharing", string, GuideDialog.Direction.TOP_RIGHT, (String) null, false, false, (String) null, 480, (g) null).showGuide();
    }

    public static final void m3(PlayAty playAty, View view) {
        i.g(playAty, "this$0");
        playAty.h3();
        TitanPlayerController titanPlayerController = (TitanPlayerController) playAty.a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            TitanPlayerController.l2(titanPlayerController, false, 1, (Object) null);
        }
    }

    public static final void o3(PlayAty playAty, View view) {
        i.g(playAty, "this$0");
        i1.N(playAty.Q1());
        b0.c0(playAty, AccountBindAty.class);
    }

    public static final void s3(PlayAty playAty, String str) {
        i.g(playAty, "this$0");
        i.g(str, "$contentId");
        playAty.G2();
        g2 i32 = playAty.S2();
        h hVar = h.f12562a;
        AssetData d10 = hVar.d();
        i.d(d10);
        i32.E0(str, d10);
        AssetData d11 = hVar.d();
        i.d(d11);
        playAty.E3(d11);
    }

    public static /* synthetic */ void u3(PlayAty playAty, String str, int i10, String str2, String str3, int[] iArr, int i11, Object obj) {
        String str4;
        int[] iArr2;
        if ((i11 & 8) != 0) {
            str4 = null;
        } else {
            str4 = str3;
        }
        if ((i11 & 16) != 0) {
            iArr2 = null;
        } else {
            iArr2 = iArr;
        }
        playAty.t3(str, i10, str2, str4, iArr2);
    }

    public static final void w3(PlayAty playAty) {
        g7.b bVar;
        i.g(playAty, "this$0");
        PopupWindow popupWindow = playAty.E;
        if (popupWindow instanceof g7.b) {
            bVar = (g7.b) popupWindow;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.a(1.0f);
        }
        playAty.E = null;
    }

    public final void A3(o6.b bVar) {
        i.g(bVar, "<set-?>");
        this.f5982v = bVar;
    }

    /* renamed from: B3 */
    public void Y0(f0 f0Var) {
        i.g(f0Var, "presenter");
    }

    public final void C3() {
        String string = getString(R.string.cast_wifi_not_connect_tips);
        i.f(string, "getString(R.string.cast_wifi_not_connect_tips)");
        new CommTipsDialog(this, string, getString(R.string.cast), getString(R.string.cast_wifi_setting), (String) null, (String) null, new d(this), (l) null, false, 432, (g) null).show();
    }

    public void D1() {
    }

    public void D2(HashMap hashMap, AudioTrackBean audioTrackBean) {
        i.g(hashMap, "audioInfoMap");
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            titanPlayerController.S3((ArrayList) hashMap.get(this.f5982v.c()), audioTrackBean);
        }
    }

    public void E0(String str, boolean z10) {
        i.g(str, "errorCode");
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            titanPlayerController.post(new x2(this, z10, str));
        }
    }

    public void E3(AssetData assetData) {
        i.g(assetData, "program");
        p3(this.f5978r);
        ((KoocanEmptyView) a3(R$id.mPlayEmptyView)).setVisibility(8);
        ((AutoFrameLayout) a3(R$id.mPlayLoadingView)).setVisibility(8);
        a3(R$id.mInfoView).setVisibility(0);
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            TitanPlayerController.u2(titanPlayerController, this.f5972l, assetData, this.f5973m, this.f5976p, this.f5977q, this.f5978r, false, 64, (Object) null);
        }
        int i10 = R$id.mActorInfoView;
        ((ProgramActorInfoView) a3(i10)).d(assetData);
        ((ProgramActorInfoView) a3(i10)).h(this.f5972l, assetData, this.f5973m, this.f5981u);
        ((ProgramActorInfoView) a3(i10)).m(assetData);
    }

    public void G1(List list) {
        i.g(list, "t");
        int i10 = R$id.mProgramRecommendInfo;
        ((ProgramRecommendInfoView) a3(i10)).f(this.f5978r);
        ((ProgramRecommendInfoView) a3(i10)).c(list);
    }

    public void G2() {
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            titanPlayerController.P1();
        }
    }

    public final void G3() {
        ((KoocanNestedScrollView) a3(R$id.mScroller)).scrollTo(0, 0);
    }

    public final void H3(AssetData assetData) {
        ((ProgramActorInfoView) a3(R$id.mActorInfoView)).k(assetData);
        if (this.f5978r && i.b(assetData.getHasFavorite(), "1")) {
            f1.a.j(f1.f12517a, Q1(), R.string.vod_fav_bl_success, 0, 4, (Object) null);
        }
    }

    public void I0(List list) {
        i.g(list, "list");
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            titanPlayerController.setSubData(list);
        }
    }

    public final void I3(AssetData assetData) {
        ((ProgramActorInfoView) a3(R$id.mActorInfoView)).l(assetData);
    }

    public void N0(AssetData assetData) {
        i.g(assetData, "program");
        ((AutoFrameLayout) a3(R$id.mPlayLoadingView)).setVisibility(8);
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            titanPlayerController.s2(this.f5972l, assetData, this.f5973m, this.f5976p, this.f5977q, this.f5978r, false);
        }
        int i10 = R$id.mActorInfoView;
        ((ProgramActorInfoView) a3(i10)).d(assetData);
        ((ProgramActorInfoView) a3(i10)).g(this.f5972l, assetData, this.f5973m, this.f5981u);
        ((ProgramActorInfoView) a3(i10)).m(assetData);
    }

    public void N2() {
        super.N2();
        S2().O();
    }

    public void R2() {
        z3(new g2(this, this));
        l3();
        ((KoocanEmptyView) a3(R$id.mPlayEmptyView)).setBackground(0);
        Intent intent = getIntent();
        i.f(intent, "intent");
        k3(intent);
        r3(this.f5975o, this.f5974n, (AssetData) null);
    }

    public void T1(String str, Program program) {
        Program program2;
        TitanVODView titanVODView;
        TitanVODView titanVODView2;
        TitanVODView titanVODView3;
        i.g(str, "contentId");
        i.g(program, "program");
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(i10);
        if (titanPlayerController != null) {
            titanPlayerController.W4(str);
        }
        TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
        if (titanPlayerController2 != null) {
            titanPlayerController2.X4(S2().a0());
        }
        h hVar = h.f12562a;
        Program program3 = null;
        if (!hVar.o()) {
            int i11 = R$id.mVideoViewVod;
            n8.b titanContext = ((TitanVODView) a3(i11)).getTitanContext();
            if (titanContext != null) {
                program3 = titanContext.a();
            }
            if (!(program3 == null || (titanVODView3 = (TitanVODView) a3(i11)) == null)) {
                titanVODView3.C();
            }
            TitanPlayerController titanPlayerController3 = (TitanPlayerController) a3(i10);
            if (titanPlayerController3 != null) {
                titanPlayerController3.b3();
            }
            ((TitanVODView) a3(i11)).B(program, str, program.getBuss());
            TitanPlayerController titanPlayerController4 = (TitanPlayerController) a3(i10);
            if (titanPlayerController4 != null) {
                Movie X = S2().X();
                i.d(X);
                titanPlayerController4.T2(X);
                return;
            }
            return;
        }
        TitanPlayerController titanPlayerController5 = (TitanPlayerController) a3(i10);
        if (titanPlayerController5 != null) {
            TitanPlayerController.V1(titanPlayerController5, false, false, 2, (Object) null);
        }
        int i12 = R$id.mVideoViewVod;
        n8.b titanContext2 = ((TitanVODView) a3(i12)).getTitanContext();
        if (titanContext2 != null) {
            program2 = titanContext2.h();
        } else {
            program2 = null;
        }
        if (!(program2 == null || (titanVODView2 = (TitanVODView) a3(i12)) == null)) {
            titanVODView2.D();
        }
        n8.b titanContext3 = ((TitanVODView) a3(i12)).getTitanContext();
        if (titanContext3 != null) {
            program3 = titanContext3.a();
        }
        if (!(program3 == null || (titanVODView = (TitanVODView) a3(i12)) == null)) {
            titanVODView.C();
        }
        TitanPlayerController titanPlayerController6 = (TitanPlayerController) a3(i10);
        if (titanPlayerController6 != null) {
            titanPlayerController6.c3();
        }
        ((TitanVODView) a3(i12)).v(program, program.getBuss());
        hVar.K(false);
    }

    public int T2() {
        return R.layout.aty_play;
    }

    public void W0(AssetData assetData) {
        i.g(assetData, "data");
        H3(assetData);
    }

    public View a3(int i10) {
        Map map = this.F;
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

    @xa.j
    public final void castPlayEvent(CastPlaySuccessEvent castPlaySuccessEvent) {
        i.g(castPlaySuccessEvent, "event");
        y3();
    }

    public void d0(AssetData assetData) {
        i.g(assetData, "program");
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            TitanPlayerController.k3(titanPlayerController, 0, 1, (Object) null);
        }
        e.f19075a = true;
        Intent intent = new Intent(this, PlayAty.class);
        intent.putExtra("extra_switch_season", true);
        intent.putExtra(g0.f17324b0.j(), this.f5973m);
        intent.putExtra("extra_program", assetData);
        v3(intent);
    }

    public void d2() {
        boolean z10;
        String z11 = r5.i.f19378a.z();
        if (z11.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            z11 = "20900";
        }
        String str = z11;
        y yVar = y.f12639a;
        String c10 = yVar.c(str);
        c2.d dVar = c2.d.f4594a;
        String str2 = H;
        String str3 = e.f19076b;
        i.f(str3, "dcsMark");
        dVar.g("", str2, str3, yVar.n(), "", c10, str, "apk");
        f1.f12517a.x(c10 + ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER + x.f12622a.y(Q1(), R.string.failed_ec5));
    }

    public void f0(AssetData assetData) {
        i.g(assetData, "data");
        I3(assetData);
    }

    public final void f3(int i10, int i11) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i10, i11);
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            titanPlayerController.setLayoutParams(layoutParams);
        }
        f.c("playerWindow redraw", new Object[0]);
        ((TitanVODView) a3(R$id.mVideoViewVod)).requestLayout();
    }

    public void g0(boolean z10) {
        O2(z10);
    }

    public final void g3() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2 = this.E;
        boolean z10 = false;
        if (popupWindow2 != null && popupWindow2.isShowing()) {
            z10 = true;
        }
        if (z10 && (popupWindow = this.E) != null) {
            popupWindow.dismiss();
        }
        ((ProgramSetInfoView) a3(R$id.mProgramSetInfoView)).h();
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void goToSharing(GoToSharingEvent goToSharingEvent) {
        i.g(goToSharingEvent, "event");
        i1.I(Q1(), "vodDetail");
        b0.j0(this, w6.i.f9510g.C() + "/#/shareApp", false, true, false, false, 24, (Object) null);
    }

    public final void h() {
        G3();
        a3(R$id.mInfoView).setVisibility(8);
        ((AutoFrameLayout) a3(R$id.mPlayLoadingView)).setVisibility(0);
    }

    public final void h3() {
        boolean z10;
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(i10);
        if (titanPlayerController == null || !titanPlayerController.B2()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            try {
                Field declaredField = NestedScrollView.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                Object obj = declaredField.get((KoocanNestedScrollView) a3(R$id.mScroller));
                if (obj instanceof OverScroller) {
                    Method declaredMethod = OverScroller.class.getDeclaredMethod("forceFinished", new Class[]{Boolean.TYPE});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke((OverScroller) obj, new Object[]{Boolean.TRUE});
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else if (!this.C) {
            TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
            if (titanPlayerController2 != null) {
                titanPlayerController2.o2();
            }
            this.C = true;
        }
    }

    @xa.j
    public final void handleRequestAuth(RequestAuthEvent requestAuthEvent) {
        String str;
        o6.b bVar;
        i.g(requestAuthEvent, "event");
        if (!requestAuthEvent.isVideoStop() && this.f5983w) {
            S2().a0().clear();
            if (requestAuthEvent.isCast()) {
                h hVar = h.f12562a;
                if (i.b(hVar.f(), "480p")) {
                    bVar = o6.c.c();
                } else if (i.b(hVar.f(), "720p")) {
                    bVar = o6.c.b();
                } else {
                    bVar = o6.c.a();
                }
                this.f5982v = bVar;
            }
            int i10 = R$id.mVodPlayer;
            TitanPlayerController titanPlayerController = (TitanPlayerController) a3(i10);
            if (titanPlayerController != null) {
                titanPlayerController.setVodQualityVisibility(8);
            }
            TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
            if (titanPlayerController2 != null) {
                titanPlayerController2.setVodSubtitleAudioVisibility(8);
            }
            H = requestAuthEvent.getData().getName();
            f0.a.a(S2(), this.f5975o, requestAuthEvent.getData().getContentId(), this.f5980t, this.f5973m, this.f5982v.c(), this.f5978r, this.f5979s, requestAuthEvent.isCast(), (String) null, (int[]) null, false, 1792, (Object) null);
            if (i.b("movie", this.f5974n) || i.b("1", this.f5973m)) {
                str = "";
            } else {
                str = String.valueOf(requestAuthEvent.getIndex());
            }
            I = str;
        }
    }

    @xa.j
    public final void handleVodFavorite(VodFavEvent vodFavEvent) {
        i.g(vodFavEvent, "event");
        if (this.f5983w) {
            S2().l0(this.f5973m, vodFavEvent, this.f5978r);
        }
    }

    @xa.j
    public final void handleVodSubscribe(VodSubEvent vodSubEvent) {
        i.g(vodSubEvent, "event");
        if (this.f5983w) {
            S2().m0(this.f5973m, vodSubEvent);
        }
    }

    public void i0() {
        f1.a.j(f1.f12517a, this, R.string.vod_sub_success, 0, 4, (Object) null);
    }

    /* renamed from: i3 */
    public g2 S2() {
        g2 g2Var = this.D;
        if (g2Var != null) {
            return g2Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final o6.b j3() {
        return this.f5982v;
    }

    public void k2() {
        n2();
    }

    public final void k3(Intent intent) {
        o6.b bVar;
        TitanPlayerController titanPlayerController;
        g0.a aVar = g0.f17324b0;
        String stringExtra = intent.getStringExtra(aVar.g());
        if (stringExtra == null) {
            stringExtra = "";
        }
        K = stringExtra;
        String stringExtra2 = intent.getStringExtra(aVar.j());
        if (stringExtra2 == null) {
            stringExtra2 = "1";
        }
        this.f5973m = stringExtra2;
        String stringExtra3 = intent.getStringExtra(aVar.f());
        if (stringExtra3 == null) {
            stringExtra3 = "movie";
        }
        this.f5974n = stringExtra3;
        String stringExtra4 = intent.getStringExtra(aVar.a());
        if (stringExtra4 == null) {
            stringExtra4 = " ";
        }
        this.f5975o = stringExtra4;
        this.f5976p = (EnterType) intent.getSerializableExtra(aVar.b());
        String stringExtra5 = intent.getStringExtra(aVar.i());
        if (stringExtra5 == null) {
            stringExtra5 = null;
        }
        this.f5977q = stringExtra5;
        this.f5978r = intent.getBooleanExtra(aVar.c(), false);
        this.f5979s = intent.getBooleanExtra(aVar.d(), false);
        this.f5980t = intent.getIntExtra(aVar.e(), -1);
        this.f5981u = intent.getBooleanExtra(aVar.k(), false);
        this.B = intent.getStringExtra(aVar.h());
        h hVar = h.f12562a;
        if (hVar.o() && !hVar.s() && i.b(this.f5975o, hVar.b())) {
            this.f5981u = true;
        }
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
        if (titanPlayerController2 != null) {
            titanPlayerController2.A2(this.f5979s);
        }
        TitanPlayerController titanPlayerController3 = (TitanPlayerController) a3(i10);
        if (titanPlayerController3 != null) {
            titanPlayerController3.setVodFuncCallback(this);
        }
        int e10 = MainAty.A.e();
        if (e10 == 1) {
            bVar = o6.c.c();
        } else if (e10 == 2) {
            bVar = o6.c.b();
        } else if (e10 != 3) {
            bVar = o6.c.c();
        } else {
            bVar = o6.c.a();
        }
        this.f5982v = bVar;
        TitanPlayerController titanPlayerController4 = (TitanPlayerController) a3(i10);
        if (titanPlayerController4 != null) {
            titanPlayerController4.setVodQualityVisibility(8);
        }
        TitanPlayerController titanPlayerController5 = (TitanPlayerController) a3(i10);
        if (titanPlayerController5 != null) {
            titanPlayerController5.setVodQualityVisibility(8);
        }
        e.f19075a = true;
        q3();
        n3();
        if (this.f5981u && (titanPlayerController = (TitanPlayerController) a3(i10)) != null) {
            TitanPlayerController.V1(titanPlayerController, false, false, 2, (Object) null);
        }
    }

    public final void l3() {
        int a10 = n5.a.f8310a.a(this);
        int percentHeightSize = AutoUtils.getPercentHeightSize(88);
        AutoRelativeLayout.LayoutParams layoutParams = new AutoRelativeLayout.LayoutParams(percentHeightSize, percentHeightSize);
        layoutParams.setMargins(0, a10, 0, 0);
        int i10 = R$id.mNavBack;
        ((ImageView) a3(i10)).setLayoutParams(layoutParams);
        ((ImageView) a3(i10)).setOnClickListener(new u2(this));
    }

    public void m() {
        String str;
        String mDetailDataContentId;
        SimpleProgramList curPlayProgram;
        g2 i32 = S2();
        HashMap a02 = S2().a0();
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(i10);
        String str2 = "";
        if (titanPlayerController == null || (curPlayProgram = titanPlayerController.getCurPlayProgram()) == null || (str = curPlayProgram.getContentId()) == null) {
            str = str2;
        }
        TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
        if (!(titanPlayerController2 == null || (mDetailDataContentId = titanPlayerController2.getMDetailDataContentId()) == null)) {
            str2 = mDetailDataContentId;
        }
        g2.t0(i32, a02, str, str2, 0, (List) null, 24, (Object) null);
    }

    public final void n3() {
        if (!d6.b.f6366a.y() || !this.f5979s) {
            ((MarqueeTextView) a3(R$id.mTvBindTip)).setVisibility(8);
            return;
        }
        int i10 = R$id.mTvBindTip;
        ((MarqueeTextView) a3(i10)).setVisibility(0);
        ((MarqueeTextView) a3(i10)).setOnClickListener(new v2(this));
    }

    public void onBackPressed() {
        h3();
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            TitanPlayerController.l2(titanPlayerController, false, 1, (Object) null);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        i.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (((TitanVODView) a3(R$id.mVideoViewVod)) == null) {
            f1.f12517a.w(R.string.exit_and_retry_text);
            return;
        }
        getResources().getConfiguration().orientation = configuration.orientation;
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(i10);
        if (titanPlayerController != null) {
            titanPlayerController.Q1(configuration);
        }
        if (configuration.orientation == 2) {
            TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
            if (titanPlayerController2 != null) {
                titanPlayerController2.setRatioEnable(false);
            }
            f3(-1, -1);
            ((ImageView) a3(R$id.mNavBack)).setVisibility(8);
        } else {
            TitanPlayerController titanPlayerController3 = (TitanPlayerController) a3(i10);
            if (titanPlayerController3 != null) {
                titanPlayerController3.setRatioEnable(true);
            }
            f3(-1, AutoUtils.getPercentHeightSize(448));
            ((ImageView) a3(R$id.mNavBack)).setVisibility(0);
        }
        g3();
    }

    public void onDestroy() {
        super.onDestroy();
        if (!this.C) {
            TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
            if (titanPlayerController != null) {
                titanPlayerController.o2();
            }
            this.C = true;
        }
        e.f19075a = false;
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        h hVar = h.f12562a;
        if (i.b(hVar.a(), hVar.k())) {
            if (i10 != 24) {
                if (i10 == 25 && ((AutoLinearLayout) a3(R$id.llCastContainer)).getVisibility() == 0) {
                    com.mobile.brasiltv.utils.g0.f12538a.o();
                    return true;
                }
            } else if (((AutoLinearLayout) a3(R$id.llCastContainer)).getVisibility() == 0) {
                com.mobile.brasiltv.utils.g0.f12538a.a();
                return true;
            }
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public void onNewIntent(Intent intent) {
        i.g(intent, "intent");
        super.onNewIntent(intent);
        v3(intent);
    }

    public void onPause() {
        TitanPlayerController titanPlayerController;
        super.onPause();
        this.f5983w = false;
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
        if (titanPlayerController2 != null) {
            titanPlayerController2.p2();
        }
        if (!this.f5981u && (titanPlayerController = (TitanPlayerController) a3(i10)) != null) {
            TitanPlayerController.k3(titanPlayerController, 0, 1, (Object) null);
        }
        if (getResources().getConfiguration().orientation == 2) {
            getResources().getConfiguration().orientation = 1;
            setRequestedOrientation(1);
        }
    }

    public void onResume() {
        Program program;
        String str;
        String str2;
        String mDetailDataContentId;
        SimpleProgramList curPlayProgram;
        super.onResume();
        this.f5983w = true;
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(i10);
        if (titanPlayerController != null) {
            titanPlayerController.q2();
        }
        h hVar = h.f12562a;
        if (!hVar.o() && !hVar.p()) {
            n8.b titanContext = ((TitanVODView) a3(R$id.mVideoViewVod)).getTitanContext();
            if (titanContext != null) {
                program = titanContext.h();
            } else {
                program = null;
            }
            if (program == null) {
                g2 i32 = S2();
                HashMap a02 = S2().a0();
                TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
                if (titanPlayerController2 == null || (curPlayProgram = titanPlayerController2.getCurPlayProgram()) == null || (str = curPlayProgram.getContentId()) == null) {
                    str = "";
                }
                TitanPlayerController titanPlayerController3 = (TitanPlayerController) a3(i10);
                if (titanPlayerController3 == null || (mDetailDataContentId = titanPlayerController3.getMDetailDataContentId()) == null) {
                    str2 = "";
                } else {
                    str2 = mDetailDataContentId;
                }
                g2.t0(i32, a02, str, str2, 0, (List) null, 24, (Object) null);
            }
        }
        hVar.x(false);
        ((ProgramActorInfoView) a3(R$id.mActorInfoView)).setIsResumed(true);
        this.C = false;
    }

    public void onStop() {
        super.onStop();
        ((ProgramActorInfoView) a3(R$id.mActorInfoView)).setIsResumed(false);
        Log.e("TAG-FIX", "onStop--2");
    }

    public final void p3(boolean z10) {
        b0.U(this, "ProgramInfoView isCr " + z10);
        int i10 = R$id.mProgramRecommendInfo;
        ((ProgramRecommendInfoView) a3(i10)).clearAnimation();
        if (z10) {
            ((ProgramRecommendInfoView) a3(i10)).setVisibility(0);
            ((DivisionLineView) a3(R$id.mProgramInfoLine)).setVisibility(0);
            return;
        }
        ((ProgramRecommendInfoView) a3(i10)).setVisibility(0);
        ((DivisionLineView) a3(R$id.mProgramInfoLine)).setVisibility(0);
    }

    public final void q3() {
        int i10 = R$id.adNativeView;
        SmallAdNativeContainer smallAdNativeContainer = (SmallAdNativeContainer) a3(i10);
        if (smallAdNativeContainer != null) {
            smallAdNativeContainer.setNativeAdCallback(new b(this));
        }
        a6.a aVar = a6.a.f10646a;
        if (aVar.s()) {
            SmallAdNativeContainer smallAdNativeContainer2 = (SmallAdNativeContainer) a3(i10);
            if (smallAdNativeContainer2 != null) {
                String string = Q1().getString(R.string.vod_detail_ad_id);
                i.f(string, "context.getString(R.string.vod_detail_ad_id)");
                smallAdNativeContainer2.loadAd(new e1(string, aVar.r(), (IAdShowControl) null, true, 4, (g) null), this.f5978r);
                return;
            }
            return;
        }
        SmallAdNativeContainer smallAdNativeContainer3 = (SmallAdNativeContainer) a3(i10);
        if (smallAdNativeContainer3 != null) {
            String string2 = Q1().getString(R.string.vod_detail_ad_id);
            i.f(string2, "context.getString(R.string.vod_detail_ad_id)");
            smallAdNativeContainer3.loadOwn(new e1(string2, aVar.r(), (IAdShowControl) null, true, 4, (g) null), this.f5978r);
        }
    }

    public final void r3(String str, String str2, AssetData assetData) {
        if (!TextUtils.isEmpty(ha.b.f17320a.a())) {
            h();
            if (this.f5981u && h.f12562a.d() != null) {
                new Handler().post(new w2(this, str));
            } else if (assetData != null) {
                G2();
                S2().E0(str, assetData);
                E3(assetData);
            } else if (i.b("1", this.f5973m)) {
                this.f5984x = str;
                this.f5985y = String.valueOf(this.f5977q);
                this.f5986z = String.valueOf(this.f5977q);
                this.A = 0;
                u3(this, str, 0, String.valueOf(this.f5977q), (String) null, (int[]) null, 24, (Object) null);
            } else {
                x3(str);
            }
            if (this.f5978r) {
                S2().P(str);
            } else {
                S2().c0(str, this.f5973m);
            }
        }
    }

    @xa.j
    public final void selectedSeason(SelectedSeason selectedSeason) {
        i.g(selectedSeason, "event");
        if (this.f5983w) {
            S2().q0(selectedSeason.getProgramSeason(), this.f5973m);
        }
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void showVodSharingGuide(ShowVodSharingGuideEvent showVodSharingGuideEvent) {
        i.g(showVodSharingGuideEvent, "event");
        a3(R$id.mInfoView).post(new t2(this));
    }

    public void t0(View view, boolean z10, boolean z11) {
        i.g(view, "qualityView");
        List Y = S2().Y();
        if (!Y.isEmpty()) {
            String string = getResources().getString(R.string.popup_quality_title);
            i.f(string, "resources.getString(R.string.popup_quality_title)");
            int i10 = 0;
            int i11 = 0;
            for (Object next : Y) {
                int i12 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                if (i.b(((o6.d) next).c(), this.f5982v.c())) {
                    i11 = i10;
                }
                i10 = i12;
            }
            if (z10) {
                n6.c cVar = new n6.c(false);
                g7.j jVar = new g7.j(this, string, cVar);
                cVar.b(i11);
                cVar.addData(Y);
                jVar.m(this, 5);
                this.E = jVar;
            } else {
                n6.b bVar = new n6.b(false);
                g7.d dVar = new g7.d(this, string, bVar);
                bVar.c(i11);
                bVar.addData(Y);
                dVar.c(true);
                this.E = dVar;
            }
            PopupWindow popupWindow = this.E;
            if (popupWindow != null) {
                popupWindow.setOnDismissListener(new y2(this));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t3(java.lang.String r64, int r65, java.lang.String r66, java.lang.String r67, int[] r68) {
        /*
            r63 = this;
            r0 = r63
            r1 = r66
            r11 = r68
            java.lang.String r2 = "programId"
            r3 = r64
            t9.i.g(r3, r2)
            java.lang.String r2 = "name"
            t9.i.g(r1, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            mobile.com.requestframe.utils.response.PosterList r4 = new mobile.com.requestframe.utils.response.PosterList
            r4.<init>()
            a7.d r5 = a7.d.f10697a
            java.lang.String r5 = r5.g()
            r4.setFileType(r5)
            java.lang.String r5 = r0.B
            r4.setFileUrl(r5)
            r2.add(r4)
            r4 = 1
            r5 = 0
            if (r11 == 0) goto L_0x003c
            int r6 = r11.length
            if (r6 != 0) goto L_0x0036
            r6 = 1
            goto L_0x0037
        L_0x0036:
            r6 = 0
        L_0x0037:
            r6 = r6 ^ r4
            if (r6 != r4) goto L_0x003c
            r6 = 1
            goto L_0x003d
        L_0x003c:
            r6 = 0
        L_0x003d:
            if (r6 == 0) goto L_0x0044
            r4 = r11[r5]
            r19 = r4
            goto L_0x0046
        L_0x0044:
            r19 = 1
        L_0x0046:
            mobile.com.requestframe.utils.response.SimpleProgramList r4 = new mobile.com.requestframe.utils.response.SimpleProgramList
            r12 = r4
            java.lang.String r13 = r0.f5984x
            java.lang.String r14 = r0.f5985y
            java.lang.String r15 = ""
            java.lang.String r16 = ""
            java.lang.String r17 = ""
            java.lang.String r18 = ""
            r20 = 0
            java.lang.String r21 = ""
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 14336(0x3800, float:2.0089E-41)
            r28 = 0
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            int r6 = com.mobile.brasiltv.R$id.mVodPlayer
            android.view.View r7 = r0.a3(r6)
            com.mobile.brasiltv.player.TitanPlayerController r7 = (com.mobile.brasiltv.player.TitanPlayerController) r7
            if (r7 == 0) goto L_0x007d
            int r8 = r0.A
            com.mobile.brasiltv.db.VodDao r9 = r0.f5972l
            java.lang.String r10 = r0.f5973m
            r7.V3(r8, r9, r4, r10)
        L_0x007d:
            java.util.ArrayList r4 = new java.util.ArrayList
            r60 = r4
            r4.<init>()
            mobile.com.requestframe.utils.response.SimpleProgramList r7 = new mobile.com.requestframe.utils.response.SimpleProgramList
            r12 = r7
            java.lang.String r13 = r0.f5975o
            java.lang.String r14 = r0.f5985y
            java.lang.String r15 = ""
            java.lang.String r16 = ""
            java.lang.String r17 = ""
            java.lang.String r18 = ""
            r19 = 1
            r20 = 1
            java.lang.String r21 = ""
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 14336(0x3800, float:2.0089E-41)
            r28 = 0
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r4.add(r7)
            mobile.com.requestframe.utils.response.AssetData r4 = new mobile.com.requestframe.utils.response.AssetData
            r29 = r4
            java.lang.String r7 = r0.f5975o
            r30 = r7
            java.lang.String r7 = r0.f5985y
            r31 = r7
            java.lang.String r32 = ""
            java.lang.String r33 = ""
            java.lang.String r34 = ""
            java.lang.String r35 = ""
            java.lang.String r36 = ""
            java.lang.String r37 = ""
            r38 = 0
            r39 = 0
            java.lang.String r7 = r0.f5986z
            r40 = r7
            java.lang.String r41 = ""
            java.lang.String r42 = ""
            java.lang.String r43 = ""
            java.lang.String r44 = ""
            r45 = 0
            java.lang.String r46 = ""
            java.lang.String r47 = ""
            java.lang.String r48 = ""
            java.lang.String r49 = ""
            java.lang.String r50 = ""
            r51 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            java.lang.String r55 = ""
            java.lang.String r56 = ""
            java.lang.String r57 = ""
            java.lang.String r58 = ""
            java.lang.String r59 = ""
            r62 = 0
            r61 = r2
            r29.<init>(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62)
            boolean r2 = r0.f5978r
            r0.p3(r2)
            int r2 = com.mobile.brasiltv.R$id.mPlayEmptyView
            android.view.View r2 = r0.a3(r2)
            com.mobile.brasiltv.view.KoocanEmptyView r2 = (com.mobile.brasiltv.view.KoocanEmptyView) r2
            r7 = 8
            r2.setVisibility(r7)
            int r2 = com.mobile.brasiltv.R$id.mInfoView
            android.view.View r2 = r0.a3(r2)
            r2.setVisibility(r5)
            android.view.View r2 = r0.a3(r6)
            com.mobile.brasiltv.player.TitanPlayerController r2 = (com.mobile.brasiltv.player.TitanPlayerController) r2
            if (r2 == 0) goto L_0x0120
            r2.t2(r4)
        L_0x0120:
            k6.g2 r2 = r63.S2()
            java.lang.String r4 = r0.f5975o
            java.lang.String r5 = r0.f5973m
            java.lang.String r8 = r0.f5974n
            boolean r9 = r0.f5978r
            r2.o0(r4, r5, r8, r9)
            k6.g2 r2 = r63.S2()
            java.util.HashMap r2 = r2.a0()
            r2.clear()
            boolean r2 = r0.f5981u
            if (r2 == 0) goto L_0x0168
            com.mobile.brasiltv.utils.h r2 = com.mobile.brasiltv.utils.h.f12562a
            java.lang.String r4 = r2.f()
            java.lang.String r5 = "480p"
            boolean r4 = t9.i.b(r4, r5)
            if (r4 == 0) goto L_0x0151
            o6.b r2 = o6.c.c()
            goto L_0x0166
        L_0x0151:
            java.lang.String r2 = r2.f()
            java.lang.String r4 = "720p"
            boolean r2 = t9.i.b(r2, r4)
            if (r2 == 0) goto L_0x0162
            o6.b r2 = o6.c.b()
            goto L_0x0166
        L_0x0162:
            o6.b r2 = o6.c.a()
        L_0x0166:
            r0.f5982v = r2
        L_0x0168:
            android.view.View r2 = r0.a3(r6)
            com.mobile.brasiltv.player.TitanPlayerController r2 = (com.mobile.brasiltv.player.TitanPlayerController) r2
            if (r2 == 0) goto L_0x0173
            r2.setVodQualityVisibility(r7)
        L_0x0173:
            android.view.View r2 = r0.a3(r6)
            com.mobile.brasiltv.player.TitanPlayerController r2 = (com.mobile.brasiltv.player.TitanPlayerController) r2
            if (r2 == 0) goto L_0x017e
            r2.setVodSubtitleAudioVisibility(r7)
        L_0x017e:
            H = r1
            k6.g2 r1 = r63.S2()
            java.lang.String r2 = r0.f5975o
            int r4 = r0.f5980t
            java.lang.String r5 = r0.f5973m
            o6.b r6 = r0.f5982v
            java.lang.String r6 = r6.c()
            boolean r7 = r0.f5978r
            boolean r8 = r0.f5979s
            boolean r9 = r0.f5981u
            r12 = 1
            r3 = r64
            r10 = r67
            r11 = r68
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            java.lang.String r1 = "movie"
            java.lang.String r2 = r0.f5974n
            boolean r1 = t9.i.b(r1, r2)
            if (r1 != 0) goto L_0x01ba
            java.lang.String r1 = "1"
            java.lang.String r2 = r0.f5973m
            boolean r1 = t9.i.b(r1, r2)
            if (r1 == 0) goto L_0x01b5
            goto L_0x01ba
        L_0x01b5:
            java.lang.String r1 = java.lang.String.valueOf(r65)
            goto L_0x01bc
        L_0x01ba:
            java.lang.String r1 = ""
        L_0x01bc:
            I = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.activity.PlayAty.t3(java.lang.String, int, java.lang.String, java.lang.String, int[]):void");
    }

    public void u1(boolean z10) {
        TitanPlayerController titanPlayerController;
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
        if (titanPlayerController2 != null) {
            titanPlayerController2.a2();
        }
        if (z10 && (titanPlayerController = (TitanPlayerController) a3(i10)) != null) {
            titanPlayerController.I4();
        }
    }

    public final void v3(Intent intent) {
        k3(intent);
        int i10 = R$id.mVodPlayer;
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(i10);
        if (titanPlayerController != null) {
            titanPlayerController.Z1();
        }
        TitanPlayerController titanPlayerController2 = (TitanPlayerController) a3(i10);
        if (titanPlayerController2 != null) {
            titanPlayerController2.e3();
        }
        ((TitanVODView) a3(R$id.mVideoViewVod)).D();
        if (intent.getBooleanExtra("extra_switch_season", false)) {
            Serializable serializableExtra = intent.getSerializableExtra("extra_program");
            i.e(serializableExtra, "null cannot be cast to non-null type mobile.com.requestframe.utils.response.AssetData");
            AssetData assetData = (AssetData) serializableExtra;
            this.f5975o = assetData.getContentId();
            String programType = assetData.getProgramType();
            this.f5974n = programType;
            r3(this.f5975o, programType, assetData);
            return;
        }
        r3(this.f5975o, this.f5974n, (AssetData) null);
    }

    public void w2() {
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            titanPlayerController.T3();
        }
    }

    public final void x3(String str) {
        int[] iArr;
        Album queryRecordInfo = this.f5972l.queryRecordInfo(str);
        if (queryRecordInfo != null) {
            iArr = new int[]{queryRecordInfo.getSeriesNumber()};
        } else {
            queryRecordInfo = new Album();
            queryRecordInfo.setPlayContentId(str);
            queryRecordInfo.setContentId(str);
            queryRecordInfo.setPlayName(this.f5977q);
            queryRecordInfo.setAlias(this.f5977q);
            queryRecordInfo.setPlayIndex(0);
            iArr = null;
        }
        this.f5984x = String.valueOf(queryRecordInfo.getPlayContentId());
        this.f5985y = String.valueOf(queryRecordInfo.getPlayName());
        this.f5986z = String.valueOf(queryRecordInfo.getAlias());
        int playIndex = queryRecordInfo.getPlayIndex();
        this.A = playIndex;
        t3(this.f5984x, playIndex, this.f5985y, "1", iArr);
    }

    public void y0(String str) {
        i.g(str, "errorCode");
        j1.h(this, str);
        ((AutoFrameLayout) a3(R$id.mPlayLoadingView)).setVisibility(8);
        int i10 = R$id.mPlayEmptyView;
        ((KoocanEmptyView) a3(i10)).changeType(KoocanEmptyView.Type.NO_DISCUSS);
        String string = getResources().getString(R.string.vod_program_exception);
        i.f(string, "resources.getString(R.st…ng.vod_program_exception)");
        ((KoocanEmptyView) a3(i10)).setTip(string);
        ((KoocanEmptyView) a3(i10)).setVisibility(0);
        a3(R$id.mInfoView).setVisibility(8);
    }

    public final void y3() {
        h hVar = h.f12562a;
        hVar.M(this.f5973m);
        hVar.J(this.f5974n);
        hVar.y(this.f5975o);
        hVar.A(this.f5976p);
        hVar.L(this.f5977q);
        hVar.z(this.f5978r);
        hVar.B(this.f5979s);
        hVar.I(this.f5980t);
        hVar.D(S2().b0());
        hVar.F(S2().X());
        hVar.G(this.f5982v.c());
        hVar.h().clear();
        hVar.h().putAll(S2().a0());
        hVar.g().putAll(S2().Z());
    }

    public void z(View view, boolean z10, Movie movie) {
        i.g(view, "castView");
        if (!b8.a.f11196a.c(this)) {
            C3();
        } else {
            xa.c.c().j(new CastToCloseOtherPlayEvent("VOD", false, 2, (g) null));
            b0.d0(this, CastByNativeDeviceAty.class, c.f12089a);
        }
        i1.g(this, "EVENT_CAST_VOD_CLICK");
    }

    public long z1() {
        TitanPlayerController titanPlayerController = (TitanPlayerController) a3(R$id.mVodPlayer);
        if (titanPlayerController != null) {
            return titanPlayerController.V2();
        }
        return 0;
    }

    public void z3(g2 g2Var) {
        i.g(g2Var, "<set-?>");
        this.D = g2Var;
    }
}
