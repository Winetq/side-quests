package com.epam.jap.user;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

@Test
public class UserRegistryTest {
    private final User user1 = new User("Marian", "Kajtek", "123456789", "marian@gmail.com");
    private final User user2 = new User("Majtek", "Kajtek", "987654321", "majtek@gmail.com");
    private final User user3 = new User("Zbyszek", "Kowalski", "543219876", "zbyszek@gmail.com");
    private final User user4 = new User("Janusz", "Kowalski", "111222333", "majtek@gmail.com");
    private final User user5 = new User("Mariusz", "Kowal", "111222333", "@gmail.com");

    public void registerUser_addingUsersWithDifferentData_usersWithCorrectDataMustBeAdded() {
        // given
        SoftAssert sa = new SoftAssert();
        UserRegistry userRegistry = new UserRegistry();
        // when
        userRegistry.registerUser(user1);
        userRegistry.registerUser(user2);
        userRegistry.registerUser(user3);
        userRegistry.registerUser(user3); // should not be added
        userRegistry.registerUser(user4); // should not be added
        userRegistry.registerUser(user5); // should not be added
        // then
        sa.assertEquals(userRegistry.getUserByEmail(user1.getBusinessId()), user1);
        sa.assertEquals(userRegistry.getUserByEmail(user2.getBusinessId()), user2);
        sa.assertEquals(userRegistry.getUserByEmail(user3.getBusinessId()), user3);
        sa.assertEquals(userRegistry.getNumberOfUsers(), 3);
        sa.assertAll();
    }

    @Test(dataProvider = "getCollectionOfUsers")
    public void registerUsers_addingUsersWithDifferentData_usersWithCorrectDataMustBeAdded(Collection<User> collection) {
        // given
        UserRegistry userRegistry = new UserRegistry();
        // when
        userRegistry.registerUsers(collection);
        // then
        assertEquals(userRegistry.getNumberOfUsers(), 3);
    }

    @DataProvider
    public Object[][] getCollectionOfUsers() {
        return new Object[][]{
                { List.of(user1, user2, user3, user3, user4, user5) },
                { Set.of(user1, user2, user3, user4, user5) }
        };
    }
}

