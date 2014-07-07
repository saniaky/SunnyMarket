package com.market.model;

/**
 * Created by saniaky on 6/25/14.
 */
public enum UserRoleEnum {

    ADMIN,
    USER,
    ANONYMOUS;

    @Override
    public String toString() {
        switch (this) {
            case ADMIN:
                return "ADMIN";
            case USER:
                return "USER";
            case ANONYMOUS:
                return "ANONYMOUS";
            default:
                return null;
        }
    }
}