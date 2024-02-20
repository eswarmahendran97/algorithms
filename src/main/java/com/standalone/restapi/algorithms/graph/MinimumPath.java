package com.design.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumPath {

    record Board(int xPos, int yPos, int moveCount) {
    }


    int findLeastMoveForTarget(int[] curPos, int[] tarPos, int tableSize) {
        //Initial false
        int curX = curPos[0];
        int curY = curPos[1];
        int tarX = tarPos[0];
        int tarY = tarPos[1];
        boolean[][] visited = new boolean[tableSize][tableSize];

        int[] possibleX = {-2, -1, -2, -1, 2, 1, 1, 2};
        int[] possibleY = {-1, -2, 1, 2, -1, -2, 2, 1};

        //current pos
        visited[curX][curY] = true;

        Queue<Board> queue = new LinkedList();
        queue.add(new Board(curX, curY, 0));

        while (!queue.isEmpty()) {
            Board pos = queue.poll();
            if (pos.xPos() == tarX && pos.yPos == tarY) {
                return pos.moveCount();
            }
            for (int i = 0; i < 8; i++) {
                int x = pos.xPos() + possibleX[i];
                int y = pos.yPos() + possibleY[i];
                if (isInside(x, y) && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Board(x, y, pos.moveCount() + 1));
                }
            }
        }
        return -1;
    }

    boolean isInside(int x, int y) {
        return x >= 0 && y >= 0 && x <= 30 && y <= 30;
    }

    public static void main(String[] args) {
        int tableSize = 31;
        int[] curPos = {1, 1};
        int[] tarPos = {30, 30};
        MinimumPath gfg = new MinimumPath();
        System.out.println(gfg.findLeastMoveForTarget(curPos, tarPos, tableSize));

    }
}
