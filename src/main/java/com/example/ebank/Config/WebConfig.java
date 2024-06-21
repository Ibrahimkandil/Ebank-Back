package com.example.ebank.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/ebank/api/v1/**")  // Map the URL path(s) you want to enable CORS for
                .allowedOrigins("http://localhost:4200")  // Allow requests from this origin
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allowed HTTP methods
                .allowedHeaders("Content-Type", "Authorization")  // Allowed headers
                .allowCredentials(true);  // Allow sending cookies from the browser
    }
}
