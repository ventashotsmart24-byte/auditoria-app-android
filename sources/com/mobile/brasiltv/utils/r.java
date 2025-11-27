package com.mobile.brasiltv.utils;

import android.widget.EditText;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class r implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f12610a;

    public /* synthetic */ r(EditText editText) {
        this.f12610a = editText;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        s.k(this.f12610a, observableEmitter);
    }
}
