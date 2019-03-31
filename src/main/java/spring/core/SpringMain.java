package spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.question10.ExpressTea;
import spring.core.question10.Tea;
import spring.core.question3.Restaurant;

public class SpringMain {

    public static void main(String[] args) {


        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-Config.xml");


        System.out.println("----------Question 1 and Question 2-------------");

        System.out.println(applicationContext.getBean("database"));
        System.out.println(applicationContext.getBean("database1"));
        System.out.println(applicationContext.getBean("database2"));
        System.out.println(applicationContext.getBean("database3"));
        System.out.println(applicationContext.getBean("database4"));


        System.out.println("-------------Question 3 and Question 4-------------");

        Restaurant tea = (Restaurant) applicationContext.getBean("teaRestaurant");
        tea.getHotDrink().prepareHotDrink();

        Restaurant expressTea = (Restaurant) applicationContext.getBean("expressTeaRestaurant");
        expressTea.getHotDrink().prepareHotDrink();

        System.out.println("-----------Question 5----------------");

        System.out.println(applicationContext.getBean("complexBean"));

        System.out.println("-----------Question 6 ---------------");

        Restaurant tea1 = (Restaurant) applicationContext.getBean("res");
        tea1.getHotDrink().prepareHotDrink();
        Restaurant tea2 = (Restaurant) applicationContext.getBean("res1");
        tea2.getHotDrink().prepareHotDrink();
        Restaurant tea3 = (Restaurant) applicationContext.getBean("res3");
        tea3.getHotDrink().prepareHotDrink();

        System.out.println("-------------Quetion 7---------------");
        Restaurant tea4 = (Restaurant) applicationContext.getBean("teaRestaurant1");
        Restaurant tea5 = (Restaurant) applicationContext.getBean("teaRestaurant1");
        System.out.println("HashCode Of First Bean " + tea4.hashCode());
        System.out.println("HashCode Of Second Bean " + tea5.hashCode());

        System.out.println("------------Question 8------------------");
        Restaurant tea6 = (Restaurant) applicationContext.getBean("restaurant");
        tea6.getHotDrink().prepareHotDrink();
        Restaurant tea7 = (Restaurant) applicationContext.getBean("restaurant");
        tea7.getHotDrink().prepareHotDrink();
        Restaurant tea8 = (Restaurant) applicationContext.getBean("restaurant");
        tea8.getHotDrink().prepareHotDrink();


        System.out.println("------------Question 10------------------");
        spring.core.question10.Restaurant teaDrink = applicationContext.getBean("rest", spring.core.question10.Restaurant.class);
        teaDrink.getHotDrink().prepareHotDrink();
        Tea teaDrink1 = applicationContext.getBean("teaDrink", Tea.class);
        teaDrink1.prepareHotDrink();
        ExpressTea expressTea1 = applicationContext.getBean("expressTeaDrink", ExpressTea.class);
        expressTea1.prepareHotDrink();


    }
}
