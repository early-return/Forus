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
    //用户角色常量定义
    public static final int ROLE_GUEST = 0; //游客
    public static final int ROLE_MEMBER = 1; //成员
    public static final int ROLE_ADMIN = 2; //管理员
    public static final int ROLE_SUPER = 3; //超级管理员

    //账户状态常量定义
    public static final int STATUS_NORMAL = 0; //正常
    public static final int STATUS_INACTIVATED = 1; //未激活
    public static final int STATUS_BAN_PUBLISH = 2; //禁止发帖
    public static final int STATUS_BAN_COMMENT = 3; //禁止评论
    public static final int STATUS_BAN_LOGIN = 4; //禁止登录

    private final UserMapper userMapper;

    private final AccountUtil accountUtil;
    private final RedisService redisService;
    private final MailService mailService;

    @Autowired
    public AccountService(UserMapper userMapper, AccountUtil accountUtil,
                          RedisService redisService, MailService mailService) {
        this.userMapper = userMapper;
        this.accountUtil = accountUtil;
        this.redisService = redisService;
        this.mailService = mailService;
    }

    //检查用户名是否已存在
    private void checkUsername(String name) throws UsernameExistedException {
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
        String token = redisService.updateToken(user.getUsername(), RedisService.TYPE_ACTIVE);

        mailService.sendRegisterMail(user, token);
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

    public void updatePassword(String username, String password) {
        String pass = accountUtil.buildPassword(password);
        userMapper.updatePassword(username, pass);
    }

    public void updateStatus(String username, int status) {
        userMapper.updateStatus(username, status);
    }

}
