package b3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface g0 {
    boolean enabled() default true;

    String prefix() default "";

    String suffix() default "";
}
