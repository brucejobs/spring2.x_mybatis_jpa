package com.bbgame.common.bean.enums;

public enum UserOpenType {

    FACEBOOK("facebook"), GOOGLE("google"), APPLE("apple"), BBGAME("bbgame"), DEVICE("device"), OTHERS("others");

    UserOpenType(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
