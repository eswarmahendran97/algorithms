package com.standalone.restapi.algorithms.slidingWindow;

public class MinSubArraySum {

    private static int findLengthOfSmallestSubarray(int[] a, int K) {
        int n = a.length;

        int lengthOfSmallestSubarray = Integer.MAX_VALUE;
        int windowSum = 0;

        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum += a[windowEnd]; // Add the next element to the window

            while(windowSum >= K) { // Shrink the window as small as possible until the 'windowSum' is smaller than 'K'
                lengthOfSmallestSubarray = Math.min(lengthOfSmallestSubarray, windowEnd-windowStart+1);
                windowSum -= a[windowStart]; // Discard the element at 'windowStart' since it is going out of the window
                windowStart++; // Shrink the window
            }
        }

        return lengthOfSmallestSubarray == Integer.MAX_VALUE ? 0 : lengthOfSmallestSubarray;
    }

    public static void main(String[] args) {
        int arr[] = {6,5,3,5,7,3,5,2,4};
        int k = 15;
        System.out.println(findLengthOfSmallestSubarray(arr, k));
    }
}
