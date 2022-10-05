package com.springWithoutXML;

import com.springwithannotations.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.springWithoutXML")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    //define a Bean for Fortune Service
    @Bean
    public FortuneService happyFortuneService(){
        return  new HappyFortuneService();
    }

    //Define a Bean for SwinCoach AND INJECT the dependency
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(happyFortuneService());
    }


}

