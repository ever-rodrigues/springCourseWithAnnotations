package com.springWithoutXML;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WithoutXMLDemo {
    public static void main(String[] args) {

        //read Spring Java config class
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SportConfig.class);

        //get he bean from Spring Container
        SwimCoach theCoach= context.getBean("swimCoach", SwimCoach.class);


        System.out.println(theCoach.getDailyWorkoout());
        System.out.println("Name: "+theCoach.getName());
        System.out.println("Team: "+theCoach.getTeam());

        context.close();
        //call a method on the bean



    }
}
