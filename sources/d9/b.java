package d9;

import b9.e;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final a f16431a;

    /* renamed from: b  reason: collision with root package name */
    public final e f16432b;

    /* renamed from: d9.b$b  reason: collision with other inner class name */
    public static class C0218b {

        /* renamed from: a  reason: collision with root package name */
        public a f16433a;

        /* renamed from: b  reason: collision with root package name */
        public e.b f16434b = new e.b();

        public b c() {
            if (this.f16433a != null) {
                return new b(this);
            }
            throw new IllegalStateException("url == null");
        }

        public C0218b d(String str, String str2) {
            this.f16434b.f(str, str2);
            return this;
        }

        public C0218b e(a aVar) {
            if (aVar != null) {
                this.f16433a = aVar;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }
    }

    public e a() {
        return this.f16432b;
    }

    public a b() {
        return this.f16431a;
    }

    public String toString() {
        return "Request{url=" + this.f16431a + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    public b(C0218b bVar) {
        this.f16431a = bVar.f16433a;
        this.f16432b = bVar.f16434b.c();
    }
}
