package org.mudskipper.blankparamcheck.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BlankParamCheck {
    boolean name() default true;
}
