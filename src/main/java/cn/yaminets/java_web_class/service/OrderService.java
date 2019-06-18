package cn.yaminets.java_web_class.service;

import cn.yaminets.java_web_class.dto.OrderDetail;
import cn.yaminets.java_web_class.dto.OrderVo;
import cn.yaminets.java_web_class.dto.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName OrderService
 * @Description TODO
 **/
public interface OrderService {
    public Result addOrder(@NotNull List<OrderDetail> orderDetailList);
}
