package b3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface m {
    Class generator();

    String property() default "@id";

    Class resolver() default r0.class;

    Class scope() default Object.class;
}
