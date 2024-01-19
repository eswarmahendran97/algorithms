package com.standalone.restapi.algorithms.graph;

import java.util.ArrayList;
import java.util.*;

public class BipotiteGraph {

    Map<Integer, List<Integer>> adjList = new HashMap<>();

    private void findAdjList(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (!adjList.containsKey(i)) {
                        var list = new ArrayList<Integer>();
                        list.add(j);
                        adjList.put(i, list);
                    } else {
                        adjList.get(i).add(j);
                    }
                }
            }
        }
    }

    public void checkBipotiteGraph(int color) {
        int[] colors = new int[adjList.size()];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        colors[0] = color;
        boolean isValid = true;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            var list = adjList.get(node);
            for (Integer adjNode : list) {
                if (colors[adjNode] == 0) {
                    colors[adjNode] = -colors[node];
                    queue.add(adjNode);
                } else if (colors[adjNode] == colors[node]) {
                    queue.clear();
                    isValid = false;
                }
            }
        }

        if (isValid) {
            System.out.println("Valid bipotite graph");
        } else {
            System.out.println("Invalid bipotite graph");
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        BipotiteGraph graph = new BipotiteGraph();
        graph.findAdjList(grid);
        graph.checkBipotiteGraph(1);
    }
}
