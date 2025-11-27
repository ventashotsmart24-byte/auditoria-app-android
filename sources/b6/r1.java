package b6;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Html;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b6.r0;
import b6.z;
import b8.a;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.common.images.WebImage;
import com.google.gson.Gson;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.CastByNativeDeviceAty;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.BaseGuideManager;
import com.mobile.brasiltv.bean.GuideNextClickListener;
import com.mobile.brasiltv.bean.LiveFeedBackGuideManager;
import com.mobile.brasiltv.bean.event.AlreadyQueryFavEvent;
import com.mobile.brasiltv.bean.event.CastPlaySuccessEvent;
import com.mobile.brasiltv.bean.event.CastToCloseFloatViewEvent;
import com.mobile.brasiltv.bean.event.CastToCloseOtherPlayEvent;
import com.mobile.brasiltv.bean.event.CastToPlayEvent;
import com.mobile.brasiltv.bean.event.CheckPwdSuccessEvent;
import com.mobile.brasiltv.bean.event.FullScreenEvent;
import com.mobile.brasiltv.bean.event.GoogleCastToPlayEvent;
import com.mobile.brasiltv.bean.event.NetworkEvent;
import com.mobile.brasiltv.bean.event.ReadyPlayFavEvent;
import com.mobile.brasiltv.bean.event.RefreshEPGEvent;
import com.mobile.brasiltv.bean.event.UpdateChannelEvent;
import com.mobile.brasiltv.bean.event.UpdateFavStatusEvent;
import com.mobile.brasiltv.bean.event.UpdateFullScreenSortEvent;
import com.mobile.brasiltv.bean.event.UpdateHighLightEvent;
import com.mobile.brasiltv.bean.event.UserIdentityChangeEvent;
import com.mobile.brasiltv.mine.activity.AccountBindAty;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.player.TitanPlayerController;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.g;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.s0;
import com.mobile.brasiltv.view.AnimatorFrameLayout;
import com.mobile.brasiltv.view.AutoHideRelativeLayout;
import com.mobile.brasiltv.view.KoocanRecyclerView;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.RatioFrameLayout;
import com.mobile.brasiltv.view.RoundedDrawable;
import com.mobile.brasiltv.view.dialog.BindEmailOrPhoneNotification;
import com.mobile.brasiltv.view.dialog.CommTipsDialog;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.mobile.brasiltv.view.dialog.GuideDialog;
import com.mobile.brasiltv.view.dialog.feedback.CastFeedBackDialog;
import com.mobile.brasiltv.view.dialog.feedback.FeedBackDialog;
import com.msandroid.mobile.R;
import com.titan.cast.bean.Device;
import com.titan.ranger.Status;
import com.titan.ranger.bean.Media;
import com.titan.ranger.bean.Program;
import com.titans.widget.TitanVideoView;
import com.umeng.analytics.pro.q;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import g5.j0;
import g5.o0;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j6.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import mobile.com.requestframe.utils.response.Channel;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.EpgResultData;
import mobile.com.requestframe.utils.response.GetLiveData;
import mobile.com.requestframe.utils.response.GetLiveDataResult;
import org.android.agoo.common.AgooConstants;
import org.greenrobot.eventbus.ThreadMode;
import q5.j;
import w6.i;
import z5.c;

public final class r1 extends f implements View.OnClickListener, KoocanRecyclerView.OnVisibility, j6.g, c.d, c.e, o8.a {

    /* renamed from: n0  reason: collision with root package name */
    public static final a f4461n0 = new a((t9.g) null);

    /* renamed from: o0  reason: collision with root package name */
    public static q5.j f4462o0;
    public g6.d A;
    public Disposable B;
    public z5.c C = new z5.c();
    public String D = "";
    public String E = "";
    public String F = "";
    public String G = "";
    public String H = "";
    public String I = "";
    public Program J;
    public boolean K;
    public boolean L;
    public String M;
    public Integer N;
    public boolean O = true;
    public boolean Q;
    public String S;
    public final h9.g V = h9.h.b(r.f11129a);
    public Channel W;
    public int X;
    public long Y;
    public boolean Z;

    /* renamed from: e  reason: collision with root package name */
    public final String f4463e = s4();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList f4464f = new ArrayList();

    /* renamed from: f0  reason: collision with root package name */
    public boolean f4465f0;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList f4466g = new ArrayList();

    /* renamed from: g0  reason: collision with root package name */
    public final s f4467g0 = new s(this);

    /* renamed from: h  reason: collision with root package name */
    public int f4468h = -1;

    /* renamed from: h0  reason: collision with root package name */
    public PopupWindow f4469h0;

    /* renamed from: i  reason: collision with root package name */
    public int f4470i;

    /* renamed from: i0  reason: collision with root package name */
    public b8.b f4471i0;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList f4472j = new ArrayList();

    /* renamed from: j0  reason: collision with root package name */
    public TitanPlayerController.b f4473j0 = TitanPlayerController.b.NONE;

    /* renamed from: k  reason: collision with root package name */
    public Channel f4474k;

    /* renamed from: k0  reason: collision with root package name */
    public Float f4475k0;

    /* renamed from: l  reason: collision with root package name */
    public boolean f4476l;

    /* renamed from: l0  reason: collision with root package name */
    public c f4477l0 = new c(this);

    /* renamed from: m  reason: collision with root package name */
    public j0 f4478m;

    /* renamed from: m0  reason: collision with root package name */
    public Map f4479m0 = new LinkedHashMap();

    /* renamed from: n  reason: collision with root package name */
    public o0 f4480n;

    /* renamed from: o  reason: collision with root package name */
    public AudioManager f4481o;

    /* renamed from: p  reason: collision with root package name */
    public int f4482p = 7;

    /* renamed from: q  reason: collision with root package name */
    public CommonDialog f4483q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f4484r;

    /* renamed from: s  reason: collision with root package name */
    public Disposable f4485s;

    /* renamed from: t  reason: collision with root package name */
    public Disposable f4486t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f4487u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f4488v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f4489w;

