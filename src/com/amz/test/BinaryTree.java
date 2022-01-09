package com.amz.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 * */
public class BinaryTree {
    TreeNode root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);



        String serialized = tree.serialize(tree.root);
        System.out.println("Serialized view of the tree:");
        System.out.println(serialized);
        System.out.println();

        // Let us deserialize the stored tree into root1
        TreeNode t = tree.deserialize(serialized);
        System.out.println(
                "Inorder Traversal of the tree constructed from serialized String:");
        inorder(t);

    }

    static void inorder(TreeNode root)
    {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public String serialize(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        List<String> result = new ArrayList<>();

        while(!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t == null) {
                result.add("#");
            } else {
                result.add("" +t.val);
                stack.push(t.right);
                stack.push(t.left);
            }
        }
        return String.join(",", result);
    }

    static int t;
    public TreeNode deserialize(String s) {
        if (s== null) {
            return null;
        }
        String[] arr = s.split(",");
        t= 0;
        return helper(arr);
    }

    public static TreeNode helper(String[] arr) {
        if (arr[t].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[t]));
        ++t;
        root.left = helper(arr);
        ++t;
        root.right = helper(arr);
        return root;
    }
}
