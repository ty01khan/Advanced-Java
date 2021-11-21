package com.patternfly.web.login;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.patternfly")
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {}