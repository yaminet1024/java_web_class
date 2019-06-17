package cn.yaminets.java_web_class.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @data 2019-06-17 18:28
 **/
@Data
public class OrderVo {
    private Long id;
    private Long userId;
    private Timestamp createDate;
    private Long goodsId;
    private Integer numbers;
}
