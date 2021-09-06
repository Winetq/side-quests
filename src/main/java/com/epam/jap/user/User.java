package com.epam.jap.user;

import java.util.Objects;
import java.util.UUID;

public final class User {
    final UUID uuid; // technical id
    private final String name;
    private final String surname;
    private final String telephone;
    private final String email; // business id

    public User(String name, String surname, String telephone, String email) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
    }

    String getBusinessId() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(surname, user.surname) &&
                Objects.equals(telephone, user.telephone) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, telephone, email);
    }

    @Override
    public String toString() {
        return "User{name=" + name + ", surname=" + surname + ", telephone=" + telephone + ", email=" + email + "}";
    }
}

