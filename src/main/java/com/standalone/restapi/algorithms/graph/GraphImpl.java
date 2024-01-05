package com.standalone.restapi.algorithms.graph;

import java.util.*;

public class GraphImpl {
    Map<String, List<String>> graph = new HashMap<>();

    void addVertex(String vertex) {
        graph.put(vertex, new ArrayList<>());
    }

    void addEdges(String source, String destination) {
        if (!graph.containsKey(source)) {
            graph.put(source, new ArrayList<>());
        }
        if (!graph.containsKey(destination)) {
            graph.put(destination, new ArrayList<>());
        }
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    void getEdgesOfVertex(String vertex) {
        graph.get(vertex).forEach(System.out::println);
    }

    void getAllConnections() {
        graph.forEach((e, k) -> System.out.println(e + ":" + k));
    }

    void dfs(String root) {
        Stack<String> stack = new Stack<>();
        var output = new LinkedHashSet<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String s = stack.pop();
            if (!output.contains(s)) {
                output.add(s);
                graph.get(s).forEach(stack::push);
            }
        }
        System.out.println(output);
    }

    void bfs(String root) {
        Queue<String> queue = new LinkedList<>();
        var output = new LinkedHashSet<String>();
        queue.add(root);
        while (!queue.isEmpty()) {
            String q = queue.poll();
            if (!output.contains(q)) {
                output.add(q);
                graph.get(q).forEach(queue::add);
            }
        }
        System.out.println(output);
    }


    public static void main(String[] args) {
        GraphImpl graphImpl = new GraphImpl();
        graphImpl.addVertex("Eswar");
        graphImpl.addVertex("Maddy");
        graphImpl.addVertex("Santhosh");
        graphImpl.addVertex("Vicky");
        graphImpl.addVertex("Pradeep");

        graphImpl.addEdges("Eswar", "Maddy");
        graphImpl.addEdges("Maddy", "Santhosh");
        graphImpl.addEdges("Santhosh", "Vicky");
        graphImpl.addEdges("Vicky", "Pradeep");
        graphImpl.addEdges("Pradeep", "Eswar");
//        graphImpl.addEdges("Maddy", "Pradeep");
//        graphImpl.addEdges("Maddy", "Vicky");
//        graphImpl.addEdges("Santhosh", "Senthil");

        graphImpl.getEdgesOfVertex("Santhosh");
        graphImpl.getEdgesOfVertex("Pradeep");

        System.out.println("---------------------------");

        graphImpl.getAllConnections();

        System.out.println("---------------------------");

        graphImpl.dfs("Eswar");

        System.out.println("---------------------------");

        graphImpl.bfs("Eswar");
    }

}
