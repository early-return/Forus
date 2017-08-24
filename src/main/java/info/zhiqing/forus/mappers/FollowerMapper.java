package info.zhiqing.forus.mappers;

import info.zhiqing.forus.models.Follower;
import info.zhiqing.forus.models.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zhiqing on 17-8-24.
 */
public interface FollowerMapper {

    @Insert("INSERT INTO `followers` (`user_id`, `follower_id`) VALUES (#{userId}, #{followerId});")
    int add(Follower follower);

    @Delete("DELETE FROM followers WHERE user_id=#{userId} AND follower_id=#{followerId};")
    int delete(Follower follower);

    @Select("SELECT users.id, users.username, users.nickname, users.password, " +
            "users.email, users.join_time, users.status, users.avatar, users.bio, users.role " +
            "FROM users " +
            "LEFT JOIN followers " +
            "ON users.id = followers.user_id " +
            "WHERE followers.follower_id = #{arg0};")
    List<User> findUsersByFollowerId(long followerId);

    @Select("SELECT users.id, users.username, users.nickname, users.password, " +
            "users.email, users.join_time, users.status, users.avatar, users.bio, users.role " +
            "FROM users " +
            "LEFT JOIN followers " +
            "ON users.id = followers.follower_id " +
            "WHERE followers.user_id = #{arg0};")
    List<User> findUsersByUserId(long userId);
}
