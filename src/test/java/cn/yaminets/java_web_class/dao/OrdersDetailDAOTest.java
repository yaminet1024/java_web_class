package cn.yaminets.java_web_class.dao;

import cn.yaminets.java_web_class.dto.Orders;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrdersDetailDAOTest {
    @Autowired
    OrdersDAO ordersDAO;

    @Test
    public void insert(){
        Orders orders = new Orders();
        orders.setUserId((long) 1);
        Integer integer = ordersDAO.insertNewOrder(orders);
        System.out.println(orders.getId());
        Assert.assertNotNull(orders.getId());
    }

}