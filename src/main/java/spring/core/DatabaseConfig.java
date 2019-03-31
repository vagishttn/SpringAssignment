package spring.core;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class DatabaseConfig {

    int port;
    String name;

    public DatabaseConfig(int port, String name) {
        this.port = port;
        this.name = name;
    }
}
