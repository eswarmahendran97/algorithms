package com.standalone.restapi.algorithms.kmp;

public class SimpleKMP {

    public static void main(String[] args) {
        String txt = "ABCABCABD";
        String pattern = "ABCABD";

        int[] lps = new int[pattern.length()];
        computeCounter(lps, pattern);

        int i = 0, j = 0;
        while (txt.length() - i >= pattern.length() - j) {
            if (txt.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                System.out.println("Match found at index:" + (i - j - 1));
                j = lps[j - 1];
            } else if (i < txt.length() && txt.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }
        }
    }

    static void computeCounter(int[] lps, String pattern) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
    }

}
