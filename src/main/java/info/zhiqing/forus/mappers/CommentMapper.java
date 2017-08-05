package info.zhiqing.forus.mappers;

import info.zhiqing.forus.models.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zhiqing on 17-8-5.
 */
public interface CommentMapper {

    @Insert("INSERT INTO comments(post_id, author_id, at_id, content, pub_time) " +
            "VALUES(#{postId}, #{authorId}, #{atId}, #{content}, #{pubTime}")
    int add(Comment comment);

    @Delete("DELETE FROM comments WHERE id=#{id}")
    int delete(Comment comment);

    @Select("SELECT * FROM comments WHERE post_id=#{arg0}")
    List<Comment> findByPostId(long postId);
}
