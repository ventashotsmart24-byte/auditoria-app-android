package retrofit2;

import h9.l;
import h9.m;
import kotlin.coroutines.Continuation;
import l9.b;

public final class KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 implements Runnable {
    final /* synthetic */ Continuation $continuation;
    final /* synthetic */ Exception $this_suspendAndThrow$inlined;

    public KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1(Continuation continuation, Exception exc) {
        this.$continuation = continuation;
        this.$this_suspendAndThrow$inlined = exc;
    }

    public final void run() {
        Continuation b10 = b.b(this.$continuation);
        Exception exc = this.$this_suspendAndThrow$inlined;
        l.a aVar = l.f17317a;
        b10.resumeWith(l.a(m.a(exc)));
    }
}
