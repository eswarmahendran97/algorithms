package com.standalone.restapi.algorithms.graph;


import java.util.*;

public class MinCost {


    public static void main(String[] args) {
        int[][] cost = {{1, 8, 8, 1, 5},
                        {4, 1, 1, 8, 1},
                        {4, 2, 8, 8, 1},
                        {1, 5, 8, 8, 1}};
        System.out.println(findMinCost(cost, 3, 4));
    }

    record Cell(int x, int y, int cost) {
    }

    private static int findMinCost(int[][] cost, int tarX, int tarY) {

        boolean[][] visited = new boolean[cost.length][cost[0].length];
        int[][] dp = new int[cost.length][cost[0].length];

        int[] possibleX = {-1, -1, 0, -1, 1, 1, 0, 1};
        int[] possibleY = {-1, 0, -1, 1, -1, 0, 1, 1};

        for (int[] i : dp) {
            for (int j = 0; j < i.length; j++) {
                i[j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>((lhs, rhs) -> lhs.cost - rhs.cost);
        pq.add(new Cell(0, 0, cost[0][0]));
        dp[0][0] = 0;

        while (!pq.isEmpty()) {
            Cell c = pq.poll();

            if (visited[c.x][c.y])
                continue;

            visited[c.x][c.y] = true;

            for (int i = 0; i < 8; i++) {
                int pX = c.x + possibleX[i];
                int pY = c.y + possibleY[i];
                if (isSafe(pX, pY,visited) && !visited[pX][pY]) {
                    int pC = c.cost+cost[pX][pY];
                    dp[pX][pY] = Math.min(dp[pX][pY],pC );
                    pq.add(new Cell(pX, pY,pC));
                }
            }
        }

        return dp[tarX][tarY];
    }

    private static boolean isSafe(int possibleX, int possibleY, boolean[][] visited) {
        if(possibleX <0 || possibleY <0 || possibleX >= visited.length || possibleY >=visited[0].length){
            return false;
        }
        return true;
    }
}
