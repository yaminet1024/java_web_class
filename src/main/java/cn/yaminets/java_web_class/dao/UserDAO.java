package cn.yaminets.java_web_class.dao;


import cn.yaminets.java_web_class.dto.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Mapper
@Component
public interface UserDAO {

    @Select("select * from user where id = #{id}")
    public User getUserById(@Param("id") long id);

    @Update("update user set login_count = login_count +1 where id = #{id}")
    public int incLoginCount(@Param("id") long id);

    @Update("update user set last_login_date = #{date} where id = #{id}")
    public int setLastLoginDate(@Param("id") long id, @Param("date") Date date);

    @Insert("insert into user values(#{id},#{nickName},#{password},#{headPic},#{registerDate},#{lastLoginDate},#{userSex},#{address})")
    public int insertUser(User user);

}
