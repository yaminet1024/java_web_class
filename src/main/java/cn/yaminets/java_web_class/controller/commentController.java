package cn.yaminets.java_web_class.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**评论id
 * 评论标题
 * 评论内容
 * 商品id
 * 评论时间
 */
@Controller
@RequestMapping(value = "/comment")

public class commentController {

    @RequestMapping("add_comment")
    @ResponseBody
    public void addComment(Long id,String title,String content,String productId){

    }

    @RequestMapping("delete_comment")
    @ResponseBody
    public void deleteComment(Long id){

    }
}
