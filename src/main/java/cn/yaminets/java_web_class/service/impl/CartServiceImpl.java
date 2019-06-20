package cn.yaminets.java_web_class.service.impl;

import cn.yaminets.java_web_class.dao.CartDAO;
import cn.yaminets.java_web_class.dto.Cart;
import cn.yaminets.java_web_class.dto.Goods;
import cn.yaminets.java_web_class.dto.Result;
import cn.yaminets.java_web_class.dto.User;
import cn.yaminets.java_web_class.enums.CodeMessage;
import cn.yaminets.java_web_class.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDAO cartDAO;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    GoodsServiceImpl goodsService;

    @Override
    public List<Cart> getUserCartList(long userId) {
        User user = userService.getUserById(userId);
        if (user == null){
            return null;
        }
        return cartDAO.getUserCart(userId);
    }

    @Override
    public Result incCartNumbers(long cartId, int value) {
        Cart cart = cartDAO.getCartById(cartId);
        Goods goods = goodsService.getGoodsById(cart.getGoodsId());
        if(value + cart.getNumbers() > goods.getStock()){
            return Result.error(CodeMessage.INDEX_OUT_OF_STOCK);
        }
        cartDAO.incGoodsNumber(cartId,value);
        return Result.success(CodeMessage.SUCCESS);
    }

    @Override
    public Result descCartNumbers(long cartId, int value) {
        Cart cart = cartDAO.getCartById(cartId);
        if(value > cart.getNumbers()){
            return Result.error(CodeMessage.INDEX_OUT_OF_STOCK);
        }
        cartDAO.descGoodsNumber(cartId,value);
        return Result.success(CodeMessage.SUCCESS);
    }
}
