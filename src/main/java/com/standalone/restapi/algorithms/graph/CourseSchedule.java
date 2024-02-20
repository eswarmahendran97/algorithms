package com.design.Graphs;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
//        int[][] prerequisites = {{1, 2},
//                {2, 3},
//                {3, 1}};
        int[][] prerequisites = {{1, 0},
               {2, 0},
               {3, 1},
               {3, 2}};
        for (int[] prerequisite : prerequisites) {
            frameAdjList(prerequisite[0], prerequisite[1]);
        }
        int check = 1;
        for (int[] prerequisite : prerequisites) {
            for (int j = 0; j < prerequisites[0].length; j++) {
                if (isCyclic(prerequisite[j])) {
                    System.out.println("Not a cyclic graph");
                    check = 0;
                    break;
                }
            }
            if(check == 0){
                break;
            }
        }
        System.out.println(check);
//        while (!output.isEmpty()){
//            System.out.println(output.pop());
//        }
    }

    static Stack<Integer> output = new Stack<>();
    static List<Integer> cyclic = new ArrayList<>();

    private static boolean isCyclic(int i) {
        if (output.contains(i)) {
            return false;
        }

        if (adjList.containsKey(i)) {
            if (cyclic.contains(i)) {
                return true;
            }
            cyclic.add(i);
            for (int j = 0; j < adjList.get(i).size(); j++) {
                if (isCyclic(adjList.get(i).get(j))) {
                    return true;
                }
            }
        }
        cyclic.clear();
        output.add(i);
        return false;
    }

    static Map<Integer, List<Integer>> adjList = new HashMap<>();

    private static void frameAdjList(int des, int soc) {
        if (adjList.containsKey(soc)) {
            adjList.get(soc).add(des);
        } else {
            var list = new ArrayList<Integer>();
            list.add(des);
            adjList.put(soc, list);
        }
    }
}
