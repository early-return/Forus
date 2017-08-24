package info.zhiqing.forus.mappers;

import info.zhiqing.forus.models.Event;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by zhiqing on 17-8-22.
 */
public interface EventMapper {

    @Insert("INSERT INTO events (`user_id`, `type`, `message`, `related_id`, `unread`) " +
            "VALUES (#{userId}, #{type}, #{message}, #{relatedId}, #{unread});")
    int add(Event event);

    @Update("UPDATE events SET unread=#{unread} WHERE id=#{id};")
    int update(Event event);

    @Select("SELECT * FROM events WHERE user_id=#{arg0} OR user_id=0;")
    List<Event> findByUserId();

}
