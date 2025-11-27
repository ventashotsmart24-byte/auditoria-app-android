package com.mobile.brasiltv.player;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.Settings;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b8.a;
import com.advertlib.bean.AdInfo;
import com.advertlib.bean.AdInfoWrapper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.common.images.WebImage;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.CastByNativeDeviceAty;
import com.mobile.brasiltv.activity.PlayAty;
import com.mobile.brasiltv.bean.AudioTrackBean;
import com.mobile.brasiltv.bean.BaseGuideManager;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.bean.GuideNextClickListener;
import com.mobile.brasiltv.bean.NoSubTitleData;
import com.mobile.brasiltv.bean.OffSubTitleData;
import com.mobile.brasiltv.bean.RecordSubtitleInfoBean;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.bean.SubTitleData;
import com.mobile.brasiltv.bean.SubtitleManager;
import com.mobile.brasiltv.bean.SubtitleStyleBean;
import com.mobile.brasiltv.bean.VodGestureGuideManager;
import com.mobile.brasiltv.bean.event.CastPlaySuccessEvent;
import com.mobile.brasiltv.bean.event.CastToCloseFloatViewEvent;
import com.mobile.brasiltv.bean.event.CastToCloseOtherPlayEvent;
import com.mobile.brasiltv.bean.event.CastToPlayEvent;
import com.mobile.brasiltv.bean.event.GoogleCastToPlayEvent;
import com.mobile.brasiltv.bean.event.NetworkEvent;
import com.mobile.brasiltv.bean.event.PlaySetIndexEvent;
import com.mobile.brasiltv.bean.event.ShowVodSharingGuideEvent;
import com.mobile.brasiltv.bean.event.SubTitleDownloadFinishEvent;
import com.mobile.brasiltv.bean.event.UpdateRecordAtyEvent;
import com.mobile.brasiltv.db.AudioSettingBean;
import com.mobile.brasiltv.db.Links;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SubtitleSettingBean;
import com.mobile.brasiltv.db.VodDao;
import com.mobile.brasiltv.mine.activity.AccountBindAty;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.g;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.view.AlphaRelativeLayout;
import com.mobile.brasiltv.view.CurTimeSeekBar;
import com.mobile.brasiltv.view.GridDecoration;
import com.mobile.brasiltv.view.GridLayoutManagerWrapper;
import com.mobile.brasiltv.view.RatioFrameLayout;
import com.mobile.brasiltv.view.adView.BeforeVodAdView;
import com.mobile.brasiltv.view.adView.PauseAdView;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.mobile.brasiltv.view.dialog.GuideDialog;
import com.mobile.brasiltv.view.dialog.feedback.CastFeedBackDialog;
import com.mobile.brasiltv.view.dialog.feedback.FeedBackDialog;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.titan.cast.bean.Device;
import com.titan.ranger.Status;
import com.titan.ranger.bean.Media;
import com.titan.ranger.bean.Program;
import com.titans.widget.TitanVODView;
import com.umeng.analytics.pro.q;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import g7.n;
import g7.p;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import m6.a1;
import m6.b1;
import m6.c1;
import m6.d1;
import m6.e1;
import m6.f1;
import m6.g1;
import m6.h1;
import m6.j1;
import m6.k1;
import m6.l1;
import m6.m1;
import m6.n1;
import m6.o1;
import m6.p1;
import m6.q1;
import m6.r1;
import m6.s1;
import m6.t1;
import m6.u1;
import m6.v1;
import m6.w0;
import m6.x0;
import m6.y0;
import m6.z0;
import mobile.com.requestframe.utils.response.AssetData;
import mobile.com.requestframe.utils.response.Movie;
import mobile.com.requestframe.utils.response.PosterList;
import mobile.com.requestframe.utils.response.SimpleProgramList;
import mobile.com.requestframe.utils.response.TotalMovieList;
import org.greenrobot.eventbus.ThreadMode;
import q5.j;
import tv.danmaku.ijk.media.player.misc.IjkMediaFormat;
import w6.i;
import z5.c;

public final class TitanPlayerController extends RatioFrameLayout implements g.b, c.e, c.d, p8.a, o8.a {
    public PauseAdView A;
    public CommonDialog A0;
    public String B;
    public Disposable B0;
    public long C;
    public Disposable C0;
    public boolean D;
    public boolean D0;
    public boolean E;
    public Program E0;
    public boolean F;
    public boolean F0;
    public boolean G;
    public String G0;
    public boolean H;
    public Integer H0;
    public boolean I;
    public boolean I0;
    public long J;
    public boolean J0;
    public boolean K;
    public final h9.g K0;
    public b L;
    public int L0;
    public m6.a M;
    public Float M0;
    public z5.c N;
    public Map N0;
    public String O;
    public Disposable Q;
    public boolean S;
    public boolean V;
    public boolean W;

    /* renamed from: a  reason: collision with root package name */
    public final TitanPlayerController f6101a;

    /* renamed from: b  reason: collision with root package name */
    public final h9.g f6102b;

    /* renamed from: c  reason: collision with root package name */
    public q5.j f6103c;

    /* renamed from: d  reason: collision with root package name */
    public b8.b f6104d;

    /* renamed from: e  reason: collision with root package name */
    public VodDao f6105e;

    /* renamed from: f  reason: collision with root package name */
    public AssetData f6106f;

    /* renamed from: f0  reason: collision with root package name */
    public boolean f6107f0;

    /* renamed from: g  reason: collision with root package name */
    public HashMap f6108g;

    /* renamed from: g0  reason: collision with root package name */
    public boolean f6109g0;

    /* renamed from: h  reason: collision with root package name */
    public Movie f6110h;

    /* renamed from: h0  reason: collision with root package name */
    public boolean f6111h0;

    /* renamed from: i  reason: collision with root package name */
    public SimpleProgramList f6112i;

    /* renamed from: i0  reason: collision with root package name */
    public long f6113i0;

    /* renamed from: j  reason: collision with root package name */
    public EnterType f6114j;

    /* renamed from: j0  reason: collision with root package name */
    public int f6115j0;

    /* renamed from: k  reason: collision with root package name */
    public String f6116k;

    /* renamed from: k0  reason: collision with root package name */
    public int f6117k0;

    /* renamed from: l  reason: collision with root package name */
    public boolean f6118l;

    /* renamed from: l0  reason: collision with root package name */
    public int f6119l0;

    /* renamed from: m  reason: collision with root package name */
    public boolean f6120m;

    /* renamed from: m0  reason: collision with root package name */
    public boolean f6121m0;

    /* renamed from: n  reason: collision with root package name */
    public int f6122n;

    /* renamed from: n0  reason: collision with root package name */
    public int f6123n0;

    /* renamed from: o  reason: collision with root package name */
    public int f6124o;

    /* renamed from: o0  reason: collision with root package name */
    public String f6125o0;

    /* renamed from: p  reason: collision with root package name */
    public String f6126p;

    /* renamed from: p0  reason: collision with root package name */
    public boolean f6127p0;

    /* renamed from: q  reason: collision with root package name */
    public String f6128q;

    /* renamed from: q0  reason: collision with root package name */
    public String f6129q0;

    /* renamed from: r  reason: collision with root package name */
    public boolean f6130r;

    /* renamed from: r0  reason: collision with root package name */
    public final h9.g f6131r0;

    /* renamed from: s  reason: collision with root package name */
    public List f6132s;

    /* renamed from: s0  reason: collision with root package name */
    public final h9.g f6133s0;

    /* renamed from: t  reason: collision with root package name */
    public boolean f6134t;

    /* renamed from: t0  reason: collision with root package name */
    public AudioTrackBean f6135t0;

    /* renamed from: u  reason: collision with root package name */
    public final h9.g f6136u;

    /* renamed from: u0  reason: collision with root package name */
    public boolean f6137u0;

    /* renamed from: v  reason: collision with root package name */
    public final h9.g f6138v;

    /* renamed from: v0  reason: collision with root package name */
    public long f6139v0;

    /* renamed from: w  reason: collision with root package name */
    public final h9.g f6140w;

    /* renamed from: w0  reason: collision with root package name */
    public int f6141w0;

    /* renamed from: x  reason: collision with root package name */
    public boolean f6142x;

    /* renamed from: x0  reason: collision with root package name */
    public final NoSubTitleData f6143x0;

    /* renamed from: y  reason: collision with root package name */
    public boolean f6144y;

    /* renamed from: y0  reason: collision with root package name */
    public final OffSubTitleData f6145y0;

    /* renamed from: z  reason: collision with root package name */
    public Links f6146z;

    /* renamed from: z0  reason: collision with root package name */
    public final AudioTrackBean f6147z0;

