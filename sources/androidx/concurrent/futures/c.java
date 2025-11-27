package androidx.concurrent.futures;

import java.util.concurrent.Executor;

public enum c implements Executor {
    INSTANCE;

    public void execute(Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        return "DirectExecutor";
    }
}
