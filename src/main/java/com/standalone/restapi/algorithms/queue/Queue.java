package com.standalone.restapi.algorithms.queue;

public class Queue {

    int[] array;
    int maxSize;
    int index = 0, firstIndex = 0, currentSize = 0;

    public Queue(int size) {
        array = new int[size];
        maxSize = size;
    }

    private void add(int data) {
        if (currentSize == maxSize) {
            System.out.println("Max size reached");
            return;
        }
        if (index == maxSize) {
            index = 0;
        }
        array[index++] = data;
        currentSize++;
    }

    private int remove() {
        if (currentSize == 0) {
            System.out.println("No element available");
        }
        if (firstIndex == maxSize) {
            firstIndex = 0;
        }
        int temp = array[firstIndex];
        array[firstIndex] = 0;
        firstIndex++;
        currentSize--;
        return temp;
    }

    private int peek() {
        return array[firstIndex];
    }

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        queue.add(4);
        System.out.println(queue.peek());
    }
}
