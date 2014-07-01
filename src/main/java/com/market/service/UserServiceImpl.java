package com.market.service;

import com.market.dao.UserDao;
import com.market.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by saniaky on 7/1/14.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public void updateUser(User user) {
        User userToUpdate = userDao.getUser(user.getId());
        userDao.updateUser(userToUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
