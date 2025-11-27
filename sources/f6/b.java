package f6;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.text.DecimalFormat;
import java.util.Map;
import mobile.com.requestframe.utils.response.CouponCodeList;
import s9.l;
import t9.i;

public final class b extends BaseQuickAdapter {

    /* renamed from: a  reason: collision with root package name */
    public l f16735a;

    public b() {
        super((int) R.layout.itme_coupons);
    }

    public static final void c(b bVar, CouponCodeList couponCodeList, View view) {
        i.g(bVar, "this$0");
        i.g(couponCodeList, "$item");
        l lVar = bVar.f16735a;
        if (lVar != null) {
            lVar.invoke(couponCodeList);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0049, code lost:
        r0.setImageResource(com.msandroid.mobile.R.id.ivState, r1);
        r8.itemView.setSelected(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0026, code lost:
        if (r0.equals("2") == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002d, code lost:
        if (r0.equals("1") == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0030, code lost:
        r0 = r8.setGone(com.msandroid.mobile.R.id.tvRedeem, false).setGone(com.msandroid.mobile.R.id.ivState, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0040, code lost:
        if ("1".equals(r9.getStatus()) == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0042, code lost:
        r1 = com.msandroid.mobile.R.drawable.icon_coupons_used;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0046, code lost:
        r1 = com.msandroid.mobile.R.drawable.icon_coupons_expired;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void convert(com.chad.library.adapter.base.BaseViewHolder r8, mobile.com.requestframe.utils.response.CouponCodeList r9) {
        /*
            r7 = this;
            java.lang.String r0 = "helper"
            t9.i.g(r8, r0)
            java.lang.String r0 = "item"
            t9.i.g(r9, r0)
            java.lang.String r0 = r9.getStatus()
            int r1 = r0.hashCode()
            r2 = 2131362134(0x7f0a0156, float:1.834404E38)
            r3 = 2131363275(0x7f0a05cb, float:1.8346354E38)
            java.lang.String r4 = "1"
            r5 = 0
            r6 = 1
            switch(r1) {
                case 48: goto L_0x0052;
                case 49: goto L_0x0029;
                case 50: goto L_0x0020;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0067
        L_0x0020:
            java.lang.String r1 = "2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0030
            goto L_0x0067
        L_0x0029:
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0030
            goto L_0x0067
        L_0x0030:
            com.chad.library.adapter.base.BaseViewHolder r0 = r8.setGone(r3, r5)
            com.chad.library.adapter.base.BaseViewHolder r0 = r0.setGone(r2, r6)
            java.lang.String r1 = r9.getStatus()
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0046
            r1 = 2131231387(0x7f08029b, float:1.8078854E38)
            goto L_0x0049
        L_0x0046:
            r1 = 2131231386(0x7f08029a, float:1.8078852E38)
        L_0x0049:
            r0.setImageResource(r2, r1)
            android.view.View r0 = r8.itemView
            r0.setSelected(r5)
            goto L_0x0067
        L_0x0052:
            java.lang.String r1 = "0"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x005b
            goto L_0x0067
        L_0x005b:
            com.chad.library.adapter.base.BaseViewHolder r0 = r8.setGone(r3, r6)
            r0.setGone(r2, r5)
            android.view.View r0 = r8.itemView
            r0.setSelected(r6)
        L_0x0067:
            r0 = 2131363272(0x7f0a05c8, float:1.8346348E38)
            android.view.View r0 = r8.getView(r0)
            java.lang.String r1 = "helper.getView(R.id.tvPrice)"
            t9.i.f(r0, r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r7.f(r0, r9)
            java.lang.String r0 = r9.getCouponEffectType()
            boolean r0 = r4.equals(r0)
            java.lang.String r1 = "dd-MM-yyyy"
            if (r0 == 0) goto L_0x00c9
            java.lang.String r0 = r9.getEffectTime()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00c9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r9.getEffectTime()
            java.lang.String r2 = y6.b.d(r2, r1)
            r0.append(r2)
            java.lang.String r2 = " to "
            r0.append(r2)
            java.lang.String r2 = r9.getInvalidTime()
            java.lang.String r1 = y6.b.d(r2, r1)
            r0.append(r1)
            r1 = 40
            r0.append(r1)
            android.content.Context r1 = r7.mContext
            r2 = 2131820848(0x7f110130, float:1.9274423E38)
            java.lang.String r1 = r1.getString(r2)
            r0.append(r1)
            r1 = 41
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x00e3
        L_0x00c9:
            android.content.Context r0 = r7.mContext
            java.lang.Object[] r2 = new java.lang.Object[r6]
            java.lang.String r4 = r9.getInvalidTime()
            java.lang.String r1 = y6.b.d(r4, r1)
            r2[r5] = r1
            r1 = 2131820659(0x7f110073, float:1.927404E38)
            java.lang.String r0 = r0.getString(r1, r2)
            java.lang.String r1 = "{\n            mContext.g…,\"dd-MM-yyyy\"))\n        }"
            t9.i.f(r0, r1)
        L_0x00e3:
            android.content.Context r1 = r7.mContext
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = r9.getPackageLabel()
            r2[r5] = r4
            java.lang.String r4 = r9.getPackageName()
            r2[r6] = r4
            r4 = 2131820836(0x7f110124, float:1.9274398E38)
            java.lang.String r1 = r1.getString(r4, r2)
            java.lang.String r2 = "mContext.getString(R.str…eLabel, item.packageName)"
            t9.i.f(r1, r2)
            r2 = 2131363256(0x7f0a05b8, float:1.8346316E38)
            java.lang.String r4 = r9.getCouponTitle()
            com.chad.library.adapter.base.BaseViewHolder r2 = r8.setText((int) r2, (java.lang.CharSequence) r4)
            r4 = 2131363258(0x7f0a05ba, float:1.834632E38)
            com.chad.library.adapter.base.BaseViewHolder r0 = r2.setText((int) r4, (java.lang.CharSequence) r0)
            r2 = 2131363285(0x7f0a05d5, float:1.8346375E38)
            r0.setText((int) r2, (java.lang.CharSequence) r1)
            android.view.View r8 = r8.getView(r3)
            f6.a r0 = new f6.a
            r0.<init>(r7, r9)
            r8.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.b.convert(com.chad.library.adapter.base.BaseViewHolder, mobile.com.requestframe.utils.response.CouponCodeList):void");
    }

    public final String d(float f10) {
        String format = new DecimalFormat(IdManager.DEFAULT_VERSION_NAME).format((double) f10);
        i.f(format, "format.format(number.toDouble())");
        return format;
    }

    public final void e(l lVar) {
        this.f16735a = lVar;
    }

    public final void f(TextView textView, CouponCodeList couponCodeList) {
        float f10;
        Float f11;
        String couponCurrency = couponCodeList.getCouponCurrency();
        if (couponCurrency == null) {
            couponCurrency = "";
        }
        Map<String, Float> couponAmount = couponCodeList.getCouponAmount();
        if (couponAmount == null || (f11 = couponAmount.get(couponCurrency)) == null) {
            f10 = 0.0f;
        } else {
            f10 = f11.floatValue();
        }
        String d10 = d(f10);
        String str = d10 + couponCurrency;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(AutoUtils.getPercentWidthSize(24)), d10.length(), str.length(), 34);
        textView.setText(spannableStringBuilder);
    }
}
