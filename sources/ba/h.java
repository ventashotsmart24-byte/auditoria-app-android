package ba;

import aa.g;
import i9.r;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import s9.l;
import t9.i;
import t9.j;
import y9.c;

public final class h implements g {

    /* renamed from: a  reason: collision with root package name */
    public final Matcher f11349a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f11350b;

    /* renamed from: c  reason: collision with root package name */
    public final f f11351c = new b(this);

    /* renamed from: d  reason: collision with root package name */
    public List f11352d;

    public static final class a extends i9.b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f11353b;

        public a(h hVar) {
            this.f11353b = hVar;
        }

        public int a() {
            return this.f11353b.c().groupCount() + 1;
        }

        public /* bridge */ boolean b(String str) {
            return super.contains(str);
        }

        /* renamed from: c */
        public String get(int i10) {
            String group = this.f11353b.c().group(i10);
            if (group == null) {
                return "";
            }
            return group;
        }

        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            return b((String) obj);
        }

        public /* bridge */ int d(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int e(String str) {
            return super.lastIndexOf(str);
        }

        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return d((String) obj);
        }

        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return e((String) obj);
        }
    }

    public static final class b extends i9.a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f11354a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f11355a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar) {
                super(1);
                this.f11355a = bVar;
            }

            public final e b(int i10) {
                return this.f11355a.c(i10);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return b(((Number) obj).intValue());
            }
        }

        public b(h hVar) {
            this.f11354a = hVar;
        }

        public int a() {
            return this.f11354a.c().groupCount() + 1;
        }

        public /* bridge */ boolean b(e eVar) {
            return super.contains(eVar);
        }

        public e c(int i10) {
            c c10 = j.f(this.f11354a.c(), i10);
            if (c10.h().intValue() < 0) {
                return null;
            }
            String group = this.f11354a.c().group(i10);
            i.f(group, "matchResult.group(index)");
            return new e(group, c10);
        }

        public final /* bridge */ boolean contains(Object obj) {
            boolean z10;
            if (obj == null) {
                z10 = true;
            } else {
                z10 = obj instanceof e;
            }
            if (!z10) {
                return false;
            }
            return b((e) obj);
        }

        public boolean isEmpty() {
            return false;
        }

        public Iterator iterator() {
            return g.d(r.o(i9.j.e(this)), new a(this)).iterator();
        }
    }

    public h(Matcher matcher, CharSequence charSequence) {
        i.g(matcher, "matcher");
        i.g(charSequence, "input");
        this.f11349a = matcher;
        this.f11350b = charSequence;
    }

    public List a() {
        if (this.f11352d == null) {
            this.f11352d = new a(this);
        }
        List list = this.f11352d;
        i.d(list);
        return list;
    }

    public final MatchResult c() {
        return this.f11349a;
    }

    public c getRange() {
        return j.e(c());
    }

    public g next() {
        int i10;
        int end = c().end();
        if (c().end() == c().start()) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        int i11 = end + i10;
        if (i11 > this.f11350b.length()) {
            return null;
        }
        Matcher matcher = this.f11349a.pattern().matcher(this.f11350b);
        i.f(matcher, "matcher.pattern().matcher(input)");
        return j.d(matcher, i11, this.f11350b);
    }
}
