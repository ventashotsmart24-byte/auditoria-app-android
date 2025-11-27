package ca;

import k9.f;

public final class k0 extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    public final f f11510a;

    public k0(f fVar) {
        this.f11510a = fVar;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public String getLocalizedMessage() {
        return this.f11510a.toString();
    }
}
