package com.standalone.restapi.algorithms.graph;

public class ClosedIsland {

    int closedIsland = 0;

    private void findClosedIslands(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                checkIsland(i, j, grid, 1);
                checkIsland(i, j, grid, 0);
            }
        }
        System.out.println("Number of closed Island : " + closedIsland);
    }

    private void checkIsland(int row, int column, int[][] grid, int type) {
        if (row == 0 || column == 0 || row == grid.length - 1 || column == grid[0].length - 1) {
            return;
        }
        if (grid[row][column] == type
                && grid[row - 1][column] != type
                && grid[row + 1][column] != type
                && grid[row][column - 1] != type
                && grid[row][column + 1] != type) {
            closedIsland++;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 1, 0, 0, 1},
                {0, 0, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0}};
        ClosedIsland c = new ClosedIsland();
        c.findClosedIslands(grid);
    }
}
