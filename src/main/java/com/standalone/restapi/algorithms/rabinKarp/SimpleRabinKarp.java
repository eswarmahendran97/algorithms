package com.standalone.restapi.algorithms.rabinKarp;

public class SimpleRabinKarp {

    //some random value
    static int d = 10;

    public static void main(String[] args) {
        String txt = "ABCCDDAEFG";
        String pattern = "CDD";
        searchPattern(txt, pattern);
    }

    private static void searchPattern(String txt, String pattern) {

        int t = 0, p = 0;
        int h = 1;

        //calculation hash => 10^2 * 67(C) + 10^1 * 68(D) + 10^0 * 68(D)
        for (int i = 0; i < pattern.length(); i++) {
            p = d * p + pattern.charAt(i);
            t = d * t + txt.charAt(i);
        }

        //removing the first value from window in below else case
        for (int i = 0; i < pattern.length() - 1; i++) {
            h = h * d;
        }

        for (int i = 0; i < txt.length() - pattern.length(); i++) {
            if (p == t) {
                int count = 0;
                for (int j = 0; j < pattern.length(); j++) {
                    if (txt.charAt(j + i) == pattern.charAt(j)) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == pattern.length()) {
                    System.out.println("Match fount at:" + i);
                }
            } else {
                t = d * (t - (h * txt.charAt(i))) + txt.charAt(i + pattern.length());
            }
        }

    }
}
