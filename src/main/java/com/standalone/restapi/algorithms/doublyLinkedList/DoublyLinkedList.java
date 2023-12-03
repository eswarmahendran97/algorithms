package com.standalone.restapi.algorithms.doublyLinkedList;

public class DoublyLinkedList<E> {

    static class Node<E> {
        Node prev;
        Node next;
        E data;

        Node(E data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = null;
    Node lastCopy = null;

    public void add(E data) {
        Node temp = new Node(data);
        if (head == null) {
            head = lastCopy = temp;
        } else {
            lastCopy.next = temp;
            temp.prev = lastCopy;
            lastCopy = temp;
        }
    }

    public void add(int pos, E data) {
        Node temp = new Node(data);
        Node current = head;
        int currPosition = 0;

        while (currPosition < pos) {
            current = current.next;
            currPosition++;
        }
        if (current != null) {
            temp.next = current;
            temp.prev = current.prev;
            current.prev.next = temp;
            current.prev = temp;
        }
    }

    public void delete(int position) {
        Node current = head;
        int currPosition = 0;
        while (currPosition < position) {
            current = current.next;
            currPosition++;
        }
        if (current != null) {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.prev = current.next = null;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(3, 10);
        list.delete(4);
        list.display();
    }
}