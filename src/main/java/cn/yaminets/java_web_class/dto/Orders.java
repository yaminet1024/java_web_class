package cn.yaminets.java_web_class.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @data 2019-06-17 17:14
 **/
@Data
public class Orders {
    private Long id;
    private Long userId;
    private Timestamp createDate;

}
