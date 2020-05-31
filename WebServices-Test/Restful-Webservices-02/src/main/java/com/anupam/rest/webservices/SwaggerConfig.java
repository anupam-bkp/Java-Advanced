package com.anupam.rest.webservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.stereotype.Component;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
//@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact("Anupam Kumar", 
			"http://anupam-kumar.com", "anupam.kumar@gmail.com");
	private static final ApiInfo DEFAULT_API_INFO = 
			new ApiInfo("Awesome API Title", "Awesome API Description", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
			new HashSet<>(Arrays.asList("application/json", "application/xml"));

	/**
	 * This method is not related to Swagger configuration.
	 * 
	 * This method is to remove issues between Swagger and HATEOS related to multiple dependency
	 * @return
	 */
	@Bean
	public LinkDiscoverers discoverers() {
		List<LinkDiscoverer> plugins = new ArrayList<>();
		plugins.add(new CollectionJsonLinkDiscoverer());
		return new LinkDiscoverers(SimplePluginRegistry.create(plugins));

	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}

}

/*
 
  @Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));

    }

    @Bean
    public Docket eDesignApi(SwaggerConfigProperties swaggerConfigProperties) {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo(swaggerConfigProperties))
                .enable(Boolean.valueOf(swaggerConfigProperties.getEnabled())).select()
                .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class).genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(Boolean.valueOf(swaggerConfigProperties.getUseDefaultResponseMessages()))
                .enableUrlTemplating(Boolean.valueOf(swaggerConfigProperties.getEnableUrlTemplating()));
    }

    @Bean
    UiConfiguration uiConfig(SwaggerConfigProperties swaggerConfigProperties) {
        return UiConfigurationBuilder.builder().deepLinking(Boolean.valueOf(swaggerConfigProperties.getDeepLinking()))
                .displayOperationId(Boolean.valueOf(swaggerConfigProperties.getDisplayOperationId()))
                .defaultModelsExpandDepth(Integer.valueOf(swaggerConfigProperties.getDefaultModelsExpandDepth()))
                .defaultModelExpandDepth(Integer.valueOf(swaggerConfigProperties.getDefaultModelExpandDepth()))
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(Boolean.valueOf(swaggerConfigProperties.getDisplayRequestDuration()))
                .docExpansion(DocExpansion.NONE).filter(Boolean.valueOf(swaggerConfigProperties.getFilter()))
                .maxDisplayedTags(Integer.valueOf(swaggerConfigProperties.getMaxDisplayedTags()))
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(Boolean.valueOf(swaggerConfigProperties.getShowExtensions()))
                .tagsSorter(TagsSorter.ALPHA).supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null).build();
    }

    private ApiInfo apiInfo(SwaggerConfigProperties swaggerConfigProperties) {
        return new ApiInfoBuilder().title(swaggerConfigProperties.getTitle())
                .description(swaggerConfigProperties.getDescription()).version(swaggerConfigProperties.getApiVersion())
                .build();
    }
    
    */
 
