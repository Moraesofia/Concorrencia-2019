package br.com.moraesofia.senha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utilitario {

    public static byte[] md5(byte[] senha) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] sen = md.digest(senha);
        return sen;
    }

    public static String shuffleString(String string, Random rnd) {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters, rnd);
        String shuffled = "";
        for (String letter : letters) {
            shuffled += letter;
        }
        return shuffled;
    }

}
