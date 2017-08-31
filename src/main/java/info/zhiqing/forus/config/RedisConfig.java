package info.zhiqing.forus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * Created by zhiqing on 17-8-25.
 */
@Configuration
public class RedisConfig {

    @Value("${redis.host}")
    private String host;

    @Bean
    public Jedis jedis() {
        return new Jedis(host);
    }
}
