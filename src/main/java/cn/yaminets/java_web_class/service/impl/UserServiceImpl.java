package cn.yaminets.java_web_class.service.impl;

import cn.yaminets.java_web_class.dao.UserDAO;
import cn.yaminets.java_web_class.dto.LoginVo;
import cn.yaminets.java_web_class.dto.Result;
import cn.yaminets.java_web_class.dto.User;
import cn.yaminets.java_web_class.enums.CodeMessage;
import cn.yaminets.java_web_class.service.RedisService;
import cn.yaminets.java_web_class.service.UserService;
import cn.yaminets.java_web_class.utils.UUIDUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
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
        User user = userDAO.getUserById(Long.parseLong(loginVo.getMobile()));
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
        userDAO.insertUser(user);
        return Result.success(user);
    }

    private void addCookie(HttpServletResponse response, String token, User user) {
        redisService.setValue(String.valueOf(user.getId()),token);
        Cookie cookie = new Cookie(TOKEN,token);
        cookie.setMaxAge(TOKEN_EXPIRE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Override
    public User getUserByToken(HttpServletResponse response, String token) {
        return null;
    }

    @Override
    public boolean isLogin(long userId) {
        return redisService.existKey(String.valueOf(userId));
    }
}
