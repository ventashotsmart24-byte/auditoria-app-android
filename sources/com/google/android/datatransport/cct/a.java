package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.retries.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CctTransportBackend f5839a;

    public /* synthetic */ a(CctTransportBackend cctTransportBackend) {
        this.f5839a = cctTransportBackend;
    }

    public final Object apply(Object obj) {
        return this.f5839a.doSend((CctTransportBackend.HttpRequest) obj);
    }
}
