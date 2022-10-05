package com.springWithoutXML;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    //create arrya of Strings
    private String[] data={
        "Beaware of the wolf in sheep's clothing",
        "Diligence is the mother of good luck",
            "The journey is the reward"
    };

    //create a Random number
    private Random randNumber= new Random();

    @Override
    public String getFortuneService() {
     //pick random string from the array
        int index= randNumber.nextInt(data.length);
        String theFortune= data[index];
        return theFortune;
    }
}
