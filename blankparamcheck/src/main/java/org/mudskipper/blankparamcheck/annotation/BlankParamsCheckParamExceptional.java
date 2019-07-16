package org.mudskipper.blankparamcheck.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BlankParamsCheckParamExceptional {
    String name() default "";
}
