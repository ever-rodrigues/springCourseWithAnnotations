package com.springwithannotations;


import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkoout() {
        return "I am a Tennis Coach, do the training for 3 hours!";
    }
}
