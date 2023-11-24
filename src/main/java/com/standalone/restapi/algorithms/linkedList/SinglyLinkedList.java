package com.standalone.restapi.algorithms.linkedList;

public class SinglyLinkedList {

    Node headNode = null;
    Node lastCopy = null;

    static class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(Object obj) {
        Node n = new Node(obj);

        if (headNode == null) {
            headNode  = n;
            lastCopy = n;
        } else {
            lastCopy.next = n;
            lastCopy = n;
        }
    }

    public void display() {
        Node n = headNode;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    public void get(int index) {
        Node n = headNode;
        for(int i=0; i<index; i++){
            n = n.next;
        }
        System.out.println(n.data);
    }


    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.get(3);
        list.display();

    }

}
