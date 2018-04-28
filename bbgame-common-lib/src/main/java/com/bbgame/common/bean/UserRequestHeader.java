package com.bbgame.common.bean;

import com.alibaba.fastjson.JSON;

/**
 * @Author bruce
 * @Date 2018/1/2 17:27
 * @Company bbgame
 * 请求头参数
 */

public class UserRequestHeader {

    private String adId;

    private String devUniqueId;

    private String model;

    private String gameId;

    private String areaId;

    private String os;

    private String packageId;

    private String channelId;

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getDevUniqueId() {
        return devUniqueId;
    }

    public void setDevUniqueId(String devUniqueId) {
        this.devUniqueId = devUniqueId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public UserRequestHeader() {

    }

    public UserRequestHeader(String adId, String devUniqueId) {
        this.adId = adId;
        this.devUniqueId = devUniqueId;
    }

    @Override
    public String toString() {
        return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }
}
