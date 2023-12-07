package com.standalone.restapi.algorithms.slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxOfAllSubArray {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 7, 9, 5, 1, 6, 4, 3 };
        int k = 3;

        findMax(arr, k);
    }

    private static void findMax(int[] arr, int k) {

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for (int i = k; i < arr.length; i++) {
            System.out.println(arr[deque.peekFirst()]);
            while(!deque.isEmpty() && deque.getFirst() == i-k){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }

    }
}
