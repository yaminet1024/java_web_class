package cn.yaminets.java_web_class.service.impl;

import cn.yaminets.java_web_class.dao.GoodsDAO;
import cn.yaminets.java_web_class.dto.Goods;
import cn.yaminets.java_web_class.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDAO goodsDAO;

    @Override
    public List<Goods> getGoodList(int startIndex, int limit) {
        return goodsDAO.getGoodsList(startIndex,limit);
    }

    @Override
    public Goods getGoodsById(long id) {
        return goodsDAO.getGoodsById(id);
    }

    @Override
    public List<Goods> queryGoodsByName(String name) {
        return goodsDAO.queryGoodsByName(name);
    }

    @Override
    public void newGoods(Goods goods) {
        if(null == goods){
            return;
        }
        goodsDAO.insertGoods(goods);
    }

    @Override
    public void descGoodsStock(long id, int value) {
        Goods goods = goodsDAO.getGoodsById(id);
        if(goods == null || goods.getStock() < value){
            return;
        }
        goodsDAO.descGoodsStock(id,value);
    }

    @Override
    public void incGoodsStock(long id, int value) {
        Goods goods = goodsDAO.getGoodsById(id);
        if(goods == null){
            return;
        }
        goodsDAO.incGoodsStock(id,value);
    }
}