    /* renamed from: x  reason: collision with root package name */
    public l6.g0 f4490x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f4491y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f4492z;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final q5.j a() {
            return r1.f4462o0;
        }
    }

    public static final class a0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11091a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a0(r1 r1Var) {
            super(1);
            this.f11091a = r1Var;
        }

        public final void b(CommTipsDialog commTipsDialog) {
            boolean z10;
            t9.i.g(commTipsDialog, "it");
            commTipsDialog.dismiss();
            if (d6.b.f6366a.y()) {
                com.mobile.brasiltv.utils.b0.a0(this.f11091a, AccountBindAty.class);
                return;
            }
            i.c cVar = w6.i.f9510g;
            if (cVar.g().length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                com.mobile.brasiltv.utils.b0.k0(this.f11091a, cVar.g(), false, true, false, 8, (Object) null);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((CommTipsDialog) obj);
            return h9.t.f17319a;
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11092a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.mobile.brasiltv.player.TitanPlayerController$b[] r0 = com.mobile.brasiltv.player.TitanPlayerController.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.mobile.brasiltv.player.TitanPlayerController$b r1 = com.mobile.brasiltv.player.TitanPlayerController.b.VOLUME     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.mobile.brasiltv.player.TitanPlayerController$b r1 = com.mobile.brasiltv.player.TitanPlayerController.b.BRIGHTNESS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.mobile.brasiltv.player.TitanPlayerController$b r1 = com.mobile.brasiltv.player.TitanPlayerController.b.NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.mobile.brasiltv.player.TitanPlayerController$b r1 = com.mobile.brasiltv.player.TitanPlayerController.b.FF_REW     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f11092a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b6.r1.b.<clinit>():void");
        }
    }

    public static final class b0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f11093a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ r1 f11094b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f11095a = new a();

            public a() {
                super(1);
            }

            /* renamed from: b */
            public final Intent invoke(Intent intent) {
                t9.i.g(intent, "intent");
                Intent putExtra = intent.putExtra("experience_mode", true);
                t9.i.f(putExtra, "intent.putExtra(Constant…ST_EXPERIENCE_MODE, true)");
                return putExtra;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b0(boolean z10, r1 r1Var) {
            super(1);
            this.f11093a = z10;
            this.f11094b = r1Var;
        }

        public final void b(CommTipsDialog commTipsDialog) {
            t9.i.g(commTipsDialog, "it");
            if (this.f11093a) {
                i1.g(this.f11094b.getActivity(), "EVENT_CAST_EXPERIENCE_VOD_CLICK");
                com.mobile.brasiltv.utils.b0.b0(this.f11094b, CastByNativeDeviceAty.class, a.f11095a);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((CommTipsDialog) obj);
            return h9.t.f17319a;
        }
    }

    public static final class c implements g.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11096a;

        public c(r1 r1Var) {
            this.f11096a = r1Var;
        }

        public static final void i(r1 r1Var, int i10, String str, String str2) {
            t9.i.g(r1Var, "this$0");
            t9.i.g(str, "$extra");
            if (com.mobile.brasiltv.utils.h.f12562a.t()) {
                com.mobile.brasiltv.utils.g.f12519a.G();
            }
            xa.c.c().j(new CastToCloseFloatViewEvent());
            if (i10 == 501 || i10 == 701) {
                TextView textView = (TextView) r1Var.x3(R$id.mTvCastRecommendHint);
                if (textView != null) {
                    textView.setVisibility(8);
                }
                int i11 = R$id.mTvCastErrorHint;
                TextView textView2 = (TextView) r1Var.x3(i11);
                if (textView2 != null) {
                    textView2.setText(r1Var.getResources().getString(R.string.cast_restart_device));
                }
                TextView textView3 = (TextView) r1Var.x3(i11);
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
            } else {
                TextView textView4 = (TextView) r1Var.x3(R$id.mTvCastRecommendHint);
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
                TextView textView5 = (TextView) r1Var.x3(R$id.mTvCastErrorHint);
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
            }
            int i12 = R$id.mTvCastState;
            TextView textView6 = (TextView) r1Var.x3(i12);
            if (textView6 != null) {
                Context context = r1Var.getContext();
                t9.i.d(context);
                textView6.setText(context.getResources().getString(R.string.cast_status_casting_failed));
            }
            ((TextView) r1Var.x3(i12)).append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN + str2 + ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER + i10 + ASCIIPropertyListParser.ARRAY_END_TOKEN);
            Context context2 = r1Var.getContext();
            t9.i.d(context2);
            ((TextView) r1Var.x3(i12)).setTextColor(context2.getResources().getColor(R.color.color_f72f2f));
            ((TextView) r1Var.x3(R$id.mTvPleaseWait)).setVisibility(8);
        }

        public static final void j(r1 r1Var) {
            t9.i.g(r1Var, "this$0");
            xa.c.c().j(new CastPlaySuccessEvent("LIVE"));
            int i10 = R$id.mTvCastState;
            TextView textView = (TextView) r1Var.x3(i10);
            if (textView != null) {
                Context context = r1Var.getContext();
                t9.i.d(context);
                textView.setText(context.getResources().getString(R.string.cast_status_casting));
            }
            TextView textView2 = (TextView) r1Var.x3(i10);
            if (textView2 != null) {
                Context context2 = r1Var.getContext();
                t9.i.d(context2);
                textView2.setTextColor(context2.getResources().getColor(R.color.color_fffefe));
            }
            TextView textView3 = (TextView) r1Var.x3(R$id.mTvPleaseWait);
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = (TextView) r1Var.x3(R$id.mTvCastRecommendHint);
            if (textView4 != null) {
                textView4.setVisibility(4);
            }
            TextView textView5 = (TextView) r1Var.x3(R$id.mTvCastErrorHint);
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            r1Var.c5();
        }

        public static final void k(r1 r1Var, long j10, long j11) {
            t9.i.g(r1Var, "this$0");
            int i10 = R$id.mTvCastState;
            TextView textView = (TextView) r1Var.x3(i10);
            if (textView != null) {
                Context context = r1Var.getContext();
                t9.i.d(context);
                textView.setText(context.getResources().getString(R.string.cast_status_casting));
            }
            TextView textView2 = (TextView) r1Var.x3(i10);
            if (textView2 != null) {
                Context context2 = r1Var.getContext();
                t9.i.d(context2);
                textView2.setTextColor(context2.getResources().getColor(R.color.color_fffefe));
            }
            TextView textView3 = (TextView) r1Var.x3(R$id.mTvPleaseWait);
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = (TextView) r1Var.x3(R$id.mTvCastRecommendHint);
            if (textView4 != null) {
                textView4.setVisibility(4);
            }
            TextView textView5 = (TextView) r1Var.x3(R$id.mTvCastErrorHint);
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
        }

        public static final void l(r1 r1Var) {
            String str;
            t9.i.g(r1Var, "this$0");
            xa.c.c().j(new CastToCloseFloatViewEvent());
            TextView textView = (TextView) r1Var.x3(R$id.mTvCastRecommendHint);
            if (textView != null) {
                textView.setVisibility(8);
            }
            int i10 = R$id.mTvCastErrorHint;
            TextView textView2 = (TextView) r1Var.x3(i10);
            if (textView2 != null) {
                Context context = r1Var.getContext();
                if (context != null) {
                    str = com.mobile.brasiltv.utils.x.f12622a.y(context, R.string.failed_cast_play);
                } else {
                    str = null;
                }
                textView2.setText(str);
            }
            TextView textView3 = (TextView) r1Var.x3(i10);
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            int i11 = R$id.mTvCastState;
            TextView textView4 = (TextView) r1Var.x3(i11);
            if (textView4 != null) {
                Context context2 = r1Var.getContext();
                t9.i.d(context2);
                textView4.setText(context2.getResources().getString(R.string.cast_status_casting_failed));
            }
            TextView textView5 = (TextView) r1Var.x3(i11);
            if (textView5 != null) {
                Context context3 = r1Var.getContext();
                t9.i.d(context3);
                textView5.setTextColor(context3.getResources().getColor(R.color.color_f72f2f));
            }
            TextView textView6 = (TextView) r1Var.x3(R$id.mTvPleaseWait);
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
        }

        public void a() {
        }

        public void b(int i10, String str, String str2) {
            t9.i.g(str, "extra");
            if (!h()) {
                ((AutoLinearLayout) this.f11096a.x3(R$id.llCastContainer)).post(new t1(this.f11096a, i10, str, str2));
            }
        }

        public void d() {
            if (!h()) {
                ((AutoLinearLayout) this.f11096a.x3(R$id.llCastContainer)).post(new s1(this.f11096a));
            }
        }

        public final boolean h() {
            if (!this.f11096a.isDetached()) {
                return false;
            }
            com.mobile.brasiltv.utils.g.f12519a.w((g.b) null);
            return true;
        }

        public void onLoading() {
            xa.c.c().j(new CastPlaySuccessEvent("LIVE"));
        }

        public void onPositionUpdate(long j10, long j11) {
            if (!h()) {
                ((AutoLinearLayout) this.f11096a.x3(R$id.llCastContainer)).post(new u1(this.f11096a, j10, j11));
            }
        }

        public void onStop() {
            if (!h()) {
                ((AutoLinearLayout) this.f11096a.x3(R$id.llCastContainer)).post(new v1(this.f11096a));
            }
        }
    }

    public static final class c0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11097a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c0(r1 r1Var) {
            super(1);
            this.f11097a = r1Var;
        }

        public final void b(CommTipsDialog commTipsDialog) {
            t9.i.g(commTipsDialog, "it");
            commTipsDialog.dismiss();
            this.f11097a.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((CommTipsDialog) obj);
            return h9.t.f17319a;
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11098a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f11099b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f11100c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(r1 r1Var, Context context, long j10) {
            super(1);
            this.f11098a = r1Var;
            this.f11099b = context;
            this.f11100c = j10;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f17319a;
        }

        public final void invoke(String str) {
            r1 r1Var = this.f11098a;
            p6.a aVar = p6.a.f19299a;
            Context context = this.f11099b;
            t9.i.f(context, "it");
            r1Var.M = aVar.a(context, (int) this.f11100c);
        }
    }

    public static final class d0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f11101a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f11102b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ r1 f11103c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d0(Context context, int i10, r1 r1Var) {
            super(1);
            this.f11101a = context;
            this.f11102b = i10;
            this.f11103c = r1Var;
        }

        public static final void c(String str) {
            f1.a aVar = f1.f12517a;
            aVar.u(str + ' ' + w6.i.f9510g.H());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f17319a;
        }

        public final void invoke(String str) {
            androidx.fragment.app.e activity;
            p6.b bVar = p6.b.f19300a;
            Context context = this.f11101a;
            t9.i.f(context, "it");
            String a10 = bVar.a(context, this.f11102b);
            if (!(a10 == null || a10.length() == 0) && this.f11103c.K4() && (activity = this.f11103c.getActivity()) != null) {
                activity.runOnUiThread(new b2(a10));
            }
        }
    }

    public static final class e extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11104a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(r1 r1Var) {
            super(1);
            this.f11104a = r1Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f17319a;
        }

        public final void invoke(String str) {
            f1.a aVar = f1.f12517a;
            StringBuilder sb = new StringBuilder();
            sb.append("EC21-");
            t9.z zVar = t9.z.f19601a;
            String string = this.f11104a.getString(R.string.failed_play_consult_dealer);
            t9.i.f(string, "getString(R.string.failed_play_consult_dealer)");
            String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
            t9.i.f(format, "format(format, *args)");
            sb.append(format);
            aVar.x(sb.toString());
        }
    }

    public static final class e0 implements GuideNextClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11105a;

        public e0(r1 r1Var) {
            this.f11105a = r1Var;
        }

        public void onGuideNextClick(String str, boolean z10) {
            if (z10) {
                q5.j a10 = r1.f4461n0.a();
                if (a10 != null) {
                    a10.x();
                }
                ((AutoHideRelativeLayout) this.f11105a.x3(R$id.mLiveControlPanelLandscape)).delayHide();
            }
        }
    }

    public static final class f extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11106a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(r1 r1Var) {
            super(1);
            this.f11106a = r1Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Long l10) {
            if (!this.f11106a.f4487u) {
                this.f11106a.F4();
            }
        }
    }

    public static final class f0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final f0 f11107a = new f0();

        public f0() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(Long l10) {
            t9.i.g(l10, "it");
            return Boolean.valueOf(r5.i.f19378a.I());
        }
    }

    public static final class g extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final g f11108a = new g();

        public g() {
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

    public static final class g0 implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11109a;

        public g0(r1 r1Var) {
            this.f11109a = r1Var;
        }

        public void a(long j10) {
            Disposable C3 = this.f11109a.B;
            if (C3 != null) {
                C3.dispose();
            }
            this.f11109a.O3();
        }

        public void onComplete() {
            r5.i iVar = r5.i.f19378a;
            iVar.K(true);
            iVar.L("32600");
            this.f11109a.O3();
        }

        public void onError(Throwable th) {
            t9.i.g(th, "e");
        }

        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            a(((Number) obj).longValue());
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            this.f11109a.B = disposable;
        }
    }

    public static final class h extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11110a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(String str) {
            super(1);
            this.f11110a = str;
        }

        /* renamed from: b */
        public final ObservableSource invoke(ArrayList arrayList) {
            t9.i.g(arrayList, "list");
            String str = this.f11110a;
            int i10 = 0;
            for (Object next : arrayList) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                if (t9.i.b(str, ((Channel) next).getChannelCode())) {
                    return Observable.just(Integer.valueOf(i10));
                }
                i10 = i11;
            }
            return Observable.just(-1);
        }
    }

    public static final class h0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11111a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h0(r1 r1Var) {
            super(1);
            this.f11111a = r1Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f17319a;
        }

        public final void invoke(String str) {
            r1 r1Var = this.f11111a;
            StringBuilder sb = new StringBuilder();
            sb.append("EC21-");
            t9.z zVar = t9.z.f19601a;
            String string = this.f11111a.getString(R.string.failed_play_consult_dealer);
            t9.i.f(string, "getString(R.string.failed_play_consult_dealer)");
            String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
            t9.i.f(format, "format(format, *args)");
            sb.append(format);
            r1Var.z0(sb.toString());
        }
    }

    public static final class i extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11112a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f11113b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(r1 r1Var, boolean z10) {
            super(1);
            this.f11112a = r1Var;
            this.f11113b = z10;
        }

        public final void b(Integer num) {
            j0 A3 = this.f11112a.f4478m;
            if (A3 == null) {
                t9.i.w("adapterChannel");
                A3 = null;
            }
            t9.i.f(num, "it");
            A3.c(num.intValue());
            if (this.f11113b && num.intValue() != -1) {
                ((KoocanRecyclerView) this.f11112a.x3(R$id.mRecyclerChannel)).scrollToPosition(num.intValue());
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return h9.t.f17319a;
        }
    }

    public static final class j extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11114a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(String str) {
            super(1);
            this.f11114a = str;
        }

        /* renamed from: b */
        public final ObservableSource invoke(ArrayList arrayList) {
            t9.i.g(arrayList, "list");
            String str = this.f11114a;
            int i10 = 0;
            for (Object next : arrayList) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                if (t9.i.b(str, ((Channel) next).getChannelCode())) {
                    return Observable.just(Integer.valueOf(i10));
                }
                i10 = i11;
            }
            return Observable.just(-1);
        }
    }

    public static final class k extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11115a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(r1 r1Var) {
            super(1);
            this.f11115a = r1Var;
        }

        public final void b(Integer num) {
            if (num == null || num.intValue() != -1) {
                t9.i.f(num, "it");
                ((KoocanRecyclerView) this.f11115a.x3(R$id.mRecyclerChannel)).scrollToPosition(num.intValue());
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return h9.t.f17319a;
        }
    }

    public static final class l implements j.d {
        public void a() {
        }

        public void b() {
        }
    }

    public static final class m extends b8.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r1 f11116e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(r1 r1Var, androidx.fragment.app.e eVar) {
            super(eVar);
            this.f11116e = r1Var;
        }

        public void f(int i10) {
            if (i10 == 0) {
                r1 r1Var = this.f11116e;
                int i11 = R$id.mIconSilence;
                ((ImageView) r1Var.x3(i11)).setTag(Boolean.TRUE);
                ((ImageView) this.f11116e.x3(i11)).setImageResource(R.drawable.ic_live_volume_off);
            } else {
                r1 r1Var2 = this.f11116e;
                int i12 = R$id.mIconSilence;
                if (t9.i.b(((ImageView) r1Var2.x3(i12)).getTag(), Boolean.TRUE)) {
                    ((ImageView) this.f11116e.x3(i12)).setTag(Boolean.FALSE);
                    ((ImageView) this.f11116e.x3(i12)).setImageResource(R.drawable.ic_live_volume_on);
                }
            }
            if (((AutoHideRelativeLayout) this.f11116e.x3(R$id.mLiveControlPanelLandscape)).getVisibility() == 0) {
                ((ProgressBar) this.f11116e.x3(R$id.mPbVolume)).setProgress((i10 * 100) / this.f11116e.p4().e());
            }
        }
    }

    public static final class n extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11117a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f11118b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(r1 r1Var, int i10) {
            super(1);
            this.f11117a = r1Var;
            this.f11118b = i10;
        }

        public final void b(GetLiveDataResult getLiveDataResult) {
            GetLiveData data = getLiveDataResult.getData();
            t9.i.d(data);
            if (!TextUtils.isEmpty(data.getDataVersion())) {
                n0 n0Var = n0.f12601a;
                Context context = this.f11117a.getContext();
                t9.i.d(context);
                GetLiveData data2 = getLiveDataResult.getData();
                t9.i.d(data2);
                n0Var.j(context, "DATA_VERSION" + this.f11118b, data2.getDataVersion());
            }
            GetLiveData data3 = getLiveDataResult.getData();
            t9.i.d(data3);
            if (!TextUtils.isEmpty(data3.getExpireTimeStr())) {
                n0 n0Var2 = n0.f12601a;
                Context context2 = this.f11117a.getContext();
                t9.i.d(context2);
                GetLiveData data4 = getLiveDataResult.getData();
                t9.i.d(data4);
                n0Var2.j(context2, "EXPIRE_TIME" + this.f11118b, data4.getExpireTimeStr());
            }
            String json = new Gson().toJson((Object) getLiveDataResult);
            if (!TextUtils.isEmpty(json)) {
                na.f.m(this.f11117a.getContext(), String.valueOf(this.f11118b), String.valueOf(this.f11118b), json);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((GetLiveDataResult) obj);
            return h9.t.f17319a;
        }
    }

    public static final class o extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11119a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f11120b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ r1 f11121a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f11122b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ t9.w f11123c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(r1 r1Var, int i10, t9.w wVar) {
                super(1);
                this.f11121a = r1Var;
                this.f11122b = i10;
                this.f11123c = wVar;
            }

            public final void b(GetLiveData getLiveData) {
                this.f11121a.Z4(getLiveData.getChannelList(), this.f11122b);
                Disposable disposable = (Disposable) this.f11123c.f19600a;
                if (disposable != null) {
                    disposable.dispose();
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                b((GetLiveData) obj);
                return h9.t.f17319a;
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public static final b f11124a = new b();

            public b() {
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

        public static final class c extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f11125a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(String str) {
                super(1);
                this.f11125a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f12639a;
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f11125a, yVar.f(), (String) null, 4, (Object) null));
            }
        }

        public static final class d extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ t9.w f11126a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(t9.w wVar) {
                super(1);
                this.f11126a = wVar;
            }

            public final void b(Disposable disposable) {
                this.f11126a.f19600a = disposable;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                b((Disposable) obj);
                return h9.t.f17319a;
            }
        }

        public o(r1 r1Var, int i10) {
            this.f11119a = r1Var;
            this.f11120b = i10;
        }

        public static final void l(String str, r1 r1Var, int i10, ObservableEmitter observableEmitter) {
            t9.i.g(str, "$returnCode");
            t9.i.g(r1Var, "this$0");
            t9.i.g(observableEmitter, "it");
            if (t9.i.b(str, "304")) {
                String h10 = na.f.h(r1Var.getContext(), String.valueOf(i10), String.valueOf(i10));
                if (!TextUtils.isEmpty(h10)) {
                    GetLiveDataResult getLiveDataResult = (GetLiveDataResult) new Gson().fromJson(h10, GetLiveDataResult.class);
                    if (getLiveDataResult.getData() != null) {
                        GetLiveData data = getLiveDataResult.getData();
                        t9.i.d(data);
                        observableEmitter.onNext(data);
                    }
                } else {
                    n0 n0Var = n0.f12601a;
                    Context context = r1Var.getContext();
                    t9.i.d(context);
                    n0Var.k(context, new String[]{"DATA_VERSION" + i10, "EXPIRE_TIME" + i10}, new String[]{"", ""});
                }
            }
            observableEmitter.onComplete();
        }

        public static final void m(s9.l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void n(s9.l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void o(r1 r1Var, String str) {
            t9.i.g(r1Var, "this$0");
            t9.i.g(str, "$returnCode");
            com.mobile.brasiltv.utils.x xVar = com.mobile.brasiltv.utils.x.f12622a;
            Context context = r1Var.getContext();
            t9.i.d(context);
            xVar.w(context, new c(str));
            r1Var.Y4();
        }

        public static final void p(s9.l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        /* renamed from: k */
        public void onNext(GetLiveDataResult getLiveDataResult) {
            t9.i.g(getLiveDataResult, "it");
            if (getLiveDataResult.getData() != null) {
                GetLiveData data = getLiveDataResult.getData();
                t9.i.d(data);
                if (com.mobile.brasiltv.utils.b0.I(data.getChannelList())) {
                    r1 r1Var = this.f11119a;
                    GetLiveData data2 = getLiveDataResult.getData();
                    t9.i.d(data2);
                    r1Var.Z4(data2.getChannelList(), this.f11120b);
                    return;
                }
            }
            this.f11119a.Y4();
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            t9.w wVar = new t9.w();
            Observable.create(new w1(str, this.f11119a, this.f11120b)).compose(p0.b()).subscribe(new x1(new a(this.f11119a, this.f11120b, wVar)), new y1(b.f11124a), new z1(this.f11119a, str), new a2(new d(wVar)));
        }
    }

    public static final class p extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11127a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(r1 r1Var) {
            super(1);
            this.f11127a = r1Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Long l10) {
            ((AutoFrameLayout) this.f11127a.x3(R$id.mFlLocked)).setVisibility(8);
        }
    }

    public static final class q extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final q f11128a = new q();

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
        public static final r f11129a = new r();

        public r() {
            super(0);
        }

        /* renamed from: b */
        public final u6.b invoke() {
            return new u6.b();
        }
    }

    public static final class s implements RecyclerView.s {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11130a;

        public s(r1 r1Var) {
            this.f11130a = r1Var;
        }

        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            t9.i.g(recyclerView, "rv");
            t9.i.g(motionEvent, "event");
            if (motionEvent.getAction() == 0) {
                this.f11130a.f4487u = true;
                Disposable B3 = this.f11130a.f4485s;
                if (B3 != null) {
                    B3.dispose();
                }
            } else if (motionEvent.getAction() == 1) {
                this.f11130a.f4487u = false;
                this.f11130a.f4();
            }
            return false;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z10) {
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            t9.i.g(recyclerView, "rv");
            t9.i.g(motionEvent, "e");
        }
    }

    public static final class t extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final t f11131a = new t();

        public t() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "intent");
            Intent putExtra = intent.putExtra("from_type", "LIVE");
            t9.i.f(putExtra, "intent.putExtra(Constant… Constant.FROM_TYPE_LIVE)");
            return putExtra;
        }
    }

    public static final class u extends ha.a {
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }
    }

    public static final class v implements GestureDetector.OnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11132a;

        public v(r1 r1Var) {
            this.f11132a = r1Var;
        }

        public boolean onDown(MotionEvent motionEvent) {
            t9.i.g(motionEvent, "e");
            this.f11132a.f4473j0 = TitanPlayerController.b.NONE;
            this.f11132a.f4475k0 = Float.valueOf(motionEvent.getRawY());
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
            if (this.f11132a.f4488v || !this.f11132a.J4() || ((AnimatorFrameLayout) this.f11132a.x3(R$id.mLayoutChannelList)).getVisibility() == 0) {
                return false;
            }
            return this.f11132a.B4(motionEvent, motionEvent2, f10, f11);
        }

        public void onShowPress(MotionEvent motionEvent) {
            t9.i.g(motionEvent, "e");
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            t9.i.g(motionEvent, "e");
            return false;
        }
    }

    public static final class w extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final w f11133a = new w();

        public w() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "intent");
            Intent putExtra = intent.putExtra("from_type", "LIVE");
            t9.i.f(putExtra, "intent.putExtra(Constant… Constant.FROM_TYPE_LIVE)");
            return putExtra;
        }
    }

    public static final class x extends OnItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11134a;

        public x(r1 r1Var) {
            this.f11134a = r1Var;
        }

        public void onSimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
            t9.i.g(baseQuickAdapter, "adapter");
            Object item = baseQuickAdapter.getItem(i10);
            t9.i.e(item, "null cannot be cast to non-null type kotlin.String");
            r1.D4(this.f11134a, (String) item, i10, false, 4, (Object) null);
        }
    }

    public static final class y extends OnItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11135a;

        public y(r1 r1Var) {
            this.f11135a = r1Var;
        }

        public void onSimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
            t9.i.g(baseQuickAdapter, "adapter");
            t9.i.g(view, "view");
            Object item = baseQuickAdapter.getItem(i10);
            t9.i.e(item, "null cannot be cast to non-null type mobile.com.requestframe.utils.response.Channel");
            Channel channel = (Channel) item;
            z.a aVar = z.f4508u;
            if (aVar.b().get(channel.getChannelCode()) != null) {
                Object obj = aVar.b().get(channel.getChannelCode());
                t9.i.d(obj);
                channel = (Channel) obj;
            }
            r1.u4(this.f11135a, channel, i10, false, 4, (Object) null);
        }
    }

    public static final class z extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r1 f11136a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z(r1 r1Var) {
            super(1);
            this.f11136a = r1Var;
        }

        public final void b(CommTipsDialog commTipsDialog) {
            boolean z10;
            t9.i.g(commTipsDialog, "it");
            commTipsDialog.dismiss();
            if (d6.b.f6366a.y()) {
                com.mobile.brasiltv.utils.b0.a0(this.f11136a, AccountBindAty.class);
                return;
            }
            i.c cVar = w6.i.f9510g;
            if (cVar.g().length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                com.mobile.brasiltv.utils.b0.k0(this.f11136a, cVar.g(), false, true, false, 8, (Object) null);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((CommTipsDialog) obj);
            return h9.t.f17319a;
        }
    }

    public static final void A5(r1 r1Var) {
        r1 r1Var2 = r1Var;
        t9.i.g(r1Var2, "this$0");
        String string = r1Var2.getString(R.string.guide_live_feedback);
        t9.i.f(string, "getString(R.string.guide_live_feedback)");
        GuideDialog.Direction direction = GuideDialog.Direction.TOP_RIGHT;
        LiveFeedBackGuideManager liveFeedBackGuideManager = new LiveFeedBackGuideManager(r1Var.getContext(), (ImageView) r1Var2.x3(R$id.mImageLandFeedback), "keyFirstPlayLIVE", string, direction);
        int i10 = R$id.mIconSave;
        if (((ImageView) r1Var2.x3(i10)).getVisibility() == 0) {
            String string2 = r1Var2.getString(R.string.guide_live_fav);
            t9.i.f(string2, "getString(R.string.guide_live_fav)");
            liveFeedBackGuideManager.addNextRecursion(new BaseGuideManager(r1Var.getContext(), (ImageView) r1Var2.x3(i10), "keyFirstViewEPG", string2, direction, (String) null, false, true, (String) null, 352, (t9.g) null));
        }
        BaseGuideManager findFirstShow = liveFeedBackGuideManager.findFirstShow();
        if (findFirstShow != null) {
            int i11 = R$id.mLiveControlPanelLandscape;
            if (((AutoHideRelativeLayout) r1Var2.x3(i11)).getVisibility() == 8) {
                ((AutoHideRelativeLayout) r1Var2.x3(i11)).setVisibility(0);
            }
            ((AutoHideRelativeLayout) r1Var2.x3(i11)).cancelDelayHide();
            q5.j jVar = f4462o0;
            if (jVar != null) {
                jVar.t();
            }
            findFirstShow.setGuideNextClickListener(new e0(r1Var2));
            findFirstShow.showGuide();
        }
    }

    public static final void B5(r1 r1Var) {
        t9.i.g(r1Var, "this$0");
        r1Var.T4(false, false);
    }

    public static /* synthetic */ void D4(r1 r1Var, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        r1Var.C4(str, i10, z10);
    }

    public static final void F5(r1 r1Var) {
        t9.i.g(r1Var, "this$0");
        Context context = r1Var.getContext();
        int i10 = R$id.mImageShare;
        String string = ((ImageView) r1Var.x3(i10)).getContext().getString(R.string.sharing_guide_tips);
        t9.i.f(string, "mImageShare.context.getS…tring.sharing_guide_tips)");
        new BaseGuideManager(context, (ImageView) r1Var.x3(i10), "keyLiveSharing", string, GuideDialog.Direction.TOP_RIGHT, (String) null, false, false, (String) null, 480, (t9.g) null).showGuide();
    }

    public static final boolean I5(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final void M4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static /* synthetic */ void N5(r1 r1Var, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = null;
        }
        r1Var.M5(bool);
    }

    public static final void O4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void P4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void Q3(r1 r1Var) {
        t9.i.g(r1Var, "this$0");
        if (com.mobile.brasiltv.utils.h.f12562a.o() || r1Var.K) {
            xa.c.c().j(new CastToPlayEvent("LIVE"));
        }
    }

    public static final void R3(r1 r1Var) {
        t9.i.g(r1Var, "this$0");
        if (com.mobile.brasiltv.utils.b0.K(r1Var.M) && r1Var.f4489w) {
            Integer num = r1Var.N;
            t9.i.d(num);
            int intValue = num.intValue();
            String str = r1Var.M;
            t9.i.d(str);
            r1Var.s5(intValue, str);
            r1Var.L = true;
        }
        if ((com.mobile.brasiltv.utils.h.f12562a.o() || r1Var.K) && !r1Var.L) {
            xa.c.c().j(new CastToPlayEvent("LIVE"));
        }
    }

    public static final void R4(r1 r1Var, DialogInterface dialogInterface) {
        t9.i.g(r1Var, "this$0");
        r1Var.f4483q = null;
    }

    public static final void S3(r1 r1Var) {
        t9.i.g(r1Var, "this$0");
        U3(r1Var, false, false, 2, (Object) null);
    }

    public static /* synthetic */ void U3(r1 r1Var, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        r1Var.T3(z10, z11);
    }

    public static final void U5(r1 r1Var, DialogInterface dialogInterface) {
        t9.i.g(r1Var, "this$0");
        r1Var.A = null;
    }

    public static /* synthetic */ String a4(r1 r1Var, Program program, o6.a aVar, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return r1Var.Z3(program, aVar, z10);
    }

    public static final void g4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void h4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean h5(r1 r1Var, GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        t9.i.g(r1Var, "this$0");
        t9.i.g(gestureDetector, "$mGestureDetector");
        t9.i.f(view, "v");
        t9.i.f(motionEvent, "event");
        return r1Var.S5(view, motionEvent, gestureDetector);
    }

    public static /* synthetic */ void k4(r1 r1Var, String str, ArrayList arrayList, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        r1Var.j4(str, arrayList, z10);
    }

    public static final void k5(View view) {
    }

    public static final ObservableSource l4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final void l5(r1 r1Var, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        t9.i.g(r1Var, "this$0");
        if (view.getId() == R.id.mFavWrapper) {
            Object item = baseQuickAdapter.getItem(i10);
            t9.i.e(item, "null cannot be cast to non-null type mobile.com.requestframe.utils.response.Channel");
            r1Var.v4((Channel) item, i10);
        }
    }

    public static final void m4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void m5(r1 r1Var, View view) {
        t9.i.g(r1Var, "this$0");
        Context context = r1Var.getContext();
        if (context != null) {
            com.mobile.brasiltv.utils.b0.l(context);
        }
    }

    public static final ObservableSource n4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final void n5(r1 r1Var, View view) {
        Program program;
        t9.i.g(r1Var, "this$0");
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        if (t9.i.b(hVar.a(), hVar.k())) {
            if (hVar.t()) {
                com.mobile.brasiltv.utils.g.f12519a.G();
            }
        } else if (t9.i.b(hVar.a(), hVar.l())) {
            r1Var.C.r();
            r1Var.C.s();
        }
        r1Var.F = "";
        xa.c.c().j(new CastToCloseFloatViewEvent());
        U3(r1Var, true, false, 2, (Object) null);
        int i10 = R$id.mVideoViewLive;
        n8.b titanContext = ((TitanVideoView) r1Var.x3(i10)).getTitanContext();
        if (titanContext != null) {
            program = titanContext.h();
        } else {
            program = null;
        }
        if (program != null) {
            ((TitanVideoView) r1Var.x3(i10)).D();
        }
        l6.g0 g0Var = r1Var.f4490x;
        if (g0Var == null) {
            t9.i.w("mLivePlayPresenter");
            g0Var = null;
        }
        f.a.a(g0Var, r1Var.f4474k, (String) null, 2, (Object) null);
    }

    public static final void o4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void o5(r1 r1Var, View view) {
        t9.i.g(r1Var, "this$0");
        xa.c.c().j(new CastToCloseOtherPlayEvent("LIVE", false, 2, (t9.g) null));
        Context context = r1Var.getContext();
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.d0((f5.c) context, CastByNativeDeviceAty.class, w.f11133a);
    }

    public static final void p5(r1 r1Var, View view) {
        t9.i.g(r1Var, "this$0");
        Context context = r1Var.getContext();
        t9.i.d(context);
        new CastFeedBackDialog(context).show();
    }

    public static /* synthetic */ void u4(r1 r1Var, Channel channel, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        r1Var.t4(channel, i10, z10);
    }

    public static /* synthetic */ void u5(r1 r1Var, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        r1Var.t5(z10, z11);
    }

    public final void A4(boolean z10) {
        this.f4489w = true;
        if (Q2()) {
            V2();
            T4(z10, true);
        }
    }

    public final boolean B4(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        MotionEvent motionEvent3 = motionEvent2;
        if (!(motionEvent == null || motionEvent3 == null)) {
            float rawX = motionEvent.getRawX();
            float rawX2 = motionEvent2.getRawX();
            float rawY = motionEvent.getRawY();
            float rawY2 = motionEvent2.getRawY();
            int i10 = R$id.mVideoViewLive;
            int width = ((TitanVideoView) x3(i10)).getWidth();
            ((TitanVideoView) x3(i10)).getHeight();
            if (this.f4473j0 == TitanPlayerController.b.NONE && Math.abs(rawX - rawX2) < Math.abs(rawY - rawY2)) {
                double d10 = (double) width;
                Double.isNaN(d10);
                if (((double) rawX) <= (d10 * 1.0d) / 2.0d) {
                    this.f4473j0 = TitanPlayerController.b.BRIGHTNESS;
                } else if (Math.abs(f11) > 3.0f) {
                    this.f4473j0 = TitanPlayerController.b.VOLUME;
                }
            }
            int i11 = b.f11092a[this.f4473j0.ordinal()];
            if (i11 == 1) {
                double d11 = (double) width;
                Double.isNaN(d11);
                if (((double) rawX) > (d11 * 1.0d) / 2.0d) {
                    S4(motionEvent3);
                }
            } else if (i11 == 2) {
                double d12 = (double) width;
                Double.isNaN(d12);
                if (((double) rawX) <= (d12 * 1.0d) / 2.0d) {
                    Q4(f11 / ((float) AutoUtils.getPercentHeightSize(280)));
                }
            }
        }
        return true;
    }

    public void C0(Channel channel, Program program) {
        Program program2;
        TitanVideoView titanVideoView;
        TitanVideoView titanVideoView2;
        t9.i.g(channel, "channel");
        t9.i.g(program, "program");
        l6.g0 g0Var = this.f4490x;
        Program program3 = null;
        if (g0Var == null) {
            t9.i.w("mLivePlayPresenter");
            g0Var = null;
        }
        String a42 = a4(this, program, g0Var.v(), false, 4, (Object) null);
        if (com.mobile.brasiltv.utils.b0.H(a42)) {
            t9.i.d(a42);
            program.setMedia(a42);
            this.J = program;
            if (!com.mobile.brasiltv.utils.h.f12562a.o()) {
                U3(this, true, false, 2, (Object) null);
                ((TitanVideoView) x3(R$id.mVideoViewLive)).B(program, channel.getChannelCode(), program.getBuss());
                D5(0);
                x5(true);
                return;
            }
            U3(this, false, false, 2, (Object) null);
            int i10 = R$id.mVideoViewLive;
            n8.b titanContext = ((TitanVideoView) x3(i10)).getTitanContext();
            if (titanContext != null) {
                program2 = titanContext.h();
            } else {
                program2 = null;
            }
            if (!(program2 == null || (titanVideoView2 = (TitanVideoView) x3(i10)) == null)) {
                titanVideoView2.D();
            }
            n8.b titanContext2 = ((TitanVideoView) x3(i10)).getTitanContext();
            if (titanContext2 != null) {
                program3 = titanContext2.a();
            }
            if (!(program3 == null || (titanVideoView = (TitanVideoView) x3(i10)) == null)) {
                titanVideoView.C();
            }
            Program program4 = this.J;
            t9.i.d(program4);
            ((TitanVideoView) x3(i10)).v(program4, program.getBuss());
            this.O = false;
        }
    }

    public void C1() {
    }

    /* JADX WARNING: type inference failed for: r8v14, types: [g5.j0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void C4(java.lang.String r7, int r8, boolean r9) {
        /*
            r6 = this;
            r6.f4()
            b6.z$a r7 = b6.z.f4508u
            java.lang.String r0 = r7.f()
            if (r0 != 0) goto L_0x000d
            java.lang.String r0 = ""
        L_0x000d:
            java.lang.String r1 = "adapterSort"
            r2 = 0
            r3 = 0
            if (r8 != 0) goto L_0x0029
            r7 = -1
            r6.f4470i = r7
            r6.f4468h = r2
            g5.o0 r7 = r6.f4480n
            if (r7 != 0) goto L_0x0020
            t9.i.w(r1)
            goto L_0x0021
        L_0x0020:
            r3 = r7
        L_0x0021:
            r3.b(r2)
            r6.R5()
            goto L_0x00f1
        L_0x0029:
            int r4 = r8 + -1
            java.util.ArrayList r5 = r6.f4464f
            int r5 = r5.size()
            if (r4 < r5) goto L_0x0034
            return
        L_0x0034:
            java.util.ArrayList r5 = r6.f4464f
            java.lang.Object r4 = r5.get(r4)
            java.lang.String r5 = "allColumnIdList[position - 1]"
            t9.i.f(r4, r5)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            int r5 = r6.f4470i
            if (r4 == r5) goto L_0x00ee
            r6.f4470i = r4
            r6.f4468h = r8
            g5.o0 r5 = r6.f4480n
            if (r5 != 0) goto L_0x0055
            t9.i.w(r1)
            r5 = r3
        L_0x0055:
            r5.b(r8)
            g5.j0 r8 = r6.f4478m
            java.lang.String r1 = "adapterChannel"
            if (r8 != 0) goto L_0x0062
            t9.i.w(r1)
            r8 = r3
        L_0x0062:
            r8.d(r2)
            g5.j0 r8 = r6.f4478m
            if (r8 != 0) goto L_0x006d
            t9.i.w(r1)
            r8 = r3
        L_0x006d:
            java.util.List r8 = r8.getData()
            r8.clear()
            g5.j0 r8 = r6.f4478m
            if (r8 != 0) goto L_0x007c
            t9.i.w(r1)
            r8 = r3
        L_0x007c:
            r8.notifyDataSetChanged()
            mobile.com.requestframe.utils.response.ChildColumnList r8 = r7.a()
            if (r8 == 0) goto L_0x008c
            int r8 = r8.getId()
            if (r4 != r8) goto L_0x008c
            r2 = 1
        L_0x008c:
            if (r2 == 0) goto L_0x009b
            boolean r8 = r6.c4()
            if (r8 == 0) goto L_0x009a
            boolean r8 = r6.T5()
            if (r8 != 0) goto L_0x009b
        L_0x009a:
            return
        L_0x009b:
            android.util.SparseArray r8 = r7.g()
            int r8 = r8.indexOfKey(r4)
            if (r8 < 0) goto L_0x00ea
            g5.j0 r8 = r6.f4478m
            if (r8 != 0) goto L_0x00ad
            t9.i.w(r1)
            r8 = r3
        L_0x00ad:
            java.util.List r8 = r8.getData()
            android.util.SparseArray r2 = r7.g()
            java.lang.Object r2 = r2.get(r4)
            t9.i.d(r2)
            java.util.Collection r2 = (java.util.Collection) r2
            r8.addAll(r2)
            g5.j0 r8 = r6.f4478m
            if (r8 != 0) goto L_0x00c9
            t9.i.w(r1)
            goto L_0x00ca
        L_0x00c9:
            r3 = r8
        L_0x00ca:
            r3.notifyDataSetChanged()
            java.util.ArrayList r8 = r6.f4472j
            r8.clear()
            java.util.ArrayList r8 = r6.f4472j
            android.util.SparseArray r7 = r7.g()
            java.lang.Object r7 = r7.get(r4)
            t9.i.d(r7)
            java.util.Collection r7 = (java.util.Collection) r7
            r8.addAll(r7)
            java.util.ArrayList r7 = r6.f4472j
            r6.j4(r0, r7, r9)
            goto L_0x00f1
        L_0x00ea:
            r6.L4(r4)
            goto L_0x00f1
        L_0x00ee:
            r6.i4(r0)
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.r1.C4(java.lang.String, int, boolean):void");
    }

    public final void C5() {
        if (this.f4484r) {
            if (((AnimatorFrameLayout) x3(R$id.mLayoutChannelList)).getVisibility() == 0) {
                F4();
                return;
            }
            int i10 = R$id.mLiveControlPanelLandscape;
            if (t9.i.b(((AutoHideRelativeLayout) x3(i10)).getTag(), Boolean.TRUE)) {
                ((AutoHideRelativeLayout) x3(i10)).setTag(Boolean.FALSE);
                ((AutoHideRelativeLayout) x3(i10)).delayHide();
            } else if (((AutoHideRelativeLayout) x3(i10)).getVisibility() == 0) {
                ((AutoHideRelativeLayout) x3(i10)).setVisibility(8);
            } else {
                ((AutoHideRelativeLayout) x3(i10)).setVisibility(0);
                d5();
                e5();
            }
        } else if (!Y3()) {
            ((AutoHideRelativeLayout) x3(R$id.mLiveControlPanelPortrait)).setVisibility(8);
        } else {
            int i11 = R$id.mLiveControlPanelPortrait;
            if (((AutoHideRelativeLayout) x3(i11)).getVisibility() == 0) {
                ((AutoHideRelativeLayout) x3(i11)).setVisibility(8);
            } else {
                ((AutoHideRelativeLayout) x3(i11)).setVisibility(0);
            }
        }
    }

    public final void D5(int i10) {
        String str;
        String str2;
        if (s6.a.f9335a.a().s()) {
            int i11 = R$id.mIvPortQuality;
            ((ImageView) x3(i11)).setVisibility(i10);
            ((AutoLinearLayout) x3(R$id.mLlQuality)).setVisibility(i10);
            if (i10 == 0) {
                l6.g0 g0Var = this.f4490x;
                String str3 = null;
                if (g0Var == null) {
                    t9.i.w("mLivePlayPresenter");
                    g0Var = null;
                }
                o6.a v10 = g0Var.v();
                if (v10 != null) {
                    str = v10.c();
                } else {
                    str = null;
                }
                if (t9.i.b(str, o6.c.c().c())) {
                    ((ImageView) x3(i11)).setImageResource(R.drawable.ic_quality_480p_portrait);
                    ((ImageView) x3(R$id.mIvLandQuality)).setImageResource(R.drawable.ic_quality_480p);
                    return;
                }
                l6.g0 g0Var2 = this.f4490x;
                if (g0Var2 == null) {
                    t9.i.w("mLivePlayPresenter");
                    g0Var2 = null;
                }
                o6.a v11 = g0Var2.v();
                if (v11 != null) {
                    str2 = v11.c();
                } else {
                    str2 = null;
                }
                if (t9.i.b(str2, o6.c.b().c())) {
                    ((ImageView) x3(i11)).setImageResource(R.drawable.ic_quality_720p_portrait);
                    ((ImageView) x3(R$id.mIvLandQuality)).setImageResource(R.drawable.ic_quality_720p);
                    return;
                }
                l6.g0 g0Var3 = this.f4490x;
                if (g0Var3 == null) {
                    t9.i.w("mLivePlayPresenter");
                    g0Var3 = null;
                }
                o6.a v12 = g0Var3.v();
                if (v12 != null) {
                    str3 = v12.c();
                }
                if (t9.i.b(str3, o6.c.a().c())) {
                    ((ImageView) x3(i11)).setImageResource(R.drawable.ic_quality_1080p_portrait);
                    ((ImageView) x3(R$id.mIvLandQuality)).setImageResource(R.drawable.ic_quality_1080p);
                }
            }
        }
    }

    public final void E4() {
        View view;
        Window window;
        androidx.fragment.app.e activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            view = null;
        } else {
            view = window.getDecorView();
        }
        if (view != null) {
            view.setSystemUiVisibility(q.a.f14394g);
        }
    }

    public final void E5() {
        q5.j jVar = f4462o0;
        boolean z10 = false;
        if (jVar != null && jVar.n()) {
            z10 = true;
        }
        if (z10 && !this.f4484r) {
            int i10 = R$id.mImageShare;
            if (((ImageView) x3(i10)).getVisibility() == 0) {
                ((ImageView) x3(i10)).post(new s0(this));
            }
        }
    }

    public void F1() {
    }

    public final void F4() {
        ((AnimatorFrameLayout) x3(R$id.mLayoutChannelList)).setVisibility(8);
        Disposable disposable = this.f4485s;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void G0(long j10) {
    }

    public final void G4() {
    }

    public final void G5() {
        AudioManager audioManager = this.f4481o;
        AudioManager audioManager2 = null;
        if (audioManager == null) {
            t9.i.w("manager");
            audioManager = null;
        }
        if (audioManager.getStreamVolume(3) != 0) {
            int i10 = R$id.mIconSilence;
            ((ImageView) x3(i10)).setTag(Boolean.TRUE);
            ((ImageView) x3(i10)).setImageResource(R.drawable.ic_live_volume_off);
            AudioManager audioManager3 = this.f4481o;
            if (audioManager3 == null) {
                t9.i.w("manager");
                audioManager3 = null;
            }
            this.f4482p = audioManager3.getStreamVolume(3);
            AudioManager audioManager4 = this.f4481o;
            if (audioManager4 == null) {
                t9.i.w("manager");
            } else {
                audioManager2 = audioManager4;
            }
            audioManager2.setStreamVolume(3, 0, 16);
            return;
        }
        int i11 = R$id.mIconSilence;
        ((ImageView) x3(i11)).setTag(Boolean.FALSE);
        ((ImageView) x3(i11)).setImageResource(R.drawable.ic_live_volume_on);
        AudioManager audioManager5 = this.f4481o;
        if (audioManager5 == null) {
            t9.i.w("manager");
        } else {
            audioManager2 = audioManager5;
        }
        audioManager2.setStreamVolume(3, this.f4482p, 0);
    }

    public void H1() {
    }

    public void H2() {
    }

    public final void H4() {
        q5.j jVar = f4462o0;
        boolean z10 = false;
        if (jVar != null && jVar.i()) {
            z10 = true;
        }
        if (z10) {
            N5(this, (Boolean) null, 1, (Object) null);
        }
        androidx.fragment.app.e activity = getActivity();
        t9.i.d(activity);
        f4462o0 = new q5.j(activity, new l());
        androidx.fragment.app.e activity2 = getActivity();
        t9.i.d(activity2);
        i5(new m(this, activity2));
        p4().c();
    }

    public final void H5() {
        Disposable disposable;
        Disposable disposable2 = this.B;
        if (disposable2 != null) {
            t9.i.d(disposable2);
            if (!disposable2.isDisposed() && (disposable = this.B) != null) {
                disposable.dispose();
            }
        }
        Observable.intervalRange(0, 45, 0, 2, TimeUnit.SECONDS).filter(new a1(f0.f11107a)).compose(O2()).compose(p0.a()).subscribe(new g0(this));
    }

    public void I1(Bitmap bitmap) {
        t9.i.g(bitmap, "bitmap");
    }

    public final boolean I4() {
        if (((AutoLinearLayout) x3(R$id.llCastContainer)).getVisibility() == 0 || ((AutoLinearLayout) x3(R$id.llSwitchContainer)).getVisibility() == 0 || com.mobile.brasiltv.utils.h.f12562a.o()) {
            return true;
        }
        return false;
    }

    public final boolean J4() {
        return this.f4484r;
    }

    public final void J5() {
        q5.j jVar;
        if (((AutoLinearLayout) x3(R$id.llSwitchContainer)).getVisibility() != 0 && ((AutoLinearLayout) x3(R$id.llCastContainer)).getVisibility() != 0 && (jVar = f4462o0) != null) {
            jVar.e();
        }
    }

    public void K0() {
    }

    public final boolean K4() {
        return this.f4489w;
    }

    public final void K5() {
        String str;
        String str2;
        String str3;
        ((TitanVideoView) x3(R$id.mVideoViewLive)).D();
        l6.g0 g0Var = null;
        if (this.Y != 0) {
            Context context = getContext();
            Channel channel = this.f4474k;
            if (channel != null) {
                str3 = channel.getName();
            } else {
                str3 = null;
            }
            i1.A(context, str3, this.Y);
        }
        this.Y = 0;
        l6.g0 g0Var2 = this.f4490x;
        if (g0Var2 == null) {
            t9.i.w("mLivePlayPresenter");
        } else {
            g0Var = g0Var2;
        }
        if (g0Var.v() == null) {
            c2.d dVar = c2.d.f4594a;
            Channel channel2 = this.f4474k;
            if (channel2 == null || (str = channel2.getChannelCode()) == null) {
                str = "";
            }
            Channel channel3 = this.f4474k;
            if (channel3 == null || (str2 = channel3.getName()) == null) {
                str2 = "";
            }
            String str4 = na.e.f19076b;
            t9.i.f(str4, "dcsMark");
            dVar.g(str, str2, str4, com.mobile.brasiltv.utils.y.f12639a.h(), "", "EC21", AgooConstants.REPORT_MESSAGE_NULL, "apk");
            Context context2 = getContext();
            if (context2 != null) {
                com.mobile.brasiltv.utils.x.f12622a.w(context2, new h0(this));
            }
        } else if (r5.i.f19378a.I()) {
            O3();
        } else {
            H5();
        }
    }

    public void L0() {
    }

    public void L1(int i10) {
        x4(i10);
    }

    public final void L4(int i10) {
        w6.i b10 = w6.i.f9510g.b();
        n0 n0Var = n0.f12601a;
        Context context = getContext();
        t9.i.d(context);
        String f10 = n0.f(n0Var, context, "DATA_VERSION" + i10, (String) null, 4, (Object) null);
        Context context2 = getContext();
        t9.i.d(context2);
        b10.z1(i10, f10, n0.f(n0Var, context2, "EXPIRE_TIME" + i10, (String) null, 4, (Object) null)).compose(O2()).doOnNext(new u0(new n(this, i10))).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this, i10));
    }

    public final void L5() {
        boolean z10;
        boolean z11 = true;
        if (this.D.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
            if (hVar.a().length() <= 0) {
                z11 = false;
            }
            if (z11 && !t9.i.b(this.D, hVar.a())) {
                if (t9.i.b(this.D, hVar.k())) {
                    com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f12519a;
                    gVar.w((g.b) null);
                    if (hVar.t()) {
                        gVar.G();
                    }
                } else if (t9.i.b(this.D, hVar.l())) {
                    this.C.s();
                    this.C.o();
                    this.C.r();
                }
            }
        }
    }

    public final void M5(Boolean bool) {
        q5.j jVar = f4462o0;
        if (jVar != null) {
            if (t9.i.b(bool, Boolean.TRUE) && !jVar.l()) {
                jVar.s();
            } else if (t9.i.b(bool, Boolean.FALSE) && !jVar.n()) {
                jVar.u();
            }
        }
        q5.j jVar2 = f4462o0;
        if (jVar2 != null) {
            jVar2.b();
        }
    }

    public void N1(long j10, long j11) {
        int i10 = R$id.mTvCastState;
        Context context = getContext();
        t9.i.d(context);
        ((TextView) x3(i10)).setText(context.getResources().getString(R.string.cast_status_casting));
        Context context2 = getContext();
        t9.i.d(context2);
        ((TextView) x3(i10)).setTextColor(context2.getResources().getColor(R.color.color_fffefe));
        ((TextView) x3(R$id.mTvPleaseWait)).setVisibility(8);
    }

    public final void N4() {
        Disposable disposable = this.f4486t;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f4486t = Observable.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new g1(new p(this)), new h1(q.f11128a));
    }

    public void O1() {
    }

    public final void O3() {
        l6.g0 g0Var = this.f4490x;
        if (g0Var == null) {
            t9.i.w("mLivePlayPresenter");
            g0Var = null;
        }
        f.a.a(g0Var, this.f4474k, (String) null, 2, (Object) null);
    }

    public final void O5() {
        if (((AutoLinearLayout) x3(R$id.llCastContainer)).getVisibility() == 0 || ((AutoLinearLayout) x3(R$id.llSwitchContainer)).getVisibility() == 0 || com.mobile.brasiltv.utils.h.f12562a.o()) {
            ((TitanVideoView) x3(R$id.mVideoViewLive)).D();
        }
    }

    public final String P3(String str) {
        return this.F + "&cast=" + str;
    }

    public final void P5() {
        TitanVideoView titanVideoView;
        String str;
        if (this.Y != 0) {
            Context context = getContext();
            Channel channel = this.f4474k;
            if (channel != null) {
                str = channel.getName();
            } else {
                str = null;
            }
            i1.A(context, str, this.Y);
        }
        if (!I4() && (titanVideoView = (TitanVideoView) x3(R$id.mVideoViewLive)) != null) {
            titanVideoView.D();
        }
    }

    public final void Q4(float f10) {
        int i10 = R$id.mLiveControlPanelLandscape;
        if (((AutoHideRelativeLayout) x3(i10)).getVisibility() == 8) {
            ((AutoHideRelativeLayout) x3(i10)).setVisibility(0);
            d5();
            e5();
        }
        ((AutoHideRelativeLayout) x3(i10)).setTag(Boolean.TRUE);
        ((AutoHideRelativeLayout) x3(i10)).delayHide();
        androidx.fragment.app.e activity = getActivity();
        t9.i.d(activity);
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        float r42 = r4() + f10;
        if (r42 > 1.0f) {
            r42 = 1.0f;
        } else if (r42 < 0.0f) {
            r42 = 0.0f;
        }
        MainAty.A.l(r42);
        attributes.screenBrightness = r42;
        androidx.fragment.app.e activity2 = getActivity();
        t9.i.d(activity2);
        activity2.getWindow().setAttributes(attributes);
        ((ProgressBar) x3(R$id.mPbBrightness)).setProgress((int) (r42 * ((float) 100)));
    }

    public final void Q5() {
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
        if (com.mobile.brasiltv.utils.b0.K(this.F)) {
            xa.c.c().j(new CastToCloseOtherPlayEvent("LIVE", false));
            com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
            if (t9.i.b(hVar.a(), hVar.k())) {
                Program program = this.J;
                if (program == null || (medias = program.getMedias()) == null) {
                    media = null;
                } else {
                    media = medias.get(0);
                }
                if (this.Q) {
                    str = P3("dlna");
                } else {
                    str = this.F;
                }
                String str13 = str;
                com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f12519a;
                Program program2 = this.J;
                if (program2 == null || (str2 = program2.getMedia()) == null) {
                    str2 = "";
                }
                Program program3 = this.J;
                if (program3 == null || (str3 = program3.getName()) == null) {
                    str3 = "";
                }
                Program program4 = this.J;
                if (program4 == null || (str4 = program4.getTitle()) == null) {
                    str4 = "";
                }
                Program program5 = this.J;
                if (program5 == null || (str5 = program5.getEpisode()) == null) {
                    str5 = "";
                }
                Program program6 = this.J;
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
                Program program7 = this.J;
                if (program7 == null || (buss = program7.getBuss()) == null) {
                    str11 = "";
                } else {
                    str11 = buss;
                }
                String str14 = this.S;
                if (str14 == null) {
                    str12 = "";
                } else {
                    str12 = str14;
                }
                gVar.E(str13, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, 0, str12, this.Q);
                U3(this, false, false, 2, (Object) null);
            }
        }
    }

    public final void R5() {
        l6.g0 g0Var = this.f4490x;
        j0 j0Var = null;
        if (g0Var == null) {
            t9.i.w("mLivePlayPresenter");
            g0Var = null;
        }
        ArrayList u10 = g0Var.u();
        j0 j0Var2 = this.f4478m;
        if (j0Var2 == null) {
            t9.i.w("adapterChannel");
            j0Var2 = null;
        }
        j0Var2.d(true);
        j0 j0Var3 = this.f4478m;
        if (j0Var3 == null) {
            t9.i.w("adapterChannel");
            j0Var3 = null;
        }
        j0Var3.getData().clear();
        j0 j0Var4 = this.f4478m;
        if (j0Var4 == null) {
            t9.i.w("adapterChannel");
            j0Var4 = null;
        }
        j0Var4.getData().addAll(u10);
        j0 j0Var5 = this.f4478m;
        if (j0Var5 == null) {
            t9.i.w("adapterChannel");
        } else {
            j0Var = j0Var5;
        }
        j0Var.notifyDataSetChanged();
        this.f4472j.clear();
        this.f4472j.addAll(u10);
        String f10 = z.f4508u.f();
        if (f10 == null) {
            f10 = "";
        }
        k4(this, f10, this.f4472j, false, 4, (Object) null);
    }

    public final void S4(MotionEvent motionEvent) {
        int i10 = R$id.mLiveControlPanelLandscape;
        int i11 = 0;
        if (((AutoHideRelativeLayout) x3(i10)).getVisibility() == 8) {
            ((AutoHideRelativeLayout) x3(i10)).setVisibility(0);
            d5();
            e5();
        }
        ((AutoHideRelativeLayout) x3(i10)).setTag(Boolean.TRUE);
        ((AutoHideRelativeLayout) x3(i10)).delayHide();
        Float f10 = this.f4475k0;
        if (f10 == null) {
            this.f4475k0 = Float.valueOf(motionEvent.getRawY());
            return;
        }
        t9.i.d(f10);
        float e10 = ((float) p4().e()) * ((f10.floatValue() - motionEvent.getRawY()) / ((float) AutoUtils.getPercentHeightSize(280)));
        float d10 = ((float) p4().d()) + e10;
        int d11 = p4().d() + ((int) e10);
        if (d11 > p4().e()) {
            i11 = p4().e();
        } else if (d11 >= 0) {
            i11 = d11;
        }
        if (d10 > ((float) p4().e())) {
            d10 = (float) p4().e();
        } else if (d10 < 0.0f) {
            d10 = 0.0f;
        }
        if (Math.abs(e10) >= 1.0f) {
            this.f4475k0 = Float.valueOf(motionEvent.getRawY());
            p4().g(i11);
        }
        ((ProgressBar) x3(R$id.mPbVolume)).setProgress((int) ((((float) 100) * d10) / ((float) p4().e())));
    }

    public final boolean S5(View view, MotionEvent motionEvent, GestureDetector gestureDetector) {
        if (this.f4488v) {
            return false;
        }
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public void T2() {
    }

    public final void T3(boolean z10, boolean z11) {
        String str;
        String str2;
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        boolean b10 = t9.i.b(hVar.a(), hVar.k());
        if (z11) {
            ((TextView) x3(R$id.mTvCastErrorHint)).setVisibility(8);
            ((AutoLinearLayout) x3(R$id.llCastContainer)).setVisibility(8);
            ((AutoHideRelativeLayout) x3(R$id.mLiveControlPanelPortrait)).setVisibility(8);
            q5.j jVar = f4462o0;
            if (jVar != null) {
                jVar.c();
            }
            int i10 = R$id.llSwitchContainer;
            Context context = getContext();
            t9.i.d(context);
            ((AutoLinearLayout) x3(i10)).setBackgroundColor(context.getResources().getColor(R.color.color_1a1a1a));
            this.D = hVar.a();
            if (!b10) {
                ((AutoLinearLayout) x3(i10)).setVisibility(0);
                Context context2 = getContext();
                t9.i.d(context2);
                ((TextView) x3(R$id.mTvSwitchTips)).setText(context2.getResources().getString(R.string.cast_content_not_support_google));
                return;
            }
            Q5();
            return;
        }
        String str3 = null;
        if (z10) {
            ((TextView) x3(R$id.mTvCastErrorHint)).setVisibility(8);
            ((AutoLinearLayout) x3(R$id.llSwitchContainer)).setVisibility(8);
            ((AutoLinearLayout) x3(R$id.llCastContainer)).setVisibility(8);
            q5.j jVar2 = f4462o0;
            if (jVar2 != null) {
                jVar2.f();
            }
            if (!Y3()) {
                ((AutoHideRelativeLayout) x3(R$id.mLiveControlPanelPortrait)).setVisibility(8);
            } else if (this.f4484r) {
                ((AutoHideRelativeLayout) x3(R$id.mLiveControlPanelPortrait)).setVisibility(8);
            } else {
                ((AutoHideRelativeLayout) x3(R$id.mLiveControlPanelPortrait)).setVisibility(0);
            }
            if (b10) {
                com.mobile.brasiltv.utils.g.f12519a.w((g.b) null);
            } else {
                this.C.o();
            }
        } else {
            ((TextView) x3(R$id.mTvCastErrorHint)).setVisibility(8);
            ((AutoLinearLayout) x3(R$id.llSwitchContainer)).setVisibility(8);
            ((AutoLinearLayout) x3(R$id.llCastContainer)).setVisibility(0);
            ((AutoHideRelativeLayout) x3(R$id.mLiveControlPanelPortrait)).setVisibility(8);
            q5.j jVar3 = f4462o0;
            if (jVar3 != null) {
                jVar3.c();
            }
            int i11 = R$id.mTvCastState;
            Context context3 = getContext();
            t9.i.d(context3);
            ((TextView) x3(i11)).setText(context3.getResources().getString(R.string.cast_status_prepare));
            Context context4 = getContext();
            t9.i.d(context4);
            ((TextView) x3(i11)).setTextColor(context4.getResources().getColor(R.color.color_fffefe));
            ((TextView) x3(R$id.mTvPleaseWait)).setVisibility(0);
            ((TextView) x3(R$id.mTvCastRecommendHint)).setVisibility(4);
            c5();
            l6.g0 g0Var = this.f4490x;
            if (g0Var == null) {
                t9.i.w("mLivePlayPresenter");
                g0Var = null;
            }
            o6.a v10 = g0Var.v();
            if (v10 != null) {
                str = v10.c();
            } else {
                str = null;
            }
            if (t9.i.b(str, o6.c.c().c())) {
                ((ImageView) x3(R$id.mIvCastQuality)).setImageResource(R.mipmap.icon_cast_definition_480);
            } else {
                l6.g0 g0Var2 = this.f4490x;
                if (g0Var2 == null) {
                    t9.i.w("mLivePlayPresenter");
                    g0Var2 = null;
                }
                o6.a v11 = g0Var2.v();
                if (v11 != null) {
                    str2 = v11.c();
                } else {
                    str2 = null;
                }
                if (t9.i.b(str2, o6.c.b().c())) {
                    ((ImageView) x3(R$id.mIvCastQuality)).setImageResource(R.mipmap.icon_cast_definition_720);
                } else {
                    l6.g0 g0Var3 = this.f4490x;
                    if (g0Var3 == null) {
                        t9.i.w("mLivePlayPresenter");
                        g0Var3 = null;
                    }
                    o6.a v12 = g0Var3.v();
                    if (v12 != null) {
                        str3 = v12.c();
                    }
                    if (t9.i.b(str3, o6.c.a().c())) {
                        ((ImageView) x3(R$id.mIvCastQuality)).setImageResource(R.mipmap.icon_cast_definition_1080);
                    }
                }
            }
            if (b10) {
                com.mobile.brasiltv.utils.g.f12519a.w(this.f4477l0);
            } else {
                this.C.e(this);
            }
        }
    }

    public final boolean T4(boolean z10, boolean z11) {
        Channel channel;
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        if (!hVar.o() && !this.O) {
            T3(false, false);
        } else if (hVar.o() && hVar.s()) {
            return false;
        } else {
            if (!hVar.p()) {
                ((AutoLinearLayout) x3(R$id.llCastContainer)).setVisibility(8);
                ((RelativeLayout) x3(R$id.mBufferView)).setVisibility(0);
                if (!z10 && z11 && r5.i.f19378a.I() && (channel = this.f4474k) != null) {
                    t9.i.d(channel);
                    l6.g0 g0Var = this.f4490x;
                    if (g0Var == null) {
                        t9.i.w("mLivePlayPresenter");
                        g0Var = null;
                    }
                    W4(channel, g0Var.y());
                }
                return false;
            }
        }
        hVar.x(false);
        return false;
    }

    public final boolean T5() {
        if (!MainAty.A.f()) {
            return true;
        }
        if (this.A == null) {
            Context context = getContext();
            t9.i.d(context);
            g6.d dVar = new g6.d(context);
            this.A = dVar;
            dVar.setOnDismissListener(new f1(this));
        }
        g6.d dVar2 = this.A;
        if (dVar2 != null) {
            dVar2.h(true);
        }
        g6.d dVar3 = this.A;
        if (dVar3 == null) {
            return false;
        }
        dVar3.show();
        return false;
    }

    public void U() {
    }

    public void U2() {
        super.U2();
        M5(Boolean.FALSE);
        ((TitanVideoView) x3(R$id.mVideoViewLive)).setKeepScreenOn(false);
    }

    public final void U4() {
        Channel channel = this.W;
        if (channel == null) {
            f1.f12517a.w(R.string.live_no_previous);
        } else {
            t9.i.d(channel);
            if (!t9.i.b(channel.getRestricted(), "1") || !t9.i.b(w6.i.f9510g.A(), "0")) {
                D4(this, "", this.X + 1, false, 4, (Object) null);
                Channel channel2 = this.W;
                t9.i.d(channel2);
                t4(channel2, 0, true);
            } else {
                this.W = null;
                f1.f12517a.w(R.string.live_no_previous);
            }
        }
        i1.n(getContext());
    }

    public void V2() {
        super.V2();
        J5();
        ((TitanVideoView) x3(R$id.mVideoViewLive)).setKeepScreenOn(true);
        if (!Y3()) {
            ((AutoHideRelativeLayout) x3(R$id.mLiveControlPanelPortrait)).setVisibility(8);
            return;
        }
        ((AutoHideRelativeLayout) x3(R$id.mLiveControlPanelPortrait)).setVisibility(0);
        E5();
    }

    public final void V3(int i10, int i11, int i12, int i13) {
        X3(this.f4484r);
        int i14 = R$id.mVideoContainer;
        ((RatioFrameLayout) x3(i14)).setRatioEnable(!this.f4484r);
        ((RatioFrameLayout) x3(i14)).setLayoutParams(new FrameLayout.LayoutParams(i10, i11));
        Fragment parentFragment = getParentFragment();
        t9.i.e(parentFragment, "null cannot be cast to non-null type com.mobile.brasiltv.fragment.LiveFrag");
        FrameLayout H3 = ((z) parentFragment).H3();
        t9.i.e(H3, "null cannot be cast to non-null type com.mobile.brasiltv.view.RatioFrameLayout");
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) H3;
        ratioFrameLayout.setRatioEnable(!this.f4484r);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i12, i13);
        if (!this.f4484r) {
            layoutParams.topMargin = AutoUtils.getPercentHeightSize(123);
        }
        ratioFrameLayout.setLayoutParams(layoutParams);
        ((TitanVideoView) x3(R$id.mVideoViewLive)).requestLayout();
    }

    public final void V4(ArrayList arrayList, int i10) {
        this.f4472j = arrayList;
        j0 j0Var = this.f4478m;
        j0 j0Var2 = null;
        if (j0Var == null) {
            t9.i.w("adapterChannel");
            j0Var = null;
        }
        j0Var.getData().clear();
        j0 j0Var3 = this.f4478m;
        if (j0Var3 == null) {
            t9.i.w("adapterChannel");
            j0Var3 = null;
        }
        j0Var3.notifyDataSetChanged();
        j0 j0Var4 = this.f4478m;
        if (j0Var4 == null) {
            t9.i.w("adapterChannel");
            j0Var4 = null;
        }
        j0Var4.getData().addAll(arrayList);
        j0 j0Var5 = this.f4478m;
        if (j0Var5 == null) {
            t9.i.w("adapterChannel");
        } else {
            j0Var2 = j0Var5;
        }
        j0Var2.c(i10);
    }

    public final void W3(boolean z10) {
        Window window;
        if (z10) {
            androidx.fragment.app.e activity = getActivity();
            t9.i.d(activity);
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags = 1024 | attributes.flags;
            androidx.fragment.app.e activity2 = getActivity();
            if (activity2 != null) {
                window = activity2.getWindow();
            } else {
                window = null;
            }
            if (window != null) {
                window.setAttributes(attributes);
                return;
            }
            return;
        }
        androidx.fragment.app.e activity3 = getActivity();
        t9.i.d(activity3);
        activity3.getWindow().addFlags(1024);
        androidx.fragment.app.e activity4 = getActivity();
        t9.i.d(activity4);
        WindowManager.LayoutParams attributes2 = activity4.getWindow().getAttributes();
        attributes2.flags &= -1025;
        androidx.fragment.app.e activity5 = getActivity();
        t9.i.d(activity5);
        activity5.getWindow().setAttributes(attributes2);
        androidx.fragment.app.e activity6 = getActivity();
        t9.i.d(activity6);
        activity6.getWindow().clearFlags(1024);
        this.f4488v = false;
        ((AutoFrameLayout) x3(R$id.mFlLocked)).setVisibility(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void W4(mobile.com.requestframe.utils.response.Channel r10, boolean r11) {
        /*
            r9 = this;
            r0 = 0
            r9.f4492z = r0
            java.util.List r1 = r10.getLiveAddressList()
            r2 = 8
            if (r1 == 0) goto L_0x0025
            java.util.List r1 = r10.getLiveAddressList()
            t9.i.d(r1)
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0019
            goto L_0x0025
        L_0x0019:
            int r1 = com.mobile.brasiltv.R$id.mTextNetNotify
            android.view.View r1 = r9.x3(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setVisibility(r2)
            goto L_0x003c
        L_0x0025:
            int r1 = com.mobile.brasiltv.R$id.mTextNetNotify
            android.view.View r3 = r9.x3(r1)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r3.setVisibility(r0)
            android.view.View r1 = r9.x3(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r3 = 2131821331(0x7f110313, float:1.9275402E38)
            r1.setText(r3)
        L_0x003c:
            java.lang.String r1 = r10.getRestricted()
            java.lang.String r3 = "0"
            boolean r1 = t9.i.b(r1, r3)
            if (r1 == 0) goto L_0x005a
            com.mobile.brasiltv.utils.n0 r1 = com.mobile.brasiltv.utils.n0.f12601a
            android.content.Context r3 = r9.getContext()
            t9.i.d(r3)
            java.lang.String r4 = "live_last_play_chanel_NORMAL"
            java.lang.String r5 = r10.getChannelCode()
            r1.j(r3, r4, r5)
        L_0x005a:
            b6.z$a r1 = b6.z.f4508u
            java.lang.String r3 = r10.getChannelCode()
            r1.n(r3)
            com.mobile.brasiltv.utils.n0 r3 = com.mobile.brasiltv.utils.n0.f12601a
            android.content.Context r4 = r9.getContext()
            t9.i.d(r4)
            java.lang.String r5 = "live_last_play_chanel"
            java.lang.String r1 = r1.f()
            r3.j(r4, r5, r1)
            r9.f4474k = r10
            int r1 = com.mobile.brasiltv.R$id.mTextTitle
            android.view.View r1 = r9.x3(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r3 = r10.getAlias()
            java.lang.String r4 = r10.getName()
            java.lang.String r3 = com.mobile.brasiltv.utils.b0.c(r3, r4)
            r1.setText(r3)
            b6.r0$a r1 = b6.r0.A
            java.util.HashMap r3 = r1.d()
            java.lang.String r4 = r10.getChannelCode()
            boolean r3 = r3.containsKey(r4)
            r4 = 0
            java.lang.String r5 = ""
            if (r3 == 0) goto L_0x00c3
            int r3 = com.mobile.brasiltv.R$id.tvProgramName
            android.view.View r3 = r9.x3(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.util.HashMap r1 = r1.d()
            java.lang.String r6 = r10.getChannelCode()
            java.lang.Object r1 = r1.get(r6)
            mobile.com.requestframe.utils.response.EpgResultData r1 = (mobile.com.requestframe.utils.response.EpgResultData) r1
            if (r1 == 0) goto L_0x00be
            java.lang.String r1 = r1.getTitle()
            goto L_0x00bf
        L_0x00be:
            r1 = r4
        L_0x00bf:
            r3.setText(r1)
            goto L_0x00ce
        L_0x00c3:
            int r1 = com.mobile.brasiltv.R$id.tvProgramName
            android.view.View r1 = r9.x3(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setText(r5)
        L_0x00ce:
            d6.a r1 = d6.a.f16338a
            boolean r1 = r1.g(r10)
            java.lang.String r3 = r10.getChannelCode()
            r9.y5(r1, r3, r0)
            int r1 = com.mobile.brasiltv.R$id.mTextToDo
            android.view.View r3 = r9.x3(r1)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.content.res.Resources r6 = r9.getResources()
            r7 = 2131099927(0x7f060117, float:1.7812221E38)
            int r6 = r6.getColor(r7)
            r3.setTextColor(r6)
            android.view.View r3 = r9.x3(r1)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r3.setBackgroundColor(r0)
            android.view.View r3 = r9.x3(r1)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.CharSequence r3 = r3.getText()
            android.content.res.Resources r6 = r9.getResources()
            r8 = 2131820788(0x7f1100f4, float:1.92743E38)
            java.lang.String r6 = r6.getString(r8)
            boolean r3 = t9.i.b(r3, r6)
            if (r3 == 0) goto L_0x012f
            android.view.View r3 = r9.x3(r1)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.content.res.Resources r6 = r9.getResources()
            int r6 = r6.getColor(r7)
            r3.setTextColor(r6)
            android.view.View r3 = r9.x3(r1)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r3.setBackgroundColor(r0)
        L_0x012f:
            w6.i$c r3 = w6.i.f9510g
            java.lang.String r3 = r3.I()
            java.lang.String r6 = "3"
            boolean r3 = t9.i.b(r3, r6)
            if (r3 == 0) goto L_0x01a8
            java.lang.String r3 = r10.getRestricted()
            java.lang.String r6 = "1"
            boolean r3 = t9.i.b(r3, r6)
            if (r3 == 0) goto L_0x01a8
            int r3 = com.mobile.brasiltv.R$id.mTextNetNotify
            android.view.View r3 = r9.x3(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r3.setVisibility(r2)
            int r3 = com.mobile.brasiltv.R$id.mLayoutMobileNotify
            android.view.View r3 = r9.x3(r3)
            com.zhy.autolayout.AutoLinearLayout r3 = (com.zhy.autolayout.AutoLinearLayout) r3
            r3.setVisibility(r0)
            int r3 = com.mobile.brasiltv.R$id.mTextPlayNotify
            android.view.View r3 = r9.x3(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.content.res.Resources r6 = r9.getResources()
            r7 = 2131821343(0x7f11031f, float:1.9275427E38)
            java.lang.String r6 = r6.getString(r7)
            r3.setText(r6)
            int r3 = com.mobile.brasiltv.R$id.mPlayIcon
            android.view.View r3 = r9.x3(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r3.setVisibility(r2)
            android.view.View r3 = r9.x3(r1)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r3.setVisibility(r0)
            android.view.View r1 = r9.x3(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.content.res.Resources r3 = r9.getResources()
            r6 = 2131821668(0x7f110464, float:1.9276086E38)
            java.lang.String r3 = r3.getString(r6)
            r1.setText(r3)
            int r1 = com.mobile.brasiltv.R$id.mTextToDo2
            android.view.View r1 = r9.x3(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setVisibility(r2)
        L_0x01a8:
            l6.g0 r1 = r9.f4490x
            java.lang.String r3 = "mLivePlayPresenter"
            if (r1 != 0) goto L_0x01b2
            t9.i.w(r3)
            r1 = r4
        L_0x01b2:
            r1.F(r11)
            l6.g0 r11 = r9.f4490x
            if (r11 != 0) goto L_0x01bd
            t9.i.w(r3)
            r11 = r4
        L_0x01bd:
            boolean r11 = r11.y()
            if (r11 == 0) goto L_0x01d9
            int r11 = com.mobile.brasiltv.R$id.mTextNetNotify
            android.view.View r11 = r9.x3(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r11.setVisibility(r2)
            int r11 = com.mobile.brasiltv.R$id.mLayoutMobileNotify
            android.view.View r11 = r9.x3(r11)
            com.zhy.autolayout.AutoLinearLayout r11 = (com.zhy.autolayout.AutoLinearLayout) r11
            r11.setVisibility(r2)
        L_0x01d9:
            boolean r11 = r9.Y3()
            if (r11 != 0) goto L_0x01eb
            int r11 = com.mobile.brasiltv.R$id.mLiveControlPanelPortrait
            android.view.View r11 = r9.x3(r11)
            com.mobile.brasiltv.view.AutoHideRelativeLayout r11 = (com.mobile.brasiltv.view.AutoHideRelativeLayout) r11
            r11.setVisibility(r2)
            goto L_0x0206
        L_0x01eb:
            boolean r11 = r9.f4484r
            if (r11 == 0) goto L_0x01fb
            int r11 = com.mobile.brasiltv.R$id.mLiveControlPanelPortrait
            android.view.View r11 = r9.x3(r11)
            com.mobile.brasiltv.view.AutoHideRelativeLayout r11 = (com.mobile.brasiltv.view.AutoHideRelativeLayout) r11
            r11.setVisibility(r2)
            goto L_0x0206
        L_0x01fb:
            int r11 = com.mobile.brasiltv.R$id.mLiveControlPanelPortrait
            android.view.View r11 = r9.x3(r11)
            com.mobile.brasiltv.view.AutoHideRelativeLayout r11 = (com.mobile.brasiltv.view.AutoHideRelativeLayout) r11
            r11.setVisibility(r0)
        L_0x0206:
            r9.F = r5
            r9.G = r5
            r9.H = r5
            r9.I = r5
            int r11 = com.mobile.brasiltv.R$id.mLayoutMobileNotify
            android.view.View r11 = r9.x3(r11)
            com.zhy.autolayout.AutoLinearLayout r11 = (com.zhy.autolayout.AutoLinearLayout) r11
            int r11 = r11.getVisibility()
            if (r11 != r2) goto L_0x0242
            l6.g0 r11 = r9.f4490x
            if (r11 != 0) goto L_0x0224
            t9.i.w(r3)
            r11 = r4
        L_0x0224:
            r11.G(r10)
            l6.g0 r10 = r9.f4490x
            if (r10 != 0) goto L_0x022f
            t9.i.w(r3)
            goto L_0x0230
        L_0x022f:
            r4 = r10
        L_0x0230:
            r4.r()
            int r10 = com.mobile.brasiltv.R$id.mBufferView
            android.view.View r10 = r9.x3(r10)
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            r10.setVisibility(r0)
            r9.K5()
            goto L_0x0258
        L_0x0242:
            int r10 = com.mobile.brasiltv.R$id.mBufferView
            android.view.View r10 = r9.x3(r10)
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            r10.setVisibility(r2)
            int r10 = com.mobile.brasiltv.R$id.mVideoViewLive
            android.view.View r10 = r9.x3(r10)
            com.titans.widget.TitanVideoView r10 = (com.titans.widget.TitanVideoView) r10
            r10.D()
        L_0x0258:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.r1.W4(mobile.com.requestframe.utils.response.Channel, boolean):void");
    }

    public void X2() {
        this.f4479m0.clear();
    }

    public final void X3(boolean z10) {
        if (z10) {
            E4();
        } else {
            q5();
        }
    }

    public final void X4() {
        String str;
        String c10;
        w6.i b10 = w6.i.f9510g.b();
        Channel channel = this.f4474k;
        String str2 = "";
        if (channel == null || (str = channel.getName()) == null) {
            str = str2;
        }
        String obj = ((TextView) x3(R$id.mTvCastDevice)).getText().toString();
        String a10 = com.mobile.brasiltv.utils.h.f12562a.a();
        l6.g0 g0Var = this.f4490x;
        if (g0Var == null) {
            t9.i.w("mLivePlayPresenter");
            g0Var = null;
        }
        o6.a v10 = g0Var.v();
        if (!(v10 == null || (c10 = v10.c()) == null)) {
            str2 = c10;
        }
        b10.s2(str, obj, a10, str2).subscribe(new u());
    }

    public final boolean Y3() {
        String str;
        if (!t9.i.b(w6.i.f9510g.I(), "3")) {
            return true;
        }
        Channel channel = this.f4474k;
        if (channel != null) {
            str = channel.getRestricted();
        } else {
            str = null;
        }
        if (t9.i.b(str, "1")) {
            return false;
        }
        return true;
    }

    public final void Y4() {
    }

    public void Z() {
    }

    public String Z0() {
        return this.E;
    }

    public final String Z3(Program program, o6.a aVar, boolean z10) {
        boolean z11;
        if (aVar == null) {
            return null;
        }
        String str = null;
        for (Media media : program.getMedias()) {
            if (t9.i.b(media.getQuality(), aVar.c())) {
                str = media.getName();
            }
        }
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (t9.i.b(aVar.c(), o6.c.c().c())) {
                Context context = getContext();
                if (context != null) {
                    com.mobile.brasiltv.utils.x.f12622a.w(context, new e(this));
                }
            } else if (t9.i.b(aVar.c(), o6.c.b().c())) {
                u5(this, false, false, 2, (Object) null);
            } else if (t9.i.b(aVar.c(), o6.c.a().c())) {
                t5(true, z10);
            }
        }
        return str;
    }

    public final void Z4(List list, int i10) {
        t9.i.g(list, "channelList");
        z.a aVar = z.f4508u;
        aVar.g().put(i10, list);
        if (this.f4470i == i10) {
            j0 j0Var = this.f4478m;
            j0 j0Var2 = null;
            if (j0Var == null) {
                t9.i.w("adapterChannel");
                j0Var = null;
            }
            j0Var.getData().addAll(list);
            j0 j0Var3 = this.f4478m;
            if (j0Var3 == null) {
                t9.i.w("adapterChannel");
            } else {
                j0Var2 = j0Var3;
            }
            j0Var2.notifyDataSetChanged();
            String f10 = aVar.f();
            if (f10 == null) {
                f10 = "";
            }
            k4(this, f10, (ArrayList) list, false, 4, (Object) null);
        }
    }

    public final void a5() {
        q5.j jVar = f4462o0;
        if (jVar != null) {
            jVar.q();
        }
    }

    @xa.j
    public final void alreadyQueryFav(AlreadyQueryFavEvent alreadyQueryFavEvent) {
        t9.i.g(alreadyQueryFavEvent, "event");
        Channel channel = this.f4474k;
        if (channel != null) {
            d6.a aVar = d6.a.f16338a;
            t9.i.d(channel);
            boolean g10 = aVar.g(channel);
            Channel channel2 = this.f4474k;
            t9.i.d(channel2);
            y5(g10, channel2.getChannelCode(), false);
        }
    }

    public void b0() {
    }

    public void b1() {
    }

    public final void b4() {
        if (!this.f4476l && !ga.a.c(getContext())) {
            ((TitanVideoView) x3(R$id.mVideoViewLive)).D();
            ((AutoLinearLayout) x3(R$id.mLayoutMobileNotify)).setVisibility(0);
            ((TextView) x3(R$id.mTextPlayNotify)).setText(getResources().getString(R.string.mobile_net_play));
            ((ImageView) x3(R$id.mPlayIcon)).setVisibility(0);
            ((TextView) x3(R$id.mTextToDo)).setText(getResources().getString(R.string.click_continue));
            ((TextView) x3(R$id.mTextNetNotify)).setVisibility(8);
        }
    }

    public final void b5() {
        Channel channel = this.f4474k;
        if (channel != null) {
            d6.a aVar = d6.a.f16338a;
            t9.i.d(channel);
            if (!aVar.l(channel.getChannelCode())) {
                Channel channel2 = this.f4474k;
                t9.i.d(channel2);
                aVar.f(channel2.getChannelCode());
                Channel channel3 = this.f4474k;
                t9.i.d(channel3);
                if (aVar.g(channel3)) {
                    Channel channel4 = this.f4474k;
                    t9.i.d(channel4);
                    aVar.h(channel4);
                    return;
                }
                Channel channel5 = this.f4474k;
                t9.i.d(channel5);
                aVar.e(channel5);
            }
        }
    }

    public void c2() {
        xa.c.c().j(new CastPlaySuccessEvent("LIVE"));
        int i10 = R$id.mTvCastState;
        Context context = getContext();
        t9.i.d(context);
        ((TextView) x3(i10)).setText(context.getResources().getString(R.string.cast_status_casting));
        Context context2 = getContext();
        t9.i.d(context2);
        ((TextView) x3(i10)).setTextColor(context2.getResources().getColor(R.color.color_fffefe));
        ((TextView) x3(R$id.mTvPleaseWait)).setVisibility(8);
        ((TextView) x3(R$id.mTvCastRecommendHint)).setVisibility(4);
        c5();
    }

    public final boolean c4() {
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

    public final void c5() {
        CastDevice castDevice;
        String friendlyName;
        String friendly_name;
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        String str = "";
        if (t9.i.b(hVar.a(), hVar.k())) {
            int i10 = R$id.mTvCastDevice;
            TextView textView = (TextView) x3(i10);
            Device g10 = com.mobile.brasiltv.utils.g.f12519a.g();
            if (!(g10 == null || (friendly_name = g10.getFriendly_name()) == null)) {
                str = friendly_name;
            }
            textView.setText(str);
            ((TextView) x3(i10)).append("-DLNA");
            return;
        }
        int i11 = R$id.mTvCastDevice;
        TextView textView2 = (TextView) x3(i11);
        CastSession i12 = this.C.i();
        if (!(i12 == null || (castDevice = i12.getCastDevice()) == null || (friendlyName = castDevice.getFriendlyName()) == null)) {
            str = friendlyName;
        }
        textView2.setText(str);
        ((TextView) x3(i11)).append("-ChromeCast");
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void castToCloseOtherPlay(CastToCloseOtherPlayEvent castToCloseOtherPlayEvent) {
        t9.i.g(castToCloseOtherPlayEvent, "event");
        if (t9.i.b(castToCloseOtherPlayEvent.getFromType(), "VOD") && com.mobile.brasiltv.utils.h.f12562a.s()) {
            U3(this, true, false, 2, (Object) null);
        }
    }

    @xa.j
    public final void castToPlay(CastToPlayEvent castToPlayEvent) {
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
        String quality;
        String vcodec;
        String format;
        String buss2;
        String episode;
        String title;
        String name;
        String media2;
        List<Media> medias;
        androidx.fragment.app.e activity;
        t9.i.g(castToPlayEvent, "event");
        if (t9.i.b(castToPlayEvent.getFromType(), "LIVE") && (activity = getActivity()) != null) {
            activity.runOnUiThread(new j1(this));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("isReceivePrepareCast:");
        sb.append(this.O);
        sb.append(";isToastCastError:");
        sb.append(this.L);
        sb.append(";castErrorMsg:");
        sb.append(this.M);
        sb.append(";\t   mCastLiveUrl:");
        sb.append(this.F);
        if (this.O && !this.L && com.mobile.brasiltv.utils.b0.K(this.M)) {
            Integer num = this.N;
            if (num != null) {
                int intValue = num.intValue();
                String str13 = this.M;
                if (str13 == null) {
                    str13 = "";
                }
                s5(intValue, str13);
            }
            this.M = "";
        }
        Program program = this.J;
        if (program == null || (medias = program.getMedias()) == null) {
            media = null;
        } else {
            media = medias.get(0);
        }
        if (t9.i.b(castToPlayEvent.getFromType(), "LIVE") && com.mobile.brasiltv.utils.b0.K(this.F) && this.O) {
            this.K = false;
            L5();
            com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f12519a;
            gVar.x(castToPlayEvent.getFromType());
            if (com.mobile.brasiltv.utils.b0.K(this.F)) {
                if (this.Q) {
                    str = P3("dlna");
                } else {
                    str = this.F;
                }
                String str14 = str;
                Program program2 = this.J;
                if (program2 == null || (media2 = program2.getMedia()) == null) {
                    str2 = "";
                } else {
                    str2 = media2;
                }
                Program program3 = this.J;
                if (program3 == null || (name = program3.getName()) == null) {
                    str3 = "";
                } else {
                    str3 = name;
                }
                Program program4 = this.J;
                if (program4 == null || (title = program4.getTitle()) == null) {
                    str4 = "";
                } else {
                    str4 = title;
                }
                Program program5 = this.J;
                if (program5 == null || (episode = program5.getEpisode()) == null) {
                    str5 = "";
                } else {
                    str5 = episode;
                }
                Program program6 = this.J;
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
                Program program7 = this.J;
                if (program7 == null || (buss = program7.getBuss()) == null) {
                    str11 = "";
                } else {
                    str11 = buss;
                }
                String str15 = this.S;
                if (str15 == null) {
                    str12 = "";
                } else {
                    str12 = str15;
                }
                gVar.E(str14, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, 0, str12, this.Q);
                this.D = com.mobile.brasiltv.utils.h.f12562a.k();
            }
        } else if (!this.O) {
            this.K = true;
        }
    }

    @xa.j
    public final void checkPwdSuccess(CheckPwdSuccessEvent checkPwdSuccessEvent) {
        boolean z10;
        g6.d dVar;
        t9.i.g(checkPwdSuccessEvent, "event");
        boolean z11 = false;
        MainAty.A.o(false);
        z.a aVar = z.f4508u;
        ChildColumnList a10 = aVar.a();
        if (a10 == null || this.f4470i != a10.getId()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            g6.d dVar2 = this.A;
            if (dVar2 != null && dVar2.isShowing()) {
                z11 = true;
            }
            if (z11 && (dVar = this.A) != null) {
                dVar.cancel();
            }
            if (aVar.g().indexOfKey(this.f4470i) >= 0) {
                j0 j0Var = this.f4478m;
                j0 j0Var2 = null;
                if (j0Var == null) {
                    t9.i.w("adapterChannel");
                    j0Var = null;
                }
                List data = j0Var.getData();
                Object obj = aVar.g().get(this.f4470i);
                t9.i.d(obj);
                data.addAll((Collection) obj);
                j0 j0Var3 = this.f4478m;
                if (j0Var3 == null) {
                    t9.i.w("adapterChannel");
                } else {
                    j0Var2 = j0Var3;
                }
                j0Var2.notifyDataSetChanged();
                this.f4472j.clear();
                ArrayList arrayList = this.f4472j;
                Object obj2 = aVar.g().get(this.f4470i);
                t9.i.d(obj2);
                arrayList.addAll((Collection) obj2);
                String f10 = aVar.f();
                if (f10 == null) {
                    f10 = "";
                }
                k4(this, f10, this.f4472j, false, 4, (Object) null);
                return;
            }
            L4(this.f4470i);
        }
    }

    public void d1(long j10) {
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        if (hVar.o() && hVar.t()) {
            com.mobile.brasiltv.utils.g.f12519a.G();
        }
        ((TitanVideoView) x3(R$id.mVideoViewLive)).C();
        this.F = "";
        hVar.v(false);
        this.O = true;
        this.N = Integer.valueOf((int) j10);
        Context context = getContext();
        if (context != null) {
            com.mobile.brasiltv.utils.x.f12622a.w(context, new d(this, context, j10));
        }
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new i1(this));
        }
    }

    public final void d4() {
        this.f4488v = true;
        q5.j jVar = f4462o0;
        if (jVar != null) {
            jVar.t();
        }
        ((AutoFrameLayout) x3(R$id.mFlLocked)).setVisibility(0);
        N4();
        ((AutoHideRelativeLayout) x3(R$id.mLiveControlPanelLandscape)).setVisibility(8);
    }

    public final void d5() {
        ((ProgressBar) x3(R$id.mPbBrightness)).setProgress((int) (r4() * ((float) 100)));
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void disConnectEvent(CastToCloseFloatViewEvent castToCloseFloatViewEvent) {
        t9.i.g(castToCloseFloatViewEvent, "event");
        if (((AutoLinearLayout) x3(R$id.llSwitchContainer)).getVisibility() == 0) {
            U3(this, true, false, 2, (Object) null);
        }
    }

    @xa.j
    public final void disableFullScreen(FullScreenEvent fullScreenEvent) {
        t9.i.g(fullScreenEvent, "event");
        if (fullScreenEvent.getDisable()) {
            M5(Boolean.FALSE);
        } else {
            J5();
        }
    }

    public void e0() {
    }

    public final void e4() {
        this.f4488v = false;
        q5.j jVar = f4462o0;
        if (jVar != null) {
            jVar.x();
        }
        Disposable disposable = this.f4486t;
        if (disposable != null) {
            disposable.dispose();
        }
        ((AutoFrameLayout) x3(R$id.mFlLocked)).setVisibility(8);
        ((AutoHideRelativeLayout) x3(R$id.mLiveControlPanelLandscape)).setVisibility(0);
        d5();
        e5();
    }

    public final void e5() {
        ((ProgressBar) x3(R$id.mPbVolume)).setProgress((p4().d() * 100) / p4().e());
    }

    public final void f4() {
        Disposable disposable;
        Disposable disposable2 = this.f4485s;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = this.f4485s) != null) {
            disposable.dispose();
        }
        this.f4485s = Observable.timer(5000, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new y0(new f(this)), new z0(g.f11108a));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        if (r1 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        if (r1 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f5() {
        /*
            r8 = this;
            b6.z$a r0 = b6.z.f4508u
            java.util.ArrayList r1 = r0.d()
            if (r1 == 0) goto L_0x0149
            boolean r1 = com.mobile.brasiltv.utils.f0.b()
            r2 = 1
            java.lang.String r3 = ""
            r4 = 0
            if (r1 != 0) goto L_0x0039
            mobile.com.requestframe.utils.response.ChildColumnList r1 = r0.e()
            if (r1 == 0) goto L_0x001d
            java.lang.String r1 = r1.getAlias()
            goto L_0x001e
        L_0x001d:
            r1 = r4
        L_0x001e:
            if (r1 == 0) goto L_0x0029
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 != 0) goto L_0x0039
            mobile.com.requestframe.utils.response.ChildColumnList r1 = r0.e()
            if (r1 == 0) goto L_0x0047
            java.lang.String r1 = r1.getAlias()
            if (r1 != 0) goto L_0x0046
            goto L_0x0047
        L_0x0039:
            mobile.com.requestframe.utils.response.ChildColumnList r1 = r0.e()
            if (r1 == 0) goto L_0x0047
            java.lang.String r1 = r1.getName()
            if (r1 != 0) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r3 = r1
        L_0x0047:
            w6.i$c r1 = w6.i.f9510g
            java.lang.String r5 = r1.e()
            java.lang.String r6 = "1"
            boolean r5 = t9.i.b(r5, r6)
            java.lang.String r7 = "adapterSort"
            if (r5 == 0) goto L_0x00ed
            java.lang.String r5 = r1.I()
            boolean r5 = t9.i.b(r5, r6)
            if (r5 != 0) goto L_0x006d
            java.lang.String r1 = r1.I()
            java.lang.String r5 = "2"
            boolean r1 = t9.i.b(r1, r5)
            if (r1 == 0) goto L_0x00ed
        L_0x006d:
            java.util.ArrayList r1 = r8.f4464f
            mobile.com.requestframe.utils.response.ChildColumnList r5 = r0.e()
            t9.i.d(r5)
            int r5 = r5.getId()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            boolean r1 = r1.contains(r5)
            if (r1 != 0) goto L_0x0149
            java.util.ArrayList r1 = r8.f4464f
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x00a7
            java.util.ArrayList r1 = r8.f4466g
            r5 = 2
            r1.add(r5, r3)
            java.util.ArrayList r1 = r8.f4464f
            mobile.com.requestframe.utils.response.ChildColumnList r0 = r0.e()
            t9.i.d(r0)
            int r0 = r0.getId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.add(r2, r0)
            goto L_0x00c0
        L_0x00a7:
            java.util.ArrayList r1 = r8.f4466g
            r1.add(r3)
            java.util.ArrayList r1 = r8.f4464f
            mobile.com.requestframe.utils.response.ChildColumnList r0 = r0.e()
            t9.i.d(r0)
            int r0 = r0.getId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.add(r0)
        L_0x00c0:
            g5.o0 r0 = r8.f4480n
            if (r0 != 0) goto L_0x00c8
            t9.i.w(r7)
            r0 = r4
        L_0x00c8:
            java.util.List r0 = r0.getData()
            r0.clear()
            g5.o0 r0 = r8.f4480n
            if (r0 != 0) goto L_0x00d7
            t9.i.w(r7)
            r0 = r4
        L_0x00d7:
            java.util.List r0 = r0.getData()
            java.util.ArrayList r1 = r8.f4466g
            r0.addAll(r1)
            g5.o0 r0 = r8.f4480n
            if (r0 != 0) goto L_0x00e8
            t9.i.w(r7)
            goto L_0x00e9
        L_0x00e8:
            r4 = r0
        L_0x00e9:
            r4.notifyDataSetChanged()
            goto L_0x0149
        L_0x00ed:
            java.util.ArrayList r1 = r8.f4464f
            mobile.com.requestframe.utils.response.ChildColumnList r2 = r0.e()
            t9.i.d(r2)
            int r2 = r2.getId()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x0149
            java.util.ArrayList r1 = r8.f4466g
            r1.remove(r3)
            java.util.ArrayList r1 = r8.f4464f
            mobile.com.requestframe.utils.response.ChildColumnList r0 = r0.e()
            t9.i.d(r0)
            int r0 = r0.getId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.remove(r0)
            g5.o0 r0 = r8.f4480n
            if (r0 != 0) goto L_0x0125
            t9.i.w(r7)
            r0 = r4
        L_0x0125:
            java.util.List r0 = r0.getData()
            r0.clear()
            g5.o0 r0 = r8.f4480n
            if (r0 != 0) goto L_0x0134
            t9.i.w(r7)
            r0 = r4
        L_0x0134:
            java.util.List r0 = r0.getData()
            java.util.ArrayList r1 = r8.f4466g
            r0.addAll(r1)
            g5.o0 r0 = r8.f4480n
            if (r0 != 0) goto L_0x0145
            t9.i.w(r7)
            goto L_0x0146
        L_0x0145:
            r4 = r0
        L_0x0146:
            r4.notifyDataSetChanged()
        L_0x0149:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.r1.f5():void");
    }

    public d8.d g1(List list) {
        t9.i.g(list, "audioTrackList");
        return null;
    }

    public final void g5() {
        ((RatioFrameLayout) x3(R$id.mVideoContainer)).setOnTouchListener(new q1(this, new GestureDetector(getActivity(), new v(this))));
    }

    @xa.j
    public final void googleCastToPlay(GoogleCastToPlayEvent googleCastToPlayEvent) {
        t9.i.g(googleCastToPlayEvent, "event");
        if (t9.i.b(googleCastToPlayEvent.getFromType(), "LIVE") && this.f4474k != null && com.mobile.brasiltv.utils.b0.K(this.F)) {
            this.K = false;
            L5();
            this.C.j(P3("google_cast"), 0, 0, q4());
            z5.c cVar = this.C;
            Channel channel = this.f4474k;
            t9.i.d(channel);
            String channelCode = channel.getChannelCode();
            Channel channel2 = this.f4474k;
            t9.i.d(channel2);
            cVar.l(this, channelCode, channel2.getName(), this.G, "live", this.H, this.I, "");
            this.D = com.mobile.brasiltv.utils.h.f12562a.l();
            U3(this, false, false, 2, (Object) null);
        }
    }

    public final void i4(String str) {
        t9.i.g(str, "channelCode");
        Observable.just(this.f4472j).flatMap(new b1(new j(str))).compose(p0.a()).subscribe(new c1(new k(this)));
    }

    public final void i5(b8.b bVar) {
        t9.i.g(bVar, "<set-?>");
        this.f4471i0 = bVar;
    }

    public final void j4(String str, ArrayList arrayList, boolean z10) {
        t9.i.g(str, "channelCode");
        t9.i.g(arrayList, "channelList");
        Observable.just(arrayList).flatMap(new w0(new h(str))).compose(p0.a()).subscribe(new x0(new i(this, z10)));
    }

    public final void j5() {
        String str;
        Resources resources;
        ((RatioFrameLayout) x3(R$id.mVideoContainer)).setOnClickListener(this);
        ((ImageView) x3(R$id.mIconSilence)).setOnClickListener(this);
        ((ImageView) x3(R$id.mIconFullscreen)).setOnClickListener(this);
        ((ImageView) x3(R$id.mIconSave)).setOnClickListener(this);
        ((ImageView) x3(R$id.mIvFavPort)).setOnClickListener(this);
        ((ImageView) x3(R$id.mIconBack)).setOnClickListener(this);
        ((AutoLinearLayout) x3(R$id.mLlChannelList)).setOnClickListener(this);
        ((AutoLinearLayout) x3(R$id.mLlPrevious)).setOnClickListener(this);
        ((AutoLinearLayout) x3(R$id.mLlLock)).setOnClickListener(this);
        ((AutoLinearLayout) x3(R$id.mLlQuality)).setOnClickListener(this);
        ((AutoFrameLayout) x3(R$id.mFlLocked)).setOnClickListener(this);
        ((AnimatorFrameLayout) x3(R$id.mLayoutChannelList)).setOnVisibilityListener(this);
        ((ImageView) x3(R$id.mIvPortQuality)).setOnClickListener(this);
        ImageView imageView = (ImageView) x3(R$id.mIconCast);
        t9.i.f(imageView, "mIconCast");
        com.mobile.brasiltv.utils.b0.P(imageView, this);
        ImageView imageView2 = (ImageView) x3(R$id.mIconCastPort);
        t9.i.f(imageView2, "mIconCastPort");
        com.mobile.brasiltv.utils.b0.P(imageView2, this);
        ((ImageView) x3(R$id.mIvCastClose)).setOnClickListener(new k1(this));
        ((ImageView) x3(R$id.mIvCastSwitchDevice)).setOnClickListener(new l1(this));
        ((ImageView) x3(R$id.mIvCastFeedback)).setOnClickListener(new m1(this));
        ((TextView) x3(R$id.tvConfirm)).setOnClickListener(new n1());
        int i10 = R$id.mRecyclerSort;
        ((KoocanRecyclerView) x3(i10)).addOnItemTouchListener(new x(this));
        int i11 = R$id.mRecyclerChannel;
        ((KoocanRecyclerView) x3(i11)).addOnItemTouchListener(new y(this));
        j0 j0Var = this.f4478m;
        if (j0Var == null) {
            t9.i.w("adapterChannel");
            j0Var = null;
        }
        j0Var.setOnItemChildClickListener(new o1(this));
        ((KoocanRecyclerView) x3(i10)).addOnItemTouchListener(this.f4467g0);
        ((KoocanRecyclerView) x3(i11)).addOnItemTouchListener(this.f4467g0);
        ((TextView) x3(R$id.mTextToDo)).setOnClickListener(this);
        ((TextView) x3(R$id.mTextToDo2)).setOnClickListener(this);
        ((TitanVideoView) x3(R$id.mVideoViewLive)).setPlayerListener(this);
        int i12 = R$id.mTvCastRecommendHint;
        TextView textView = (TextView) x3(i12);
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null || (str = resources.getString(R.string.cast_recommend_hint)) == null) {
            str = "";
        }
        textView.setText(Html.fromHtml(str));
        ((TextView) x3(i12)).setOnClickListener(new p1(this));
        ((ImageView) x3(R$id.mImageLandFeedback)).setOnClickListener(this);
        ((ImageView) x3(R$id.mImageFeedback)).setOnClickListener(this);
        ((ImageView) x3(R$id.mImageLandShare)).setOnClickListener(this);
        ((ImageView) x3(R$id.mImageShare)).setOnClickListener(this);
        ((ImageView) x3(R$id.mDebugSwitch)).setOnClickListener(this);
        ((ImageView) x3(R$id.mDebugSwitch_lands)).setOnClickListener(this);
    }

    public void l0() {
    }

    public void m(String str, String str2, long j10) {
        t9.i.g(str, "adName");
        t9.i.g(str2, "path");
    }

    public void m2() {
        ((RelativeLayout) x3(R$id.mBufferView)).setVisibility(8);
        O5();
    }

    public void n2() {
        ((RelativeLayout) x3(R$id.mBufferView)).setVisibility(0);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        o0 o0Var = new o0();
        this.f4480n = o0Var;
        o0Var.getData().addAll(this.f4466g);
        int i10 = R$id.mRecyclerSort;
        ((KoocanRecyclerView) x3(i10)).setLayoutManager(new LinearLayoutManagerWrapper(getContext()));
        KoocanRecyclerView koocanRecyclerView = (KoocanRecyclerView) x3(i10);
        o0 o0Var2 = this.f4480n;
        j0 j0Var = null;
        if (o0Var2 == null) {
            t9.i.w("adapterSort");
            o0Var2 = null;
        }
        koocanRecyclerView.setAdapter(o0Var2);
        Context context = getContext();
        t9.i.d(context);
        this.f4478m = new j0(context);
        int i11 = R$id.mRecyclerChannel;
        ((KoocanRecyclerView) x3(i11)).setLayoutManager(new LinearLayoutManagerWrapper(getContext()));
        KoocanRecyclerView koocanRecyclerView2 = (KoocanRecyclerView) x3(i11);
        j0 j0Var2 = this.f4478m;
        if (j0Var2 == null) {
            t9.i.w("adapterChannel");
        } else {
            j0Var = j0Var2;
        }
        koocanRecyclerView2.setAdapter(j0Var);
        j5();
        ((ImageView) x3(R$id.mIconSilence)).setTag(Boolean.FALSE);
        Context context2 = getContext();
        t9.i.d(context2);
        Object systemService = context2.getSystemService("audio");
        t9.i.e(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.f4481o = (AudioManager) systemService;
        this.f4490x = new l6.g0(this, this);
        xa.c.c().o(this);
        H4();
        g5();
    }

    public void onClick(View view) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        String str;
        String str2;
        Program program;
        Program program2;
        String str3;
        TitanVideoView titanVideoView;
        t9.i.g(view, "v");
        if (t9.i.b(view, (ImageView) x3(R$id.mIconSilence))) {
            G5();
        } else if (t9.i.b(view, (ImageView) x3(R$id.mIconFullscreen))) {
            a5();
        } else if (!t9.i.b(view, (RatioFrameLayout) x3(R$id.mVideoContainer))) {
            boolean z14 = true;
            if (t9.i.b(view, (ImageView) x3(R$id.mIconSave))) {
                z10 = true;
            } else {
                z10 = t9.i.b(view, (ImageView) x3(R$id.mIvFavPort));
            }
            if (z10) {
                b5();
            } else if (t9.i.b(view, (AutoLinearLayout) x3(R$id.mLlChannelList))) {
                w5();
            } else if (t9.i.b(view, (ImageView) x3(R$id.mIconBack))) {
                a5();
            } else if (t9.i.b(view, (AutoLinearLayout) x3(R$id.mLlLock))) {
                if (!this.f4488v) {
                    d4();
                }
            } else if (t9.i.b(view, (AutoFrameLayout) x3(R$id.mFlLocked))) {
                if (this.f4488v) {
                    e4();
                }
            } else if (t9.i.b(view, (AutoLinearLayout) x3(R$id.mLlPrevious))) {
                U4();
            } else if (t9.i.b(view, (TextView) x3(R$id.mTextToDo))) {
                y4();
            } else if (t9.i.b(view, (TextView) x3(R$id.mTextToDo2))) {
                com.mobile.brasiltv.utils.b0.a0(this, AccountBindAty.class);
            } else {
                if (t9.i.b(view, (ImageView) x3(R$id.mIconCast))) {
                    z11 = true;
                } else {
                    z11 = t9.i.b(view, (ImageView) x3(R$id.mIconCastPort));
                }
                String str4 = null;
                if (!z11) {
                    if (t9.i.b(view, (ImageView) x3(R$id.mImageFeedback))) {
                        z12 = true;
                    } else {
                        z12 = t9.i.b(view, (ImageView) x3(R$id.mImageLandFeedback));
                    }
                    if (z12) {
                        FeedBackDialog.Companion companion = FeedBackDialog.Companion;
                        androidx.fragment.app.e activity = getActivity();
                        t9.i.d(activity);
                        boolean z15 = this.f4484r;
                        Channel channel = this.f4474k;
                        if (channel != null) {
                            str2 = channel.getAlias();
                        } else {
                            str2 = null;
                        }
                        Channel channel2 = this.f4474k;
                        if (channel2 != null) {
                            str4 = channel2.getName();
                        }
                        CommonDialog feedBackDialog = companion.getFeedBackDialog(activity, z15, 2, com.mobile.brasiltv.utils.b0.e(str2, str4));
                        this.f4483q = feedBackDialog;
                        if (feedBackDialog != null) {
                            feedBackDialog.show();
                        }
                        CommonDialog commonDialog = this.f4483q;
                        if (commonDialog != null) {
                            commonDialog.setOnDismissListener(new d1(this));
                            return;
                        }
                        return;
                    }
                    if (t9.i.b(view, (ImageView) x3(R$id.mDebugSwitch))) {
                        z13 = true;
                    } else {
                        z13 = t9.i.b(view, (ImageView) x3(R$id.mDebugSwitch_lands));
                    }
                    if (!z13) {
                        int i10 = R$id.mImageShare;
                        if (!t9.i.b(view, (ImageView) x3(i10))) {
                            z14 = t9.i.b(view, (ImageView) x3(R$id.mImageLandShare));
                        }
                        if (z14) {
                            Context context = getContext();
                            if (t9.i.b(view, (ImageView) x3(i10))) {
                                str = "liveDetail";
                            } else {
                                str = "liveFullScreen";
                            }
                            i1.I(context, str);
                            com.mobile.brasiltv.utils.b0.k0(this, w6.i.f9510g.C() + "/#/shareApp", false, true, false, 8, (Object) null);
                        }
                    }
                } else if (getActivity() != null) {
                    a.C0148a aVar = b8.a.f11196a;
                    androidx.fragment.app.e activity2 = getActivity();
                    t9.i.d(activity2);
                    if (!aVar.c(activity2)) {
                        v5();
                    } else {
                        int i11 = R$id.mVideoViewLive;
                        n8.b titanContext = ((TitanVideoView) x3(i11)).getTitanContext();
                        if (titanContext != null) {
                            program = titanContext.h();
                        } else {
                            program = null;
                        }
                        if (program != null) {
                            ((TitanVideoView) x3(i11)).D();
                        }
                        n8.b titanContext2 = ((TitanVideoView) x3(i11)).getTitanContext();
                        if (titanContext2 != null) {
                            program2 = titanContext2.a();
                        } else {
                            program2 = null;
                        }
                        if (!(program2 == null || (titanVideoView = (TitanVideoView) x3(i11)) == null)) {
                            titanVideoView.C();
                        }
                        Program program3 = this.J;
                        if (program3 != null) {
                            TitanVideoView titanVideoView2 = (TitanVideoView) x3(i11);
                            Program program4 = this.J;
                            if (program4 == null || (str3 = program4.getBuss()) == null) {
                                str3 = "";
                            }
                            titanVideoView2.v(program3, str3);
                        }
                        this.O = false;
                        xa.c.c().j(new CastToCloseOtherPlayEvent("LIVE", false, 2, (t9.g) null));
                        com.mobile.brasiltv.utils.b0.b0(this, CastByNativeDeviceAty.class, t.f11131a);
                    }
                    androidx.fragment.app.e activity3 = getActivity();
                    t9.i.d(activity3);
                    i1.g(activity3, "EVENT_CAST_LIVE_CLICK");
                }
            }
        } else if (!this.f4488v) {
            C5();
        } else {
            int i12 = R$id.mFlLocked;
            if (((AutoFrameLayout) x3(i12)).getVisibility() == 0) {
                Disposable disposable = this.f4486t;
                if (disposable != null) {
                    disposable.dispose();
                }
                ((AutoFrameLayout) x3(i12)).setVisibility(8);
                return;
            }
            N4();
            ((AutoFrameLayout) x3(i12)).setVisibility(0);
        }
    }

    public void onCompletion() {
    }

    public void onConfigurationChanged(Configuration configuration) {
        t9.i.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (getUserVisibleHint() || configuration.orientation != 2) {
            CommonDialog commonDialog = this.f4483q;
            if (commonDialog != null) {
                commonDialog.dismiss();
            }
            PopupWindow popupWindow = this.f4469h0;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
            if (configuration.orientation == 1) {
                this.f4484r = false;
                Disposable disposable = this.f4486t;
                if (disposable != null) {
                    disposable.dispose();
                }
                ((AutoFrameLayout) x3(R$id.mFlLocked)).setVisibility(8);
                V3(-1, s0.a(getContext(), 203.0f), -1, s0.a(getContext(), 203.0f));
                xa.c c10 = xa.c.c();
                String f10 = z.f4508u.f();
                t9.i.d(f10);
                c10.j(new UpdateHighLightEvent(f10));
                ((AutoHideRelativeLayout) x3(R$id.mLiveControlPanelLandscape)).setVisibility(8);
                this.f4488v = false;
                W3(this.f4484r);
                ((AnimatorFrameLayout) x3(R$id.mLayoutChannelList)).setVisibility(8);
                E5();
                return;
            }
            this.f4484r = true;
            z5();
            Channel channel = this.f4474k;
            if (channel != null) {
                y5(d6.a.f16338a.g(channel), channel.getChannelCode(), false);
            }
            V3(-1, -1, -1, -1);
            ((AutoHideRelativeLayout) x3(R$id.mLiveControlPanelPortrait)).setVisibility(8);
            W3(this.f4484r);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t9.i.g(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_live_play, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        xa.c.c().r(this);
        M5(Boolean.FALSE);
        if (this.f4471i0 != null) {
            b8.b.b(p4(), false, 1, (Object) null);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        W2(false);
        ((TitanVideoView) x3(R$id.mVideoViewLive)).D();
        if (com.mobile.brasiltv.utils.h.f12562a.t()) {
            com.mobile.brasiltv.utils.g.f12519a.G();
        }
        G4();
        X2();
    }

    public void onVisibility(int i10, View view) {
        if (i10 == 0) {
            ((AutoHideRelativeLayout) x3(R$id.mLiveControlPanelLandscape)).setVisibility(8);
            if (!t9.i.b((AnimatorFrameLayout) x3(R$id.mLayoutChannelList), view)) {
                int i11 = R$id.mLiveControl;
                ((AutoRelativeLayout) x3(i11)).setBackgroundColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
                ((AutoRelativeLayout) x3(i11)).setAlpha(0.75f);
                return;
            }
            return;
        }
        int i12 = R$id.mLiveControl;
        ((AutoRelativeLayout) x3(i12)).setBackgroundColor(0);
        ((AutoRelativeLayout) x3(i12)).setAlpha(1.0f);
    }

    public void p1() {
    }

    public final b8.b p4() {
        b8.b bVar = this.f4471i0;
        if (bVar != null) {
            return bVar;
        }
        t9.i.w("mVoiceHelper");
        return null;
    }

    public void q0(Status status) {
        t9.i.g(status, Constant.KEY_STATUS);
        String play_url = status.getPlay_url();
        t9.i.f(play_url, "status.play_url");
        this.F = play_url;
        this.Q = status.isUrl_modified();
        this.S = status.getHost();
        if (this.M != null) {
            this.M = "";
        }
        this.O = true;
        ((TitanVideoView) x3(R$id.mVideoViewLive)).C();
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new e1(this));
        }
    }

    public final MediaMetadata q4() {
        MediaMetadata mediaMetadata = new MediaMetadata(1);
        Channel channel = this.f4474k;
        t9.i.d(channel);
        String alias = channel.getAlias();
        Channel channel2 = this.f4474k;
        t9.i.d(channel2);
        mediaMetadata.putString(MediaMetadata.KEY_TITLE, com.mobile.brasiltv.utils.b0.e(alias, channel2.getName()));
        mediaMetadata.putString(MediaMetadata.KEY_SUBTITLE, "");
        Channel channel3 = this.f4474k;
        t9.i.d(channel3);
        if (com.mobile.brasiltv.utils.b0.H(channel3.getPosterUrl())) {
            Channel channel4 = this.f4474k;
            t9.i.d(channel4);
            mediaMetadata.addImage(new WebImage(Uri.parse(channel4.getPosterUrl())));
        }
        return mediaMetadata;
    }

    public final void q5() {
        View view;
        Window window;
        androidx.fragment.app.e activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            view = null;
        } else {
            view = window.getDecorView();
        }
        if (view != null) {
            view.setSystemUiVisibility(0);
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 != null) {
            n5.a.f8310a.h(activity2);
        }
    }

    public void r1(long j10) {
    }

    public final float r4() {
        boolean z10;
        androidx.fragment.app.e activity = getActivity();
        t9.i.d(activity);
        int i10 = 0;
        if (activity.getWindow().getAttributes().screenBrightness == -1.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            try {
                androidx.fragment.app.e activity2 = getActivity();
                t9.i.d(activity2);
                i10 = Settings.System.getInt(activity2.getContentResolver(), "screen_brightness");
            } catch (Settings.SettingNotFoundException e10) {
                e10.printStackTrace();
            }
            Resources system = Resources.getSystem();
            return ((float) i10) / ((float) system.getInteger(system.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android")));
        }
        androidx.fragment.app.e activity3 = getActivity();
        t9.i.d(activity3);
        return activity3.getWindow().getAttributes().screenBrightness;
    }

    public final void r5(boolean z10) {
        int i10;
        s6.a aVar = s6.a.f9335a;
        if (aVar.a().p() && aVar.a().o()) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            ((ImageView) x3(R$id.mIconCast)).setVisibility(i10);
            ((ImageView) x3(R$id.mIconCastPort)).setVisibility(i10);
        }
    }

    @xa.j
    public final void readyForPlay(UpdateChannelEvent updateChannelEvent) {
        int i10;
        t9.i.g(updateChannelEvent, "event");
        int position = updateChannelEvent.getPosition();
        Object clone = updateChannelEvent.getListChannel().clone();
        t9.i.e(clone, "null cannot be cast to non-null type java.util.ArrayList<mobile.com.requestframe.utils.response.Channel>{ kotlin.collections.TypeAliasesKt.ArrayList<mobile.com.requestframe.utils.response.Channel> }");
        ArrayList arrayList = (ArrayList) clone;
        Object obj = arrayList.get(position);
        t9.i.f(obj, "listChannel[position]");
        Channel channel = (Channel) obj;
        this.E = updateChannelEvent.getTdcFrom();
        this.W = this.f4474k;
        this.X = updateChannelEvent.getPreviousColumnIndex();
        boolean z10 = false;
        r5(false);
        D5(8);
        x5(false);
        ((AutoLinearLayout) x3(R$id.mLayoutMobileNotify)).setVisibility(8);
        ChildColumnList e10 = z.f4508u.e();
        if (e10 != null) {
            i10 = e10.getId();
        } else {
            i10 = 0;
        }
        if (i10 == updateChannelEvent.getCategoryCode()) {
            z10 = true;
        }
        W4(channel, z10);
        V4(arrayList, position);
    }

    @xa.j
    public final void readyForPlayFav(ReadyPlayFavEvent readyPlayFavEvent) {
        t9.i.g(readyPlayFavEvent, "event");
        int position = readyPlayFavEvent.getPosition();
        ArrayList<Channel> listChannel = readyPlayFavEvent.getListChannel();
        Channel channel = listChannel.get(position);
        t9.i.f(channel, "listChannel[position]");
        Channel channel2 = channel;
        z.a aVar = z.f4508u;
        if (aVar.b().get(channel2.getChannelCode()) != null) {
            Object obj = aVar.b().get(channel2.getChannelCode());
            t9.i.d(obj);
            channel2 = (Channel) obj;
        }
        this.E = "fav";
        this.W = this.f4474k;
        this.X = readyPlayFavEvent.getPreviousColumnIndex();
        ((AutoLinearLayout) x3(R$id.mLayoutMobileNotify)).setVisibility(8);
        ((RelativeLayout) x3(R$id.mBufferView)).setVisibility(0);
        D5(8);
        W4(channel2, false);
        V4(listChannel, position);
    }

    @xa.j
    public final void refreshEPGMessage(RefreshEPGEvent refreshEPGEvent) {
        t9.i.g(refreshEPGEvent, "event");
        Channel channel = this.f4474k;
        if (channel != null) {
            r0.a aVar = r0.A;
            if (aVar.d().containsKey(channel.getChannelCode())) {
                Object obj = aVar.d().get(channel.getChannelCode());
                t9.i.d(obj);
                ((TextView) x3(R$id.tvProgramName)).setText(((EpgResultData) obj).getTitle());
            }
        }
    }

    public String s4() {
        String simpleName = r1.class.getSimpleName();
        t9.i.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void s5(int i10, String str) {
        t9.i.g(str, "extra");
        xa.c.c().j(new CastToCloseFloatViewEvent());
        if (com.mobile.brasiltv.utils.b0.K(str)) {
            ((TextView) x3(R$id.mTvCastRecommendHint)).setVisibility(8);
            int i11 = R$id.mTvCastErrorHint;
            ((TextView) x3(i11)).setText(str);
            ((TextView) x3(i11)).setVisibility(0);
        } else {
            ((TextView) x3(R$id.mTvCastRecommendHint)).setVisibility(0);
            ((TextView) x3(R$id.mTvCastErrorHint)).setVisibility(8);
        }
        int i12 = R$id.mTvCastState;
        Context context = getContext();
        t9.i.d(context);
        ((TextView) x3(i12)).setText(context.getResources().getString(R.string.cast_status_casting_failed));
        StringBuilder sb = new StringBuilder();
        sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
        sb.append(i10);
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        ((TextView) x3(i12)).append(sb.toString());
        Context context2 = getContext();
        t9.i.d(context2);
        ((TextView) x3(i12)).setTextColor(context2.getResources().getColor(R.color.color_f72f2f));
        ((TextView) x3(R$id.mTvPleaseWait)).setVisibility(8);
    }

    @xa.j
    public final void showNoNetNotify(NetworkEvent networkEvent) {
        t9.i.g(networkEvent, "event");
        if (NetworkEvent.NetState.NO_NET == networkEvent.getMState() && isVisible() && ((TitanVideoView) x3(R$id.mVideoViewLive)).s()) {
            f1.f12517a.t(R.string.net_remind_net_break);
        } else if (this.f4476l && isVisible() && isResumed()) {
            TitanVideoView titanVideoView = (TitanVideoView) x3(R$id.mVideoViewLive);
            t9.i.d(titanVideoView);
            titanVideoView.post(new v0(this));
        }
    }

    public void t0() {
    }

    public final void t4(Channel channel, int i10, boolean z10) {
        String str;
        int i11;
        String channelCode = channel.getChannelCode();
        Channel channel2 = this.f4474k;
        j0 j0Var = null;
        if (channel2 != null) {
            str = channel2.getChannelCode();
        } else {
            str = null;
        }
        if (!t9.i.b(channelCode, str)) {
            this.W = this.f4474k;
            n0 n0Var = n0.f12601a;
            androidx.fragment.app.e activity = getActivity();
            t9.i.d(activity);
            boolean z11 = false;
            this.X = n0Var.d(activity, "live_last_play_column_index", 0);
            androidx.fragment.app.e activity2 = getActivity();
            t9.i.d(activity2);
            n0Var.i(activity2, "live_last_play_column_index", this.f4468h - 1);
            i.c cVar = w6.i.f9510g;
            if (t9.i.b(cVar.e(), "1") && (t9.i.b(cVar.I(), "1") || t9.i.b(cVar.I(), "2"))) {
                androidx.fragment.app.e activity3 = getActivity();
                t9.i.d(activity3);
                n0Var.g(activity3, "live_first_play_free_column", false);
            }
            ((AutoLinearLayout) x3(R$id.mLayoutMobileNotify)).setVisibility(8);
            f4();
            r5(false);
            D5(8);
            x5(false);
            if (z10) {
                String channelCode2 = channel.getChannelCode();
                j0 j0Var2 = this.f4478m;
                if (j0Var2 == null) {
                    t9.i.w("adapterChannel");
                } else {
                    j0Var = j0Var2;
                }
                List data = j0Var.getData();
                t9.i.e(data, "null cannot be cast to non-null type java.util.ArrayList<mobile.com.requestframe.utils.response.Channel>{ kotlin.collections.TypeAliasesKt.ArrayList<mobile.com.requestframe.utils.response.Channel> }");
                k4(this, channelCode2, (ArrayList) data, false, 4, (Object) null);
            } else {
                j0 j0Var3 = this.f4478m;
                if (j0Var3 == null) {
                    t9.i.w("adapterChannel");
                } else {
                    j0Var = j0Var3;
                }
                j0Var.c(i10);
            }
            z.a aVar = z.f4508u;
            ChildColumnList e10 = aVar.e();
            if (e10 != null) {
                i11 = e10.getId();
            } else {
                i11 = 0;
            }
            if (i11 == this.f4470i) {
                z11 = true;
            }
            String str2 = "";
            if (com.mobile.brasiltv.utils.b0.I(aVar.d())) {
                ArrayList d10 = aVar.d();
                t9.i.d(d10);
                int size = d10.size();
                int i12 = this.f4468h;
                if (size > i12 - 1) {
                    if (i12 == 0) {
                        str2 = "fav";
                    } else {
                        ArrayList d11 = aVar.d();
                        t9.i.d(d11);
                        String alias = ((ChildColumnList) d11.get(this.f4468h - 1)).getAlias();
                        if (alias != null) {
                            str2 = alias;
                        }
                    }
                }
            }
            this.E = str2;
            W4(channel, z11);
        }
    }

    public final void t5(boolean z10, boolean z11) {
        String str;
        String str2;
        if (getActivity() != null) {
            if (z11) {
                androidx.fragment.app.e activity = getActivity();
                t9.i.d(activity);
                String string = getString(R.string.package_premium_cast_plan_tips);
                t9.i.f(string, "getString(R.string.package_premium_cast_plan_tips)");
                new CommTipsDialog(activity, string, getString(R.string.cast_service_plan), getString(R.string.cast_purchase), (String) null, (String) null, new z(this), (s9.l) null, false, 256, (t9.g) null).show();
                return;
            }
            if (z10) {
                str = getString(R.string.package_premium_service_plan_tips);
            } else {
                str = getString(R.string.cast_service_plan_tips);
            }
            String str3 = str;
            t9.i.f(str3, "if (isFHD) {\n           …_plan_tips)\n            }");
            boolean p10 = s6.a.f9335a.a().p();
            androidx.fragment.app.e activity2 = getActivity();
            t9.i.d(activity2);
            String string2 = getString(R.string.cast_service_plan);
            String string3 = getString(R.string.cast_purchase);
            String str4 = null;
            if (p10) {
                str2 = getString(R.string.try_epurchasing);
            } else {
                str2 = null;
            }
            if (p10) {
                str4 = getString(R.string.cast_service_tips);
            }
            new CommTipsDialog(activity2, str3, string2, string3, str2, str4, new a0(this), new b0(p10, this), false, 256, (t9.g) null).show();
        }
    }

    public void u(int i10) {
        Context context = getContext();
        if (context != null) {
            com.mobile.brasiltv.utils.x.f12622a.w(context, new d0(context, i10, this));
        }
    }

    @xa.j
    public final void updateFavStatus(UpdateFavStatusEvent updateFavStatusEvent) {
        t9.i.g(updateFavStatusEvent, "event");
        y5(updateFavStatusEvent.isFav(), updateFavStatusEvent.getChannelCode(), true);
    }

    @xa.j
    public final void updateFullScreenSort(UpdateFullScreenSortEvent updateFullScreenSortEvent) {
        boolean z10;
        t9.i.g(updateFullScreenSortEvent, "event");
        this.f4464f.clear();
        this.f4466g.clear();
        z.a aVar = z.f4508u;
        if (com.mobile.brasiltv.utils.b0.I(aVar.d())) {
            ArrayList<ChildColumnList> d10 = aVar.d();
            t9.i.d(d10);
            for (ChildColumnList childColumnList : d10) {
                this.f4464f.add(Integer.valueOf(childColumnList.getId()));
                if (!com.mobile.brasiltv.utils.f0.b()) {
                    String alias = childColumnList.getAlias();
                    if (alias == null || alias.length() == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10) {
                        ArrayList arrayList = this.f4466g;
                        String alias2 = childColumnList.getAlias();
                        t9.i.d(alias2);
                        arrayList.add(alias2);
                    }
                }
                this.f4466g.add(childColumnList.getName());
            }
        }
        ArrayList arrayList2 = this.f4466g;
        Context context = getContext();
        t9.i.d(context);
        arrayList2.add(0, context.getResources().getString(R.string.live_fav));
        o0 o0Var = this.f4480n;
        o0 o0Var2 = null;
        if (o0Var == null) {
            t9.i.w("adapterSort");
            o0Var = null;
        }
        o0Var.getData().clear();
        o0 o0Var3 = this.f4480n;
        if (o0Var3 == null) {
            t9.i.w("adapterSort");
            o0Var3 = null;
        }
        o0Var3.getData().addAll(this.f4466g);
        o0 o0Var4 = this.f4480n;
        if (o0Var4 == null) {
            t9.i.w("adapterSort");
        } else {
            o0Var2 = o0Var4;
        }
        o0Var2.notifyDataSetChanged();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9  */
    @xa.j(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateRestrict(com.mobile.brasiltv.bean.event.UpdateRestrictEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "event"
            t9.i.g(r5, r0)
            w6.i$c r0 = w6.i.f9510g
            java.lang.String r0 = r0.e()
            java.lang.String r1 = "1"
            boolean r0 = t9.i.b(r0, r1)
            if (r0 == 0) goto L_0x00ee
            b6.z$a r0 = b6.z.f4508u
            java.util.ArrayList r1 = r0.d()
            if (r1 == 0) goto L_0x00ee
            boolean r1 = com.mobile.brasiltv.utils.f0.b()
            if (r1 != 0) goto L_0x0049
            mobile.com.requestframe.utils.response.ChildColumnList r1 = r0.a()
            t9.i.d(r1)
            java.lang.String r1 = r1.getAlias()
            if (r1 == 0) goto L_0x0037
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r1 = 0
            goto L_0x0038
        L_0x0037:
            r1 = 1
        L_0x0038:
            if (r1 != 0) goto L_0x0049
            mobile.com.requestframe.utils.response.ChildColumnList r1 = r0.a()
            t9.i.d(r1)
            java.lang.String r1 = r1.getAlias()
            t9.i.d(r1)
            goto L_0x0054
        L_0x0049:
            mobile.com.requestframe.utils.response.ChildColumnList r1 = r0.a()
            t9.i.d(r1)
            java.lang.String r1 = r1.getName()
        L_0x0054:
            java.lang.String r5 = r5.getStatus()
            java.lang.String r2 = "0"
            boolean r5 = t9.i.b(r5, r2)
            r2 = 0
            java.lang.String r3 = "adapterSort"
            if (r5 == 0) goto L_0x00a9
            java.util.ArrayList r5 = r4.f4466g
            r5.remove(r1)
            java.util.ArrayList r5 = r4.f4464f
            mobile.com.requestframe.utils.response.ChildColumnList r0 = r0.a()
            t9.i.d(r0)
            int r0 = r0.getId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5.remove(r0)
            g5.o0 r5 = r4.f4480n
            if (r5 != 0) goto L_0x0084
            t9.i.w(r3)
            r5 = r2
        L_0x0084:
            java.util.List r5 = r5.getData()
            r5.clear()
            g5.o0 r5 = r4.f4480n
            if (r5 != 0) goto L_0x0093
            t9.i.w(r3)
            r5 = r2
        L_0x0093:
            java.util.List r5 = r5.getData()
            java.util.ArrayList r0 = r4.f4466g
            r5.addAll(r0)
            g5.o0 r5 = r4.f4480n
            if (r5 != 0) goto L_0x00a4
            t9.i.w(r3)
            goto L_0x00a5
        L_0x00a4:
            r2 = r5
        L_0x00a5:
            r2.notifyDataSetChanged()
            goto L_0x00ee
        L_0x00a9:
            java.util.ArrayList r5 = r4.f4466g
            r5.add(r1)
            java.util.ArrayList r5 = r4.f4464f
            mobile.com.requestframe.utils.response.ChildColumnList r0 = r0.a()
            t9.i.d(r0)
            int r0 = r0.getId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5.add(r0)
            g5.o0 r5 = r4.f4480n
            if (r5 != 0) goto L_0x00ca
            t9.i.w(r3)
            r5 = r2
        L_0x00ca:
            java.util.List r5 = r5.getData()
            r5.clear()
            g5.o0 r5 = r4.f4480n
            if (r5 != 0) goto L_0x00d9
            t9.i.w(r3)
            r5 = r2
        L_0x00d9:
            java.util.List r5 = r5.getData()
            java.util.ArrayList r0 = r4.f4466g
            r5.addAll(r0)
            g5.o0 r5 = r4.f4480n
            if (r5 != 0) goto L_0x00ea
            t9.i.w(r3)
            goto L_0x00eb
        L_0x00ea:
            r2 = r5
        L_0x00eb:
            r2.notifyDataSetChanged()
        L_0x00ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.r1.updateRestrict(com.mobile.brasiltv.bean.event.UpdateRestrictEvent):void");
    }

    @xa.j
    public final void userIdentityChange(UserIdentityChangeEvent userIdentityChangeEvent) {
        t9.i.g(userIdentityChangeEvent, "event");
        l6.g0 g0Var = null;
        if (t9.i.b(w6.i.f9510g.I(), "1")) {
            l6.g0 g0Var2 = this.f4490x;
            if (g0Var2 == null) {
                t9.i.w("mLivePlayPresenter");
                g0Var2 = null;
            }
            g0Var2.w().clear();
        } else {
            l6.g0 g0Var3 = this.f4490x;
            if (g0Var3 == null) {
                t9.i.w("mLivePlayPresenter");
                g0Var3 = null;
            }
            g0Var3.u();
        }
        this.W = null;
        this.f4474k = null;
        l6.g0 g0Var4 = this.f4490x;
        if (g0Var4 == null) {
            t9.i.w("mLivePlayPresenter");
        } else {
            g0Var = g0Var4;
        }
        g0Var.s();
        f5();
    }

    public final void v4(Channel channel, int i10) {
        d6.a aVar = d6.a.f16338a;
        if (!aVar.l(channel.getChannelCode())) {
            aVar.f(channel.getChannelCode());
            j0 j0Var = this.f4478m;
            if (j0Var == null) {
                t9.i.w("adapterChannel");
                j0Var = null;
            }
            j0Var.e(channel.getChannelCode(), i10);
            aVar.h(channel);
        }
    }

    public final void v5() {
        if (getActivity() != null) {
            androidx.fragment.app.e activity = getActivity();
            t9.i.d(activity);
            String string = getString(R.string.cast_wifi_not_connect_tips);
            t9.i.f(string, "getString(R.string.cast_wifi_not_connect_tips)");
            new CommTipsDialog(activity, string, getString(R.string.cast), getString(R.string.cast_wifi_setting), (String) null, (String) null, new c0(this), (s9.l) null, false, 432, (t9.g) null).show();
        }
    }

    public boolean w1() {
        return false;
    }

    public final void w4() {
        int i10 = R$id.mLayoutChannelList;
        if (((AnimatorFrameLayout) x3(i10)).getVisibility() == 0) {
            ((AnimatorFrameLayout) x3(i10)).setVisibility(8);
            return;
        }
        q5.j jVar = f4462o0;
        if (jVar != null) {
            jVar.g();
        }
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            com.mobile.brasiltv.utils.b0.N(activity);
        }
    }

    public final void w5() {
        f4();
        int i10 = R$id.mLayoutChannelList;
        if (((AnimatorFrameLayout) x3(i10)).getVisibility() == 0) {
            F4();
            return;
        }
        o0 o0Var = this.f4480n;
        if (o0Var == null) {
            t9.i.w("adapterSort");
            o0Var = null;
        }
        if (o0Var.getData().size() != 0) {
            ((AnimatorFrameLayout) x3(i10)).setVisibility(0);
            n0 n0Var = n0.f12601a;
            Context context = getContext();
            t9.i.d(context);
            int d10 = n0Var.d(context, "live_last_play_column_index", 0);
            if (d10 == -1) {
                ((KoocanRecyclerView) x3(R$id.mRecyclerSort)).scrollToPosition(0);
            } else {
                ((KoocanRecyclerView) x3(R$id.mRecyclerSort)).scrollToPosition(d10 + 1);
            }
            C4("", d10 + 1, true);
        }
    }

    public View x3(int i10) {
        View findViewById;
        Map map = this.f4479m0;
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

    public final void x4(int i10) {
        if (i10 == 3) {
            int i11 = R$id.mTvCastState;
            Context context = getContext();
            t9.i.d(context);
            ((TextView) x3(i11)).setText(context.getResources().getString(R.string.cast_status_casting));
            Context context2 = getContext();
            t9.i.d(context2);
            ((TextView) x3(i11)).setTextColor(context2.getResources().getColor(R.color.color_fffefe));
            ((TextView) x3(R$id.mTvPleaseWait)).setVisibility(8);
            ((TextView) x3(R$id.mTvCastRecommendHint)).setVisibility(4);
            c5();
        } else if (i10 == 4) {
            int i12 = R$id.mTvCastState;
            Context context3 = getContext();
            t9.i.d(context3);
            ((TextView) x3(i12)).setText(context3.getResources().getString(R.string.cast_status_casting_failed));
            ((TextView) x3(i12)).append("(4)");
            Context context4 = getContext();
            t9.i.d(context4);
            ((TextView) x3(i12)).setTextColor(context4.getResources().getColor(R.color.color_f72f2f));
            ((TextView) x3(R$id.mTvPleaseWait)).setVisibility(8);
            ((TextView) x3(R$id.mTvCastRecommendHint)).setVisibility(0);
            X4();
        }
    }

    public final void x5(boolean z10) {
        String str;
        if (z10) {
            Channel channel = this.f4474k;
            if (channel != null) {
                str = channel.getRestricted();
            } else {
                str = null;
            }
            if (t9.i.b(str, "0")) {
                ((ImageView) x3(R$id.mIconSave)).setVisibility(0);
                ((ImageView) x3(R$id.mIvFavPort)).setVisibility(0);
                this.Z = z10;
                z5();
            }
        }
        ((ImageView) x3(R$id.mIconSave)).setVisibility(8);
        ((ImageView) x3(R$id.mIvFavPort)).setVisibility(8);
        this.Z = z10;
        z5();
    }

    public final void y4() {
        Program program;
        Channel channel;
        CharSequence text = ((TextView) x3(R$id.mTextToDo)).getText();
        boolean z10 = true;
        if (t9.i.b(text, getResources().getString(R.string.click_continue))) {
            ((AutoLinearLayout) x3(R$id.mLayoutMobileNotify)).setVisibility(8);
            this.f4476l = true;
            n8.b titanContext = ((TitanVideoView) x3(R$id.mVideoViewLive)).getTitanContext();
            l6.g0 g0Var = null;
            if (titanContext != null) {
                program = titanContext.h();
            } else {
                program = null;
            }
            if (r5.i.f19378a.I() && (channel = this.f4474k) != null && program == null) {
                t9.i.d(channel);
                l6.g0 g0Var2 = this.f4490x;
                if (g0Var2 == null) {
                    t9.i.w("mLivePlayPresenter");
                } else {
                    g0Var = g0Var2;
                }
                W4(channel, g0Var.y());
            }
        } else if (t9.i.b(text, getResources().getString(R.string.login))) {
            com.mobile.brasiltv.utils.b0.a0(this, LoginAty.class);
        } else if (t9.i.b(text, getResources().getString(R.string.bind_now))) {
            com.mobile.brasiltv.utils.b0.a0(this, AccountBindAty.class);
        } else if (t9.i.b(text, getResources().getString(R.string.be_a_vip))) {
            i.c cVar = w6.i.f9510g;
            if (cVar.g().length() <= 0) {
                z10 = false;
            }
            if (z10) {
                com.mobile.brasiltv.utils.b0.k0(this, cVar.g(), false, true, false, 8, (Object) null);
            }
        }
    }

    public final void y5(boolean z10, String str, boolean z11) {
        Channel channel = this.f4474k;
        if (channel != null) {
            t9.i.d(channel);
            if (t9.i.b(channel.getChannelCode(), str)) {
                this.f4491y = z10;
                if (z10) {
                    int i10 = R$id.mIconSave;
                    ((ImageView) x3(i10)).setVisibility(0);
                    int i11 = R$id.mIvFavPort;
                    ((ImageView) x3(i11)).setVisibility(0);
                    ((ImageView) x3(i10)).setImageResource(R.drawable.ic_live_fav);
                    ((ImageView) x3(i11)).setImageResource(R.drawable.ic_live_fav);
                    if (z11) {
                        Context context = getContext();
                        Context context2 = getContext();
                        t9.i.d(context2);
                        Context b10 = com.mobile.brasiltv.utils.b.b(context, new com.mobile.brasiltv.utils.c(context2).c());
                        f1.a aVar = f1.f12517a;
                        String string = b10.getString(R.string.add_fav_success);
                        t9.i.f(string, "ctx.getString(R.string.add_fav_success)");
                        aVar.x(string);
                    }
                } else {
                    ((ImageView) x3(R$id.mIconSave)).setImageResource(R.drawable.ic_live_not_fav);
                    ((ImageView) x3(R$id.mIvFavPort)).setImageResource(R.drawable.ic_live_not_fav);
                }
            }
        }
        if (!z10 && this.f4468h == 0) {
            R5();
        }
    }

    public void z() {
        r5(true);
        if (!this.f4489w || !isResumed()) {
            com.mobile.brasiltv.utils.b0.U(this, "live info video rendering start, but not visible, stop");
            ((TitanVideoView) x3(R$id.mVideoViewLive)).D();
        } else {
            com.mobile.brasiltv.utils.b0.U(this, "live info video rendering start, start");
            ((RelativeLayout) x3(R$id.mBufferView)).setVisibility(8);
            b4();
        }
        O5();
    }

    public void z0(String str) {
        t9.i.g(str, "toastMsg");
        f1.f12517a.x(str);
    }

    public final void z4() {
        this.f4489w = false;
        if (Q2()) {
            U2();
            ((TitanVideoView) x3(R$id.mVideoViewLive)).D();
            Disposable disposable = this.f4486t;
            if (disposable != null) {
                disposable.dispose();
            }
            Disposable disposable2 = this.f4485s;
            if (disposable2 != null) {
                disposable2.dispose();
            }
        }
    }

    public final void z5() {
        if (this.f4484r && this.Z && !this.f4465f0) {
            this.f4465f0 = true;
            ((ImageView) x3(R$id.mImageLandFeedback)).postDelayed(new t0(this), 20);
        }
    }
}
