package com.worldofthings;

//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.json.GsonHttpMessageConverter;
//
//import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.Collection;





import java.util.List;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
//import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.worldofthings.json.GsonFactory;

//@Configuration
//@ConditionalOnClass(Gson.class)

@Configuration
@EnableWebMvc
public class GsonHttpMessageConverterConfiguration extends WebMvcConfigurerAdapter {

//    @Bean
////    @ConditionalOnMissingBean
//    public GsonHttpMessageConverter gsonHttpMessageConverter(Gson gson) {
//        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
//        converter.setGson(gson);
//        return converter;
//    }
//
//
//	public class WebMvcConfig extends WebMvcConfigurerAdapter {

	    @Override
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	        super.configureMessageConverters(converters);
	        converters.add(createGsonHttpMessageConverter());
	    }

	    private GsonHttpMessageConverter createGsonHttpMessageConverter() {
	        GsonHttpMessageConverter gsonConverter = new GsonHttpMessageConverter();
	        gsonConverter.setGson(GsonFactory.createGson());
	        
	        System.out.println("MANOJ Configuring HttpMessageConverters");

	        return gsonConverter;
	    }

	
	
	
    
//	@Bean
//    public HttpMessageConverters customConverters() {
//		
//		Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//		
//		GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
//		gsonHttpMessageConverter.setGson(GsonFactory.createGson());
//		
//		messageConverters.add(gsonHttpMessageConverter);
//		
//		System.out.println("MANOJ Configuring HttpMessageConverters");
//		
//        return new HttpMessageConverters(true, messageConverters);
//    }	
	
}