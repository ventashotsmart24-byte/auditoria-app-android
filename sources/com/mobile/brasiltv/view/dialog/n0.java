package com.mobile.brasiltv.view.dialog;

import android.content.DialogInterface;
import io.reactivex.disposables.Disposable;

public final /* synthetic */ class n0 implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Disposable f12760a;

    public /* synthetic */ n0(Disposable disposable) {
        this.f12760a = disposable;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        InterstitialDialog.onCreate$lambda$2(this.f12760a, dialogInterface);
    }
}
