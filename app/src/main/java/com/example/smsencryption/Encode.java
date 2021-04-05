package com.example.smsencryption;

public class Encode {

    String toBinary(int num) {
        int[] bin = new int[8];
        int i = 7;
        while (num > 0) {
            bin[i] = num % 2;
            num = num / 2;
            i--;
        }
        String binaryString="";
        for (i = 0; i < 8; i++) {
            binaryString = binaryString + bin[i];
        }
        return binaryString;
    }

    String enc(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int ascii = (int) s.charAt(i);
            res = res + toBinary(ascii);
        }
        return "101" + res + toBinary(s.length()); //prefix + original data binary + suffix
    }
}
