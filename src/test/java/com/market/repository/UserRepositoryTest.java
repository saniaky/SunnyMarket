package com.market.repository;

import com.market.model.User;
import com.market.model.UserRoleEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by saniaky on 6/30/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void testSaveAndGet() {
        final int usersCount = 10;
        List<User> users = new ArrayList<User>(usersCount);
        for (int i = 0; i < usersCount; i++) {
            users.add(new User("User " + i, "pas" + i*3%8, UserRoleEnum.USER));
        }

        for (User user : users) {
            repository.save(user);
        }

        Iterable<User> actualUsers = repository.findAll();
        int idx = 0;
        for (User actualUser : actualUsers) {
            assertEquals(users.get(idx), actualUser);
            idx++;
        }
    }
}
