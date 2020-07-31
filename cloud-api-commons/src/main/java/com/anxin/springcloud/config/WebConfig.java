package com.anxin.springcloud.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZC
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 配置消息转换器-- fastJson
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //1.需要定义一个convert转换消息的对象;
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                // 支持Map的key为复杂对象的形式
                .enableComplexMapKeySerialization()
                // 不导出实体类中没有用@Expose注解的属性
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                //.setVersion()
                //排除了具有private、final或static修饰符的字段
                //.excludeFieldsWithModifiers(Modifier.FINAL, Modifier.STATIC, Modifier.PRIVATE)
                .create();

        //3处理中文乱码问题
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        //4.在convert中添加配置信息.
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);

        gsonHttpMessageConverter.setGson(gson);
        //5.将convert添加到converters当中.
        converters.add(gsonHttpMessageConverter);
    }
}
