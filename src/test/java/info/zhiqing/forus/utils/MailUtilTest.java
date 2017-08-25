package info.zhiqing.forus.utils;

import info.zhiqing.forus.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;

/**
 * Created by zhiqing on 17-8-25.
 */
public class MailUtilTest extends BaseTest {

    @Autowired
    MailUtil mailUtil;

    @Test
    public void testSendText() {
        try {
            mailUtil.sendText("lizhiqing1996@gmail.com", "send mail test", "this is a test");
        } catch (MessagingException e) {
            System.out.println("failed");
            e.printStackTrace();
        }
    }
}
