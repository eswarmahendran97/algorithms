package com.standalone.restapi.algorithms.graph;

import java.util.*;
import java.util.stream.Stream;

public class WordLadder {
    public static void main(String[] args){
        Set<String> D = new HashSet<String>();
        D.add("poon");
        D.add("plee");
        D.add("same");
        D.add("poie");
        D.add("plie");
        D.add("poin");
        D.add("plea");
        String start = "toon";
        String target = "plea";
        System.out.print("Length of shortest chain is: "
                         + shortestChainLen(start, target, D));
    }

    private static String shortestChainLen(String start, String target, Set<String> set) {
        
        if(!set.contains(target)){
            return "invalid";
        }
        
        if(start == target){
            return "0";
        }
        
        int count = 0;
        boolean check = true;
        while(check){
            for(String s: set){
                if(start.equals(target)){
                    check = false;
                    break;
                }
                if(check(start, s)){
                    count++;
                    set.remove(s);
                    start = s;
                    break;
                }
            }
        }
        return String.valueOf(count);
    }

    private static boolean check(String start, String target) {
        if(start.length() != target.length() || start.equals(target)){
            return false;
        }
        int count = 0;
        int min = start.length();
        Map<String, Integer> map = new HashMap<>();
        
        String[] targetArray = target.split("");
        Stream.of(start.split("")).forEach(e ->{
            if(map.containsKey(e)){
                int num = map.get(e)+1;
                map.put(e, num);
            } else {
                map.put(e, 1);
            }
        });
        for (String s : targetArray) {
            if (map.containsKey(s)) {
                count++;
                if (map.get(s) == 1) {
                    map.remove(s);
                } else {
                    int num = map.get(s);
                    map.put(s, --num);
                }
            }
        }
        return count == min-1;
    }
}
