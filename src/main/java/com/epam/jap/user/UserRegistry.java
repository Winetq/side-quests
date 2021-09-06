package com.epam.jap.user;

import com.epam.jap.validation.Validator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class UserRegistry {
    private final Map<UUID, User> uuidUserMap;

    public UserRegistry() {
        this.uuidUserMap = new HashMap<>();
    }

    public void registerUser(User user) {
        if (!Validator.checkEmail(user.getBusinessId()) || checkEmailExistence(user.getBusinessId())) {
            System.err.println(user.getBusinessId() + " - this email is incorrect or is already used!");
        } else {
            uuidUserMap.put(user.uuid, user);
        }
    }

    public void registerUsers(Collection<User> users) {
        for (User x : users) {
            if (!Validator.checkEmail(x.getBusinessId()) || checkEmailExistence(x.getBusinessId())) {
                System.err.println(x.getBusinessId() + " - this email is incorrect or is already used!");
            } else {
                uuidUserMap.put(x.uuid, x);
            }
        }
    }

    private boolean checkEmailExistence(String email) {
        for (User user : uuidUserMap.values()) {
            if (email.equals(user.getBusinessId())) {
                return true;
            }
        }
        return false;
    }

    public User getUserByEmail(String email) {
        for (User user : uuidUserMap.values()) {
            if (email.equals(user.getBusinessId())) {
                return user;
            }
        }
        return null;
    }

    public int getNumberOfUsers() {
        return uuidUserMap.size();
    }

    public void show() {
        for (User user : uuidUserMap.values()) {
            System.out.println(user);
        }
    }
}

