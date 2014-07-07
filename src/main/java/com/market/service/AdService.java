package com.market.service;

import com.market.model.Ad;
import com.market.model.User;

import java.util.List;

/**
 * Created by saniaky on 7/3/14.
 */
public interface AdService {

    public void createAd(Ad ad);
    public void updateAd(Ad ad);
    public void removeAd(Ad ad);
    public void removeAd(Long id);
    public Ad getAd(Long id);
    public List<Ad> getAds(User user);
    public List<Ad> getAllAds();

}
