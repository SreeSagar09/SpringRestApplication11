package com.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.app"})
public class AppConfig implements WebMvcConfigurer {
	
	@Override
	public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {
		 UrlPathHelper urlPathHelper = new UrlPathHelper();
	     urlPathHelper.setRemoveSemicolonContent(false);
	     
	     pathMatchConfigurer.setUrlPathHelper(urlPathHelper);
	}
	
}
