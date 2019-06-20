package cn.yaminets.java_web_class.dao;

import cn.yaminets.java_web_class.dto.OrderDetail;
import cn.yaminets.java_web_class.dto.Orders;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrdersDetailDAOTest {
    @Autowired
    OrdersDAO ordersDAO;
    @Autowired
    OrdersDetailDAO ordersDetailDAO;

    @Test
    public void insert(){
        Orders orders = new Orders();
        orders.setUserId((long) 1);
        ordersDAO.insertNewOrder(orders);
        System.out.println(orders.getId());
        Assert.assertNotNull(orders.getId());
    }

    @Test
    public void get(){

    }

    @Test
    public void getDetail(){
        List<OrderDetail> orderDetails = ordersDetailDAO.selectDetailInfo((long) 1);
        System.out.println(orderDetails.size());
    }

    @Test
    public void insertDetail(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setGoodsId((long) 1);
        orderDetail.setNumbers(100);
        orderDetail.setOrderId((long) 1);
        Integer integer = ordersDetailDAO.insertNewDetailOrder(orderDetail);
        System.out.println(integer);
    }


}