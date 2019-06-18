package cn.yaminets.java_web_class.controller;

import cn.yaminets.java_web_class.dto.OrderDetail;
import cn.yaminets.java_web_class.dto.OrderVo;
import cn.yaminets.java_web_class.dto.Result;
import cn.yaminets.java_web_class.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * @Description TODO
 * @data 2019-06-17 19:07
 **/
@RestController
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    OrderService orderService;

    /**
     * 购买商品
     * @param orderDetailList 商品id列表
     * @return
     */
    @PostMapping("/buy")
    public Result addOrder(@Valid List<OrderDetail> orderDetailList, String token){
        return orderService.addOrder(orderDetailList);
    }

//    @GetMapping("/list")
//    public Result orderList(){
//
//    }
}
