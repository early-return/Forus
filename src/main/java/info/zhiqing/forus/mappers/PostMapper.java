package info.zhiqing.forus.mappers;

import info.zhiqing.forus.models.Post;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by zhiqing on 17-7-30.
 */
public interface PostMapper {

    @Insert("INSERT INTO posts(author_id, title, content, view_role, pub_time, comment_status, belong_to)" +
            "VALUES(#{authorId}, #{title}, #{content}, #{viewRole}, #{pubTime}, #{commentStatus}, #{belongTo})"
    )
    int add(Post post);

    @Delete("DELETE FROM posts WHERE id=#{id}")
    int delete(Post post);

    @Update("UPDATE posts SET title=#{title}, content=#{content}, view_role=#{viewRole}, " +
            "comment_status=#{commentStatus}, belong_to=#{belongTo} WHERE id=#{id}")
    int update(Post post);

    @Update("UPDATE posts SET belong_to=#{arg1} WHERE belong_to=#{arg0}")
    int transferSection(long oldId, long newId);

    @Select("SELECT * FROM posts WHERE id=#{id}")
    Post findById(long id);

    @Select("SELECT * FROM posts WHERE belong_to=#{arg0} LIMIT #{arg1},#{arg2}")
    List<Post> findBySectionId(long id, int limitStart, int limitNum);

    @Select("SELECT * FROM posts WHERE title LIKE CONCAT('%',#{arg0},'%') LIMIT #{arg1}, #{arg2}")
    List<Post> findByKey(String key, int limitStart, int limitNum);
}
