package x5;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.mobile.brasiltv.mine.activity.OrderAty;
import com.mobile.brasiltv.utils.b0;
import com.umeng.analytics.pro.f;
import f5.c;
import t9.i;

public final class j extends f {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(Context context, InAppMsg inAppMsg) {
        super(context, inAppMsg);
        i.g(context, f.X);
        i.g(inAppMsg, Constant.KEY_MSG);
    }

    public static final void h(j jVar, View view) {
        i.g(jVar, "this$0");
        jVar.dismiss();
    }

    public static final void i(j jVar, View view) {
        i.g(jVar, "this$0");
        Context mContext = jVar.getMContext();
        i.e(mContext, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.c0((c) mContext, OrderAty.class);
    }

    public void initListener() {
        ((TextView) findViewById(R$id.mTvCancel)).setOnClickListener(new h(this));
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new i(this));
    }
}
