package com.springWithoutXML;

import org.springframework.stereotype.Component;

@Component
public class NotSoHappyFortuneService implements FortuneService {
    @Override
    public String getFortuneService() {
        return "Not So happy Fortune Service";
    }
}
