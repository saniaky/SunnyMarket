package com.market.controller;

import com.market.model.LikeEnum;
import com.market.model.User;
import com.market.model.UserLike;
import com.market.service.AdService;
import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by saniaky on 7/1/14.
 */
@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    UserService userService;

    @Autowired
    AdService adService;

    @RequestMapping("{username}")
    public String showUser(@PathVariable("username") String name, Model model) {
        User user = userService.getUser(name);

        if (user == null) return "redirect:/";
        if (user.equals(userService.loadAuthenticatedUser())) {
            model.addAttribute("personal", true);
        }
        model.addAttribute("user", user);
        model.addAttribute("up", user.getLikes());
        model.addAttribute("down", user.getDislikes());
        return "profile";
    }

    @RequestMapping(value = "vote", method = RequestMethod.POST)
    public @ResponseBody String upVote(@RequestParam("user") String username,
                                       @RequestParam("decision") String decision,
                                       Model model) {
        User receiverUser = userService.getUser(username);
        User loggedInUser = userService.loadAuthenticatedUser();

        if (receiverUser == null || loggedInUser == null) return "You must login, to vote!";
        if (receiverUser.equals(loggedInUser)) return "Can't rate yourself";

        List<UserLike> votes = receiverUser.getRating();
        for (UserLike vote : votes) {
            if (vote.getOwner_id().equals(loggedInUser.getId())) {
                return "You already did that";
            }
        }

        UserLike like = new UserLike();
        if (decision.equals("up")) {
            receiverUser.like();
            like.setDecision(LikeEnum.LIKE);
        } else {
            receiverUser.dislike();
            like.setDecision(LikeEnum.DISLIKE);
        }
        like.setOwner_id(loggedInUser.getId());
        like.setRecipient_id(receiverUser.getId());
        votes.add(like);
        receiverUser.setRating(votes);
        userService.updateUser(receiverUser);

        return "ok";
    }

}
