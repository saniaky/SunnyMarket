package com.market.controller;

import com.market.dto.SignupDTO;
import com.market.dto.SignupValidator;
import com.market.model.User;
import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by saniaky on 6/26/14.
 */
@Controller
public class SignupController {

    @Autowired
    UserService userService;

    @Autowired
    SignupValidator signupValidator;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String createUser(ModelMap model) {
        User user = userService.loadAuthenticatedUser();
        if (user != null)
            return "redirect:/login/";
        model.addAttribute("signupDTO", new SignupDTO());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String createUser(SignupDTO signupDTO, BindingResult result) {
        signupValidator.validate(signupDTO, result);
        if (result.hasErrors()) {
            return "signup";
        }
        User user = new User();
        user.setUsername(signupDTO.getUsername());
        user.setPassword(signupDTO.getPassword());
        userService.addUser(user);
        return "redirect:/profile/" + user.getUsername();
    }

}
