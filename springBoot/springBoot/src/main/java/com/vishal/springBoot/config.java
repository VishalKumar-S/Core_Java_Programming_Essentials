package com.vishal.springBoot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    public dep1 dep1bean(){
        return new dep1();
    }

//    @Bean
//    public dep2 dep2bean(){
//        return new dep2();
//    }

//    @Bean
//    public printDependencies allDependencies(dep1 dep1bean, dep2 dep2bean){
//        return new printDependencies(dep1bean, dep2bean);
//    }
}
