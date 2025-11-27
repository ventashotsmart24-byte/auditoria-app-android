package com.mobile.brasiltv.view.dialog;

import android.content.DialogInterface;
import io.reactivex.disposables.Disposable;

public final /* synthetic */ class h0 implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Disposable f12743a;

    public /* synthetic */ h0(Disposable disposable) {
        this.f12743a = disposable;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        HomeImportantAdDialog.onCreate$lambda$3(this.f12743a, dialogInterface);
    }
}
