package com.standalone.restapi.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class CovidSpread {
    record Room(int x, int y, int ite){}
    
    static void findSpread(int[][] input){
        Queue<Room> queue = new LinkedList<>();
        int[][] visited = new int[input.length][input[0].length];
        for(int i=0;i< input.length;i++){
            for(int j=0; j< input[0].length; j++){
                if(input[i][j]==2){
                    queue.add(new Room(i,j,0));
                }
            }
        }
        int iteration = 0;

        while(!queue.isEmpty()){
            Room room = queue.poll();
            if(check(room.x()+1, room.y(), input, visited)){
                queue.add(new Room(room.x()+1, room.y(), room.ite()+1));
                visited[room.x()+1][room.y()] = 1;
            }
            if(check(room.x(), room.y()+1, input, visited)){
                queue.add(new Room(room.x(), room.y()+1, room.ite()+1));
                visited[room.x()][room.y()+1] = 1;
            }
            if(check(room.x()-1, room.y(), input, visited)){
                queue.add(new Room(room.x()-1, room.y(), room.ite()+1));
                visited[room.x()-1][room.y()] = 1;
            }
            if(check(room.x(), room.y()-1, input, visited)){
                queue.add(new Room(room.x(), room.y()-1, room.ite()+1));
                visited[room.x()][room.y()-1] = 1;
            }

            if(queue.isEmpty()){
                iteration = room.ite();
            }
        }
        System.out.println(iteration);
    }

    static boolean check(int x, int y, int[][] input, int[][] visited){
        if(x < 0 || y < 0 || x>= input.length || y >= input[0].length || input[x][y] !=1 || visited[x][y]==1){
            return false;
        }
        return true;
    }
    
    
    public static void main(String[] args) {

        int[][] wards = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 2, 1}
        };

        findSpread(wards);

    }
}
