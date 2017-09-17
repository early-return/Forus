package info.zhiqing.forus.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

/**
 * Created by zhiqing on 17-9-17.
 */
@Component
public class CaptchaUtil {

    @Value("${forus.captcha.width}")
    private int width;

    @Value("${forus.captcha.height}")
    private int height;

    @Value("${forus.captcha.size}")
    private int fontSize;

    private final String chars = "23456789abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRST";

    public final String SESSION_KEY = "captcha";

    private String randomCode() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int index = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    private void draw(String code, OutputStream out) {

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

        Graphics graphics = bi.getGraphics();

        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, width, height);

        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font("Sans-serif", Font.BOLD, fontSize));

        int x = ((width / 4) - fontSize) / 2;
        int y = (height - fontSize) / 2 + fontSize;

        for (int i = 0; i < 4; i++) {
            graphics.drawString(code.substring(i, i +1), x, y);
            x += width / 4;
        }

        try {
            ImageIO.write(bi, "JPG", out);
        } catch (Exception ignored) {

        }

    }

    public String randomAndDrawCaptcha(OutputStream out) {
        String code = randomCode();
        draw(code, out);
        return code;
    }
}
