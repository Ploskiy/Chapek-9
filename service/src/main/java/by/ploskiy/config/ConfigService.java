package by.ploskiy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"by.ploskiy.services", "by.ploskiy.entitys"})
public class ConfigService {


}
