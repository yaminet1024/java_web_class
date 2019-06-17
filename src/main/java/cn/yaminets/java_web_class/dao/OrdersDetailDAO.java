package cn.yaminets.java_web_class.dao;

import cn.yaminets.java_web_class.dto.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName OrdersDetailDAO
 * @Description TODO
 **/
@Mapper
public interface OrdersDetailDAO {
    /**1. 添加新详细订单*/
    public Integer insertNewDetailOrder(OrderDetail orderDetail);


}
