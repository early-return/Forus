package info.zhiqing.forus.mappers;

import info.zhiqing.forus.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by zhiqing on 17-7-30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testAdd() {
        User user = new User();
        user.setUsername("lizhiqing");
        user.setNickname("Zhiqing");
        user.setPassword("lizhiqing");
        user.setEmail("i@zhiqing.info");
        user.setJoinTime(new Date());
        user.setAvatar("avatar");
        System.out.println(userMapper.add(user));
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(3);
        user.setNickname("New Nickname");
        user.setAvatar("new avatar");
        user.setBio("This is bio");
        userMapper.update(user);
    }

    @Test
    public void testDelete() {
        User user = new User();
        user.setId(3);
        userMapper.delete(user);
    }

    @Test
    public void testGetById() {
        User user = userMapper.findById(3);
        System.out.println(user.getUsername());
    }

    @Test
    public void testGetByUsername() {
        User user = userMapper.findByUsername("lizhiqing");
        System.out.println(user.getId());
    }

}
