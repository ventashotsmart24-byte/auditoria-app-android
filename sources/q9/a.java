package q9;

import java.io.Closeable;

public abstract class a {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            h9.a.a(th, th2);
        }
    }
}
