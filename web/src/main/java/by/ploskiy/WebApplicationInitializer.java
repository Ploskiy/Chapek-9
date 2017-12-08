package by.ploskiy;

import by.ploskiy.config.ConfigService;
import by.ploskiy.config.ConfigWeb;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {ConfigService.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ConfigWeb.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
