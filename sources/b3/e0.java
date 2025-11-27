package b3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface e0 {

    public enum a {
        PROPERTY,
        WRAPPER_OBJECT,
        WRAPPER_ARRAY,
        EXTERNAL_PROPERTY,
        EXISTING_PROPERTY
    }

    public enum b {
        NONE((String) null),
        CLASS("@class"),
        MINIMAL_CLASS("@c"),
        NAME("@type"),
        DEDUCTION((String) null),
        CUSTOM((String) null);
        

        /* renamed from: a  reason: collision with root package name */
        public final String f4225a;

        /* access modifiers changed from: public */
        b(String str) {
            this.f4225a = str;
        }

        public String a() {
            return this.f4225a;
        }
    }

    public static abstract class c {
    }

    Class defaultImpl() default e0.class;

    a include() default a.PROPERTY;

    String property() default "";

    b use();

    boolean visible() default false;
}
