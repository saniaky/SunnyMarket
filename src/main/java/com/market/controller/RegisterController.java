package com.market.controller;

import com.market.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by saniaky on 6/26/14.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @RequestMapping(method = RequestMethod.POST)
    public String register(@ModelAttribute User user) {
        // registration logic
        return "redirect:/login";
    }
}
