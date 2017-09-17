package info.zhiqing.forus.controllers;

import info.zhiqing.forus.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;

/**
 * Created by zhiqing on 17-9-17.
 */
@Controller
public class CaptchaController {

    private final CaptchaUtil captchaUtil;

    @Autowired
    public CaptchaController(CaptchaUtil captchaUtil) {
        this.captchaUtil = captchaUtil;
    }

    @RequestMapping("/captcha")
    public void captcha(HttpServletResponse response, HttpSession session) {
        OutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (Exception ignored) {}

        String code = captchaUtil.randomAndDrawCaptcha(out);

        session.setAttribute(captchaUtil.SESSION_KEY, code);
    }
}
