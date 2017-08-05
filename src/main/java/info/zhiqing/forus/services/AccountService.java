package info.zhiqing.forus.services;

import info.zhiqing.forus.exceptions.PasswordErrorException;
import info.zhiqing.forus.exceptions.RegisterFailedException;
import info.zhiqing.forus.exceptions.UserNotFoundException;
import info.zhiqing.forus.exceptions.UsernameExistedException;
import info.zhiqing.forus.mappers.UserMapper;
import info.zhiqing.forus.models.User;
import info.zhiqing.forus.utils.AccountUtil;
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

    @Autowired
    AccountUtil accountUtil;

    public void checkUsername(String name) throws UsernameExistedException {
        User u = userMapper.findByUsername(name);
        if(u != null) {
            throw new UsernameExistedException();
        }
    }

    public void register(User user) throws UsernameExistedException, RegisterFailedException {
        checkUsername(user.getUsername());
        user.setAvatar(accountUtil.randomAvatar());
        user.setPassword(accountUtil.buildPassword(user.getPassword()));
        if(userMapper.add(user) < 1) {
            throw new RegisterFailedException();
        }
    }

    public void login(User user) throws PasswordErrorException, UserNotFoundException {
        User u = userMapper.findByUsername(user.getUsername());
        if(u == null || u.getUsername().equals("")) {
            throw new UserNotFoundException();
        }

        String password = accountUtil.buildPassword(user.getPassword());
        if(!password.equals(u.getPassword())) {
            throw new PasswordErrorException();
        }

    }

}
