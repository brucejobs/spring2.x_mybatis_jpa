package com.bbgame.common.service;

import com.bbgame.common.bean.UserRequestHeader;


/**
 * @Author bruce
 * @Date 2018/1/2 14:33
 * @Company bbgame
 * 封禁通用基类
 */

public interface CommonBandService {

    void judgeBandInfo(String paras, UserRequestHeader requestHeader);

    void manageConditionList(String module, String conditionList, String status);

}
