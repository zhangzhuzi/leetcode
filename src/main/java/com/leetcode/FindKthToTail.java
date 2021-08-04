package com.leetcode;

import com.leetcode.entity.ListNode;

/**
 * @Author: ZhangShiZhu
 * @Description:
 * @Date: create in 2021/8/3 21:29
 */
public class FindKthToTail {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        while (p1 != null && k-- > 0) {
            p1 = p1.next;
        }
        if (k > 0) {
            return null;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
