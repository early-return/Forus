package info.zhiqing.forus.services;

import info.zhiqing.forus.BaseTest;
import info.zhiqing.forus.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhiqing on 17-7-30.
 */
public class AccountServiceTest extends BaseTest {
    @Autowired
    AccountService accountService;

    @Test
    public void testRegister() {
        User user = new User();
        user.setUsername("lizhiqing");
        user.setNickname("Nickname");
        user.setEmail("i@zhiqing.info");
        user.setPassword("lizhiqing");
        try {
            accountService.register(user);
            System.out.println("OK!");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Existed!");
        }
        user.setUsername("lizhiqing" + System.currentTimeMillis());
        try {
            accountService.register(user);
            System.out.println("OK!");
        } catch (Exception e) {

        }
    }

    @Test
    public void testException() {
        try {
            accountService.login(new User());
            System.out.println("hello");
        } catch (Exception e) {
            System.out.println("world");
        }
    }

    @Test
    public void testLogin() {
        User user = new User();
        user.setUsername("lizhiqing");
        user.setPassword("lizhiqing");
        try {
            accountService.login(user);
            System.out.println("OK!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
