package cn.yaminets.java_web_class.service;

import cn.yaminets.java_web_class.dto.Cart;
import cn.yaminets.java_web_class.dto.Result;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {
    List<Cart> getUserCartList(long userId);
    Result incCartNumbers(long cartId, int value);
    Result descCartNumbers(long cartId,int value);
}
