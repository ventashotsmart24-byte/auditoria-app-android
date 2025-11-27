package com.mobile.brasiltv.mine.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.LoadingDialog;
import com.mobile.brasiltv.view.dialog.PaymentResultDialog;
import com.mobile.brasiltv.view.dialog.PriorityVipDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import e6.r0;
import e6.s0;
import e6.t0;
import e6.u0;
import h9.t;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.CheckGetVipResult;
import mobile.com.requestframe.utils.response.GetExchangeOrderData;
import mobile.com.requestframe.utils.response.GetExchangeOrderInfoResult;
import mobile.com.requestframe.utils.response.GetOrderInfoData;
import mobile.com.requestframe.utils.response.GetOrderInfoResult;
import mobile.com.requestframe.utils.response.GetPriorityVipResult;
import mobile.com.requestframe.utils.response.ResultFlag;
import s9.l;

public final class OrderAty extends f5.c {

    /* renamed from: u  reason: collision with root package name */
    public static final a f12351u = new a((t9.g) null);

    /* renamed from: k  reason: collision with root package name */
    public ArrayList f12352k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public ArrayList f12353l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public int f12354m;

    /* renamed from: n  reason: collision with root package name */
    public final Handler f12355n = new Handler();

    /* renamed from: o  reason: collision with root package name */
    public long f12356o = 60;

    /* renamed from: p  reason: collision with root package name */
    public e f12357p = new e(this);

    /* renamed from: q  reason: collision with root package name */
    public f f12358q = new f(this);

    /* renamed from: r  reason: collision with root package name */
    public final h9.g f12359r = h9.h.b(g.f12372a);

    /* renamed from: s  reason: collision with root package name */
    public final h9.g f12360s = h9.h.b(h.f12373a);

    /* renamed from: t  reason: collision with root package name */
    public Map f12361t = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OrderAty f12362a;

        public static final class a extends t9.j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OrderAty f12363a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(OrderAty orderAty) {
                super(1);
                this.f12363a = orderAty;
            }

