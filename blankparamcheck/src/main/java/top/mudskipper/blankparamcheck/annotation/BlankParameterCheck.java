package top.mudskipper.blankparamcheck.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BlankParameterCheck {
    boolean name() default true;
}
