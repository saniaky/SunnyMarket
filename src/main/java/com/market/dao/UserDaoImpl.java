package com.market.dao;

import com.market.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Created by saniaky on 6/29/14.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        User userToUpdate = getUser(user.getId());
        userToUpdate.setUsername(user.getUsername());
        entityManager.refresh(userToUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUser(id);
        if (user != null)
            entityManager.remove(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        List<User> users = entityManager.createQuery("from User").getResultList();
        return users;
    }
}
