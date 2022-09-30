package com.springwithannotations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    private FortuneService fortuneService;

   //Dependency injection
    public TennisCoach() {
    }

    @Override
    public String getDailyWorkoout() {
        return "I am a Tennis Coach, do the training for 3 hours!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortuneService();
    }

//Here we are injection autowired annotation in setter Method
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
}
