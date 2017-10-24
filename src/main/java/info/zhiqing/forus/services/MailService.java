package info.zhiqing.forus.services;

import info.zhiqing.forus.utils.MailUtil;
import info.zhiqing.forus.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * Created by zhiqing on 17-9-5.
 */
@Component
public class MailService {

    private final String MAIL_SUBJECT_REGISTER = "欢迎注册！";
    private final String MAIL_SUBJECT_ACTIVATE = "请激活您的账户！";
    private final String MAIL_SUBJECT_RESET = "您正在请求重置您的账户密码！";

    private final String MAIL_TEMPLATE_REGISTER = "mail/register";
    private final String MAIL_TEMPLATE_ACTIVATE = "mail/active";
    private final String MAIL_TEMPLATE_RESET = "mail/RESET";


    private final MailUtil mailUtil;
    private final SpringTemplateEngine templateEngine;

    @Value("${forus.baseurl}")
    private String baseUrl;

    @Autowired
    public MailService(MailUtil mailUtil, SpringTemplateEngine templateEngine) {
        this.mailUtil = mailUtil;
        this.templateEngine = templateEngine;
    }

    public void sendRegisterMail(User user, String token) {
        Context context = new Context(LocaleContextHolder.getLocale());
        context.setVariable("username", user.getUsername());
        context.setVariable("token", token);
        context.setVariable("baseurl", baseUrl);

        String content = templateEngine.process(MAIL_TEMPLATE_REGISTER, context);

        try {
            mailUtil.sendHtml(user.getEmail(), MAIL_SUBJECT_REGISTER, content);
        } catch (Exception e) {
            System.out.println("Mail send failed!");
        }

    }
}
