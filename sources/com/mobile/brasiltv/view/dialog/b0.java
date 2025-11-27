package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;

public final /* synthetic */ class b0 implements Html.ImageGetter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f12718a;

    public /* synthetic */ b0(Context context) {
        this.f12718a = context;
    }

    public final Drawable getDrawable(String str) {
        return GuideDialog.mImageGetter$lambda$6(this.f12718a, str);
    }
}
