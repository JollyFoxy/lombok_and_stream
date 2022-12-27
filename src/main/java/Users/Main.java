package Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        int p = 100;
        int[] run = new Random().ints(1, p + 2).distinct().limit(p + 1).toArray();
        for (int i = 0; i <= p; i++) {
            User user = new User(run[i], Name_gen.genName(), (int) (Math.random() * 110));
            users.add(user);
        }
        System.out.println("All users count: "+ users.size());


        System.out.println("Woman:");
        List<User> womanFilter =users.stream().filter(x-> x.getName().equals("Алиса")||x.getName().equals("Арина")||x.getName().equals("Вика"))
                .collect(Collectors.toList());
        System.out.println(womanFilter+"\n Woman count "+womanFilter.size());

        System.out.println("Old mans:");
        List<User> oldMansFilter = users.stream().filter(x->x.getAge()>50)
                .collect(Collectors.toList());
        System.out.println(oldMansFilter+"\n Old mans count "+oldMansFilter.size());
    }
}
