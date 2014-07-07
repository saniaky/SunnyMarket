package com.market.controller;

import com.market.model.User;
import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by saniaky on 6/30/14.
 */
@Controller
//@PropertySource("classpath:i18n/messages_en.properties")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showHomePage() {
        ModelAndView model = new ModelAndView("home");
        User user = userService.loadAuthenticatedUser();
        model.addObject("user", user);
        return model;
    }

}
