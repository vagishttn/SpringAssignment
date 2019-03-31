package spring.core.question10;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("teaDrink")
@Primary
public class Tea implements HotDrink {
    @Override
    public void prepareHotDrink() {
        System.out.println("Tea");
    }
}
