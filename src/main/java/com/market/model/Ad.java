package com.market.model;

import java.util.Date;

/**
 * Created by saniaky on 6/29/14.
 */
public class Ad {

    String title;
    String text;
    User creator;
    Date creationDate;

    public Ad(String title, String text, User creator) {
        this.title = title;
        this.text = text;
        this.creator = creator;
    }
}
