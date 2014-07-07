package com.market.controller;

import com.market.model.User;
import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by saniaky on 7/7/14.
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping("/**")
    public String showMainPage(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "admin";
    }

    @RequestMapping("/edit/{username}")
    public String editUser(@PathVariable String username, Model model) {
        User user = userService.getUser(username);
        model.addAttribute("user", user);
        return "user_edit";
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String updateUser(@RequestParam String role, Model model) {
        model.addAttribute("msg", "User updated");
        return "redirect:/admin";
    }


    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    public @ResponseBody String deleteUser(@RequestParam Long id, Model model) {
        model.addAttribute("msg", "User deleted");
        userService.deleteUser(id);
        return "ok";
    }


}
