package cn.yaminets.java_web_class.controller;

import cn.yaminets.java_web_class.dto.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "goods")
public class GoodsController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public Result getGoodsList(int startIndex,int limit){
        return null;
    }

}
