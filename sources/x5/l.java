package x5;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.mobile.brasiltv.mine.activity.OrderAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import f5.c;
import t9.i;

public final class l extends g {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(Context context, InAppMsg inAppMsg) {
        super(context, inAppMsg);
        i.g(context, f.X);
        i.g(inAppMsg, Constant.KEY_MSG);
    }

    public static final void c(l lVar, View view) {
        i.g(lVar, "this$0");
        Context mContext = lVar.getMContext();
        i.e(mContext, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.c0((c) mContext, OrderAty.class);
    }

    public int getDialogHeight() {
        return -2;
    }

    public int getDialogWidth() {
        return 600;
    }

    public int getLayoutId() {
        return R.layout.dialog_inapp_msg_service_effect;
    }

    public void initListener() {
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new k(this));
    }

    public void initView() {
        ((AutoCardView) findViewById(R$id.mAcvRoot)).setRadius((float) AutoUtils.getPercentWidthSize(28));
        ((TextView) findViewById(R$id.mTvTitle)).setText(a().getTitle());
        ((TextView) findViewById(R$id.mTvContent)).setText(a().getText());
        ((TextView) findViewById(R$id.mTvConfirm)).setText(getContext().getString(R.string.msg_inapp_go_check));
    }
}
