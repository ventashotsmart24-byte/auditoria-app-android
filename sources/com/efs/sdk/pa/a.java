package com.efs.sdk.pa;

public final class a implements PAANRListener {

    /* renamed from: a  reason: collision with root package name */
    private PAFactory f5514a;

    /* renamed from: b  reason: collision with root package name */
    private PATraceListener f5515b;

    public a(PAFactory pAFactory) {
        this.f5514a = pAFactory;
        this.f5515b = pAFactory.getTraceListener();
        boolean enableTracer = pAFactory.getConfigManager().enableTracer();
        PATraceListener pATraceListener = this.f5515b;
        if (pATraceListener != null) {
            pATraceListener.onCheck(enableTracer);
        }
    }

    public final void anrStack(String str) {
        if (str != null && str.length() > 200) {
            c.a(this.f5514a, "patrace", str);
            PATraceListener pATraceListener = this.f5515b;
            if (pATraceListener != null) {
                pATraceListener.onAnrTrace();
            }
        }
    }

    public final void unexcept(Object obj) {
        PATraceListener pATraceListener = this.f5515b;
        if (pATraceListener != null) {
            pATraceListener.onUnexcept(obj);
        }
    }
}
