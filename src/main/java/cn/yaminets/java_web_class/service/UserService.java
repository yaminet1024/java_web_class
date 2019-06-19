package cn.yaminets.java_web_class.service;


import cn.yaminets.java_web_class.dto.LoginVo;
import cn.yaminets.java_web_class.dto.Result;
import cn.yaminets.java_web_class.dto.User;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletResponse;

public interface UserService {
    Result login(HttpServletResponse response, LoginVo loginVo);

    Result register(HttpServletResponse response,User user);

    User getUserByToken(String token);

    boolean isLogin(String token);
}
