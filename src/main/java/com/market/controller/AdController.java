package com.market.controller;

import com.market.dto.AdDTO;
import com.market.dto.AdValidator;
import com.market.model.Ad;
import com.market.model.User;
import com.market.service.AdService;
import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.imgscalr.Scalr.*;

/**
 * Created by saniaky on 7/3/14.
 */
@Controller
@RequestMapping("ad")
public class AdController {

    @Autowired
    private AdValidator adValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private AdService adService;

    @RequestMapping(value = "all")
    public String showAds(Model model) {
        List<Ad> ads = adService.getAllAds();
        model.addAttribute("ads", ads);
        return "ads";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String showAd(@PathVariable Long id, Model model) {
        Ad ad = adService.getAd(id);
        User user = userService.loadAuthenticatedUser();
        if (user.equals(ad.getUser())) {
            model.addAttribute("personal", true);
        }
        model.addAttribute("ad", ad);
        return "ad";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String showPage(Model model) {
        model.addAttribute("adDTO", new AdDTO());
        return "create_ad";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createAd(AdDTO adDTO, BindingResult result, Model model, HttpServletRequest request) throws IOException {
        adValidator.validate(adDTO, result);
        if (result.hasErrors()) {
            model.addAttribute("adDTO", adDTO);
            return "create_ad";
        }

        Ad ad = new Ad();
        User author = userService.loadAuthenticatedUser();

        ad.setUser(author);
        ad.setTitle(adDTO.getTitle());
        ad.setText(adDTO.getText());
        ad.setTags(adDTO.getTags());

        List<String> files = new ArrayList<String>();
        Set<MultipartFile> images = adDTO.getImages();

        for (MultipartFile image : images) {
            if (image.isEmpty()) continue;

            String webappRoot = request.getServletContext().getRealPath("/");
            String r = new BigInteger(130, new SecureRandom()).toString(32);
            String filename = r + image.getOriginalFilename();

            String path =
                    webappRoot + File.separator +
                            "assets" + File.separator +
                            "uploads" + File.separator;
            File file = new File(path + filename);
            File thumb = new File(path + "thumb_" + filename);

            image.transferTo(file);
//            BufferedImage img = ImageIO.read(file);
//            BufferedImage thumbnail = resize(img, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH, 300, Scalr.OP_ANTIALIAS);
//            ImageIO.write(thumbnail, "jpg", thumb);
            files.add(filename);
        }

        ad.setImages(files);
        adService.createAd(ad);
        return "redirect:/profile/" + author.getUsername();
    }

    @RequestMapping("edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        User loggedInUser = userService.loadAuthenticatedUser();
        Ad ad = adService.getAd(id);
        if (!loggedInUser.equals(ad.getUser())) {
            return "redirect:/";
        }
        AdDTO dto = new AdDTO();
        dto.setTitle(ad.getTitle());
        dto.setText(ad.getText());
        dto.setTags(ad.getTags());
        model.addAttribute("adDTO", dto);
        model.addAttribute("id", id);
        return "update_ad";
    }

    @RequestMapping("delete/{id}")
    public String deleteAd(@PathVariable Long id, Model model) {
        User loggedInUser = userService.loadAuthenticatedUser();
        Ad ad = adService.getAd(id);
        if (!loggedInUser.equals(ad.getUser())) {
            return "redirect:/";
        }
        adService.removeAd(ad);
        return "redirect:/profile/" + loggedInUser.getUsername();
    }

    public static BufferedImage createThumbnail(BufferedImage img) {
        // Create quickly, then smooth and brighten it.
        return resize(img, Method.SPEED, 200, OP_ANTIALIAS, OP_BRIGHTER);
    }

}
