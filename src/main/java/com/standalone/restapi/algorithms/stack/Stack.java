package com.standalone.restapi.algorithms.stack;

public class Stack {

    int[] array;
    int index = -1;

    public Stack(int i) {
        array = new int[i];
    }

    private void push(int data) {
        if (index > array.length) {
            System.out.println("over flow");
        } else {
            array[++index] = data;
        }
    }

    private void pop() {
        array[index--] = 0;
    }

    private int top() {
        return array[index];
    }

    private void display() {
        for (int i = index; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        stack.push(6);
        stack.display();
    }
}