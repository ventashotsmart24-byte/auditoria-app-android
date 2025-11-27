package f6;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.dialog.PaymentTipDialog;
import com.mobile.brasiltv.view.dialog.UploadVoucherDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import h9.t;
import mobile.com.requestframe.utils.response.GetOrderInfoData;
import s9.l;
import t9.g;
import t9.i;

public final class j extends BaseQuickAdapter {

    /* renamed from: b  reason: collision with root package name */
    public static final a f16746b = new a((g) null);

    /* renamed from: a  reason: collision with root package name */
    public l f16747a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final class b extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f16748a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetOrderInfoData f16749b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(j jVar, GetOrderInfoData getOrderInfoData) {
            super(1);
            this.f16748a = jVar;
            this.f16749b = getOrderInfoData;
        }

        public final void b(PaymentTipDialog paymentTipDialog) {
            i.g(paymentTipDialog, "it");
            l e10 = this.f16748a.f16747a;
            if (e10 != null) {
                e10.invoke(this.f16749b.getOrderId());
            }
            paymentTipDialog.dismiss();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((PaymentTipDialog) obj);
            return t.f17319a;
        }
    }

    public j() {
        super((int) R.layout.adapter_order);
    }

    public static final void g(j jVar, GetOrderInfoData getOrderInfoData, View view) {
        i.g(jVar, "this$0");
        i.g(getOrderInfoData, "$item");
        Context context = jVar.mContext;
        i.f(context, "mContext");
        new PaymentTipDialog(context, new b(jVar, getOrderInfoData)).show();
    }

    public static final void h(j jVar, GetOrderInfoData getOrderInfoData, View view) {
        i.g(jVar, "this$0");
        i.g(getOrderInfoData, "$item");
        Context context = jVar.mContext;
        i.f(context, "mContext");
        String uploadUrl = getOrderInfoData.getUploadUrl();
        i.d(uploadUrl);
        new UploadVoucherDialog(context, uploadUrl).show();
    }

    public static final void i(j jVar, GetOrderInfoData getOrderInfoData, View view) {
        i.g(jVar, "this$0");
        i.g(getOrderInfoData, "$item");
        Context context = jVar.mContext;
        i.f(context, "mContext");
        b0.o(context, getOrderInfoData.getOrderId(), getOrderInfoData.getPaymentType(), getOrderInfoData.getPaymentPlatform());
    }

    public static final void j(j jVar, GetOrderInfoData getOrderInfoData, View view) {
        i.g(jVar, "this$0");
        i.g(getOrderInfoData, "$item");
        b0.U(jVar, ">>> enterOrderProgressPage state: " + getOrderInfoData.getState());
        Context context = jVar.mContext;
        i.f(context, "mContext");
        b0.n(context, getOrderInfoData.getOrderId());
    }

    public void bindToRecyclerView(RecyclerView recyclerView) {
        if (getRecyclerView() != null) {
            getRecyclerView().setAdapter(this);
        } else {
            super.bindToRecyclerView(recyclerView);
        }
    }

    /* renamed from: f */
    public void convert(BaseViewHolder baseViewHolder, GetOrderInfoData getOrderInfoData) {
        String str;
        String str2;
        boolean z10;
        boolean z11;
        i.g(baseViewHolder, "helper");
        i.g(getOrderInfoData, PlistBuilder.KEY_ITEM);
        if (getOrderInfoData.getPackageType() == 1) {
            baseViewHolder.setText((int) R.id.mTextType, (CharSequence) this.mContext.getResources().getString(R.string.mobile_vip));
        } else {
            baseViewHolder.setText((int) R.id.mTextType, (CharSequence) this.mContext.getResources().getString(R.string.tv_vip));
        }
        l(baseViewHolder, getOrderInfoData);
        baseViewHolder.setText((int) R.id.mTextOrderName, (CharSequence) this.mContext.getString(R.string.order_record_name, new Object[]{getOrderInfoData.getPackagePlanName(), String.valueOf(getOrderInfoData.getAuthorizedDays())}));
        baseViewHolder.setText((int) R.id.mTvMoney, (CharSequence) getOrderInfoData.getPaymentAmount());
        String paymentCurrency = getOrderInfoData.getPaymentCurrency();
        if (i.b(paymentCurrency, "BRL")) {
            str = "R$";
        } else if (i.b(paymentCurrency, "USD")) {
            str = "$";
        } else {
            str = getOrderInfoData.getPaymentCurrency();
        }
        baseViewHolder.setText((int) R.id.mTvMoneyFlag, (CharSequence) str);
        baseViewHolder.setText((int) R.id.mTextOrderId, (CharSequence) this.mContext.getResources().getString(R.string.order_number, new Object[]{getOrderInfoData.getOrderId()}));
        if (TextUtils.isEmpty(getOrderInfoData.getCreateTime()) || getOrderInfoData.getCreateTime().length() < 16) {
            String c10 = y6.b.c();
            i.f(c10, "getLocalUTCTime()");
            str2 = c10.substring(0, 16);
            i.f(str2, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            str2 = y6.b.e(getOrderInfoData.getCreateTime(), "yyyy-MM-dd HH:mm:SS", "dd-MM-yyyy HH:mm");
        }
        baseViewHolder.setText((int) R.id.mTextOrderTime, (CharSequence) this.mContext.getResources().getString(R.string.purchase_time, new Object[]{str2}));
        baseViewHolder.setText((int) R.id.mTvPayMethod, (CharSequence) this.mContext.getResources().getString(R.string.order_pay_method, new Object[]{getOrderInfoData.getPaymentType()}));
        String paymentInfo = getOrderInfoData.getPaymentInfo();
        if (paymentInfo == null || paymentInfo.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            baseViewHolder.setVisible(R.id.mTvPay, false);
        } else {
            baseViewHolder.setVisible(R.id.mTvPay, true);
        }
        String uploadUrl = getOrderInfoData.getUploadUrl();
        if (uploadUrl == null || uploadUrl.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            baseViewHolder.setGone(R.id.mLayoutUploadVoucher, false);
        } else {
            baseViewHolder.setGone(R.id.mLayoutUploadVoucher, true);
        }
        baseViewHolder.setOnClickListener(R.id.mTvPay, new f(this, getOrderInfoData));
        baseViewHolder.setOnClickListener(R.id.mTvUploadVoucher, new g(this, getOrderInfoData));
        baseViewHolder.setOnClickListener(R.id.mTvFeedback, new h(this, getOrderInfoData));
        baseViewHolder.setOnClickListener(R.id.mTvOrderProcess, new i(this, getOrderInfoData));
    }

    public final void k(l lVar) {
        i.g(lVar, "callback");
        this.f16747a = lVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0093, code lost:
        if (r2.equals(com.titans.entity.CdnType.DIGITAL_TYPE_PCDN) == false) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00bc, code lost:
        if (r2.equals("3") == false) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00c0, code lost:
        r11.setText((int) com.msandroid.mobile.R.id.mTextState, (java.lang.CharSequence) r10.mContext.getResources().getString(com.msandroid.mobile.R.string.transaction_failed));
        r11.setGone(com.msandroid.mobile.R.id.mTvNote, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00d8, code lost:
        if (r2.equals("2") == false) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00e2, code lost:
        if (r2.equals("1") == false) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00e6, code lost:
        r11.setText((int) com.msandroid.mobile.R.id.mTextState, (java.lang.CharSequence) r10.mContext.getResources().getString(com.msandroid.mobile.R.string.order_payment_complete));
        r11.setGone(com.msandroid.mobile.R.id.mTvNote, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x021c, code lost:
        r11.setText((int) com.msandroid.mobile.R.id.mTextState, (java.lang.CharSequence) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(com.chad.library.adapter.base.BaseViewHolder r11, mobile.com.requestframe.utils.response.GetOrderInfoData r12) {
        /*
            r10 = this;
            r0 = 2131362826(0x7f0a040a, float:1.8345444E38)
            r1 = 0
            r11.setGone(r0, r1)
            java.lang.String r2 = r12.getState()
            int r3 = r2.hashCode()
            r4 = 2131821398(0x7f110356, float:1.9275538E38)
            r5 = 2131821617(0x7f110431, float:1.9275982E38)
            java.lang.String r6 = ""
            r7 = 1
            r8 = 2131362694(0x7f0a0386, float:1.8345176E38)
            r9 = 2131362805(0x7f0a03f5, float:1.83454E38)
            switch(r3) {
                case 48: goto L_0x00fb;
                case 49: goto L_0x00dc;
                case 50: goto L_0x00d2;
                case 51: goto L_0x00b6;
                case 52: goto L_0x0097;
                case 53: goto L_0x008d;
                case 54: goto L_0x0071;
                case 55: goto L_0x0042;
                case 56: goto L_0x0023;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x021c
        L_0x0023:
            java.lang.String r12 = "8"
            boolean r12 = r2.equals(r12)
            if (r12 != 0) goto L_0x002d
            goto L_0x021c
        L_0x002d:
            android.content.Context r12 = r10.mContext
            android.content.res.Resources r12 = r12.getResources()
            r0 = 2131821407(0x7f11035f, float:1.9275556E38)
            java.lang.String r12 = r12.getString(r0)
            r11.setText((int) r8, (java.lang.CharSequence) r12)
            r11.setGone(r9, r1)
            goto L_0x021f
        L_0x0042:
            java.lang.String r12 = "7"
            boolean r12 = r2.equals(r12)
            if (r12 != 0) goto L_0x004c
            goto L_0x021c
        L_0x004c:
            android.content.Context r12 = r10.mContext
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getString(r5)
            r11.setText((int) r8, (java.lang.CharSequence) r12)
            android.content.Context r12 = r10.mContext
            android.content.res.Resources r12 = r12.getResources()
            r2 = 2131821369(0x7f110339, float:1.927548E38)
            java.lang.String r12 = r12.getString(r2)
            r11.setText((int) r0, (java.lang.CharSequence) r12)
            r11.setGone(r0, r7)
            r11.setGone(r9, r1)
            goto L_0x021f
        L_0x0071:
            java.lang.String r12 = "6"
            boolean r12 = r2.equals(r12)
            if (r12 != 0) goto L_0x007b
            goto L_0x021c
        L_0x007b:
            android.content.Context r12 = r10.mContext
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getString(r4)
            r11.setText((int) r8, (java.lang.CharSequence) r12)
            r11.setGone(r9, r1)
            goto L_0x021f
        L_0x008d:
            java.lang.String r12 = "5"
            boolean r12 = r2.equals(r12)
            if (r12 != 0) goto L_0x00c0
            goto L_0x021c
        L_0x0097:
            java.lang.String r12 = "4"
            boolean r12 = r2.equals(r12)
            if (r12 != 0) goto L_0x00a1
            goto L_0x021c
        L_0x00a1:
            android.content.Context r12 = r10.mContext
            android.content.res.Resources r12 = r12.getResources()
            r0 = 2131821404(0x7f11035c, float:1.927555E38)
            java.lang.String r12 = r12.getString(r0)
            r11.setText((int) r8, (java.lang.CharSequence) r12)
            r11.setGone(r9, r1)
            goto L_0x021f
        L_0x00b6:
            java.lang.String r12 = "3"
            boolean r12 = r2.equals(r12)
            if (r12 != 0) goto L_0x00c0
            goto L_0x021c
        L_0x00c0:
            android.content.Context r12 = r10.mContext
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getString(r5)
            r11.setText((int) r8, (java.lang.CharSequence) r12)
            r11.setGone(r9, r1)
            goto L_0x021f
        L_0x00d2:
            java.lang.String r12 = "2"
            boolean r12 = r2.equals(r12)
            if (r12 != 0) goto L_0x00e6
            goto L_0x021c
        L_0x00dc:
            java.lang.String r12 = "1"
            boolean r12 = r2.equals(r12)
            if (r12 != 0) goto L_0x00e6
            goto L_0x021c
        L_0x00e6:
            android.content.Context r12 = r10.mContext
            android.content.res.Resources r12 = r12.getResources()
            r0 = 2131821397(0x7f110355, float:1.9275536E38)
            java.lang.String r12 = r12.getString(r0)
            r11.setText((int) r8, (java.lang.CharSequence) r12)
            r11.setGone(r9, r1)
            goto L_0x021f
        L_0x00fb:
            java.lang.String r0 = "0"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0105
            goto L_0x021c
        L_0x0105:
            int r0 = r12.isProcessing()
            if (r0 != r7) goto L_0x011c
            android.content.Context r12 = r10.mContext
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getString(r4)
            r11.setText((int) r8, (java.lang.CharSequence) r12)
            r11.setGone(r9, r1)
            return
        L_0x011c:
            android.content.Context r0 = r10.mContext
            android.content.res.Resources r0 = r0.getResources()
            r2 = 2131821409(0x7f110361, float:1.927556E38)
            java.lang.String r0 = r0.getString(r2)
            r11.setText((int) r8, (java.lang.CharSequence) r0)
            java.lang.String r0 = r12.getPaymentType()
            java.lang.String r2 = "Boleto"
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L_0x013d
            r11.setGone(r9, r1)
            goto L_0x021f
        L_0x013d:
            r11.setVisible(r9, r7)
            java.lang.String r12 = r12.getPaymentType()
            int r0 = r12.hashCode()
            switch(r0) {
                case -1911368973: goto L_0x0201;
                case -1650650849: goto L_0x01ee;
                case -185857904: goto L_0x01db;
                case -34572147: goto L_0x01c8;
                case 3242655: goto L_0x01b5;
                case 94423028: goto L_0x01a1;
                case 642271019: goto L_0x018c;
                case 1037568729: goto L_0x0177;
                case 1456686223: goto L_0x0162;
                case 1543015526: goto L_0x014d;
                default: goto L_0x014b;
            }
        L_0x014b:
            goto L_0x0213
        L_0x014d:
            java.lang.String r0 = "Payment in lotteries"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x0157
            goto L_0x0213
        L_0x0157:
            android.content.Context r12 = r10.mContext
            r0 = 2131821391(0x7f11034f, float:1.9275524E38)
            java.lang.String r6 = r12.getString(r0)
            goto L_0x0213
        L_0x0162:
            java.lang.String r0 = "Card virtual Caixa"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x016c
            goto L_0x0213
        L_0x016c:
            android.content.Context r12 = r10.mContext
            r0 = 2131821394(0x7f110352, float:1.927553E38)
            java.lang.String r6 = r12.getString(r0)
            goto L_0x0213
        L_0x0177:
            java.lang.String r0 = "Bank deposits"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x0181
            goto L_0x0213
        L_0x0181:
            android.content.Context r12 = r10.mContext
            r0 = 2131821386(0x7f11034a, float:1.9275514E38)
            java.lang.String r6 = r12.getString(r0)
            goto L_0x0213
        L_0x018c:
            java.lang.String r0 = "bancodobrasil"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x0196
            goto L_0x0213
        L_0x0196:
            android.content.Context r12 = r10.mContext
            r0 = 2131821385(0x7f110349, float:1.9275512E38)
            java.lang.String r6 = r12.getString(r0)
            goto L_0x0213
        L_0x01a1:
            java.lang.String r0 = "caixa"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x01ab
            goto L_0x0213
        L_0x01ab:
            android.content.Context r12 = r10.mContext
            r0 = 2131821388(0x7f11034c, float:1.9275518E38)
            java.lang.String r6 = r12.getString(r0)
            goto L_0x0213
        L_0x01b5:
            java.lang.String r0 = "itau"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x01be
            goto L_0x0213
        L_0x01be:
            android.content.Context r12 = r10.mContext
            r0 = 2131821389(0x7f11034d, float:1.927552E38)
            java.lang.String r6 = r12.getString(r0)
            goto L_0x0213
        L_0x01c8:
            java.lang.String r0 = "bradesco"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x01d1
            goto L_0x0213
        L_0x01d1:
            android.content.Context r12 = r10.mContext
            r0 = 2131821387(0x7f11034b, float:1.9275516E38)
            java.lang.String r6 = r12.getString(r0)
            goto L_0x0213
        L_0x01db:
            java.lang.String r0 = "Santander"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x01e4
            goto L_0x0213
        L_0x01e4:
            android.content.Context r12 = r10.mContext
            r0 = 2131821393(0x7f110351, float:1.9275528E38)
            java.lang.String r6 = r12.getString(r0)
            goto L_0x0213
        L_0x01ee:
            java.lang.String r0 = "Payment by Card"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x01f7
            goto L_0x0213
        L_0x01f7:
            android.content.Context r12 = r10.mContext
            r0 = 2131821390(0x7f11034e, float:1.9275522E38)
            java.lang.String r6 = r12.getString(r0)
            goto L_0x0213
        L_0x0201:
            java.lang.String r0 = "PayPal"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x020a
            goto L_0x0213
        L_0x020a:
            android.content.Context r12 = r10.mContext
            r0 = 2131821392(0x7f110350, float:1.9275526E38)
            java.lang.String r6 = r12.getString(r0)
        L_0x0213:
            java.lang.String r12 = "when (item.paymentType) … \"\"\n                    }"
            t9.i.f(r6, r12)
            r11.setText((int) r9, (java.lang.CharSequence) r6)
            goto L_0x021f
        L_0x021c:
            r11.setText((int) r8, (java.lang.CharSequence) r6)
        L_0x021f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.j.l(com.chad.library.adapter.base.BaseViewHolder, mobile.com.requestframe.utils.response.GetOrderInfoData):void");
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        BaseViewHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i10);
        i.f(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        AutoUtils.autoSize(onCreateViewHolder.itemView);
        return onCreateViewHolder;
    }
}
