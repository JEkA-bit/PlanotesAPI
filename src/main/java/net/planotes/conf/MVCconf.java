package net.planotes.conf;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MVCconf implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/sign-up").setViewName("sign-up/index");

        WebMvcConfigurer.super.addViewControllers(registry);
    }
}
