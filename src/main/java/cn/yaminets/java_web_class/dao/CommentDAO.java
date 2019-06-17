package cn.yaminets.java_web_class.dao;

import cn.yaminets.java_web_class.dto.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface CommentDAO {
    @Insert("insert into comment(user_id,content,title,goods_id,create_date) " +
            "value(#{userId},#{content},#{title},#{goodsId},now())")
    int insertComment(Comment comment);

    @Update("update comment set status = 0 where id = #{id}")
    int deleteComment(long id);

    @Select("select * from comment where goods_id = #{goodsId}")
    List<Comment> selectComments(long goodsId);
}
