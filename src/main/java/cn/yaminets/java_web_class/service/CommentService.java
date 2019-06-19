package cn.yaminets.java_web_class.service;

import cn.yaminets.java_web_class.dto.Comment;
import cn.yaminets.java_web_class.dto.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {
    Result addComment(long userId, String title,String content,long goodsId);
    Result deleteComment(long id);
    Result<PageInfo> getComments(long goodsId,int pageNum, int pageSize, String orderBy);
}
