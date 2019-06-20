package cn.yaminets.java_web_class.service.impl;

import cn.yaminets.java_web_class.dao.UserDAO;
import cn.yaminets.java_web_class.dto.LoginVo;
import cn.yaminets.java_web_class.dto.Result;
import cn.yaminets.java_web_class.dto.User;
import cn.yaminets.java_web_class.enums.CodeMessage;
import cn.yaminets.java_web_class.service.UserService;
import cn.yaminets.java_web_class.utils.UUIDUtil;
import cn.yaminets.java_web_class.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private static final String TOKEN = "token";
    private static final int TOKEN_EXPIRE = 3600*24*2;


    @Autowired
    UserDAO userDAO;

    @Autowired
    RedisServiceImpl redisService;

    @Override
    public Result login(HttpServletResponse response, @NotNull LoginVo loginVo) {
        try {
            loginVo.setPassword(Utils.encodeByMd5(loginVo.getPassword()));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = userDAO.getUserById(Long.parseLong(loginVo.getMobile()));
        user.setLoginCount(user.getLoginCount() + 1);
        if (null == user){
            return Result.error(CodeMessage.LOGIN_USER_NAME_ERROR);
        }
        if (!user.getPassword().equals(loginVo.getPassword())){
            return Result.error(CodeMessage.LOGIN_PASSWORD_ERROR);
        }
        userDAO.incLoginCount(user.getId());
        userDAO.setLastLoginDate(user.getId(),new Date());
        String token = UUIDUtil.UUID();
        addCookie(response,token,user);
        return Result.success(user);
    }

    @Override
    public Result register(HttpServletResponse response, User user) {
        User checkExist = userDAO.getUserById(user.getId());
        if (checkExist != null){
            return Result.error(CodeMessage.RESGISTER_USER_EXIST);
        }
        try {
            user.setPassword(Utils.encodeByMd5(user.getPassword()));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        user.setRegisterDate(new Date());
        userDAO.insertUser(user);
        return Result.success(user);
    }

    private void addCookie(HttpServletResponse response, String token, User user) {
        redisService.setValue(token,user.getId());
        Cookie cookie = new Cookie(TOKEN,token);
        cookie.setMaxAge(TOKEN_EXPIRE);
        cookie.setPath("/");
        response.addCookie(cookie);
        response.setHeader(TOKEN,token);
        response.setHeader("Access-Control-Expose-Headers", "token");
    }

    @Override
    public User getUserByToken(String token) {
        Long userId = redisService.getValue(token,Long.class);
        return userDAO.getUserById(userId);
    }

    @Override
    public User getUserById(long userId) {
        return userDAO.getUserById(userId);
    }

    @Override
    public boolean isLogin(String token) {
        return redisService.existKey(String.valueOf(token));
    }

    @Override
    public String getToken(HttpServletRequest request) {
        String token = "";
        for(Cookie cookie: request.getCookies()){
            if(cookie.getName().equals(TOKEN)){
                token = cookie.getValue();
            }
        }
        //兼容header里面添加token的方案
        String headerToken = request.getHeader(TOKEN);
        if (headerToken != null && headerToken.length()>0){
            token = headerToken;
        }
        return token;
    }


}
