package com.standalone.restapi.algorithms.graph;

import java.util.*;
import java.util.stream.*;

public class BellmanFord {

    static List<Point> adjList = new ArrayList<>();

    record Point(int point, Connection connection) {
    }

    record Connection(int point, int distance) {
    }

    private static void trackShortestDistance(int[][] adjGraph, String[] places) {
        getAdjList(adjGraph);
        int[] distance = new int[places.length];
        IntStream.range(1, distance.length).forEach(e -> distance[e] = Integer.MAX_VALUE);

        // relaxation n-1 times
        IntStream.range(1, distance.length).forEach(i -> {
            adjList.forEach(p -> {
                int dis = distance[p.point()] + p.connection().distance();
                if (distance[p.connection().point()] > dis) {
                    distance[p.connection().point()] = dis;
                }
            });
        });

        IntStream.range(1, distance.length).forEach(e -> System.out.printf("Shortest distance from %s to %s is %d%n", places[0], places[e], distance[e]));
    }

    private static void getAdjList(int[][] adjGraph) {

        for (int i = 0; i < adjGraph.length; i++) {
            for (int j = i; j < adjGraph.length; j++) {
                if (adjGraph[i][j] != 0) {
                    adjList.add(new Point(i, new Connection(j, adjGraph[i][j])));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] adjGraph = new int[][]{{0, -5, 1, 2, 0, 0, 0}, {-5, 0, 2, 0, 0, 3, 0}, {1, 2, 0, 1, 3, 0, 0}, {2, 0, 1, 0, 2, 0, 8}, {0, 0, 3, 2, 0, 2, 0}, {0, 3, 0, 0, 2, 0, 1}, {0, 0, 0, 8, 0, 1, 0}};
        String[] places = {"a", "b", "c", "d", "e", "f", "g"};
        trackShortestDistance(adjGraph, places);
    }
}
