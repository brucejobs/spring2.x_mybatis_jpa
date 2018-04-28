package com.bbgame.dao;

import com.bbgame.repository.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author bruce
 * @Date 2018/3/31 18:20
 * @Company bbgame
 */
//@Mapper
//@Component
public  interface UserMapper   {
    //com.bbgame.repository.mapper.UserMapper
    //List<User> getUserList(String status);

    //User getUser(String status);

    User findById(Long id);

}
