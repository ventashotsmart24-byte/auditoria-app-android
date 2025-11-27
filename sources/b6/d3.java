package b6;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.e;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.MsgBoxAty;
import com.mobile.brasiltv.activity.MyFavListActivity;
import com.mobile.brasiltv.activity.RecordsAty;
import com.mobile.brasiltv.activity.SubtitleAty;
import com.mobile.brasiltv.bean.BaseGuideManager;
import com.mobile.brasiltv.bean.event.HasNewUpdateEvent;
import com.mobile.brasiltv.bean.event.UpdateMineViewEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.db.Album;
import com.mobile.brasiltv.mine.activity.AccountAty;
import com.mobile.brasiltv.mine.activity.AccountBindAty;
import com.mobile.brasiltv.mine.activity.SettingAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.view.LoadingDialog;
import com.mobile.brasiltv.view.dialog.BindEmailOrPhoneNotification;
import com.mobile.brasiltv.view.dialog.CommTipsDialog;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.mobile.brasiltv.view.dialog.GuideDialog;
import com.mobile.brasiltv.view.dialog.RestrictOpenTipsDialog;
import com.mobile.brasiltv.view.dialog.StandardDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import g5.z0;
import h9.g;
import h9.h;
import h9.t;
import j6.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k7.f;
import l6.m1;
import org.greenrobot.eventbus.ThreadMode;
import s9.l;
import t9.j;
import t9.z;
import w6.i;

public final class d3 extends e<m1> implements i {

    /* renamed from: i  reason: collision with root package name */
    public boolean f4383i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4384j;

    /* renamed from: k  reason: collision with root package name */
    public m1 f4385k;

    /* renamed from: l  reason: collision with root package name */
    public final g f4386l = h.b(new a(this));

    /* renamed from: m  reason: collision with root package name */
    public StandardDialog f4387m;

    /* renamed from: n  reason: collision with root package name */
    public RestrictOpenTipsDialog f4388n;

    /* renamed from: o  reason: collision with root package name */
    public final g f4389o = h.b(new d(this));

    /* renamed from: p  reason: collision with root package name */
    public boolean f4390p = true;

