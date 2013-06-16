package org.personal.mason.feop.oauth.service.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurationSupport {

	@Override
	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		RequestMappingHandlerMapping result = super.requestMappingHandlerMapping();
		result.setUseTrailingSlashMatch(false);
		return result;
	}
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
	}
	
	@Bean
	public InternalResourceViewResolver internalResolver() {
		InternalResourceViewResolver internalResolver = new InternalResourceViewResolver();
		internalResolver.setPrefix("/WEB-INF/views/");
		internalResolver.setSuffix(".jsp");
		return internalResolver;
	}

}
