package com.my.ad.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @ClassName WebConfiguration
 * @Deseription
 * @Author ywk
 * @Date 2019/11/29 13:09
 * @Version 1.0
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.clear();;
        converters.add(new MappingJackson2HttpMessageConverter());
    }

}
