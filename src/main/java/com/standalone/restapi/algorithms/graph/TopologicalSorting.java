package com.standalone.restapi.algorithms.graph;

import java.util.*;

public class TopologicalSorting {
    
    static Map<Integer, List<Integer>> adjList = new HashMap<>();
    static Stack<Integer> output = new Stack<>();
    
    void addEdge(Integer source, Integer destination){
        if(adjList.containsKey(source)){
            adjList.get(source).add(destination);
        } else {
            var list = new ArrayList<Integer>();
            list.add(destination);
            adjList.put(source, list);
        }
    }
    
    public static void main(String[] args){
        var sort = new TopologicalSorting();
        sort.addEdge(5, 2);
        sort.addEdge(5, 0);
        sort.addEdge(4, 0);
        sort.addEdge(4, 1);
        sort.addEdge(2, 3);
        sort.addEdge(3, 1);
        sort.findTopologicalSorting();
        while(!output.isEmpty()){
            System.out.println(output.pop());
        }
    }

    private void findTopologicalSorting() {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<=5; i++){
            findTopology(i);
        }
    }

    private void findTopology(int i) {
        if(output.contains(i))
            return;
        
        if(adjList.containsKey(i)){
            for(int j=0; j<adjList.get(i).size(); j++){
                findTopology(adjList.get(i).get(j));
            }
        }
        output.add(i);
    }


}
