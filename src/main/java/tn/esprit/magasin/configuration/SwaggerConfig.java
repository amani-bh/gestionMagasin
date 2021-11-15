package tn.esprit.magasin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)
	.select()
	.apis(RequestHandlerSelectors.any())
	.paths(PathSelectors.any())
	/*.apis(RequestHandlerSelectors.basePackage("com.esprit.magasin"))
	.paths(PathSelectors.regex("/client.*"))*/
	.build();
	}
	/*private ApiInfo apiInfo () {
		return new ApiInfoBuilder()
		.title("Swagger Configuration for tpStockProject")
		.description("\"Spring Boot Swagger configuration\"")
		.version("1.1.0").build();
		}*/
}