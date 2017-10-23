package info.zhiqing.forus.api;


import info.zhiqing.forus.exceptions.*;
import info.zhiqing.forus.json.LoginRequest;
import info.zhiqing.forus.json.RegisterRequest;
import info.zhiqing.forus.json.Response;
import info.zhiqing.forus.models.User;
import info.zhiqing.forus.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    public static final String SESSION_LOGGED_USER = "loggedUser";

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/check_username/{username}", method = RequestMethod.GET)
    public Response<Void> checkUsername(@PathVariable String username) {
        Response<Void> resp = new Response<>();
        resp.setStatus(Response.STATUS_OK);

        try {
            accountService.checkUsername(username);
        } catch (UsernameExistedException e) {
            resp.setStatus(Response.STATUS_ACCOUNT_USERNAME_EXISTED);
            resp.setMessage("用户名已存在！");
            e.printStackTrace();
        }

        return resp;
    }

    @RequestMapping(value = "/check_email/{email}", method = RequestMethod.GET)
    public Response<Void> checkEmail(@PathVariable String email) {
        Response<Void> resp = new Response<>();
        resp.setStatus(Response.STATUS_OK);

        try {
            accountService.checkEmail(email);
        } catch (EmailExistedException e) {
            resp.setStatus(Response.STATUS_ACCOUNT_EMAIL_EXISTED);
            resp.setMessage("该邮箱已经注册过了！");
            e.printStackTrace();
        }

        return resp;
    }

    //注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response<Void> register(@RequestBody RegisterRequest req) {
        Response<Void> resp = new Response<>();
        resp.setStatus(Response.STATUS_OK);

        User user = new User();
        user.setNickname(req.getNickname());
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());

        System.out.println(user.getNickname());
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());

        try {
            accountService.register(user);
        } catch (UsernameExistedException e) {
            resp.setStatus(Response.STATUS_ACCOUNT_USERNAME_EXISTED);
            resp.setMessage("用户名已存在!");
            e.printStackTrace();
        } catch (RegisterFailedException e) {
            resp.setStatus(Response.STATUS_ACCOUNT_FAILED);
            resp.setMessage("注册失败！");
            e.printStackTrace();
        } catch (EmailExistedException e) {
            resp.setStatus(Response.STATUS_ACCOUNT_EMAIL_EXISTED);
            resp.setMessage("该邮箱已经注册过了！");
            e.printStackTrace();
        }

        return resp;
    }

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response<User> login(@RequestBody LoginRequest req, HttpSession session) {
        Response<User> resp = new Response<>();
        resp.setStatus(Response.STATUS_OK);

        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword());

        User respUser = null;

        try {
            respUser = accountService.login(user);
            session.setAttribute(SESSION_LOGGED_USER, respUser);
        } catch (UserNotFoundException e) {
            resp.setStatus(Response.STATUS_ACCOUNT_USERNAME_NOT_EXIST);
            resp.setMessage("没有找到该用户哦！");
            e.printStackTrace();
        } catch (PasswordErrorException e) {
            resp.setStatus(Response.STATUS_ACCOUNT_PASSWORD_ERROR);
            resp.setMessage("密码不正确!");
            e.printStackTrace();
        }

        resp.setBody(respUser);

        return  resp;
    }

    @RequestMapping(value = "/logged", method = RequestMethod.GET)
    public Response<User> logged(HttpSession session) {
        Response<User> resp = new Response<>();
        resp.setStatus(Response.STATUS_OK);

        User user = (User) session.getAttribute(SESSION_LOGGED_USER);

        resp.setBody(user);
        return resp;
    }
}
