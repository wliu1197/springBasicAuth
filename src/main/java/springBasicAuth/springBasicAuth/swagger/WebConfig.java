package springBasicAuth.springBasicAuth.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//moving swagger-ui.html to /rest-api/swagger-ui.html
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/rest-api/**").addResourceLocations("classpath:/META-INF/resources/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/rest-api/v2/api-docs", "/v2/api-docs").setKeepQueryParams(true);
        registry.addRedirectViewController("/rest-api/swagger-resources/configuration/ui","/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/rest-api/swagger-resources/configuration/security","/swagger-resources/configuration/security");
        registry.addRedirectViewController("/rest-api/swagger-resources", "/swagger-resources");
    }
}