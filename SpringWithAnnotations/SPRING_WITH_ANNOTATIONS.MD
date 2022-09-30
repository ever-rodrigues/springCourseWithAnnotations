Spring with annnotations
    -> Class Name : TennisCoach     ->DefaultBeanName : tennisCoach 
    Always first letter will be lower case for Beans Defatult Name.

    This process name by : DECAPTALIZE 
    Java has one method called public static String decapitalized(String name) That Spring boot
    use to set default name of Beans ID.


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

        ->Method Injection

            You can use @Autowired annotion to any method you need to do injecton dependency
            Simple as that! Just use the annotion to spring inject!

            So I did some example without Autowired Annotation to you saw that Spring will not inject dependency
            without annotation

    You need to add @Component inside your class that implements you interface

    So use autowired at your constructor and Spring will inject dependency for you with Spring annotations

->Field Injections 
    ->Applied directly to the field
    ->No need for setter methods

    ->(Using Java Technology called Reflection!)
        @Autowired
        private FortuneService fortuneService;


Ok, NOW WHAT KIND OF STYLE I WILL USE?
    STAY consistent in yout project!!!


    ->Using @Qualifier Annotation
        ->THis is very important to tells to Spring what dependency injection you need from classes thata
    implement your interface. As this code you have HappyFortuneService and NotSoHappy... that implements
    Fortune service, just tell to Spring what implementation you whant... using
    @Qualifier("nameOfClassThatImplementInterface")

    @Qualifier("notSoHappyFortuneService")
    private FortuneService fortuneService;

->You can use this @Qualifier annotation to
        ->Constructor Injection
        ->Setter Injection methods
        ->Field Injection

    ->IMPORTANT NOTE, DONT FORGET TO USE THE @Component at each class of Spring ... without this
    Spring will not saw this Class to create a Bean
    
    
    You can use @Qualifier inside the argument of constuctor
        Ex:
        @Autowired
        public TennisCoach(@Qualifier ("randomFortuneService") FortuneService fortuneService{
            System.out.prinln("Tennis coach inside constructor ");
            this.fortuneService=fortuneService;
        }

    

You can use the ".properties" file to set some variables or values
Just create a .properties file and insert the values you whant...
    Ex: 
        foo.name=Everton Rodrigues
        foo.team=Vasco da Gama

After That create inside applicationContext.xml the:
    <context:property-placeholder location="classpath:sport.properties"/>

    That will link the property to sport.properties. so when Spring Beans look at applicationContext.xml
    file he will look at sport.properties, and when you inject the TennisCoah, he will follow the path.

    After that create at TennisCoach class the attribute Name and team
    Also use the Annotation of @Value to set the "direction to Java Beans loook at"

        Ex:
            @Value("${foo.name}")
            private String name;

            @Value("${foo.team}")
            private String team;