package l3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import k3.y;

@Retention(RetentionPolicy.RUNTIME)
public @interface d {
    Class value() default y.class;
}
