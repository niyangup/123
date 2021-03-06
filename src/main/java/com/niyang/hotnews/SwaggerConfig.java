package com.niyang.hotnews;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket createRestApi() {
    ParameterBuilder ticketPar = new ParameterBuilder();
    List<Parameter> pars = new ArrayList<Parameter>();
    ticketPar
        .name("Authorization")
        .description("token")
        .modelRef(new ModelRef("string"))
        .parameterType("header")
        .required(false)
        .build();
    pars.add(ticketPar.build());

    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.niyang"))
        .paths(PathSelectors.any())
        .build()
        .securitySchemes(securitySchemes())
        .securityContexts(securityContexts())
    //                .globalOperationParameters(pars)
    ;
  }

  private List<ApiKey> securitySchemes() {
    List<ApiKey> apiKeyList = new ArrayList();
    apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
    return apiKeyList;
  }

  private List<SecurityContext> securityContexts() {
    List<SecurityContext> securityContexts = new ArrayList<>();
    securityContexts.add(
        SecurityContext.builder()
            .securityReferences(defaultAuth())
            .forPaths(PathSelectors.regex("^(?!auth).*$"))
            .build());
    return securityContexts;
  }

  List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    List<SecurityReference> securityReferences = new ArrayList<>();
    securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
    return securityReferences;
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("HotNews业务相关APIs")
        .description("Create by niyang")
        .termsOfServiceUrl("http://apiDocs.cloud.com")
        .version("1.0")
        .build();
  }
}
