Spring with annnotations

    -> With annotions from spring all the setup from applicationContext.xml get more simple.
This means that using @Component inseide your class that will be a Bean, and calling this bean from your
Main class , he will inicialize the beans from all packages setup at applicationContext.xml...
Ex:
    ->     <context:component-scan base-package="com.springwithannotations"/>
    ->Here you are set up all the base-package that spring will look for the beans

->At your class you will use the annotatins that specify that you need to Spring do the work
    @Component("thatSillyCoach")
        public Class....

->Just instanciate the config file at your Main class
    ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");

-> and get the bean you need from Spring container
    Coach myCoach = context.getBean("thatSillyCoach",Coach.class);

So just access the method from Bean you need.

With this aproach you saw the applicationContext.xml file are more clean and simple... 
This aproach are really better to work with amount of Beans... Imagine that you need to run 100 of Beans..
with XML aproach you are F! ,,,Hahahahhahq