    public static final class a extends b8.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12406e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TitanPlayerController titanPlayerController, f5.c cVar) {
            super(cVar);
            this.f12406e = titanPlayerController;
        }

        public void f(int i10) {
            if (this.f12406e._$_findCachedViewById(R$id.mLlVolumeController).getVisibility() == 0) {
                ProgressBar progressBar = (ProgressBar) this.f12406e._$_findCachedViewById(R$id.mPbVolume);
                int i11 = i10 * 100;
                b8.b Y0 = this.f12406e.f6104d;
                if (Y0 == null) {
                    t9.i.w("mVoiceHelper");
                    Y0 = null;
                }
                progressBar.setProgress(i11 / Y0.e());
            }
        }
    }

    public static final class a0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f12407a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f12408b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArrayList f12409c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12410d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a0(List list, ArrayList arrayList, ArrayList arrayList2, TitanPlayerController titanPlayerController) {
            super(1);
            this.f12407a = list;
            this.f12408b = arrayList;
            this.f12409c = arrayList2;
            this.f12410d = titanPlayerController;
        }

        public final void b(SubtitleSettingBean subtitleSettingBean) {
            boolean z10;
            if (subtitleSettingBean.getSubtitleLanguage().length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                List list = this.f12407a;
                ArrayList arrayList = this.f12409c;
                ArrayList arrayList2 = this.f12408b;
                TitanPlayerController titanPlayerController = this.f12410d;
                int i10 = 0;
                for (Object next : list) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        i9.j.j();
                    }
                    if (t9.i.b(((SubTitleData) next).getLanguage(), subtitleSettingBean.getSubtitleLanguage())) {
                        arrayList.add(Integer.valueOf(i10));
                        if (subtitleSettingBean.getSubtitleIndex() == i10) {
                            arrayList2.add(Integer.valueOf(i10));
                            titanPlayerController.f6115j0 = i10;
                        }
                    }
                    i10 = i11;
                }
                if (this.f12408b.isEmpty()) {
                    if (com.mobile.brasiltv.utils.b0.I(this.f12409c)) {
                        TitanPlayerController titanPlayerController2 = this.f12410d;
                        Object obj = this.f12409c.get(0);
                        t9.i.f(obj, "sameLanguage[0]");
                        titanPlayerController2.f6115j0 = ((Number) obj).intValue();
                    } else {
                        this.f12410d.f6115j0 = 0;
                    }
                }
            } else {
                int mGlobalLanguage = SubtitleManager.INSTANCE.getMGlobalLanguage();
                String str = "pt";
                if (mGlobalLanguage != 0) {
                    if (mGlobalLanguage == 1) {
                        str = XML.DEFAULT_CONTENT_LANGUAGE;
                    } else if (mGlobalLanguage == 2) {
                        str = "es";
                    }
                }
                List list2 = this.f12407a;
                TitanPlayerController titanPlayerController3 = this.f12410d;
                int i12 = 0;
                for (Object next2 : list2) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        i9.j.j();
                    }
                    if (t9.i.b(((SubTitleData) next2).getLanguage(), str)) {
                        titanPlayerController3.f6115j0 = i12;
                    }
                    i12 = i13;
                }
            }
            if (this.f12410d.f6115j0 == -1) {
                this.f12410d.f6115j0 = 0;
            }
            SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
            String mDetailDataContentId = this.f12410d.getMDetailDataContentId();
            String str2 = "";
            if (mDetailDataContentId == null) {
                mDetailDataContentId = str2;
            }
            subtitleManager.putSelectSubtitle(mDetailDataContentId, this.f12410d.f6115j0, subtitleSettingBean.getSubtitleLanguage());
            LruCache<String, Boolean> mLruCacheSwitch = subtitleManager.getMLruCacheSwitch();
            String mDetailDataContentId2 = this.f12410d.getMDetailDataContentId();
            if (mDetailDataContentId2 != null) {
                str2 = mDetailDataContentId2;
            }
            mLruCacheSwitch.put(str2, Boolean.valueOf(!TextUtils.isEmpty(subtitleSettingBean.getSubtitleLanguage())));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SubtitleSettingBean) obj);
            return h9.t.f17319a;
        }
    }

    public enum b {
        NONE,
        VOLUME,
        BRIGHTNESS,
        FF_REW
    }

    public static final class b0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final b0 f12416a = new b0();

        public b0() {
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

    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12417a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f12418b;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|33) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|33) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0066 */
        static {
            /*
                com.mobile.brasiltv.player.TitanPlayerController$b[] r0 = com.mobile.brasiltv.player.TitanPlayerController.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.mobile.brasiltv.player.TitanPlayerController$b r2 = com.mobile.brasiltv.player.TitanPlayerController.b.VOLUME     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.mobile.brasiltv.player.TitanPlayerController$b r3 = com.mobile.brasiltv.player.TitanPlayerController.b.BRIGHTNESS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.mobile.brasiltv.player.TitanPlayerController$b r4 = com.mobile.brasiltv.player.TitanPlayerController.b.FF_REW     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                com.mobile.brasiltv.player.TitanPlayerController$b r5 = com.mobile.brasiltv.player.TitanPlayerController.b.NONE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f12417a = r0
                com.mobile.brasiltv.bean.EnterType[] r0 = com.mobile.brasiltv.bean.EnterType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.mobile.brasiltv.bean.EnterType r5 = com.mobile.brasiltv.bean.EnterType.HOME     // Catch:{ NoSuchFieldError -> 0x003c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                com.mobile.brasiltv.bean.EnterType r1 = com.mobile.brasiltv.bean.EnterType.CATEGORY     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                com.mobile.brasiltv.bean.EnterType r1 = com.mobile.brasiltv.bean.EnterType.RECOMMEND     // Catch:{ NoSuchFieldError -> 0x004c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                com.mobile.brasiltv.bean.EnterType r1 = com.mobile.brasiltv.bean.EnterType.BANNER     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                com.mobile.brasiltv.bean.EnterType r1 = com.mobile.brasiltv.bean.EnterType.TOPIC     // Catch:{ NoSuchFieldError -> 0x005d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                com.mobile.brasiltv.bean.EnterType r1 = com.mobile.brasiltv.bean.EnterType.HISTORY     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                com.mobile.brasiltv.bean.EnterType r1 = com.mobile.brasiltv.bean.EnterType.SEARCH     // Catch:{ NoSuchFieldError -> 0x006f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                f12418b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.player.TitanPlayerController.c.<clinit>():void");
        }
    }

    public static final class c0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12419a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f12420b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArrayList f12421c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ArrayList f12422d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c0(TitanPlayerController titanPlayerController, List list, ArrayList arrayList, ArrayList arrayList2) {
            super(1);
            this.f12419a = titanPlayerController;
            this.f12420b = list;
            this.f12421c = arrayList;
            this.f12422d = arrayList2;
        }

        public final void b(SubtitleSettingBean subtitleSettingBean) {
            boolean z10;
            String str;
            Integer num;
            boolean z11;
            if (subtitleSettingBean.getSubtitleSwitch().length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f12419a.f6121m0 = subtitleSettingBean.getSubtitleSwitch().equals("true");
            } else {
                this.f12419a.f6121m0 = SubtitleManager.INSTANCE.getMGlobalSwitch();
            }
            SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
            LruCache<String, Boolean> mLruCacheSwitch = subtitleManager.getMLruCacheSwitch();
            String mDetailDataContentId = this.f12419a.getMDetailDataContentId();
            String str2 = "";
            if (mDetailDataContentId == null) {
                mDetailDataContentId = str2;
            }
            mLruCacheSwitch.put(mDetailDataContentId, Boolean.valueOf(this.f12419a.f6121m0));
            if (this.f12419a.f6121m0) {
                HashMap<String, RecordSubtitleInfoBean> mLruCacheLanguages = subtitleManager.getMLruCacheLanguages();
                AssetData data = this.f12419a.getData();
                if (data == null || (str = data.getContentId()) == null) {
                    str = str2;
                }
                RecordSubtitleInfoBean recordSubtitleInfoBean = mLruCacheLanguages.get(str);
                if (recordSubtitleInfoBean != null) {
                    num = Integer.valueOf(recordSubtitleInfoBean.getSubtitleIndex());
                } else {
                    num = null;
                }
                if (num == null || num.intValue() >= this.f12420b.size()) {
                    if (subtitleSettingBean.getSubtitleLanguage().length() > 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        List list = this.f12420b;
                        ArrayList arrayList = this.f12422d;
                        ArrayList arrayList2 = this.f12421c;
                        TitanPlayerController titanPlayerController = this.f12419a;
                        int i10 = 0;
                        for (Object next : list) {
                            int i11 = i10 + 1;
                            if (i10 < 0) {
                                i9.j.j();
                            }
                            if (t9.i.b(((SubTitleData) next).getLanguage(), subtitleSettingBean.getSubtitleLanguage())) {
                                arrayList.add(Integer.valueOf(i10));
                                if (subtitleSettingBean.getSubtitleIndex() == i10) {
                                    arrayList2.add(Integer.valueOf(i10));
                                    titanPlayerController.f6115j0 = i10;
                                }
                            }
                            i10 = i11;
                        }
                        if (this.f12421c.isEmpty()) {
                            if (com.mobile.brasiltv.utils.b0.I(this.f12422d)) {
                                TitanPlayerController titanPlayerController2 = this.f12419a;
                                Object obj = this.f12422d.get(0);
                                t9.i.f(obj, "sameLanguage[0]");
                                titanPlayerController2.f6115j0 = ((Number) obj).intValue();
                            } else {
                                this.f12419a.f6115j0 = 0;
                            }
                        }
                    } else {
                        int mGlobalLanguage = subtitleManager.getMGlobalLanguage();
                        String str3 = "pt";
                        if (mGlobalLanguage != 0) {
                            if (mGlobalLanguage == 1) {
                                str3 = XML.DEFAULT_CONTENT_LANGUAGE;
                            } else if (mGlobalLanguage == 2) {
                                str3 = "es";
                            }
                        }
                        List list2 = this.f12420b;
                        TitanPlayerController titanPlayerController3 = this.f12419a;
                        int i12 = 0;
                        for (Object next2 : list2) {
                            int i13 = i12 + 1;
                            if (i12 < 0) {
                                i9.j.j();
                            }
                            if (t9.i.b(((SubTitleData) next2).getLanguage(), str3)) {
                                titanPlayerController3.f6115j0 = i12;
                            }
                            i12 = i13;
                        }
                    }
                    if (this.f12419a.f6115j0 == -1) {
                        this.f12419a.f6115j0 = 0;
                    }
                } else {
                    this.f12419a.f6115j0 = num.intValue();
                }
            }
            SubtitleManager subtitleManager2 = SubtitleManager.INSTANCE;
            String mDetailDataContentId2 = this.f12419a.getMDetailDataContentId();
            if (mDetailDataContentId2 != null) {
                str2 = mDetailDataContentId2;
            }
            subtitleManager2.putSelectSubtitle(str2, this.f12419a.f6115j0, subtitleSettingBean.getSubtitleLanguage());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SubtitleSettingBean) obj);
            return h9.t.f17319a;
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12423a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f12424b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f12425c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(TitanPlayerController titanPlayerController, Context context, long j10) {
            super(1);
            this.f12423a = titanPlayerController;
            this.f12424b = context;
            this.f12425c = j10;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f17319a;
        }

        public final void invoke(String str) {
            this.f12423a.G0 = p6.a.f19299a.a(this.f12424b, (int) this.f12425c);
        }
    }

    public static final class d0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final d0 f12426a = new d0();

        public d0() {
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

    public static final class e extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12427a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(TitanPlayerController titanPlayerController) {
            super(1);
            this.f12427a = titanPlayerController;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Long l10) {
            ((AutoFrameLayout) this.f12427a._$_findCachedViewById(R$id.mLayoutSetInfo)).setVisibility(8);
        }
    }

    public static final class e0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12428a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e0(TitanPlayerController titanPlayerController) {
            super(1);
            this.f12428a = titanPlayerController;
        }

        public final void b(SubtitleSettingBean subtitleSettingBean) {
            if (subtitleSettingBean.getSubtitleSize() != -1) {
                this.f12428a.f6117k0 = subtitleSettingBean.getSubtitleSize();
            } else {
                this.f12428a.f6117k0 = SubtitleManager.INSTANCE.getMGlobalSize();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SubtitleSettingBean) obj);
            return h9.t.f17319a;
        }
    }

    public static final class f extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final f f12429a = new f();

        public f() {
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

    public static final class f0 extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12430a;

        public f0(TitanPlayerController titanPlayerController) {
            this.f12430a = titanPlayerController;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            t9.i.g(motionEvent, "e");
            if (!this.f12430a.getMOrientationHelper().n()) {
                ((ImageView) this.f12430a._$_findCachedViewById(R$id.mImagePlay)).performClick();
            }
            return super.onDoubleTap(motionEvent);
        }

        public boolean onDown(MotionEvent motionEvent) {
            t9.i.g(motionEvent, "e");
            this.f12430a.L = b.NONE;
            this.f12430a.M0 = Float.valueOf(motionEvent.getRawY());
            return false;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            t9.i.g(motionEvent2, "e2");
            return false;
        }

        public void onLongPress(MotionEvent motionEvent) {
            t9.i.g(motionEvent, "e");
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            t9.i.g(motionEvent2, "e2");
            if (this.f12430a.getMOrientationHelper().m() || this.f12430a.getMOrientationHelper().n()) {
                return false;
            }
            return this.f12430a.v2(motionEvent, motionEvent2, f10, f11);
        }

        public void onShowPress(MotionEvent motionEvent) {
            t9.i.g(motionEvent, "e");
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            t9.i.g(motionEvent, "e");
            return false;
        }
    }

    public static final class g extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final g f12431a = new g();

        public g() {
            super(0);
        }

        public final void invoke() {
        }
    }

    public static final class g0 extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final g0 f12432a = new g0();

        public g0() {
            super(0);
        }

        /* renamed from: b */
        public final n6.e invoke() {
            return new n6.e();
        }
    }

    public static final class h extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final h f12433a = new h();

        public h() {
            super(0);
        }

        public final void invoke() {
        }
    }

    public static final class h0 extends t9.j implements s9.p {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12434a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h0(TitanPlayerController titanPlayerController) {
            super(2);
            this.f12434a = titanPlayerController;
        }

        public final void b(int i10, int i11) {
            if (i10 == 0 || i11 == 0) {
                TitanPlayerController titanPlayerController = this.f12434a;
                int i12 = R$id.mPlayPauseIcon;
                ViewGroup.LayoutParams layoutParams = ((ImageView) titanPlayerController._$_findCachedViewById(i12)).getLayoutParams();
                t9.i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoFrameLayout.LayoutParams");
                AutoFrameLayout.LayoutParams layoutParams2 = (AutoFrameLayout.LayoutParams) layoutParams;
                layoutParams2.leftMargin = 0;
                layoutParams2.topMargin = 0;
                ((ImageView) this.f12434a._$_findCachedViewById(i12)).setLayoutParams(layoutParams2);
                this.f12434a.D4(true);
                return;
            }
            TitanPlayerController titanPlayerController2 = this.f12434a;
            int i13 = R$id.mPlayPauseIcon;
            ((ImageView) titanPlayerController2._$_findCachedViewById(i13)).setVisibility(0);
            this.f12434a.D4(false);
            ViewGroup.LayoutParams layoutParams3 = ((ImageView) this.f12434a._$_findCachedViewById(i13)).getLayoutParams();
            t9.i.e(layoutParams3, "null cannot be cast to non-null type com.zhy.autolayout.AutoFrameLayout.LayoutParams");
            AutoFrameLayout.LayoutParams layoutParams4 = (AutoFrameLayout.LayoutParams) layoutParams3;
            layoutParams4.leftMargin = (i10 / 2) + AutoUtils.getPercentWidthSize(70);
            layoutParams4.topMargin = (i11 / 2) - AutoUtils.getPercentWidthSize(60);
            ((ImageView) this.f12434a._$_findCachedViewById(i13)).setLayoutParams(layoutParams4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b(((Number) obj).intValue(), ((Number) obj2).intValue());
            return h9.t.f17319a;
        }
    }

    public static final class i extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12435a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(TitanPlayerController titanPlayerController) {
            super(1);
            this.f12435a = titanPlayerController;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Long l10) {
            if (!na.e.f19075a) {
                ((AlphaRelativeLayout) this.f12435a._$_findCachedViewById(R$id.mLayoutController)).setVisibility(4);
            }
            ((ImageView) this.f12435a._$_findCachedViewById(R$id.mImageBack)).setVisibility(0);
        }
    }

    public static final class i0 extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12436a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i0(TitanPlayerController titanPlayerController) {
            super(0);
            this.f12436a = titanPlayerController;
        }

        public final void invoke() {
            TitanPlayerController titanPlayerController = this.f12436a;
            int i10 = R$id.mPlayPauseIcon;
            ViewGroup.LayoutParams layoutParams = ((ImageView) titanPlayerController._$_findCachedViewById(i10)).getLayoutParams();
            t9.i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoFrameLayout.LayoutParams");
            AutoFrameLayout.LayoutParams layoutParams2 = (AutoFrameLayout.LayoutParams) layoutParams;
            layoutParams2.leftMargin = 0;
            layoutParams2.topMargin = 0;
            ((ImageView) this.f12436a._$_findCachedViewById(i10)).setLayoutParams(layoutParams2);
            this.f12436a.D4(true);
        }
    }

    public static final class j extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12437a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(TitanPlayerController titanPlayerController) {
            super(1);
            this.f12437a = titanPlayerController;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Long l10) {
            ((AutoFrameLayout) this.f12437a._$_findCachedViewById(R$id.mFlLocked)).setVisibility(8);
        }
    }

    public static final class j0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12438a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j0(TitanPlayerController titanPlayerController) {
            super(1);
            this.f12438a = titanPlayerController;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f17319a;
        }

        public final void invoke(String str) {
            if (this.f12438a.S) {
                ((AutoLinearLayout) this.f12438a._$_findCachedViewById(R$id.mLayoutStage)).setVisibility(8);
                ((ImageView) this.f12438a._$_findCachedViewById(R$id.mIvStage)).setVisibility(8);
                return;
            }
            a7.e eVar = a7.e.f10706a;
            Context context = this.f12438a.getContext();
            t9.i.f(context, com.umeng.analytics.pro.f.X);
            TitanPlayerController titanPlayerController = this.f12438a;
            int i10 = R$id.mIvStage;
            ImageView imageView = (ImageView) titanPlayerController._$_findCachedViewById(i10);
            t9.i.f(imageView, "mIvStage");
            eVar.b(context, str, imageView, R.drawable.bg_vod_default_stage);
            ((AutoLinearLayout) this.f12438a._$_findCachedViewById(R$id.mLayoutStage)).setVisibility(0);
            ((ImageView) this.f12438a._$_findCachedViewById(i10)).setVisibility(0);
        }
    }

    public static final class k extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final k f12439a = new k();

        public k() {
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

    public static final class k0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12440a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k0(TitanPlayerController titanPlayerController) {
            super(1);
            this.f12440a = titanPlayerController;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Throwable th) {
            if (this.f12440a.S) {
                AutoLinearLayout autoLinearLayout = (AutoLinearLayout) this.f12440a._$_findCachedViewById(R$id.mLayoutStage);
                if (autoLinearLayout != null) {
                    autoLinearLayout.setVisibility(8);
                }
                ImageView imageView = (ImageView) this.f12440a._$_findCachedViewById(R$id.mIvStage);
                if (imageView != null) {
                    imageView.setVisibility(8);
                    return;
                }
                return;
            }
            TitanPlayerController titanPlayerController = this.f12440a;
            int i10 = R$id.mIvStage;
            ImageView imageView2 = (ImageView) titanPlayerController._$_findCachedViewById(i10);
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.bg_vod_default_stage);
            }
            AutoLinearLayout autoLinearLayout2 = (AutoLinearLayout) this.f12440a._$_findCachedViewById(R$id.mLayoutStage);
            if (autoLinearLayout2 != null) {
                autoLinearLayout2.setVisibility(0);
            }
            ImageView imageView3 = (ImageView) this.f12440a._$_findCachedViewById(i10);
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
        }
    }

    public static final class l extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f12441a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(Context context) {
            super(0);
            this.f12441a = context;
        }

        /* renamed from: b */
        public final f5.c invoke() {
            Context context = this.f12441a;
            t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
            return (f5.c) context;
        }
    }

    public static final class l0 implements v1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12442a;

        public l0(TitanPlayerController titanPlayerController) {
            this.f12442a = titanPlayerController;
        }

        public void a(AdInfoWrapper adInfoWrapper) {
            AdInfo adInfo;
            com.mobile.brasiltv.utils.b0.U(this, "load before ad result and ad is " + adInfoWrapper);
            this.f12442a.f6111h0 = true;
            if (adInfoWrapper != null) {
                adInfo = adInfoWrapper.getAdInfo();
            } else {
                adInfo = null;
            }
            if (adInfo != null) {
                this.f12442a.f6107f0 = false;
                a6.a aVar = a6.a.f10646a;
                ((BeforeVodAdView) this.f12442a._$_findCachedViewById(R$id.mBvavAd)).showBeforeVodAd(adInfoWrapper, aVar.n());
                s1.m mVar = s1.m.f9270a;
                Context context = this.f12442a.getContext();
                t9.i.f(context, com.umeng.analytics.pro.f.X);
                String n10 = aVar.n();
                AdInfo adInfo2 = adInfoWrapper.getAdInfo();
                t9.i.d(adInfo2);
                mVar.d0(context, n10, adInfo2.getAd_id());
            } else if (this.f12442a.W) {
                this.f12442a.X2();
                if (this.f12442a.D) {
                    ((TitanVODView) this.f12442a._$_findCachedViewById(R$id.mVideoViewVod)).x(0);
                } else {
                    ((TitanVODView) this.f12442a._$_findCachedViewById(R$id.mVideoViewVod)).w();
                }
            } else {
                ((ImageView) this.f12442a._$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
                this.f12442a.D4(false);
                ((RelativeLayout) this.f12442a._$_findCachedViewById(R$id.mBufferView)).setVisibility(0);
            }
        }
    }

    public static final class m extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f12443a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(Context context) {
            super(0);
            this.f12443a = context;
        }

        /* renamed from: b */
        public final MobileDao invoke() {
            Context applicationContext = this.f12443a.getApplicationContext();
            t9.i.f(applicationContext, "context.applicationContext");
            return new MobileDao(applicationContext);
        }
    }

    public static final class m0 implements AlphaRelativeLayout.OnVisibility {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12444a;

        public m0(TitanPlayerController titanPlayerController) {
            this.f12444a = titanPlayerController;
        }

        public void onVisible(int i10) {
            boolean z10;
            Object obj = null;
            if (i10 == 0) {
                TitanPlayerController titanPlayerController = this.f12444a;
                int i11 = R$id.mVideoViewVod;
                n8.b titanContext = ((TitanVODView) titanPlayerController._$_findCachedViewById(i11)).getTitanContext();
                if (titanContext != null) {
                    obj = titanContext.h();
                }
                if (obj == null) {
                    ((ImageView) this.f12444a._$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
                    this.f12444a.D4(false);
                } else if (((TitanVODView) this.f12444a._$_findCachedViewById(i11)).s()) {
                    this.f12444a.G4();
                } else {
                    this.f12444a.H4();
                }
            } else if (((ImageView) this.f12444a._$_findCachedViewById(R$id.mIvStage)).getVisibility() == 8 || !this.f12444a.G) {
                PauseAdView W0 = this.f12444a.A;
                if (W0 != null) {
                    obj = W0.getParent();
                }
                if (obj != null) {
                    PauseAdView W02 = this.f12444a.A;
                    boolean z11 = true;
                    if (W02 == null || W02.getWidth() != 0) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (z10) {
                        PauseAdView W03 = this.f12444a.A;
                        if (W03 == null || W03.getHeight() != 0) {
                            z11 = false;
                        }
                        if (!z11) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                ((ImageView) this.f12444a._$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
                this.f12444a.D4(false);
            }
        }
    }

    public static final class n extends ha.a {
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }
    }

    public static final class n0 implements n.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12445a;

        public n0(TitanPlayerController titanPlayerController) {
            this.f12445a = titanPlayerController;
        }

        public void a(int i10, SubTitleData subTitleData) {
            int i11;
            int i12;
            int i13;
            String str;
            String str2;
            t9.i.g(subTitleData, "subTitleData");
            this.f12445a.f6115j0 = i10 - 1;
            this.f12445a.f6121m0 = true;
            TitanPlayerController titanPlayerController = this.f12445a;
            int i14 = R$id.mVideoViewVod;
            ((TitanVODView) titanPlayerController._$_findCachedViewById(i14)).setSubtitleVisible(this.f12445a.f6121m0);
            String str3 = "";
            if (t9.i.b(this.f12445a.B, "0")) {
                SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
                String mDetailDataContentId = this.f12445a.getMDetailDataContentId();
                if (mDetailDataContentId == null) {
                    mDetailDataContentId = str3;
                }
                subtitleManager.putSelectSubtitle(mDetailDataContentId, this.f12445a.f6115j0, subTitleData.getLanguage());
                if (this.f12445a.f6130r) {
                    TitanVODView titanVODView = (TitanVODView) this.f12445a._$_findCachedViewById(i14);
                    String filePath = subTitleData.getFilePath();
                    SimpleProgramList curPlayProgram = this.f12445a.getCurPlayProgram();
                    if (curPlayProgram == null || (str2 = curPlayProgram.getContentId()) == null) {
                        str2 = str3;
                    }
                    titanVODView.J(filePath, str2);
                }
            } else {
                SubtitleManager subtitleManager2 = SubtitleManager.INSTANCE;
                String mDetailDataContentId2 = this.f12445a.getMDetailDataContentId();
                if (mDetailDataContentId2 == null) {
                    mDetailDataContentId2 = str3;
                }
                subtitleManager2.putSelectSubtitle(mDetailDataContentId2, this.f12445a.f6115j0, subTitleData.getLanguage());
                if (this.f12445a.f6130r) {
                    TitanVODView titanVODView2 = (TitanVODView) this.f12445a._$_findCachedViewById(i14);
                    String filePath2 = subTitleData.getFilePath();
                    AssetData data = this.f12445a.getData();
                    if (data == null || (str = data.getContentId()) == null) {
                        str = str3;
                    }
                    titanVODView2.J(filePath2, str);
                }
            }
            String mDetailDataContentId3 = this.f12445a.getMDetailDataContentId();
            if (mDetailDataContentId3 != null) {
                Boolean put = SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId3, Boolean.TRUE);
            }
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId4 = this.f12445a.getMDetailDataContentId();
            if (mDetailDataContentId4 != null) {
                str3 = mDetailDataContentId4;
            }
            subtitleSettingBean.setContentId(str3);
            subtitleSettingBean.setSubtitleLanguage(subTitleData.getLanguage());
            SubtitleManager subtitleManager3 = SubtitleManager.INSTANCE;
            RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager3.getMLruCacheLanguages().get(this.f12445a.getMDetailDataContentId());
            if (recordSubtitleInfoBean != null) {
                i11 = recordSubtitleInfoBean.getSubtitleIndex();
            } else {
                i11 = subtitleManager3.getMGlobalLanguage();
            }
            subtitleSettingBean.setSubtitleIndex(i11);
            Integer num = subtitleManager3.getMLruCacheColor().get(this.f12445a.getMDetailDataContentId());
            if (num == null) {
                i12 = subtitleManager3.getMGlobalColor();
            } else {
                i12 = num.intValue();
            }
            subtitleSettingBean.setSubtitleStyle(i12);
            Integer num2 = subtitleManager3.getMLruCacheSize().get(this.f12445a.getMDetailDataContentId());
            if (num2 == null) {
                i13 = subtitleManager3.getMGlobalSize();
            } else {
                i13 = num2.intValue();
            }
            subtitleSettingBean.setSubtitleSize(i13);
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(this.f12445a.f6121m0));
            this.f12445a.l3(subtitleSettingBean);
        }

        public void b(boolean z10) {
            int i10;
            int i11;
            int i12;
            String subTitleLanguage;
            String str;
            if (this.f12445a.f6121m0 != z10) {
                Context context = this.f12445a.getContext();
                String valueOf = String.valueOf(z10);
                AudioTrackBean O0 = this.f12445a.f6135t0;
                if (O0 != null) {
                    str = O0.getRealAudio();
                } else {
                    str = null;
                }
                i1.P(context, valueOf, str);
            }
            this.f12445a.f6121m0 = z10;
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId = this.f12445a.getMDetailDataContentId();
            String str2 = "";
            if (mDetailDataContentId == null) {
                mDetailDataContentId = str2;
            }
            subtitleSettingBean.setContentId(mDetailDataContentId);
            if (this.f12445a.f6121m0) {
                SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
                RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager.getMLruCacheLanguages().get(this.f12445a.getMDetailDataContentId());
                if (!(recordSubtitleInfoBean == null || (subTitleLanguage = recordSubtitleInfoBean.getSubTitleLanguage()) == null)) {
                    str2 = subTitleLanguage;
                }
                subtitleSettingBean.setSubtitleLanguage(str2);
                Integer num = subtitleManager.getMLruCacheColor().get(this.f12445a.getMDetailDataContentId());
                if (num == null) {
                    i10 = subtitleManager.getMGlobalColor();
                } else {
                    i10 = num.intValue();
                }
                subtitleSettingBean.setSubtitleStyle(i10);
                Integer num2 = subtitleManager.getMLruCacheSize().get(this.f12445a.getMDetailDataContentId());
                if (num2 == null) {
                    i11 = subtitleManager.getMGlobalSize();
                } else {
                    i11 = num2.intValue();
                }
                subtitleSettingBean.setSubtitleSize(i11);
                RecordSubtitleInfoBean recordSubtitleInfoBean2 = subtitleManager.getMLruCacheLanguages().get(this.f12445a.getMDetailDataContentId());
                if (recordSubtitleInfoBean2 != null) {
                    i12 = recordSubtitleInfoBean2.getSubtitleIndex();
                } else {
                    i12 = -1;
                }
                subtitleSettingBean.setSubtitleIndex(i12);
            } else {
                subtitleSettingBean.setSubtitleLanguage(str2);
                subtitleSettingBean.setSubtitleStyle(-1);
                subtitleSettingBean.setSubtitleSize(-1);
                subtitleSettingBean.setSubtitleIndex(-1);
            }
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(z10));
            this.f12445a.l3(subtitleSettingBean);
            String mDetailDataContentId2 = this.f12445a.getMDetailDataContentId();
            if (mDetailDataContentId2 != null) {
                Boolean put = SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId2, Boolean.valueOf(z10));
            }
            if (this.f12445a.f6130r) {
                ((TitanVODView) this.f12445a._$_findCachedViewById(R$id.mVideoViewVod)).setSubtitleVisible(z10);
            }
            this.f12445a.getSubtitleAudioLandWindow().q(z10);
            if (!z10) {
                this.f12445a.f6115j0 = -1;
            }
        }

        public void c(int i10, AudioTrackBean audioTrackBean) {
            t9.i.g(audioTrackBean, "data");
            this.f12445a.f6123n0 = i10;
            if (!t9.i.b(audioTrackBean.getRealAudio(), this.f12445a.f6147z0.getRealAudio())) {
                this.f12445a.R4(audioTrackBean);
                AudioSettingBean audioSettingBean = new AudioSettingBean();
                String mDetailDataContentId = this.f12445a.getMDetailDataContentId();
                if (mDetailDataContentId == null) {
                    mDetailDataContentId = "";
                }
                audioSettingBean.setContentId(mDetailDataContentId);
                audioSettingBean.setAudioLanguage(audioTrackBean.getRealAudio());
                this.f12445a.f3(audioSettingBean);
                SubtitleManager.INSTANCE.getMLruCacheAudioLanguages().put(this.f12445a.getMDetailDataContentId(), audioTrackBean.getRealAudio());
            }
        }

        public void d(int i10) {
            int i11;
            String str;
            int i12;
            this.f12445a.f6117k0 = i10;
            this.f12445a.f6121m0 = true;
            String mDetailDataContentId = this.f12445a.getMDetailDataContentId();
            if (mDetailDataContentId != null) {
                Integer put = SubtitleManager.INSTANCE.getMLruCacheSize().put(mDetailDataContentId, Integer.valueOf(i10));
            }
            String mDetailDataContentId2 = this.f12445a.getMDetailDataContentId();
            if (mDetailDataContentId2 != null) {
                Boolean put2 = SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId2, Boolean.TRUE);
            }
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId3 = this.f12445a.getMDetailDataContentId();
            if (mDetailDataContentId3 == null) {
                mDetailDataContentId3 = "";
            }
            subtitleSettingBean.setContentId(mDetailDataContentId3);
            SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
            RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager.getMLruCacheLanguages().get(this.f12445a.getMDetailDataContentId());
            if (recordSubtitleInfoBean != null) {
                i11 = recordSubtitleInfoBean.getSubtitleIndex();
            } else {
                i11 = subtitleManager.getMGlobalLanguage();
            }
            subtitleSettingBean.setSubtitleIndex(i11);
            RecordSubtitleInfoBean recordSubtitleInfoBean2 = subtitleManager.getMLruCacheLanguages().get(this.f12445a.getMDetailDataContentId());
            if (recordSubtitleInfoBean2 == null || (str = recordSubtitleInfoBean2.getSubTitleLanguage()) == null) {
                str = this.f12445a.g2(subtitleManager.getMGlobalLanguage());
            }
            subtitleSettingBean.setSubtitleLanguage(str);
            Integer num = subtitleManager.getMLruCacheColor().get(this.f12445a.getMDetailDataContentId());
            if (num == null) {
                i12 = subtitleManager.getMGlobalColor();
            } else {
                i12 = num.intValue();
            }
            subtitleSettingBean.setSubtitleStyle(i12);
            subtitleSettingBean.setSubtitleSize(this.f12445a.f6117k0);
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(this.f12445a.f6121m0));
            this.f12445a.l3(subtitleSettingBean);
            if (this.f12445a.f6130r) {
                ((TitanVODView) this.f12445a._$_findCachedViewById(R$id.mVideoViewVod)).K(subtitleManager.getPortraitSizeValues()[i10].intValue(), subtitleManager.getLandscapeSizeValues()[i10].intValue());
            }
        }

        public void e(int i10) {
            String str;
            int i11;
            int i12;
            this.f12445a.f6119l0 = i10;
            this.f12445a.f6121m0 = true;
            String mDetailDataContentId = this.f12445a.getMDetailDataContentId();
            if (mDetailDataContentId != null) {
                Integer put = SubtitleManager.INSTANCE.getMLruCacheColor().put(mDetailDataContentId, Integer.valueOf(i10));
            }
            String mDetailDataContentId2 = this.f12445a.getMDetailDataContentId();
            if (mDetailDataContentId2 != null) {
                Boolean put2 = SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId2, Boolean.TRUE);
            }
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId3 = this.f12445a.getMDetailDataContentId();
            if (mDetailDataContentId3 == null) {
                mDetailDataContentId3 = "";
            }
            subtitleSettingBean.setContentId(mDetailDataContentId3);
            SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
            RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager.getMLruCacheLanguages().get(this.f12445a.getMDetailDataContentId());
            if (recordSubtitleInfoBean == null || (str = recordSubtitleInfoBean.getSubTitleLanguage()) == null) {
                str = this.f12445a.g2(subtitleManager.getMGlobalLanguage());
            }
            subtitleSettingBean.setSubtitleLanguage(str);
            RecordSubtitleInfoBean recordSubtitleInfoBean2 = subtitleManager.getMLruCacheLanguages().get(this.f12445a.getMDetailDataContentId());
            if (recordSubtitleInfoBean2 != null) {
                i11 = recordSubtitleInfoBean2.getSubtitleIndex();
            } else {
                i11 = subtitleManager.getMGlobalLanguage();
            }
            subtitleSettingBean.setSubtitleIndex(i11);
            subtitleSettingBean.setSubtitleStyle(this.f12445a.f6119l0);
            Integer num = subtitleManager.getMLruCacheSize().get(this.f12445a.getMDetailDataContentId());
            if (num == null) {
                i12 = subtitleManager.getMGlobalSize();
            } else {
                i12 = num.intValue();
            }
            subtitleSettingBean.setSubtitleSize(i12);
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(this.f12445a.f6121m0));
            this.f12445a.l3(subtitleSettingBean);
            if (!this.f12445a.f6130r) {
                return;
            }
            if (i10 == 2) {
                TitanPlayerController titanPlayerController = this.f12445a;
                int i13 = R$id.mVideoViewVod;
                ((TitanVODView) titanPlayerController._$_findCachedViewById(i13)).setSubtitleColor(subtitleManager.getColorValues()[0].intValue());
                ((TitanVODView) this.f12445a._$_findCachedViewById(i13)).setSubtitleBg(1);
                return;
            }
            TitanPlayerController titanPlayerController2 = this.f12445a;
            int i14 = R$id.mVideoViewVod;
            ((TitanVODView) titanPlayerController2._$_findCachedViewById(i14)).setSubtitleColor(subtitleManager.getColorValues()[i10].intValue());
            ((TitanVODView) this.f12445a._$_findCachedViewById(i14)).setSubtitleBg(0);
        }
    }

    public static final class o extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12446a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(TitanPlayerController titanPlayerController) {
            super(1);
            this.f12446a = titanPlayerController;
        }

        public final void b(AudioSettingBean audioSettingBean) {
            com.mobile.brasiltv.utils.b0.U(this.f12446a, "增加音轨设置成功！");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((AudioSettingBean) obj);
            return h9.t.f17319a;
        }
    }

    public static final class o0 implements p.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12447a;

        public o0(TitanPlayerController titanPlayerController) {
            this.f12447a = titanPlayerController;
        }

        public void a(int i10, SubTitleData subTitleData) {
            int i11;
            int i12;
            int i13;
            String str;
            String str2;
            t9.i.g(subTitleData, "subTitleData");
            this.f12447a.f6115j0 = i10 - 1;
            this.f12447a.f6121m0 = true;
            TitanPlayerController titanPlayerController = this.f12447a;
            int i14 = R$id.mVideoViewVod;
            ((TitanVODView) titanPlayerController._$_findCachedViewById(i14)).setSubtitleVisible(this.f12447a.f6121m0);
            String str3 = "";
            if (t9.i.b(this.f12447a.B, "0")) {
                SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
                String mDetailDataContentId = this.f12447a.getMDetailDataContentId();
                if (mDetailDataContentId == null) {
                    mDetailDataContentId = str3;
                }
                subtitleManager.putSelectSubtitle(mDetailDataContentId, this.f12447a.f6115j0, subTitleData.getLanguage());
                if (this.f12447a.f6130r) {
                    TitanVODView titanVODView = (TitanVODView) this.f12447a._$_findCachedViewById(i14);
                    String filePath = subTitleData.getFilePath();
                    SimpleProgramList curPlayProgram = this.f12447a.getCurPlayProgram();
                    if (curPlayProgram == null || (str2 = curPlayProgram.getContentId()) == null) {
                        str2 = str3;
                    }
                    titanVODView.J(filePath, str2);
                }
            } else {
                SubtitleManager subtitleManager2 = SubtitleManager.INSTANCE;
                String mDetailDataContentId2 = this.f12447a.getMDetailDataContentId();
                if (mDetailDataContentId2 == null) {
                    mDetailDataContentId2 = str3;
                }
                subtitleManager2.putSelectSubtitle(mDetailDataContentId2, this.f12447a.f6115j0, subTitleData.getLanguage());
                if (this.f12447a.f6130r) {
                    TitanVODView titanVODView2 = (TitanVODView) this.f12447a._$_findCachedViewById(i14);
                    String filePath2 = subTitleData.getFilePath();
                    AssetData data = this.f12447a.getData();
                    if (data == null || (str = data.getContentId()) == null) {
                        str = str3;
                    }
                    titanVODView2.J(filePath2, str);
                }
            }
            String mDetailDataContentId3 = this.f12447a.getMDetailDataContentId();
            if (mDetailDataContentId3 != null) {
                Boolean put = SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId3, Boolean.TRUE);
            }
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId4 = this.f12447a.getMDetailDataContentId();
            if (mDetailDataContentId4 != null) {
                str3 = mDetailDataContentId4;
            }
            subtitleSettingBean.setContentId(str3);
            subtitleSettingBean.setSubtitleLanguage(subTitleData.getLanguage());
            SubtitleManager subtitleManager3 = SubtitleManager.INSTANCE;
            RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager3.getMLruCacheLanguages().get(this.f12447a.getMDetailDataContentId());
            if (recordSubtitleInfoBean != null) {
                i11 = recordSubtitleInfoBean.getSubtitleIndex();
            } else {
                i11 = subtitleManager3.getMGlobalLanguage();
            }
            subtitleSettingBean.setSubtitleIndex(i11);
            Integer num = subtitleManager3.getMLruCacheColor().get(this.f12447a.getMDetailDataContentId());
            if (num == null) {
                i12 = subtitleManager3.getMGlobalColor();
            } else {
                i12 = num.intValue();
            }
            subtitleSettingBean.setSubtitleStyle(i12);
            Integer num2 = subtitleManager3.getMLruCacheSize().get(this.f12447a.getMDetailDataContentId());
            if (num2 == null) {
                i13 = subtitleManager3.getMGlobalSize();
            } else {
                i13 = num2.intValue();
            }
            subtitleSettingBean.setSubtitleSize(i13);
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(this.f12447a.f6121m0));
            this.f12447a.l3(subtitleSettingBean);
        }

        public void b(boolean z10) {
            int i10;
            String str;
            int i11;
            int i12;
            this.f12447a.f6121m0 = z10;
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId = this.f12447a.getMDetailDataContentId();
            if (mDetailDataContentId == null) {
                mDetailDataContentId = "";
            }
            subtitleSettingBean.setContentId(mDetailDataContentId);
            if (this.f12447a.f6121m0) {
                SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
                RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager.getMLruCacheLanguages().get(this.f12447a.getMDetailDataContentId());
                if (recordSubtitleInfoBean != null) {
                    i10 = recordSubtitleInfoBean.getSubtitleIndex();
                } else {
                    i10 = subtitleManager.getMGlobalLanguage();
                }
                subtitleSettingBean.setSubtitleIndex(i10);
                RecordSubtitleInfoBean recordSubtitleInfoBean2 = subtitleManager.getMLruCacheLanguages().get(this.f12447a.getMDetailDataContentId());
                if (recordSubtitleInfoBean2 == null || (str = recordSubtitleInfoBean2.getSubTitleLanguage()) == null) {
                    str = this.f12447a.g2(subtitleManager.getMGlobalLanguage());
                }
                subtitleSettingBean.setSubtitleLanguage(str);
                Integer num = subtitleManager.getMLruCacheColor().get(this.f12447a.getMDetailDataContentId());
                if (num == null) {
                    i11 = subtitleManager.getMGlobalColor();
                } else {
                    i11 = num.intValue();
                }
                subtitleSettingBean.setSubtitleStyle(i11);
                Integer num2 = subtitleManager.getMLruCacheSize().get(this.f12447a.getMDetailDataContentId());
                if (num2 == null) {
                    i12 = subtitleManager.getMGlobalSize();
                } else {
                    i12 = num2.intValue();
                }
                subtitleSettingBean.setSubtitleSize(i12);
            } else {
                subtitleSettingBean.setSubtitleLanguage("");
                subtitleSettingBean.setSubtitleIndex(-1);
                subtitleSettingBean.setSubtitleStyle(-1);
                subtitleSettingBean.setSubtitleSize(-1);
            }
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(z10));
            this.f12447a.l3(subtitleSettingBean);
            String mDetailDataContentId2 = this.f12447a.getMDetailDataContentId();
            if (mDetailDataContentId2 != null) {
                Boolean put = SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId2, Boolean.valueOf(z10));
            }
            if (this.f12447a.f6130r) {
                ((TitanVODView) this.f12447a._$_findCachedViewById(R$id.mVideoViewVod)).setSubtitleVisible(z10);
            }
            this.f12447a.getSubtitleAudioPorWindow().q(z10);
            if (!z10) {
                this.f12447a.f6115j0 = -1;
            }
        }

        public void c(int i10, AudioTrackBean audioTrackBean) {
            t9.i.g(audioTrackBean, "data");
            this.f12447a.f6123n0 = i10;
            if (!t9.i.b(audioTrackBean.getRealAudio(), this.f12447a.f6147z0.getRealAudio())) {
                this.f12447a.R4(audioTrackBean);
                AudioSettingBean audioSettingBean = new AudioSettingBean();
                String mDetailDataContentId = this.f12447a.getMDetailDataContentId();
                if (mDetailDataContentId == null) {
                    mDetailDataContentId = "";
                }
                audioSettingBean.setContentId(mDetailDataContentId);
                audioSettingBean.setAudioLanguage(audioTrackBean.getRealAudio());
                this.f12447a.f3(audioSettingBean);
                SubtitleManager.INSTANCE.getMLruCacheAudioLanguages().put(this.f12447a.getMDetailDataContentId(), audioTrackBean.getRealAudio());
            }
        }

        public void d(int i10) {
            String str;
            int i11;
            int i12;
            this.f12447a.f6117k0 = i10;
            String mDetailDataContentId = this.f12447a.getMDetailDataContentId();
            if (mDetailDataContentId != null) {
                Integer put = SubtitleManager.INSTANCE.getMLruCacheSize().put(mDetailDataContentId, Integer.valueOf(i10));
            }
            String mDetailDataContentId2 = this.f12447a.getMDetailDataContentId();
            if (mDetailDataContentId2 != null) {
                Boolean put2 = SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId2, Boolean.TRUE);
            }
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId3 = this.f12447a.getMDetailDataContentId();
            if (mDetailDataContentId3 == null) {
                mDetailDataContentId3 = "";
            }
            subtitleSettingBean.setContentId(mDetailDataContentId3);
            SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
            RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager.getMLruCacheLanguages().get(this.f12447a.getMDetailDataContentId());
            if (recordSubtitleInfoBean == null || (str = recordSubtitleInfoBean.getSubTitleLanguage()) == null) {
                str = this.f12447a.g2(subtitleManager.getMGlobalLanguage());
            }
            subtitleSettingBean.setSubtitleLanguage(str);
            RecordSubtitleInfoBean recordSubtitleInfoBean2 = subtitleManager.getMLruCacheLanguages().get(this.f12447a.getMDetailDataContentId());
            if (recordSubtitleInfoBean2 != null) {
                i11 = recordSubtitleInfoBean2.getSubtitleIndex();
            } else {
                i11 = subtitleManager.getMGlobalLanguage();
            }
            subtitleSettingBean.setSubtitleIndex(i11);
            Integer num = subtitleManager.getMLruCacheColor().get(this.f12447a.getMDetailDataContentId());
            if (num == null) {
                i12 = subtitleManager.getMGlobalColor();
            } else {
                i12 = num.intValue();
            }
            subtitleSettingBean.setSubtitleStyle(i12);
            subtitleSettingBean.setSubtitleSize(this.f12447a.f6117k0);
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(this.f12447a.f6121m0));
            this.f12447a.l3(subtitleSettingBean);
            if (this.f12447a.f6130r) {
                ((TitanVODView) this.f12447a._$_findCachedViewById(R$id.mVideoViewVod)).K(subtitleManager.getPortraitSizeValues()[i10].intValue(), subtitleManager.getLandscapeSizeValues()[i10].intValue());
            }
        }

        public void e(int i10) {
            String str;
            int i11;
            int i12;
            this.f12447a.f6119l0 = i10;
            String mDetailDataContentId = this.f12447a.getMDetailDataContentId();
            if (mDetailDataContentId != null) {
                Integer put = SubtitleManager.INSTANCE.getMLruCacheColor().put(mDetailDataContentId, Integer.valueOf(i10));
            }
            String mDetailDataContentId2 = this.f12447a.getMDetailDataContentId();
            if (mDetailDataContentId2 != null) {
                Boolean put2 = SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId2, Boolean.TRUE);
            }
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId3 = this.f12447a.getMDetailDataContentId();
            if (mDetailDataContentId3 == null) {
                mDetailDataContentId3 = "";
            }
            subtitleSettingBean.setContentId(mDetailDataContentId3);
            SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
            RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager.getMLruCacheLanguages().get(this.f12447a.getMDetailDataContentId());
            if (recordSubtitleInfoBean == null || (str = recordSubtitleInfoBean.getSubTitleLanguage()) == null) {
                str = this.f12447a.g2(subtitleManager.getMGlobalLanguage());
            }
            subtitleSettingBean.setSubtitleLanguage(str);
            RecordSubtitleInfoBean recordSubtitleInfoBean2 = subtitleManager.getMLruCacheLanguages().get(this.f12447a.getMDetailDataContentId());
            if (recordSubtitleInfoBean2 != null) {
                i11 = recordSubtitleInfoBean2.getSubtitleIndex();
            } else {
                i11 = subtitleManager.getMGlobalLanguage();
            }
            subtitleSettingBean.setSubtitleIndex(i11);
            subtitleSettingBean.setSubtitleStyle(this.f12447a.f6119l0);
            Integer num = subtitleManager.getMLruCacheSize().get(this.f12447a.getMDetailDataContentId());
            if (num == null) {
                i12 = subtitleManager.getMGlobalSize();
            } else {
                i12 = num.intValue();
            }
            subtitleSettingBean.setSubtitleSize(i12);
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(this.f12447a.f6121m0));
            this.f12447a.l3(subtitleSettingBean);
            if (this.f12447a.f6130r) {
                if (i10 == 2) {
                    ((TitanVODView) this.f12447a._$_findCachedViewById(R$id.mVideoViewVod)).setSubtitleBg(1);
                } else {
                    ((TitanVODView) this.f12447a._$_findCachedViewById(R$id.mVideoViewVod)).setSubtitleBg(0);
                }
                ((TitanVODView) this.f12447a._$_findCachedViewById(R$id.mVideoViewVod)).setSubtitleColor(subtitleManager.getColorValues()[i10].intValue());
            }
        }
    }

    public static final class p extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12448a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(TitanPlayerController titanPlayerController) {
            super(1);
            this.f12448a = titanPlayerController;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Throwable th) {
            com.mobile.brasiltv.utils.b0.U(this.f12448a, "增加音轨设置失败！");
        }
    }

    public static final class p0 implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12449a;

        public p0(TitanPlayerController titanPlayerController) {
            this.f12449a = titanPlayerController;
        }

        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            t9.i.g(seekBar, "seekBar");
            if (this.f12449a.W) {
                this.f12449a.H = true;
                ((TitanVODView) this.f12449a._$_findCachedViewById(R$id.mVideoViewVod)).x((long) seekBar.getProgress());
                if (this.f12449a.V) {
                    ((ImageView) this.f12449a._$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
                    this.f12449a.D4(false);
                }
                if (seekBar.getProgress() != seekBar.getMax()) {
                    this.f12449a.D = false;
                }
            }
        }
    }

    public static final class q extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12450a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(TitanPlayerController titanPlayerController) {
            super(1);
            this.f12450a = titanPlayerController;
        }

        public final void b(SubtitleSettingBean subtitleSettingBean) {
            com.mobile.brasiltv.utils.b0.U(this.f12450a, "增加字幕设置成功！");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SubtitleSettingBean) obj);
            return h9.t.f17319a;
        }
    }

    public static final class q0 implements GuideNextClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12451a;

        public q0(TitanPlayerController titanPlayerController) {
            this.f12451a = titanPlayerController;
        }

        public void onGuideNextClick(String str, boolean z10) {
            if (z10) {
                this.f12451a.M4();
            }
        }
    }

    public static final class r extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12452a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(TitanPlayerController titanPlayerController) {
            super(1);
            this.f12452a = titanPlayerController;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Throwable th) {
            com.mobile.brasiltv.utils.b0.U(this.f12452a, "增加字幕设置失败！");
        }
    }

    public static final class r0 implements GuideNextClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12453a;

        public r0(TitanPlayerController titanPlayerController) {
            this.f12453a = titanPlayerController;
        }

        public void onGuideNextClick(String str, boolean z10) {
            this.f12453a.M4();
            ((AlphaRelativeLayout) this.f12453a._$_findCachedViewById(R$id.mLayoutController)).delayHide();
            xa.c.c().j(new ShowVodSharingGuideEvent());
        }
    }

    public static final class s extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final s f12454a = new s();

        public s() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "intent");
            Intent putExtra = intent.putExtra("from_type", "VOD");
            t9.i.f(putExtra, "intent.putExtra(Constant…, Constant.FROM_TYPE_VOD)");
            return putExtra;
        }
    }

    public static final class s0 extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f12455a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s0(Context context) {
            super(0);
            this.f12455a = context;
        }

        /* renamed from: b */
        public final ArrayList invoke() {
            return SubtitleManager.INSTANCE.getSizeList(this.f12455a);
        }
    }

    public static final class t implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12456a;

        public t(TitanPlayerController titanPlayerController) {
            this.f12456a = titanPlayerController;
        }

        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            t9.i.g(seekBar, "seekBar");
            if (((AutoLinearLayout) this.f12456a._$_findCachedViewById(R$id.llCastContainer)).getVisibility() == 0) {
                com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
                if (t9.i.b(hVar.a(), hVar.k())) {
                    com.mobile.brasiltv.utils.g.f12519a.s(((long) seekBar.getProgress()) * 1000);
                } else if (t9.i.b(hVar.a(), hVar.l())) {
                    this.f12456a.N.q(((long) seekBar.getProgress()) * 1000);
                }
            }
        }
    }

    public static final class t0 extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f12457a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t0(Context context) {
            super(0);
            this.f12457a = context;
        }

        /* renamed from: b */
        public final ArrayList invoke() {
            return SubtitleManager.INSTANCE.getStyleList(this.f12457a);
        }
    }

    public static final class u implements BeforeVodAdView.BeforeVodCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12458a;

        public u(TitanPlayerController titanPlayerController) {
            this.f12458a = titanPlayerController;
        }

        public void onBack() {
            this.f12458a.k2(true);
        }

        public void onCountDownFinished() {
            this.f12458a.f6107f0 = true;
            this.f12458a.C3();
            this.f12458a.J4();
        }

        public void onFullScreen() {
            this.f12458a.getMOrientationHelper().q();
        }
    }

    public static final class u0 extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12459a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u0(TitanPlayerController titanPlayerController) {
            super(0);
            this.f12459a = titanPlayerController;
        }

        /* renamed from: b */
        public final g7.n invoke() {
            return new g7.n(this.f12459a.getMActivity());
        }
    }

    public static final class v extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final v f12460a = new v();

        public v() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "intent");
            Intent putExtra = intent.putExtra("from_type", "VOD");
            t9.i.f(putExtra, "intent.putExtra(Constant…, Constant.FROM_TYPE_VOD)");
            return putExtra;
        }
    }

    public static final class v0 extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12461a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v0(TitanPlayerController titanPlayerController) {
            super(0);
            this.f12461a = titanPlayerController;
        }

        /* renamed from: b */
        public final g7.p invoke() {
            return new g7.p(this.f12461a.getMActivity());
        }
    }

    public static final class w implements BeforeVodAdView.BeforeVodCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12462a;

        public w(TitanPlayerController titanPlayerController) {
            this.f12462a = titanPlayerController;
        }

        public void onBack() {
            this.f12462a.k2(true);
        }

        public void onCountDownFinished() {
            this.f12462a.f6107f0 = true;
            if (this.f12462a.W) {
                this.f12462a.X2();
                ((TitanVODView) this.f12462a._$_findCachedViewById(R$id.mVideoViewVod)).w();
            } else {
                ((ImageView) this.f12462a._$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
                this.f12462a.D4(false);
                ((RelativeLayout) this.f12462a._$_findCachedViewById(R$id.mBufferView)).setVisibility(0);
            }
            this.f12462a.J4();
        }

        public void onFullScreen() {
            this.f12462a.getMOrientationHelper().q();
        }
    }

    public static final class x extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final x f12463a = new x();

        public x() {
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

    public static final class y extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f12464a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y(TitanPlayerController titanPlayerController) {
            super(1);
            this.f12464a = titanPlayerController;
        }

        public final void b(SubtitleSettingBean subtitleSettingBean) {
            if (subtitleSettingBean.getSubtitleStyle() != -1) {
                this.f12464a.f6119l0 = subtitleSettingBean.getSubtitleStyle();
            } else {
                this.f12464a.f6119l0 = SubtitleManager.INSTANCE.getMGlobalColor();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SubtitleSettingBean) obj);
            return h9.t.f17319a;
        }
    }

    public static final class z extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final z f12465a = new z();

        public z() {
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TitanPlayerController(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (t9.g) null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    public static final void C4(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        TextView textView = (TextView) titanPlayerController._$_findCachedViewById(R$id.tvPlayTips);
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public static final void D3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void E2(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void E3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void F2(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void F3(TitanPlayerController titanPlayerController, ObservableEmitter observableEmitter) {
        String str;
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(observableEmitter, "it");
        MobileDao mSubtitleAndAudioLanguageDao = titanPlayerController.getMSubtitleAndAudioLanguageDao();
        AssetData assetData = titanPlayerController.f6106f;
        if (assetData == null || (str = assetData.getContentId()) == null) {
            str = "";
        }
        SubtitleSettingBean querySubtitleSetting = mSubtitleAndAudioLanguageDao.querySubtitleSetting(str);
        if (querySubtitleSetting != null) {
            observableEmitter.onNext(querySubtitleSetting);
        } else {
            observableEmitter.onNext(new SubtitleSettingBean());
        }
    }

    public static final void G3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void H3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void I3(TitanPlayerController titanPlayerController, ObservableEmitter observableEmitter) {
        String str;
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(observableEmitter, "it");
        MobileDao mSubtitleAndAudioLanguageDao = titanPlayerController.getMSubtitleAndAudioLanguageDao();
        AssetData assetData = titanPlayerController.f6106f;
        if (assetData == null || (str = assetData.getContentId()) == null) {
            str = "";
        }
        SubtitleSettingBean querySubtitleSetting = mSubtitleAndAudioLanguageDao.querySubtitleSetting(str);
        if (querySubtitleSetting != null) {
            observableEmitter.onNext(querySubtitleSetting);
        } else {
            observableEmitter.onNext(new SubtitleSettingBean());
        }
    }

    public static final void J2(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f12519a;
        gVar.B(false);
        gVar.C(false);
        gVar.y(true);
        ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
        int i10 = R$id.mSeekBarCast;
        ((SeekBar) titanPlayerController._$_findCachedViewById(i10)).setProgress(((SeekBar) titanPlayerController._$_findCachedViewById(i10)).getMax());
        TextView textView = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTextCurTimeCast);
        if (textView != null) {
            textView.setText(y6.a.l((long) ((SeekBar) titanPlayerController._$_findCachedViewById(i10)).getProgress()));
        }
        titanPlayerController.C = 0;
        Links links = titanPlayerController.f6146z;
        if (links != null) {
            links.setRecordTime(0);
        }
    }

    public static final void J3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void K2(int i10, String str, TitanPlayerController titanPlayerController, String str2) {
        t9.i.g(str, "$extra");
        t9.i.g(titanPlayerController, "this$0");
        if (com.mobile.brasiltv.utils.h.f12562a.t()) {
            com.mobile.brasiltv.utils.g.f12519a.G();
        }
        xa.c.c().j(new CastToCloseFloatViewEvent());
        if (i10 == 501 || i10 == 701) {
            TextView textView = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastRecommendHint);
            if (textView != null) {
                textView.setVisibility(8);
            }
            int i11 = R$id.mTvCastErrorHint;
            TextView textView2 = (TextView) titanPlayerController._$_findCachedViewById(i11);
            if (textView2 != null) {
                textView2.setText(titanPlayerController.getResources().getString(R.string.cast_restart_device));
            }
            TextView textView3 = (TextView) titanPlayerController._$_findCachedViewById(i11);
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        } else {
            TextView textView4 = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastRecommendHint);
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            TextView textView5 = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastErrorHint);
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
        }
        int i12 = R$id.mTvCastState;
        TextView textView6 = (TextView) titanPlayerController._$_findCachedViewById(i12);
        if (textView6 != null) {
            textView6.setText(titanPlayerController.getContext().getResources().getString(R.string.cast_status_casting_failed));
        }
        TextView textView7 = (TextView) titanPlayerController._$_findCachedViewById(i12);
        if (textView7 != null) {
            textView7.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN + str2 + ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER + i10 + ASCIIPropertyListParser.ARRAY_END_TOKEN);
        }
        TextView textView8 = (TextView) titanPlayerController._$_findCachedViewById(i12);
        if (textView8 != null) {
            textView8.setTextColor(titanPlayerController.getContext().getResources().getColor(R.color.color_f72f2f));
        }
        TextView textView9 = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTvPleaseWait);
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
    }

    public static final void K3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void K4(TitanPlayerController titanPlayerController, BaseGuideManager baseGuideManager) {
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(baseGuideManager, "$baseGuideManager");
        if (!titanPlayerController.B2()) {
            baseGuideManager.showGuide();
        }
    }

    public static final void L2(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        com.mobile.brasiltv.utils.g.f12519a.A(true);
        xa.c.c().j(new CastPlaySuccessEvent("VOD"));
        ((TextView) titanPlayerController._$_findCachedViewById(R$id.mTvPleaseWait)).setVisibility(0);
        int i10 = R$id.mTvCastState;
        ((TextView) titanPlayerController._$_findCachedViewById(i10)).setText(titanPlayerController.getContext().getResources().getString(R.string.cast_status_prepare));
        ((TextView) titanPlayerController._$_findCachedViewById(i10)).setTextColor(titanPlayerController.getContext().getResources().getColor(R.color.color_fffefe));
        ((TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(4);
        ((TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastErrorHint)).setVisibility(8);
        titanPlayerController.q3();
        ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_pause_white);
    }

    public static final void L3(TitanPlayerController titanPlayerController, ObservableEmitter observableEmitter) {
        String str;
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(observableEmitter, "it");
        MobileDao mSubtitleAndAudioLanguageDao = titanPlayerController.getMSubtitleAndAudioLanguageDao();
        AssetData assetData = titanPlayerController.f6106f;
        if (assetData == null || (str = assetData.getContentId()) == null) {
            str = "";
        }
        SubtitleSettingBean querySubtitleSetting = mSubtitleAndAudioLanguageDao.querySubtitleSetting(str);
        if (querySubtitleSetting != null) {
            observableEmitter.onNext(querySubtitleSetting);
        } else {
            observableEmitter.onNext(new SubtitleSettingBean());
        }
    }

    public static final void M0(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.k2(true);
    }

    public static final void M2(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f12519a;
        gVar.B(true);
        gVar.C(false);
        ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
    }

    public static final void M3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void N2(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        xa.c.c().j(new CastPlaySuccessEvent("VOD"));
        com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f12519a;
        gVar.C(true);
        gVar.z(true);
        int i10 = R$id.mTvCastState;
        ((TextView) titanPlayerController._$_findCachedViewById(i10)).setText(titanPlayerController.getContext().getResources().getString(R.string.cast_status_casting));
        ((TextView) titanPlayerController._$_findCachedViewById(i10)).setTextColor(titanPlayerController.getContext().getResources().getColor(R.color.color_fffefe));
        ((TextView) titanPlayerController._$_findCachedViewById(R$id.mTvPleaseWait)).setVisibility(8);
        ((TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(4);
        ((TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastErrorHint)).setVisibility(8);
        titanPlayerController.q3();
        ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_pause_white);
    }

    public static final void N3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void O2(long j10, long j11, TitanPlayerController titanPlayerController) {
        CharSequence charSequence;
        TextView textView;
        SeekBar seekBar;
        t9.i.g(titanPlayerController, "this$0");
        int i10 = R$id.mTvCastState;
        TextView textView2 = (TextView) titanPlayerController._$_findCachedViewById(i10);
        if (textView2 != null) {
            textView2.setText(titanPlayerController.getContext().getResources().getString(R.string.cast_status_casting));
        }
        TextView textView3 = (TextView) titanPlayerController._$_findCachedViewById(i10);
        if (textView3 != null) {
            textView3.setTextColor(titanPlayerController.getContext().getResources().getColor(R.color.color_fffefe));
        }
        TextView textView4 = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTvPleaseWait);
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        TextView textView5 = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastRecommendHint);
        if (textView5 != null) {
            textView5.setVisibility(4);
        }
        TextView textView6 = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastErrorHint);
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        int i11 = R$id.mSeekBarCast;
        SeekBar seekBar2 = (SeekBar) titanPlayerController._$_findCachedViewById(i11);
        boolean z10 = false;
        if (seekBar2 != null && seekBar2.getMax() == ((int) j10)) {
            z10 = true;
        }
        if (!z10 && (seekBar = (SeekBar) titanPlayerController._$_findCachedViewById(i11)) != null) {
            seekBar.setMax((int) j10);
        }
        SeekBar seekBar3 = (SeekBar) titanPlayerController._$_findCachedViewById(i11);
        if (seekBar3 != null) {
            seekBar3.setProgress((int) j11);
        }
        String l10 = y6.a.l(j10);
        String l11 = y6.a.l(j11);
        int i12 = R$id.mTextTotalTimeCast;
        TextView textView7 = (TextView) titanPlayerController._$_findCachedViewById(i12);
        if (textView7 != null) {
            charSequence = textView7.getText();
        } else {
            charSequence = null;
        }
        if (!t9.i.b(charSequence, '/' + l10) && (textView = (TextView) titanPlayerController._$_findCachedViewById(i12)) != null) {
            textView.setText('/' + l10);
        }
        TextView textView8 = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTextCurTimeCast);
        if (textView8 != null) {
            textView8.setText(l11);
        }
        titanPlayerController.C = j11 * ((long) 1000);
    }

    public static final void O3(TitanPlayerController titanPlayerController, ObservableEmitter observableEmitter) {
        String str;
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(observableEmitter, "it");
        MobileDao mSubtitleAndAudioLanguageDao = titanPlayerController.getMSubtitleAndAudioLanguageDao();
        AssetData assetData = titanPlayerController.f6106f;
        if (assetData == null || (str = assetData.getContentId()) == null) {
            str = "";
        }
        SubtitleSettingBean querySubtitleSetting = mSubtitleAndAudioLanguageDao.querySubtitleSetting(str);
        if (querySubtitleSetting != null) {
            observableEmitter.onNext(querySubtitleSetting);
        } else {
            observableEmitter.onNext(new SubtitleSettingBean());
        }
    }

    public static final void Q2(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
        int i10 = R$id.mSeekBarCast;
        if (((SeekBar) titanPlayerController._$_findCachedViewById(i10)).getProgress() > ((SeekBar) titanPlayerController._$_findCachedViewById(i10)).getMax() - 10) {
            titanPlayerController.I2();
        } else {
            titanPlayerController.A4(-2, "");
        }
    }

    public static final void R1(TitanPlayerController titanPlayerController) {
        long j10;
        t9.i.g(titanPlayerController, "this$0");
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        if (hVar.o()) {
            Program program = titanPlayerController.E0;
            if (program != null) {
                j10 = program.getStart();
            } else {
                j10 = 0;
            }
            titanPlayerController.C = j10;
            V1(titanPlayerController, false, false, 2, (Object) null);
        }
        if (titanPlayerController.J0 || hVar.o() || (hVar.o() && t9.i.b(titanPlayerController.B, "0") && titanPlayerController.I0)) {
            xa.c.c().j(new CastToPlayEvent("VOD"));
            titanPlayerController.I0 = false;
        }
    }

    public static final boolean R3(TitanPlayerController titanPlayerController, GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(gestureDetector, "$mGestureDetector");
        t9.i.f(view, "v");
        t9.i.f(motionEvent, "event");
        return titanPlayerController.Z4(view, motionEvent, gestureDetector);
    }

    public static final void S1(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        if (com.mobile.brasiltv.utils.b0.K(titanPlayerController.G0) && titanPlayerController.f6142x) {
            String str = titanPlayerController.G0;
            if (str != null) {
                Integer num = titanPlayerController.H0;
                t9.i.d(num);
                titanPlayerController.A4(num.intValue(), str);
            }
            titanPlayerController.F0 = true;
        }
        if (!titanPlayerController.J0) {
            com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
            if (!hVar.o() && (!hVar.o() || !t9.i.b(titanPlayerController.B, "0") || !titanPlayerController.I0)) {
                return;
            }
        }
        if (!titanPlayerController.F0) {
            xa.c.c().j(new CastToPlayEvent("VOD"));
            titanPlayerController.I0 = false;
        }
    }

    public static final void T1(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        V1(titanPlayerController, false, false, 2, (Object) null);
    }

    public static /* synthetic */ void V1(TitanPlayerController titanPlayerController, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        titanPlayerController.U1(z10, z11);
    }

    public static final void W3(TitanPlayerController titanPlayerController, int i10, ObservableEmitter observableEmitter) {
        boolean z10;
        List<SimpleProgramList> simpleProgramList;
        SimpleProgramList simpleProgramList2;
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(observableEmitter, "emitter");
        List<PosterList> list = null;
        if (t9.i.b(titanPlayerController.B, "0")) {
            AssetData assetData = titanPlayerController.f6106f;
            if (!(assetData == null || (simpleProgramList = assetData.getSimpleProgramList()) == null || (simpleProgramList2 = simpleProgramList.get(i10)) == null)) {
                list = simpleProgramList2.getPosterList();
            }
        } else {
            AssetData assetData2 = titanPlayerController.f6106f;
            if (assetData2 != null) {
                list = assetData2.getPosterList();
            }
        }
        if (list != null) {
            for (PosterList posterList : list) {
                if (t9.i.b(posterList.getFileType(), a7.d.f10697a.k())) {
                    String fileUrl = posterList.getFileUrl();
                    t9.i.f(fileUrl, "it.fileUrl");
                    if (fileUrl.length() > 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        observableEmitter.onNext(posterList.getFileUrl());
                        observableEmitter.onComplete();
                        return;
                    }
                }
            }
        }
        observableEmitter.onError(new Throwable());
    }

    public static final void X3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void Y1(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.f6144y = true;
        ((AutoLinearLayout) titanPlayerController._$_findCachedViewById(R$id.mLayoutMobileNotify)).setVisibility(8);
        ((TitanVODView) titanPlayerController._$_findCachedViewById(R$id.mVideoViewVod)).w();
        titanPlayerController.X2();
    }

    public static final void Y3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void a4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        if (!titanPlayerController.S) {
            titanPlayerController.V = true;
            if (!titanPlayerController.W1() && !titanPlayerController.f6111h0) {
                ((BeforeVodAdView) titanPlayerController._$_findCachedViewById(R$id.mBvavAd)).hideBeforeVodAd();
                s1.m mVar = s1.m.f9270a;
                Context context = titanPlayerController.getContext();
                t9.i.f(context, com.umeng.analytics.pro.f.X);
                String n10 = a6.a.f10646a.n();
                l0 l0Var = new l0(titanPlayerController);
                i.c cVar = w6.i.f9510g;
                s1.m.C(mVar, context, n10, l0Var, cVar.I(), false, cVar.r(), 16, (Object) null);
            } else if (titanPlayerController.W) {
                titanPlayerController.X2();
                if (titanPlayerController.D) {
                    ((TitanVODView) titanPlayerController._$_findCachedViewById(R$id.mVideoViewVod)).x(0);
                } else {
                    ((TitanVODView) titanPlayerController._$_findCachedViewById(R$id.mVideoViewVod)).w();
                }
            } else {
                ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
                titanPlayerController.D4(false);
                ((RelativeLayout) titanPlayerController._$_findCachedViewById(R$id.mBufferView)).setVisibility(0);
            }
        } else {
            ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
            titanPlayerController.D4(false);
            int i10 = R$id.mVideoViewVod;
            if (((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).s()) {
                ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).u();
                titanPlayerController.H4();
                titanPlayerController.F4();
                return;
            }
            titanPlayerController.G4();
            if (titanPlayerController.D) {
                ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).x(0);
            } else {
                ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).w();
            }
            titanPlayerController.G = false;
            titanPlayerController.w2();
        }
    }

    public static final void b4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        com.mobile.brasiltv.utils.b0.k(titanPlayerController.getMActivity(), RootColumnId.freeVodColumn, -1, titanPlayerController.f6118l);
    }

    public static final void c4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        i.c cVar = w6.i.f9510g;
        String I2 = cVar.I();
        boolean z10 = true;
        switch (I2.hashCode()) {
            case 49:
                if (I2.equals("1")) {
                    com.mobile.brasiltv.utils.b0.c0(titanPlayerController.getMActivity(), AccountBindAty.class);
                    return;
                }
                return;
            case 50:
                if (I2.equals("2")) {
                    com.mobile.brasiltv.utils.b0.U(titanPlayerController, "beVipUrl:" + cVar.g());
                    if (cVar.g().length() <= 0) {
                        z10 = false;
                    }
                    if (z10) {
                        Context context = titanPlayerController.getContext();
                        t9.i.f(context, com.umeng.analytics.pro.f.X);
                        com.mobile.brasiltv.utils.b0.j0(context, cVar.g(), false, true, false, false, 24, (Object) null);
                        return;
                    }
                    return;
                }
                return;
            case 51:
                if (I2.equals("3") && titanPlayerController.f6118l) {
                    com.mobile.brasiltv.utils.b0.U(titanPlayerController, "beVipUrl:" + cVar.g());
                    if (cVar.g().length() <= 0) {
                        z10 = false;
                    }
                    if (z10) {
                        Context context2 = titanPlayerController.getContext();
                        t9.i.f(context2, com.umeng.analytics.pro.f.X);
                        com.mobile.brasiltv.utils.b0.j0(context2, cVar.g(), false, true, false, false, 24, (Object) null);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static final void d2(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void d4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        if (((AutoLinearLayout) titanPlayerController._$_findCachedViewById(R$id.mLayoutMobileNotify)).getVisibility() != 0) {
            ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mPlayPauseIcon)).performClick();
        }
    }

    public static final void e2(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void e4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.f6103c.q();
    }

    public static final void f4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        AutoFrameLayout autoFrameLayout = (AutoFrameLayout) titanPlayerController._$_findCachedViewById(R$id.mLayoutSetInfo);
        t9.i.f(autoFrameLayout, "mLayoutSetInfo");
        titanPlayerController.L4(autoFrameLayout, AutoUtils.getPercentWidthSize(580));
        titanPlayerController.b2();
    }

    public static final void g3(TitanPlayerController titanPlayerController, AudioSettingBean audioSettingBean, ObservableEmitter observableEmitter) {
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(audioSettingBean, "$audioSetting");
        t9.i.g(observableEmitter, "it");
        Context applicationContext = titanPlayerController.getContext().getApplicationContext();
        t9.i.f(applicationContext, "context.applicationContext");
        new MobileDao(applicationContext).addAudioSetting(audioSettingBean);
        observableEmitter.onNext(audioSettingBean);
        observableEmitter.onComplete();
    }

    public static final void g4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.getSubtitleAudioLandWindow().setWidth(-1);
        titanPlayerController.getSubtitleAudioLandWindow().setHeight(-1);
        titanPlayerController.getSubtitleAudioLandWindow().d(titanPlayerController, true);
        titanPlayerController.getSubtitleAudioLandWindow().s(titanPlayerController.f6123n0, titanPlayerController.f6115j0 + 1, titanPlayerController.f6117k0, titanPlayerController.f6119l0, titanPlayerController.f6121m0);
    }

    private final MobileDao getMSubtitleAndAudioLanguageDao() {
        return (MobileDao) this.K0.getValue();
    }

    private final MediaMetadata getMediaMetadata() {
        MediaMetadata mediaMetadata = new MediaMetadata(1);
        AssetData assetData = this.f6106f;
        t9.i.d(assetData);
        String alias = assetData.getAlias();
        AssetData assetData2 = this.f6106f;
        t9.i.d(assetData2);
        mediaMetadata.putString(MediaMetadata.KEY_TITLE, com.mobile.brasiltv.utils.b0.e(alias, assetData2.getName()));
        mediaMetadata.putString(MediaMetadata.KEY_SUBTITLE, "");
        AssetData assetData3 = this.f6106f;
        t9.i.d(assetData3);
        if (!assetData3.getPosterList().isEmpty()) {
            AssetData assetData4 = this.f6106f;
            t9.i.d(assetData4);
            mediaMetadata.addImage(new WebImage(Uri.parse(assetData4.getPosterList().get(0).getFileUrl())));
        }
        AssetData assetData5 = this.f6106f;
        t9.i.d(assetData5);
        if (assetData5.getPosterList().size() > 1) {
            AssetData assetData6 = this.f6106f;
            t9.i.d(assetData6);
            mediaMetadata.addImage(new WebImage(Uri.parse(assetData6.getPosterList().get(1).getFileUrl())));
        }
        return mediaMetadata;
    }

    private final float getRealCurBrightness() {
        boolean z10;
        int i10 = 0;
        if (getMActivity().getWindow().getAttributes().screenBrightness == -1.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return getMActivity().getWindow().getAttributes().screenBrightness;
        }
        try {
            i10 = Settings.System.getInt(getMActivity().getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e10) {
            e10.printStackTrace();
        }
        Resources system = Resources.getSystem();
        return ((float) i10) / ((float) system.getInteger(system.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android")));
    }

    private final n6.a getSetInfoAdapter() {
        return (n6.a) this.f6136u.getValue();
    }

    private final ArrayList<String> getSizeList() {
        return (ArrayList) this.f6131r0.getValue();
    }

    private final ArrayList<SubtitleStyleBean> getStyleList() {
        return (ArrayList) this.f6133s0.getValue();
    }

    /* access modifiers changed from: private */
    public final g7.n getSubtitleAudioLandWindow() {
        return (g7.n) this.f6138v.getValue();
    }

    /* access modifiers changed from: private */
    public final g7.p getSubtitleAudioPorWindow() {
        return (g7.p) this.f6140w.getValue();
    }

    public static final void h3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void h4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.f6103c.t();
        ((AutoFrameLayout) titanPlayerController._$_findCachedViewById(R$id.mFlLocked)).setVisibility(0);
        titanPlayerController.D2();
        ((AlphaRelativeLayout) titanPlayerController._$_findCachedViewById(R$id.mLayoutController)).setVisibility(8);
    }

    public static final void i2(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        int i10 = R$id.mVideoViewVod;
        if (!((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).s()) {
            titanPlayerController.j3(titanPlayerController.C);
            ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).w();
        }
    }

    public static final void i3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void i4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.f6103c.x();
        ((AutoFrameLayout) titanPlayerController._$_findCachedViewById(R$id.mFlLocked)).setVisibility(8);
        Disposable disposable = titanPlayerController.B0;
        if (disposable != null) {
            disposable.dispose();
        }
        ((AlphaRelativeLayout) titanPlayerController._$_findCachedViewById(R$id.mLayoutController)).setVisibility(0);
        titanPlayerController.z3();
        titanPlayerController.B3();
    }

    public static final void j2(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        int i10 = R$id.mVideoViewVod;
        if (!((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).s()) {
            titanPlayerController.j3(titanPlayerController.C);
            ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).w();
        }
    }

    public static final void j4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        m6.a aVar = titanPlayerController.M;
        if (aVar != null) {
            ImageView imageView = (ImageView) titanPlayerController._$_findCachedViewById(R$id.mImageQuality);
            t9.i.f(imageView, "mImageQuality");
            aVar.t0(imageView, titanPlayerController.B2(), false);
        }
    }

    public static /* synthetic */ void k3(TitanPlayerController titanPlayerController, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        titanPlayerController.j3(j10);
    }

    public static final void k4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.f2(-titanPlayerController.f6141w0);
    }

    public static /* synthetic */ void l2(TitanPlayerController titanPlayerController, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        titanPlayerController.k2(z10);
    }

    public static final void l4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.f2(titanPlayerController.f6141w0);
    }

    public static final void m3(TitanPlayerController titanPlayerController, SubtitleSettingBean subtitleSettingBean, ObservableEmitter observableEmitter) {
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(subtitleSettingBean, "$subtitleSetting");
        t9.i.g(observableEmitter, "it");
        Context applicationContext = titanPlayerController.getContext().getApplicationContext();
        t9.i.f(applicationContext, "context.applicationContext");
        new MobileDao(applicationContext).addSubtitleSetting(subtitleSettingBean);
        observableEmitter.onNext(subtitleSettingBean);
        observableEmitter.onComplete();
    }

    public static final void m4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.Y4();
    }

    public static final void n3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void n4(TitanPlayerController titanPlayerController, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        t9.i.g(titanPlayerController, "this$0");
        if (i10 != titanPlayerController.f6124o) {
            titanPlayerController.I0 = true;
            titanPlayerController.p3(i10);
            Disposable disposable = titanPlayerController.C0;
            if (disposable != null) {
                disposable.dispose();
            }
            AutoFrameLayout autoFrameLayout = (AutoFrameLayout) titanPlayerController._$_findCachedViewById(R$id.mLayoutSetInfo);
            t9.i.f(autoFrameLayout, "mLayoutSetInfo");
            titanPlayerController.N4(autoFrameLayout, AutoUtils.getPercentWidthSize(580));
            titanPlayerController.E = false;
            titanPlayerController.f6111h0 = false;
            ((BeforeVodAdView) titanPlayerController._$_findCachedViewById(R$id.mBvavAd)).hideBeforeVodAd();
        }
    }

    public static final void o3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void o4(TitanPlayerController titanPlayerController, View view) {
        String str;
        String str2;
        Integer num;
        String str3;
        String str4;
        t9.i.g(titanPlayerController, "this$0");
        Object obj = null;
        if (!t9.i.b(titanPlayerController.B, "0")) {
            AssetData assetData = titanPlayerController.f6106f;
            if (assetData != null) {
                str4 = assetData.getAlias();
            } else {
                str4 = null;
            }
            String valueOf = String.valueOf(str4);
            AssetData assetData2 = titanPlayerController.f6106f;
            if (assetData2 != null) {
                obj = assetData2.getName();
            }
            str = com.mobile.brasiltv.utils.b0.e(valueOf, String.valueOf(obj));
        } else {
            StringBuilder sb = new StringBuilder();
            AssetData assetData3 = titanPlayerController.f6106f;
            if (assetData3 != null) {
                str2 = assetData3.getAlias();
            } else {
                str2 = null;
            }
            sb.append(str2);
            sb.append('_');
            SimpleProgramList simpleProgramList = titanPlayerController.f6112i;
            if (simpleProgramList != null) {
                num = Integer.valueOf(simpleProgramList.getSeriesNumber());
            } else {
                num = null;
            }
            sb.append(num);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            AssetData assetData4 = titanPlayerController.f6106f;
            if (assetData4 != null) {
                str3 = assetData4.getName();
            } else {
                str3 = null;
            }
            sb3.append(str3);
            sb3.append('_');
            SimpleProgramList simpleProgramList2 = titanPlayerController.f6112i;
            if (simpleProgramList2 != null) {
                obj = Integer.valueOf(simpleProgramList2.getSeriesNumber());
            }
            sb3.append(obj);
            str = com.mobile.brasiltv.utils.b0.e(sb2, sb3.toString());
        }
        CommonDialog feedBackDialog = FeedBackDialog.Companion.getFeedBackDialog(titanPlayerController.getMActivity(), titanPlayerController.f6103c.l(), 1, str);
        titanPlayerController.A0 = feedBackDialog;
        if (feedBackDialog != null) {
            feedBackDialog.show();
        }
        CommonDialog commonDialog = titanPlayerController.A0;
        if (commonDialog != null) {
            commonDialog.setOnDismissListener(new g1(titanPlayerController));
        }
    }

    public static final void p4(TitanPlayerController titanPlayerController, DialogInterface dialogInterface) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.A0 = null;
    }

    public static final void q4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        i1.I(titanPlayerController.getContext(), "vodFullScreen");
        f5.c mActivity = titanPlayerController.getMActivity();
        com.mobile.brasiltv.utils.b0.j0(mActivity, w6.i.f9510g.C() + "/#/shareApp", false, true, false, false, 24, (Object) null);
    }

    public static final void r2(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void r4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
    }

    public static final void s3(TitanPlayerController titanPlayerController, View view) {
        Media media;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String buss;
        String lang;
        List<Media> medias;
        TitanPlayerController titanPlayerController2 = titanPlayerController;
        t9.i.g(titanPlayerController2, "this$0");
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        if (t9.i.b(hVar.a(), hVar.k())) {
            com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f12519a;
            if (gVar.m()) {
                gVar.p();
            } else if (gVar.l()) {
                gVar.r();
            } else if (gVar.j()) {
                Program program = titanPlayerController2.E0;
                if (program == null || (medias = program.getMedias()) == null) {
                    media = null;
                } else {
                    media = medias.get(0);
                }
                titanPlayerController.Q4();
                if (titanPlayerController2.f6127p0) {
                    str = titanPlayerController2.T4(hVar.e(), "dlna");
                } else {
                    str = hVar.e();
                }
                String str13 = str;
                Program program2 = titanPlayerController2.E0;
                if (program2 == null || (str2 = program2.getMedia()) == null) {
                    str2 = "";
                }
                Program program3 = titanPlayerController2.E0;
                if (program3 == null || (str3 = program3.getName()) == null) {
                    str3 = "";
                }
                Program program4 = titanPlayerController2.E0;
                if (program4 == null || (str4 = program4.getTitle()) == null) {
                    str4 = "";
                }
                Program program5 = titanPlayerController2.E0;
                if (program5 == null || (str5 = program5.getEpisode()) == null) {
                    str5 = "";
                }
                Program program6 = titanPlayerController2.E0;
                if (program6 == null || (str6 = program6.getBuss()) == null) {
                    str6 = "";
                }
                if (media == null || (str7 = media.getFormat()) == null) {
                    str7 = "";
                }
                if (media == null || (str8 = media.getVcodec()) == null) {
                    str8 = "";
                }
                if (media == null || (str9 = media.getQuality()) == null) {
                    str9 = "";
                }
                if (media == null || (lang = media.getLang()) == null) {
                    str10 = "";
                } else {
                    str10 = lang;
                }
                Program program7 = titanPlayerController2.E0;
                if (program7 == null || (buss = program7.getBuss()) == null) {
                    str11 = "";
                } else {
                    str11 = buss;
                }
                String str14 = titanPlayerController2.f6129q0;
                if (str14 == null) {
                    str12 = "";
                } else {
                    str12 = str14;
                }
                gVar.E(str13, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, 0, str12, titanPlayerController2.f6127p0);
            }
        } else if (t9.i.b(hVar.a(), hVar.l())) {
            titanPlayerController2.N.k();
        }
    }

    public static final void s4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        m6.a aVar = titanPlayerController.M;
        if (aVar != null) {
            ImageView imageView = (ImageView) titanPlayerController._$_findCachedViewById(R$id.mImageQuality);
            t9.i.f(imageView, "mImageQuality");
            aVar.t0(imageView, titanPlayerController.B2(), false);
        }
    }

    private final void setClickAdOnBeforePlaySeries(String str) {
        ((BeforeVodAdView) _$_findCachedViewById(R$id.mBvavAd)).setBeforeVodCallback(new u(this));
    }

    private final void setDefaultSubtitleOption(List<SubTitleData> list) {
        String str;
        String contentId;
        String str2;
        String str3;
        Integer num;
        String str4;
        String str5;
        this.f6115j0 = -1;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append("list:");
        sb.append(list);
        String str6 = "";
        if (com.mobile.brasiltv.utils.b0.I(list)) {
            SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
            LruCache<String, Boolean> mLruCacheSwitch = subtitleManager.getMLruCacheSwitch();
            AssetData assetData = this.f6106f;
            if (assetData == null || (str2 = assetData.getContentId()) == null) {
                str2 = str6;
            }
            Boolean bool = mLruCacheSwitch.get(str2);
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                this.f6121m0 = booleanValue;
                if (booleanValue) {
                    HashMap<String, RecordSubtitleInfoBean> mLruCacheLanguages = subtitleManager.getMLruCacheLanguages();
                    AssetData assetData2 = this.f6106f;
                    if (assetData2 == null || (str3 = assetData2.getContentId()) == null) {
                        str3 = str6;
                    }
                    RecordSubtitleInfoBean recordSubtitleInfoBean = mLruCacheLanguages.get(str3);
                    String str7 = null;
                    if (recordSubtitleInfoBean != null) {
                        num = Integer.valueOf(recordSubtitleInfoBean.getSubtitleIndex());
                    } else {
                        num = null;
                    }
                    HashMap<String, RecordSubtitleInfoBean> mLruCacheLanguages2 = subtitleManager.getMLruCacheLanguages();
                    AssetData assetData3 = this.f6106f;
                    if (assetData3 == null || (str4 = assetData3.getContentId()) == null) {
                        str4 = str6;
                    }
                    RecordSubtitleInfoBean recordSubtitleInfoBean2 = mLruCacheLanguages2.get(str4);
                    if (recordSubtitleInfoBean2 != null) {
                        str5 = recordSubtitleInfoBean2.getSubTitleLanguage();
                    } else {
                        str5 = null;
                    }
                    if (num == null || num.intValue() >= list.size()) {
                        Observable.create(new m6.t0(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new t1(new a0(list, arrayList, arrayList2, this)), new u1(b0.f12416a));
                    } else {
                        SubTitleData subTitleData = (SubTitleData) i9.r.u(list, num.intValue());
                        if (subTitleData != null) {
                            str7 = subTitleData.getLanguage();
                        }
                        if (!t9.i.b(str7, str5)) {
                            k7.f.c("字幕信息有变化 cacheLanguage : " + str5, new Object[0]);
                            int i10 = 0;
                            for (T next : list) {
                                int i11 = i10 + 1;
                                if (i10 < 0) {
                                    i9.j.j();
                                }
                                if (((SubTitleData) next).getLanguage().equals(str5)) {
                                    arrayList2.add(Integer.valueOf(i10));
                                    if (i10 == num.intValue()) {
                                        arrayList.add(Integer.valueOf(i10));
                                    }
                                }
                                i10 = i11;
                            }
                            if (arrayList.isEmpty()) {
                                if (com.mobile.brasiltv.utils.b0.I(arrayList2)) {
                                    Object obj = arrayList2.get(0);
                                    t9.i.f(obj, "sameLanguage[0]");
                                    this.f6115j0 = ((Number) obj).intValue();
                                } else {
                                    this.f6115j0 = 0;
                                }
                            }
                        } else {
                            this.f6115j0 = num.intValue();
                        }
                    }
                }
            } else {
                Observable.create(new v1(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m6.c(new c0(this, list, arrayList, arrayList2)), new m6.d(d0.f12426a));
            }
        } else {
            this.f6115j0 = -1;
            this.f6121m0 = false;
        }
        SubtitleManager subtitleManager2 = SubtitleManager.INSTANCE;
        LruCache<String, Integer> mLruCacheSize = subtitleManager2.getMLruCacheSize();
        AssetData assetData4 = this.f6106f;
        if (assetData4 == null || (str = assetData4.getContentId()) == null) {
            str = str6;
        }
        Integer num2 = mLruCacheSize.get(str);
        if (num2 == null || num2.intValue() >= getSizeList().size()) {
            Observable.create(new m6.e(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m6.f(new e0(this)), new m6.g(x.f12463a));
        } else {
            this.f6117k0 = num2.intValue();
        }
        LruCache<String, Integer> mLruCacheColor = subtitleManager2.getMLruCacheColor();
        AssetData assetData5 = this.f6106f;
        if (!(assetData5 == null || (contentId = assetData5.getContentId()) == null)) {
            str6 = contentId;
        }
        Integer num3 = mLruCacheColor.get(str6);
        if (num3 == null || num3.intValue() >= getStyleList().size()) {
            Observable.create(new m6.h(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e1(new y(this)), new p1(z.f12465a));
        } else {
            this.f6119l0 = num3.intValue();
        }
    }

    private final void setFullScreenAttr(boolean z10) {
        WindowManager.LayoutParams layoutParams = null;
        if (z10) {
            Window window = getMActivity().getWindow();
            if (window != null) {
                layoutParams = window.getAttributes();
            }
            if (layoutParams != null) {
                layoutParams.flags |= 1024;
                Window window2 = getMActivity().getWindow();
                if (window2 != null) {
                    window2.setAttributes(layoutParams);
                    return;
                }
                return;
            }
            return;
        }
        Window window3 = getMActivity().getWindow();
        if (window3 != null) {
            layoutParams = window3.getAttributes();
        }
        if (layoutParams != null) {
            layoutParams.flags &= -1025;
            Window window4 = getMActivity().getWindow();
            if (window4 != null) {
                window4.setAttributes(layoutParams);
            }
        }
    }

    private final void setSeekBarClickable(boolean z10) {
        if (z10) {
            int i10 = R$id.mSeekBar;
            ((CurTimeSeekBar) _$_findCachedViewById(i10)).setClickable(true);
            ((CurTimeSeekBar) _$_findCachedViewById(i10)).setEnabled(true);
            ((CurTimeSeekBar) _$_findCachedViewById(i10)).setFocusable(true);
            return;
        }
        int i11 = R$id.mSeekBar;
        ((CurTimeSeekBar) _$_findCachedViewById(i11)).setClickable(false);
        ((CurTimeSeekBar) _$_findCachedViewById(i11)).setEnabled(false);
        ((CurTimeSeekBar) _$_findCachedViewById(i11)).setFocusable(false);
    }

    private final void setStage(int i10) {
        Disposable disposable = this.Q;
        if (disposable != null) {
            disposable.dispose();
        }
        this.Q = Observable.create(new m6.b(this, i10)).compose(com.mobile.brasiltv.utils.p0.a()).subscribe(new m6.m(new j0(this)), new m6.x(new k0(this)));
    }

    public static final void t3(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        m6.a aVar = titanPlayerController.M;
        if (aVar != null) {
            t9.i.f(view, "it");
            aVar.t0(view, titanPlayerController.B2(), true);
        }
    }

    public static final void t4(TitanPlayerController titanPlayerController, View view) {
        Program program;
        Program program2;
        String str;
        TitanVODView titanVODView;
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.w2();
        Program program3 = null;
        k3(titanPlayerController, 0, 1, (Object) null);
        int i10 = R$id.mVideoViewVod;
        n8.b titanContext = ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).getTitanContext();
        if (titanContext != null) {
            program = titanContext.h();
        } else {
            program = null;
        }
        titanPlayerController.E0 = program;
        n8.b titanContext2 = ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).getTitanContext();
        if (titanContext2 != null) {
            program2 = titanContext2.h();
        } else {
            program2 = null;
        }
        if (program2 != null) {
            ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).D();
            titanPlayerController.W = false;
        }
        n8.b titanContext3 = ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).getTitanContext();
        if (titanContext3 != null) {
            program3 = titanContext3.a();
        }
        if (!(program3 == null || (titanVODView = (TitanVODView) titanPlayerController._$_findCachedViewById(i10)) == null)) {
            titanVODView.C();
        }
        Program program4 = titanPlayerController.E0;
        if (program4 != null) {
            titanPlayerController.c3();
            TitanVODView titanVODView2 = (TitanVODView) titanPlayerController._$_findCachedViewById(i10);
            Program program5 = titanPlayerController.E0;
            if (program5 == null || (str = program5.getBuss()) == null) {
                str = "";
            }
            titanVODView2.v(program4, str);
        }
        com.mobile.brasiltv.utils.h.f12562a.K(false);
        m6.a aVar = titanPlayerController.M;
        if (aVar != null) {
            ImageView imageView = (ImageView) titanPlayerController._$_findCachedViewById(R$id.mImageQuality);
            t9.i.f(imageView, "mImageQuality");
            aVar.z(imageView, titanPlayerController.B2(), titanPlayerController.f6110h);
        }
    }

    public static /* synthetic */ void u2(TitanPlayerController titanPlayerController, VodDao vodDao, AssetData assetData, String str, EnterType enterType, String str2, boolean z10, boolean z11, int i10, Object obj) {
        boolean z12;
        if ((i10 & 64) != 0) {
            z12 = true;
        } else {
            z12 = z11;
        }
        titanPlayerController.s2(vodDao, assetData, str, enterType, str2, z10, z12);
    }

    public static final void u3(TitanPlayerController titanPlayerController, View view) {
        Program program;
        m6.a aVar;
        t9.i.g(titanPlayerController, "this$0");
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        if (t9.i.b(hVar.a(), hVar.k())) {
            if (hVar.t()) {
                com.mobile.brasiltv.utils.g.f12519a.G();
                hVar.v(false);
            }
        } else if (t9.i.b(hVar.a(), hVar.l())) {
            titanPlayerController.N.r();
            titanPlayerController.N.s();
        }
        int i10 = R$id.mVideoViewVod;
        n8.b titanContext = ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).getTitanContext();
        Program program2 = null;
        if (titanContext != null) {
            program = titanContext.a();
        } else {
            program = null;
        }
        if (program != null) {
            ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).C();
        }
        titanPlayerController.j3(((long) titanPlayerController.W2()) * 1000);
        xa.c.c().j(new CastToCloseFloatViewEvent());
        V1(titanPlayerController, true, false, 2, (Object) null);
        n8.b titanContext2 = ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).getTitanContext();
        if (titanContext2 != null) {
            program2 = titanContext2.h();
        }
        if (program2 == null && (aVar = titanPlayerController.M) != null) {
            aVar.m();
        }
    }

    public static final void u4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        Context context = titanPlayerController.getContext();
        if (context != null) {
            com.mobile.brasiltv.utils.b0.l(context);
        }
    }

    public static final void v3(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        xa.c.c().j(new CastToCloseOtherPlayEvent("VOD", false, 2, (t9.g) null));
        Context context = titanPlayerController.getContext();
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.d0((f5.c) context, CastByNativeDeviceAty.class, s.f12454a);
    }

    public static final void v4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.getSubtitleAudioPorWindow().setWidth(-1);
        titanPlayerController.getSubtitleAudioPorWindow().setHeight(-2);
        titanPlayerController.getSubtitleAudioPorWindow().c(true);
        titanPlayerController.getSubtitleAudioPorWindow().s(titanPlayerController.f6123n0, titanPlayerController.f6115j0 + 1, titanPlayerController.f6117k0, titanPlayerController.f6119l0, titanPlayerController.f6121m0);
    }

    public static final void w3(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        Context context = titanPlayerController.getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        new CastFeedBackDialog(context).show();
    }

    public static final boolean w4(TitanPlayerController titanPlayerController, View view, MotionEvent motionEvent) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.b2();
        return false;
    }

    public static final void x4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        AutoFrameLayout autoFrameLayout = (AutoFrameLayout) titanPlayerController._$_findCachedViewById(R$id.mLayoutSetInfo);
        t9.i.f(autoFrameLayout, "mLayoutSetInfo");
        titanPlayerController.N4(autoFrameLayout, AutoUtils.getPercentWidthSize(580));
    }

    public static final void y3(TitanPlayerController titanPlayerController, View view) {
        Program program;
        String str;
        TitanVODView titanVODView;
        t9.i.g(titanPlayerController, "this$0");
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        hVar.K(false);
        int i10 = R$id.mVideoViewVod;
        n8.b titanContext = ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).getTitanContext();
        if (titanContext != null) {
            program = titanContext.a();
        } else {
            program = null;
        }
        if (!(program == null || (titanVODView = (TitanVODView) titanPlayerController._$_findCachedViewById(i10)) == null)) {
            titanVODView.C();
        }
        Program program2 = titanPlayerController.E0;
        if (program2 != null) {
            TitanVODView titanVODView2 = (TitanVODView) titanPlayerController._$_findCachedViewById(i10);
            Program program3 = titanPlayerController.E0;
            if (program3 == null || (str = program3.getBuss()) == null) {
                str = "";
            }
            titanVODView2.v(program2, str);
        }
        if (hVar.e() != null) {
            xa.c.c().j(new CastToCloseOtherPlayEvent("VOD", false));
            Context context = titanPlayerController.getContext();
            t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
            com.mobile.brasiltv.utils.b0.d0((f5.c) context, CastByNativeDeviceAty.class, v.f12460a);
        }
    }

    public final void A2(boolean z10) {
        this.F = z10;
        this.G = true;
        this.f6112i = null;
        int i10 = R$id.mLayoutController;
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).setVisibilitySwitch(true);
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).setVisibility(8);
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).enableProxyVisibility(false);
        ((RelativeLayout) _$_findCachedViewById(R$id.mBufferView)).setVisibility(8);
        ((AutoRelativeLayout) _$_findCachedViewById(R$id.mMemberTipsLayout)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setText(Html.fromHtml(getResources().getString(R.string.cast_recommend_hint)));
        _$_findCachedViewById(R$id.mLlBrightnessController).setVisibility(8);
        _$_findCachedViewById(R$id.mLlVolumeController).setVisibility(8);
    }

    public final void A3() {
        if (s6.a.f9335a.a().s()) {
            setVodQualityVisibility(0);
        }
        Context context = getContext();
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
        o6.b j32 = ((PlayAty) context).j3();
        if (t9.i.b(j32, o6.c.c())) {
            y4(R.drawable.ic_quality_480p, R.drawable.ic_quality_480p_portrait);
            PlayAty.G.d("1");
        } else if (t9.i.b(j32, o6.c.b())) {
            y4(R.drawable.ic_quality_720p, R.drawable.ic_quality_720p_portrait);
            PlayAty.G.d("2");
        } else if (t9.i.b(j32, o6.c.a())) {
            y4(R.drawable.ic_quality_1080p, R.drawable.ic_quality_1080p_portrait);
            PlayAty.G.d("3");
        } else {
            y4(0, 0);
        }
    }

    public final void A4(int i10, String str) {
        t9.i.g(str, "extra");
        xa.c.c().j(new CastToCloseFloatViewEvent());
        if (com.mobile.brasiltv.utils.b0.K(str)) {
            ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(4);
            int i11 = R$id.mTvCastErrorHint;
            ((TextView) _$_findCachedViewById(i11)).setText(str);
            ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
        } else {
            ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R$id.mTvCastErrorHint)).setVisibility(8);
        }
        int i12 = R$id.mTvCastState;
        ((TextView) _$_findCachedViewById(i12)).setText(getContext().getResources().getString(R.string.cast_status_casting_failed));
        StringBuilder sb = new StringBuilder();
        sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
        sb.append(i10);
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        ((TextView) _$_findCachedViewById(i12)).append(sb.toString());
        ((TextView) _$_findCachedViewById(i12)).setTextColor(getContext().getResources().getColor(R.color.color_f72f2f));
        ((TextView) _$_findCachedViewById(R$id.mTvPleaseWait)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
    }

    public final boolean B2() {
        if (this.f6103c.l() || getMActivity().getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public final void B3() {
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R$id.mPbVolume);
        b8.b bVar = this.f6104d;
        b8.b bVar2 = null;
        if (bVar == null) {
            t9.i.w("mVoiceHelper");
            bVar = null;
        }
        int d10 = 100 * bVar.d();
        b8.b bVar3 = this.f6104d;
        if (bVar3 == null) {
            t9.i.w("mVoiceHelper");
        } else {
            bVar2 = bVar3;
        }
        progressBar.setProgress(d10 / bVar2.e());
    }

    public final void B4(String str) {
        t9.i.g(str, "errorMessage");
        int i10 = R$id.tvPlayTips;
        ((TextView) _$_findCachedViewById(i10)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i10)).setText(str);
        ((TextView) _$_findCachedViewById(i10)).postDelayed(new j1(this), 4000);
    }

    public void C1() {
        int i10 = R$id.mVideoViewVod;
        if (!((TitanVODView) _$_findCachedViewById(i10)).s() && this.V) {
            ((TitanVODView) _$_findCachedViewById(i10)).w();
        }
    }

    public final boolean C2(String str, String str2) {
        if (!t9.i.b(str, IjkMediaFormat.CODEC_NAME_H264) || !t9.i.b(str2, "mp4")) {
            return false;
        }
        return true;
    }

    public final void C3() {
        ((BeforeVodAdView) _$_findCachedViewById(R$id.mBvavAd)).setBeforeVodCallback(new w(this));
    }

    public final void D2() {
        Disposable disposable = this.B0;
        if (disposable != null) {
            disposable.dispose();
        }
        this.B0 = Observable.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new h1(new j(this)), new m6.i1(k.f12439a));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
        if (r1 != false) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D4(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x004a
            boolean r3 = r2.B2()
            if (r3 == 0) goto L_0x004a
            com.mobile.brasiltv.view.adView.PauseAdView r3 = r2.A
            if (r3 == 0) goto L_0x0011
            android.view.ViewParent r3 = r3.getParent()
            goto L_0x0012
        L_0x0011:
            r3 = 0
        L_0x0012:
            r0 = 0
            if (r3 == 0) goto L_0x0033
            com.mobile.brasiltv.view.adView.PauseAdView r3 = r2.A
            r1 = 1
            if (r3 == 0) goto L_0x0022
            int r3 = r3.getWidth()
            if (r3 != 0) goto L_0x0022
            r3 = 1
            goto L_0x0023
        L_0x0022:
            r3 = 0
        L_0x0023:
            if (r3 == 0) goto L_0x004a
            com.mobile.brasiltv.view.adView.PauseAdView r3 = r2.A
            if (r3 == 0) goto L_0x0030
            int r3 = r3.getHeight()
            if (r3 != 0) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r1 = 0
        L_0x0031:
            if (r1 == 0) goto L_0x004a
        L_0x0033:
            int r3 = com.mobile.brasiltv.R$id.mIvFastForward
            android.view.View r3 = r2._$_findCachedViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r3.setVisibility(r0)
            int r3 = com.mobile.brasiltv.R$id.mIvFastRewind
            android.view.View r3 = r2._$_findCachedViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r3.setVisibility(r0)
            goto L_0x0062
        L_0x004a:
            int r3 = com.mobile.brasiltv.R$id.mIvFastForward
            android.view.View r3 = r2._$_findCachedViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r0 = 8
            r3.setVisibility(r0)
            int r3 = com.mobile.brasiltv.R$id.mIvFastRewind
            android.view.View r3 = r2._$_findCachedViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r3.setVisibility(r0)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.player.TitanPlayerController.D4(boolean):void");
    }

    public final void E4() {
        VodGestureGuideManager vodGestureGuideManager = new VodGestureGuideManager(getContext());
        if (vodGestureGuideManager.isShow()) {
            P4(true);
            vodGestureGuideManager.setGuideNextClickListener(new q0(this));
            vodGestureGuideManager.showGuide();
        }
    }

    public void F1() {
    }

    public final void F4() {
        ViewParent viewParent;
        PauseAdView pauseAdView = this.A;
        if (pauseAdView != null) {
            if (pauseAdView != null) {
                viewParent = pauseAdView.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent == null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                addView(this.A, layoutParams);
            }
        }
    }

    public void G0(long j10) {
        U3();
        int i10 = R$id.mSeekBar;
        ((CurTimeSeekBar) _$_findCachedViewById(i10)).setProgress((int) j10);
        ((CurTimeSeekBar) _$_findCachedViewById(i10)).setMax((int) ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).getDuration());
        if (((CurTimeSeekBar) _$_findCachedViewById(i10)).getMax() > 0) {
            setSeekBarClickable(true);
        }
        if (((CurTimeSeekBar) _$_findCachedViewById(i10)).getProgress() != ((CurTimeSeekBar) _$_findCachedViewById(i10)).getMax()) {
            this.D = false;
        }
        if (j10 != 0 && !this.D) {
            this.C = j10;
        }
    }

    public final void G2(float f10) {
        int i10 = R$id.mLayoutController;
        if (((AlphaRelativeLayout) _$_findCachedViewById(i10)).getVisibility() == 8) {
            ((AlphaRelativeLayout) _$_findCachedViewById(i10)).setVisibility(0);
            z3();
            B3();
        }
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).setTag(Boolean.TRUE);
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).delayHide();
        WindowManager.LayoutParams attributes = getMActivity().getWindow().getAttributes();
        float realCurBrightness = getRealCurBrightness() + f10;
        if (realCurBrightness > 1.0f) {
            realCurBrightness = 1.0f;
        } else if (realCurBrightness < 0.0f) {
            realCurBrightness = 0.0f;
        }
        attributes.screenBrightness = realCurBrightness;
        getMActivity().getWindow().setAttributes(attributes);
        ((ProgressBar) _$_findCachedViewById(R$id.mPbBrightness)).setProgress((int) (realCurBrightness * ((float) 100)));
    }

    public final void G4() {
        int i10 = R$id.mPlayPauseIcon;
        ((ImageView) _$_findCachedViewById(i10)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(i10)).setImageResource(R.drawable.ic_vod_to_pause);
        D4(true);
    }

    public void H1() {
    }

    public void H2() {
    }

    public final void H4() {
        int i10 = R$id.mPlayPauseIcon;
        ((ImageView) _$_findCachedViewById(i10)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(i10)).setImageResource(R.drawable.ic_vod_to_play);
        D4(true);
    }

    public void I1(Bitmap bitmap) {
        t9.i.g(bitmap, "bitmap");
    }

    public final void I2() {
        post(new m6.f0(this));
    }

    public final void I4() {
        int i10 = R$id.mPlayPauseIcon;
        ((ImageView) _$_findCachedViewById(i10)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(i10)).setImageResource(R.drawable.ic_vod_to_play);
        D4(true);
    }

    public final void J4() {
        if (!B2()) {
            int i10 = R$id.mIvSubtitleAudio;
            if (((ImageView) _$_findCachedViewById(i10)).getVisibility() == 0 && ((BeforeVodAdView) _$_findCachedViewById(R$id.mBvavAd)).getVisibility() != 0) {
                String string = getContext().getString(R.string.guide_vod_subtitle);
                t9.i.f(string, "context.getString(R.string.guide_vod_subtitle)");
                BaseGuideManager baseGuideManager = new BaseGuideManager(getContext(), (ImageView) _$_findCachedViewById(i10), "keyFirstEnterVodDetail", string, GuideDialog.Direction.TOP_RIGHT, getContext().getString(R.string.next_step), false, false, (String) null, 448, (t9.g) null);
                if (baseGuideManager.isShow()) {
                    int i11 = R$id.mLayoutController;
                    ((AlphaRelativeLayout) _$_findCachedViewById(i11)).setVisibility(0);
                    ((AlphaRelativeLayout) _$_findCachedViewById(i11)).cancelDalayHide();
                    P4(false);
                    baseGuideManager.setGuideNextClickListener(new r0(this));
                    ((ImageView) _$_findCachedViewById(i10)).postDelayed(new m6.q(this, baseGuideManager), 50);
                    return;
                }
                xa.c.c().j(new ShowVodSharingGuideEvent());
            }
        }
    }

    public void K0() {
    }

    public void L0() {
    }

    public void L1(int i10) {
        ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
        h2(i10);
    }

    public final void L4(View view, int i10) {
        x6.a.a(view, i10);
    }

    public final void M4() {
        this.f6103c.d();
    }

    public void N1(long j10, long j11) {
        CharSequence charSequence;
        TextView textView;
        long j12 = (long) 1000;
        long j13 = j11 / j12;
        long j14 = j10 / j12;
        int i10 = R$id.mSeekBarCast;
        int i11 = (int) j13;
        if (((SeekBar) _$_findCachedViewById(i10)).getMax() != i11) {
            ((SeekBar) _$_findCachedViewById(i10)).setMax(i11);
        }
        ((SeekBar) _$_findCachedViewById(i10)).setProgress((int) j14);
        String l10 = y6.a.l(j13);
        String l11 = y6.a.l(j14);
        int i12 = R$id.mTextTotalTimeCast;
        TextView textView2 = (TextView) _$_findCachedViewById(i12);
        if (textView2 != null) {
            charSequence = textView2.getText();
        } else {
            charSequence = null;
        }
        if (!t9.i.b(charSequence, '/' + l10) && (textView = (TextView) _$_findCachedViewById(i12)) != null) {
            textView.setText('/' + l10);
        }
        TextView textView3 = (TextView) _$_findCachedViewById(R$id.mTextCurTimeCast);
        if (textView3 != null) {
            textView3.setText(l11);
        }
        this.C = j14 * j12;
    }

    public final void N4(View view, int i10) {
        x6.a.b(view, i10);
    }

    public void O1() {
    }

    public final void O4() {
        boolean z10;
        boolean z11 = true;
        if (this.O.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
            if (hVar.a().length() <= 0) {
                z11 = false;
            }
            if (z11 && !t9.i.b(this.O, hVar.a())) {
                if (t9.i.b(this.O, hVar.k())) {
                    com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f12519a;
                    gVar.w((g.b) null);
                    if (hVar.t()) {
                        gVar.G();
                    }
                } else if (t9.i.b(this.O, hVar.l())) {
                    this.N.s();
                    this.N.o();
                    this.N.r();
                }
            }
        }
    }

    public final void P1() {
        ((AlphaRelativeLayout) _$_findCachedViewById(R$id.mLayoutController)).setVisibilitySwitch(false);
    }

    public final void P2(float f10) {
        if (this.D) {
            this.D = false;
        }
        int i10 = R$id.mVideoViewVod;
        int duration = (int) (((float) ((TitanVODView) _$_findCachedViewById(i10)).getDuration()) * f10);
        if (f10 > 0.0f) {
            ((ImageView) _$_findCachedViewById(R$id.mImgGesture)).setImageResource(R.drawable.bg_video_speed);
        } else {
            ((ImageView) _$_findCachedViewById(R$id.mImgGesture)).setImageResource(R.drawable.bg_video_foward);
        }
        ((FrameLayout) _$_findCachedViewById(R$id.mLayoutGesture)).setVisibility(0);
        int i11 = R$id.mTextGesture;
        ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
        this.f6120m = true;
        int currentProgress = duration + ((int) ((TitanVODView) _$_findCachedViewById(i10)).getCurrentProgress());
        this.f6122n = currentProgress;
        if (currentProgress <= 0) {
            ((TextView) _$_findCachedViewById(i11)).setText("00:00/" + ((TextView) _$_findCachedViewById(R$id.mTextTotalTime)).getText());
        } else if (((long) currentProgress) > ((TitanVODView) _$_findCachedViewById(i10)).getDuration()) {
            StringBuilder sb = new StringBuilder();
            int i12 = R$id.mTextTotalTime;
            sb.append(((TextView) _$_findCachedViewById(i12)).getText());
            sb.append('/');
            sb.append(((TextView) _$_findCachedViewById(i12)).getText());
            ((TextView) _$_findCachedViewById(i11)).setText(sb.toString());
        } else {
            ((TextView) _$_findCachedViewById(i11)).setText(y6.a.k((long) this.f6122n) + '/' + ((TextView) _$_findCachedViewById(R$id.mTextTotalTime)).getText());
        }
        int i13 = R$id.mImgPercent;
        ViewGroup.LayoutParams layoutParams = ((ImageView) _$_findCachedViewById(i13)).getLayoutParams();
        int duration2 = (int) (((float) ((ImageView) _$_findCachedViewById(R$id.mImgfull)).getLayoutParams().width) * (((float) this.f6122n) / ((float) ((TitanVODView) _$_findCachedViewById(i10)).getDuration())));
        layoutParams.width = duration2;
        if (duration2 < 0) {
            layoutParams.width = 0;
        }
        ((ImageView) _$_findCachedViewById(i13)).setLayoutParams(layoutParams);
    }

    public final void P3() {
        String d10 = y6.a.d("MM-dd HH:mm");
        if (d10.compareTo("10-28 00:00:00") > 0 && d10.compareTo("11-04 00:00:00") < 0) {
            ((CurTimeSeekBar) _$_findCachedViewById(R$id.mSeekBar)).setThumb(getContext().getResources().getDrawable(R.drawable.icon_thumb_halloween));
        } else if (d10.compareTo("12-22 00:00:00") > 0 && d10.compareTo("12-29 00:00:00") < 0) {
            ((CurTimeSeekBar) _$_findCachedViewById(R$id.mSeekBar)).setThumb(getContext().getResources().getDrawable(R.drawable.icon_thumb_christmas));
        } else if (d10.compareTo("12-29 00:00:00") > 0 || d10.compareTo("01-05 00:00:00") < 0) {
            ((CurTimeSeekBar) _$_findCachedViewById(R$id.mSeekBar)).setThumb(getContext().getResources().getDrawable(R.drawable.icon_thumb_new_years));
        } else {
            ((CurTimeSeekBar) _$_findCachedViewById(R$id.mSeekBar)).setThumb(getContext().getResources().getDrawable(R.drawable.shape_vod_seekbar_thumb));
        }
    }

    public final void P4(boolean z10) {
        if (z10) {
            this.f6103c.s();
        } else {
            this.f6103c.u();
        }
        this.f6103c.a();
    }

    public final void Q1(Configuration configuration) {
        t9.i.g(configuration, "newConfig");
        if (this.f6103c.l() || configuration.orientation == 2) {
            d3(true);
            setFullScreenAttr(true);
            x2();
            return;
        }
        d3(false);
        setFullScreenAttr(false);
        z4();
        J4();
    }

    public final void Q3() {
        setOnTouchListener(new m6.w(this, new GestureDetector(getMActivity(), new f0(this))));
    }

    public final void Q4() {
        ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).D();
    }

    public final void R2(MotionEvent motionEvent) {
        int i10 = R$id.mLayoutController;
        int i11 = 0;
        if (((AlphaRelativeLayout) _$_findCachedViewById(i10)).getVisibility() == 8) {
            ((AlphaRelativeLayout) _$_findCachedViewById(i10)).setVisibility(0);
            z3();
            B3();
        }
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).setTag(Boolean.TRUE);
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).delayHide();
        Float f10 = this.M0;
        if (f10 == null) {
            this.M0 = Float.valueOf(motionEvent.getRawY());
            return;
        }
        t9.i.d(f10);
        float floatValue = f10.floatValue() - motionEvent.getRawY();
        int percentHeightSize = AutoUtils.getPercentHeightSize(280);
        b8.b bVar = this.f6104d;
        b8.b bVar2 = null;
        if (bVar == null) {
            t9.i.w("mVoiceHelper");
            bVar = null;
        }
        float e10 = ((float) bVar.e()) * (floatValue / ((float) percentHeightSize));
        b8.b bVar3 = this.f6104d;
        if (bVar3 == null) {
            t9.i.w("mVoiceHelper");
            bVar3 = null;
        }
        float d10 = ((float) bVar3.d()) + e10;
        b8.b bVar4 = this.f6104d;
        if (bVar4 == null) {
            t9.i.w("mVoiceHelper");
            bVar4 = null;
        }
        int d11 = bVar4.d() + ((int) e10);
        b8.b bVar5 = this.f6104d;
        if (bVar5 == null) {
            t9.i.w("mVoiceHelper");
            bVar5 = null;
        }
        if (d11 > bVar5.e()) {
            b8.b bVar6 = this.f6104d;
            if (bVar6 == null) {
                t9.i.w("mVoiceHelper");
                bVar6 = null;
            }
            i11 = bVar6.e();
        } else if (d11 >= 0) {
            i11 = d11;
        }
        b8.b bVar7 = this.f6104d;
        if (bVar7 == null) {
            t9.i.w("mVoiceHelper");
            bVar7 = null;
        }
        if (d10 > ((float) bVar7.e())) {
            b8.b bVar8 = this.f6104d;
            if (bVar8 == null) {
                t9.i.w("mVoiceHelper");
                bVar8 = null;
            }
            d10 = (float) bVar8.e();
        } else if (d10 < 0.0f) {
            d10 = 0.0f;
        }
        if (Math.abs(e10) >= 1.0f) {
            this.M0 = Float.valueOf(motionEvent.getRawY());
            b8.b bVar9 = this.f6104d;
            if (bVar9 == null) {
                t9.i.w("mVoiceHelper");
                bVar9 = null;
            }
            bVar9.g(i11);
        }
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R$id.mPbVolume);
        float f11 = ((float) 100) * d10;
        b8.b bVar10 = this.f6104d;
        if (bVar10 == null) {
            t9.i.w("mVoiceHelper");
        } else {
            bVar2 = bVar10;
        }
        progressBar.setProgress((int) (f11 / ((float) bVar2.e())));
    }

    public final void R4(AudioTrackBean audioTrackBean) {
        String str;
        this.f6135t0 = audioTrackBean;
        String contentId = audioTrackBean.getContentId();
        Movie movie = this.f6110h;
        if (movie != null) {
            str = movie.getContentId();
        } else {
            str = null;
        }
        if (t9.i.b(contentId, str)) {
            this.f6137u0 = !((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).y(audioTrackBean.getRealAudio(), audioTrackBean.getPosition());
            return;
        }
        this.f6137u0 = true;
        this.f6109g0 = true;
        ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).setMedia(audioTrackBean.getContentId());
        V4(audioTrackBean.getContentId());
    }

    public final void S2() {
        this.H = false;
        if (this.f6112i != null) {
            int i10 = this.f6124o + 1;
            AssetData assetData = this.f6106f;
            t9.i.d(assetData);
            if (i10 < assetData.getSimpleProgramList().size()) {
                p3(this.f6124o + 1);
                return;
            }
            this.f6103c.u();
            ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).u();
            int i11 = R$id.mPlayPauseIcon;
            if (((ImageView) _$_findCachedViewById(i11)).getVisibility() != 0) {
                ((ImageView) _$_findCachedViewById(i11)).setVisibility(0);
                D4(true);
            }
        }
    }

    public final void S3(ArrayList arrayList, AudioTrackBean audioTrackBean) {
        if (arrayList != null) {
            int i10 = 0;
            int i11 = 0;
            for (Object next : arrayList) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    i9.j.j();
                }
                if (((AudioTrackBean) next).isSelected()) {
                    i10 = i11;
                }
                i11 = i12;
            }
            this.f6123n0 = i10;
            getSubtitleAudioPorWindow().m(arrayList, i10);
            getSubtitleAudioLandWindow().m(arrayList, i10);
            this.f6135t0 = audioTrackBean;
        }
    }

    public final void S4() {
        String str;
        String str2;
        String contentId;
        Media media;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String buss;
        String lang;
        String quality;
        String vcodec;
        String format;
        String buss2;
        String episode;
        String title;
        String name;
        String media2;
        List<Media> medias;
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        String e10 = hVar.e();
        if (e10 != null) {
            O4();
            xa.c.c().j(new CastToCloseOtherPlayEvent("VOD", false));
            if (this.f6127p0) {
                str = T4(e10, "dlna");
            } else {
                str = e10;
            }
            if (t9.i.b(hVar.a(), hVar.k())) {
                Program program = this.E0;
                if (program == null || (medias = program.getMedias()) == null) {
                    media = null;
                } else {
                    media = medias.get(0);
                }
                com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f12519a;
                Program program2 = this.E0;
                if (program2 == null || (media2 = program2.getMedia()) == null) {
                    str3 = "";
                } else {
                    str3 = media2;
                }
                Program program3 = this.E0;
                if (program3 == null || (name = program3.getName()) == null) {
                    str4 = "";
                } else {
                    str4 = name;
                }
                Program program4 = this.E0;
                if (program4 == null || (title = program4.getTitle()) == null) {
                    str5 = "";
                } else {
                    str5 = title;
                }
                Program program5 = this.E0;
                if (program5 == null || (episode = program5.getEpisode()) == null) {
                    str6 = "";
                } else {
                    str6 = episode;
                }
                Program program6 = this.E0;
                if (program6 == null || (buss2 = program6.getBuss()) == null) {
                    str7 = "";
                } else {
                    str7 = buss2;
                }
                if (media == null || (format = media.getFormat()) == null) {
                    str8 = "";
                } else {
                    str8 = format;
                }
                if (media == null || (vcodec = media.getVcodec()) == null) {
                    str9 = "";
                } else {
                    str9 = vcodec;
                }
                if (media == null || (quality = media.getQuality()) == null) {
                    str10 = "";
                } else {
                    str10 = quality;
                }
                if (media == null || (lang = media.getLang()) == null) {
                    str11 = "";
                } else {
                    str11 = lang;
                }
                Program program7 = this.E0;
                if (program7 == null || (buss = program7.getBuss()) == null) {
                    str12 = "";
                } else {
                    str12 = buss;
                }
                long W2 = ((long) W2()) * 1000;
                String str14 = this.f6129q0;
                if (str14 == null) {
                    str13 = "";
                } else {
                    str13 = str14;
                }
                gVar.E(str, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, W2, str13, this.f6127p0);
                V1(this, false, false, 2, (Object) null);
            } else if (t9.i.b(hVar.a(), hVar.l())) {
                Q4();
                this.N.j(T4(e10, "google_cast"), W2(), ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).getDuration(), getMediaMetadata());
                this.N.s();
                z5.c cVar = this.N;
                AssetData assetData = this.f6106f;
                if (assetData == null || (contentId = assetData.getContentId()) == null) {
                    str2 = "";
                } else {
                    str2 = contentId;
                }
                cVar.l(this, str2, PlayAty.G.a(), this.f6126p, com.mobile.brasiltv.utils.y.f12639a.n(), this.f6128q, na.e.f19077c, "");
                V1(this, false, false, 2, (Object) null);
            }
        }
    }

    public final void T2(Movie movie) {
        String str;
        Program h10;
        String media;
        t9.i.g(movie, "movie");
        A3();
        this.f6134t = true;
        int i10 = 0;
        this.f6109g0 = false;
        V1(this, true, false, 2, (Object) null);
        setVodSubtitleAudioVisibility(0);
        e3();
        this.H = false;
        int i11 = R$id.mVideoViewVod;
        TitanVODView titanVODView = (TitanVODView) _$_findCachedViewById(i11);
        AudioTrackBean audioTrackBean = this.f6135t0;
        String str2 = "";
        if (audioTrackBean == null || (str = audioTrackBean.getRealAudio()) == null) {
            str = str2;
        }
        AudioTrackBean audioTrackBean2 = this.f6135t0;
        if (audioTrackBean2 != null) {
            i10 = audioTrackBean2.getPosition();
        }
        this.f6137u0 = true ^ titanVODView.y(str, i10);
        J4();
        n8.b titanContext = ((TitanVODView) _$_findCachedViewById(i11)).getTitanContext();
        if (!(titanContext == null || (h10 = titanContext.h()) == null || (media = h10.getMedia()) == null)) {
            str2 = media;
        }
        this.f6126p = str2;
        this.f6110h = movie;
    }

    public final void T3() {
        Context context = getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        PauseAdView pauseAdView = new PauseAdView(context, this.f6118l);
        this.A = pauseAdView;
        pauseAdView.setLayoutAdCallback(new h0(this));
        PauseAdView pauseAdView2 = this.A;
        if (pauseAdView2 != null) {
            pauseAdView2.setDetachAdCallback(new i0(this));
        }
    }

    public final String T4(String str, String str2) {
        if (ba.t.o(str, Operator.Operation.EMPTY_PARAM, false, 2, (Object) null)) {
            return str + "&cast=" + str2;
        }
        return str + "?cast=" + str2;
    }

    public void U() {
        ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
    }

    public final void U1(boolean z10, boolean z11) {
        String str;
        String videoFormat;
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        boolean b10 = t9.i.b(hVar.a(), hVar.k());
        if (z11) {
            ((AutoLinearLayout) _$_findCachedViewById(R$id.llCastContainer)).setVisibility(8);
            this.f6103c.c();
            ((AlphaRelativeLayout) _$_findCachedViewById(R$id.mLayoutController)).setVisibility(8);
            ((TextView) _$_findCachedViewById(R$id.mTvCastErrorHint)).setVisibility(8);
            this.O = hVar.a();
            if (!b10) {
                Movie movie = this.f6110h;
                String str2 = "";
                if (movie == null || (str = movie.getEncodeFormat()) == null) {
                    str = str2;
                }
                Movie movie2 = this.f6110h;
                if (!(movie2 == null || (videoFormat = movie2.getVideoFormat()) == null)) {
                    str2 = videoFormat;
                }
                if (!C2(str, str2)) {
                    ((AutoLinearLayout) _$_findCachedViewById(R$id.llSwitchContainer)).setVisibility(0);
                    return;
                }
            }
            S4();
        } else if (z10) {
            ((AutoLinearLayout) _$_findCachedViewById(R$id.llSwitchContainer)).setVisibility(8);
            ((AutoLinearLayout) _$_findCachedViewById(R$id.llCastContainer)).setVisibility(8);
            ((AlphaRelativeLayout) _$_findCachedViewById(R$id.mLayoutController)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R$id.mTvCastErrorHint)).setVisibility(8);
            z3();
            B3();
            this.f6103c.f();
            ((SeekBar) _$_findCachedViewById(R$id.mSeekBarCast)).setProgress(0);
            if (b10) {
                com.mobile.brasiltv.utils.g.f12519a.w((g.b) null);
            } else {
                this.N.o();
            }
        } else {
            ((AutoLinearLayout) _$_findCachedViewById(R$id.mLayoutStage)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R$id.mIvStage)).setVisibility(8);
            ((AutoLinearLayout) _$_findCachedViewById(R$id.llSwitchContainer)).setVisibility(8);
            ((AutoLinearLayout) _$_findCachedViewById(R$id.llCastContainer)).setVisibility(0);
            ((AlphaRelativeLayout) _$_findCachedViewById(R$id.mLayoutController)).setVisibility(8);
            ((TextView) _$_findCachedViewById(R$id.mTvCastErrorHint)).setVisibility(8);
            this.f6103c.c();
            int i10 = R$id.mTvCastState;
            ((TextView) _$_findCachedViewById(i10)).setText(getContext().getResources().getString(R.string.cast_status_prepare));
            ((TextView) _$_findCachedViewById(i10)).setTextColor(getContext().getResources().getColor(R.color.color_fffefe));
            int i11 = R$id.mTvPleaseWait;
            ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(4);
            q3();
            int i12 = R$id.mImagePlayCast;
            ((ImageView) _$_findCachedViewById(i12)).setImageResource(R.drawable.icon_pause_white);
            if (getContext() instanceof PlayAty) {
                Context context = getContext();
                t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                if (t9.i.b(((PlayAty) context).j3().c(), o6.c.c().c())) {
                    ((ImageView) _$_findCachedViewById(R$id.mIvCastQuality)).setImageResource(R.mipmap.icon_cast_definition_480);
                } else {
                    Context context2 = getContext();
                    t9.i.e(context2, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                    if (t9.i.b(((PlayAty) context2).j3().c(), o6.c.b().c())) {
                        ((ImageView) _$_findCachedViewById(R$id.mIvCastQuality)).setImageResource(R.mipmap.icon_cast_definition_720);
                    } else {
                        Context context3 = getContext();
                        t9.i.e(context3, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                        if (t9.i.b(((PlayAty) context3).j3().c(), o6.c.a().c())) {
                            ((ImageView) _$_findCachedViewById(R$id.mIvCastQuality)).setImageResource(R.mipmap.icon_cast_definition_1080);
                        }
                    }
                }
            }
            int i13 = R$id.mSeekBarCast;
            ((SeekBar) _$_findCachedViewById(i13)).setProgress(0);
            com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f12519a;
            if (gVar.j()) {
                ((TextView) _$_findCachedViewById(i11)).setVisibility(8);
                ((ImageView) _$_findCachedViewById(i12)).setImageResource(R.drawable.icon_play_white);
                ((SeekBar) _$_findCachedViewById(i13)).setProgress(((SeekBar) _$_findCachedViewById(i13)).getMax());
                TextView textView = (TextView) _$_findCachedViewById(R$id.mTextCurTimeCast);
                if (textView != null) {
                    textView.setText(y6.a.l(0));
                }
                this.C = 0;
                Links links = this.f6146z;
                if (links != null) {
                    links.setRecordTime(0);
                }
            }
            if (b10) {
                gVar.w(this);
            } else {
                this.N.e(this);
            }
        }
    }

    public final boolean U2() {
        if (((AutoLinearLayout) _$_findCachedViewById(R$id.mLlQuality)).getVisibility() == 0 || ((ImageView) _$_findCachedViewById(R$id.mImageQuality)).getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void U3() {
        int i10 = R$id.mVideoViewVod;
        String k10 = y6.a.k(((TitanVODView) _$_findCachedViewById(i10)).getDuration());
        y6.a.k(((TitanVODView) _$_findCachedViewById(i10)).getCurrentProgress());
        ((TextView) _$_findCachedViewById(R$id.mTextTotalTime)).setText(k10);
        ((TextView) _$_findCachedViewById(R$id.mFullTotalTime)).setText(k10);
    }

    public final void U4() {
        String str;
        List<Movie> movieList;
        d8.c playStatus = ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).getPlayStatus();
        if (playStatus != null) {
            str = playStatus.d();
        } else {
            str = null;
        }
        HashMap hashMap = this.f6108g;
        Context context = getContext();
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
        TotalMovieList totalMovieList = (TotalMovieList) hashMap.get(((PlayAty) context).j3().c());
        if (str != null && totalMovieList != null && (movieList = totalMovieList.getMovieList()) != null) {
            for (Movie movie : movieList) {
                if (com.mobile.brasiltv.utils.b0.I(movie.getLicenseList()) && t9.i.b(str, movie.getContentId())) {
                    this.f6110h = movie;
                }
            }
        }
    }

    public final long V2() {
        long j10;
        Links links;
        AssetData assetData = this.f6106f;
        if (assetData != null) {
            VodDao vodDao = this.f6105e;
            if (vodDao != null) {
                t9.i.d(assetData);
                links = vodDao.queryRecordByContentId(assetData.getContentId(), this.f6124o);
            } else {
                links = null;
            }
            this.f6146z = links;
            if (links != null && links.getRecordTime() > links.getDuration() - ((long) 10000)) {
                links.setRecordTime(0);
            }
        }
        Links links2 = this.f6146z;
        if (links2 != null) {
            j10 = links2.getRecordTime();
        } else {
            j10 = 0;
        }
        if (j10 <= 0) {
            return 0;
        }
        Links links3 = this.f6146z;
        t9.i.d(links3);
        return links3.getRecordTime();
    }

    public final void V3(int i10, VodDao vodDao, SimpleProgramList simpleProgramList, String str) {
        t9.i.g(vodDao, "mVodDao");
        t9.i.g(simpleProgramList, "curPlayProgram");
        t9.i.g(str, "type");
        this.f6124o = i10;
        this.f6105e = vodDao;
        this.f6112i = simpleProgramList;
        this.B = str;
        int i11 = R$id.mIvStage;
        ((ImageView) _$_findCachedViewById(i11)).setImageResource(R.drawable.bg_vod_default_stage);
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLayoutStage)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(i11)).setVisibility(0);
    }

    public final void V4(String str) {
        List<Movie> movieList;
        HashMap hashMap = this.f6108g;
        Context context = getContext();
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
        TotalMovieList totalMovieList = (TotalMovieList) hashMap.get(((PlayAty) context).j3().c());
        if (totalMovieList != null && (movieList = totalMovieList.getMovieList()) != null) {
            for (Movie movie : movieList) {
                if (com.mobile.brasiltv.utils.b0.I(movie.getLicenseList()) && t9.i.b(str, movie.getContentId())) {
                    this.f6110h = movie;
                }
            }
        }
    }

    public final boolean W1() {
        return false;
    }

    public final int W2() {
        long j10 = this.C;
        if (j10 != 0) {
            int i10 = ((int) j10) / 1000;
            this.C = 0;
            return i10;
        }
        Links links = this.f6146z;
        if (links != null) {
            t9.i.d(links);
            if (links.getRecordTime() > 0) {
                Links links2 = this.f6146z;
                t9.i.d(links2);
                return ((int) links2.getRecordTime()) / 1000;
            }
        }
        return 0;
    }

    public final void W4(String str) {
        t9.i.g(str, "contentId");
        SimpleProgramList simpleProgramList = this.f6112i;
        if (simpleProgramList != null) {
            simpleProgramList.setContentId(str);
        }
    }

    public final boolean X1() {
        if (!this.f6144y) {
            a.C0148a aVar = b8.a.f11196a;
            Context context = getContext();
            t9.i.f(context, com.umeng.analytics.pro.f.X);
            if (!aVar.c(context)) {
                int i10 = R$id.mLayoutMobileNotify;
                ((AutoLinearLayout) _$_findCachedViewById(i10)).setVisibility(0);
                ((AutoLinearLayout) _$_findCachedViewById(i10)).setOnClickListener(new m6.y(this));
                return false;
            }
        }
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLayoutMobileNotify)).setVisibility(8);
        return true;
    }

    public final void X2() {
        ((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
        D4(false);
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLayoutStage)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R$id.mIvStage)).setVisibility(8);
        ((RelativeLayout) _$_findCachedViewById(R$id.mBufferView)).setVisibility(8);
        this.G = false;
        ((ImageView) _$_findCachedViewById(R$id.mImagePlay)).setImageResource(R.drawable.ic_vod_pause);
        int i10 = R$id.mLayoutController;
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).setVisibility(4);
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).enableProxyVisibility(true);
        this.S = true;
    }

    public final void X4(HashMap hashMap) {
        t9.i.g(hashMap, "totalMovieListMap");
        this.f6108g.clear();
        this.f6108g.putAll(hashMap);
    }

    public final void Y2() {
        if (!xa.c.c().h(this)) {
            xa.c.c().o(this);
        }
    }

    public final void Y4() {
        if (this.f6103c.m()) {
            int i10 = R$id.mFlLocked;
            if (((AutoFrameLayout) _$_findCachedViewById(i10)).getVisibility() == 0) {
                Disposable disposable = this.B0;
                if (disposable != null) {
                    disposable.dispose();
                }
                ((AutoFrameLayout) _$_findCachedViewById(i10)).setVisibility(8);
                return;
            }
            D2();
            ((AutoFrameLayout) _$_findCachedViewById(i10)).setVisibility(0);
            return;
        }
        int i11 = R$id.mLayoutSetInfo;
        if (((AutoFrameLayout) _$_findCachedViewById(i11)).getVisibility() == 0) {
            Disposable disposable2 = this.C0;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            AutoFrameLayout autoFrameLayout = (AutoFrameLayout) _$_findCachedViewById(i11);
            t9.i.f(autoFrameLayout, "mLayoutSetInfo");
            N4(autoFrameLayout, AutoUtils.getPercentWidthSize(580));
            return;
        }
        int i12 = R$id.mMemberTipsLayout;
        if (((AutoRelativeLayout) _$_findCachedViewById(i12)).getVisibility() != 0) {
            if (((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).getVisibility() == 0 || ((AutoRelativeLayout) _$_findCachedViewById(i12)).getVisibility() == 0) {
                ((ImageView) _$_findCachedViewById(R$id.mImageBack)).setVisibility(0);
            }
            int i13 = R$id.mLayoutController;
            if (t9.i.b(((AlphaRelativeLayout) _$_findCachedViewById(i13)).getTag(), Boolean.TRUE)) {
                ((AlphaRelativeLayout) _$_findCachedViewById(i13)).setTag(Boolean.FALSE);
                ((AlphaRelativeLayout) _$_findCachedViewById(i13)).delayHide();
            } else if (((AlphaRelativeLayout) _$_findCachedViewById(i13)).getVisibility() == 0) {
                ((AlphaRelativeLayout) _$_findCachedViewById(i13)).setVisibility(8);
            } else {
                ((AlphaRelativeLayout) _$_findCachedViewById(i13)).setVisibility(0);
                z3();
                B3();
            }
        }
    }

    public void Z() {
    }

    public final void Z1() {
        ((BeforeVodAdView) _$_findCachedViewById(R$id.mBvavAd)).hideBeforeVodAd();
    }

    public final void Z2() {
        String str;
        w6.i b10 = w6.i.f9510g.b();
        AssetData assetData = this.f6106f;
        if (assetData == null || (str = assetData.getName()) == null) {
            str = "";
        }
        String obj = ((TextView) _$_findCachedViewById(R$id.mTvCastDevice)).getText().toString();
        String a10 = com.mobile.brasiltv.utils.h.f12562a.a();
        Context context = getContext();
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
        b10.s2(str, obj, a10, ((PlayAty) context).j3().c()).subscribe(new n());
    }

    public final void Z3() {
        C3();
        ((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).setOnClickListener(new m6.g0(this));
        ((TextView) _$_findCachedViewById(R$id.mMemberWatchFree)).setOnClickListener(new m6.s0(this));
        ((TextView) _$_findCachedViewById(R$id.mMemberTips2)).setOnClickListener(new x0(this));
        ((CurTimeSeekBar) _$_findCachedViewById(R$id.mSeekBar)).setOnSeekBarChangeListener(new p0(this));
        ((ImageView) _$_findCachedViewById(R$id.mImagePlay)).setOnClickListener(new y0(this));
        ((ImageView) _$_findCachedViewById(R$id.mImageFullScreen)).setOnClickListener(new z0(this));
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlEpisodes)).setOnClickListener(new a1(this));
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlAudioLanguage)).setOnClickListener(new b1(this));
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlLock)).setOnClickListener(new c1(this));
        ((AutoFrameLayout) _$_findCachedViewById(R$id.mFlLocked)).setOnClickListener(new d1(this));
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlQuality)).setOnClickListener(new f1(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvFastRewind)).setOnClickListener(new m6.h0(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvFastForward)).setOnClickListener(new m6.j0(this));
        ((AlphaRelativeLayout) _$_findCachedViewById(R$id.mLayoutController)).setVisibilityListener(new m0(this));
        setOnClickListener(new m6.k0(this));
        getSetInfoAdapter().setOnItemClickListener(new m6.l0(this));
        ((ImageView) _$_findCachedViewById(R$id.mImageFeedback)).setOnClickListener(new m6.m0(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvShare)).setOnClickListener(new m6.n0(this));
        ((ImageView) _$_findCachedViewById(R$id.mDebugSwitch)).setOnClickListener(new m6.o0(this));
        ((ImageView) _$_findCachedViewById(R$id.mImageQuality)).setOnClickListener(new m6.p0(this));
        ImageView imageView = (ImageView) _$_findCachedViewById(R$id.mImageCast);
        t9.i.f(imageView, "mImageCast");
        com.mobile.brasiltv.utils.b0.P(imageView, new m6.q0(this));
        ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setOnClickListener(new m6.r0(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvSubtitleAudio)).setOnClickListener(new m6.u0(this));
        getSubtitleAudioLandWindow().o(new n0(this));
        getSubtitleAudioPorWindow().o(new o0(this));
        ((RecyclerView) _$_findCachedViewById(R$id.recyclerSetInfo)).setOnTouchListener(new m6.v0(this));
        ((AutoFrameLayout) _$_findCachedViewById(R$id.mLayoutSetInfo)).setOnClickListener(new w0(this));
    }

    public final boolean Z4(View view, MotionEvent motionEvent, GestureDetector gestureDetector) {
        if (this.f6103c.m() || !this.W) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            ((FrameLayout) _$_findCachedViewById(R$id.mLayoutGesture)).setVisibility(8);
            if (this.f6120m) {
                this.H = true;
                int i10 = this.f6122n;
                if (i10 < 0) {
                    ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).x(0);
                } else {
                    int i11 = R$id.mVideoViewVod;
                    if (((long) i10) > ((TitanVODView) _$_findCachedViewById(i11)).getDuration()) {
                        ((TitanVODView) _$_findCachedViewById(i11)).x(((TitanVODView) _$_findCachedViewById(i11)).getDuration() - ((long) 3000));
                    } else {
                        ((TitanVODView) _$_findCachedViewById(i11)).x((long) this.f6122n);
                    }
                }
                this.f6120m = false;
                if (this.V) {
                    ((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
                    D4(false);
                }
                return true;
            }
        }
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public View _$_findCachedViewById(int i10) {
        Map map = this.N0;
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
        post(new m6.n(this));
    }

    public final void a2() {
        ((AlphaRelativeLayout) _$_findCachedViewById(R$id.mLayoutController)).setVisibilitySwitch(true);
    }

    public final void a3() {
        EnterType enterType;
        int i10;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        if (this.f6113i0 != 0 && (enterType = this.f6114j) != null) {
            if (enterType == null) {
                i10 = -1;
            } else {
                i10 = c.f12418b[enterType.ordinal()];
            }
            String str14 = null;
            if (i10 == 1) {
                Context context = getContext();
                String str15 = this.f6116k;
                SimpleProgramList simpleProgramList = this.f6112i;
                if (simpleProgramList != null) {
                    str2 = simpleProgramList.getContentId();
                } else {
                    str2 = null;
                }
                AssetData assetData = this.f6106f;
                if (assetData != null) {
                    str3 = assetData.getName();
                } else {
                    str3 = null;
                }
                i1.y(context, str15, str2, str3, this.f6113i0);
            } else if (i10 == 2) {
                Context context2 = getContext();
                AssetData assetData2 = this.f6106f;
                if (assetData2 != null) {
                    str4 = assetData2.getProgramType();
                } else {
                    str4 = null;
                }
                SimpleProgramList simpleProgramList2 = this.f6112i;
                if (simpleProgramList2 != null) {
                    str5 = simpleProgramList2.getContentId();
                } else {
                    str5 = null;
                }
                AssetData assetData3 = this.f6106f;
                if (assetData3 != null) {
                    str6 = assetData3.getName();
                } else {
                    str6 = null;
                }
                i1.k(context2, str4, str5, str6, this.f6113i0);
            } else if (i10 == 3) {
                Context context3 = getContext();
                SimpleProgramList simpleProgramList3 = this.f6112i;
                if (simpleProgramList3 != null) {
                    str7 = simpleProgramList3.getContentId();
                } else {
                    str7 = null;
                }
                AssetData assetData4 = this.f6106f;
                if (assetData4 != null) {
                    str8 = assetData4.getName();
                } else {
                    str8 = null;
                }
                AssetData assetData5 = this.f6106f;
                if (assetData5 != null) {
                    str9 = assetData5.getProgramType();
                } else {
                    str9 = null;
                }
                i1.E(context3, str7, str8, str9, this.f6113i0);
            } else if (i10 == 4) {
                Context context4 = getContext();
                SimpleProgramList simpleProgramList4 = this.f6112i;
                if (simpleProgramList4 != null) {
                    str10 = simpleProgramList4.getContentId();
                } else {
                    str10 = null;
                }
                AssetData assetData6 = this.f6106f;
                if (assetData6 != null) {
                    str11 = assetData6.getName();
                } else {
                    str11 = null;
                }
                i1.E(context4, str10, str11, "banner", this.f6113i0);
            } else if (i10 == 5) {
                Context context5 = getContext();
                String str16 = this.f6116k;
                SimpleProgramList simpleProgramList5 = this.f6112i;
                if (simpleProgramList5 != null) {
                    str12 = simpleProgramList5.getContentId();
                } else {
                    str12 = null;
                }
                AssetData assetData7 = this.f6106f;
                if (assetData7 != null) {
                    str13 = assetData7.getName();
                } else {
                    str13 = null;
                }
                i1.L(context5, str16, str12, str13, this.f6113i0);
            }
            Context context6 = getContext();
            SimpleProgramList simpleProgramList6 = this.f6112i;
            if (simpleProgramList6 != null) {
                str = simpleProgramList6.getContentId();
            } else {
                str = null;
            }
            AssetData assetData8 = this.f6106f;
            if (assetData8 != null) {
                str14 = assetData8.getName();
            }
            i1.O(context6, str, str14, this.f6113i0);
        }
    }

    public void b(int i10, String str, String str2) {
        t9.i.g(str, "extra");
        post(new m6.o(i10, str, this, str2));
    }

    public void b0() {
    }

    public void b1() {
    }

    public final void b2() {
        Disposable disposable = this.C0;
        if (disposable != null) {
            disposable.dispose();
        }
        this.C0 = Observable.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new k1(new e(this)), new l1(f.f12429a));
    }

    public final void b3() {
        this.S = false;
        this.W = false;
    }

    public void c(int i10) {
        if (i10 == 2) {
            a.C0148a aVar = b8.a.f11196a;
            Context context = getContext();
            t9.i.f(context, com.umeng.analytics.pro.f.X);
            if (aVar.c(context)) {
                int i11 = R$id.mLayoutMobileNotify;
                if (((AutoLinearLayout) _$_findCachedViewById(i11)).getVisibility() == 0) {
                    ((AutoLinearLayout) _$_findCachedViewById(i11)).setVisibility(8);
                }
            }
            this.H = false;
            w2();
            ((ImageView) _$_findCachedViewById(R$id.mImagePlay)).setImageResource(R.drawable.ic_vod_pause);
            ((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).setImageResource(R.drawable.ic_vod_to_pause);
            this.D = false;
        } else if (i10 == 3) {
            ((ImageView) _$_findCachedViewById(R$id.mImagePlay)).setImageResource(R.drawable.ic_vod_play);
            ((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).setImageResource(R.drawable.ic_vod_to_play);
        }
    }

    public void c2() {
        xa.c.c().j(new CastPlaySuccessEvent("VOD"));
        int i10 = R$id.mTvCastState;
        ((TextView) _$_findCachedViewById(i10)).setText(getContext().getResources().getString(R.string.cast_status_casting));
        ((TextView) _$_findCachedViewById(i10)).setTextColor(getContext().getResources().getColor(R.color.color_fffefe));
        ((TextView) _$_findCachedViewById(R$id.mTvPleaseWait)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(4);
        q3();
        ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_pause_white);
    }

    public final void c3() {
        this.S = false;
        this.V = false;
        this.W = false;
        this.L0 = 0;
        setSeekBarClickable(false);
    }

    @xa.j
    public final void castToPlay(CastToPlayEvent castToPlayEvent) {
        Media media;
        boolean z10;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String buss;
        String lang;
        String quality;
        String vcodec;
        String format;
        String buss2;
        String episode;
        String title;
        String name;
        String media2;
        List<Media> medias;
        String str13;
        f5.c mActivity;
        t9.i.g(castToPlayEvent, "event");
        if (t9.i.b(castToPlayEvent.getFromType(), "VOD") && (mActivity = getMActivity()) != null) {
            mActivity.runOnUiThread(new m6.t(this));
        }
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        if (hVar.u() && !this.F0 && com.mobile.brasiltv.utils.b0.K(this.G0) && (str13 = this.G0) != null) {
            Integer num = this.H0;
            t9.i.d(num);
            A4(num.intValue(), str13);
        }
        Program program = this.E0;
        if (program == null || (medias = program.getMedias()) == null) {
            media = null;
        } else {
            media = medias.get(0);
        }
        if (t9.i.b(castToPlayEvent.getFromType(), "VOD")) {
            if (hVar.e().length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 && hVar.u()) {
                this.J0 = false;
                O4();
                Q4();
                com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f12519a;
                gVar.x(castToPlayEvent.getFromType());
                if (this.f6127p0) {
                    str = T4(hVar.e(), "dlna");
                } else {
                    str = hVar.e();
                }
                String str14 = str;
                Program program2 = this.E0;
                if (program2 == null || (media2 = program2.getMedia()) == null) {
                    str2 = "";
                } else {
                    str2 = media2;
                }
                Program program3 = this.E0;
                if (program3 == null || (name = program3.getName()) == null) {
                    str3 = "";
                } else {
                    str3 = name;
                }
                Program program4 = this.E0;
                if (program4 == null || (title = program4.getTitle()) == null) {
                    str4 = "";
                } else {
                    str4 = title;
                }
                Program program5 = this.E0;
                if (program5 == null || (episode = program5.getEpisode()) == null) {
                    str5 = "";
                } else {
                    str5 = episode;
                }
                Program program6 = this.E0;
                if (program6 == null || (buss2 = program6.getBuss()) == null) {
                    str6 = "";
                } else {
                    str6 = buss2;
                }
                if (media == null || (format = media.getFormat()) == null) {
                    str7 = "";
                } else {
                    str7 = format;
                }
                if (media == null || (vcodec = media.getVcodec()) == null) {
                    str8 = "";
                } else {
                    str8 = vcodec;
                }
                if (media == null || (quality = media.getQuality()) == null) {
                    str9 = "";
                } else {
                    str9 = quality;
                }
                if (media == null || (lang = media.getLang()) == null) {
                    str10 = "";
                } else {
                    str10 = lang;
                }
                Program program7 = this.E0;
                if (program7 == null || (buss = program7.getBuss()) == null) {
                    str11 = "";
                } else {
                    str11 = buss;
                }
                long W2 = 1000 * ((long) W2());
                String str15 = this.f6129q0;
                if (str15 == null) {
                    str12 = "";
                } else {
                    str12 = str15;
                }
                gVar.E(str14, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, W2, str12, this.f6127p0);
                this.O = hVar.k();
                return;
            }
        }
        if (!hVar.u()) {
            this.J0 = true;
        }
    }

    public void d() {
        post(new m6.s(this));
    }

    public void d1(long j10) {
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        if (hVar.o() && hVar.t()) {
            com.mobile.brasiltv.utils.g.f12519a.G();
        }
        hVar.E("");
        hVar.v(false);
        hVar.K(true);
        com.mobile.brasiltv.utils.g.f12519a.y(false);
        ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).C();
        Context context = getContext();
        if (context != null) {
            com.mobile.brasiltv.utils.x.f12622a.w(context, new d(this, context, j10));
        }
        this.H0 = Integer.valueOf((int) j10);
        f5.c mActivity = getMActivity();
        if (mActivity != null) {
            mActivity.runOnUiThread(new m6.v(this));
        }
    }

    public final void d3(boolean z10) {
        if (z10) {
            E4();
            ((ImageView) _$_findCachedViewById(R$id.mIvShare)).setVisibility(0);
            ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlFunction)).setVisibility(0);
            _$_findCachedViewById(R$id.mLlBrightnessController).setVisibility(0);
            _$_findCachedViewById(R$id.mLlVolumeController).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R$id.mImagePlay)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R$id.mImageFullScreen)).setVisibility(8);
            ((TextView) _$_findCachedViewById(R$id.mTextTotalTime)).setVisibility(8);
            ((TextView) _$_findCachedViewById(R$id.mFullTotalTime)).setVisibility(0);
            setVodSubtitleAudioVisibility(0);
            ((ImageView) _$_findCachedViewById(R$id.mImageBack)).setVisibility(0);
            getSubtitleAudioPorWindow().dismiss();
            ((TextView) _$_findCachedViewById(R$id.mTextTitle)).setVisibility(0);
            if (this.f6106f != null) {
                if (t9.i.b(this.B, "1")) {
                    ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlEpisodes)).setVisibility(8);
                } else {
                    ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlEpisodes)).setVisibility(0);
                }
            }
            if (U2()) {
                ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlQuality)).setVisibility(0);
                ((ImageView) _$_findCachedViewById(R$id.mImageQuality)).setVisibility(8);
            }
        } else {
            ((ImageView) _$_findCachedViewById(R$id.mImageGesture)).setVisibility(8);
            ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlFunction)).setVisibility(8);
            _$_findCachedViewById(R$id.mLlBrightnessController).setVisibility(8);
            _$_findCachedViewById(R$id.mLlVolumeController).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R$id.mImagePlay)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R$id.mImageFullScreen)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R$id.mTextTotalTime)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R$id.mFullTotalTime)).setVisibility(8);
            setVodSubtitleAudioVisibility(0);
            ((ImageView) _$_findCachedViewById(R$id.mImageBack)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R$id.mIvShare)).setVisibility(8);
            ((TextView) _$_findCachedViewById(R$id.mTextTitle)).setVisibility(8);
            ((AutoFrameLayout) _$_findCachedViewById(R$id.mLayoutSetInfo)).setVisibility(8);
            Disposable disposable = this.C0;
            if (disposable != null) {
                disposable.dispose();
            }
            D4(false);
            if (U2()) {
                ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlQuality)).setVisibility(8);
                ((ImageView) _$_findCachedViewById(R$id.mImageQuality)).setVisibility(0);
            }
            getSubtitleAudioLandWindow().dismiss();
            getSubtitleAudioPorWindow().dismiss();
            ((AutoFrameLayout) _$_findCachedViewById(R$id.mFlLocked)).setVisibility(8);
            Disposable disposable2 = this.B0;
            if (disposable2 != null) {
                disposable2.dispose();
            }
        }
        CommonDialog commonDialog = this.A0;
        if (commonDialog != null) {
            commonDialog.dismiss();
        }
        U3();
    }

    public void e0() {
    }

    public final void e3() {
        this.J = 0;
        this.K = false;
        int i10 = R$id.mSeekBar;
        ((CurTimeSeekBar) _$_findCachedViewById(i10)).setProgress(0);
        ((CurTimeSeekBar) _$_findCachedViewById(i10)).setSecondaryProgress(0);
        ((TextView) _$_findCachedViewById(R$id.mTextTotalTime)).setText("00:00");
        ((TextView) _$_findCachedViewById(R$id.mFullTotalTime)).setText("00:00");
        ((ImageView) _$_findCachedViewById(R$id.mImagePlay)).setImageResource(R.drawable.ic_vod_pause);
        a3();
        this.f6113i0 = 0;
        this.E = false;
        this.f6111h0 = false;
    }

    public final void f2(int i10) {
        this.H = true;
        int i11 = R$id.mSeekBar;
        int progress = ((CurTimeSeekBar) _$_findCachedViewById(i11)).getProgress() + i10;
        if (progress > ((CurTimeSeekBar) _$_findCachedViewById(i11)).getMax()) {
            progress = ((CurTimeSeekBar) _$_findCachedViewById(i11)).getMax();
        } else if (progress < 0) {
            progress = 0;
        }
        ((CurTimeSeekBar) _$_findCachedViewById(i11)).setProgress(progress);
        ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).x((long) ((CurTimeSeekBar) _$_findCachedViewById(i11)).getProgress());
        if (((CurTimeSeekBar) _$_findCachedViewById(i11)).getProgress() != ((CurTimeSeekBar) _$_findCachedViewById(i11)).getMax()) {
            this.D = false;
        }
    }

    public final void f3(AudioSettingBean audioSettingBean) {
        Observable.create(new q1(this, audioSettingBean)).compose(ma.q.b()).subscribe(new r1(new o(this)), new s1(new p(this)));
    }

    public d8.d g1(List list) {
        t9.i.g(list, "audioTrackList");
        if (!this.f6137u0 || this.f6135t0 == null) {
            return null;
        }
        this.f6137u0 = false;
        AudioTrackBean audioTrackBean = this.f6135t0;
        t9.i.d(audioTrackBean);
        String realAudio = audioTrackBean.getRealAudio();
        AudioTrackBean audioTrackBean2 = this.f6135t0;
        t9.i.d(audioTrackBean2);
        return ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).q(realAudio, audioTrackBean2.getPosition());
    }

    public final String g2(int i10) {
        Integer num;
        SubTitleData subTitleData;
        String language;
        List list = this.f6132s;
        if (list != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        t9.i.d(num);
        if (i10 < num.intValue()) {
            List list2 = this.f6132s;
            if (list2 == null || (subTitleData = (SubTitleData) list2.get(i10 - 1)) == null || (language = subTitleData.getLanguage()) == null) {
                return "es";
            }
            return language;
        } else if (i10 == 0) {
            return "pt";
        } else {
            if (i10 != 1) {
                return "es";
            }
            return XML.DEFAULT_CONTENT_LANGUAGE;
        }
    }

    public final String getCastStatusHost() {
        return this.f6129q0;
    }

    public final SimpleProgramList getCurPlayProgram() {
        return this.f6112i;
    }

    public final AssetData getData() {
        return this.f6106f;
    }

    public final boolean getEnableNoWifiPlay() {
        return this.f6144y;
    }

    public final EnterType getEnterType() {
        return this.f6114j;
    }

    public final f5.c getMActivity() {
        return (f5.c) this.f6102b.getValue();
    }

    public final String getMDetailDataContentId() {
        return this.f6125o0;
    }

    public final Movie getMMovie() {
        return this.f6110h;
    }

    public final q5.j getMOrientationHelper() {
        return this.f6103c;
    }

    public final TitanPlayerController getMView() {
        return this.f6101a;
    }

    public final VodDao getMVodDao() {
        return this.f6105e;
    }

    public final Links getProgramBookMark() {
        return this.f6146z;
    }

    public final String getTopicName() {
        return this.f6116k;
    }

    @xa.j
    public final void googleCastToPlay(GoogleCastToPlayEvent googleCastToPlayEvent) {
        t9.i.g(googleCastToPlayEvent, "event");
    }

    public final void h2(int i10) {
        if (i10 == 1) {
            ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
            this.C = 0;
            Links links = this.f6146z;
            if (links != null) {
                links.setRecordTime(0);
            }
        } else if (i10 == 3) {
            int i11 = R$id.mTvCastState;
            ((TextView) _$_findCachedViewById(i11)).setText(getContext().getResources().getString(R.string.cast_status_casting));
            ((TextView) _$_findCachedViewById(i11)).setTextColor(getContext().getResources().getColor(R.color.color_fffefe));
            ((TextView) _$_findCachedViewById(R$id.mTvPleaseWait)).setVisibility(8);
            ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(4);
            q3();
            ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_pause_white);
        } else if (i10 == 4) {
            int i12 = R$id.mTvCastState;
            ((TextView) _$_findCachedViewById(i12)).setText(getContext().getResources().getString(R.string.cast_status_casting_failed));
            ((TextView) _$_findCachedViewById(i12)).append("(4)");
            ((TextView) _$_findCachedViewById(i12)).setTextColor(getContext().getResources().getColor(R.color.color_f72f2f));
            ((TextView) _$_findCachedViewById(R$id.mTvPleaseWait)).setVisibility(8);
            ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
            Z2();
        }
    }

    @xa.j
    public final void handleNetChange(NetworkEvent networkEvent) {
        t9.i.g(networkEvent, "event");
        NetworkEvent.NetState netState = NetworkEvent.NetState.NO_NET;
        if (netState == networkEvent.getMState() && ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).s()) {
            com.mobile.brasiltv.utils.f1.f12517a.t(R.string.net_remind_net_break);
        } else if (NetworkEvent.NetState.WIFI == networkEvent.getMState() && this.f6142x) {
            post(new m6.i(this));
        } else if (NetworkEvent.NetState.MOBILE == networkEvent.getMState() && this.f6142x && this.f6144y) {
            post(new m6.j(this));
        }
        if (com.mobile.brasiltv.utils.h.f12562a.o() && netState == networkEvent.getMState()) {
            com.mobile.brasiltv.utils.f1.f12517a.t(R.string.net_remind_net_break);
        }
    }

    @xa.j
    public final void handlePlaySetIndexEvent(PlaySetIndexEvent playSetIndexEvent) {
        String str;
        String str2;
        String str3;
        t9.i.g(playSetIndexEvent, "event");
        String str4 = null;
        if (playSetIndexEvent.isVideoStop()) {
            setStage(this.f6124o);
            int i10 = R$id.mTextTitle;
            TextView textView = (TextView) _$_findCachedViewById(i10);
            if (textView != null) {
                AssetData assetData = this.f6106f;
                if (assetData != null) {
                    str2 = assetData.getAlias();
                } else {
                    str2 = null;
                }
                AssetData assetData2 = this.f6106f;
                if (assetData2 != null) {
                    str3 = assetData2.getName();
                } else {
                    str3 = null;
                }
                textView.setText(com.mobile.brasiltv.utils.b0.c(str2, str3));
            }
            BeforeVodAdView beforeVodAdView = (BeforeVodAdView) _$_findCachedViewById(R$id.mBvavAd);
            if (beforeVodAdView != null) {
                AssetData assetData3 = this.f6106f;
                if (assetData3 != null) {
                    str = assetData3.getAlias();
                } else {
                    str = null;
                }
                AssetData assetData4 = this.f6106f;
                if (assetData4 != null) {
                    str4 = assetData4.getName();
                }
                beforeVodAdView.setTitle(com.mobile.brasiltv.utils.b0.c(str, str4));
            }
            AssetData assetData5 = this.f6106f;
            t9.i.d(assetData5);
            if (!t9.i.b("movie", assetData5.getProgramType())) {
                ((TextView) _$_findCachedViewById(i10)).append(" ");
                SimpleProgramList simpleProgramList = this.f6112i;
                t9.i.d(simpleProgramList);
                ((TextView) _$_findCachedViewById(i10)).append(String.valueOf(simpleProgramList.getSeriesNumber()));
                return;
            }
            return;
        }
        c3();
        this.I0 = true;
        if (this.f6142x) {
            w2();
            int i11 = R$id.mVideoViewVod;
            if (((TitanVODView) _$_findCachedViewById(i11)).s() || com.mobile.brasiltv.utils.h.f12562a.o()) {
                k3(this, 0, 1, (Object) null);
            }
            if (!playSetIndexEvent.isVideoStop()) {
                ((TitanVODView) _$_findCachedViewById(i11)).D();
            }
            this.f6124o = playSetIndexEvent.getPlaySetIndex();
            this.C = 0;
            int i12 = R$id.mBvavAd;
            ((BeforeVodAdView) _$_findCachedViewById(i12)).hideBeforeVodAd();
            if (playSetIndexEvent.isCast()) {
                ((AutoLinearLayout) _$_findCachedViewById(R$id.mLayoutStage)).setVisibility(8);
                ((ImageView) _$_findCachedViewById(R$id.mIvStage)).setVisibility(8);
                V1(this, false, false, 2, (Object) null);
            } else {
                setStage(this.f6124o);
                if (this.f6112i == null) {
                    if (!playSetIndexEvent.isVideoStop()) {
                        H4();
                    }
                } else if (!this.G) {
                    this.V = true;
                    this.I = true;
                    ((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
                    D4(false);
                    ((RelativeLayout) _$_findCachedViewById(R$id.mBufferView)).setVisibility(0);
                } else if (!playSetIndexEvent.isVideoStop()) {
                    H4();
                }
            }
            AssetData assetData6 = this.f6106f;
            t9.i.d(assetData6);
            this.f6112i = assetData6.getSimpleProgramList().get(this.f6124o);
            getSetInfoAdapter().c(this.f6124o);
            int i13 = R$id.mTextTitle;
            AssetData assetData7 = this.f6106f;
            t9.i.d(assetData7);
            String alias = assetData7.getAlias();
            AssetData assetData8 = this.f6106f;
            t9.i.d(assetData8);
            ((TextView) _$_findCachedViewById(i13)).setText(com.mobile.brasiltv.utils.b0.c(alias, assetData8.getName()));
            AssetData assetData9 = this.f6106f;
            t9.i.d(assetData9);
            String alias2 = assetData9.getAlias();
            AssetData assetData10 = this.f6106f;
            t9.i.d(assetData10);
            ((BeforeVodAdView) _$_findCachedViewById(i12)).setTitle(com.mobile.brasiltv.utils.b0.c(alias2, assetData10.getName()));
            AssetData assetData11 = this.f6106f;
            t9.i.d(assetData11);
            if (!t9.i.b("movie", assetData11.getProgramType())) {
                ((TextView) _$_findCachedViewById(i13)).append(" ");
                SimpleProgramList simpleProgramList2 = this.f6112i;
                t9.i.d(simpleProgramList2);
                ((TextView) _$_findCachedViewById(i13)).append(String.valueOf(simpleProgramList2.getSeriesNumber()));
            }
        }
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void handleSubDownloadFinish(SubTitleDownloadFinishEvent subTitleDownloadFinishEvent) {
        t9.i.g(subTitleDownloadFinishEvent, "event");
        com.mobile.brasiltv.utils.b0.U(this, "字幕文件下载完成");
        this.f6130r = true;
        if (com.mobile.brasiltv.utils.b0.I(this.f6132s)) {
            List list = this.f6132s;
            t9.i.d(list);
            if (list.size() > this.f6115j0) {
                if (this.f6117k0 == -1) {
                    this.f6117k0 = 0;
                }
                if (this.f6119l0 == -1) {
                    this.f6119l0 = 0;
                }
                int i10 = R$id.mVideoViewVod;
                SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
                ((TitanVODView) _$_findCachedViewById(i10)).K(subtitleManager.getPortraitSizeValues()[this.f6117k0].intValue(), subtitleManager.getLandscapeSizeValues()[this.f6117k0].intValue());
                if (this.f6119l0 == 2) {
                    ((TitanVODView) _$_findCachedViewById(i10)).setSubtitleColor(subtitleManager.getColorValues()[0].intValue());
                    ((TitanVODView) _$_findCachedViewById(i10)).setSubtitleBg(1);
                } else {
                    ((TitanVODView) _$_findCachedViewById(i10)).setSubtitleColor(subtitleManager.getColorValues()[this.f6119l0].intValue());
                    ((TitanVODView) _$_findCachedViewById(i10)).setSubtitleBg(0);
                }
                ((TitanVODView) _$_findCachedViewById(i10)).setSubtitleVisible(this.f6121m0);
                List list2 = this.f6132s;
                t9.i.d(list2);
                ((TitanVODView) _$_findCachedViewById(i10)).J(((SubTitleData) list2.get(this.f6115j0)).getFilePath(), subTitleDownloadFinishEvent.getContentId());
            }
        }
    }

    public final void j3(long j10) {
        long j11;
        long j12;
        VodDao vodDao;
        long max = (long) ((CurTimeSeekBar) _$_findCachedViewById(R$id.mSeekBar)).getMax();
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) _$_findCachedViewById(R$id.llCastContainer);
        boolean z10 = false;
        if (autoLinearLayout != null && autoLinearLayout.getVisibility() == 0) {
            z10 = true;
        }
        if (z10) {
            int i10 = R$id.mSeekBarCast;
            j11 = ((long) ((SeekBar) _$_findCachedViewById(i10)).getMax()) * 1000;
            j12 = ((long) ((SeekBar) _$_findCachedViewById(i10)).getProgress()) * ((long) 1000);
        } else {
            if (j10 == 0) {
                j10 = this.C;
            }
            j12 = j10;
            j11 = max;
        }
        if ((!this.f6118l && j12 >= 1 && j12 >= 1) || ((TitanPlayerController) _$_findCachedViewById(R$id.mVodPlayer)).I) {
            int i11 = this.L0;
            if ((i11 == 0 || Math.abs(((long) i11) - j12) >= NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) && (vodDao = this.f6105e) != null) {
                vodDao.addRecord(this.f6106f, this.f6112i, j12, this.f6124o, this.B, j11);
            }
        }
    }

    public final void k2(boolean z10) {
        if (z10) {
            this.f6103c.p(g.f12431a);
            return;
        }
        int i10 = R$id.mLayoutSetInfo;
        if (((AutoFrameLayout) _$_findCachedViewById(i10)).getVisibility() == 0) {
            Disposable disposable = this.C0;
            if (disposable != null) {
                disposable.dispose();
            }
            AutoFrameLayout autoFrameLayout = (AutoFrameLayout) _$_findCachedViewById(i10);
            t9.i.f(autoFrameLayout, "mLayoutSetInfo");
            N4(autoFrameLayout, AutoUtils.getPercentWidthSize(580));
            return;
        }
        this.f6103c.p(h.f12433a);
    }

    public void l0() {
    }

    public final void l3(SubtitleSettingBean subtitleSettingBean) {
        Observable.create(new m1(this, subtitleSettingBean)).compose(ma.q.b()).subscribe(new n1(new q(this)), new o1(new r(this)));
    }

    public void m(String str, String str2, long j10) {
        t9.i.g(str, "adName");
        t9.i.g(str2, "path");
    }

    public void m2() {
        if (!(((ImageView) _$_findCachedViewById(R$id.mIvStage)).getVisibility() == 0 || this.f6112i == null)) {
            ((RelativeLayout) _$_findCachedViewById(R$id.mBufferView)).setVisibility(8);
        }
        this.H = false;
    }

    public void n2() {
        if (this.f6112i != null && ((ImageView) _$_findCachedViewById(R$id.mIvStage)).getVisibility() == 8 && ((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).getVisibility() == 8) {
            ((RelativeLayout) _$_findCachedViewById(R$id.mBufferView)).setVisibility(0);
        }
    }

    public final void o2() {
        this.H = false;
        y2();
        int i10 = R$id.mVideoViewVod;
        ((TitanVODView) _$_findCachedViewById(i10)).D();
        TitanVODView titanVODView = (TitanVODView) _$_findCachedViewById(i10);
        if (titanVODView != null) {
            titanVODView.C();
        }
        b8.b bVar = this.f6104d;
        if (bVar != null) {
            if (bVar == null) {
                t9.i.w("mVoiceHelper");
                bVar = null;
            }
            b8.b.b(bVar, false, 1, (Object) null);
        }
        removeView((TitanVODView) _$_findCachedViewById(i10));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Y2();
        setSeekBarClickable(false);
        setKeepScreenOn(true);
        ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).setAspectRatio(0);
        P3();
    }

    public void onCompletion() {
        this.C = 0;
        Links links = this.f6146z;
        if (links != null) {
            links.setRecordTime(0);
        }
        this.D = true;
        this.f6111h0 = false;
        ((BeforeVodAdView) _$_findCachedViewById(R$id.mBvavAd)).hideBeforeVodAd();
        int i10 = R$id.mSeekBar;
        if (((CurTimeSeekBar) _$_findCachedViewById(i10)).getProgress() < ((CurTimeSeekBar) _$_findCachedViewById(i10)).getMax() - 10000) {
            this.L0 = ((CurTimeSeekBar) _$_findCachedViewById(i10)).getProgress();
            ((CurTimeSeekBar) _$_findCachedViewById(i10)).setProgress(((CurTimeSeekBar) _$_findCachedViewById(i10)).getMax());
            j3(1);
        } else {
            j3(0);
        }
        S2();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f6103c.a();
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        setKeepScreenOn(false);
        a3();
        int i10 = R$id.mVideoViewVod;
        ((TitanVODView) _$_findCachedViewById(i10)).D();
        TitanVODView titanVODView = (TitanVODView) _$_findCachedViewById(i10);
        if (titanVODView != null) {
            titanVODView.C();
        }
        if (this.f6114j == EnterType.HISTORY) {
            xa.c.c().m(new UpdateRecordAtyEvent());
        }
    }

    public void onLoading() {
        post(new m6.l(this));
    }

    public void onPositionUpdate(long j10, long j11) {
        post(new m6.i0(j10, j11, this));
    }

    public void onStop() {
        post(new m6.p(this));
    }

    public void p1() {
    }

    public final void p2() {
        ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).u();
        this.f6142x = false;
    }

    public final void p3(int i10) {
        if (i10 != -1) {
            xa.c.c().j(new PlaySetIndexEvent(i10, false, false, 6, (t9.g) null));
        }
    }

    public void q0(Status status) {
        Program program;
        t9.i.g(status, Constant.KEY_STATUS);
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        hVar.K(true);
        com.mobile.brasiltv.utils.g.f12519a.y(false);
        String play_url = status.getPlay_url();
        t9.i.f(play_url, "status.play_url");
        hVar.E(play_url);
        this.f6127p0 = status.isUrl_modified();
        this.f6129q0 = status.getHost();
        int i10 = R$id.mVideoViewVod;
        n8.b titanContext = ((TitanVODView) _$_findCachedViewById(i10)).getTitanContext();
        if (titanContext != null) {
            program = titanContext.a();
        } else {
            program = null;
        }
        this.E0 = program;
        ((TitanVODView) _$_findCachedViewById(i10)).C();
        f5.c mActivity = getMActivity();
        if (mActivity != null) {
            mActivity.runOnUiThread(new m6.z(this));
        }
    }

    public final void q2() {
        ViewParent viewParent;
        this.f6142x = true;
        ((ImageView) _$_findCachedViewById(R$id.mImageBack)).setVisibility(0);
        if (this.f6103c.l() || getResources().getConfiguration().orientation == 2) {
            x2();
        }
        if (((AutoRelativeLayout) _$_findCachedViewById(R$id.mMemberTipsLayout)).getVisibility() != 0) {
            ((AlphaRelativeLayout) _$_findCachedViewById(R$id.mLayoutController)).setVisibility(0);
            z3();
            B3();
            Observable<Long> timer = Observable.timer(6, TimeUnit.SECONDS, AndroidSchedulers.mainThread());
            Context context = getContext();
            t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
            timer.compose(((PlayAty) context).O1()).subscribe(new m6.k(new i(this)));
        }
        if (this.f6124o != -1 && this.f6106f != null && this.f6112i != null && !this.G && this.S && ((AutoLinearLayout) _$_findCachedViewById(R$id.llCastContainer)).getVisibility() != 0) {
            PauseAdView pauseAdView = this.A;
            if (pauseAdView != null) {
                viewParent = pauseAdView.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent != null) {
                return;
            }
            if (this.D) {
                ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).x(0);
            } else {
                ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).w();
            }
        }
    }

    public final void q3() {
        CastDevice castDevice;
        String friendlyName;
        String friendly_name;
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        String str = "";
        if (t9.i.b(hVar.a(), hVar.k())) {
            int i10 = R$id.mTvCastDevice;
            TextView textView = (TextView) _$_findCachedViewById(i10);
            Device g10 = com.mobile.brasiltv.utils.g.f12519a.g();
            if (!(g10 == null || (friendly_name = g10.getFriendly_name()) == null)) {
                str = friendly_name;
            }
            textView.setText(str);
            ((TextView) _$_findCachedViewById(i10)).append("-DLNA");
            return;
        }
        int i11 = R$id.mTvCastDevice;
        TextView textView2 = (TextView) _$_findCachedViewById(i11);
        CastSession i12 = this.N.i();
        if (!(i12 == null || (castDevice = i12.getCastDevice()) == null || (friendlyName = castDevice.getFriendlyName()) == null)) {
            str = friendlyName;
        }
        textView2.setText(str);
        ((TextView) _$_findCachedViewById(i11)).append("-ChromeCast");
    }

    public void r1(long j10) {
        this.f6139v0 = j10;
        ((CurTimeSeekBar) _$_findCachedViewById(R$id.mSeekBar)).setSecondaryProgress((int) this.f6139v0);
    }

    public final void r3() {
        ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setOnClickListener(new m6.a0(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvCastQuality)).setOnClickListener(new m6.b0(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvCastClose)).setOnClickListener(new m6.c0(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvCastSwitchDevice)).setOnClickListener(new m6.d0(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvCastFeedback)).setOnClickListener(new m6.e0(this));
        ((SeekBar) _$_findCachedViewById(R$id.mSeekBarCast)).setOnSeekBarChangeListener(new t(this));
    }

    public final void s2(VodDao vodDao, AssetData assetData, String str, EnterType enterType, String str2, boolean z10, boolean z11) {
        t9.i.g(vodDao, "vodDao");
        t9.i.g(assetData, "program");
        t9.i.g(str, "vodType");
        this.D0 = true;
        this.f6105e = vodDao;
        this.f6106f = assetData;
        this.f6125o0 = assetData.getContentId();
        this.B = str;
        this.f6114j = enterType;
        this.f6116k = str2;
        this.f6118l = z10;
        ((BeforeVodAdView) _$_findCachedViewById(R$id.mBvavAd)).setCr(z10);
        int i10 = R$id.recyclerSetInfo;
        ((RecyclerView) _$_findCachedViewById(i10)).setItemAnimator((RecyclerView.l) null);
        GridLayoutManagerWrapper gridLayoutManagerWrapper = new GridLayoutManagerWrapper(getContext(), 5);
        if (((RecyclerView) _$_findCachedViewById(i10)).getItemDecorationCount() != 0) {
            ((RecyclerView) _$_findCachedViewById(i10)).removeItemDecorationAt(0);
        }
        ((RecyclerView) _$_findCachedViewById(i10)).addItemDecoration(new GridDecoration(AutoUtils.getPercentHeightSize(36), 5));
        ((RecyclerView) _$_findCachedViewById(i10)).setLayoutManager(gridLayoutManagerWrapper);
        ((RecyclerView) _$_findCachedViewById(i10)).setAdapter(getSetInfoAdapter());
        n6.a setInfoAdapter = getSetInfoAdapter();
        AssetData assetData2 = this.f6106f;
        t9.i.d(assetData2);
        setInfoAdapter.setNewData(assetData2.getSimpleProgramList());
        if (z11) {
            z2();
        }
        Z3();
        r3();
        x3();
        Q3();
    }

    public final void setCastStatusHost(String str) {
        this.f6129q0 = str;
    }

    public final void setCr(boolean z10) {
        this.f6118l = z10;
    }

    public final void setCurPlayProgram(SimpleProgramList simpleProgramList) {
        this.f6112i = simpleProgramList;
    }

    public final void setData(AssetData assetData) {
        this.f6106f = assetData;
    }

    public final void setEnableNoWifiPlay(boolean z10) {
        this.f6144y = z10;
    }

    public final void setEnterType(EnterType enterType) {
        this.f6114j = enterType;
    }

    public final void setMDetailDataContentId(String str) {
        this.f6125o0 = str;
    }

    public final void setMMovie(Movie movie) {
        this.f6110h = movie;
    }

    public final void setMOrientationHelper(q5.j jVar) {
        t9.i.g(jVar, "<set-?>");
        this.f6103c = jVar;
    }

    public final void setMVodDao(VodDao vodDao) {
        this.f6105e = vodDao;
    }

    public final void setPlayNextSeries(boolean z10) {
        this.I = z10;
    }

    public final void setProgramBookMark(Links links) {
        this.f6146z = links;
    }

    public final void setProgramLoad(boolean z10) {
        this.D0 = z10;
    }

    public final void setResumed(boolean z10) {
        this.f6142x = z10;
    }

    public final void setSubData(List<SubTitleData> list) {
        t9.i.g(list, "list");
        this.f6132s = list;
        setDefaultSubtitleOption(list);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.add(0, this.f6145y0);
        getSubtitleAudioLandWindow().p(arrayList, this.f6115j0 + 1);
        getSubtitleAudioLandWindow().r(getSizeList(), this.f6117k0);
        getSubtitleAudioLandWindow().n(getStyleList(), this.f6119l0);
        getSubtitleAudioLandWindow().q(this.f6121m0);
        getSubtitleAudioPorWindow().p(arrayList, this.f6115j0 + 1);
        getSubtitleAudioPorWindow().r(getSizeList(), this.f6117k0);
        getSubtitleAudioPorWindow().n(getStyleList(), this.f6119l0);
        getSubtitleAudioPorWindow().q(this.f6121m0);
    }

    public final void setSupportUrlModified(boolean z10) {
        this.f6127p0 = z10;
    }

    public final void setTopicName(String str) {
        this.f6116k = str;
    }

    public final void setVodFuncCallback(m6.a aVar) {
        t9.i.g(aVar, "callback");
        this.M = aVar;
    }

    public final void setVodQualityVisibility(int i10) {
        if (i10 == 8) {
            ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlQuality)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R$id.mImageQuality)).setVisibility(8);
        } else if (B2()) {
            ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlQuality)).setVisibility(i10);
        } else {
            ((ImageView) _$_findCachedViewById(R$id.mImageQuality)).setVisibility(i10);
        }
    }

    public final void setVodSubtitleAudioVisibility(int i10) {
        if (i10 != 0 || !this.f6134t) {
            ((ImageView) _$_findCachedViewById(R$id.mIvSubtitleAudio)).setVisibility(8);
            ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlAudioLanguage)).setVisibility(8);
            return;
        }
        if (!B2()) {
            ((ImageView) _$_findCachedViewById(R$id.mIvSubtitleAudio)).setVisibility(0);
        } else {
            ((ImageView) _$_findCachedViewById(R$id.mIvSubtitleAudio)).setVisibility(8);
        }
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlAudioLanguage)).setVisibility(0);
    }

    public final void setWaitingCastUrl(boolean z10) {
        this.J0 = z10;
    }

    public void t0() {
    }

    public final void t2(AssetData assetData) {
        t9.i.g(assetData, "program");
        this.f6106f = assetData;
        if (!this.D0) {
            z2();
            Z3();
            r3();
            x3();
            Q3();
        }
    }

    public void u(int i10) {
        boolean z10;
        p6.b bVar = p6.b.f19300a;
        Context context = getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        String a10 = bVar.a(context, i10);
        if (a10 == null || a10.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 && this.f6142x) {
            f1.a aVar = com.mobile.brasiltv.utils.f1.f12517a;
            aVar.u(a10 + ' ' + w6.i.f9510g.H());
        }
    }

    public final boolean v2(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        float f12;
        MotionEvent motionEvent3 = motionEvent2;
        if (motionEvent == null || motionEvent3 == null) {
            return true;
        }
        float rawX = motionEvent.getRawX();
        float rawX2 = motionEvent2.getRawX();
        float rawY = motionEvent.getRawY();
        float rawY2 = motionEvent2.getRawY();
        int width = getWidth();
        if (this.L == b.NONE) {
            com.mobile.brasiltv.utils.b0.U(this, "NONE");
            float f13 = rawY - rawY2;
            if (Math.abs(rawX - rawX2) < Math.abs(f13)) {
                f12 = rawX;
                double d10 = (double) width;
                Double.isNaN(d10);
                if (((double) rawX) <= (d10 * 1.0d) / 2.0d) {
                    this.L = b.BRIGHTNESS;
                } else if (Math.abs(f11) > 3.0f) {
                    this.L = b.VOLUME;
                }
            } else {
                f12 = rawX;
                if (Math.abs(rawX2 - f12) > Math.abs(f13) + ((float) 30)) {
                    this.L = b.FF_REW;
                }
            }
        } else {
            f12 = rawX;
        }
        int i10 = c.f12417a[this.L.ordinal()];
        if (i10 == 1) {
            com.mobile.brasiltv.utils.b0.U(this, "VOLUME");
            double d11 = (double) width;
            Double.isNaN(d11);
            if (((double) f12) <= (d11 * 1.0d) / 2.0d) {
                return true;
            }
            R2(motionEvent3);
            return true;
        } else if (i10 == 2) {
            com.mobile.brasiltv.utils.b0.U(this, "BRIGHTNESS");
            double d12 = (double) width;
            Double.isNaN(d12);
            if (((double) f12) > (d12 * 1.0d) / 2.0d) {
                return true;
            }
            G2(f11 / ((float) AutoUtils.getPercentHeightSize(280)));
            return true;
        } else if (i10 != 3) {
            return true;
        } else {
            com.mobile.brasiltv.utils.b0.U(this, "FF_REW");
            float f14 = rawX2 - f12;
            if (Math.abs(f14) <= Math.abs(rawY - rawY2) + ((float) 30)) {
                return true;
            }
            P2((f14 / ((float) width)) / ((float) 3));
            return true;
        }
    }

    public boolean w1() {
        return false;
    }

    public final void w2() {
        ViewParent viewParent;
        PauseAdView pauseAdView = this.A;
        if (pauseAdView != null) {
            if (pauseAdView != null) {
                viewParent = pauseAdView.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent != null) {
                removeView(this.A);
            }
        }
    }

    public final void x2() {
        View view;
        Window window = getMActivity().getWindow();
        if (window != null) {
            view = window.getDecorView();
        } else {
            view = null;
        }
        if (view != null) {
            view.setSystemUiVisibility(q.a.f14394g);
        }
    }

    public final void x3() {
        ((TextView) _$_findCachedViewById(R$id.tvConfirm)).setOnClickListener(new m6.u(this));
    }

    public final void y2() {
    }

    public final void y4(int i10, int i11) {
        ((ImageView) _$_findCachedViewById(R$id.mImageQuality)).setImageResource(i11);
        ((ImageView) _$_findCachedViewById(R$id.mIvLandQuality)).setImageResource(i10);
    }

    public void z() {
        this.W = true;
        if (s6.a.f9335a.a().o()) {
            ((ImageView) _$_findCachedViewById(R$id.mImageCast)).setVisibility(0);
        } else {
            ((ImageView) _$_findCachedViewById(R$id.mImageCast)).setVisibility(8);
        }
        U3();
        U4();
        this.f6113i0 = System.currentTimeMillis();
        this.H = false;
        if (!this.V || !X1() || !this.f6107f0) {
            ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).u();
            return;
        }
        X2();
        int i10 = R$id.mVideoViewVod;
        if (!((TitanVODView) _$_findCachedViewById(i10)).s()) {
            ((TitanVODView) _$_findCachedViewById(i10)).w();
        }
        if (this.f6109g0) {
            ((TitanVODView) _$_findCachedViewById(i10)).x(this.C);
            this.f6109g0 = false;
        }
        if (!this.f6142x) {
            ((TitanVODView) _$_findCachedViewById(i10)).u();
        }
    }

    public final void z2() {
        this.f6134t = false;
        setVodSubtitleAudioVisibility(8);
        this.f6123n0 = 0;
        this.f6115j0 = -1;
        this.f6117k0 = -1;
        this.f6119l0 = -1;
        this.f6121m0 = false;
        getSubtitleAudioLandWindow().m(i9.j.c(this.f6147z0), this.f6123n0);
        getSubtitleAudioLandWindow().p(i9.j.c(this.f6143x0), this.f6115j0 + 1);
        getSubtitleAudioLandWindow().r(getSizeList(), this.f6117k0);
        getSubtitleAudioLandWindow().n(getStyleList(), this.f6119l0);
        getSubtitleAudioLandWindow().q(this.f6121m0);
        getSubtitleAudioPorWindow().m(i9.j.c(this.f6147z0), this.f6123n0);
        getSubtitleAudioPorWindow().p(i9.j.c(this.f6143x0), this.f6115j0 + 1);
        getSubtitleAudioPorWindow().r(getSizeList(), this.f6117k0);
        getSubtitleAudioPorWindow().n(getStyleList(), this.f6119l0);
        getSubtitleAudioPorWindow().q(this.f6121m0);
    }

    public final void z3() {
        ((ProgressBar) _$_findCachedViewById(R$id.mPbBrightness)).setProgress((int) (getRealCurBrightness() * ((float) 100)));
    }

    public final void z4() {
        View view;
        Window window = getMActivity().getWindow();
        if (window != null) {
            view = window.getDecorView();
        } else {
            view = null;
        }
        if (view != null) {
            view.setSystemUiVisibility(0);
        }
        n5.a.f8310a.h(getMActivity());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitanPlayerController(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.N0 = new LinkedHashMap();
        this.f6101a = this;
        this.f6102b = h9.h.b(new l(context));
        this.f6108g = new HashMap();
        this.f6114j = EnterType.CATEGORY;
        this.f6124o = -1;
        this.f6126p = "";
        this.f6128q = "";
        this.f6136u = h9.h.b(g0.f12432a);
        this.f6138v = h9.h.b(new u0(this));
        this.f6140w = h9.h.b(new v0(this));
        this.B = "0";
        this.G = true;
        this.L = b.NONE;
        this.N = new z5.c();
        this.O = "";
        this.f6107f0 = true;
        this.f6115j0 = -1;
        this.f6117k0 = -1;
        this.f6119l0 = -1;
        this.f6131r0 = h9.h.b(new s0(context));
        this.f6133s0 = h9.h.b(new t0(context));
        this.f6139v0 = -1;
        this.f6141w0 = 10000;
        this.f6143x0 = new NoSubTitleData();
        this.f6145y0 = new OffSubTitleData();
        this.f6147z0 = new AudioTrackBean("", "", "no", 0, true);
        this.K0 = h9.h.b(new m(context));
        Y2();
        LayoutInflater.from(context).inflate(R.layout.layout_titan_vod_controller, this, true);
        q5.j jVar = new q5.j(getMActivity(), (j.d) null, 2, (t9.g) null);
        this.f6103c = jVar;
        jVar.d();
        a aVar = new a(this, getMActivity());
        this.f6104d = aVar;
        aVar.c();
        int a10 = n5.a.f8310a.a(context);
        int percentHeightSize = AutoUtils.getPercentHeightSize(88);
        AutoRelativeLayout.LayoutParams layoutParams = new AutoRelativeLayout.LayoutParams(percentHeightSize, percentHeightSize);
        layoutParams.setMargins(0, a10, 0, 0);
        int i11 = R$id.mImageBack;
        ((ImageView) _$_findCachedViewById(i11)).setLayoutParams(layoutParams);
        AutoRelativeLayout.LayoutParams layoutParams2 = new AutoRelativeLayout.LayoutParams(-2, percentHeightSize);
        layoutParams2.setMargins(percentHeightSize, a10, 0, 0);
        ((TextView) _$_findCachedViewById(R$id.mTextTitle)).setLayoutParams(layoutParams2);
        AutoRelativeLayout.LayoutParams layoutParams3 = new AutoRelativeLayout.LayoutParams(-2, percentHeightSize);
        layoutParams3.addRule(11);
        layoutParams3.setMargins(layoutParams3.leftMargin, a10, layoutParams3.rightMargin, layoutParams3.bottomMargin);
        ((AutoLinearLayout) _$_findCachedViewById(R$id.llMenu)).setLayoutParams(layoutParams3);
        ((ImageView) _$_findCachedViewById(i11)).setOnClickListener(new m6.r(this));
        setBackgroundColor(getResources().getColor(R.color.color_000000));
        int i12 = R$id.mVideoViewVod;
        ((TitanVODView) _$_findCachedViewById(i12)).setPlayerListener(this);
        ((TitanVODView) _$_findCachedViewById(i12)).setPlayerStateChangeListener(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TitanPlayerController(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
