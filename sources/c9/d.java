package c9;

import okhttp3.internal.http2.Header;
import okio.ByteString;

public final class d {

    /* renamed from: d  reason: collision with root package name */
    public static final ByteString f11413d = ByteString.encodeUtf8(":status");

    /* renamed from: e  reason: collision with root package name */
    public static final ByteString f11414e = ByteString.encodeUtf8(Header.TARGET_METHOD_UTF8);

    /* renamed from: f  reason: collision with root package name */
    public static final ByteString f11415f = ByteString.encodeUtf8(Header.TARGET_PATH_UTF8);

    /* renamed from: g  reason: collision with root package name */
    public static final ByteString f11416g = ByteString.encodeUtf8(Header.TARGET_SCHEME_UTF8);

    /* renamed from: h  reason: collision with root package name */
    public static final ByteString f11417h = ByteString.encodeUtf8(Header.TARGET_AUTHORITY_UTF8);

    /* renamed from: i  reason: collision with root package name */
    public static final ByteString f11418i = ByteString.encodeUtf8(":host");

    /* renamed from: j  reason: collision with root package name */
    public static final ByteString f11419j = ByteString.encodeUtf8(":version");

    /* renamed from: a  reason: collision with root package name */
    public final ByteString f11420a;

    /* renamed from: b  reason: collision with root package name */
    public final ByteString f11421b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11422c;

    public d(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f11420a.equals(dVar.f11420a) || !this.f11421b.equals(dVar.f11421b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f11420a.hashCode()) * 31) + this.f11421b.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", new Object[]{this.f11420a.utf8(), this.f11421b.utf8()});
    }

    public d(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public d(ByteString byteString, ByteString byteString2) {
        this.f11420a = byteString;
        this.f11421b = byteString2;
        this.f11422c = byteString.size() + 32 + byteString2.size();
    }
}
