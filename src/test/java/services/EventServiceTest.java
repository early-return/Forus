package services;

import info.zhiqing.forus.models.Event;
import info.zhiqing.forus.services.EventService;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zhiqing on 17-8-22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config.xml")
public class EventServiceTest {

    @Autowired
    private EventService eventService;

    @Test
    public void testNewEvent() {
        Event event = new Event();
        event.setUserId(0);
        event.setMessage("Hello");
        event.setType(EventService.TYPE_SYSTEM);
        eventService.newEvent(event);
    }

    @Test
    public void testFindByUserId() {
        List<Event> result = eventService.findByUserId(7);
        Event event = result.get(0);
        assertEquals(event.getMessage(), "Hello");
    }
}
