package ca;

import java.util.concurrent.locks.LockSupport;

public abstract class s0 extends q0 {
    public abstract Thread X();

    public final void Y() {
        Thread X = X();
        if (Thread.currentThread() != X) {
            c.a();
            LockSupport.unpark(X);
        }
    }
}
