package com.bbgame.authority.controller;

import com.alibaba.fastjson.JSONObject;
import com.bbgame.Routes;
import com.bbgame.common.web.JsonResult;
import com.bbgame.common.web.RestDoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * mock测试控制器
 * @Author bruce
 * @Date 2018/3/29 10:26
 * @Company bbgame
 */

@RestController
@RequestMapping(Routes.API_VERSION)
public class MockController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static String pramas_application_type = "Content-type";
    private final static String pramas_versionId = "versionId";
    private final static String pramas_channelId = "channelId";
    private final static String pramas_gameId = "gameId";
    private final static String pramas_packageId = "packageId";
    private final static String pramas_areaId = "areaId";
    private final static String pramas_adId = "adId";
    private final static String pramas_devUniqueId = "devUniqueId";
    private final static String pramas_userToken = "userToken";
    private final static String pramas_os = "os";
    private final static String pramas_model = "model";
    private final static String pramas_sign = "sign";
    private final static String pramas_randomNum = "randomNum";
    private final static String pramas_cpOrderNum = "randomNum";

    // 默认参数值
    private final static String application_type = "application/json";
    private final static String versionId = "1";
    private final static String channelId = "1";
    private final static String gameId = "1";
    private final static String packageId = "1";
    private final static String areaId = "886852";
    private final static String adId = "1510780873479-2069533";
    private final static String devUniqueId = "357709061619719";
    private final static String userToken = "a0f44bf719121a8d388fb201a2ff79fb471b0c7cd215e22d0a60edff92b635f1";
    private final static String os = "android";
    private final static String model = "iphoneX";
    private final static String cpOrderNum = "sgz8888888383898ff123";
    private final static String sign = "sdf3423asd2232335555234";
    private final static String randomNum = "77a90a72-a501-4627-b4b8-287abfda8e92";
    private final static String switch_request = ""; // 氢气类型开关 http, https
    private final static String[] request_type = new String[] {"GET","POST","PATCH","DELETE","PUT"};
    private final static String path = ""; // 默认请求路径
    private final static String[] http_type = new String[] {"http","https"}; // 默认请求路径

    static {

    }

    /**
     * 返回数据体量 512b 1k 2k
     * @return
     */
    @RequestMapping(value = "/sys/server/responseData", method = RequestMethod.GET)
    public JsonResult requestData() {
        RestDoing doing = jsonResult -> {
            String randomData = UUID.randomUUID().toString();//随机数据
            Map<String,String> map = new HashMap<>();
            map.put(pramas_application_type, application_type);
            map.put(pramas_versionId, versionId);
            map.put(pramas_channelId, channelId);
            map.put(pramas_gameId, gameId);
            map.put(pramas_packageId, packageId);
            map.put(pramas_areaId, areaId);
            map.put(pramas_adId, adId);
            map.put(pramas_devUniqueId, devUniqueId+randomData);
            map.put(pramas_os, os);
            map.put(pramas_model, model);
            map.put(pramas_sign, sign);
            map.put(pramas_cpOrderNum, cpOrderNum+randomData);
            map.put(pramas_userToken, userToken);
            map.put(pramas_randomNum, randomNum);
            jsonResult.data = JSONObject.toJSONString(map);
        };
        return doing.go(logger);
    }

}
