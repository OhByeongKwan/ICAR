package com.example.icar.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcWebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //aws 서버 배포 시 서버에 맞게 변경해줘야함
        registry.addResourceHandler("/uploads/**")
                //local path
//                .addResourceLocations("file:/Users/obk/Desktop/icar/src/main/resources/static/uploads/");
                //server path
                .addResourceLocations("file:/home/ubuntu/ICAR/src/main/resources/static/uploads/");
    }
}
