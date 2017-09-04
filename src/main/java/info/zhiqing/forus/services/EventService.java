package info.zhiqing.forus.services;

import info.zhiqing.forus.mappers.EventMapper;
import info.zhiqing.forus.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhiqing on 17-8-22.
 */
@Component
public class EventService {

    //事件类型常量定义
    public static final int TYPE_SYSTEM = 0;
    public static final int TYPE_NEW_FOLLOWER = 1;
    public static final int TYPE_AT_ME = 2;

    //事件是否已读常量定义
    public static final int HAVE_READ = 0;
    public static final int UNREAD = 1;

    private final EventMapper eventMapper;

    @Autowired
    public EventService(EventMapper eventMapper) {
        this.eventMapper = eventMapper;
    }

    public List<Event> findByUserId(long id) {
        List<Event> result = eventMapper.findByUserId();
        for(Event item : result) {
            markReaded(item);
        }
        return result;
    }

    public void newEvent(Event event) {
        event.setUnread(UNREAD);
        eventMapper.add(event);
    }

    public void markReaded(Event event) {
        event.setUnread(HAVE_READ);
        eventMapper.update(event);
    }
}
