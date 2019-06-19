package cn.yaminets.java_web_class.dao;

import cn.yaminets.java_web_class.dto.Goods;

import java.util.List;

public interface GoodsDAO {
    int insertGoods(Goods goods);
    List<Goods> getGoodsList(int index,int limit);
    List<Goods> queryGoodsByName(String shopName);
    Goods getGoodsById(long id);
    int incGoodsStock(long id,int value);
    int descGoodsStock(long id,int value);
}
