package entities.saucedemo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class User {
    private String username;
    private String password = "secret_sauce";

}
