package spring.event;

import org.springframework.context.ApplicationListener;

public class CustomEventListner implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("----Custom Event--------   ");
    }
}
