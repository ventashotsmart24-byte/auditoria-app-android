package com.mobile.brasiltv.view.dialog;

import android.animation.ObjectAnimator;
import android.view.KeyEvent;
import android.view.View;

public final /* synthetic */ class e0 implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ObjectAnimator f12727a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GuideDialog f12728b;

    public /* synthetic */ e0(ObjectAnimator objectAnimator, GuideDialog guideDialog) {
        this.f12727a = objectAnimator;
        this.f12728b = guideDialog;
    }

    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        return GuideDialog.initThumbnailArrow$lambda$5(this.f12727a, this.f12728b, view, i10, keyEvent);
    }
}
