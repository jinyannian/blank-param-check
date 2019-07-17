package org.mudskipper.blankparamcheck.annotation;

import org.mudskipper.blankparamcheck.config.BlankParamCheckConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({BlankParamCheckConfiguration.class})
public @interface EnableBlankParamCheck {
}
