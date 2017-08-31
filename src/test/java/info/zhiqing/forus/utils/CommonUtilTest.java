package info.zhiqing.forus.utils;

import info.zhiqing.forus.BaseTest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhiqing on 17-7-30.
 */
public class CommonUtilTest extends BaseTest {

    @Autowired
    private CommonUtil commonUtil;

    @Test
    public void testMD5() {
        assertEquals(commonUtil.getMD5("lizhiqing"), "f57b888bc53ccfa3e4a71f19604df23c");
    }
}
