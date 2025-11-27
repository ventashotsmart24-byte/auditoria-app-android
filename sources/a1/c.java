package a1;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Set f100a = new HashSet();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f101a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f102b;

        public a(Uri uri, boolean z10) {
            this.f101a = uri;
            this.f102b = z10;
        }

        public Uri a() {
            return this.f101a;
        }

        public boolean b() {
            return this.f102b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f102b != aVar.f102b || !this.f101a.equals(aVar.f101a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f101a.hashCode() * 31) + (this.f102b ? 1 : 0);
        }
    }

    public void a(Uri uri, boolean z10) {
        this.f100a.add(new a(uri, z10));
    }

    public Set b() {
        return this.f100a;
    }

    public int c() {
        return this.f100a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.f100a.equals(((c) obj).f100a);
    }

    public int hashCode() {
        return this.f100a.hashCode();
    }
}
