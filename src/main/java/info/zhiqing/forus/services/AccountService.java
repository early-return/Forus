package info.zhiqing.forus.services;

import info.zhiqing.forus.mappers.UserMapper;
import info.zhiqing.forus.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhiqing on 17-7-30.
 */
@Component
public class AccountService {
    public static final int ROLE_GUEST = 0;
    public static final int ROLE_MEMBER = 1;
    public static final int ROLE_ADMIN = 2;
    public static final int ROLE_SUPER = 3;

    public static final int STATUS_NORMAL = 0;
    public static final int STATUS_INACTIVATED = 1;
    public static final int STATUS_BAN_PUBLISH = 2;
    public static final int STATUS_BAN_COMMENT = 3;
    public static final int STATUS_BAN_LOGIN = 4;

    @Autowired
    UserMapper userMapper;

    public boolean register(User user) {

        return true;
    }

}
