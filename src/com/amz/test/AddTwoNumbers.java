package com.amz.test;
/**
 * https://leetcode.com/problems/add-two-numbers/
 * */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class AddTwoNumbers {
    public Node addTwoNumbers(Node l1, Node l2) {
        int carry =0;
        Node result = new Node(0);
        Node pointer = result;

        while(l1 != null || l2 != null || carry !=0) {
            int total =0;
            if (l1 != null) {
                carry+= l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                carry += l2.val;
                l2= l2.next;
            }

            Node node = new Node(carry%10);
            carry = carry/10;
            pointer.next = node;
            pointer = pointer.next;


        }
        return result.next;
    }
}