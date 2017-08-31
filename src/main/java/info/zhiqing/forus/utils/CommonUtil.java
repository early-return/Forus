package info.zhiqing.forus.utils;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;

/**
 * Created by zhiqing on 17-7-30.
 */
@Component
public class CommonUtil {

    public String getMD5(String str) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes();
            md.update(bytes);
            byte[] resultBytes = md.digest();
            StringBuilder builder = new StringBuilder();
            for(byte cipher : resultBytes) {
                String toHexStr = Integer.toHexString(cipher & 0xff);
                builder.append(toHexStr.length() == 1 ? "0" + toHexStr : toHexStr);
            }
            return builder.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
