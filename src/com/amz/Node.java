package com.amz;

public class Node {
    int data;
    Node left, right;
    public Node(int item)    {
        data = item;
        left = right = null;
    }
    public Node(int item, Node left, Node right) {
        data = item;
        this.left = left;
        this.right = right;
    }
}
