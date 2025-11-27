package j0;

import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.lifecycle.y;
import androidx.loader.content.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a {

    /* renamed from: j0.a$a  reason: collision with other inner class name */
    public interface C0092a {
        b onCreateLoader(int i10, Bundle bundle);

        void onLoadFinished(b bVar, Object obj);

        void onLoaderReset(b bVar);
    }

    public static a b(g gVar) {
        return new b(gVar, ((y) gVar).getViewModelStore());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract b c(int i10, Bundle bundle, C0092a aVar);

    public abstract void d();
}
