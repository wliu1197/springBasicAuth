package springBasicAuth.springBasicAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class SpringBasicAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBasicAuthApplication.class, args);
	}


}
