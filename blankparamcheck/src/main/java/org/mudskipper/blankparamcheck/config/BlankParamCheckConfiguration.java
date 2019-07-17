package org.mudskipper.blankparamcheck.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "org.mudskipper.blankparamcheck.*"
})
public class BlankParamCheckConfiguration {
}
