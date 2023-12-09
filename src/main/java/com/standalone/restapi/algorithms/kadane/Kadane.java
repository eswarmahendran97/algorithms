package com.standalone.restapi.algorithms.kadane;

class Kadane {

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, -4, -5, 1, 5, 6};

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum > max) {
                max = sum;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        System.out.printf("Index start : %d to end index : %d", start, end);
    }
}
