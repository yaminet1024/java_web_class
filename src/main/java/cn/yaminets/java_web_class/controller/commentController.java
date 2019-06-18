package cn.yaminets.java_web_class.controller;

import cn.yaminets.java_web_class.dto.Comment;
import cn.yaminets.java_web_class.dto.Result;
import cn.yaminets.java_web_class.enums.CodeMessage;
import cn.yaminets.java_web_class.service.CommentService;
import cn.yaminets.java_web_class.service.UserService;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 评论id
 * 评论标题
 * 评论内容
 * 商品id
 * 评论时间
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentController {
//    Logger logger = (Logger) LoggerFactory.getLogger(CommentController.class);
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @RequestMapping("/add_comment")
    @ResponseBody
    public Result addComment(long userId, String title, String content, long goodsId) {
//        if (userService.isLogin(userId)) {
////            logger.info("执行添加");
//            System.out.println("执行添加");
            return commentService.addComment(userId, title, content, goodsId);
//        } else {
////            logger.info("用户未登录");
//            System.out.println("用户未登录");
//            return Result.error(CodeMessage.NOT_USER_LOGIN);
//        }
    }

    @RequestMapping("/delete_comment")
    @ResponseBody
    public Result deleteComment(long userId, long id) {
//        if (userService.isLogin(userId)) {
////            logger.info("执行添加");
//            System.out.println("执行删除");
        return commentService.deleteComment(id);
//        } else {
////            logger.info("用户未登录");
//            System.out.println("用户未登录");
//            return Result.error(CodeMessage.NOT_USER_LOGIN);
//        }
    }

    @RequestMapping("/get_comments")
    @ResponseBody
    public List<Comment> getComments(long goodsId) {
        //        if (userService.isLogin(userId)) {
////            logger.info("执行添加");
//            System.out.println("执行添加");
        return commentService.getComments(goodsId);
//        } else {
////            logger.info("用户未登录");
//            System.out.println("用户未登录");
//            return Result.error(CodeMessage.NOT_USER_LOGIN);
//        }
    }
}
