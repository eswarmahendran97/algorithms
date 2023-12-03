package com.standalone.restapi.algorithms.doublyLinkedList;

public class DoublyLinkedList {

    static class Node {
        Node prev;
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = null;
    Node lastCopy = null;

    public void add(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = lastCopy = n;
        } else {
            lastCopy.next = n;
            n.prev = lastCopy;
            lastCopy = n;
        }
    }

    public void display() {
        Node n = head;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    public void add(int pos, int data) {
        Node n = new Node(data);
        int currentPos = 0;
        Node current = head;

        while (currentPos != pos) {
            current = current.next;
            currentPos++;
        }
        if (current != null) {
            n.next = current;
            n.prev = current.prev;
            current.prev = n;
            current.prev.next = n;
        }
    }


    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(3, 10);
        list.display();
    }

}
