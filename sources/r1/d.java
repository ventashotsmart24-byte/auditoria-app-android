package r1;

import java.io.Closeable;
import java.io.IOException;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f9011a = new d();

    public final void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
    }
}
