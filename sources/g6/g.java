package g6;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.dialog.BaseDialog;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import t9.i;

public final class g extends BaseDialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context) {
        super(context);
        i.g(context, f.X);
    }

    public static final void c(g gVar, View view) {
        i.g(gVar, "this$0");
        gVar.cancel();
    }

    public static final void d(g gVar, View view) {
        i.g(gVar, "this$0");
        Context context = gVar.getContext();
        i.f(context, f.X);
        new d(context).show();
        gVar.cancel();
    }

    public void onCreate(Bundle bundle) {
        WindowManager.LayoutParams layoutParams;
        super.onCreate(bundle);
        setContentView((int) R.layout.dialog_restrict);
        Window window = getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 17;
            layoutParams.width = AutoUtils.getPercentWidthSize(520);
            layoutParams.height = AutoUtils.getPercentWidthSize(450);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(layoutParams);
            }
        }
        ((TextView) findViewById(R$id.mTextNo)).setOnClickListener(new e(this));
        ((TextView) findViewById(R$id.mTextYes)).setOnClickListener(new f(this));
    }
}
