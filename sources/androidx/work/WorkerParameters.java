package androidx.work;

import a1.f;
import a1.p;
import a1.v;
import android.net.Network;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {

    /* renamed from: a  reason: collision with root package name */
    public UUID f3344a;

    /* renamed from: b  reason: collision with root package name */
    public b f3345b;

    /* renamed from: c  reason: collision with root package name */
    public Set f3346c;

    /* renamed from: d  reason: collision with root package name */
    public a f3347d;

    /* renamed from: e  reason: collision with root package name */
    public int f3348e;

    /* renamed from: f  reason: collision with root package name */
    public Executor f3349f;

    /* renamed from: g  reason: collision with root package name */
    public m1.a f3350g;

    /* renamed from: h  reason: collision with root package name */
    public v f3351h;

    /* renamed from: i  reason: collision with root package name */
    public p f3352i;

    /* renamed from: j  reason: collision with root package name */
    public f f3353j;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List f3354a = Collections.emptyList();

        /* renamed from: b  reason: collision with root package name */
        public List f3355b = Collections.emptyList();

        /* renamed from: c  reason: collision with root package name */
        public Network f3356c;
    }

    public WorkerParameters(UUID uuid, b bVar, Collection collection, a aVar, int i10, Executor executor, m1.a aVar2, v vVar, p pVar, f fVar) {
        this.f3344a = uuid;
        this.f3345b = bVar;
        this.f3346c = new HashSet(collection);
        this.f3347d = aVar;
        this.f3348e = i10;
        this.f3349f = executor;
        this.f3350g = aVar2;
        this.f3351h = vVar;
        this.f3352i = pVar;
        this.f3353j = fVar;
    }

    public Executor a() {
        return this.f3349f;
    }

    public f b() {
        return this.f3353j;
    }

    public UUID c() {
        return this.f3344a;
    }

    public b d() {
        return this.f3345b;
    }

    public m1.a e() {
        return this.f3350g;
    }

    public v f() {
        return this.f3351h;
    }
}
