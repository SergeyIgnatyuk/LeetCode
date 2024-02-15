package stream;

import java.util.*;
import java.util.stream.Collectors;

public class CountUsersInEachCity {

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

        Set<String> cities = Set.of("Brest", "Orel", "Jopa");

        System.out.println(countUsersInEachCity(users, cities));
    }

    private static Map<String, Long> countUsersInEachCity(Set<User> users, Set<String> cities) {
        return users.stream().filter(user -> cities.contains(user.getCity()))
                .collect(Collectors.groupingBy(User::getCity, Collectors.counting()));
    }

    public static class User {
        private String username;
        private String city;

        public User(String username, String city) {
            this.username = username;
            this.city = city;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User user)) return false;
            return Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getCity(), user.getCity());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getUsername(), getCity());
        }
    }

}
