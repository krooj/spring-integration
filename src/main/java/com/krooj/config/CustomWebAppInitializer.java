package com.krooj.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by krooj on 8/16/15.
 */
public class CustomWebAppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        //Register the root context to be loaded on servlet init
        servletContext.addListener(new ContextLoaderListener(rootContext));

        //Create the dispatcher servlet
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(MvcConfig.class);

        //Register the dispatcher servlet with this servlet
        ServletRegistration.Dynamic dispatcherServletRegistration = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcherServletRegistration.setLoadOnStartup(1);
        dispatcherServletRegistration.addMapping("/");
    }
}
