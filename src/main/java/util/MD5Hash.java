package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hash {
    public static String hash(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(password.getBytes());
        byte[] resultByteArray = messageDigest.digest();

        StringBuilder sb = new StringBuilder();

        for(byte b : resultByteArray){
            sb.append(String.format("%02x",b));
        }

        return sb.toString();
    }
}
