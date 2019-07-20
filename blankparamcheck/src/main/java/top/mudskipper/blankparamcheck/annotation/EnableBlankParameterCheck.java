package top.mudskipper.blankparamcheck.annotation;

import top.mudskipper.blankparamcheck.config.ComponentScanConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ComponentScanConfiguration.class})
public @interface EnableBlankParameterCheck {
}
