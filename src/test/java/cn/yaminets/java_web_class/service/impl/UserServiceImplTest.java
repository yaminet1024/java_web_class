package cn.yaminets.java_web_class.service.impl;

import cn.yaminets.java_web_class.dto.User;
import cn.yaminets.java_web_class.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    @Test
    public void login() {
    }

    @Test
    public void register() {
        User user = new User();
    }

    @Test
    public void getUserByToken() {
        UserService userService = new UserServiceImpl();
        User user = userService.getUserByToken("ff003d8f-1004-4081-a6d7-1d12d2a2e1ad");
        System.out.println(user);
    }

    @Test
    public void isLogin() {
    }

    @Test
    public void getToken() {
    }
}