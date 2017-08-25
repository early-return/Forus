package info.zhiqing.forus.mappers;

import info.zhiqing.forus.models.Post;
import info.zhiqing.forus.models.Star;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zhiqing on 17-8-24.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config.xml")
public class StarMapperTest {

    @Autowired
    StarMapper starMapper;

    @Test
    public void testAdd() {
        Star star = new Star();
        star.setPostId(1);
        star.setUserId(12);
        int result = starMapper.add(star);
        assertEquals(result, 1);
    }

    @Test
    public void testFindPostsByUserId() {
        List<Post> posts = starMapper.findPostsByUserId(12);
        assertTrue(posts.size() > 1);
        assertEquals(posts.get(0).getTitle(), "Hello");
    }
}

