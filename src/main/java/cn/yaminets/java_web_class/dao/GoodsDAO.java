package cn.yaminets.java_web_class.dao;

import cn.yaminets.java_web_class.dto.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodsDAO {
    int insertGoods(Goods goods);
    List<Goods> getGoodsList(int index,int limit);
    List<Goods> queryGoodsByName(String shopName);
    Goods getGoodsById(long id);
    int incGoodsStock(long id,int value);
    int descGoodsStock(long id,int value);
}
