package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoFrameLayout;
import h9.h;
import java.util.ArrayList;
import java.util.List;
import t9.g;
import t9.i;

public final class FeedBackDialog extends CommonDialog implements View.OnClickListener, IFeedbackView {
    public static final Companion Companion = new Companion((g) null);
    public static final int LIVE_TYPE = 2;
    public static final int VOD_TYPE = 1;
    /* access modifiers changed from: private */
    public static ArrayList<String> mEmailSuffixList = new ArrayList<>();
    private final h9.g contentHolder$delegate;
    private Context ctx;
    private final h9.g feedbackHodler$delegate;
    private final h9.g serviceHolder$delegate = h.b(new FeedBackDialog$serviceHolder$2(this));
    private int type;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final CommonDialog getFeedBackDialog(Context context, boolean z10, int i10, String str) {
            i.g(context, f.X);
            i.g(str, "name");
            if (z10) {
                return new FeedBackFullScreenDialog(context, z10, i10, str);
            }
            return new FeedBackDialog(context, i10, str);
        }

        public final ArrayList<String> getMEmailSuffixList() {
            return FeedBackDialog.mEmailSuffixList;
        }

        public final void setMEmailSuffixList(ArrayList<String> arrayList) {
            i.g(arrayList, "<set-?>");
            FeedBackDialog.mEmailSuffixList = arrayList;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBackDialog(Context context, int i10, String str) {
        super(context, 0, 2, (g) null);
        i.g(context, "ctx");
        i.g(str, "name");
        this.ctx = context;
        this.type = i10;
        this.feedbackHodler$delegate = h.b(new FeedBackDialog$feedbackHodler$2(str, this));
        this.contentHolder$delegate = h.b(new FeedBackDialog$contentHolder$2(str, this));
    }

    private final void getEmailSuffixList(Context context) {
        w6.i.f9510g.b().q1().subscribe(new FeedBackDialog$getEmailSuffixList$1(this));
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

    /* access modifiers changed from: private */
    public final void updateEmailSuffixList(List<String> list) {
        mEmailSuffixList.clear();
        if (!list.isEmpty()) {
            mEmailSuffixList.addAll(list);
        }
    }

    public void cancel() {
        super.cancel();
        hiedSoft();
        getFeedbackHodler().dialogCancel();
        getContentHolder().dialogCancel();
        getServiceHolder().dialogCancel();
    }

    public void editActionDone() {
    }

    public final ContentHolder getContentHolder() {
        return (ContentHolder) this.contentHolder$delegate.getValue();
    }

    public final Context getCtx() {
        return this.ctx;
    }

    public int getDialogHeight() {
        return 880;
    }

    public int getDialogWidth() {
        return -1;
    }

    public final FeedbackHolder getFeedbackHodler() {
        return (FeedbackHolder) this.feedbackHodler$delegate.getValue();
    }

    public int getGravity() {
        return 80;
    }

    public int getLayoutId() {
        return R.layout.dialog_feedback;
    }

    public final ServiceHolder getServiceHolder() {
        return (ServiceHolder) this.serviceHolder$delegate.getValue();
    }

    public final int getType() {
        return this.type;
    }

    public void initListener() {
        ((ImageView) findViewById(R$id.ivClose)).setOnClickListener(this);
        ((AutoFrameLayout) findViewById(R$id.flFeedback)).setOnClickListener(this);
        ((AutoFrameLayout) findViewById(R$id.flContent)).setOnClickListener(this);
        ((AutoFrameLayout) findViewById(R$id.flService)).setOnClickListener(this);
    }

    public void initView() {
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        Context context = getContext();
        i.f(context, f.X);
        getEmailSuffixList(context);
        swichItem(0);
    }

    public void onClick(View view) {
        i.g(view, "v");
        int id = view.getId();
        if (id != R.id.ivClose) {
            switch (id) {
                case R.id.flContent:
                    swichItem(1);
                    hiedSoft();
                    return;
                case R.id.flFeedback:
                    hiedSoft();
                    swichItem(0);
                    return;
                case R.id.flService:
                    swichItem(2);
                    hiedSoft();
                    return;
                default:
                    return;
            }
        } else {
            dismiss();
        }
    }

    public final void setCtx(Context context) {
        i.g(context, "<set-?>");
        this.ctx = context;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    public void showLoading(boolean z10) {
        int i10;
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.loading);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        frameLayout.setVisibility(i10);
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
        boolean z11;
        int i11 = R$id.flFeedback;
        AutoFrameLayout autoFrameLayout = (AutoFrameLayout) findViewById(i11);
        boolean z12 = true;
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        autoFrameLayout.setSelected(z10);
        int i12 = R$id.flContent;
        AutoFrameLayout autoFrameLayout2 = (AutoFrameLayout) findViewById(i12);
        if (i10 == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        autoFrameLayout2.setSelected(z11);
        int i13 = R$id.flService;
        AutoFrameLayout autoFrameLayout3 = (AutoFrameLayout) findViewById(i13);
        if (i10 != 2) {
            z12 = false;
        }
        autoFrameLayout3.setSelected(z12);
        showLoading(false);
        getFeedbackHodler().show(((AutoFrameLayout) findViewById(i11)).isSelected());
        getContentHolder().show(((AutoFrameLayout) findViewById(i12)).isSelected());
        getServiceHolder().show(((AutoFrameLayout) findViewById(i13)).isSelected());
    }

    /* renamed from: getType  reason: collision with other method in class */
    public String m23getType() {
        return this.type == 1 ? CdnType.DIGITAL_TYPE_PEERSTAR : "7";
    }
}
