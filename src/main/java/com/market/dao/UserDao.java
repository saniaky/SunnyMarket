package com.market.dao;

import com.market.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by saniaky on 6/29/14.
 */
public interface UserDao {

    public void addUser(User user);
    public User getUser(Long id);
    public void updateUser(User user);
    public void deleteUser(Long id);
    public List<User> getUsers();

}