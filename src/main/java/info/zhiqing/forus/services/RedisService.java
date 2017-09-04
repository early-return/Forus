package info.zhiqing.forus.services;

import info.zhiqing.forus.exceptions.TokenNotMatchException;
import info.zhiqing.forus.utils.AccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * Created by zhiqing on 17-9-4.
 */
@Component
public class RedisService {
    @Value("${forus.redis.prefix.active}")
    public String KEY_PREFIX_ACTIVE;
    @Value("${forus.redis.prefix.reset}")
    public String KEY_PREFIX_RESET;

    @Value("${forus.redis.lifecycle.active}")
    public int LIFECYCLE_ACTIVE;
    @Value("${forus.redis.lifecycle.reset}")
    public int LIFECYCLE_RESET;

    public static final int TYPE_ACTIVE = 1;
    public static final int TYPE_RESET = 2;

    private final Jedis jedis;

    private final AccountUtil accountUtil;

    @Autowired
    public RedisService(Jedis jedis, AccountUtil accountUtil) {
        this.jedis = jedis;
        this.accountUtil = accountUtil;
    }

    public String updateToken(String username, int type) {
        String token = accountUtil.buildToken(username);
        String key = getKey(username, type);
        int lifecycle = getLifecycle(type);
        System.out.println(key + ": " + lifecycle);
        jedis.set(key, token);
        jedis.expire(key, lifecycle);
        return token;
    }

    public void checkToken(String username, int type, String token) throws TokenNotMatchException {
        String key = getKey(username, type);
        String t = jedis.get(key);
        if(!token.equals(t)) {
            throw new TokenNotMatchException();
        }
    }

    private String getKey(String username, int type) {
        if (type == TYPE_ACTIVE) {
            return KEY_PREFIX_ACTIVE + username;
        } else if (type == TYPE_RESET) {
            return KEY_PREFIX_RESET + username;
        } else {
            return "";
        }
    }

    private int getLifecycle(int type) {
        if (type == TYPE_ACTIVE) {
            return LIFECYCLE_ACTIVE;
        } else if (type == TYPE_RESET) {
            return LIFECYCLE_RESET;
        } else {
            return 0;
        }
    }

}
