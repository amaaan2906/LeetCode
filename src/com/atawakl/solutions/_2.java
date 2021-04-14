package com.atawakl.solutions;

import com.atawakl.common.ListNode;

public class _2 {
    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0; // carry flag
            ListNode tempNode = new ListNode();
            ListNode result = tempNode;
            while (l1 != null || l2 != null) {
                // get value of node if it exists
                int v1 = l1!=null ? l1.val : 0;
                int v2 = l2!=null ? l2.val : 0;
                // sum for current nodes with carry
                int tempSum = v1 + v2 + carry;
                carry = tempSum / 10; // find carry if sum < 10
                tempNode.next = new ListNode(tempSum % 10);
                tempNode = tempNode.next;
                // increment if next node exists
                if(l1!=null) l1 = l1.next;
                if(l2!=null) l2 = l2.next;

                // if no further addition is possible the carry bit is saved as the next node in result
                if (carry == 1) {
                    tempNode.next = new ListNode(1);
                }
            }
            return result.next;
        }
    }
}
