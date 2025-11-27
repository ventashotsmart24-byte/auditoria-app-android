package y8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class w0 {

    /* renamed from: a  reason: collision with root package name */
    public final d f20194a;

    /* renamed from: b  reason: collision with root package name */
    public final String f20195b;

    /* renamed from: c  reason: collision with root package name */
    public final String f20196c;

    /* renamed from: d  reason: collision with root package name */
    public final c f20197d;

    /* renamed from: e  reason: collision with root package name */
    public final c f20198e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f20199f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f20200g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f20201h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f20202i;

    /* renamed from: j  reason: collision with root package name */
    public final AtomicReferenceArray f20203j;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public c f20204a;

        /* renamed from: b  reason: collision with root package name */
        public c f20205b;

        /* renamed from: c  reason: collision with root package name */
        public d f20206c;

        /* renamed from: d  reason: collision with root package name */
        public String f20207d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f20208e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f20209f;

        /* renamed from: g  reason: collision with root package name */
        public Object f20210g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f20211h;

        public b() {
        }

        public w0 a() {
            return new w0(this.f20206c, this.f20207d, this.f20204a, this.f20205b, this.f20210g, this.f20208e, this.f20209f, this.f20211h);
        }

        public b b(String str) {
            this.f20207d = str;
            return this;
        }

        public b c(c cVar) {
            this.f20204a = cVar;
            return this;
        }

        public b d(c cVar) {
            this.f20205b = cVar;
            return this;
        }

        public b e(boolean z10) {
            this.f20211h = z10;
            return this;
        }

        public b f(d dVar) {
            this.f20206c = dVar;
            return this;
        }
    }

    public interface c {
        InputStream a(Object obj);

        Object parse(InputStream inputStream);
    }

    public enum d {
        UNARY,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        BIDI_STREAMING,
        UNKNOWN;

        public final boolean a() {
            if (this == UNARY || this == SERVER_STREAMING) {
                return true;
            }
            return false;
        }
    }

    public static String a(String str) {
        int lastIndexOf = ((String) Preconditions.checkNotNull(str, "fullMethodName")).lastIndexOf(47);
        if (lastIndexOf == -1) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static String b(String str, String str2) {
        return ((String) Preconditions.checkNotNull(str, "fullServiceName")) + Operator.Operation.DIVISION + ((String) Preconditions.checkNotNull(str2, "methodName"));
    }

    public static b g() {
        return h((c) null, (c) null);
    }

    public static b h(c cVar, c cVar2) {
        return new b().c(cVar).d(cVar2);
    }

    public String c() {
        return this.f20195b;
    }

    public String d() {
        return this.f20196c;
    }

    public d e() {
        return this.f20194a;
    }

    public boolean f() {
        return this.f20201h;
    }

    public Object i(InputStream inputStream) {
        return this.f20198e.parse(inputStream);
    }

    public InputStream j(Object obj) {
        return this.f20197d.a(obj);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("fullMethodName", (Object) this.f20195b).add("type", (Object) this.f20194a).add("idempotent", this.f20200g).add("safe", this.f20201h).add("sampledToLocalTracing", this.f20202i).add("requestMarshaller", (Object) this.f20197d).add("responseMarshaller", (Object) this.f20198e).add("schemaDescriptor", this.f20199f).omitNullValues().toString();
    }

    public w0(d dVar, String str, c cVar, c cVar2, Object obj, boolean z10, boolean z11, boolean z12) {
        this.f20203j = new AtomicReferenceArray(2);
        this.f20194a = (d) Preconditions.checkNotNull(dVar, "type");
        this.f20195b = (String) Preconditions.checkNotNull(str, "fullMethodName");
        this.f20196c = a(str);
        this.f20197d = (c) Preconditions.checkNotNull(cVar, "requestMarshaller");
        this.f20198e = (c) Preconditions.checkNotNull(cVar2, "responseMarshaller");
        this.f20199f = obj;
        this.f20200g = z10;
        this.f20201h = z11;
        this.f20202i = z12;
    }
}
