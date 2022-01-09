package com.amz;

import java.util.ArrayList;
import java.util.List;

public class InOrderTreeTraversal {
    // Function to return a list containing the inorder traversal of the tree.
    List<Integer> result = new ArrayList<>();

    void inOrder(Node root) {
        if (root== null){
            return;
        }
        inOrder(root.left);
        result.add(root.data);
        inOrder(root.right);
    }

    public static void main(String[] args) {

        Node left = new Node(30);
        Node right = new Node(40);
        Node root = new Node(35, left, right);
        InOrderTreeTraversal in = new InOrderTreeTraversal();
        in.inOrder(root);
        System.out.println(in.result);
    }
}