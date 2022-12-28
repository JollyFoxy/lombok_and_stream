package Users;

import lombok.*;

@Value
@With
public class User {
    long id;
    String name;
    int age;
    public User(){
        id=0;
        name="Unnamed";
        age=0;
    }
}