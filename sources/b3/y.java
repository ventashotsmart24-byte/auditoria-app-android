package b3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface y {
    boolean alphabetic() default false;

    String[] value() default {};
}
