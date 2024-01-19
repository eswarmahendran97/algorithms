package com.standalone.restapi.algorithms.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DistinctIsland {

    List<String> commonList = new ArrayList<>();

    private void findDistinctIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        var set = new HashSet<String>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    findDistinct(i, j, grid, visited, i, j);
                    set.add(commonList.toString());
                    commonList.clear();
                }
            }
        }
        System.out.println("Total number of distinct islands : " + set.size());
    }

    private void findDistinct(int row, int col, int[][] grid, int[][] visited, int row1, int col1) {
        if (row1 < 0 || row1 > grid.length - 1 || col1 < 0 || col1 > grid[0].length - 1 || grid[row1][col1] == 0 || visited[row1][col1] == 1) {
            return;
        }
        visited[row1][col1] = 1;
        commonList.add((row1 - row) + "," + (col1 - col));
        findDistinct(row, col, grid, visited, row1 + 1, col1);
        findDistinct(row, col, grid, visited, row1 - 1, col1);
        findDistinct(row, col, grid, visited, row1, col1 + 1);
        findDistinct(row, col, grid, visited, row1, col1 - 1);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        DistinctIsland i = new DistinctIsland();
        i.findDistinctIsland(grid);
    }

}
