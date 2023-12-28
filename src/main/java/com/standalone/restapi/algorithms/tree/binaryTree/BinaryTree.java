package com.standalone.restapi.algorithms.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
//                           7
//
//                 5                  10
//
//           3           6      9
//
//      1         4
//
//          2

    private void add(Node node, int data) {
        if (node.data > data) {
            if (node.left == null) {
                node.left = new Node(data);
            } else {
                add(node.left, data);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(data);
            } else {
                add(node.right, data);
            }
        }
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    private void levelOrder(Node node) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(node);
        while (!nodes.isEmpty()) {
            Node n = nodes.remove();
            System.out.println(n.data);
            if (n.left != null) {
                nodes.add(n.left);
            }
            if (n.right != null) {
                nodes.add(n.right);
            }
        }
    }

    private boolean contains(Node node, int data) {
        if (node != null) {
            if (node.data == data) {
                return true;
            } else if (node.data > data) {
                return contains(node.left, data);
            } else {
                return contains(node.right, data);
            }
        } else {
            return false;
        }
    }

    // Function to delete given element
// in binary tree
    static void delete(Node root, int key) {

        Node dataNode = getNode(root, key);

        if (dataNode.left == null) {
            replaceNode(root, dataNode.right, key);
        } else if (dataNode.right == null) {
            replaceNode(root, dataNode.left, key);
        } else {
            Node temp = getSuccessor(dataNode);
            replaceNodeWithChildren(root, temp, key);
        }
    }

    public static Node getNode(Node node, int data) {
        if (node.data > data) {
            return getNode(node.left, data);
        } else if (node.data < data) {
            return getNode(node.right, data);
        } else {
            return node;
        }
    }

    public static Node getSuccessor(Node node) {
        Node temp = node.left;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    public static void replaceNode(Node root, Node temp, int key) {

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
            if (node.right != null && node.right.data == key) {
                node.right = temp;
                nodes.clear();
            }
            if (node.left != null && node.left.data == key) {
                node.left = temp;
                nodes.clear();
            }
        }
    }

    public static void replaceNodeWithChildren(Node root, Node temp, int key) {

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            if (node.data == key) {
                node.data = temp.data;
            }
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
            if (node.right != null && node.right.data == temp.data) {
                node.right = null;
                nodes.clear();
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = new Node(7);
        tree.add(root, 5);
        tree.add(root, 3);
        tree.add(root, 10);
//        tree.add(root, 6);
        tree.add(root, 4);
        tree.add(root, 9);
        tree.add(root, 1);
        tree.add(root, 2);

//                               7
//
//                   5                        10
//
//            3                         9
//
//      1           4
//
//          2

        System.out.println(tree.contains(root, 11));

        tree.delete(root, 5);

        tree.preOrder(root);
        System.out.println("---------------");
        tree.inOrder(root);
        System.out.println("---------------");
        tree.postOrder(root);
        System.out.println("---------------");
        tree.levelOrder(root);
    }
}