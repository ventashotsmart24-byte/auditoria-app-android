package y8;

import com.google.common.base.Preconditions;
import com.umeng.analytics.pro.f;
import java.util.concurrent.Executor;
import y8.b;

public final class m extends b {

    /* renamed from: a  reason: collision with root package name */
    public final b f20091a;

    /* renamed from: b  reason: collision with root package name */
    public final b f20092b;

    public final class a extends b.a {

        /* renamed from: a  reason: collision with root package name */
        public final b.C0295b f20093a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f20094b;

        /* renamed from: c  reason: collision with root package name */
        public final b.a f20095c;

        /* renamed from: d  reason: collision with root package name */
        public final r f20096d;

        public a(b.C0295b bVar, Executor executor, b.a aVar, r rVar) {
            this.f20093a = bVar;
            this.f20094b = executor;
            this.f20095c = (b.a) Preconditions.checkNotNull(aVar, "delegate");
            this.f20096d = (r) Preconditions.checkNotNull(rVar, f.X);
        }
    }

    public m(b bVar, b bVar2) {
        this.f20091a = (b) Preconditions.checkNotNull(bVar, "creds1");
        this.f20092b = (b) Preconditions.checkNotNull(bVar2, "creds2");
    }

    public void a(b.C0295b bVar, Executor executor, b.a aVar) {
        this.f20091a.a(bVar, executor, new a(bVar, executor, aVar, r.e()));
    }
}
