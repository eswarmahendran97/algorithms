package com.standalone.restapi.algorithms.graph;

public class Islands {

    public static void main(String[] args) {
//        int[][] grid = {
//                {1, 1, 1, 1, 0},
//                {1, 1, 0, 1, 0},
//                {1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0}
//        };

        char[][] grid = {
                {'0', '1'},
                {'1', '0'},
                {'1', '1'},
                {'1', '0'}
        };

        Islands i = new Islands();
        System.out.println(i.numIslands(grid));

    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        char[][] visited = new char[m][n];
        int island = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = '0';
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0' && visited[i][j] == '0') {
                    island++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return island;
    }

    public void dfs(char[][] grid, char[][] visited, int row, int column) {
        if (row < 0 || row > grid.length - 1 || column < 0 || column > grid[0].length - 1 || visited[row][column] != '0' || grid[row][column] == '0') {
            return;
        } else {
            visited[row][column] = '1';
        }
        dfs(grid, visited, row - 1, column);
        dfs(grid, visited, row + 1, column);
        dfs(grid, visited, row, column - 1);
        dfs(grid, visited, row, column + 1);
        dfs(grid, visited, row + 1, column - 1);
        dfs(grid, visited, row + 1, column + 1);
        dfs(grid, visited, row - 1, column + 1);
        dfs(grid, visited, row - 1, column - 1);
        return;
    }
}
