package com.bbgame.authority.test;

import com.bbgame.authority.entity.User;
import com.bbgame.authority.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @Author bruce
 * @Date 2018/4/24 11:50
 * @Company bbgame
 */

@RunWith(SpringRunner.class)
@SpringBootTest
//@EnableJpaRepositories
public class UserJpaJunitTest {

    @Autowired
    private UserRepository userRepository;
    
    //增加
    @Test
    public void addUser() {
        User user = new User();
        user.setAccount("andyjobs1234");
        user.setEmail("1084372784@qq.com");
        user.setNickName("liuzhiwen");
        long start_time = System.currentTimeMillis();
        User saveUser = userRepository.save(user);
        System.out.println("const time: " + (System.currentTimeMillis() - start_time) + " ms");
        System.out.println("======save result is=====>" + saveUser);
    }

    //删除
    @Test
    public void deleteUser() {
        long start_time = System.currentTimeMillis();
        userRepository.deleteById(4L);
        System.out.println("const time: " + (System.currentTimeMillis() - start_time) + " ms");
        System.out.println("======delete result is finished=====>" );
    }

    //修改
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(680302L);
        user.setAccount("most mybatis import");
        long start_time = System.currentTimeMillis();
        User saveUser = userRepository.save(user);
        System.out.println("const time: " + (System.currentTimeMillis() - start_time) + " ms");
        System.out.println("======update result is=====>" + saveUser);
    }

    //查找
    @Test
    public void findUser() {
        long start_time = System.currentTimeMillis();
        Optional<User> user = userRepository.findById(2L);
        System.out.println("const time: " + (System.currentTimeMillis() - start_time) + " ms");
        System.out.println("======find result is=====>" + user.get().getAccount());
    }

    @Test
    public void findUserByLimit() {
//        long start_time = System.currentTimeMillis();
//        List<User> userList = userRepository.getUserListLimit(10);
//        System.out.println("const time: " + (System.currentTimeMillis() - start_time) + " ms");
//        System.out.println("======find result is=====>" + userList.size());
    }

}
