package com.standalone.restapi.algorithms.queue;

class Deque {

    int[] array;
    int frontIndex = 0;
    int rear = 0;
    int currentSize = 0;

    public Deque(int size) {
        array = new int[size];
    }

    private void addFront(int data) {
        if (currentSize == array.length) {
            System.out.println("Deque is full");
            return;
        }
        if (currentSize == 0) {
            frontIndex = 0;
            rear = 0;
        }
        if (frontIndex == 0) {
            frontIndex = array.length;
        }
        array[--frontIndex] = data;
        currentSize++;
    }

    private void addLast(int data) {
        if (currentSize == array.length) {
            System.out.println("Deque is full");
            return;
        }
        if (currentSize == 0) {
            frontIndex = 0;
            rear = 0;
        }
        if (rear == array.length) {
            rear = 0;
        }
        array[rear++] = data;
        currentSize++;
    }

    private void removeFront() {
        if (currentSize == 0) {
            System.out.println("No elements to remove");
            return;
        }
        array[frontIndex] = 0;
        frontIndex = (frontIndex == array.length - 1) ? 0 : frontIndex + 1;
        currentSize--;
    }

    private void removeLast() {
        if (currentSize == 0) {
            System.out.println("No elements to remove");
            return;
        }
        array[--rear] = 0;
        rear = (rear == 0) ? array.length : rear;
        currentSize--;
    }

    private int getLast() {
        int index = rear - 1;
        return array[index];
    }

    private int getFirst() {
        return array[frontIndex];
    }

    public static void main(String[] args) {
        Deque deque = new Deque(5);
        deque.addFront(2);
        deque.addLast(3);
        deque.addFront(1);
        deque.addLast(4);
        deque.removeLast();
        deque.addLast(5);
        deque.removeFront();
        deque.addLast(10);
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        deque.removeFront();
        deque.removeLast();
        deque.removeFront();
        deque.removeLast();
        deque.addFront(2);
        deque.addLast(3);
        deque.addFront(1);
        deque.addLast(4);
        deque.removeLast();
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        deque.addLast(5);
        deque.removeFront();
        deque.addLast(10);
        deque.removeFront();
        deque.removeLast();
        deque.removeFront();
        deque.removeLast();
    }
}