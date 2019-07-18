package org.mudskipper.blankparamcheck.annotation;

import org.mudskipper.blankparamcheck.config.ComponentScanConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ComponentScanConfiguration.class})
public @interface EnableBlankParameterCheck {
}
