package cn.yaminets.java_web_class.controller;

import cn.yaminets.java_web_class.dto.OrderDetail;
import cn.yaminets.java_web_class.dto.OrderVo;
import cn.yaminets.java_web_class.dto.Result;
import cn.yaminets.java_web_class.enums.CodeMessage;
import cn.yaminets.java_web_class.service.OrderService;
import cn.yaminets.java_web_class.utils.Utils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    OrderService orderService;

    /**
     * 购买商品
     * @return
     */
    @PostMapping("/buy")
    public Result addOrder(@RequestBody @Valid String jsonString, HttpServletRequest request){
        try {
            jsonString = URLDecoder.decode(jsonString, "GBK");
            jsonString = jsonString.replace("jsonString=","");
            System.out.println(jsonString + " fuck");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<OrderDetail> orderDetailList = JSON.parseArray(jsonString,OrderDetail.class);
        System.out.println(orderDetailList);
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
