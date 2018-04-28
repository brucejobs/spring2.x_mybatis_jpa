package com.bbgame.authority.dao;

import com.bbgame.authority.domain.UserEntity;

/**
 * @Author bruce
 * @Date 2018/3/31 18:20
 * @Company bbgame
 */
public  interface UserMapper   {

    int addUser(UserEntity user);

    UserEntity findById(Long id);

    int updateUser(UserEntity user);

    int deleteAuthorById(Long id);

    void deleteAll();

    int findUserList(Long count);

}
