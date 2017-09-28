package info.zhiqing.forus.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by zhiqing on 17-7-30.
 */
@Component
public class AccountUtil {

    private final CommonUtil commonUtil;

    @Value("${forus.salt}")
    private String PASSWORD_SALT;

    @Autowired
    public AccountUtil(CommonUtil commonUtil) {
        this.commonUtil = commonUtil;
    }

    public String randomAvatar() {
        long l = System.currentTimeMillis();
        int n = (int) (l % 16) + 1;
        return "/static/img/avatar/" + n + ".png";
    }

    public String buildPassword(String pass) {
        return commonUtil.getMD5("Forus" + pass + PASSWORD_SALT);
    }

    public String buildToken(String username) {
        return commonUtil.getMD5("Forus" + username + System.currentTimeMillis());
    }

}
