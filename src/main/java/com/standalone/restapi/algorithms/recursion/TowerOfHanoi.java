package com.standalone.restapi.algorithms.recursion;

public class TowerOfHanoi {

    static void tower(int n, char from_rod,
                      char to_rod, char helper_rod) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from_rod + " to " + to_rod);
            return;
        }
        tower(n - 1, from_rod, helper_rod, to_rod);
        System.out.println("Move disk " + n + " from " + from_rod + " to " + to_rod);
        tower(n - 1, helper_rod, to_rod, from_rod);
    }

    public static void main(String[] args) {
        int N = 4;
        tower(N, 'A', 'B', 'C');
    }
}
