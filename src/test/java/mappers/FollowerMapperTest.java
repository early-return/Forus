package mappers;

import info.zhiqing.forus.mappers.FollowerMapper;
import info.zhiqing.forus.models.Follower;
import info.zhiqing.forus.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhiqing on 17-8-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config.xml")
public class FollowerMapperTest {

    @Autowired
    FollowerMapper followerMapper;

    @Test
    public void testAdd() {
        Follower follower = new Follower();
        follower.setUserId(12);
        follower.setFollowerId(7);
        int result = followerMapper.add(follower);
        assertEquals(result, 1);
    }

    @Test
    public void testFindUsersByUserId() {
        List<User> users = followerMapper.findUsersByUserId(12);
        assertTrue(users.size() > 0);
    }

    @Test
    public void testFindUsersByFollowerId() {
        List<User> users = followerMapper.findUsersByFollowerId(7);
        assertTrue(users.size() > 0);
    }

    @Test
    public void testDelete() {
        Follower follower = new Follower();
        follower.setUserId(12);
        follower.setFollowerId(7);
        int result = followerMapper.delete(follower);
        assertEquals(result, 1);
    }

}
