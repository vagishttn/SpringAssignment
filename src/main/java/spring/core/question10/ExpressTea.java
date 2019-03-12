package spring.core.question10;

import org.springframework.stereotype.Component;

@Component("expressTeaDrink")
public class ExpressTea implements HotDrink {
    @Override
    public void prepareHotDrink() {
        System.out.println("Express Tea");
    }
}
