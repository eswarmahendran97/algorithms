package com.standalone.restapi.algorithms.queue;

import java.util.Stack;

public class QueueUsingStack {

    static class Queue<E> {

        private Stack<E> s1 = new Stack<>();
        private Stack<E> s2 = new Stack<>();
        private int maxSize;

        protected Queue(int size) {
            this.maxSize = size;
        }

        protected void add(E item) {
            if (s2.size() >= maxSize) {
                System.out.println("Reached max queue size, cannot add item:" + item);
                return;
            }
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            s1.push(item);
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        protected void remove() {
            if (s2.size() == 0) {
                System.out.println("No elements present");
                return;
            }
            s2.pop();
        }

        protected E poll() {
            if (s2.size() == 0) {
                System.out.println("No elements present");
                return null;
            }
            return s2.pop();
        }

        protected E peek() {
            if (s2.size() == 0) {
                System.out.println("No elements present");
                return null;
            }
            return s2.peek();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(3);
        queue.remove();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        queue.add(4);
        System.out.println(queue.peek());
    }

}
