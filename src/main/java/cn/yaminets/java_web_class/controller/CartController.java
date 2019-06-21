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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "cart")
public class CartController {

    @Autowired
    CartServiceImpl cartService;

    @RequestMapping(value = "my",method = RequestMethod.GET)
    @ResponseBody
    public Result getUserCart(@RequestParam long userId){
        List<Cart> cartList =  cartService.getUserCartList(userId);
        return Result.success(cartList);
    }

    @RequestMapping(value = "inc",method = RequestMethod.POST)
    @ResponseBody
    public Result incCartNumber(CartManagerVo cartManagerVo){
        return cartService.incCartNumbers(cartManagerVo);
    }

    @RequestMapping(value = "desc",method = RequestMethod.POST)
    @ResponseBody
    public Result descCartNumber(CartManagerVo cartManagerVo){
        return cartService.descCartNumbers(cartManagerVo.getCartId(),cartManagerVo.getValue());
    }

    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public Result delCartNumber(@RequestParam long cartId){
        return cartService.delCartById(cartId);
    }

}
