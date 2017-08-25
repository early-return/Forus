package info.zhiqing.forus.utils;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * Created by zhiqing on 17-8-25.
 */
@Component
public class MailUtil {

    private static final String TYPE_TEXT = "text/plain";
    private static final String TYPE_HTML = "text/html";

    @Value("${mail.host}")
    private String host;

    @Value("${mail.port}")
    private String port;

    @Value("${mail.ssl}")
    private boolean ssl;

    @Value("${mail.address}")
    private String address;

    @Value("${mail.username}")
    private String username;

    @Value("${mail.password}")
    private String password;

    //如果用户名为空则用户名为邮箱地址
    private String getUsername() {
        return username != null && !username.equals("") ? username : address;
    }

    private void send(String to, String subject, String content, String mime) throws MessagingException {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");

        if (ssl) {
            try {
                MailSSLSocketFactory socketFactory = new MailSSLSocketFactory();
                socketFactory.setTrustAllHosts(true);
                properties.put("mail.smtp.ssl.enable", "true");
                properties.put("mail.smtp.ssl.socketFactory", socketFactory);
            } catch (GeneralSecurityException e) {
                throw new MessagingException("SSL Exception");
            }
        }

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(getUsername(), password);
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(address));

        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);

        message.setContent(content, mime);
        Transport.send(message);
    }

    public void sendText(String to, String subject, String content) throws MessagingException {
        send(to, subject, content, TYPE_TEXT);
    }

    public void sendHtml(String to, String subject, String content) throws MessagingException {
        send(to, subject, content, TYPE_HTML);
    }
}
