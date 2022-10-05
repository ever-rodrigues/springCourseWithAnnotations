package com.springWithoutXML;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WithoutXMLDemo {
    public static void main(String[] args) {

        //read Spring Java config class
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SportConfig.class);

        //get he bean from Spring Container
        Coach myCoach = context.getBean("tennisCoach", Coach.class);

        System.out.println(myCoach.getDailyWorkoout());

        context.close();
        //call a method on the bean



    }
}
