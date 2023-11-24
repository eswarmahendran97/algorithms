package com.standalone.restapi.algorithms.twoPointer;

public class simpleTwoPointer {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 8, 9, 11, 15 };
        int val = 14;
        findVal(arr, val);
    }

    private static void findVal(int[] arr, int val) {
        int i=0;
        int j= arr.length-1;
        while(j>i) {
            // adding two pointers amd checking
            if (arr[i] + arr[j] == val) {
                System.out.println("Match found ("+arr[i]+","+arr[j]+")");
                break;
            }
            else if (arr[i] + arr[j] < val) {
                i++;
            }
            else{
                j--;
            }
        }

    }
}
