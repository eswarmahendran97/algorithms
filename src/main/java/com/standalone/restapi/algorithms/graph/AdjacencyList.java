package com.standalone.restapi.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList {

    static Map<Integer, List<Integer>> map = new HashMap<>();
    static void addVertex(int i) {
        map.put(i, new ArrayList<Integer>());
    }

    static void addGraph(int... edge) {
        if (!map.containsKey(edge[0])) {
            addVertex(edge[0]);
        }
        map.get(edge[0]).add(edge[1]);
    }

    static void print() {
        map.forEach((k, v) -> {
            System.out.println(k + "->" + v);
        });
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {2, 3}, {3, 0}};
        for (int[] edge : edges) {
            addGraph(edge);
        }
        print();
    }
}