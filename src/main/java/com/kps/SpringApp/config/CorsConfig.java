package com.kps.SpringApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/api/**") // Define los patrones de URL que deseas habilitar para CORS
                    .allowedOrigins("http://localhost:5173") // Permite solicitudes solo desde este origen
                    .allowedMethods("GET", "POST", "PUT", "DELETE") // Define los métodos HTTP permitidos
                    .allowedHeaders("*"); // Puedes ajustar los encabezados permitidos aquí
        }


}
