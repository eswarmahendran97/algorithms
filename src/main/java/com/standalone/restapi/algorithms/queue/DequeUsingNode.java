package com.standalone.restapi.algorithms.queue;

public class DequeUsingNode {

    int maxSize;
    int currentSize = 0;

    public DequeUsingNode(int size) {
        maxSize = size;
    }

    static class Node {
        Node prev;
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            prev = next = null;
        }
    }

    Node head = null;
    Node lastCopy = null;


    private void addFront(int data) {
        if (isFull()) {
            System.out.println("Deque is full");
        }
        Node n = new Node(data);
        if (head == null) {
            head = lastCopy = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
        currentSize++;
    }

    private void addLast(int data) {
        if (isFull()) {
            System.out.println("Deque is full");
        }
        Node n = new Node(data);
        if (head == null) {
            head = lastCopy = n;
        } else {
            n.prev = lastCopy;
            lastCopy.next = n;
            lastCopy = n;
        }
        currentSize++;
    }

    private void removeFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
        }
        Node n = head.next;
        n.prev = null;
        head.next = null;
        head = n;
        currentSize--;
    }

    private void removeLast() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
        }
        Node n = lastCopy.prev;
        n.next = null;
        lastCopy.prev = null;
        lastCopy = n;
        currentSize--;
    }

    private boolean isFull() {
        return currentSize == maxSize;
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    private void display() {
        Node n = head;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    public static void main(String[] args) {
        DequeUsingNode deque = new DequeUsingNode(5);
        deque.addFront(2);
        deque.addLast(3);
        deque.addFront(1);
        deque.addLast(4);
        deque.removeLast();
        deque.addLast(5);
        deque.removeFront();
        deque.addLast(10);
        deque.removeFront();
        deque.display();
    }
}
