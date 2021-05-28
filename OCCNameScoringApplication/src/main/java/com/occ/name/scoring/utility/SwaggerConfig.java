package com.occ.name.scoring.utility;

import java.util.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import static springfox.documentation.builders.PathSelectors.regex;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Loganathan
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

	private static final Logger LOG = Logger.getLogger(SwaggerConfig.class.getName());
    /**
     *
     * @return
     */
    @Bean
	public Docket productApi() {
		return new Docket(SWAGGER_2).select()
				.apis(basePackage("com.connected.city.controller")).paths(regex("/connected.*"))
				.build().apiInfo(metaData());

	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Finding Whether Route Exist between two cities")
				.description("\"Finding Whether Route Exist between two cities\"").version("1.0.0")
				.license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				.contact(new Contact("Loganathan Rajappan", "https://springframework.guru/about/",
						"rlogu2000@gmail.com"))
				.build();
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

	}
    
}
