package b0;

import a0.c;
import android.os.Build;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final Object f4105a;

    public h(Object obj) {
        this.f4105a = obj;
    }

    public static h e(Object obj) {
        if (obj == null) {
            return null;
        }
        return new h(obj);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return c.a(this.f4105a).getSafeInsetBottom();
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return c.a(this.f4105a).getSafeInsetLeft();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return c.a(this.f4105a).getSafeInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return c.a(this.f4105a).getSafeInsetTop();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return c.a(this.f4105a, ((h) obj).f4105a);
    }

    public int hashCode() {
        Object obj = this.f4105a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f4105a + "}";
    }
}
