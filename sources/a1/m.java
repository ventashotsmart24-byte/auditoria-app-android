package a1;

import a1.u;
import android.os.Build;
import androidx.work.OverwritingInputMerger;

public final class m extends u {

    public static final class a extends u.a {
        public a(Class cls) {
            super(cls);
            this.f143c.f7092d = OverwritingInputMerger.class.getName();
        }

        /* renamed from: e */
        public m c() {
            if (!this.f141a || Build.VERSION.SDK_INT < 23 || !this.f143c.f7098j.h()) {
                return new m(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* renamed from: f */
        public a d() {
            return this;
        }
    }

    public m(a aVar) {
        super(aVar.f142b, aVar.f143c, aVar.f144d);
    }

    public static m d(Class cls) {
        return (m) new a(cls).b();
    }
}
