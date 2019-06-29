package cn.wt.springbootdemo2.configuration;

import cn.wt.springbootdemo2.interceptor.LoggerInterceptor;
import cn.wt.springbootdemo2.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class WebMvcConfiguration extends  WebMvcConfigurationSupport{


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor())
                .excludePathPatterns("/register","/favicon.ico")
                .addPathPatterns("/*/**");

        registry.addInterceptor(new LoggerInterceptor())
                .addPathPatterns("/*/**");

    }
}
