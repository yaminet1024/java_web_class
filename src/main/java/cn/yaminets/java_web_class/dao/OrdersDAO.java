package cn.yaminets.java_web_class.dao;

import cn.yaminets.java_web_class.dto.OrderVo;
import cn.yaminets.java_web_class.dto.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TODO
 * @data 2019-06-17 17:31
 **/
@Mapper
@Component
public interface OrdersDAO {
    /**1。 添加新订单*/
    public Integer insertNewOrder(Orders orders);

    /**2。 获取所有订单*/
    public List<Orders> selectAllOrder();
    /**3。 根据Id获取对应数据*/

    /**4。 根据用户获取对应数据*/
}
