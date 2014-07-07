package com.market.model;

/**
 * Created by saniaky on 7/5/14.
 */
public enum LikeEnum {

    LIKE,
    DISLIKE;

    @Override
    public String toString() {
        switch (this) {
            case LIKE:
                return "LIKE";
            case DISLIKE:
                return "DISLIKE";
            default:
                return null;
        }
    }
}
