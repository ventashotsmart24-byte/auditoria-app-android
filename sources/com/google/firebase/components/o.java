package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import java.util.Map;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map.Entry f10156a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Event f10157b;

    public /* synthetic */ o(Map.Entry entry, Event event) {
        this.f10156a = entry;
        this.f10157b = event;
    }

    public final void run() {
        ((EventHandler) this.f10156a.getKey()).handle(this.f10157b);
    }
}
