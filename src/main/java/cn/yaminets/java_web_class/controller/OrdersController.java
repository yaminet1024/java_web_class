package cn.yaminets.java_web_class.controller;

import cn.yaminets.java_web_class.dto.OrderDetail;
import cn.yaminets.java_web_class.dto.OrderVo;
import cn.yaminets.java_web_class.dto.Result;
import cn.yaminets.java_web_class.enums.CodeMessage;
import cn.yaminets.java_web_class.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

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
    public Result addOrder(@Valid List<OrderDetail> orderDetailList, HttpServletRequest request){
        try {
            return orderService.addOrder(orderDetailList,request);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMessage.CREATE_ORDER_FAIL);
        }
    }

    /**
     * 获取订单信息
     * @return
     */
    @GetMapping("/list/{start}/{pageSize}")
    public Result getOrders(HttpServletRequest request,@PathVariable int start,@PathVariable int pageSize){
        try {
            return orderService.getOrders(request,start,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMessage.NOT_USER_LOGIN);
        }
    }
}
