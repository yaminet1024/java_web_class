package cn.yaminets.java_web_class.dao;

import cn.yaminets.java_web_class.dto.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName OrdersDetailDAO
 * @Description TODO
 **/
@Mapper
public interface OrdersDetailDAO {
    /**1. 添加新详细订单*/
    Integer insertNewDetailOrder(OrderDetail orderDetail);
    /**2. 获取详细订单信息*/
    List<OrderDetail> selectDetailInfo(Long orderId);

}
