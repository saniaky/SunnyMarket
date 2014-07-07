package com.market.controller;

import com.market.model.User;
import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by saniaky on 7/6/14.
 */
@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping("users")
    public String showPage(Model model) {
        List<User> upVoted = userService.getUsers();
        List<User> downVoted = userService.getUsers();
        List<User> recentUsers = userService.getUsers();

        // sort by likes
        Collections.sort(upVoted, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getLikes().compareTo(o1.getLikes());
            }
        });
        model.addAttribute("upvoted_users", upVoted);

        // sort by dislikes
        Collections.sort(downVoted, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getDislikes().compareTo(o1.getDislikes());
            }
        });
        model.addAttribute("downvoted_users", downVoted);


        // sort by registration date
        Collections.sort(recentUsers, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getCreationTime().compareTo(o1.getCreationTime());
            }
        });
        model.addAttribute("recent_users", recentUsers);

        return "users";
    }
}
