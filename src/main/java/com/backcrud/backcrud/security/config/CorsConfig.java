package com.backcrud.backcrud.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
@Override
public void addCorsMappings(CorsRegistry registry){
    registry.addMapping("/**")
        .allowedOrigins("https://localhost:4200")
        .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
        .allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
        .allowCredentials(true)
        .maxAge(3600);

    registry.addMapping("auth/**")
        .allowedOrigins("https://localhost:4200")
        .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
        .allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
        .allowCredentials(false)
        .maxAge(3600);
}

}
  