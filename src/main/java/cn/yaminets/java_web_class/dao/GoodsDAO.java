package cn.yaminets.java_web_class.dao;

import cn.yaminets.java_web_class.dto.Goods;

public interface GoodsDAO {
    int insertGoods(Goods goods);
    int qureyGoods(String shopName);
}
