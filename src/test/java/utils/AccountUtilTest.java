package utils;

import info.zhiqing.forus.utils.AccountUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhiqing on 17-7-30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config.xml")
public class AccountUtilTest {

    @Test
    public void testBuildPass() {
        System.out.println(AccountUtil.buildPassword("lizhiqing"));
    }
}
