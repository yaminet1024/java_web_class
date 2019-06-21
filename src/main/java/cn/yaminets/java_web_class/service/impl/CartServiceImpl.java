package cn.yaminets.java_web_class.service.impl;

import cn.yaminets.java_web_class.dao.CartDAO;
import cn.yaminets.java_web_class.dto.*;
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
    public Result incCartNumbers(CartManagerVo vo) {
        if(vo.getCartId() == 0){
            Cart tempCart = cartDAO.getCartByUserIdAndGoodsId(vo.getUserId(),vo.getGoodsId());
            if(tempCart == null){
                Cart newCart = new Cart();
                Goods goods = goodsService.getGoodsById(vo.getGoodsId());
                newCart.setUserId(vo.getUserId());
                newCart.setGoodsId(goods.getId());
                newCart.setGoodsName(goods.getTitle());
                newCart.setImages(goods.getImages());
                newCart.setNumbers(1);
                newCart.setGoodsPrice(goods.getPrice());
                cartDAO.newGoodsCart(newCart);
                vo.setCartId(newCart.getId());
            }else {
                vo.setCartId(tempCart.getId());
                Goods goods = goodsService.getGoodsById(vo.getGoodsId());
                if(tempCart.getNumbers() + vo.getValue() > goods.getStock()){
                    return Result.error(CodeMessage.INDEX_OUT_OF_STOCK);
                }
                cartDAO.incGoodsNumber(vo.getCartId(),vo.getValue());
            }
        }else {
            Cart cart = cartDAO.getCartById(vo.getCartId());
            Goods goods = goodsService.getGoodsById(cart.getGoodsId());
            System.out.println("1");
            if(cart.getNumbers() + vo.getValue() > goods.getStock()){
                return Result.error(CodeMessage.INDEX_OUT_OF_STOCK);
            }
            cartDAO.incGoodsNumber(vo.getCartId(),vo.getValue());
        }
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

    @Override
    public Result delCartById(long cartId) {
        cartDAO.delCartById(cartId);
        return Result.success(CodeMessage.SUCCESS);
    }

}
