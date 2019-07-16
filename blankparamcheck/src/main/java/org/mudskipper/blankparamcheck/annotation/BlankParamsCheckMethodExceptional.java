package org.mudskipper.blankparamcheck.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BlankParamsCheckMethodExceptional {
    boolean name() default true;
}
