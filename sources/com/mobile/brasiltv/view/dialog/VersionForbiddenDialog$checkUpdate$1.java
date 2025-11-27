package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import com.mobile.bean.UpdateBean;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoFrameLayout;
import h7.a;
import t9.i;

public final class VersionForbiddenDialog$checkUpdate$1 implements a {
    final /* synthetic */ VersionForbiddenDialog this$0;

    public VersionForbiddenDialog$checkUpdate$1(VersionForbiddenDialog versionForbiddenDialog) {
        this.this$0 = versionForbiddenDialog;
    }

    public void onCompleted() {
    }

    public void onError(Throwable th) {
        ((AutoFrameLayout) this.this$0.findViewById(R$id.mAflLoading)).setVisibility(8);
        Context context = this.this$0.getContext();
        i.f(context, f.X);
        String string = this.this$0.getContext().getResources().getString(R.string.no_update);
        i.f(string, "context.resources.getString(R.string.no_update)");
        new OkDialog(context, string).setConfirmCallback(VersionForbiddenDialog$checkUpdate$1$onError$1.INSTANCE).show();
    }

    public void onReady() {
    }

    public void onOver(UpdateBean updateBean) {
        i.g(updateBean, "result");
        ((AutoFrameLayout) this.this$0.findViewById(R$id.mAflLoading)).setVisibility(8);
        this.this$0.handleForceUpgrade(updateBean);
        DialogManager.INSTANCE.clearSaveDialog(DialogManager.DIALOG_UPDATE);
        b0.j(this.this$0);
    }
}
