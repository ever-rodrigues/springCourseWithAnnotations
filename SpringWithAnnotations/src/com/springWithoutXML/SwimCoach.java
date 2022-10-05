package com.springWithoutXML;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
public class SwimCoach implements Coach, com.springwithannotations.Coach {

    private FortuneService fortuneService;

    @Value("${foo.name}")
    private String name;

    @Value("${foo.team}")
    private String team;


    public SwimCoach(FortuneService theFortuneService) {
        System.out.println("Inside Constuctor of SwinCoach Bean");
        this.fortuneService=theFortuneService;
    }

    @Override
    public String getDailyWorkoout() {
        return "Inside getDaily from SwinCoach";
    }

    @Override
    public String getDailyFortune() {
        return "inside getFortune from SwinCoach";
    }

    @PostConstruct
    public void doStuff(){
        System.out.println("This is the Pos Construct Method");
    }

    @PreDestroy
    public void afterEnd(){
        System.out.println("This method is before Context.close runs...");
    }


    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }
}
