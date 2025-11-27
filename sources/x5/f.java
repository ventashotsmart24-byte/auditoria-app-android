package x5;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.mobile.brasiltv.mine.activity.MyBenefitsAty;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import t9.i;

public class f extends g {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Context context, InAppMsg inAppMsg) {
        super(context, inAppMsg);
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(inAppMsg, Constant.KEY_MSG);
    }

    public static final void d(f fVar, View view) {
        i.g(fVar, "this$0");
        fVar.dismiss();
    }

    public static final void e(f fVar, View view) {
        i.g(fVar, "this$0");
        MyBenefitsAty.a.b(MyBenefitsAty.f12342r, fVar.getMContext(), 0, false, 6, (Object) null);
    }

    public int getDialogHeight() {
        return -2;
    }

    public int getDialogWidth() {
        return 600;
    }

    public int getLayoutId() {
        return R.layout.dialog_common_inapp_msg;
    }

    public void initListener() {
        ((TextView) findViewById(R$id.mTvCancel)).setOnClickListener(new d(this));
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new e(this));
    }

    public void initView() {
        ((AutoCardView) findViewById(R$id.mAcvRoot)).setRadius((float) AutoUtils.getPercentWidthSize(28));
        ((TextView) findViewById(R$id.mTvTitle)).setText(a().getTitle());
        ((TextView) findViewById(R$id.mTvContent)).setText(a().getText());
        ((TextView) findViewById(R$id.mTvCancel)).setText(getContext().getString(R.string.msg_inapp_cancal));
        ((TextView) findViewById(R$id.mTvConfirm)).setText(getContext().getString(R.string.msg_inapp_go_check));
    }
}
