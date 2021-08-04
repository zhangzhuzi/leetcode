package com.leetcode.linklist;

import com.leetcode.entity.ListNode;

/**
 * @description: deleteDuplication
 * @date: 2021/8/3 17:36
 * @author: zsz
 */
public class deleteDuplication {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode result = deleteDuplication(node1);
        System.out.println(result);
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
