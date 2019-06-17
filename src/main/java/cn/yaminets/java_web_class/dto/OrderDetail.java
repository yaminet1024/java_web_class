package cn.yaminets.java_web_class.dto;

import lombok.Data;

/**
 * @Description TODO
 * @data 2019-06-17 17:15
 **/
@Data
public class OrderDetail {
    private Long orderId;
    private Long goodsId;
    private Integer numbers;
}
