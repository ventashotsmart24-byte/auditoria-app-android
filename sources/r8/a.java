package r8;

import android.view.Surface;
import android.view.View;

public interface a {

    /* renamed from: r8.a$a  reason: collision with other inner class name */
    public interface C0281a {
        void a(b bVar);

        void b(b bVar, int i10, int i11);

        void c(b bVar, int i10, int i11, int i12);

        void d(int i10, int i11);
    }

    public interface b {
        a getRenderView();

        Surface openSurface();
    }

    void a(C0281a aVar);

    void b(C0281a aVar);

    View getView();

    void setAspectRatio(int i10);

    void setVideoRotation(int i10);

    void setVideoSize(int i10, int i11);
}
