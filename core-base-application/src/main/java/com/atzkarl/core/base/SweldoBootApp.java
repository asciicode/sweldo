package com.atzkarl.core.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SweldoBootApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SweldoBootApp.class, args);
        System.out.println("----------------------------ASCII---------------------------");
        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

}
