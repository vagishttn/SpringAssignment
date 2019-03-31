package spring.aop;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    int id;
    String name;

    void getInfoById() {
        System.out.println("Id -> " + this.id + "  Name -> " + this.name);
    }

    void getInfoByName() {
        System.out.println("Name -> " + this.name + "  Id -> " + this.id);
    }
}
