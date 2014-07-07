package com.market.service;

import com.market.model.User;

import java.util.List;

/**
 * Created by saniaky on 6/30/14.
 */
public interface UserService {

    public void addUser(User user);
    public User getUser(Long id);
    public User getUser(String username);
    public void updateUser(User user);
    public void deleteUser(Long id);
    public List<User> getUsers();
    public User loadAuthenticatedUser();
    public boolean isUserExist(String username);


}
