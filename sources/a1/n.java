package a1;

import anet.channel.util.HttpConstant;

public interface n {

    /* renamed from: a  reason: collision with root package name */
    public static final b.c f125a = new b.c();

    /* renamed from: b  reason: collision with root package name */
    public static final b.C0003b f126b = new b.C0003b();

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            public final Throwable f127a;

            public a(Throwable th) {
                this.f127a = th;
            }

            public Throwable a() {
                return this.f127a;
            }

            public String toString() {
                return String.format("FAILURE (%s)", new Object[]{this.f127a.getMessage()});
            }
        }

        /* renamed from: a1.n$b$b  reason: collision with other inner class name */
        public static final class C0003b extends b {
            public String toString() {
                return "IN_PROGRESS";
            }

            public C0003b() {
            }
        }

        public static final class c extends b {
            public String toString() {
                return HttpConstant.SUCCESS;
            }

            public c() {
            }
        }
    }
}
