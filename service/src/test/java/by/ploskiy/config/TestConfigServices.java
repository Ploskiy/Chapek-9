package by.ploskiy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ConfigService.class)
public class TestConfigServices {
}
