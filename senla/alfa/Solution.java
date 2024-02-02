package senla.alfa;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Set<User> users = Set.of(
                new User("Ivanov", "Orel"),
                new User("Petrov", "Orel"),
                new User("Petrova", "Orel"),
                new User("Ivanova", "Orel"),
                new User("Vsiliev", "Brest"),
                new User("Sidorov", "Brest"),
                new User("Pupkin", "Magadan"),
                new User("Pupkina", "Magadan")
        );

        Set<String> cities = Set.of("Brest", "Orel", "Magadan");

        System.out.println(countUsersInEachCity(users, cities));
    }

    private static Map<String, Integer> countUsersInEachCity(Set<User> users, Set<String> cities) {
        Map<String, Integer> result = new HashMap<>();

        cities.forEach(city -> {
            long count = users.stream().filter(user -> Objects.equals(user.getCity(), city)).count();
            if (count > 0) {
                result.put(city, (int) count);
            }
        });

        return result;
    }


}
