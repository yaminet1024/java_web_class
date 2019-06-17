package cn.yaminets.java_web_class.service;

import cn.yaminets.java_web_class.dto.Comment;
import cn.yaminets.java_web_class.dto.Result;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {
    Result addComment(long userId, String title,String content,long goodsId);
    Result deleteComment(long id);
    List<Comment> getComments(long goodsId);
}
