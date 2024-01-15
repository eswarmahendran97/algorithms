package com.standalone.restapi.algorithms.graph;

import java.util.*;

public class ConnectedComponents {

    HashMap<Integer, List<Integer>> nodes = new HashMap<>();

    void addConnection(int source, int destination) {
        if (nodes.containsKey(source)) {
            nodes.get(source).add(destination);
        } else {
            nodes.put(source, Arrays.asList(destination));
        }
    }

    private void populateAll(int totalNodes) {
        int[] visited = new int[totalNodes];
        Queue<Integer> queue = new LinkedList();

        visited[0] = 1;
        queue.add(0);

        while (!queue.isEmpty()) {

            var obj = queue.poll();
            System.out.println(obj + " ");

            if (nodes.containsKey(obj)) {
                nodes.get(obj).forEach(e -> {
                    if (visited[e] == 0) {
                        visited[e] = 1;
                        queue.add(e);
                    }
                });
            }

            if (queue.isEmpty()) {
                for (int i = 0; i < visited.length; i++) {
                    if (visited[i] == 0) {
                        visited[i] = 1;
                        queue.add(i);
                        System.out.println("-----------------------");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ConnectedComponents com = new ConnectedComponents();
        com.addConnection(0, 1);
        com.addConnection(1, 2);
        com.addConnection(2, 3);
        com.addConnection(3, 0);
        com.addConnection(4, 5);
        com.addConnection(5, 6);
        com.addConnection(6, 4);
        com.addConnection(7, 8);
        com.populateAll(9);
    }

}
