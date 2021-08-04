package com.leetcode;

import com.leetcode.entity.ListNode;

/**
 * @description: MergeSortedList
 * @date: 2021/8/4 11:04
 * @author: zsz
 * <p>
 * 合并两个排序的链表
 */
public class MergeSortedList {
    //递归
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            return list1.next = Merge(list1.next, list2);
        } else {
            return list2.next = Merge(list1, list2.next);
        }
    }

    //非递归：迭代
    public ListNode Merge2(ListNode list1, ListNode list2) {
        //需要占用额外空间
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        }
        if (list2 == null) {
            cur.next = list1;
        }
        return head.next;
    }
}
