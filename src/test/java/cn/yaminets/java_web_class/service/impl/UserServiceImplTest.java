package cn.yaminets.java_web_class.service.impl;

import cn.yaminets.java_web_class.dto.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void login() {
    }

    @Test
    public void register() {
        User user = new User();
    }

    @Test
    public void getUserByToken() {
    }

    @Test
    public void isLogin() {
    }

    @Test
    public void getToken() {
    }
}