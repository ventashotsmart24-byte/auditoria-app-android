package y8;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import y8.l;

public final class v {

    /* renamed from: c  reason: collision with root package name */
    public static final Joiner f20173c = Joiner.on((char) ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);

    /* renamed from: d  reason: collision with root package name */
    public static final v f20174d = a().f(new l.a(), true).f(l.b.f20085a, false);

    /* renamed from: a  reason: collision with root package name */
    public final Map f20175a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f20176b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final u f20177a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f20178b;

        public a(u uVar, boolean z10) {
            this.f20177a = (u) Preconditions.checkNotNull(uVar, "decompressor");
            this.f20178b = z10;
        }
    }

    public v(u uVar, boolean z10, v vVar) {
        String a10 = uVar.a();
        Preconditions.checkArgument(!a10.contains(","), "Comma is currently not allowed in message encoding");
        int size = vVar.f20175a.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(!vVar.f20175a.containsKey(uVar.a()) ? size + 1 : size);
        for (a aVar : vVar.f20175a.values()) {
            String a11 = aVar.f20177a.a();
            if (!a11.equals(a10)) {
                linkedHashMap.put(a11, new a(aVar.f20177a, aVar.f20178b));
            }
        }
        linkedHashMap.put(a10, new a(uVar, z10));
        this.f20175a = Collections.unmodifiableMap(linkedHashMap);
        this.f20176b = f20173c.join((Iterable<? extends Object>) b()).getBytes(Charset.forName("US-ASCII"));
    }

    public static v a() {
        return new v();
    }

    public static v c() {
        return f20174d;
    }

    public Set b() {
        HashSet hashSet = new HashSet(this.f20175a.size());
        for (Map.Entry entry : this.f20175a.entrySet()) {
            if (((a) entry.getValue()).f20178b) {
                hashSet.add((String) entry.getKey());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public byte[] d() {
        return this.f20176b;
    }

    public u e(String str) {
        a aVar = (a) this.f20175a.get(str);
        if (aVar != null) {
            return aVar.f20177a;
        }
        return null;
    }

    public v f(u uVar, boolean z10) {
        return new v(uVar, z10, this);
    }

    public v() {
        this.f20175a = new LinkedHashMap(0);
        this.f20176b = new byte[0];
    }
}
