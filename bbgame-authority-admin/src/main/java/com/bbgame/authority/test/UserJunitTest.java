//package com.bbgame.authority.test;
//
//import com.bbgame.authority.BootStrapAdminApi;
//import com.bbgame.authority.dao.UserMapper;
//import com.bbgame.authority.domain.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @Author bruce
// * @Date 2018/4/24 10:03
// * @Company bbgame
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest//(classes = BootStrapAdminApi.class)
//public class UserJunitTest {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    //增加
//    @Test
//    public void addUser() {
//        User user = new User();
//        user.setAccount("brucejobs521");
//        user.setEmail("1084372784@qq.com");
//        user.setNickName("liuzhiwen");
//        long start_time = System.currentTimeMillis();
//        int saveUser = userMapper.addUser(user);
//        System.out.println("const time: " + (System.currentTimeMillis() - start_time) + " ms");
//        System.out.println("======save result is=====>" + saveUser);
//    }
//
//    //删除
//    @Test
//    public void deleteUser() {
//        long start_time = System.currentTimeMillis();
//        int saveUser = userMapper.deleteAuthorById( 10020L);
//        System.out.println("const time: " + (System.currentTimeMillis() - start_time) + " ms");
//        System.out.println("======delete result is=====>" + saveUser);
//    }
//
//    //修改
//    @Test
//    public void updateUser() {
//        User user = new User();
//        user.setId(495496L);
//        user.setAccount("most import");
//        long start_time = System.currentTimeMillis();
//        int saveUser = userMapper.updateUser(user);
//        System.out.println("const time: " + (System.currentTimeMillis() - start_time) + " ms");
//        System.out.println("======update result is=====>" + saveUser);
//    }
//
//    //查找
//    @Test
//    public void findUser() {
//        long start_time = System.currentTimeMillis();
//        User user = userMapper.findById(2L);
//        System.out.println("const time: " + (System.currentTimeMillis() - start_time) + " ms");
//        System.out.println("======find result is=====>" + user.getAccount());
//    }
//
//    @Test
//    public void findUserByLimit() {
//        long start_time = System.currentTimeMillis();
//        int user = userMapper.findUserList(2L);
//        System.out.println("const time: " + (System.currentTimeMillis() - start_time) + " ms");
//        System.out.println("======find result is=====>" + user);
//    }
//
//}
