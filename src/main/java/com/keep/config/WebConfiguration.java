package com.keep.config;

import com.keep.interceptor.TokenCheckInterceptor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.keep.web")
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addRedirectViewController("/", "/index");
//    }


//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor( new TokenCheckInterceptor())
//                .excludePathPatterns("/login")
//                .excludePathPatterns("/noToken")
//                .excludePathPatterns("/register")
//                .excludePathPatterns("/upPwd")
//                .addPathPatterns("/*");
//        super.addInterceptors(registry);
//    }
}
