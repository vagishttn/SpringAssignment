package spring.aop;

public class InfoService {


    public void getInfo() {
        System.out.println();
        System.out.println("Inside Simple Info");
    }

    public void getParameterInfo(String info) {
        System.out.println();
        System.out.println("Inside Parameter Info --->  " + info);
    }

    public void infoGet(int a) {
        System.out.println();
        System.out.println("Getting Int Info --->  " + a);

    }
}
