package com.rafsan;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@EnableJSONDoc
public class Application {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){

        return ( container -> {
            ErrorPage page = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
            container.addErrorPages(page);
        });
    }

    public static void main(String[] args){

        SpringApplication.run(Application.class, args);
    }
}
