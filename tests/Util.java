package tests;

import java.security.SecureRandom;
import java.util.Random;

public class Util {
    
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM_STRING = new SecureRandom();
    private static final Random RANDOM_DOUBLE = new Random();

    @SuppressWarnings("unused")
    static String genRandomString() {
        
        int length = 10;
        StringBuilder sb = new StringBuilder(length);
       
        for (int i = 0; i < length; i++) {
            int randomIndex = RANDOM_STRING.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }

    @SuppressWarnings("unused")
    static double genRandomDouble() {
        
        double min = 1.0;
        double max = 10.0;
        
        return min + (max - min) * RANDOM_DOUBLE.nextDouble();    
    }
}