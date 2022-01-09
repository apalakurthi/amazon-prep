package com.amz.test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * */


public class ConvertSortedListToBinaryTree {
    public static void main(String[] args) {
        /*input setup*/
        Node node = new Node(0);
        Node curr = node;
        int[] arr = new int[]{-10, -3, 0, 5, 9};
        for (int i = 0; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            curr.next = newNode;
            curr= curr.next;
        }

        ConvertSortedListToBinaryTree tree = new ConvertSortedListToBinaryTree();
        tree.sortedListToBST(node.next);

    }

    public TreeNode sortedListToBST(Node head) {
        if(head == null)
            return null;

        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        return constructFromInOrder(list, 0, list.size()-1);
    }

    public static TreeNode constructFromInOrder(List<Integer> in, int si, int ei) {
        if (si > ei)
            return null;

        int mid = (si + ei) / 2;
        TreeNode node = new TreeNode(in.get(mid));

        node.left = constructFromInOrder(in, si, mid - 1);
        node.right = constructFromInOrder(in, mid + 1, ei);

        return node;
    }
}
