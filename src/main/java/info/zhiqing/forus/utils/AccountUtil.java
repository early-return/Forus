package info.zhiqing.forus.utils;

import org.springframework.stereotype.Component;

/**
 * Created by zhiqing on 17-7-30.
 */
@Component
public class AccountUtil {

    public static String randomAvatar() {
        long l = System.currentTimeMillis();
        int n = (int) (l % 16) + 1;
        return "/img/avatar/" + n + ".png";
    }

    public static String buildPassword(String pass) {
        return CommonUtil.getMD5("Forus" + pass + Config.PASSWORD_SALT);
    }

}
