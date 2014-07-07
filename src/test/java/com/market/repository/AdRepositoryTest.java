package com.market.repository;

import com.market.config.MarketConfig;
import com.market.config.WebAppContext;
import com.market.model.Ad;
import com.market.service.AdService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * Created by saniaky on 7/4/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MarketConfig.class, WebAppContext.class})
@WebAppConfiguration
@Transactional
public class AdRepositoryTest {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private AdService adService;

    private Ad ad;

    @Before
    public void setup() {
        ad = new Ad();
        ad.setTitle("some title");
        ad.setText("Text of some interesting title");
        HashSet<String> tags = new HashSet<String>();
        tags.add("first tag");
        tags.add("second tag");
        ad.setTags(tags);
    }

    @Test
    public void create() {
        adRepository.save(ad);
        assertEquals(ad, adRepository.findOne(ad.getId()));
    }

    @Test
    public void delete() {

    }

    @Test
    public void findAll() {}

    @Test
    public void findById() {

    }

    @Test
    public void update() {}

}
