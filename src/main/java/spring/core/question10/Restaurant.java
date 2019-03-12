package spring.core.question10;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Repository("rest")
public class Restaurant {

    @Autowired
    HotDrink hotDrink;

}
