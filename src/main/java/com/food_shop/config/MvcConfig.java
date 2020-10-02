package com.food_shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@ComponentScan(basePackages = "com.food_shop.config")
public class MvcConfig implements WebMvcConfigurer {

//    @Bean // cors config
//    public WebMvcConfigurer corsConfigurer(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
//            }
//        };
//    }

    @Bean // tiles xml configuration
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer =  new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
        tilesConfigurer.setCheckRefresh(true);
        return  tilesConfigurer;
    }

    @Override // view resolver
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }

    @Override // static resources link config
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources/css/**")
                .addResourceLocations("classpath:/static/css/");

        registry.addResourceHandler("/resources/js/**")
                .addResourceLocations("classpath:/static/js/");

        registry.addResourceHandler("/resources/files/**")
                .addResourceLocations("classpath:/static/files/");

        registry.addResourceHandler("/resources/fonts/**")
                .addResourceLocations("classpath:/static/fonts/");

        registry.addResourceHandler("/resources/tool/**")
                .addResourceLocations("classpath:/static/tools/");

        registry.addResourceHandler("/resources/img/**")
                .addResourceLocations("classpath:/static/img/");

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
