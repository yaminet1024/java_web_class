package cn.yaminets.java_web_class.service;

import cn.yaminets.java_web_class.dto.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getGoodList(int startIndex,int limit);
    Goods getGoodsById(long id);
    /**模糊搜索商品列表**/
    List<Goods> queryGoodsByName(String name);
    /**创建新的商品**/
    void newGoods(Goods goods);
    /** 减少库存 **/
    void descGoodsStock(long id,int value);
    /** 增加库存 **/
    void incGoodsStock(long id, int value);
}
