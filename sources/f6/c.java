package f6;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.text.DecimalFormat;
import java.util.Map;
import mobile.com.requestframe.utils.response.AvailableCouponCodeList;
import t9.i;

public final class c extends BaseQuickAdapter {
    public c() {
        super((int) R.layout.itme_coupons_available);
    }

    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, AvailableCouponCodeList availableCouponCodeList) {
        i.g(baseViewHolder, "helper");
        i.g(availableCouponCodeList, PlistBuilder.KEY_ITEM);
        View view = baseViewHolder.getView(R.id.tvPrice);
        i.f(view, "helper.getView(R.id.tvPrice)");
        c((TextView) view, availableCouponCodeList);
        String string = this.mContext.getString(R.string.coupons_use_on, new Object[]{availableCouponCodeList.getPackageLabel(), availableCouponCodeList.getPackageName()});
        i.f(string, "mContext.getString(R.str…eLabel, item.packageName)");
        baseViewHolder.setText((int) R.id.tvCouponsTitle, (CharSequence) availableCouponCodeList.getCouponTitle()).setText((int) R.id.tvUseOn, (CharSequence) string);
    }

    public final String b(float f10) {
        String format = new DecimalFormat(IdManager.DEFAULT_VERSION_NAME).format((double) f10);
        i.f(format, "format.format(number.toDouble())");
        return format;
    }

    public final void c(TextView textView, AvailableCouponCodeList availableCouponCodeList) {
        float f10;
        Float f11;
        String couponCurrency = availableCouponCodeList.getCouponCurrency();
        if (couponCurrency == null) {
            couponCurrency = "";
        }
        Map<String, Float> couponAmount = availableCouponCodeList.getCouponAmount();
        if (couponAmount == null || (f11 = couponAmount.get(couponCurrency)) == null) {
            f10 = 0.0f;
        } else {
            f10 = f11.floatValue();
        }
        String b10 = b(f10);
        String str = b10 + couponCurrency;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(AutoUtils.getPercentWidthSize(24)), b10.length(), str.length(), 34);
        textView.setText(spannableStringBuilder);
    }
}
