package a1;

import android.os.Build;
import j1.p;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class u {

    /* renamed from: a  reason: collision with root package name */
    public UUID f138a;

    /* renamed from: b  reason: collision with root package name */
    public p f139b;

    /* renamed from: c  reason: collision with root package name */
    public Set f140c;

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f141a = false;

        /* renamed from: b  reason: collision with root package name */
        public UUID f142b = UUID.randomUUID();

        /* renamed from: c  reason: collision with root package name */
        public p f143c;

        /* renamed from: d  reason: collision with root package name */
        public Set f144d = new HashSet();

        /* renamed from: e  reason: collision with root package name */
        public Class f145e;

        public a(Class cls) {
            this.f145e = cls;
            this.f143c = new p(this.f142b.toString(), cls.getName());
            a(cls.getName());
        }

        public final a a(String str) {
            this.f144d.add(str);
            return d();
        }

        public final u b() {
            boolean z10;
            u c10 = c();
            b bVar = this.f143c.f7098j;
            int i10 = Build.VERSION.SDK_INT;
            if ((i10 < 24 || !bVar.e()) && !bVar.f() && !bVar.g() && (i10 < 23 || !bVar.h())) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!this.f143c.f7105q || !z10) {
                this.f142b = UUID.randomUUID();
                p pVar = new p(this.f143c);
                this.f143c = pVar;
                pVar.f7089a = this.f142b.toString();
                return c10;
            }
            throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
        }

        public abstract u c();

        public abstract a d();
    }

    public u(UUID uuid, p pVar, Set set) {
        this.f138a = uuid;
        this.f139b = pVar;
        this.f140c = set;
    }

    public String a() {
        return this.f138a.toString();
    }

    public Set b() {
        return this.f140c;
    }

    public p c() {
        return this.f139b;
    }
}
