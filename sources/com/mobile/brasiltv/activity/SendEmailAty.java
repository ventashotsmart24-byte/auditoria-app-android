package com.mobile.brasiltv.activity;

import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.ClosePageEvent;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import f5.d;
import f5.f4;
import f5.g4;
import f5.h4;
import f5.i4;
import i6.r0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.u3;
import t9.g;
import t9.i;
import w6.i;
import xa.c;

public final class SendEmailAty extends d implements r0 {

    /* renamed from: s  reason: collision with root package name */
    public static final a f12138s = new a((g) null);

    /* renamed from: l  reason: collision with root package name */
    public long f12139l;

    /* renamed from: m  reason: collision with root package name */
    public String f12140m = "";

    /* renamed from: n  reason: collision with root package name */
    public Handler f12141n = new Handler();

    /* renamed from: o  reason: collision with root package name */
    public Runnable f12142o = new f4(this);

    /* renamed from: p  reason: collision with root package name */
    public Runnable f12143p = new g4(this);

    /* renamed from: q  reason: collision with root package name */
    public u3 f12144q;

    /* renamed from: r  reason: collision with root package name */
    public Map f12145r = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final class b extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SendEmailAty f12146a;

        public b(SendEmailAty sendEmailAty) {
            this.f12146a = sendEmailAty;
        }

        public void onClick(View view) {
            i.g(view, "widget");
        }

        public void updateDrawState(TextPaint textPaint) {
            i.g(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f12146a.getResources().getColor(R.color.color_important));
            textPaint.setUnderlineText(true);
        }
    }

    public static final void Z2(SendEmailAty sendEmailAty, boolean z10, View view) {
        i.g(sendEmailAty, "this$0");
        if (System.currentTimeMillis() - sendEmailAty.f12139l >= 60000) {
            sendEmailAty.f12139l = System.currentTimeMillis();
            if (z10) {
                sendEmailAty.j3();
            } else {
                sendEmailAty.i3();
            }
        } else {
            c3(sendEmailAty, 0, 1, (Object) null);
        }
    }

    public static /* synthetic */ void c3(SendEmailAty sendEmailAty, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = R.string.frequent_operation;
        }
        sendEmailAty.b3(i10);
    }

    public static final void f3(SendEmailAty sendEmailAty, View view) {
        i.g(sendEmailAty, "this$0");
        c.c().j(new ClosePageEvent());
        sendEmailAty.finish();
    }

    public static final void g3(SendEmailAty sendEmailAty) {
        i.g(sendEmailAty, "this$0");
        ((TextView) sendEmailAty.Y2(R$id.resendEmail)).setVisibility(4);
    }

    public static final void h3(SendEmailAty sendEmailAty) {
        i.g(sendEmailAty, "this$0");
        ((TextView) sendEmailAty.Y2(R$id.tryAgain)).setVisibility(4);
    }

    public void R2() {
        k3(new u3(this, this));
        e3();
        boolean booleanExtra = getIntent().getBooleanExtra("reset_pwd", false);
        String stringExtra = getIntent().getStringExtra("send_email");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f12140m = stringExtra;
        if (booleanExtra) {
            ((TextView) Y2(R$id.content)).setText(getResources().getString(R.string.forget_email_send, new Object[]{this.f12140m}));
            String string = getString(R.string.forget_pwd_title);
            i.f(string, "getString(R.string.forget_pwd_title)");
            ((TitleView) Y2(R$id.titleView)).setTvTitleText(string);
        } else {
            i.c cVar = w6.i.f9510g;
            if (cVar.h().equals("1") || cVar.s().equals("1")) {
                ((TextView) Y2(R$id.content)).setText(getResources().getString(R.string.email_change_send_success));
                String string2 = getString(R.string.mailbox_binding);
                t9.i.f(string2, "getString(R.string.mailbox_binding)");
                ((TitleView) Y2(R$id.titleView)).setTvTitleText(string2);
            } else {
                ((TextView) Y2(R$id.content)).setText(getResources().getString(R.string.email_send_success));
                String string3 = getString(R.string.mailbox_binding);
                t9.i.f(string3, "getString(R.string.mailbox_binding)");
                ((TitleView) Y2(R$id.titleView)).setTvTitleText(string3);
            }
        }
        String string4 = getResources().getString(R.string.do_not_receive);
        t9.i.f(string4, "resources.getString(R.string.do_not_receive)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string4);
        spannableStringBuilder.setSpan(new b(this), t.y(string4, ",", 0, false, 6, (Object) null) + 1, string4.length(), 33);
        int i10 = R$id.sendMsgBt;
        ((TextView) Y2(i10)).setText(spannableStringBuilder);
        ((TextView) Y2(i10)).setOnClickListener(new h4(this, booleanExtra));
        this.f12139l = System.currentTimeMillis();
    }

    public int T2() {
        return R.layout.activity_sendemile;
    }

    public View Y2(int i10) {
        Map map = this.f12145r;
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

    public final void a3() {
        ((TextView) Y2(R$id.resendEmail)).setVisibility(0);
        this.f12141n.removeCallbacks(this.f12143p);
        this.f12141n.postDelayed(this.f12143p, 5000);
    }

    public final void b3(int i10) {
        int i11 = R$id.tryAgain;
        ((TextView) Y2(i11)).setText(getResources().getString(i10));
        ((TextView) Y2(i11)).setVisibility(0);
        this.f12141n.removeCallbacks(this.f12142o);
        this.f12141n.postDelayed(this.f12142o, 5000);
    }

    /* renamed from: d3 */
    public u3 S2() {
        u3 u3Var = this.f12144q;
        if (u3Var != null) {
            return u3Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final void e3() {
        int i10 = R$id.titleView;
        ((TitleView) Y2(i10)).setLayoutBackground(R.color.color_191a23);
        ((TitleView) Y2(i10)).getSettingView().setVisibility(8);
        ((TitleView) Y2(i10)).getIvMenuView().setVisibility(8);
        ((TitleView) Y2(i10)).setIvMenuSrc(0);
        ((TitleView) Y2(i10)).getTvMenuView().setVisibility(8);
        ((TitleView) Y2(i10)).setTvMenuText("");
        ((TitleView) Y2(i10)).setXVisible(0);
        ((TitleView) Y2(i10)).setXClickListener(new i4(this));
    }

    public void g2() {
        a3();
    }

    public final void i3() {
        int i10;
        if (w6.i.f9510g.h().equals("1")) {
            i10 = 2;
        } else {
            i10 = 1;
        }
        S2().h(this.f12140m, i10);
    }

    public void j() {
        b3(R.string.email_been_linked);
    }

    public final void j3() {
        S2().k(this.f12140m);
    }

    public void k2() {
        n2();
    }

    public void k3(u3 u3Var) {
        t9.i.g(u3Var, "<set-?>");
        this.f12144q = u3Var;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f12141n.removeCallbacks(this.f12142o);
        this.f12141n.removeCallbacks(this.f12143p);
    }

    public void showLoading(boolean z10) {
        if (z10) {
            ((ProgressBar) Y2(R$id.mLoadingPbar)).setVisibility(0);
        } else {
            ((ProgressBar) Y2(R$id.mLoadingPbar)).setVisibility(8);
        }
    }
}
