package top.mudskipper.blankparamcheck.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "top.mudskipper.blankparamcheck.*"
})
public class ComponentScanConfiguration {
}