    /* renamed from: q  reason: collision with root package name */
    public Map f4391q = new LinkedHashMap();

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d3 f10943a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d3 d3Var) {
            super(0);
            this.f10943a = d3Var;
        }

        public final Integer invoke() {
            return Integer.valueOf(n5.a.f8310a.a(this.f10943a.getActivity()));
        }
    }

    public static final class b implements z0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d3 f10944a;

        public b(d3 d3Var) {
            this.f10944a = d3Var;
        }

        public void a(Album album, int i10) {
            t9.i.g(album, "album");
            e activity = this.f10944a.getActivity();
            t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
            b0.q((f5.c) activity, album, "history");
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f10945a = new c();

        public c() {
            super(1);
        }

        public final void b(CommTipsDialog commTipsDialog) {
            t9.i.g(commTipsDialog, "it");
            commTipsDialog.dismiss();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((CommTipsDialog) obj);
            return t.f17319a;
        }
    }

    public static final class d extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d3 f10946a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(d3 d3Var) {
            super(0);
            this.f10946a = d3Var;
        }

        /* renamed from: b */
        public final z0 invoke() {
            Context requireContext = this.f10946a.requireContext();
            t9.i.f(requireContext, "requireContext()");
            return new z0(requireContext, new ArrayList());
        }
    }

    public static final void A3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        b0.a0(d3Var, SubtitleAty.class);
    }

    public static final void B3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        i1.I(d3Var.getContext(), "personal");
        b0.k0(d3Var, w6.i.f9510g.C() + "/#/shareApp", false, true, false, 8, (Object) null);
    }

    public static final void C3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        b0.a0(d3Var, MyFavListActivity.class);
    }

    public static final void D3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        b0.a0(d3Var, RecordsAty.class);
    }

    public static final void E3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        b0.a0(d3Var, AccountAty.class);
    }

    public static final void F3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        b0.a0(d3Var, AccountAty.class);
    }

    public static final void G3(d3 d3Var, View view) {
        d3 d3Var2 = d3Var;
        t9.i.g(d3Var2, "this$0");
        if (t9.i.b(w6.i.f9510g.A(), "0")) {
            d6.b bVar = d6.b.f6366a;
            if (!bVar.a() || (bVar.c() && !bVar.b())) {
                Context context = d3Var.getContext();
                if (context != null) {
                    new BindEmailOrPhoneNotification(context).show();
                    return;
                }
                return;
            }
            Context context2 = d3Var.getContext();
            t9.i.d(context2);
            new g6.g(context2).show();
            return;
        }
        xa.c.c().m(new UpdateRestrictEvent("0", false, 2, (t9.g) null));
        e activity = d3Var.getActivity();
        t9.i.d(activity);
        String string = d3Var2.getString(R.string.cr_content_blocked);
        t9.i.f(string, "getString(R.string.cr_content_blocked)");
        new CommTipsDialog(activity, string, (String) null, d3Var2.getString(R.string.i_see), (String) null, (String) null, c.f10945a, (l) null, false, 180, (t9.g) null).show();
        d3Var.a3().v();
        MainAty.A.o(true);
    }

    public static final void H3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        i.c cVar = w6.i.f9510g;
        boolean b10 = t9.i.b(cVar.e(), "0");
        b0.k0(d3Var, b0.x(m7.c.g()) + "/#/app-help?isFree=" + b10 + "&appId=" + na.a.g() + "&userId=" + cVar.H() + "&lang=" + f0.a() + "&appVersion=" + na.a.b() + "&timestamp=" + new Date().getTime() + "&portalCode=" + cVar.v(), false, true, false, 8, (Object) null);
    }

    public static final void I3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        b0.a0(d3Var, SettingAty.class);
    }

    public static final void K3(d3 d3Var) {
        t9.i.g(d3Var, "this$0");
        if (!DialogManager.INSTANCE.isDialogShowing()) {
            String string = d3Var.getString(R.string.guide_mine_block_des);
            t9.i.f(string, "getString(R.string.guide_mine_block_des)");
            new BaseGuideManager(d3Var.getContext(), (ImageView) d3Var.t3(R$id.mIvAdultContent), "keyFirstMineOnCharge", string, GuideDialog.Direction.TOP_RIGHT, (String) null, false, false, (String) null, 480, (t9.g) null).showGuide();
        }
    }

    public static final void N3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        StandardDialog standardDialog = d3Var.f4387m;
        if (standardDialog != null) {
            b0.j(standardDialog);
        }
    }

    public static final void O3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        StandardDialog standardDialog = d3Var.f4387m;
        if (standardDialog != null) {
            b0.j(standardDialog);
        }
        d3Var.startActivity(new Intent(d3Var.getActivity(), AccountBindAty.class));
    }

    public static final void y3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        b0.a0(d3Var, RecordsAty.class);
    }

    public static final void z3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        b0.a0(d3Var, MsgBoxAty.class);
    }

    public void A2(int i10) {
        String str;
        int i11 = R$id.mTvMsgCount;
        ((TextView) t3(i11)).setVisibility(0);
        TextView textView = (TextView) t3(i11);
        if (i10 >= 100) {
            str = "99+";
        } else {
            str = String.valueOf(i10);
        }
        textView.setText(str);
    }

    public void F(List list) {
        t9.i.g(list, "list");
        ((RecyclerView) t3(R$id.mRvContent)).setVisibility(0);
        ((AutoRelativeLayout) t3(R$id.mRlHistoryList)).setVisibility(0);
        u3().b(list);
    }

    public final void J3() {
        L3();
        x3();
    }

    public final void L3() {
        R3();
        i.c cVar = w6.i.f9510g;
        if (TextUtils.isEmpty(cVar.q())) {
            ((ImageView) t3(R$id.mImageAvatar)).setImageResource(R.drawable.icon_mine_avatar_new);
        } else {
            a7.e eVar = a7.e.f10706a;
            Context context = getContext();
            t9.i.d(context);
            String q10 = cVar.q();
            ImageView imageView = (ImageView) t3(R$id.mImageAvatar);
            t9.i.f(imageView, "mImageAvatar");
            eVar.b(context, q10, imageView, R.drawable.icon_mine_avatar_new);
        }
        if (!this.f4383i) {
            S3();
        }
        W3();
        P3();
        ((ImageView) t3(R$id.mIvAdultContent)).setSelected(!t9.i.b(cVar.A(), "0"));
        V3();
        int i10 = R$id.mRvContent;
        ((RecyclerView) t3(i10)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ((RecyclerView) t3(i10)).setAdapter(u3());
    }

    public void M3(m1 m1Var) {
        t9.i.g(m1Var, "<set-?>");
        this.f4385k = m1Var;
    }

    public final void P3() {
        i.c cVar = w6.i.f9510g;
        if (!t9.i.b(cVar.I(), "1")) {
            t9.i.b(cVar.D(), "0");
        }
    }

    public final void Q3() {
        a3().k();
        a3().p();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00b3, code lost:
        if (r1.equals(com.titans.entity.CdnType.DIGITAL_TYPE_PCDN) == false) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00bd, code lost:
        if (r1.equals("4") == false) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c7, code lost:
        if (r1.equals("3") == false) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d3, code lost:
        if (r5.t().length() != 0) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d6, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d7, code lost:
        if (r3 == false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d9, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00da, code lost:
        r1 = r5.t().length() - 3;
        ((android.widget.TextView) t3(com.mobile.brasiltv.R$id.mTvUserNameNew)).setText(ba.t.I(r5.t(), r1 - 3, r1, "***").toString());
        ((android.widget.TextView) t3(r0)).setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void R3() {
        /*
            r14 = this;
            int r0 = com.mobile.brasiltv.R$id.mTvUserIdNew
            android.view.View r1 = r14.t3(r0)
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.content.res.Resources r2 = r14.getResources()
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            w6.i$c r5 = w6.i.f9510g
            java.lang.String r6 = r5.H()
            r7 = 0
            r4[r7] = r6
            r6 = 2131821202(0x7f110292, float:1.927514E38)
            java.lang.String r2 = r2.getString(r6, r4)
            r1.setText(r2)
            d6.b r1 = d6.b.f6366a
            boolean r2 = r1.y()
            if (r2 == 0) goto L_0x0046
            int r1 = com.mobile.brasiltv.R$id.mTvUserNameNew
            android.view.View r1 = r14.t3(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 2131821613(0x7f11042d, float:1.9275974E38)
            java.lang.String r2 = r14.getString(r2)
            r1.setText(r2)
            android.view.View r0 = r14.t3(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r7)
            return
        L_0x0046:
            android.content.Context r2 = r14.getContext()
            t9.i.d(r2)
            java.lang.String r1 = r1.j(r2)
            int r2 = r1.hashCode()
            r4 = -1240244679(0xffffffffb6135e39, float:-2.1959552E-6)
            r6 = 8
            if (r2 == r4) goto L_0x0151
            java.lang.String r4 = "***"
            switch(r2) {
                case 50: goto L_0x0108;
                case 51: goto L_0x00c1;
                case 52: goto L_0x00b7;
                case 53: goto L_0x00ad;
                case 54: goto L_0x0087;
                case 55: goto L_0x0063;
                default: goto L_0x0061;
            }
        L_0x0061:
            goto L_0x0159
        L_0x0063:
            java.lang.String r2 = "7"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x006d
            goto L_0x0159
        L_0x006d:
            int r1 = com.mobile.brasiltv.R$id.mTvUserNameNew
            android.view.View r1 = r14.t3(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = r5.H()
            r1.setText(r2)
            android.view.View r0 = r14.t3(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r6)
            goto L_0x018a
        L_0x0087:
            java.lang.String r2 = "6"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0091
            goto L_0x0159
        L_0x0091:
            int r1 = com.mobile.brasiltv.R$id.mTvUserNameNew
            android.view.View r1 = r14.t3(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            com.mobile.brasiltv.bean.MemberInfo r2 = com.mobile.brasiltv.bean.MemberInfo.INSTANCE
            java.lang.String r2 = r2.getLastUserName()
            r1.setText(r2)
            android.view.View r0 = r14.t3(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r7)
            goto L_0x018a
        L_0x00ad:
            java.lang.String r2 = "5"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00cb
            goto L_0x0159
        L_0x00b7:
            java.lang.String r2 = "4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00cb
            goto L_0x0159
        L_0x00c1:
            java.lang.String r2 = "3"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00cb
            goto L_0x0159
        L_0x00cb:
            java.lang.String r1 = r5.t()
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00d6
            goto L_0x00d7
        L_0x00d6:
            r3 = 0
        L_0x00d7:
            if (r3 == 0) goto L_0x00da
            return
        L_0x00da:
            java.lang.String r1 = r5.t()
            int r1 = r1.length()
            int r1 = r1 + -3
            int r2 = com.mobile.brasiltv.R$id.mTvUserNameNew
            android.view.View r2 = r14.t3(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = r5.t()
            int r5 = r1 + -3
            java.lang.CharSequence r1 = ba.t.I(r3, r5, r1, r4)
            java.lang.String r1 = r1.toString()
            r2.setText(r1)
            android.view.View r0 = r14.t3(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r7)
            goto L_0x018a
        L_0x0108:
            java.lang.String r2 = "2"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0111
            goto L_0x0159
        L_0x0111:
            java.lang.String r1 = r5.m()
            int r1 = r1.length()
            if (r1 != 0) goto L_0x011c
            goto L_0x011d
        L_0x011c:
            r3 = 0
        L_0x011d:
            if (r3 == 0) goto L_0x0120
            return
        L_0x0120:
            java.lang.String r8 = r5.m()
            java.lang.String r9 = "@"
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            int r1 = ba.t.y(r8, r9, r10, r11, r12, r13)
            int r2 = com.mobile.brasiltv.R$id.mTvUserNameNew
            android.view.View r2 = r14.t3(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = r5.m()
            int r5 = r1 + -3
            java.lang.CharSequence r1 = ba.t.I(r3, r5, r1, r4)
            java.lang.String r1 = r1.toString()
            r2.setText(r1)
            android.view.View r0 = r14.t3(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r7)
            goto L_0x018a
        L_0x0151:
            java.lang.String r2 = "google"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0172
        L_0x0159:
            int r1 = com.mobile.brasiltv.R$id.mTvUserNameNew
            android.view.View r1 = r14.t3(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = r5.H()
            r1.setText(r2)
            android.view.View r0 = r14.t3(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r6)
            goto L_0x018a
        L_0x0172:
            int r1 = com.mobile.brasiltv.R$id.mTvUserNameNew
            android.view.View r1 = r14.t3(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = r5.p()
            r1.setText(r2)
            android.view.View r0 = r14.t3(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r7)
        L_0x018a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.d3.R3():void");
    }

    public final void S3() {
        this.f4383i = false;
        d6.b.f6366a.y();
    }

    public void T2() {
        ((ImageView) t3(R$id.mIvAdultContent)).post(new v2(this));
    }

    public final void T3() {
    }

    public final void U3() {
    }

    @xa.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void UpdateMineView(UpdateMineViewEvent updateMineViewEvent) {
        t9.i.g(updateMineViewEvent, "event");
        f.e("更新个人中心页面: " + Q2(), new Object[0]);
        if (Q2()) {
            L3();
        }
    }

    @xa.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void UpdateRestrict(UpdateRestrictEvent updateRestrictEvent) {
        RestrictOpenTipsDialog restrictOpenTipsDialog;
        t9.i.g(updateRestrictEvent, "event");
        i.c cVar = w6.i.f9510g;
        cVar.q0(updateRestrictEvent.getStatus());
        boolean z10 = false;
        if (t9.i.b(cVar.A(), "0")) {
            ((ImageView) t3(R$id.mIvAdultContent)).setSelected(false);
            return;
        }
        ((ImageView) t3(R$id.mIvAdultContent)).setSelected(true);
        if (updateRestrictEvent.isSwitchOpen()) {
            RestrictOpenTipsDialog restrictOpenTipsDialog2 = this.f4388n;
            if (restrictOpenTipsDialog2 != null && restrictOpenTipsDialog2.isShowing()) {
                z10 = true;
            }
            if (z10 && (restrictOpenTipsDialog = this.f4388n) != null) {
                restrictOpenTipsDialog.dismiss();
            }
            Context context = getContext();
            t9.i.d(context);
            RestrictOpenTipsDialog restrictOpenTipsDialog3 = new RestrictOpenTipsDialog(context);
            this.f4388n = restrictOpenTipsDialog3;
            restrictOpenTipsDialog3.show();
        }
    }

    public void V2() {
        super.V2();
        if (Q2()) {
            a3().u();
        }
    }

    public final void V3() {
        if (this.f4384j) {
            t3(R$id.viewUpgradeDot).setVisibility(0);
        } else {
            t3(R$id.viewUpgradeDot).setVisibility(8);
        }
    }

    public final void W3() {
        d6.b bVar = d6.b.f6366a;
        if (bVar.y()) {
            Y3();
        } else if (bVar.p()) {
            T3();
        } else if (bVar.q()) {
            U3();
        } else if (bVar.x()) {
            X3();
        }
    }

    public void X2() {
        this.f4391q.clear();
    }

    public final void X3() {
    }

    public void Y2() {
        J3();
    }

    public final void Y3() {
    }

    public int c3() {
        return R.layout.frag_mine1;
    }

    public void l() {
        ((RecyclerView) t3(R$id.mRvContent)).setVisibility(8);
        ((AutoRelativeLayout) t3(R$id.mRlHistoryList)).setVisibility(8);
        u3().b(new ArrayList());
    }

    public void l1() {
        L3();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        M3(new m1(this, this));
        xa.c.c().o(this);
    }

    public void onDestroy() {
        xa.c.c().r(this);
        super.onDestroy();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    public void onStart() {
        super.onStart();
        a3().q();
        boolean z10 = this.f4390p;
        if (z10) {
            this.f4390p = !z10;
        } else if (S2()) {
            a3().u();
        }
    }

    public void s0() {
        if (getActivity() != null) {
            e activity = getActivity();
            t9.i.d(activity);
            if (!activity.isFinishing()) {
                e activity2 = getActivity();
                t9.i.d(activity2);
                StandardDialog standardDialog = new StandardDialog(activity2);
                this.f4387m = standardDialog;
                String string = getResources().getString(R.string.tips);
                t9.i.f(string, "resources.getString(R.string.tips)");
                z zVar = z.f19601a;
                String string2 = getResources().getString(R.string.bind_get_gift_days);
                t9.i.f(string2, "resources.getString(R.string.bind_get_gift_days)");
                String format = String.format(string2, Arrays.copyOf(new Object[]{w6.i.f9510g.x()}, 1));
                t9.i.f(format, "format(format, *args)");
                String string3 = getResources().getString(R.string.cancel);
                String string4 = getResources().getString(R.string.binding_now);
                t9.i.f(string4, "resources.getString(R.string.binding_now)");
                standardDialog.setDialogConfig(string, format, string3, string4, new p2(this), new u2(this));
                StandardDialog standardDialog2 = this.f4387m;
                if (standardDialog2 != null) {
                    b0.S(standardDialog2, DialogManager.DIALOG_NEW_BIND);
                }
            }
        }
    }

    public void showLoading(boolean z10) {
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

    @xa.j(sticky = true)
    public final void showUpdateNew(HasNewUpdateEvent hasNewUpdateEvent) {
        t9.i.g(hasNewUpdateEvent, "event");
        this.f4384j = hasNewUpdateEvent.getHas();
        if (Q2()) {
            V3();
        }
    }

    public void t1(boolean z10) {
    }

    public View t3(int i10) {
        View findViewById;
        Map map = this.f4391q;
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

    public final z0 u3() {
        return (z0) this.f4389o.getValue();
    }

    /* renamed from: v3 */
    public m1 a3() {
        m1 m1Var = this.f4385k;
        if (m1Var != null) {
            return m1Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final void w3() {
        StandardDialog standardDialog;
        StandardDialog standardDialog2 = this.f4387m;
        boolean z10 = false;
        if (standardDialog2 != null && standardDialog2.isShowing()) {
            z10 = true;
        }
        if (z10 && (standardDialog = this.f4387m) != null) {
            b0.j(standardDialog);
        }
    }

    public void x1() {
        if (d6.b.f6366a.y()) {
            t9.i.b(w6.i.f9510g.e(), "1");
        }
    }

    public void x2() {
        ((TextView) t3(R$id.mTvMsgCount)).setVisibility(8);
    }

    public final void x3() {
        u3().d(new b(this));
        ((AutoRelativeLayout) t3(R$id.mRlHistoryList)).setOnClickListener(new w2(this));
        ((ImageView) t3(R$id.ivMessage)).setOnClickListener(new y2(this));
        ((AutoLinearLayout) t3(R$id.mLayoutFav)).setOnClickListener(new z2(this));
        ((AutoLinearLayout) t3(R$id.mLayoutHistory)).setOnClickListener(new a3(this));
        ((AutoLinearLayout) t3(R$id.mLlAccount)).setOnClickListener(new b3(this));
        ((ImageView) t3(R$id.mCollapsingToolbarNew).findViewById(R$id.mImageAvatar)).setOnClickListener(new c3(this));
        ImageView imageView = (ImageView) t3(R$id.mIvAdultContent);
        t9.i.f(imageView, "mIvAdultContent");
        b0.P(imageView, new q2(this));
        ((AutoLinearLayout) t3(R$id.mLlHelp)).setOnClickListener(new r2(this));
        ((AutoLinearLayout) t3(R$id.mRlSetting)).setOnClickListener(new s2(this));
        ((AutoLinearLayout) t3(R$id.mLlSubtitle)).setOnClickListener(new t2(this));
        ((AutoLinearLayout) t3(R$id.mLayoutShare)).setOnClickListener(new x2(this));
    }
}
