package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoFrameLayout;
import h9.g;
import h9.h;
import org.android.agoo.message.MessageService;
import t9.i;

public final class CastFeedBackDialog extends CommonDialog implements View.OnClickListener, IFeedbackView {
    private final g feedbackHodler$delegate = h.b(new CastFeedBackDialog$feedbackHodler$2(this));
    private final g serviceHolder$delegate = h.b(new CastFeedBackDialog$serviceHolder$2(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CastFeedBackDialog(Context context) {
        super(context, 0, 2, (t9.g) null);
        i.g(context, f.X);
    }

    private final void hiedSoft() {
        Object obj;
        Context context = getContext();
        if (context != null) {
            obj = context.getSystemService("input_method");
        } else {
            obj = null;
        }
        i.e(obj, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) obj).hideSoftInputFromWindow(((AutoFrameLayout) findViewById(R$id.flFeedback)).getWindowToken(), 2);
    }

    public void cancel() {
        super.cancel();
        hiedSoft();
        getFeedbackHodler().dialogCancel();
        getServiceHolder().dialogCancel();
    }

    public void editActionDone() {
    }

    public int getDialogHeight() {
        return 820;
    }

    public int getDialogWidth() {
        return -1;
    }

    public final CastFeedBackHolder getFeedbackHodler() {
        return (CastFeedBackHolder) this.feedbackHodler$delegate.getValue();
    }

    public int getGravity() {
        return 80;
    }

    public int getLayoutId() {
        return R.layout.dialog_cast_feedback;
    }

    public final ServiceHolder getServiceHolder() {
        return (ServiceHolder) this.serviceHolder$delegate.getValue();
    }

    public String getType() {
        return MessageService.MSG_ACCS_NOTIFY_CLICK;
    }

    public void initListener() {
        ((AutoFrameLayout) findViewById(R$id.flFeedback)).setOnClickListener(this);
        ((AutoFrameLayout) findViewById(R$id.flService)).setOnClickListener(this);
        ((ImageView) findViewById(R$id.ivClose)).setOnClickListener(this);
    }

    public void initView() {
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        swichItem(0);
    }

    public void onClick(View view) {
        i.g(view, "v");
        switch (view.getId()) {
            case R.id.flFeedback:
                swichItem(0);
                return;
            case R.id.flService:
                hiedSoft();
                swichItem(1);
                return;
            case R.id.ivClose:
                dismiss();
                return;
            default:
                return;
        }
    }

    public void showLoading(boolean z10) {
    }

    public void submitBntEnable(boolean z10) {
    }

    public void submitSuc() {
        String str;
        dismiss();
        f1.a aVar = f1.f12517a;
        Context context = getContext();
        Context context2 = getContext();
        if (context2 == null || (str = context2.getString(R.string.thanks_feedback)) == null) {
            str = "";
        }
        aVar.k(context, str, 1);
    }

    public final void swichItem(int i10) {
        boolean z10;
        int i11 = R$id.flFeedback;
        AutoFrameLayout autoFrameLayout = (AutoFrameLayout) findViewById(i11);
        boolean z11 = true;
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        autoFrameLayout.setSelected(z10);
        int i12 = R$id.flService;
        AutoFrameLayout autoFrameLayout2 = (AutoFrameLayout) findViewById(i12);
        if (i10 != 1) {
            z11 = false;
        }
        autoFrameLayout2.setSelected(z11);
        showLoading(false);
        getFeedbackHodler().show(((AutoFrameLayout) findViewById(i11)).isSelected());
        getServiceHolder().show(((AutoFrameLayout) findViewById(i12)).isSelected());
    }
}
