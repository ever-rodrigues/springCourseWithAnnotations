package com.springwithannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {

        //read spring config file
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");

        //get the bean from spring container
        Coach myCoach = context.getBean("tennisCoach",Coach.class);
        Coach mySecondCoach = context.getBean("tennisCoach",Coach.class);


        System.out.println("Position of Memory of"+myCoach);
        System.out.println("Position of Memory of MySecond Coach"+mySecondCoach);
        System.out.println("JUST REMEMBER THAT USING ANNOTATION OF SINGLETON ALL INSTANCES OF CLASS WILL USE SAME MEMORY ADDRESS");
        System.out.println("JUST REMEMBER THAT USING ANNOTATION OF PROTOTYPE ALL INSTANCES OF CLASS WILL USE UNIQUE ONE MEMORY ADDRESS");
        System.out.println("The annotation must be set up at Class with @Scope ");
        System.out.println("\n");
        //call a method on the bean
        System.out.println(myCoach.getDailyWorkoout());

        //call method to get the daily fortune
        System.out.println(myCoach.getDailyFortune());
        //close the context

        context.close();
    }

}
