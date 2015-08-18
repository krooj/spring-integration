package com.krooj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Application context configuration
 */
@Configuration
@ComponentScan(basePackages = {"com.krooj"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class}),
@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {ControllerAdvice.class})})
@ImportResource("classpath*:integration-context.xml")
public class AppConfig {
}
