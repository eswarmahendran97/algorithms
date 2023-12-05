package com.standalone.restapi.algorithms.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    static class Stack<E> {
        int maxSize;
        Queue<E> q1 = new LinkedList<>();
        Queue<E> q2 = new LinkedList<>();

        public Stack(int size) {
            this.maxSize = size;
        }

        public void push(E data) {
            if (q1.size() == maxSize) {
                System.out.println("Already achieved max stack size, Cannot push:" + data);
                return;
            }
            q2.add(data);
            while (!q1.isEmpty()) {
                q2.add(q1.poll());
            }
            Queue<E> q = q1;
            q1 = q2;
            q2 = q;
        }

        public void pop() {
            if (q1.size() == 0) {
                System.out.println("No element to remove");
                return;
            }
            q1.remove();
        }

        public E top() {
            if (q1.size() == 0) {
                System.out.println("No element present");
                return null;
            }
            return q1.peek();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(3);
        System.out.println(stack.top());
        stack.pop();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.top());
        stack.pop();
        stack.push(4);
        System.out.println(stack.top());
    }
}