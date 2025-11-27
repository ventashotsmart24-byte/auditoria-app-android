package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;

public class StringRegistry<V> extends DefaultRegistry<String, V> {
    private final Function<String, String> CASE_FN;
    private final Map<String, V> CI_VALUES;

    public static final class CaseInsensitiveFunction implements Function<String, String> {
        /* access modifiers changed from: private */
        public static final CaseInsensitiveFunction ENGLISH = new CaseInsensitiveFunction(Locale.ENGLISH);
        private final Locale LOCALE;

        private CaseInsensitiveFunction(Locale locale) {
            this.LOCALE = (Locale) Assert.notNull(locale, "Case insensitive Locale argument cannot be null.");
        }

        public String apply(String str) {
            return ((String) Assert.notNull(Strings.clean(str), "String identifier cannot be null or empty.")).toUpperCase(this.LOCALE);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StringRegistry(String str, String str2, Collection<V> collection, Function<V, String> function, boolean z10) {
        this(str, str2, collection, function, (Function<String, String>) z10 ? Functions.identity() : CaseInsensitiveFunction.ENGLISH);
    }

    public V get(Object obj) {
        String str = (String) obj;
        Assert.hasText(str, "id argument cannot be null or empty.");
        V v10 = super.get(str);
        if (v10 != null) {
            return v10;
        }
        return this.CI_VALUES.get(this.CASE_FN.apply(str));
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [io.jsonwebtoken.impl.lang.Function<java.lang.String, java.lang.String>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public StringRegistry(java.lang.String r2, java.lang.String r3, java.util.Collection<V> r4, io.jsonwebtoken.impl.lang.Function<V, java.lang.String> r5, io.jsonwebtoken.impl.lang.Function<java.lang.String, java.lang.String> r6) {
        /*
            r1 = this;
            r1.<init>(r2, r3, r4, r5)
            java.lang.String r2 = "Case function cannot be null."
            java.lang.Object r2 = io.jsonwebtoken.lang.Assert.notNull(r6, r2)
            io.jsonwebtoken.impl.lang.Function r2 = (io.jsonwebtoken.impl.lang.Function) r2
            r1.CASE_FN = r2
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            java.util.Collection r3 = r1.values()
            int r3 = r3.size()
            r2.<init>(r3)
            java.util.Iterator r3 = r4.iterator()
        L_0x001e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = r3.next()
            java.lang.Object r6 = r5.apply(r4)
            java.lang.String r6 = (java.lang.String) r6
            io.jsonwebtoken.impl.lang.Function<java.lang.String, java.lang.String> r0 = r1.CASE_FN
            java.lang.Object r6 = r0.apply(r6)
            java.lang.String r6 = (java.lang.String) r6
            r2.put(r6, r4)
            goto L_0x001e
        L_0x003a:
            java.util.Map r2 = io.jsonwebtoken.lang.Collections.immutable(r2)
            r1.CI_VALUES = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.lang.StringRegistry.<init>(java.lang.String, java.lang.String, java.util.Collection, io.jsonwebtoken.impl.lang.Function, io.jsonwebtoken.impl.lang.Function):void");
    }
}
