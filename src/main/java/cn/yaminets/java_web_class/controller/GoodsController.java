package cn.yaminets.java_web_class.controller;

import cn.yaminets.java_web_class.dto.Goods;
import cn.yaminets.java_web_class.dto.Result;
import cn.yaminets.java_web_class.enums.CodeMessage;
import cn.yaminets.java_web_class.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "goods")
public class GoodsController {

    @Autowired
    GoodsServiceImpl goodsService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Result getGoodsList(@RequestParam int startIndex,@RequestParam int limit){
        List<Goods> goodsList = goodsService.getGoodList(startIndex,limit);
        if (goodsList == null || goodsList.isEmpty()){
            return Result.error(CodeMessage.EMPTY_DATA);
        }
        return Result.success(goodsList);
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ResponseBody
    public Result getGoodsById(@RequestParam long goodsId){
        Goods goods = goodsService.getGoodsById(goodsId);
        if(null == goods){
            return Result.error(CodeMessage.GOODS_NOT_EXIST);
        }
        return Result.success(goods);
    }

}
