package com.springwithannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {

        //read spring config file
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");

        //get the bean from spring container
        Coach myCoach = context.getBean("thatSillyCoach",Coach.class);

        //call a method on the bean
        System.out.println(myCoach.getDailyWorkoout());

        //close the context
        context.close();
    }

}
