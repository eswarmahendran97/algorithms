package com.standalone.restapi.algorithms.graph;

import java.util.*;

public class PathExist {

    HashMap<Integer, List<Integer>> place = new HashMap<>();

    void addPlace(int source, int destination) {
        if (place.containsKey(source)) {
            place.get(source).add(destination);
        } else {
            var list = new ArrayList<Integer>();
            list.add(destination);
            place.put(source, list);
        }
    }

    boolean isReachable(int source, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> checkedPlace = new ArrayList();
        queue.add(source);
        while (!queue.isEmpty()) {
            int s = queue.poll();
            checkedPlace.add(s);
            var list = place.get(s);
            for (int li : list) {
                if (!checkedPlace.contains(li)) {
                    queue.add(li);
                }
            }
            if (checkedPlace.contains(destination)) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        PathExist path = new PathExist();
        path.addPlace(0, 1);
        path.addPlace(0, 2);
        path.addPlace(1, 2);
        path.addPlace(2, 0);
        path.addPlace(2, 3);
        path.addPlace(3, 3);

        System.out.println(path.isReachable(1, 3));
    }
}
