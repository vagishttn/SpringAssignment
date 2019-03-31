package spring.event;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Config.xml");
        ctx.start();
        DataBase db = ctx.getBean("eventData", spring.event.DataBase.class);
        db.connect();
        ctx.stop();
        ctx.close();
    }

}
