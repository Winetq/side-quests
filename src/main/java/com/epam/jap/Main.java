package com.epam.jap;

import com.epam.jap.user.User;
import com.epam.jap.user.UserRegistry;

import java.util.List;

class Main {
    public static void main(String[] args) {
        UserRegistry userRegistry = new UserRegistry();
        userRegistry.registerUser(
                new User("Marian", "Kajtek", "123456789", "marian@gmail.com")
        );
        userRegistry.registerUsers(List.of(
                new User("Janusz", "Kowalski", "111222333", "majtek@gmail.com"),
                new User("Majtek", "Kajtek", "987654321", "majtek@gmail.com"),
                new User("Mariusz", "Kowal", "111222333", "@gmail.com")
        ));
        System.out.println(userRegistry.getUserByEmail("majtek@gmail.com"));
        userRegistry.show();
    }
}

