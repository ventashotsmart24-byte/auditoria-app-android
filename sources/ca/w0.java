package ca;

import java.io.Closeable;
import k9.b;
import k9.f;
import s9.l;
import t9.g;
import t9.j;

public abstract class w0 extends y implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    public static final a f11554c = new a((g) null);

    public static final class a extends b {

        /* renamed from: ca.w0$a$a  reason: collision with other inner class name */
        public static final class C0154a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0154a f11555a = new C0154a();

            public C0154a() {
                super(1);
            }

            /* renamed from: b */
            public final w0 invoke(f.b bVar) {
                if (bVar instanceof w0) {
                    return (w0) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public a() {
            super(y.f11564b, C0154a.f11555a);
        }
    }
}
