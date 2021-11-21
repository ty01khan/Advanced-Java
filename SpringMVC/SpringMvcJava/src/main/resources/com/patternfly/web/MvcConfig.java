package com.patternfly.web;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@EnableWebMvc
@ComponentScan("com.patternfly")
public class MvcConfig extends WebMvcConfigurerAdapter {
	
}
