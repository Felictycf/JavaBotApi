package com.wuzh.blog.config;

import com.wuzh.blog.handler.LoginInterceptro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @auther :Wuzh
 * @date :2022/7/12
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptro loginInterceptro;
    @Override
    public void addCorsMappings(CorsRegistry registry){
        //跨域配置
        registry.addMapping("/**")

                .allowedOrigins("http://43.142.42.66/")
                .allowedOrigins("http://www.wuzh666.com/")
                .allowedMethods("POST","GET","PUT","OPTIONS","DELETE")
                .allowCredentials(true)
        ;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptro)
                .addPathPatterns("/test")
                .addPathPatterns("/comments/create/change")
                .addPathPatterns("/articles/publish")
        ;
     //   System.out.println("ceshi2");
    }
}
