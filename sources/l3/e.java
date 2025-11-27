package l3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface e {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f7619a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7620b;

        public a(e eVar) {
            this(eVar.buildMethodName(), eVar.withPrefix());
        }

        public a(String str, String str2) {
            this.f7619a = str;
            this.f7620b = str2;
        }
    }

    String buildMethodName() default "build";

    String withPrefix() default "with";
}
