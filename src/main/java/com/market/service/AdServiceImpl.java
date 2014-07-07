package com.market.service;

import com.market.model.Ad;
import com.market.model.User;
import com.market.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by saniaky on 7/4/14.
 */
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    AdRepository repository;

    @Override
    @Transactional
    public void createAd(Ad ad) {
        repository.save(ad);
    }

    @Override
    public void updateAd(Ad ad) {
        Ad adToUpdate = repository.getOne(ad.getId());
        repository.save(adToUpdate);
    }

    @Override
    public void removeAd(Ad ad) {
        repository.delete(ad);
    }

    @Override
    public void removeAd(Long id) {
        repository.delete(id);
    }

    @Override
    public Ad getAd(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Ad> getAllAds() {
        return repository.findAll();
    }

    @Override
    public List<Ad> getAds(User user) {
        List<Ad> ads = user.getAds();
        return ads;
    }

}