            public final void b(PriorityVipDialog priorityVipDialog) {
                t9.i.g(priorityVipDialog, "it");
                this.f12363a.o3(priorityVipDialog);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                b((PriorityVipDialog) obj);
                return t.f17319a;
            }
        }

        public b(OrderAty orderAty) {
            this.f12362a = orderAty;
        }

        /* renamed from: f */
        public void onNext(CheckGetVipResult checkGetVipResult) {
            String str;
            int i10;
            t9.i.g(checkGetVipResult, "t");
            StringBuilder sb = new StringBuilder();
            sb.append("checkGetVip result: ");
            ResultFlag data = checkGetVipResult.getData();
            String str2 = null;
            if (data != null) {
                str = data.getResultFlag();
            } else {
                str = null;
            }
            sb.append(str);
            b0.U(this, sb.toString());
            ResultFlag data2 = checkGetVipResult.getData();
            if (data2 != null) {
                str2 = data2.getResultFlag();
            }
            if (t9.i.b(str2, "yes")) {
                OrderAty orderAty = this.f12362a;
                PriorityVipDialog.Type type = PriorityVipDialog.Type.QUALIFICATIONS;
                ResultFlag data3 = checkGetVipResult.getData();
                if (data3 != null) {
                    i10 = data3.getAuthDays();
                } else {
                    i10 = 0;
                }
                new PriorityVipDialog(orderAty, type, i10, new a(this.f12362a)).show();
            }
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OrderAty f12364a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f12365b;

        public static final class a extends t9.j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f12366a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f12366a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f12366a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public c(OrderAty orderAty, String str) {
            this.f12364a = orderAty;
            this.f12365b = str;
        }

        /* renamed from: f */
        public void onNext(GetOrderInfoResult getOrderInfoResult) {
            String str;
            t9.i.g(getOrderInfoResult, "t");
            b0.U(this, "query order record by order id success");
            this.f12364a.O2(false);
            if (b0.I(getOrderInfoResult.getData())) {
                List<GetOrderInfoData> data = getOrderInfoResult.getData();
                t9.i.d(data);
                GetOrderInfoData getOrderInfoData = data.get(0);
                String d10 = y6.b.d(getOrderInfoData.getInvalidDate(), "yyyy-MM-dd HH:mm:ss");
                if (t9.i.b(getOrderInfoData.getState(), "1") || t9.i.b(getOrderInfoData.getState(), "2")) {
                    str = this.f12364a.getResources().getString(R.string.order_dialog_finished);
                    t9.i.f(str, "resources.getString(R.st…ng.order_dialog_finished)");
                } else if (!t9.i.b(getOrderInfoData.getPaymentPlatform(), "Pagsmile") || y6.b.a(d10, "yyyy-MM-dd HH:mm:ss") < 0) {
                    str = "";
                } else if (getOrderInfoData.isProcessing() == 0) {
                    str = this.f12364a.getResources().getString(R.string.order_dialog_expired);
                    t9.i.f(str, "resources.getString(R.string.order_dialog_expired)");
                } else {
                    str = this.f12364a.getResources().getString(R.string.order_dialog_processed);
                    t9.i.f(str, "resources.getString(R.st…g.order_dialog_processed)");
                }
                if (b0.J(str)) {
                    String json = new Gson().toJson((Object) getOrderInfoData);
                    OrderAty orderAty = this.f12364a;
                    String str2 = this.f12365b;
                    t9.i.f(json, "orderJson");
                    b0.p(orderAty, str2, json, getOrderInfoData.getPaymentType());
                    return;
                }
                new PaymentResultDialog(this.f12364a, str).show();
            }
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f12364a.O2(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f12364a.O2(false);
            b0.U(this, "fetch order record fail");
            x.f12622a.w(this.f12364a.Q1(), new a(str));
        }
    }

    public static final class d extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OrderAty f12367a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PriorityVipDialog f12368b;

        public static final class a extends t9.j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f12369a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f12369a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f12369a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public d(OrderAty orderAty, PriorityVipDialog priorityVipDialog) {
            this.f12367a = orderAty;
            this.f12368b = priorityVipDialog;
        }

        /* renamed from: f */
        public void onNext(GetPriorityVipResult getPriorityVipResult) {
            int i10;
            t9.i.g(getPriorityVipResult, "t");
            this.f12367a.showLoading(false);
            if (t9.i.b(getPriorityVipResult.getReturnCode(), "0")) {
                b0.U(this, "getPriorityVip success");
                this.f12368b.dismiss();
                OrderAty orderAty = this.f12367a;
                PriorityVipDialog.Type type = PriorityVipDialog.Type.RECEIVE;
                ResultFlag data = getPriorityVipResult.getData();
                if (data != null) {
                    i10 = data.getAuthDays();
                } else {
                    i10 = 0;
                }
                new PriorityVipDialog(orderAty, type, i10, (l) null, 8, (t9.g) null).show();
            } else if (t9.i.b(getPriorityVipResult.getReturnCode(), "aaa60001")) {
                b0.U(this, "getPriorityVip disqualified");
                this.f12368b.dismiss();
            }
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            this.f12367a.showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f12367a.showLoading(false);
            b0.U(this, "getPriorityVip failed");
            x.f12622a.w(this.f12367a.Q1(), new a(str));
        }
    }

    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OrderAty f12370a;

        public e(OrderAty orderAty) {
            this.f12370a = orderAty;
        }

        public void run() {
            this.f12370a.h3();
        }
    }

    public static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OrderAty f12371a;

        public f(OrderAty orderAty) {
            this.f12371a = orderAty;
        }

        public void run() {
            this.f12371a.p3();
        }
    }

    public static final class g extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final g f12372a = new g();

        public g() {
            super(0);
        }

        /* renamed from: b */
        public final f6.j invoke() {
            return new f6.j();
        }
    }

    public static final class h extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final h f12373a = new h();

        public h() {
            super(0);
        }

        /* renamed from: b */
        public final f6.k invoke() {
            return new f6.k();
        }
    }

    public static final class i extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OrderAty f12374a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(OrderAty orderAty) {
            super(1);
            this.f12374a = orderAty;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f17319a;
        }

        public final void invoke(String str) {
            t9.i.g(str, "it");
            this.f12374a.i3(str);
        }
    }

    public static final class j extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OrderAty f12375a;

        public static final class a extends t9.j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f12376a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f12376a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f12376a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public j(OrderAty orderAty) {
            this.f12375a = orderAty;
        }

        /* renamed from: f */
        public void onNext(GetExchangeOrderInfoResult getExchangeOrderInfoResult) {
            t9.i.g(getExchangeOrderInfoResult, "t");
            b0.U(this, "query exchange record success");
            this.f12375a.showLoading(false);
            if (b0.I(getExchangeOrderInfoResult.getData()) && this.f12375a.k3() == 1) {
                OrderAty orderAty = this.f12375a;
                List<GetExchangeOrderData> data = getExchangeOrderInfoResult.getData();
                t9.i.e(data, "null cannot be cast to non-null type java.util.ArrayList<mobile.com.requestframe.utils.response.GetExchangeOrderData>");
                orderAty.x3((ArrayList) data);
                this.f12375a.m3().setNewData(this.f12375a.n3());
            }
            this.f12375a.f3();
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f12375a.showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f12375a.showLoading(false);
            this.f12375a.z3();
            b0.U(this, "fetch redemption record fail");
            x.f12622a.w(this.f12375a.Q1(), new a(str));
        }
    }

    public static final class k extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OrderAty f12377a;

        public static final class a extends t9.j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f12378a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f12378a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f12378a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public k(OrderAty orderAty) {
            this.f12377a = orderAty;
        }

        /* renamed from: f */
        public void onNext(GetOrderInfoResult getOrderInfoResult) {
            t9.i.g(getOrderInfoResult, "t");
            b0.U(this, "query order record success");
            this.f12377a.showLoading(false);
            if (b0.I(getOrderInfoResult.getData()) && this.f12377a.k3() == 0) {
                OrderAty orderAty = this.f12377a;
                List<GetOrderInfoData> data = getOrderInfoResult.getData();
                t9.i.e(data, "null cannot be cast to non-null type java.util.ArrayList<mobile.com.requestframe.utils.response.GetOrderInfoData>");
                orderAty.w3((ArrayList) data);
                this.f12377a.l3().setNewData(this.f12377a.j3());
                this.f12377a.C3();
            }
            this.f12377a.f3();
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f12377a.showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f12377a.showLoading(false);
            if (t9.i.b(str, CdnType.DIGITAL_TYPE_PCDN)) {
                this.f12377a.f3();
                return;
            }
            this.f12377a.A3();
            b0.U(this, "fetch order record fail");
            x.f12622a.w(this.f12377a.Q1(), new a(str));
        }
    }

    public static final void q3(OrderAty orderAty, View view) {
        t9.i.g(orderAty, "this$0");
        orderAty.f12354m = 0;
        ((AutoFrameLayout) orderAty.V2(R$id.mAflRefresh)).setVisibility(0);
        int i10 = R$id.mTextOrder;
        ((TextView) orderAty.V2(i10)).setTextColor(orderAty.getResources().getColor(R.color.color_important));
        int i11 = R$id.mTextRedemption;
        ((TextView) orderAty.V2(i11)).setTextColor(orderAty.getResources().getColor(R.color.color_cccccc));
        ((TextView) orderAty.V2(i10)).setTypeface(Typeface.DEFAULT_BOLD);
        ((TextView) orderAty.V2(i11)).setTypeface(Typeface.DEFAULT);
        orderAty.l3().bindToRecyclerView((RecyclerView) orderAty.V2(R$id.mRecyclerOrder));
        orderAty.l3().setNewData(orderAty.f12352k);
        ((AutoFrameLayout) orderAty.V2(R$id.mAflOrder)).setVisibility(0);
        orderAty.V2(R$id.mOrderStatus).setVisibility(8);
        if (orderAty.f12352k.isEmpty()) {
            orderAty.v3();
        }
    }

    public static final void r3(OrderAty orderAty, View view) {
        t9.i.g(orderAty, "this$0");
        orderAty.f12354m = 1;
        ((AutoFrameLayout) orderAty.V2(R$id.mAflRefresh)).setVisibility(8);
        int i10 = R$id.mTextOrder;
        ((TextView) orderAty.V2(i10)).setTextColor(orderAty.getResources().getColor(R.color.color_cccccc));
        int i11 = R$id.mTextRedemption;
        ((TextView) orderAty.V2(i11)).setTextColor(orderAty.getResources().getColor(R.color.color_important));
        ((TextView) orderAty.V2(i10)).setTypeface(Typeface.DEFAULT);
        ((TextView) orderAty.V2(i11)).setTypeface(Typeface.DEFAULT_BOLD);
        orderAty.m3().bindToRecyclerView((RecyclerView) orderAty.V2(R$id.mRecyclerOrder));
        orderAty.m3().setNewData(orderAty.f12353l);
        ((AutoFrameLayout) orderAty.V2(R$id.mAflOrder)).setVisibility(0);
        orderAty.V2(R$id.mOrderStatus).setVisibility(8);
        if (orderAty.f12353l.isEmpty()) {
            orderAty.u3();
        }
    }

    public static final void s3(OrderAty orderAty, View view) {
        t9.i.g(orderAty, "this$0");
        orderAty.v3();
        orderAty.f12356o = 60;
        orderAty.y3(false);
        orderAty.f12355n.post(orderAty.f12357p);
    }

    public static final void t3(OrderAty orderAty, View view) {
        t9.i.g(orderAty, "this$0");
        b0.M(orderAty);
    }

    public final void A3() {
        int i10 = R$id.mTvOrderHint;
        ((TextView) V2(i10)).setVisibility(0);
        ((TextView) V2(i10)).setText(getResources().getString(R.string.order_system_busy));
        ((TextView) V2(i10)).setTextColor(getResources().getColor(R.color.color_f23232));
        this.f12355n.postDelayed(this.f12358q, 5000);
    }

    public final void B3(boolean z10) {
        if (z10) {
            V2(R$id.mLayoutNoLogin).setVisibility(8);
            ((AutoLinearLayout) V2(R$id.mLayoutTab)).setVisibility(0);
            ((AutoFrameLayout) V2(R$id.mAflOrder)).setVisibility(0);
            V2(R$id.mOrderStatus).setVisibility(8);
            ((AutoFrameLayout) V2(R$id.mAflRefresh)).setVisibility(0);
            return;
        }
        int i10 = R$id.mLayoutNoLogin;
        V2(i10).setVisibility(0);
        ((TextView) V2(i10).findViewById(R$id.mTvStatusInfo)).setText(getResources().getString(R.string.vod_please_bind));
        ((ImageView) V2(i10).findViewById(R$id.mImageNoLogin)).setVisibility(0);
        ((AutoLinearLayout) V2(R$id.mLayoutTab)).setVisibility(8);
        ((AutoFrameLayout) V2(R$id.mAflOrder)).setVisibility(8);
        V2(R$id.mOrderStatus).setVisibility(8);
        ((AutoFrameLayout) V2(R$id.mAflRefresh)).setVisibility(8);
    }

    public final void C3() {
        int i10 = R$id.mTvOrderHint;
        ((TextView) V2(i10)).setVisibility(0);
        ((TextView) V2(i10)).setText(getResources().getString(R.string.order_record_update));
        ((TextView) V2(i10)).setTextColor(getResources().getColor(R.color.color_important));
        this.f12355n.postDelayed(this.f12358q, 5000);
    }

    public View V2(int i10) {
        Map map = this.f12361t;
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

    public final void f3() {
        ArrayList arrayList;
        if (this.f12354m == 0) {
            arrayList = this.f12352k;
        } else {
            arrayList = this.f12353l;
        }
        if (arrayList.isEmpty()) {
            ((AutoFrameLayout) V2(R$id.mAflOrder)).setVisibility(8);
            int i10 = R$id.mOrderStatus;
            V2(i10).setVisibility(0);
            ((TextView) V2(i10).findViewById(R$id.mTvStatusInfo)).setText(b0.A(this, R.string.no_order_record));
            ((ImageView) V2(i10).findViewById(R$id.mImageNoLogin)).setVisibility(8);
            return;
        }
        ((AutoFrameLayout) V2(R$id.mAflOrder)).setVisibility(0);
        V2(R$id.mOrderStatus).setVisibility(8);
    }

    public final void g3() {
        w6.i.f9510g.b().V0().compose(O1()).subscribe(new b(this));
    }

    public final void h3() {
        if (this.f12356o != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f12356o);
            sb.append('s');
            ((TextView) V2(R$id.mTvRefresh)).setText(sb.toString());
            this.f12356o--;
            this.f12355n.postDelayed(this.f12357p, 1000);
            return;
        }
        ((TextView) V2(R$id.mTvRefresh)).setText(getResources().getString(R.string.order_refresh));
        y3(true);
    }

    public final void i3(String str) {
        w6.i.f9510g.b().D1(str).compose(O1()).subscribe(new c(this, str));
    }

    public final ArrayList j3() {
        return this.f12352k;
    }

    public void k2() {
        n2();
    }

    public final int k3() {
        return this.f12354m;
    }

    public final f6.j l3() {
        return (f6.j) this.f12359r.getValue();
    }

    public final f6.k m3() {
        return (f6.k) this.f12360s.getValue();
    }

    public final ArrayList n3() {
        return this.f12353l;
    }

    public final void o3(PriorityVipDialog priorityVipDialog) {
        w6.i.f9510g.b().E1().compose(O1()).subscribe(new d(this, priorityVipDialog));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_order);
        if (t9.i.b(w6.i.f9510g.I(), "1")) {
            B3(false);
            return;
        }
        B3(true);
        int i10 = R$id.mTvHelp;
        ((TextView) V2(i10)).getPaint().setFlags(8);
        ((TextView) V2(i10)).getPaint().setAntiAlias(true);
        int i11 = R$id.mRecyclerOrder;
        ((RecyclerView) V2(i11)).setLayoutManager(new LinearLayoutManager(Q1()));
        l3().k(new i(this));
        l3().bindToRecyclerView((RecyclerView) V2(i11));
        v3();
        g3();
        ((TextView) V2(R$id.mTextOrder)).setOnClickListener(new r0(this));
        ((TextView) V2(R$id.mTextRedemption)).setOnClickListener(new s0(this));
        ((TextView) V2(R$id.mTvRefresh)).setOnClickListener(new t0(this));
        ((TextView) V2(i10)).setOnClickListener(new u0(this));
    }

    public final void p3() {
        ((TextView) V2(R$id.mTvOrderHint)).setVisibility(8);
    }

    public final void showLoading(boolean z10) {
        if (z10) {
            LoadingDialog.Companion.show(getFragmentManager());
        } else {
            LoadingDialog.Companion.hidden();
        }
    }

    public final void u3() {
        w6.i.f9510g.b().t1().compose(O1()).subscribe(new j(this));
    }

    public final void v3() {
        w6.i.f9510g.b().C1().compose(O1()).subscribe(new k(this));
    }

    public final void w3(ArrayList arrayList) {
        t9.i.g(arrayList, "<set-?>");
        this.f12352k = arrayList;
    }

    public final void x3(ArrayList arrayList) {
        t9.i.g(arrayList, "<set-?>");
        this.f12353l = arrayList;
    }

    public final void y3(boolean z10) {
        if (z10) {
            int i10 = R$id.mTvRefresh;
            ((TextView) V2(i10)).setEnabled(true);
            ((TextView) V2(i10)).setTextColor(getResources().getColor(R.color.color_important));
            return;
        }
        int i11 = R$id.mTvRefresh;
        ((TextView) V2(i11)).setEnabled(false);
        ((TextView) V2(i11)).setTextColor(getResources().getColor(R.color.color_999999));
    }

    public final void z3() {
        ((AutoFrameLayout) V2(R$id.mAflOrder)).setVisibility(8);
        int i10 = R$id.mOrderStatus;
        V2(i10).setVisibility(0);
        ((TextView) V2(i10).findViewById(R$id.mTvStatusInfo)).setText(b0.A(this, R.string.order_record_get_failed));
        ((ImageView) V2(i10).findViewById(R$id.mImageNoLogin)).setVisibility(8);
    }
}
