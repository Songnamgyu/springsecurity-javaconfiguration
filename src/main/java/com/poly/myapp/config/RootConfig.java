package com.poly.myapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
	  DataSourceConfig.class
	
	})
@ComponentScan(basePackages =  {"com.poly.myapp.model.service"})
public class RootConfig {

}
