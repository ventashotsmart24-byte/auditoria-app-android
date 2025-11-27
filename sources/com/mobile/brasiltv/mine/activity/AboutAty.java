package com.mobile.brasiltv.mine.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.WebViewAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.x;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.d;
import h9.t;
import java.util.LinkedHashMap;
import java.util.Map;
import s9.l;
import t9.i;
import t9.j;

public final class AboutAty extends d implements i6.b {

    /* renamed from: l  reason: collision with root package name */
    public k6.a f12269l;

    /* renamed from: m  reason: collision with root package name */
    public Map f12270m = new LinkedHashMap();

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AboutAty f12271a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AboutAty aboutAty) {
            super(1);
            this.f12271a = aboutAty;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f17319a;
        }

        public final void invoke(String str) {
            if (str == null || str.length() == 0) {
                ((AutoRelativeLayout) this.f12271a.V2(R$id.aboutAtyServiceLayout)).setVisibility(8);
                return;
            }
            ((AutoRelativeLayout) this.f12271a.V2(R$id.aboutAtyServiceLayout)).setVisibility(0);
            if (str.length() >= 24) {
                int x10 = ba.t.x(str, '@', 0, false, 6, (Object) null);
                if (x10 != -1) {
                    StringBuilder sb = new StringBuilder();
                    String substring = str.substring(0, x10);
                    i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb.append(substring);
                    sb.append(10);
                    String substring2 = str.substring(x10);
                    i.f(substring2, "this as java.lang.String).substring(startIndex)");
                    sb.append(substring2);
                    ((TextView) this.f12271a.V2(R$id.tvEmail)).setText(sb.toString());
                    return;
                }
                ((TextView) this.f12271a.V2(R$id.tvEmail)).setText(str);
                return;
            }
            ((TextView) this.f12271a.V2(R$id.tvEmail)).setText(str);
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AboutAty f12272a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AboutAty aboutAty) {
            super(1);
            this.f12272a = aboutAty;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f17319a;
        }

        public final void invoke(String str) {
            if (str == null || str.length() == 0) {
                ((AutoRelativeLayout) this.f12272a.V2(R$id.rlWebsite)).setVisibility(8);
                return;
            }
            ((AutoRelativeLayout) this.f12272a.V2(R$id.rlWebsite)).setVisibility(0);
            ((TextView) this.f12272a.V2(R$id.tvWebsite)).setText(str);
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f12273a = new c();

        public c() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "it");
            WebViewAty.a aVar = WebViewAty.B;
            intent.putExtra(aVar.j(), a6.c.a());
            Intent putExtra = intent.putExtra(aVar.a(), false);
            i.f(putExtra, "it.putExtra(WebViewAty.BUNDLE_BACK_TO_MAIN, false)");
            return putExtra;
        }
    }

    public static final void W2(AboutAty aboutAty, View view) {
        i.g(aboutAty, "this$0");
        b0.d0(aboutAty, WebViewAty.class, c.f12273a);
    }

    public void J(String str) {
        i.g(str, "version");
        ((TextView) V2(R$id.aboutAtyVersion)).setText(str);
    }

    public void R2() {
        Y2(new k6.a(this, this));
        ((AutoRelativeLayout) V2(R$id.rlWebsite)).setVisibility(8);
        ((AutoRelativeLayout) V2(R$id.aboutAtyServiceLayout)).setVisibility(8);
        x.f12622a.x(Q1(), new a(this), new b(this));
        int i10 = R$id.mTvPrivaryPolicy;
        ((TextView) V2(i10)).getPaint().setFlags(8);
        ((TextView) V2(i10)).getPaint().setAntiAlias(true);
        ((TextView) V2(i10)).setOnClickListener(new e6.a(this));
    }

    public int T2() {
        return R.layout.aty_about;
    }

    public View V2(int i10) {
        Map map = this.f12270m;
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

    /* renamed from: X2 */
    public k6.a S2() {
        k6.a aVar = this.f12269l;
        if (aVar != null) {
            return aVar;
        }
        i.w("mPresenter");
        return null;
    }

    public void Y2(k6.a aVar) {
        i.g(aVar, "<set-?>");
        this.f12269l = aVar;
    }

    /* renamed from: Z2 */
    public void Y0(i6.a aVar) {
        i.g(aVar, "presenter");
    }

    public void k2() {
        n2();
    }
}
