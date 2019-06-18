package cn.yaminets.java_web_class.service.impl;

import cn.yaminets.java_web_class.dao.OrdersDAO;
import cn.yaminets.java_web_class.dto.OrderDetail;
import cn.yaminets.java_web_class.dto.Orders;
import cn.yaminets.java_web_class.dto.Result;
import cn.yaminets.java_web_class.dto.User;
import cn.yaminets.java_web_class.enums.CodeMessage;
import cn.yaminets.java_web_class.service.OrderService;
import cn.yaminets.java_web_class.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName OrderServiceimpl
 * @Description TODO
 **/
@Service
public class OrderServiceimpl implements OrderService {
    @Autowired
    OrdersDAO ordersDAO;
    @Autowired
    UserService userService;

    @Override
    public Result addOrder(@NotNull List<OrderDetail> orderDetailList) {
        /*获取当前用户id*/

        /*检查商品库存是否大于0*/

        /*添加新的订单*/

        /*根据订单id添加详细数据*/
        return Result.success(null);
    }
}
