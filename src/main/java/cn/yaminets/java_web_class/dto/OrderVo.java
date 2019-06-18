package cn.yaminets.java_web_class.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description TODO
 * @data 2019-06-17 18:28
 **/
@Data
public class OrderVo {
    private Long id;
    private Long userId;
    List<OrderDetail> orderDetails;
}
