package spring.aop;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.IOException;

@Getter
@Setter
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    int id;
    String name;

    void exceptionThrower() throws IOException {
        System.out.println("Throwing exception");
        throw new IOException();
    }

}
