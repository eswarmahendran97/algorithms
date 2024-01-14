package com.standalone.restapi.algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class Dijkstra {

    static List<Point> adjList = new ArrayList<>();

    record Point(int point, Connection connection) {
    }

    record Connection(int point, int distance) {
    }

    private static void trackShortestDistance(int[][] adjGraph, String[] place) {
        getAdjList(adjGraph);
        int[] distance = new int[place.length];
        IntStream.range(0, distance.length).forEach(e -> distance[e] = Integer.MAX_VALUE);
        distance[0] = 0;

        Queue<Point> queue = new LinkedList<>();
        adjList.stream().filter(e -> e.point() == 0).forEach(queue::add);

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            Connection c = p.connection();
            int dis = distance[p.point()] + c.distance();
            if (distance[c.point()] > dis) {
                distance[c.point()] = dis;
                //it may add already found values but it will be filtered in if condition, if this is outside then it will be infinite
                adjList.stream().filter(e -> e.point() == c.point() && e.connection().point() != p.point()).forEach(queue::add);
            }
        }

        IntStream.range(1, distance.length).forEach(e -> System.out.printf("Shortest Distance between %s and %s is %d%n", place[0], place[e], distance[e]));

    }

    private static void getAdjList(int[][] adjGraph) {
        for (int i = 0; i < adjGraph.length; i++) {
            for (int j = 0; j < adjGraph.length; j++) {
                if (adjGraph[i][j] != 0) {
                    adjList.add(new Point(i, new Connection(j, adjGraph[i][j])));
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] adjGraph = new int[][]{
                {0, 5, 1, 2, 0, 0, 0},
                {5, 0, 2, 0, 0, 3, 0},
                {1, 2, 0, 1, 3, 0, 0},
                {2, 0, 1, 0, 2, 0, 8},
                {0, 0, 3, 2, 0, 2, 0},
                {0, 3, 0, 0, 2, 0, 1},
                {0, 0, 0, 8, 0, 1, 0}
        };
        String[] place = {"a", "b", "c", "d", "e", "f", "g"};
        trackShortestDistance(adjGraph, place);
    }
}
