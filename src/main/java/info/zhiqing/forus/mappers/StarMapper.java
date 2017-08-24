package info.zhiqing.forus.mappers;

import info.zhiqing.forus.models.Post;
import info.zhiqing.forus.models.Star;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zhiqing on 17-8-24.
 */
public interface StarMapper {

    @Insert("INSERT INTO `stars` (`user_id`, `post_id`) VALUES (#{userId}, #{postId});")
    int add(Star star);

    @Select("SELECT posts.id, posts.author_id, posts.title, posts.content, posts.view_role, posts.pub_time, " +
            "posts.comment_status, comment_count, posts.star_count, posts.belong_to FROM posts " +
            "LEFT JOIN stars " +
            "ON posts.id = stars.post_id " +
            "WHERE stars.user_id=#{arg0};")
    List<Post> findPostsByUserId(long userId);

    @Delete("DELETE FROM stars WHERE id=#{arg0};")
    int deleteById(long id);

    @Delete("DELETE FROm stars WHERE user_id=#{arg0};")
    int deleteByUserId(long userId);

}
