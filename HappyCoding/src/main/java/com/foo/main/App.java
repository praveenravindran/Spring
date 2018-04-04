package com.foo.main;

import com.foo.config.AopConfig;
import com.foo.config.DatabaseConfig;
import com.foo.model.User;
import com.foo.service.UserService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    private UserService userService;

    public void mainApp(User user){
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class , DatabaseConfig.class);
        userService = applicationContext.getBean(UserService.class);
        userService.testMethod(user);
    }

}
