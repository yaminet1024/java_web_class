package cn.yaminets.java_web_class.service.impl;

import cn.yaminets.java_web_class.dao.OrdersDAO;
import cn.yaminets.java_web_class.dao.OrdersDetailDAO;
import cn.yaminets.java_web_class.dto.*;
import cn.yaminets.java_web_class.enums.CodeMessage;
import cn.yaminets.java_web_class.service.GoodsService;
import cn.yaminets.java_web_class.service.OrderService;
import cn.yaminets.java_web_class.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceimpl implements OrderService {
    @Autowired
    OrdersDAO ordersDAO;
    @Autowired
    OrdersDetailDAO ordersDetailDAO;
    @Autowired
    UserService userService;
    @Autowired
    GoodsService goodsService;

    @Override
    public Result getOrders(HttpServletRequest request,int start,int pageSize) throws Exception {
        User userByRequset = getUserByRequset(request);
        /*根据用户信息查询订单表*/
        List<Orders> orders = ordersDAO.selectAllOrder(userByRequset.getId(),start,pageSize);
        /*根据订单表id获取订单详细表数据*/
        if(orders==null){
            return Result.success(CodeMessage.ORDER_NOT_EXIT);
        }
        List<List<OrderDetail>> orderDetailList = new ArrayList<>();
        for(Orders orders1:orders){
            List<OrderDetail> orderDetailList1 = ordersDetailDAO.selectDetailInfo(orders1.getId());
            orderDetailList.add(orderDetailList1);
        }
        return Result.success(orderDetailList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result addOrder(@NotNull List<OrderDetail> orderDetailList,HttpServletRequest request) throws Exception{
        User userByRequset = getUserByRequset(request);
        //根据订单id添加详细数据
        for(OrderDetail orderDetail:orderDetailList){
            Orders orders = new Orders();
            orders.setUserId(userByRequset.getId());
            orders.setGoodsId(orderDetail.getGoodsId());
            orders.setNumbers(orderDetail.getNumbers());
            orders.setCreateDate(new Date());
            ordersDAO.insertNewOrder(orders);
            Long id = orders.getId();
            Goods goodsById = goodsService.getGoodsById(orderDetail.getGoodsId());
            if(goodsById.getStock()<orderDetail.getNumbers()){
                throw new Exception();
            }
            /*减库存*/
            goodsService.descGoodsStock(orderDetail.getGoodsId(),orderDetail.getNumbers());
            orderDetail.setOrderId(id);
//            ordersDetailDAO.insertNewDetailOrder(orderDetail);
        }
        return Result.success(CodeMessage.SUCCESS);
    }

    public User getUserByRequset(HttpServletRequest request) throws Exception {
        /*获取token*/
        String token = userService.getToken(request);
        if(!userService.isLogin(token)){
            throw new Exception(String.valueOf(CodeMessage.NOT_USER_LOGIN));
        }
        /*获取用户信息*/
        User userByToken = userService.getUserByToken(token);
        if(userByToken==null){
            throw  new Exception(String.valueOf(CodeMessage.NOT_USER_LOGIN));
        }
        return userByToken;
    }
}
