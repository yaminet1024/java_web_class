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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }
}
