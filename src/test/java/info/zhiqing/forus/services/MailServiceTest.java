package info.zhiqing.forus.services;

import info.zhiqing.forus.models.User;
import info.zhiqing.forus.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhiqing on 17-9-5.
 */
public class MailServiceTest extends BaseTest {

    @Autowired
    MailService mailService;

    @Test
    public void testSendRegisterMail() {
        User user = new User();
        user.setNickname("Zhiqing");
        user.setEmail("lizhiqing1996@gmail.com");

        mailService.sendRegisterMail(user, "hello");
    }
}
