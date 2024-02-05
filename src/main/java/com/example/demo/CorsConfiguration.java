package com.example.demo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
               // registry.addMapping("/api/v1").allowedOrigins("http://localhost:3000"); // Replace with your frontend URL
            	 registry.addMapping("/**")
                 .allowedOrigins("http://localhost:3000") // Adjust this to match your React app's URL
                 .allowedMethods("GET", "POST", "PUT", "DELETE")
                 .allowedHeaders("*");
            }
        };
    }
}
