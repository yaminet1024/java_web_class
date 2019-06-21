package cn.yaminets.java_web_class.service.impl;

import cn.yaminets.java_web_class.dao.CommentDAO;
import cn.yaminets.java_web_class.dao.UserDAO;
import cn.yaminets.java_web_class.dto.Comment;
import cn.yaminets.java_web_class.dto.CommentVo;
import cn.yaminets.java_web_class.dto.Result;
import cn.yaminets.java_web_class.dto.User;
import cn.yaminets.java_web_class.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private UserDAO userDAO;
    @Override
    public Result addComment(long userId, String title, String content, long goodsId) {
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setTitle(title);
        comment.setContent(content);
        comment.setGoodsId(goodsId);
        commentDAO.insertComment(comment);
        return Result.success(comment);
    }

    @Override
    public Result deleteComment(long id) {
        commentDAO.deleteComment(id);
        return null;
    }

    @Override
    public Result<PageInfo> getComments(long goodsId, int pageNum, int pageSize,String orderBy) {
        PageHelper.startPage(pageNum, pageSize, orderBy);
        List<Comment> commentList =  commentDAO.selectComments(goodsId);
        List<CommentVo> commentVoList = new ArrayList<CommentVo>();
        PageInfo pageResult = new PageInfo(commentList);
        for (Comment comment : commentList){
            CommentVo commentVo = toCommentVo(comment);
            commentVoList.add(commentVo);
        }
        pageResult.setList(commentVoList);
        return Result.success(pageResult);
    }

    private CommentVo toCommentVo( Comment comment){
        CommentVo commentVo = new CommentVo();
        User user = userDAO.getUserById(comment.getUserId());
        commentVo.setUserName(user.getNickName());
        commentVo.setTitle(comment.getTitle());
        commentVo.setContent(comment.getContent());
        commentVo.setCreateDate(comment.getCreateDate());
        return commentVo;
    }

}
