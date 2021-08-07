package com.erik5594.blog.config.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 11:49
 */

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SpringFoxConfig implements WebMvcConfigurer {

    @Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.erik5594.blog.api"))
                .build()
                .apiInfo(apiInfo())
                .tags(new Tag("Usuários", "Gerenciar usuários."),
                        new Tag("Postagens", "Gerenciamento de postagens."),
                        new Tag("Comentários", "Gerenciamento de comentários."),
                        new Tag("Álbuns", "Gerenciamento de álbuns de fotos."),
                        new Tag("Autenticação", "Obter Token"));
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Blog - API")
                .description("API - Para gerenciamento de Blogs")
                .version("1")
                .contact(new Contact("Erik Queiroz", "https://github.com/Erik5594/", "erik.derick74@gmail.com"))
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }

}
