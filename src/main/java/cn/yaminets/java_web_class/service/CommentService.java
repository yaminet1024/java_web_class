package cn.yaminets.java_web_class.service;

import cn.yaminets.java_web_class.dto.Result;

public interface CommentService {
    Result addComment(Long id,String title,String content,String productId);
    Result deleteComment(Long id);
}
