/**
 * AuthUtils.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date May 14, 2013 6:20:40 PM
 */
package com.joydeal.utils;

import com.joydeal.base.Constants;
import com.joydeal.security.Encrypter;
import com.joydeal.thrift.User;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

/**
 * @author leo
 */
public class AuthUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthUtils.class);
    private static Random random = new SecureRandom();

    /**
     * @return
     * @throws DecoderException
     */
    public static String generateRandomAESKey() {
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        String aesKey = Encrypter.encryptBASE64(bytes);
        Arrays.fill(bytes, (byte) 0);
        return aesKey;
    }

    /**
     * @param user
     * @param userIp
     * @return
     * @throws SecurityException
     */
    public static User genPasstoken(User user, String userIp) throws SecurityException {
        String sessionCode = AuthUtils.generateRandomAESKey();
        JSONObject json = new JSONObject();
        json.put("p", user.password);
        json.put("ip", userIp);
        json.put("u", user.id);
        json.put("a", user.account);
        json.put("n", user.name);
        json.put("s", sessionCode);
        json.put("t", System.currentTimeMillis() + "");
        json.put("v", "1.0");
        String token = Encrypter.encryptAES(json.toString());
        return user.setPasstoken(token);
    }

    /**
     * @param token
     * @return
     * @throws SecurityException
     */
    public static User decryptPasstoken(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        JSONObject j = null;
        try {
            j = JSONObject.fromObject(Encrypter.decryptAES(token));
            return new User().setPasstoken(token).setId(j.getLong("u")).setAccount(j.getString("a"))
                    .setPassword(j.getString("p")).setName(j.getString("n"));
        } catch (JSONException ex) {
            LOGGER.warn("Passtoken " + token + " decrypt fail", ex);
            return null;
        }
    }

    /**
     * @param data
     * @return
     */
    private static String sha1HMAC(String data) throws SecurityException {
        try {
            return Encrypter.encryptBASE64(Encrypter.encryptHMAC(data.getBytes("UTF-8"),
                    Constants.SECURITY_KEY));
        } catch (Exception e) {
            // InvalidKeyException UnsupportedEncodingException NoSuchAlgorithmException
            throw new SecurityException(e);
        }
    }

}
