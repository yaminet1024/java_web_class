package cn.yaminets.java_web_class.controller;

import cn.yaminets.java_web_class.dto.LoginVo;
import cn.yaminets.java_web_class.dto.Result;
import cn.yaminets.java_web_class.dto.User;
import cn.yaminets.java_web_class.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    @ResponseBody
    public Result login(HttpServletResponse response, @Valid LoginVo loginVo){
        return userService.login(response,loginVo);
    }

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    @ResponseBody
    public Result register(HttpServletResponse response, @Valid User user){
        return userService.register(response,user);
    }

}
