package cn.yaminets.java_web_class.dao;

import cn.yaminets.java_web_class.dto.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CartDAO {
    List<Cart> getUserCart(long userId);
    Cart getCartById(long cartId);
    void newGoodsCart(Cart cart);
    void incGoodsNumber(long cartId,int value);
    void descGoodsNumber(long cartId,int value);
    Cart getCartByUserIdAndGoodsId(long userId,long goodsId);
    void delCartById(long cartId);
}
