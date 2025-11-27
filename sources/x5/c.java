package x5;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import d6.b;
import t9.i;

public final class c extends f {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, InAppMsg inAppMsg) {
        super(context, inAppMsg);
        i.g(context, f.X);
        i.g(inAppMsg, Constant.KEY_MSG);
    }

    public static final void h(c cVar, View view) {
        i.g(cVar, "this$0");
        cVar.dismiss();
    }

    public static final void i(c cVar, View view) {
        boolean z10;
        i.g(cVar, "this$0");
        String url = cVar.a().getUrl();
        if (url == null || url.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            b0.j0(cVar.getMContext(), cVar.a().getUrl(), false, true, false, false, 24, (Object) null);
        } else if (b.f6366a.y()) {
            f1.a.j(f1.f12517a, cVar.getContext(), R.string.vod_please_bind, 0, 4, (Object) null);
        } else {
            Context mContext = cVar.getMContext();
            i.e(mContext, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
            b0.C((f5.c) mContext);
        }
    }

    public void initListener() {
        ((TextView) findViewById(R$id.mTvCancel)).setOnClickListener(new a(this));
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new b(this));
    }
}
