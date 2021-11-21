package com.beans;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FrontController extends AbstractAnnotationConfigDispatcherServletInitializer
{
    protected Class<?>[] getRootConfigClasses() {
        return (Class<?>[])new Class[] { MvcConfiguration.class };
    }
    
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
    
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
