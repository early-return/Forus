package info.zhiqing.forus.services;

import info.zhiqing.forus.BaseTest;
import info.zhiqing.forus.exceptions.TokenNotMatchException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhiqing on 17-9-4.
 */
public class RedisServiceTest extends BaseTest {

    @Autowired
    private RedisService redisService;

    private String token = "";
    private String username = "lizhiqing";

    @Test
    public void testUpdateToken() {
        token = redisService.updateToken(username, RedisService.TYPE_ACTIVE);
        System.out.println(token);
    }

    @Test
    public void testCheckToken() throws TokenNotMatchException {
        System.out.println(token);
        redisService.checkToken(username, RedisService.TYPE_ACTIVE, token);
    }
}
