package spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;

@Aspect
public class LoggingAspect {


    //Question1

    @Before("execution(String get*())")
    void beforeGetter() {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<Before Getter Execution");
    }

    @After("execution(void set*(..))")
    void afterSetter() {
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> After Setter Execution");
    }

    @Before("execution(void getInfoById())")
    void beforeInfoByIdMethod() {
        System.out.println();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<< Before Method Call");
    }

    @After("execution(void getInfoById())")
    void afterInfoByIdMethod() {
        System.out.println();
        System.out.println("-----------------------After Method Call--------------");
    }

    //Question2
    @Around("execution(void getInfoByName())")
    void aroundMethodByName(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println();
        System.out.println("************************** Before Around Method Call **********************");
        joinPoint.proceed();
        System.out.println();
        System.out.println("************************** After Around Method Call ***********************");
    }

    //Question3

    @AfterThrowing(pointcut = "execution(void exceptionThrower())", throwing = "ex")
    public void logExceptionMethods(JoinPoint joinPoint, IOException ex) throws Throwable {
        System.out.println("Exception Inside Logging Asepect");
    }

    //Question4

    @Before("execution(void *Info())")
    public void beforeInfoMethod() {
        System.out.println();
        System.out.println("-------------------Before Info Method-------------");
    }

    @After("within(spring.aop.InfoService.*)")
    public void withInfoMethod() {
        System.out.println();
        System.out.println("-------------------Within Usage-------------------");
    }

    @After("args(String)")
    public void argumentMethod() {
        System.out.println();
        System.out.println("---------------Running Args advice---------------------");
    }

    @After("this(spring.aop.InfoService)")
    public void thisMethod() {
        System.out.println();
        System.out.println("---------------Running This Advice ----------------------");
    }

    @After("bean(infoService)")
    void beanMethod() {
        System.out.println();
        System.out.println("******************* Inside Bean Method ************************");
    }

    //Question 5

    @Before("beforePointCut()")
    void beforeAdvice() {
        System.out.println();
        System.out.println("*****************----------PointCut Reuse Before------------*************");
    }

    @After("afterPointCut()")
    void afterAdvice() {
        System.out.println();
        System.out.println("---------------**************Pointcut Reuse After **************-----------");
    }

    @Pointcut("execution(void *Info())")
    void beforePointCut() {
    }

    @Pointcut("execution(String *Info())")
    void afterPointCut() {
    }

    //Question 6

    @Before("execution(void infoGet(int))")
    void beforeInfoGet(JoinPoint joinPoint) {
        System.out.println();
        System.out.println("****** Running before advice ***********");
        System.out.println(joinPoint);
        System.out.println(joinPoint.getThis());
        System.out.println(joinPoint.getSignature());
        Object[] objects = joinPoint.getArgs();
        for (Object object : objects) {
            System.out.println(object);
        }
    }


}
