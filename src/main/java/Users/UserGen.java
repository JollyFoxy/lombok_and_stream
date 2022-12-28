package Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserGen{
    public static List<User> newListUser(int p){
        List<User> newUsersList = new ArrayList<>();
        int[] run = new Random().ints(1, p + 2).distinct().limit(p+1).toArray();
        User user =new User();
        for (int i = 0; i <= p; i++) {
            user = user.withId(run[i]).withName(Name_gen.genName()).withAge ((int) (Math.random() * 110));
            newUsersList.add(user);
        }
        return newUsersList;
    }
}