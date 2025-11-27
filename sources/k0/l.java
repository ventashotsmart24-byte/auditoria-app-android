package k0;

import android.media.VolumeProvider;
import android.os.Build;
import android.support.v4.media.session.a0;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public final int f7222a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7223b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7224c;

    /* renamed from: d  reason: collision with root package name */
    public int f7225d;

    /* renamed from: e  reason: collision with root package name */
    public c f7226e;

    /* renamed from: f  reason: collision with root package name */
    public VolumeProvider f7227f;

    public class a extends VolumeProvider {
        public a(int i10, int i11, int i12, String str) {
            super(i10, i11, i12, str);
        }

        public void onAdjustVolume(int i10) {
            l.this.e(i10);
        }

        public void onSetVolumeTo(int i10) {
            l.this.f(i10);
        }
    }

    public class b extends VolumeProvider {
        public b(int i10, int i11, int i12) {
            super(i10, i11, i12);
        }

        public void onAdjustVolume(int i10) {
            l.this.e(i10);
        }

        public void onSetVolumeTo(int i10) {
            l.this.f(i10);
        }
    }

    public static abstract class c {
        public abstract void a(l lVar);
    }

    public l(int i10, int i11, int i12, String str) {
        this.f7222a = i10;
        this.f7223b = i11;
        this.f7225d = i12;
        this.f7224c = str;
    }

    public final int a() {
        return this.f7225d;
    }

    public final int b() {
        return this.f7223b;
    }

    public final int c() {
        return this.f7222a;
    }

    public Object d() {
        if (this.f7227f == null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f7227f = new a(this.f7222a, this.f7223b, this.f7225d, this.f7224c);
            } else if (i10 >= 21) {
                this.f7227f = new b(this.f7222a, this.f7223b, this.f7225d);
            }
        }
        return this.f7227f;
    }

    public abstract void e(int i10);

    public abstract void f(int i10);

    public void g(c cVar) {
        this.f7226e = cVar;
    }

    public final void h(int i10) {
        this.f7225d = i10;
        if (Build.VERSION.SDK_INT >= 21) {
            a0.a(d()).setCurrentVolume(i10);
        }
        c cVar = this.f7226e;
        if (cVar != null) {
            cVar.a(this);
        }
    }
}
