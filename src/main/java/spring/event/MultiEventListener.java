package spring.event;

import org.springframework.context.event.*;

public class MultiEventListener {

    @EventListener(ContextClosedEvent.class)
    public void closedEvent() {
        System.out.println();
        System.out.println("**********Closed Event************");
    }

    @EventListener(ContextRefreshedEvent.class)
    public void refreshEvent() {
        System.out.println();
        System.out.println("**********Refresh Event************");
    }

    @EventListener(ContextStartedEvent.class)
    public void startEvent() {
        System.out.println();
        System.out.println("**********Start Event************");
    }

    @EventListener(ContextStoppedEvent.class)
    public void stopEvent() {
        System.out.println();
        System.out.println("**********Stop Event************");
    }

}
