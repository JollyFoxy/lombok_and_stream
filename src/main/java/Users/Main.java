package Users;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        int p = 100;
        int[] run = new Random().ints(1, p + 2).distinct().limit(p+1).toArray();
        for (int i = 0; i <= p; i++) {
            User user = new User(run[i], Name_gen.genName(), (int) (Math.random() * 110));
            users.add(user);
        }
        System.out.println("All users count: "+ users.size()+users);

        System.out.println("\n\n\nWoman:");
        List<User> womanFilter =users.stream().filter(x-> x.getName().equals("Алиса")||x.getName().equals("Арина")||x.getName().equals("Вика"))
                .collect(Collectors.toList());
        Optional<User> womanFilter1 =users.stream().parallel().filter(x-> x.getName().equals("Алиса")||x.getName().equals("Арина")||x.getName().equals("Вика"))
                .findFirst();
        Optional<User> womanFilter2 =users.stream().parallel().filter(x-> x.getName().equals("Алиса")||x.getName().equals("Арина")||x.getName().equals("Вика"))
                .findAny();
        System.out.println("First lady: "+womanFilter1.get()+"\nSecond lady: "+womanFilter2.get());
//
        System.out.println(womanFilter+"\n Woman count "+womanFilter.size());

        System.out.println("\n\n\nOld mans:");
        List<User> oldMansFilter = users.stream().filter(x->x.getAge()>50)
                .collect(Collectors.toList());
        System.out.println(oldMansFilter+"\n Old mans count "+oldMansFilter.size());

        List<User> yangOld = users.stream().sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
        System.out.println("\n\n\nОт молодым к старым: "+yangOld);
        List<User> oldYang = users.stream().sorted((x1,x2)->Integer.compare(x2.getAge(), x1.getAge()))
                .collect(Collectors.toList());
        System.out.println("От старым к молодым : "+oldYang);

        Optional<User> first = users.stream().findFirst();
        System.out.println(first.get());

        Optional<User> any = users.stream().findAny();
        System.out.println(any.get());

        List<User> chel= users.stream().skip(50).limit(1).collect(Collectors.toList());
        System.out.println("В центре у нас: "+chel);

    }
}
