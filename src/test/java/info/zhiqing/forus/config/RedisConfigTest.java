package info.zhiqing.forus.config;

import info.zhiqing.forus.BaseTest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

/**
 * Created by zhiqing on 17-8-25.
 */
public class RedisConfigTest extends BaseTest {

    @Autowired
    private Jedis jedis;

    @Test
    public void test() {
        jedis.set("hello", "world");
        assertEquals("world", jedis.get("hello"));
    }
}
