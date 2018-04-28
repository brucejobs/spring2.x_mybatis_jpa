package com.bbgame.authority.controller;

import com.bbgame.Routes;
import com.bbgame.authority.entity.User;
import com.bbgame.authority.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author bruce
 * @Date 2018/4/23 17:00
 * @Company bbgame
 */

@RestController
@RequestMapping(Routes.API_VERSION)
public class GameController {

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/gameData",method = RequestMethod.GET)
    public String gameData() {
        User user = new User();
        user.setId(8L);
        user.setAccount("andyjobs1234");
        user.setEmail("1084372784@qq.com");
        user.setNickName("liuzhiwen");
        long start_time = System.currentTimeMillis();
        User saveUser = userRepository.save(user);
//        System.out.println("=========?>" + userMapper);
//        System.out.println("====result=====?>" + userMapper.findById(1L));
        return "success";
    }

 }
