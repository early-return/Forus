package info.zhiqing.forus.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by zhiqing on 17-7-30.
 */
public class Config {

    @Value("${forus.salt}")
    public static String PASSWORD_SALT;
}
