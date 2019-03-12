package spring.core.question3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

@Getter

@NoArgsConstructor
@ToString
public class Restaurant {

    @Autowired
    @Qualifier("tea")
    HotDrink hotDrink;

    @Autowired
    public Restaurant(@Qualifier("tea1") HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }

    @Required
    @Autowired
    @Qualifier("tea2")
    public void setHotDrink(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }
}
