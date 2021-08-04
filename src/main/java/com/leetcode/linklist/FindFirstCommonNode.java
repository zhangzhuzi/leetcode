package com.leetcode.linklist;

import com.leetcode.entity.ListNode;

/**
 * @description: FindFirstCommonNode
 * @date: 2021/8/4 14:42
 * @author: zsz
 * <p>
 * 两个链表的第一个公共结点
 * <p>
 * a+b+c=b+c+a
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            // 链表走到头从另外一个链表重新开始，两个链表的相交处即为第一个公共节点
            l1 = l1 == null ? pHead2 : l1.next;
            l2 = l2 == null ? pHead1 : l2.next;
        }
        return l1;
    }
}
