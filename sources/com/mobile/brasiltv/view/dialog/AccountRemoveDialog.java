package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import s9.a;
import t9.g;
import t9.i;

public final class AccountRemoveDialog extends BaseDialog {
    private final String mAccount;
    private final a mCancelListener;
    private final a mRemoveListener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccountRemoveDialog(Context context, String str, a aVar, a aVar2, int i10, g gVar) {
        this(context, str, (i10 & 4) != 0 ? null : aVar, (i10 & 8) != 0 ? null : aVar2);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(AccountRemoveDialog accountRemoveDialog, View view) {
        i.g(accountRemoveDialog, "this$0");
        accountRemoveDialog.dismiss();
        a aVar = accountRemoveDialog.mCancelListener;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(AccountRemoveDialog accountRemoveDialog, View view) {
        i.g(accountRemoveDialog, "this$0");
        accountRemoveDialog.dismiss();
        a aVar = accountRemoveDialog.mRemoveListener;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(AccountRemoveDialog accountRemoveDialog, DialogInterface dialogInterface) {
        i.g(accountRemoveDialog, "this$0");
        a aVar = accountRemoveDialog.mCancelListener;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.dialog_account_remove);
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.3f);
        }
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new a(this));
        ((TextView) findViewById(R$id.mTvAccount)).setText(this.mAccount);
        ((TextView) findViewById(R$id.mTvRemove)).setOnClickListener(new b(this));
        setOnCancelListener(new c(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountRemoveDialog(Context context, String str, a aVar, a aVar2) {
        super(context);
        i.g(context, f.X);
        i.g(str, "mAccount");
        this.mAccount = str;
        this.mRemoveListener = aVar;
        this.mCancelListener = aVar2;
    }
}
