package cn.yaminets.java_web_class.controller;

import cn.yaminets.java_web_class.dto.Cart;
import cn.yaminets.java_web_class.dto.CartManagerVo;
import cn.yaminets.java_web_class.dto.Result;
import cn.yaminets.java_web_class.service.impl.CartServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "cart")
public class CartController {

    @Autowired
    CartServiceImpl cartService;

    @RequestMapping(value = "my",method = RequestMethod.GET)
    public Result getUserCart(@RequestParam long userId){
        List<Cart> cartList =  cartService.getUserCartList(userId);
        return Result.success(cartList);
    }

    @RequestMapping(value = "inc",method = RequestMethod.POST)
    public Result incCartNumber(CartManagerVo cartManagerVo){
        return cartService.incCartNumbers(cartManagerVo.getCartId(),cartManagerVo.getValue());
    }

    @RequestMapping(value = "desc",method = RequestMethod.POST)
    public Result descCartNumber(CartManagerVo cartManagerVo){
        return cartService.descCartNumbers(cartManagerVo.getCartId(),cartManagerVo.getValue());
    }

}
