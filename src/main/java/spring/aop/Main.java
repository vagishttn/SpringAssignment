package spring.aop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Config.xml");

        Employee employee = ctx.getBean(Employee.class);
        System.out.println(employee.getName());
        employee.setName("vagish dixit");
        System.out.println(employee.getName());
        employee.getInfoById();
        employee.getInfoByName();


        Student student = ctx.getBean(Student.class);
        System.out.println(student.getName());
        try {
            student.exceptionThrower();
        } catch (IOException e) {
            System.out.println("Indide Catch");
        }


        InfoService infoService = ctx.getBean("infoService", InfoService.class);
        infoService.getInfo();
        System.out.println();
        infoService.getParameterInfo("Vagish");
        infoService.infoGet(4);

    }

}
