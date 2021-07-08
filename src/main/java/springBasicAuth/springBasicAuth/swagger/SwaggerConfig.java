package springBasicAuth.springBasicAuth.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;
import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    private final ServletContext servletContext;

    @Autowired
    public SwaggerConfig(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Bean
    public Docket swaggerConfigs(){
        System.out.println("here runnnnnnnnn");

        /*return new Docket(DocumentationType.SWAGGER_2)
                .host("http://localhost:9091")
                .pathProvider(new RelativePathProvider(servletContext) {
                    @Override
                    public String getApplicationBasePath() {
                        return "/myapi";
                    }
                }).apiInfo(apiDetails());*/
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/rest-api/*"))
                .apis(RequestHandlerSelectors.basePackage("springBasicAuth.springBasicAuth"))
                .build()
                .apiInfo(apiDetails());
    }

    @Bean
    public UiConfiguration tryItOutConfig() {
        final String[] methodsWithTryItOutButton = { "get" };
        return UiConfigurationBuilder.builder().supportedSubmitMethods(methodsWithTryItOutButton).build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Test rest api",
                "Basic Auth example with swagger api",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("wen","",""),
                "",
                "",
                Collections.emptyList()
                );
    }
}
