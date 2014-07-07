package com.market.repository;

import com.market.config.MarketConfig;
import com.market.config.WebAppContext;
import com.market.model.LikeEnum;
import com.market.model.User;
import com.market.model.UserLike;
import com.market.model.UserRoleEnum;
import com.market.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by saniaky on 6/30/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MarketConfig.class, WebAppContext.class})
@WebAppConfiguration
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService userService;

    private User user;
    private User user2;
    private int usersCount = 10;

    @Before
    public void setup() {
        user = new User("Grigoriy", new BCryptPasswordEncoder().encode("sun"), UserRoleEnum.USER);
        user2 = new User("Masha", new BCryptPasswordEncoder().encode("cars"), UserRoleEnum.USER);
    }

    @Test
    public void addUser() {
        repository.save(user);
        repository.save(user2);

        assertEquals(user, repository.getOne(user.getId()));
        assertEquals(user, repository.findByUsername(user.getUsername()));

//        List<LikeEnum> likes = new ArrayList<LikeEnum>();
//        likes.add(LikeEnum.LIKE);
//        likes.add(LikeEnum.LIKE);
//        likes.add(LikeEnum.DISLIKE);

        List<UserLike> likes = new LinkedList<UserLike>();
        for (int i = 0; i < 5; i++) {
            likes.add(new UserLike(user.getId(), user2.getId(), LikeEnum.LIKE));
        }
        user.setRating(likes);
        repository.save(user);
        assertEquals(user, repository.getOne(user.getId()));

        repository.delete(user);
        assertFalse(repository.exists(user.getId()));
    }

}
