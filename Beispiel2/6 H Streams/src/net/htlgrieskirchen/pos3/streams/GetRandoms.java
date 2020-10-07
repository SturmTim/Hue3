/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.streams;

import java.util.Arrays;

/**
 *
 * @author timst
 */
public class GetRandoms {

    public int[] getRandomNumberArray(int anzahl, int min, int max) {
        return Arrays.stream(new int[anzahl])
                .map(number -> (int) (Math.random() * (max - min)) + min)
                .toArray();
    }

    public String[] getRandomStringArray(int anzahl, int length) {
        return Arrays.stream(new String[anzahl])
                .map(string -> generateRandomString(length))
                .toArray(String[]::new);
    }

    private String generateRandomString(int length) {
        String s = "";
        for (int i = 0; i < length; i++) {
            s += (char) ((int) (Math.random() * 26) + 26);
        }
        return s;
    }
}
