package info.zhiqing.forus.controllers;

import info.zhiqing.forus.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.util.Date;

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

    @ResponseBody
    @RequestMapping("/captcha")
    public void captcha(HttpServletResponse response, HttpSession session) {
        OutputStream out = null;
        response.setContentType("image/jpg");
        try {
            out = response.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String code = captchaUtil.randomAndDrawCaptcha(out);

        session.setAttribute(captchaUtil.SESSION_KEY, code);
    }
}
