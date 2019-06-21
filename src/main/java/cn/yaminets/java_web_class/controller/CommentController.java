package cn.yaminets.java_web_class.controller;

import cn.yaminets.java_web_class.dto.Result;
import cn.yaminets.java_web_class.enums.CodeMessage;
import cn.yaminets.java_web_class.service.CommentService;
import cn.yaminets.java_web_class.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/add_comment", method = RequestMethod.POST)
    @ResponseBody
    public Result addComment(HttpServletRequest request, @RequestParam long userId, @RequestParam String title, @RequestParam String content, @RequestParam long goodsId) {
        String loginToken = userService.getToken(request);
        if (userService.isLogin(loginToken)) {
            return commentService.addComment(userId, title, content, goodsId);
        } else {
            return Result.error(CodeMessage.NOT_USER_LOGIN);
        }
    }

    @RequestMapping(value = "/delete_comment", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteComment(HttpServletRequest request, long id) {
        String loginToken = userService.getToken(request);
        if (userService.isLogin(loginToken)) {
            return commentService.deleteComment(id);
        } else {
            return Result.error(CodeMessage.NOT_USER_LOGIN);
        }
    }

    @RequestMapping(value = "/get_comments",method = RequestMethod.GET)
    @ResponseBody
    public Result getComments(@RequestParam long goodsId,@RequestParam int pageNum,@RequestParam int pageSize, @RequestParam String orderBy) {
        return commentService.getComments(goodsId,pageNum,pageSize,orderBy);
    }
}
