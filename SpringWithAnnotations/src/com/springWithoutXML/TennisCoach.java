package com.springWithoutXML;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    @Value("${foo.name}")
    private String name;

    @Value("${foo.team}")
    private String team;
    @Autowired
    //This annotation is very importat! That tell to Spring what dependecy injection he will do ...
    //This is becayde fortuneService has a lot of implementation, so we need to decide what we cam implement here, because
    //spring cannot implement all at same time!
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

   //Dependency injection
    public TennisCoach() {
        System.out.println("Default constructor of TennisCoach");
    }

    @Override
    public String getDailyWorkoout() {
        return "I am a Tennis Coach, do the training for 3 hours!";
    }

    @Override
    public String getDailyFortune() {
        System.out.println("Inside getDailyFortune ");
        System.out.println("Name of: "+ getName());
        System.out.println("Team of:" + getTeam());
        return fortuneService.getFortuneService();
    }


    //Define my Init Method
    @PostConstruct
    public void doMyStartupeStuff(){
        System.out.println("Inside PreConstruct Method : doMyStartupStuff");
    }

    //Before Destruc beans, this method will run
    @PreDestroy
    public void destroyMethod(){
        System.out.println("Destroy method inside Tennis coach ");
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    //Here we are injection autowired annotation in setter Method
//    @Autowired
//    public void doCrazyStuffs(FortuneService fortuneService) {
//        System.out.println("Inside method of Tennis Coach, method Do Crazy Stuff");
//        this.fortuneService = fortuneService;
//    }
//
//    public void testWithoutAutowired(FortuneService fortuneService){
//        System.out.println("Without Autowired Annotations");
//        this.fortuneService=fortuneService;
//    }


}
