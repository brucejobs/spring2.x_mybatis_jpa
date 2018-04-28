package com.bbgame.common.enums;

/**
 * @Author bruce
 * @Date 2018/4/3 10:08
 * @Company bbgame
 */
public enum DeleteStatus {

    YES("是"), NO("否");

    DeleteStatus(String text) {
        this.text = text;
    }

    private int sort;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}   