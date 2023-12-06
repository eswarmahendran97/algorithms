package com.standalone.restapi.algorithms.stack;

public class Stack {

    int[] array;
    int index = -1;
    int maxSize;

    public Stack(int size) {
        array = new int[size];
        maxSize = size;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.display();
    }

    private void display() {
        for (int i = index; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }

    private void pop() {
        if (index < 0) {
            System.out.println("No elements present");
        }
        array[index--] = 0;
    }

    private int peek() {
        return array[index];
    }

    private void push(int data) {
        if (index == maxSize - 1) {
            System.out.println("Over flow");
            return;
        }
        array[++index] = data;
    }
}