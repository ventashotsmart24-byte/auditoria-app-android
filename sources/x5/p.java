package x5;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import f5.c;
import t9.i;
import u5.a;
import w5.m;

public final class p extends f {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(Context context, InAppMsg inAppMsg) {
        super(context, inAppMsg);
        i.g(context, f.X);
        i.g(inAppMsg, Constant.KEY_MSG);
    }

    public static final void i(p pVar, View view) {
        i.g(pVar, "this$0");
        pVar.dismiss();
    }

    public static final void j(p pVar, View view) {
        i.g(pVar, "this$0");
        Context mContext = pVar.getMContext();
        i.e(mContext, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.E((c) mContext);
    }

    public static final void k(p pVar, View view) {
        i.g(pVar, "this$0");
        a.f19630a.b(App.f6050e.a(), "dont_remind", Boolean.TRUE);
        m.f19701a.n();
        pVar.dismiss();
    }

    public int getLayoutId() {
        return R.layout.dialog_inapp_msg_withdraw;
    }

    public void initListener() {
        ((TextView) findViewById(R$id.mTvCancel)).setOnClickListener(new m(this));
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new n(this));
        ((TextView) findViewById(R$id.mTvDontRemind)).setOnClickListener(new o(this));
    }

    public void initView() {
        ((AutoCardView) findViewById(R$id.mAcvRoot)).setRadius((float) AutoUtils.getPercentWidthSize(28));
        ((TextView) findViewById(R$id.mTvTitle)).setText(getContext().getString(R.string.msg_inapp_withdraw_title));
        ((TextView) findViewById(R$id.mTvContent)).setText(getContext().getString(R.string.msg_inapp_withdraw_content, new Object[]{String.valueOf(b0.X(a().getAvaliableCoin()))}));
        ((TextView) findViewById(R$id.mTvCancel)).setText(getContext().getString(R.string.msg_inapp_cancal));
        ((TextView) findViewById(R$id.mTvConfirm)).setText(getContext().getString(R.string.msg_inapp_go_withdraw));
        int i10 = R$id.mTvDontRemind;
        ((TextView) findViewById(i10)).setText(getContext().getString(R.string.msg_inapp_dont_remind));
        ((TextView) findViewById(i10)).getPaint().setFlags(8);
        ((TextView) findViewById(i10)).getPaint().setAntiAlias(true);
    }

    public void show() {
        super.show();
        m mVar = m.f19701a;
        mVar.Y(true);
        mVar.n();
    }
}
