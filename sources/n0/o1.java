package n0;

import android.os.Build;
import android.os.Bundle;

public class o1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f7961a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f7962b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f7963c;

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f7964d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f7965a = 1;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7966b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7967c;

        /* renamed from: d  reason: collision with root package name */
        public Bundle f7968d;

        public o1 a() {
            return new o1(this);
        }

        public a b(boolean z10) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f7966b = z10;
            }
            return this;
        }

        public a c(boolean z10) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f7967c = z10;
            }
            return this;
        }
    }

    public o1(a aVar) {
        Bundle bundle;
        this.f7961a = aVar.f7965a;
        this.f7962b = aVar.f7966b;
        this.f7963c = aVar.f7967c;
        Bundle bundle2 = aVar.f7968d;
        if (bundle2 == null) {
            bundle = Bundle.EMPTY;
        } else {
            bundle = new Bundle(bundle2);
        }
        this.f7964d = bundle;
    }

    public int a() {
        return this.f7961a;
    }

    public Bundle b() {
        return this.f7964d;
    }

    public boolean c() {
        return this.f7962b;
    }

    public boolean d() {
        return this.f7963c;
    }
}
