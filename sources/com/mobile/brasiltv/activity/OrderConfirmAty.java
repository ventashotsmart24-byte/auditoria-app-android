package com.mobile.brasiltv.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.OrderAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import f5.c;
import f5.k2;
import f5.l2;
import h9.h;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;
import t9.j;
import t9.z;
import w6.i;

public final class OrderConfirmAty extends c {

    /* renamed from: m  reason: collision with root package name */
    public static final a f12063m = new a((g) null);

    /* renamed from: n  reason: collision with root package name */
    public static final String f12064n = "bundlePaymentType";

    /* renamed from: k  reason: collision with root package name */
    public final h9.g f12065k = h.b(new b(this));

    /* renamed from: l  reason: collision with root package name */
    public Map f12066l = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a() {
            return OrderConfirmAty.f12064n;
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OrderConfirmAty f12067a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(OrderConfirmAty orderConfirmAty) {
            super(0);
            this.f12067a = orderConfirmAty;
        }

        public final String invoke() {
            return this.f12067a.getIntent().getStringExtra(OrderConfirmAty.f12063m.a());
        }
    }

    public static final void X2(OrderConfirmAty orderConfirmAty, View view) {
        i.g(orderConfirmAty, "this$0");
        b0.c0(orderConfirmAty, OrderAty.class);
        orderConfirmAty.finish();
    }

    public static final void Y2(OrderConfirmAty orderConfirmAty, View view) {
        i.g(orderConfirmAty, "this$0");
        b0.c0(orderConfirmAty, OrderAty.class);
        orderConfirmAty.finish();
    }

    public View T2(int i10) {
        Map map = this.f12066l;
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

    public final String V2() {
        return (String) this.f12065k.getValue();
    }

    public final void W2() {
        int i10 = R$id.mTitleView;
        ((TitleView) T2(i10)).setXVisible(0);
        z zVar = z.f19601a;
        String string = Q1().getString(R.string.order_confirm_title);
        i.f(string, "context.getString(R.string.order_confirm_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{V2()}, 1));
        i.f(format, "format(format, *args)");
        ((TextView) T2(R$id.mTvPaymentTip)).setText(format);
        int i11 = R$id.mTvHelp;
        ((TextView) T2(i11)).setPaintFlags(8);
        ((TextView) T2(i11)).getPaint().setAntiAlias(true);
        ((TitleView) T2(i10)).setXClickListener(new k2(this));
        ((TitleView) T2(i10)).setOnBackClickListener(new l2(this));
        ((TextView) T2(i11)).setOnClickListener(this);
        ((Button) T2(R$id.mBtnPaid)).setOnClickListener(this);
        ((Button) T2(R$id.mBtnPreparing)).setOnClickListener(this);
        ((Button) T2(R$id.mBtnRepay)).setOnClickListener(this);
        ((Button) T2(R$id.mBtnCancel)).setOnClickListener(this);
    }

    public void onClick(View view) {
        String str;
        boolean z10;
        i.g(view, "view");
        int id = view.getId();
        if (id == R.id.mBtnCancel) {
            b0.c0(this, MainAty.class);
            finish();
            str = "Cancel";
        } else if (id != R.id.mTvHelp) {
            Class<OrderAty> cls = OrderAty.class;
            switch (id) {
                case R.id.mBtnPaid:
                    b0.c0(this, cls);
                    finish();
                    str = "Paid";
                    break;
                case R.id.mBtnPreparing:
                    b0.c0(this, cls);
                    finish();
                    str = "Preparing";
                    break;
                case R.id.mBtnRepay:
                    i.c cVar = w6.i.f9510g;
                    if (cVar.g().length() > 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        b0.j0(Q1(), cVar.g(), false, true, false, false, 24, (Object) null);
                    }
                    b0.U(this, "beVipUrl:" + cVar.g());
                    finish();
                    str = "Unpaid";
                    break;
                default:
                    str = "";
                    break;
            }
        } else {
            i.c cVar2 = w6.i.f9510g;
            boolean b10 = t9.i.b(cVar2.e(), "0");
            Context Q1 = Q1();
            b0.j0(Q1, b0.x(m7.c.g()) + "/#/app-help?isFree=" + b10 + "&appId=" + na.a.g() + "&userId=" + cVar2.H() + "&lang=" + f0.a() + "&appVersion=" + na.a.b() + "&timestamp=" + new Date().getTime() + "&portalCode=" + cVar2.v(), false, true, false, false, 24, (Object) null);
            str = "Help";
        }
        i1.C(this, str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_order_comfirm);
        W2();
    }
}
