package sa;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface d {
    String column() default "";

    String defaultValue() default "";
}
