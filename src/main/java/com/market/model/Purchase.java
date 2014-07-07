package com.market.model;

import javax.persistence.PrePersist;
import java.util.Date;

/**
 * Created by saniaky on 7/3/14.
 */
public class Purchase {

    private User buyer;
    private User seller;
    private Ad ad;
    private Date creationTime;

    @PrePersist
    public void prePersist() {
        creationTime = new Date();
    }
}
