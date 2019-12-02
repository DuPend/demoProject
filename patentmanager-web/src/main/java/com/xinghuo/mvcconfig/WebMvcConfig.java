package com.xinghuo.mvcconfig;

import com.xinghuo.handlerinterceptor.MyHandlerIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private MyHandlerIntercepter myHandlerIntercepter;



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //.excludePathPatterns("/adminExport");
        registry.addInterceptor(myHandlerIntercepter).addPathPatterns("/**").excludePathPatterns("/logincheck");
    }

}
