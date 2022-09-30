Spring with annnotations
    -> Class Name : TennisCoach     ->DefaultBeanName : tennisCoach 
    Always first letter will be lower case for Beans Defatult Name.

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

    -> at this example I'm using @Component("nameOfBeanId") 
    ->BUT you can take out and not insert the name of Bean Id, but just remember that the Default Bean Name
    ->will be ex:
        ->-> Class Name : TennisCoach     ->DefaultBeanName : tennisCoach

Its up to you use a defaulty name or create a special one... at  @Compontent


    ->Spring Autowiring?
->For dependency injection, Spring can use auto wiring

->Spring will look for a class that matches the property
    ->matches by type: class or interface
    
->Spring will inject automatically ..hence it is autowired

    ->3 Types of Injection
        ->Constructor Injection
            @Autowired
            public TennisCoach(FortuneService fortuneService) {
            this.fortuneService = fortuneService;
            }

        Observation : At Spring 4.3 to up, if you only has one constructor is not necessary to use
        Autowired annotation, but if you have moew than , at least one must be annotated to teach the
        container wich one to use... 

        ->Setter Injection
            -> So if you whant to use the Setter injection just keep in Mind you need to use a default constructor
        and use a Autowired annotation in your setter Method!
        Exemplo:
            public TennisCoach() {
               }
            
            @Autowired
            public void setFortuneService(FortuneService fortuneService) {
            this.fortuneService = fortuneService;
            }

        ->Field Injections

You need to add @Component inside your class that implements you interface

So use autowired at your constructor and Spring will inject dependency for you with Spring annotations








    